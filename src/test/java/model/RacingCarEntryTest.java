package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarEntryTest {

	RacingCarEntry carEntry;

	@Test
	@DisplayName("차량 리스트 생성 테스트")
	void createEntryTest() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		assertThat(carEntry.getRacingCars().size()).isEqualTo(3);

		carEntry = new RacingCarEntry("test");
		assertThat(carEntry.getRacingCars().size()).isEqualTo(1);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carEntry = new RacingCarEntry("");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carEntry = new RacingCarEntry("doctorfish");
		});
	}

	@Test
	@DisplayName("차량 별 이동 테스트")
	void racingOneRound() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		int testRound = 30;
		testRacing(testRound);
		assertThat(isExistRacingOneMoreTrackCar()).isTrue();

	}

	private boolean isExistRacingOneMoreTrackCar() {
		boolean isExist = false;
		for (int i = 0; i < carEntry.getRacingCars().size() && (!isExist); i++) {
			isExist = (carEntry.getRacingCars().get(i).getRacingLapCount() > 0);
		}
		return isExist;
	}

	private void testRacing(int testRound) {
		for (int i = 0; i < testRound; i++) {
			carEntry.racingOneRound();
		}
	}
}
