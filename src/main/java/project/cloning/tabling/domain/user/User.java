package project.cloning.tabling.domain.user;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "oauth_provider", nullable = false)
    private String oauthProvider;

    @Column(name = "oauth_token", nullable = false)
    private String oauthToken;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "panalty_count", nullable = false)
    private String panaltyCount;

    @Column(name = "penalty_updated_datetime", nullable = false)
    private LocalDateTime penaltyUpdatedDatetime;

    @Enumerated(EnumType.STRING)
    @Column(name = "authorization", nullable = false)
    public Role role;

//    @Column(name = "picture", nullable = false)
//    private String picture;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        //this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
