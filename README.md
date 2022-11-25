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

###  유스케이스 다이어그램

<img width="704" alt="스크린샷 2022-11-25 오후 5 40 36" src="https://user-images.githubusercontent.com/81874493/203937822-95cd5abd-b845-420c-a8dd-4efaec79cc35.png">

<br>

### 클래스 다이어그램

####  ⃝ Repository 클래스 다이어그램

<img width="929" alt="스크린샷 2022-11-25 오후 5 52 00" src="https://user-images.githubusercontent.com/81874493/203940818-fef1e15a-d64a-4269-a12e-c47cfbc5b792.png">

* HashMap을 통한 메모리 저장 방식

<br>

####  ⃝ Domain 클래스 다이어그램

<img width="619" alt="스크린샷 2022-11-25 오후 5 52 19" src="https://user-images.githubusercontent.com/81874493/203940978-d3afb9d3-7119-4cd6-8039-5f2662ab0e43.png">

<br>

####  ⃝ Controller 클래스 다이어그램

<img width="1113" alt="스크린샷 2022-11-25 오후 5 55 00" src="https://user-images.githubusercontent.com/81874493/203941163-832f53a5-e727-4c96-be0e-e14739d29cba.png">

<br>

####  ⃝ Interceptor 클래스 다이어그램

<img width="430" alt="스크린샷 2022-11-25 오후 5 55 35" src="https://user-images.githubusercontent.com/81874493/203941404-777dd8a8-3caa-43c1-b972-8d45f60b5779.png">


* 접근 제한 필터링
  - interceptor를 통한 미인증 사용자 접근 제한 
    - LoginCheckInterceptor 
    - ManagerCheckInterceptor


<br>


## 📺 프로젝트 실행 화면

![testing](https://user-images.githubusercontent.com/81874493/133004784-eba8a44e-706b-4316-9ce5-ea232b32758c.gif)



