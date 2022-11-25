<div align="center">
  
![home](https://user-images.githubusercontent.com/81874493/133004425-2729c7db-f325-4a22-942e-cfe9ad2586ff.gif)


	
# FAQ
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
 <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">



</div>



<br>

## 🎬 어떤 프로젝트 인가요?

 ‘FAQ’는 고객센터 게시판 웹 어플리케이션 입니다.

스프링 프레임워크를 이용하여 사용자는 관리자에게 문의를 하고 문의에 대한 답변을 받을 수 있는 게시판을 구성 하였습니다.



<br>

## 💻 시스템 설계

###  ⃝ 유스케이스 다이어그램

<img width="704" alt="스크린샷 2022-11-25 오후 5 40 36" src="https://user-images.githubusercontent.com/81874493/203937822-95cd5abd-b845-420c-a8dd-4efaec79cc35.png">

<br>

###  ⃝ Session을 통한 로그인 여부 확인 및 미인증 사용자 접근 제한

<img width="640" alt="스크린샷 2022-11-21 오후 5 15 18" src="https://user-images.githubusercontent.com/81874493/202999935-3a180dd1-bc14-43c7-81d0-e8ea457b70e7.png">

* session을 통한 로그인 여부 확인
  - V1 자체적 SessionManager 방식
  - V2 스프링 프레임워크에서 제공하는 Session 방식 

<br>

* 접근 제한 필터링
  - filter를 통한 미인증 사용자 접근 제한 
    - V1 자체적 SessionManager 방식
    - V2 스프링 프레임워크에서 제공하는 Session 방식  
    
  - interceptor를 통한 미인증 사용자 접근 제한 
    - V1 자체적 SessionManager 방식
    - V2 스프링 프레임워크에서 제공하는 Session 방식  


<br>

###  ⃝ Member 클래스 다이어그램

<img width="167" alt="스크린샷 2022-11-21 오후 5 13 22" src="https://user-images.githubusercontent.com/81874493/203006591-d72a1720-2aee-4140-a8c8-687632b2dedc.png">



<br>

###  ⃝ 회원가입, 로그인 Service 클래스 다이어그램

<img width="404" alt="스크린샷 2022-11-21 오후 5 12 20" src="https://user-images.githubusercontent.com/81874493/203006078-0a38750d-6544-4070-918e-99feb2478643.png">

<br>

###  ⃝ 컨트롤러 클래스 다이어그램

<img width="1181" alt="스크린샷 2022-11-21 오후 5 17 15" src="https://user-images.githubusercontent.com/81874493/203005947-b4f567bd-4b7e-414d-a5b4-9fcd2ffc3a73.png">

<br>


## 📺 프로젝트 실행 화면

![testing](https://user-images.githubusercontent.com/81874493/133004784-eba8a44e-706b-4316-9ce5-ea232b32758c.gif)



