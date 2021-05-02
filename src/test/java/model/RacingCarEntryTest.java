package model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

	@Test
	@DisplayName("우승자 정보 조회 테스트(우승자 1명)")
	void getWinnerList1() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		List<RacingCar> racingCars = carEntry.getRacingCars();
		setRacingLapCount(racingCars.get(0), 3);
		setRacingLapCount(racingCars.get(1), 2);
		setRacingLapCount(racingCars.get(2), 1);

		List<RacingCar> winnerList = carEntry.getWinnerList();

		assertThat(winnerList.size()).isEqualTo(1);
		assertThat(winnerList.get(0).getRacingCarName()).isEqualTo("twins");
	}

	@Test
	@DisplayName("우승자 정보 조회 테스트(우승자 1명) - 순서 변경")
	void getWinnerList2() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		List<RacingCar> racingCars = carEntry.getRacingCars();
		setRacingLapCount(racingCars.get(0), 2);
		setRacingLapCount(racingCars.get(1), 3);
		setRacingLapCount(racingCars.get(2), 2);

		List<RacingCar> winnerList = carEntry.getWinnerList();

		assertThat(winnerList.size()).isEqualTo(1);
		assertThat(winnerList.get(0).getRacingCarName()).isEqualTo("bear");
	}

	private void setRacingLapCount(RacingCar car, int labCount) {
		for (int i = 0; i < labCount; i++) {
			car.raceTrack();
		}
	}

	@Test
	@DisplayName("우승자 정보 조회 테스트(우승자 2명)")
	void getWinnerList3() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		List<RacingCar> racingCars = carEntry.getRacingCars();
		setRacingLapCount(racingCars.get(0), 3);
		setRacingLapCount(racingCars.get(1), 1);
		setRacingLapCount(racingCars.get(2), 3);

		List<RacingCar> winnerList = carEntry.getWinnerList();

		assertThat(winnerList.size()).isEqualTo(2);
		assertThat(winnerList.get(0).getRacingCarName()).isEqualTo("twins");
		assertThat(winnerList.get(1).getRacingCarName()).isEqualTo("tiger");
	}

}
