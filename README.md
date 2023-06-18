# Quiz-Spring

<h1>java Spring Framework를 이용한 개인 프로젝트입니다.</h1>

![1 index](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/7fe1848f-16f6-4a1d-825f-dd4014edf1f7)

1. dependency: Spring Web, Thymeleaf, Lombok, Spring Boot DevTools, Spring Data JPA, QueryDSL
2. html, css, javascript Library: Bootstrap, Google Font
3. DB: mariaDB

## 상세 구현 내용

<details>
<summary>접기/펼치기</summary>

## 회원가입

![2 signUp](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/a0a13d45-0551-47bc-842a-b8229c9be730)
+ 회원 정보를 기입하여 회원 가입 클릭시 DB에 회원 정보가 들어간다.
  
## 로그인

![3 login](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/83d23a04-f89c-4584-a180-3d966bea257b)
+ 로그인시 아이디가 있는지 DB에서 찾아 비밀번호가 맞는지 확인하여 맞으면 Session으로 관리되어 로그인 된다.
  
## 퀴즈 만들기

![4](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/aea7b5c8-30d4-4ad8-a0e3-4598bb2056b5)
+ 퀴즈 문제를 작성하고 4개의 선택지를 만들고 정답을 체크 해주면 DB에 퀴즈가 만들어진다.

  
## 퀴즈 문제
  
![5](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/19ff4597-3f2d-4522-81eb-e358846128ca)
+ 퀴즈 문제가 나오며 4개의 버튼중에 선택지를 누르면 문제의 정답과 일치하는지 확인한다.
  
## 퀴즈 만들기

![6](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/06b3d455-c7bb-457f-87f8-8cfa7d698ccb)
+ 문제를 맞출경우 View에 보여준다. 
 
## 퀴즈 만들기

![7](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/ebc88659-baac-45b4-bcf9-f2f1b68cbb1c)
+ 문제를 틀릴경우 View에 보여준다. 
  
## Setting
  
![8](https://github.com/selloriwoo/Quiz-Spring/assets/39435633/bf47da5e-94e5-4489-a157-650c38068b93)
+ spring.datasource.driverClassName에는 DB드라이버를 셋팅해준다.
+ spring.datasource.url에는 DB의 주소를 넣어준다.
  ex)jdbc:mariadb://localhost:3306/(DB의 이름)
+ spring.datasource.username에는 DB의 로그인 아이디를 입력해준다.
+ spring.datasource.password에는 DB의 로그인 비밀번호를 입력해준다.

주의)
  + spring.jpa.hibernate.ddl-auto는 상세한 DB의 초기화를 선택할 수 있다.
    create는 SessionFactory가 시작될 때 drop을 실행하고 create해준다.
    update는 변경된 스키마가 있으면 update해준다.
</details>
