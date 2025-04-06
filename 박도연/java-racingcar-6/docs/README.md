# 기능 목록
## initialize
- (출력) "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
- (입력) 경주할 자동차 목록
  - `exception`: "" 입력
  - `exception`: 구분자(',') 에러
  - `exception`: 이름 5자 초과
- (출력) "시도할 회수는 몇회인가요?"
- (입력) 시도 횟수
  - `exception`: "" 입력
  - `exception`: 양수 정수가 아닌경우

## process
- n대의 자동차는 전진/ 정지 한다.
  - 0~9 사이의 random number 
    - 4 이상 -> 전진
    - 4 미만 -> 정지

## terminate
- (출력) "실행 결과"
- 실행 결과를 출력한다.
    - `${name} : -` 과 같은 형식, 이동 문자는 `-`
    - `${name}`은 입력 순서대로 출력
    - 최종 우승자는 `최종 우승자 : ${name}` 형식으로 출력. 여러명일 경우 구분자로 나누어 출력한다. 

## exception
- `IllegalArgumentException`예외 출력 후 프로그램 terminate