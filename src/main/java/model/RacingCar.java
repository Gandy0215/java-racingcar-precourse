package model;

import utils.RacingCarValidationUtils;

public class RacingCar implements Comparable<RacingCar> {
	RacingCarValidationUtils validationUtils = new RacingCarValidationUtils();

	final private String racingCarName;
	int racingLabCount;

	public RacingCar(final String racingCarName) {
		this.racingCarName = validationUtils.validateRacingCarName(racingCarName);
		this.racingLabCount = 0;
	}

	public String getRacingCarName() {
		return racingCarName;
	}

	public int getRacingLapCount() {
		return racingLabCount;
	}

	public void raceTrack() {
		racingLabCount++;
	}

	@Override
	public int compareTo(final RacingCar car) {
		return Integer.compare(car.getRacingLapCount(), this.racingLabCount);

	}
}
