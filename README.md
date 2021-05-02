# 자동차 경주 게임
## 구현기능 목록
* 차량
    - 속성
        + 이름
        + 이동거리(LAP)
    - 기능
        + 초기설정
            + 이름 생성
                - 이름은 1글자 이상이다.
                - 이름은 5글자 이하만 가능하다.
                - 이름 생성 조건을 통과하지 못하면 오류를 반환한다.
            + 이동거리 초기화
                - 이동거리는 0으로 설정
            + 차량 이동
                - 차량 이동거리 +1

* 차량 엔트리
    - 속성
        + 차량 List
    - 기능
        + 초기설정
            + 차량 엔트리를 입력받아 차량정보 생성
            + 차량정보 생성에 실패하면 오류를 반환한다.
        + 엔트리 차량 이동
            + 차량 엔트리에 있는 차량의 이동
                - 차량별로 숫자 0~9 사이 중 임의의 숫자가 4 이상이면 이동, 아니면 멈춤
        + 우승차량 조회
            + 가장 이동한 차량 정보 반환(복수 가능)


* 레이싱
    - 속성
        + 차량 엔트리
        + 레이싱 라운드
        + 인터페이스 객체
    - 기능
        + 초기설정
            + 입력받은 차량 엔트리 정보로 차량 라인업 정보를 생성한다.
            + 입력받은 라운드 정보를 저장한다.
                - 라운드 정보는 1보다 커야한다.
                - 라운드 정보가 1보다 작을경우 예외를 반환한다.
        + 레이싱 라운드 진행
            + 차량 엔트리의 차량 이동
            + 차량 엔트리의 차량 위치 출력
            + 레이싱 완료 후 가장 많이 이동한 차량 정보 조회 및 출력

* 레이싱 런처
    - 속성
    - 기능
        + 기본정보 입력받기
            + 차량 엔트리 정보를 입력 받는다.
                - Text : "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"
            + 차량 라운드 정보를 입력 받는다.
                - Text : "시도할 횟수는 몇회인가요?"
            + 입력받은 데이터로 레이싱 객체를 생성한다.
            + 레이싱 객체를 생성하지 못하면 다시 기본정보를 입력받는다.


* 레이싱 인터페이스
    - 차량 엔트리의 차량별 이름과 이동 거리를 출력한다.
    - 우승자 정보를 출력한다.
