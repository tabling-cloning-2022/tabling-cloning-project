# 테이블링 웹

![unnamed](https://user-images.githubusercontent.com/16564373/163896507-a434dc2d-157c-4a37-86cc-84cd6d64b53c.jpg)

## 📌 프로젝트 구조

💻 개발 환경 Java, Spring Boot, JPA, Gradle, MySQL

## 📌 프로젝트 상세

### 프로젝트 목표

- 테이블링 앱 서비스 기능 구현해 내는 것이 목표 입니다.
- 객체 지향적인 올바른 코드 작성
- 클린 코드 작성
- 문서화, 단위 테스트를 높은 우선순위를 두어 작성하여 협업이 쉬운 프로젝트 구현

### 프로젝트 중점사항

- 대기 예상 시간 스케쥴링
- 원격 줄서기 : 동시 입력과 같은 상활별 대처
- 예약하기 기능
- 문서화
- 성능 개선
- 코드 컨벤션
- 성능 최적화

### ⭐ 기능 명세서

- 회원 가입 및 로그인
    - OAuth : 카카오/구글
    - Spring Security
- 음식점 리스트
    - 기본 상세 정보 : 위치/평점/편의시설/매장소개
- 관심등록
- 원격 줄서기
    - KakaoPushService 알림
    - 평균 대기 예상 시간
    - 대기자 수
- 예약하기
- 리뷰
  <br>

### Documents
- [Spec](https://docs.google.com/spreadsheets/d/1u6pIzsWbwesEpiHSxtgDcQqHkcOpiDJtS92MmeiVNKM/edit?usp=sharing)
- [UI Mockup](https://wireframepro.mockflow.com/space/Mswif8N05nb)    
- [UX flow](https://www.figma.com/file/JqvPq5XGrHOOouyajC8dNg/Tabling?node-id=0%3A1)
- [DB ERD](https://www.erdcloud.com/p/rwJXz5LLXrXszaEck)
- [API blueprint](https://tabling.docs.apiary.io/#)

### 📌 DB ERD

## 📌 기술적 issue 해결 과정

## ⛓ Github PR 방식

### ✔ 브랜치 전략

````````
Main : 배포했거나 곧 배포할 코드 관리합니다.
Develop : 배포할 것을 개발하는 코드를 관리합니다. 배포할 시에 Master로 merge 합니다.
Feature : 기능 개발을 진행할 때 사용합니다. 
          기능을 완성할 때까지 유지하고 완성 시 Develop 브랜치로 merge 합니다. 
Release : 배포를 준비하는 브랜치로 배포를 필요한 메타데이터를 준비합니다.
Hotfix : 배포한 버전에서 발생한 버그를 수정하는 브랜치입니다.
````````

### ✔ commit guidelines

````````
FIX - 보통 올바르지 않은 동작을 고친 경우에 사용합니다. 
FEAT - 코드, 예제, 문서 등의 추가가 있을 때 사용합니다
TEST - 테스트 코드 추가
REFACTOR - 전면 수정이 있을 때 사용합니다.
UPDATE - 원래도 정상적으로 동작하고 있었지만, 수정, 추가, 보완을 한다는 개념입니다. 
         코드보다는 주로 문서나 리소스, 라이브러리등에 사용합니다 
DOCS - 문서의 개정이 있을 때 주로 사용합니다.
CORRECT - 주로 문법의 오류나 타입의 변경, 이름 변경 등에 사용합니다. 
MOVE - 코드의 이동이 있을 때 사용합니다. 
RENAME - 이름 변경이 있을 때 사용합니다. 
````````

