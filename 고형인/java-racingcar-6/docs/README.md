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