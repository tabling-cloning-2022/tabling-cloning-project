package project.cloning.tabling.config.auth;

import java.util.Collections;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import project.cloning.tabling.config.auth.dto.OAuthAttributes;
import project.cloning.tabling.config.auth.dto.SessionUser;
import project.cloning.tabling.domain.user.User;
import project.cloning.tabling.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        /**
         * registrationId -> 현재 로그인 진행 중인 서비스를 구분하는 코드
         *                   소셜 로그인 구분 값
         * userNameAttributeName -> OAuth2 로그인 진행 시 키가 되는 필드값 PK
         *                          구글 기본 코드 = sub
         *                          네이버 로그인과 구글 로그인을 동시 지원할 때 사용
         */
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        /**
         * OAuthAttributes -> OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
         *                    이후 네이버 등 다른 소셜 로그인도 이 클래스를 사용
         */
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        /**
         * SessionUser -> 세션에 사용자 정보를 저장하고 위한 Dto
         */
        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    /**
     * 구글 사용자 정보가 업데이트 되었을 때를 대비한 update 기능
     * 사용자 이름, 프로필 사진이 변경되면 User 엔티티에 반영
     * @param attributes
     * @return
     */
    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}