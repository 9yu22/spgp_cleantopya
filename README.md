# spgp_cleantopya
2024-1 스마트폰게임프로그래밍 텀프로젝트

---

### 개발 일정
 1주차(4/4 - 4/10) - 시작화면 구성, 플레이 화면 구성
 
 2주차(4/11 - 4/17) - 첫번째 스테이지 만들기 - 리소스 수집, 게임 플레이 및 버튼 기능 구현

 3주차(4/18 - 4/24) - 첫번째 스테이지 만들기(완) - 클릭 횟수에 따라 먼지가 사라짐. 초단위 시간측정
 
 4주차(4/25 - 5/1) - 두번째 스테이지 만들기 - 리소스 수집, 플레이 및 버튼 기능 구현
 
 5주차(5/2 - 5/8) - 부족한 부분 보완, 2차 발표준비
 
 6주차(5/9 - 5/15) - 두번째 스테이지 만들기(완) - 흔들림 등 추가 애니메이션 구현

    *5/10 2차발표
 7주차(5/16 - 5/22) - 시작 카운트다운, 나가기버튼
 
 8주차(5/23 - 5/29) - 시간에 따른 최종 점수판, 언어지원 추가
 
 9주차(5/30 - 6/5)(6/6 - 6/12)  - 피드백 및 수정, 3차 발표 준비

    *6/14 3차발표

---
1차 발표 영상: https://youtu.be/ZYuXUSFj6Ow
</br>게임 소개: 버튼을 빠르게 클릭하는 아케이드형식의 모바일 게임
### 진행 상황
1단계 스테이지 구현 완료. 게임이 시작되면 랜덤으로 목표 카운트가 지정되며, 카운트만큼 버튼을 모두 입력했으면 노란색 버튼이 생긴다. 노란색 버튼을 클릭하면 다음 스테이지로 넘어간다. 버튼1회 입력은 카운트1번과 같으며, 카운트가 5번씩 증가할때마다 먼지가 하나씩 떨어진다.  게임이 시작되고 노란색 버튼을 클릭하기 전까지의 시간이 초단위로 측정된다.

<img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjYx/MDAxNzE1MjQwMjc5MjA2.hjcMrn4-W1Ddpm74Lw8CSIqpcmd2zmETqWiq1gry36Yg.tBWu7Q5IhbtMY5NEovl-BQIdrG9EbDDuC_D5ZjiA9yIg.PNG/image.png?type=w773" height = "400">  <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjMx/MDAxNzE1MjMyOTg4Mzc5.a4KybelV7AoZheNVzuzus_FKglGlSnTk161YmJe306sg.wseJXWmIc7FPjuFXiDhkibDntcVl4iZaPO0D9yZUulIg.PNG/image.png?type=w773" height = "400">

### 항목별 진행 척도
|항목 (진행율)|구현내용|부족한내용|
|---|---|---|
|1단계 (90%)|버튼입력, 먼지애니메이션, Scene전환|먼지객체들의 효율적인 관리, 버튼 눌림 효과(이미지 혹은 사운드)|
|2단계 (5%)|background, 버튼띄우기|아이템 생성, 입력에 따른 아이템 제거, 잘못된 입력시 화면흔들림|
|기타 (5%)|시간측정|카운트다운, 점수판, 언어지원, 사운드|

|주차|커밋횟수|일일 커밋 그래프|
|:---:|:---:|---|
|1주차 |7| <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjkx/MDAxNzE1MjMzMjUwMjIz.sYXZIlRVPKlynrpLnPgk1TG_gnQiqWmg3EcoegHONp0g.bdaUaNhR2vkilONQo-1-rUrsshrtZCn13d_Xz4NYhuEg.PNG/image.png?type=w773" height = "150">|
|2주차 |10| <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMSAg/MDAxNzE1MjM4MDk2ODY1.B2XiwC-6xv4pTL8xvaN5XN_aWwRAXluZAP2y58hNBXEg.X--RFH2UAPzh1ScQ7B3rD-5s_TDMz26j6rc0ZvRrircg.PNG/image.png?type=w773" height = "150">|
|3주차 |2| <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjMy/MDAxNzE1MjM4MTEyNTIw.sxg0J-3Om3JSs_jBgCz3vsSJp4cgyV1gwVmh8iU1J8Mg.hmXDBXNoJroLOutCn_7D-TMYPXzKe0v9Use2t2XuS0Ag.PNG/image.png?type=w773" height = "150">|
|4주차 |2| <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMTYy/MDAxNzE1MjM4MTI1OTM0.a3P_7tBYGEg7oGdO03mf6aFIvppP6MDUUVush77l8BYg.1Cfmok9sPZ5on3iKbjJcwOv4wPDtd29s_UUo_BNMMHAg.PNG/image.png?type=w773" height = "150">|
|5주차 |9| <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMTcw/MDAxNzE1MjMzMzczNjg5.UMt8vBw-YGHDpFdbO9yhf0nhrGtfjaY91GHUvbXWt0Yg.q9cMwq-DTI40ZugHL98QqVFz02EttC-0ceki9hcgAhAg.PNG/image.png?type=w773" height = "150">|

### GameObject - TouchButton, Dust
* TouchButton
<img src ="https://postfiles.pstatic.net/MjAyNDA1MDlfNzYg/MDAxNzE1MjM3NDE1MTk4.QD0h_muo-0t0KMnevn2mb57yvXO_1mziTQrzH8rFxN0g.EeP149BhecZuc0cgUGiR-UPUhJcxUyT05kXnGjNMsTog.PNG/image.png?type=w773" height ="80">
Sprite를 상속받아, MainScene에서 이미지와, 위치를 입력받아 생성됩니다.
버튼이 클릭되면 count가 증가되며, count의 횟수에 따라 Dust의 speed가 결정되어 떨어지는 애니메이션을 합니다.
<img src ="https://postfiles.pstatic.net/MjAyNDA1MDlfMjEz/MDAxNzE1MjM5MTk4Nzc2.RajlHCqvyd8RH3ykLu8zHWqDtWuMM_FZoukGkwvtSowg.vC-TFnSp0GxqRLGhHgVOV6v5y8WR4eSjjVEBTclh31cg.PNG/image.png?type=w773" height ="300">
* Dust
<img src ="https://postfiles.pstatic.net/MjAyNDA1MDlfMTc3/MDAxNzE1MjM3MzkxNDI1.AfnWORFH2LvMdDk2RJu9C-Rk4MH-_1uIykzNps3Q4DYg.6MiUg8XSlF9Q0MCEUfhxMqd9Oyk2_qYASpZO1WYlvFQg.PNG/dust.png?type=w773" height ="80">
Sprite를 상속받습니다. x, y좌표를 입력받아 생성되며 count의 횟수가 증가되면 입력받은 speed에 따라 화면 아래로 떨어집니다.
<img src ="https://postfiles.pstatic.net/MjAyNDA1MDlfMTgz/MDAxNzE1MjM5MjMwNTc5.768egbjJ8GgV32jBQkyY9_azn5omC77g7WF1qwXlBvEg.aXCaskEtouLDxh7zzzcikdSCcBA59f_auwBgV0y-jtUg.PNG/image.png?type=w773" height ="80">
* 이외 object 
   -베게: MainScene에서 Sprite로 생성한 이미지
   -시간: Framework의 Score를 사용. MainScene의 update함수에서 호출되며 초단위로 측정됨

### 기타
카운트 다운 비디오를 넣고자 하는데, mp4파일을 인식하는 과정에서 어려움을 겪고있음.

2단계 스테이지에서 잘못된 버튼을 입력했을때 화면이 흔들리는 효과를 어떻게 넣어야할지 모르겠음. 
