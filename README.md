# 🌟 StarVive_BE – Backend

> 스타벅스 앱 기반 이커머스 플랫폼 백엔드 리빌딩 프로젝트  
> Spring Boot 기반의 RESTful API 서버입니다.

---

## 👨‍💻 백엔드 팀원 소개

| 이름 | 역할 | 담당 기능 |
|------|------|-----------|
| 김보미 | 백엔드 | 상품, 추천 섹션, 장바구니, 배너 이미지 |
| 신효철 | 백엔드 | 로그인, 회원가입, 배송지, 베스트 상품, 상품 찜하기 |
| 최지호 | 백엔드 | 기획전, 카테고리, 트랜드 태그 |

---

## 🔗 프로젝트 링크

- **Backend Repository**: [https://github.com/1-StarVive/StarVive_BE](https://github.com/1-StarVive/StarVive_BE)

---

## 📌 프로젝트 개요

StarVive는 스파로스 아카데미에서 진행된 팀 프로젝트로,  
**스타벅스 앱 온라인 스토어**를 리빌딩하여 **모바일 중심의 이커머스 서비스**를 구현하였습니다.

> 주요 기능: 회원가입, 로그인(JWT), 상품 조회, 카테고리별 조회, 트렌드 태그, 베스트 상품, 찜하기 등

---

## 🚀 기술 스택

### 🔧 Backend
- Spring Boot 3.3.1
- Java 17
- Gradle (Groovy)
- Spring Data JPA
- Spring Security + JWT
- Redis
- Swagger (Springdoc OpenAPI)

### 🛠 Infra
- MySQL 8.0+
- Redis 6.2+
- AWS EC2, S3
- Jenkins + Docker
- Nginx (HTTPS 리버스 프록시)

---

##  1. 레포지토리 클론
```bash
git clone https://github.com/1-StarVive/StarVive_BE.git
cd StarVive_BE
```

---

##  2. JDK 및 Gradle 환경 설정
- JDK: **OpenJDK 17** 이상
- Gradle: 내장 `./gradlew` 사용
- IDE: IntelliJ Ultimate 권장

---

##  3. application.yml 구성
`src/main/resources/application.yml` 생성 후 아래와 같이 설정합니다:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/starvive_database
    username: your_mysql_user
    password: your_mysql_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  redis:
    host: localhost
    port: 6379

jwt:
  secret: your_jwt_secret_key

logging:
  level:
    org.hibernate.SQL: debug
```

> 📌 MySQL 및 Redis 로컬 실행 필요

---

##  4. 의존성 설치 및 빌드
```bash
./gradlew clean build
```

---

- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

##  5. 기본 테스트 계정
- 회원가입: `/api/v1/auth/join`
- 로그인: `/api/v1/auth/login`

```http
Authorization: Bearer <ACCESS_TOKEN>
```

---

## 🧪 Postman 테스트 가능 API
- 회원가입 / 로그인
- 상품조회, 카테고리별 조회, 찜하기

> Postman 가이드: [Notion 링크](https://www.notion.so/Postman-1ca2ca1a3b5d80889e22f2d31021f2dd?pvs=21)

---
