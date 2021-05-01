package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

	private RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar("test");
	}

	@Test
	@DisplayName("레이싱카 이름 초기설정 테스트")
	void getRacingCarName() {
		assertThat(racingCar.getRacingCarName()).isEqualTo("test");
	}

	@Test
	@DisplayName("입력되지 않은 레이싱카 이름 예외처리 테스트")
	void racingCarNameEmpty() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new RacingCar(null);
		}).withMessage("차량 이름이 입력되지 않았습니다.");
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new RacingCar("");
		}).withMessage("차량 이름이 입력되지 않았습니다.");
	}

	@Test
	@DisplayName("5글자 넘는 레이싱카 이름 예외처리 테스트")
	void racingCarNameOver5Byte() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new RacingCar("test1234");
		}).withMessage("차량 이름의 최대 크기를 초과하였습니다.");
	}

	@Test
	@DisplayName("레이싱 이동거리 초기화 테스트")
	void getRacingLapCount() {
		racingCar = new RacingCar("test");
		assertThat(racingCar.getRacingLapCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("레이싱카 이동 기능 테스트")
	void raceTrackTest() {
		assertThat(racingCar.getRacingLapCount()).isEqualTo(0);
		racingCar.raceTrack();
		assertThat(racingCar.getRacingLapCount()).isEqualTo(1);
		racingCar.raceTrack();
		assertThat(racingCar.getRacingLapCount()).isEqualTo(2);
	}
}
