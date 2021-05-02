package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceValidationUtilsTest {
	CarRaceValidationUtils carRaceValidationUtils;

	@BeforeEach
	void setUp() {
		carRaceValidationUtils = new CarRaceValidationUtils();
	}

	@Test
	@DisplayName("레이싱 라운드 예외 테스트")
	void validateRacingRoundNonIntegerTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			carRaceValidationUtils.validateRacingRound("-333");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			carRaceValidationUtils.validateRacingRound("1.5");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			carRaceValidationUtils.validateRacingRound("abcdTest");
		});

	}
}
