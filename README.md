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
    *터치에 따른, 주체의 흔들리는 애니메이션과 리소스변화

 2.청소기 돌리기(아이템을 얼마나 많이 획득하는지 측정)
    
    *필요한 리소스: 바닥 background, 아이템(돈)
    *아이템이 있는 길에 따라 그 위치의 버튼을 누름
    *아이템 획득 시 사라짐 & 획득한 갯수 기록
    *버튼을 잘못 눌렀을시, 잠시 멈추고 화면이 흔들린다.

 
 * 게임시작 버튼, activity 전환
 * 스테이지 시작 카운트 다운
 * 왼쪽/중앙/오른쪽/finish 버튼, 나가기 버튼(alert)
 * 초단위로 게임플레이 시간을 측정
 * 시간에 따른 최종 점수판
 * 언어지원(한국어, 영어)


#### 예상 게임 실행 흐름

게임 시작버튼을 누르면 총 2가지 스테이지가 진행되며, 걸린시간의 총합으로 성적이 부여된다.

첫번째 스테이지는 '먼지 털기'로 먼지털이(예시)에 붙어있는 먼지를 털기 위하여 빠른 속도로 버튼을 번갈아 누르면 되는 게임이다. 먼지를 다 털면 다음 스테이지로 넘어간다.
![](http://webimage.uniana.com/bishibashi/images/web/bishi/game_01_02.jpg)
<img src = "https://postfiles.pstatic.net/MjAyNDA0MDJfMjU1/MDAxNzEyMDU5MzY4MzYx.YuBYEACXqDC_sjdT6VdR3Gdy4ORPkIGK2tnh2qOYSyQg.7lILFT9dxwOFVnrsUQuiNipRhK-UEaQDwOGHZbqiKA0g.PNG/image.png?type=w773" height = "200">


두번째 스테이지는 '청소기 돌리기'로 청소기로 아이템의 위치에 해당하는 버튼을 눌러 마지막 아이템까지 가장 빨리 흡입하면 되는 게임이다. 
![](http://webimage.uniana.com/bishibashi/images/web/bishi/game_02_05.jpg)
<img src = "https://postfiles.pstatic.net/MjAyNDA0MDJfOTUg/MDAxNzEyMDU5MjY2ODcy._4yNgJfbpQ8DqFM2q1HRLtKaaatC-Qh1u5vlSlC-mPsg.seqWGzk7KB0e1BI6L0NkS2hitBfT43EX3RiKhIMJ4FMg.PNG/image.png?type=w773" height = "200">
   
이후 성적이 부여되며 게임은 종료된다.
성적 부여방식의 예) 3개의 스테이지의 총 걸린시간이 60초 이내일 경우 sss등급
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
