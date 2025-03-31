<!-- 어렵다.. 뭐부터 해야할 지 모르겠다.. -->

### 자동차
이름   
위치   

### 차수별
랜덤값

### 입력
자동차 이름   
횟수   

### 출력
자동차 이름   
최종 우승자 안내


JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

```java
Randoms.pickNumberInRange(0,9);
```

1. 입력
   1. 자동차 이름 입력
      1. 5자 이하 검증
      2. 예외 처리
   2. 시행 횟수 입력 
      1. 예외 처리
2. 게임 진행
   1. 랜덤값 추출
   2. 자동차 distance 값 변경
   3. 진행 상황 출력
3. 우승자
   1. 우승자 계산
   2. 우승자 출력


- 지피티
   - 클래스별 역할 명확히 해서 분리
     디렉토리 나눠서 하라던데 관련해서 찾아보기 ← 일단 이거부터
   - 전역 변수 최소화
     Application.java에서 관리하지 않도록..
   - 자동차 이동 외에도 출력, 연산 등을 Car.java에서 처리
   - 레이싱 관리하는 클래스 추가해서 레이싱에 필요한 연산 처리
     자동차 이동, 우승자 계산 등
   - Input 클래스 인터페이스로 변경.. 추상화는 아닌 듯ㅜㅜ
- To Do
   - 다른 자바 코드 많이 읽어보기.. (객체 지향이 뭔지, 뭐가 중요한지 위주로)
   - 효율적인 우승자 계산/출력 방법 생각해보기
   - test 어떻게 쓰는 건지 찾기
   - intelliJ에서 깃 커밋/푸쉬 왜 실패하는지 찾기
   - 깃 조금 더 공부해보기
   - 다른 사람들 코드 보면서 배우기
   - 시간 오래 쓰지 말고 직접 질문해보기