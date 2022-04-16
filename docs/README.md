### 숫자 야구 게임 구현 기능 정의
* Application
  1. 게임을 시작한다.
  2. Player에게 ballNumber를 입력 받는다.
  3. Player에게 결과를 출력한다.
  4. Player가 정답을 맞추면 finishNumber를 입력받는다.
  5. Player가 2를 입력하면 게임 종료를 출력하고 애플리케이션을 종료한다.

<br>

* controller
  * PlayController
    * gameNumber : 임의로 생성된 3자리 숫자 
    * guess
      1. Player에게 입력받은 ballNumber를 검증한다.
      2. Player에게 입력받은 ballNumber를 Computer에게 전달한다.
      3. Computer에게 결과를 받아서 반환한다.
    * finish
      1. Player에게 입력받은 finishNumber를 검증한다.
      2. 입력받은 값이 2면 "finish"를 반환한다.

<br>

* model
   * Ball
      1. ballNumber: 3자리 숫자
      2. toList: ballNumber 각 자리의 숫자 별로 나눠 List형으로 변환한다.
   * Hint
      1. strike: 스트라이크의 갯수
      2. ball: 볼의 갯수
      3. toString: strike, ball을 "{ball}볼 {strike}스트라이크"로 변환한다. <br> 둘 다 갯수가 0일 경우 "낫싱"을 반환한다.

* service
  * ComputerService
    * createGameNumber
        1. 임의의 3자리 gameNumber를 생성한다.
    * compare
        1. ballNumber와 gameNumber를 비교한다.
        2. hint를 반환한다.
  * ValidationService
      * validateBallNumber
          1. Player에게 입력받은 ballNumber가 3자리인지 검증한다.
          2. 검증 결과를 반환한다.
      * validateFinishNumber
          1. Player에게 입력받은 finishNumber가 1 또는 2인지 검증한다.
          2. 검증 결과를 반환한다.