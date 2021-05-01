package model;

import utils.RacingCarValidationUtils;

public class RacingCar {
	RacingCarValidationUtils validationUtils = new RacingCarValidationUtils();

	final private String racingCarName;
	int racingLabCount;

	public RacingCar(String racingCarName) {
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
}
