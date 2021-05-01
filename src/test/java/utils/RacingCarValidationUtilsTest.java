package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.RacingCar;

class RacingCarValidationUtilsTest {
	RacingCarValidationUtils racingCarValidationUtils;

	@BeforeEach
	void setUp() {
		racingCarValidationUtils = new RacingCarValidationUtils();
	}

	@Test
	@DisplayName("차량 이름 생성 검증 테스트")
	void validateRacingCarNameTest() {
		assertThat(racingCarValidationUtils.validateRacingCarName("test")).isEqualTo("test");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			racingCarValidationUtils.validateRacingCarName(null);
		}).withMessage("차량 이름이 입력되지 않았습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			racingCarValidationUtils.validateRacingCarName("");
		}).withMessage("차량 이름이 입력되지 않았습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			racingCarValidationUtils.validateRacingCarName("test123");
		}).withMessage("차량 이름의 최대 크기를 초과하였습니다.");

	}

}
