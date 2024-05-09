# spgp_cleantopya
2024-1 스마트폰게임프로그래밍 텀프로젝트

---

#### 게임 컨셉
 청소는 스피드만이 살길! 빠른 청소실력을 가진 청소알바생의 하루를 살아보자!

 2가지 스테이지로 구성되며 조작법이 쉬운 게임. 
 모티브게임은 아케이드게임 <더 비시바시>

#### 개발 범위
 
 1.먼지 털기(클릭횟수에 대한 스피드를 측정)
    
    *필요한 리소스: background, 먼지를 갖고있는 주체, 먼지
    *게임이 시작되면 100~109번 사이에서 랜덤으로 터치해야할 횟수가 지정됨.
    *총 10개의 먼지가 붙어있으며, 터치10번에 먼지1개가 사라짐.

 2.청소기 돌리기(아이템을 얼마나 많이 획득하는지를 측정)
    
    *필요한 리소스: 바닥 background, 아이템(돈)
    *아이템이 있는 길에 따라 그 위치의 버튼을 누름
    *아이템은 3가지 길 중 1~2곳에서 랜덤으로 생성됨.
    *버튼을 옳게 누르면 해당 아이템은 사라짐 & 아이템을 획득한 갯수가 기록됨.
    *버튼을 잘못 눌렀을시, 잠시 멈추고 휴대폰 화면 전체가 흔들리고 입력이 2초동안 불가능하다.

 

 * 게임시작 버튼, activity 전환
 * 스테이지 시작 카운트 다운
 * 왼쪽/중앙/오른쪽/finish 버튼, 나가기 버튼(alert)
 * 초단위로 게임플레이 시간을 측정
 * 시간에 따른 최종 점수판(40초 sss등급, 50초 ss등급, 60초 s등급, 70초 a등급, 80초 b등급, 90초 f등급)
 * 언어지원(한국어, 영어)
 * 버튼 사운드와 배경 음악 추가


#### 예상 게임 실행 흐름

게임 시작버튼을 누르면 총 2가지 스테이지가 진행되며, 걸린시간의 총합으로 성적이 부여된다.

첫번째 스테이지는 '먼지 털기'로 먼지털이(예시)에 붙어있는 먼지를 털기 위하여 빠른 속도로 버튼을 번갈아 누르면 되는 게임이다. 먼지를 다 털면 다음 스테이지로 넘어간다.

![](http://webimage.uniana.com/bishibashi/images/web/bishi/game_01_02.jpg)
<img src = "https://postfiles.pstatic.net/MjAyNDA0MDJfMjU1/MDAxNzEyMDU5MzY4MzYx.YuBYEACXqDC_sjdT6VdR3Gdy4ORPkIGK2tnh2qOYSyQg.7lILFT9dxwOFVnrsUQuiNipRhK-UEaQDwOGHZbqiKA0g.PNG/image.png?type=w773" height = "205">


두번째 스테이지는 '청소기 돌리기'로 청소기로 아이템의 위치에 해당하는 버튼을 눌러 마지막 아이템까지 가장 빨리 흡입하면 되는 게임이다. 

![](http://webimage.uniana.com/bishibashi/images/web/bishi/game_02_05.jpg)
<img src = "https://postfiles.pstatic.net/MjAyNDA0MDJfOTUg/MDAxNzEyMDU5MjY2ODcy._4yNgJfbpQ8DqFM2q1HRLtKaaatC-Qh1u5vlSlC-mPsg.seqWGzk7KB0e1BI6L0NkS2hitBfT43EX3RiKhIMJ4FMg.PNG/image.png?type=w773" height = "200">
   
이후 성적이 부여되며 게임은 종료된다.

<img src="https://i.ytimg.com/vi/POTp4Mdsg8w/maxresdefault.jpg" height="180">



#### 개발 일정
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


</br>1차 발표 영상: https://youtu.be/ZYuXUSFj6Ow

***
# 중간발표
2024-1 스마트폰게임프로그래밍 텀프로젝트 
SPGP_Cleantopya

</br>게임 소개: 버튼을 빠르게 클릭하는 아케이드형식의 모바일 게임

진행 상황: 1단계 스테이지 구현 완료
게임이 시작되면 랜덤으로 목표 카운트가 지정되며, 카운트만큼 버튼을 모두 입력했으면 노란색 버튼이 생긴다. 노란색 버튼을 클릭하면 다음 스테이지로 넘어간다. 버튼1회 입력은 카운트1번과 같으며, 카운트가 5번씩 증가할때마다 먼지가 하나씩 떨어진다. 
게임이 시작되고 노란색 버튼을 클릭하기 전까지의 시간이 초단위로 측정된다.

<img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjYx/MDAxNzE1MjQwMjc5MjA2.hjcMrn4-W1Ddpm74Lw8CSIqpcmd2zmETqWiq1gry36Yg.tBWu7Q5IhbtMY5NEovl-BQIdrG9EbDDuC_D5ZjiA9yIg.PNG/image.png?type=w773" height = "400">  <img src="https://postfiles.pstatic.net/MjAyNDA1MDlfMjMx/MDAxNzE1MjMyOTg4Mzc5.a4KybelV7AoZheNVzuzus_FKglGlSnTk161YmJe306sg.wseJXWmIc7FPjuFXiDhkibDntcVl4iZaPO0D9yZUulIg.PNG/image.png?type=w773" height = "400">

#### 항목별 진행 척도
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

#### GameObject - TouchButton, Dust
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
