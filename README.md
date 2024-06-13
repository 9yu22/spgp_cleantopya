# spgp_cleantopya
2024-1 스마트폰게임프로그래밍 텀프로젝트

영상 링크
1차 발표: https://youtu.be/ZYuXUSFj6Ow
2차 발표: https://youtu.be/lRy6FSp5rxo
3차 발표: 

#### 게임 소개
버튼을 빠르게 클릭하는 아케이드형식의 모바일 게임


#### 개발 일정
 1주차(4/4 - 4/10) - 시작화면 구성, 플레이 화면 구성
 
 2주차(4/11 - 4/17) - 첫번째 스테이지 만들기 - 리소스 수집, 게임 플레이 및 버튼 기능 구현

 3주차(4/18 - 4/24) - 첫번째 스테이지 만들기(완) - 클릭 횟수에 따라 먼지가 사라짐. 초단위 시간측정
 
 4주차(4/25 - 5/1) - 두번째 스테이지 만들기 - 리소스 수집, 플레이 및 버튼 기능 구현
 
 5주차(5/2 - 5/8) - 부족한 부분 보완, 2차 발표준비
 
 6주차(5/9 - 5/15) - 두번째 스테이지 만들기(완) - 흔들림 등 추가 애니메이션 구현

 7주차(5/16 - 5/22) - 시작 카운트다운, 나가기버튼
 
 8주차(5/23 - 5/29) - 시간에 따른 최종 점수판, 언어지원 추가
 
 9주차(5/30 - 6/5)(6/6 - 6/12)  - 피드백 및 수정, 3차 발표 준비
 ```
 -> 계획한 일정 모두 진행 완료
 ```

|항목(진행율)|실제 진행 내용|
|---|---|
|스테이지1(100%)|버튼입력, 먼지애니메이션, Scene전환|
|스테이지2(100%)|버튼입력, 아이템 생성, 입력에 따른 아이템 제거, 잘못된 입력시 화면 흔들림, activity전환|
|기타(100%)|background, 사운드, 언어지원, 카운트다운영상, 점수판|

|주차|커밋횟수|일일 커밋 그래프|
|:---:|:---:|---|
|6주차 |2| <img src="https://postfiles.pstatic.net/MjAyNDA2MTNfMjMg/MDAxNzE4MjgyMjM2NDQ5.WlQoH4qRW25hkdiU4YDaQkn6hg8z85zxos6DVLOKFvYg.M18Q0ImNecC7niNtikvX9NXKXzL0-OuXjkjhgI9FlCMg.PNG/image.png?type=w773" height = "150">|
|7주차 |4| <img src="https://postfiles.pstatic.net/MjAyNDA2MTNfMjkg/MDAxNzE4MjgyMjU0OTc5.qJIy9z_Wy5aY3hOAaNyjuTfAkVoMll18Dit2YEWyeDIg.OTvg03jeeGWCLmkaMc3IsvCllJYh2eHqL13PFQ-Aq_Ug.PNG/image.png?type=w773" height = "150">|
|8주차 |7| <img src="https://postfiles.pstatic.net/MjAyNDA2MTNfMjgz/MDAxNzE4MjgyMjcyMjQ2.Vu13Yumw0hVbpz3KKjnucn2TXgDtm39OTfkN4ghmJ90g.y4DZAi73DE8cuHwtlpNZeazJDnAdhq6VulYgzxT6uGog.PNG/image.png?type=w773" height = "150">|
|9주차 |15| <img src="https://postfiles.pstatic.net/MjAyNDA2MTNfMjA5/MDAxNzE4MjgyMjgxMzYy.AX6eObwi45a8MPFyE0ZshY8_KwdDVZPvIu6a-r05t_Mg.Y9F9j3hFsTYnSbXsQe_MCAARrgASc6IWQLNQbnce8Kog.PNG/image.png?type=w773" height = "150">|
|10주차 |4| <img src="https://postfiles.pstatic.net/MjAyNDA2MTNfMTQ0/MDAxNzE4MjgyMjk4NTEz.4MvaroW5eMP6e5JCi2u-dT3QCcL06vT1lTsORWi0fv8g.O1aTq8T2iRzIlW8IWdexbcCH_DC-vx3bakR-fxdvTSsg.PNG/image.png?type=w773" height = "150">|

#### 개발 관련
-사용된 기술: 언어지원, Toast, VideoView, 화면 흔들림, TouchButton
-참고한 것: VideoView 유튜브 영상(https://www.youtube.com/watch?v=kTobGa8CFBg)
-수업에서 참고한 것: 프레임워크(scene, generator, sound), Toast, 언어지원
-직접 개발한 것: Touchbutton, ObjectLine, 점수 계산

-하고싶었는데 하지 못한 것: 먼지 객체 관리(위치, 애니메이션)
-팔기위해 보충할 것: stage2에서 처음부터 아이템이 내려오는게 아니라 이미 배치된 상태에서 시작되면 더 좋을 것 같다. 언어지원이 되기때문에 게임내에 언어선택 버튼이 있었으면 좋겠다. 스테이지 화면이 꽉 채워져 있지 않다. 버튼을 눌렀을때 사운드 말고도 눌린 버튼 사진을 추가하면 좋을것 같다. 평소에 실제 기기로 테스트하지않고 애뮬레이터를 이용하다보니 마우스버튼으로 게임을 하는것과 실제 스마트폰으로 두 손을 이용하여 터치하는 것과의 차이가 생겼다. 팔기 위해서는 이 점을 고려하여 스마트폰 게임은 동시에 터치가 가능하다는 점을 보완하여 좀 더 빠른 속도의 게임이 되어도 좋을것 같다. 모티브게임처럼 게임방법을 설명하는 영상이 들어가면 좋을 것 같다.
-겪었던 어려운점: 초반에 클래스 간의 상호작용을 이해하는것이 어려웠다. Video를 activity가 아닌곳에서 적용하는것이 어려웠다. 스테이지2에서 아이템생성에서 겹치거나 위치상의 버그가 많았다.
*해결하지 못한 버그는 없습니다.

-수업에서 기대했던 부분: 수업에서 이렇게 많은 게임을 만드는 법을 배우게 될 줄 몰랐다. 하나하나 배우는 수업이었으면 좋았겠지만 4학년 과목이기도하고, 구현해야할게 많다보니 그렇게 되지 않았다. 초반에 타이핑하던 때에 기대이상으로 이 수업이 잘 맞을 것 같다고 생각했다.
-수업을 통해 얻은 것: 조사하는 과제는 기초적인 지식을 쌓는데도 도움이 되었다. 깃을 통해 관리되다 보니 체계적으로 정리되고 수정할 수 있어서 좋았다. 해당 수업이 특히 좋았던 이유는 수업자체가 전반적으로 매우 체계적으로 계획되어있었고, 개개인마다 프로젝트의 피드백을 최종발표 전까지 2차례에 걸쳐서 받을 수 있었던 부분이 마음에 들었다. Readme를 쓸때도 요청사항이 체계적으로 적혀있었는데, 게임을 개발하는데도 도움이 되었따. 게임을 실질적으로 만드는 방법을 알게되었다.
-수업에서 얻지 못한 것: 수업 내에서 즉각적으로 피드백할만한큼 집중하진 못해서 아쉽다.
-수업이 변화해야할 부분: 초기에 직접 코드를 작성하면서 함께 따라하는 시간은 가장 즉각적으로 스스로 작성한 코드를 확인할 수 있었기 때문에 배우는 재미가 있었다. 이미 적혀있는 코드를 보고 이해하기에는 나중에 따라하면서 버벅이거나 잊혀지는것들이 있었다. 어느정도 기반은 함께 만들고 추가요소를 깃과 온라인강의 형태로 배포하거나 가르쳐주는 갯수를 줄이고 좀 더 한 게임에 집중한다면 수업에 대한 집중도가 더 높아지지 않을까 싶다.


