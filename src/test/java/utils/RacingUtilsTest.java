package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.RacingCarEntry;

public class RacingUtilsTest {
	RacingUtils carUtils = new RacingUtils();

	@BeforeEach
	void setUp() {
		carUtils = new RacingUtils();
	}

	@Test
	@DisplayName("레이싱 이동 여부 테스트")
	void canRacingOneMoreLap() {
		assertThat(carUtils.canRacingOneMoreLap(3)).isFalse();
		assertThat(carUtils.canRacingOneMoreLap(0)).isFalse();
		assertThat(carUtils.canRacingOneMoreLap(4)).isTrue();
		assertThat(carUtils.canRacingOneMoreLap(9)).isTrue();
	}

	@Test
	@DisplayName("랜덤 숫자 범위확인(0~9)")
	void randomScoreTest() {
		int randomScore = -1;
		for (int i = 0; i < 30; i++) {
			randomScore = carUtils.createRandomScore();
			System.out.println(randomScore);
			assertThat(randomScore >= 0 && randomScore <= 9).isTrue();
		}
	}
}
