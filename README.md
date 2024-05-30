### State Paatern
이 프로젝트는 Java와 Spring Boot를 사용하여 "상태 패턴(State Pattern)"을 구현한 것입니다. 상태 패턴은 객체의 내부 상태에 따라 객체의 행동을 변경할 수 있게 하는 디자인 패턴입니다.
주요 클래스와 그 역할은 다음과 같습니다:
1. `State`: 상태를 나타내는 인터페이스입니다. `handle(Context context)` 메소드를 통해 상태를 처리하고, `getDescription()` 메소드를 통해 상태 설명을 반환합니다.
2. `StateA`와 `StateB`: `State` 인터페이스를 구현한 클래스입니다. `StateA`는 "active" 상태를, `StateB`는 "inactive" 상태를 나타냅니다.
3. `Context`: 현재 상태를 관리하는 클래스입니다. `Context`는 `State` 객체를 가지고 있으며, 이를 통해 상태를 변경하거나 조회할 수 있습니다.
4. `StatePatternApplication`: 애플리케이션의 시작점입니다. Spring Boot 애플리케이션을 실행합니다.
#### 프로젝트의 핵심 로직은 다음과 같습니다:
1. `Context` 객체를 생성하고, 초기 상태(`StateA` 또는 `StateB`)를 설정합니다.
2. `Context`의 `request()` 메소드를 호출하여 상태를 변경합니다. 이 메소드는 내부적으로 현재 상태의 `handle(Context context)` 메소드를 호출합니다.
3. `Context`의 `getState().getDescription()` 메소드를 호출하여 변경된 상태를 확인합니다.
이 프로젝트는 상태 패턴을 이해하고 구현하는 데 도움이 될 것입니다.

### 흐름은 아래와 같습니다.
1. 애플리케이션 시작 (`StatePatternApplication.main`)
2. `Context` 객체 생성
3. 사용자의 상태에 따라 `StateA` 또는 `StateB` 인스턴스를 `Context`에 설정
4. `Context.request()` 호출
5. `Context.request()`는 현재 상태의 `handle(Context context)` 메소드를 호출
6. `handle(Context context)` 메소드는 `Context`의 상태를 변경
7. 변경된 상태는 `Context.getState().getDescription()`을 통해 확인 가능

끝
