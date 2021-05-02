package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTest {

	CarRace carRace;

	@Test
	@DisplayName("차량 이름 예외처리 테스트")
	void racingCarNameValidationTest() {
		String carNames = "";
		String racingRound = "0";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carRace = new CarRace(carNames, racingRound);
		});
	}

	@Test
	@DisplayName("레이싱 라운드 예외처리 테스트")
	void racingRoundValidationTest() {
		String carNames = "twins,bear,tiger";
		String racingRound = "0";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carRace = new CarRace(carNames, racingRound);
		});
	}

	@Test
	@DisplayName("레이싱 정상 생성 테스트")
	void createCarRaceTest() {
		String carNames = "twins,bear,tiger";
		String racingRound = "5";
		carRace = new CarRace(carNames, racingRound);

		assertThat(carRace.getRacingCarEntry().getRacingCars().size()).isEqualTo(3);
		assertThat(carRace.getRacingCarEntry().getRacingCars().get(0).getRacingCarName()).isEqualTo("twins");
		assertThat(carRace.getRaceRound()).isEqualTo(5);
	}

}
