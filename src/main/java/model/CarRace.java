package model;

import utils.CarRaceValidationUtils;

public class CarRace {

	final private RacingCarEntry racingCarEntry;
	final int raceRound;

	public CarRace(String entryCarNames, String raceRound) {
		CarRaceValidationUtils raceValidationUtils = new CarRaceValidationUtils();
		this.racingCarEntry = new RacingCarEntry(entryCarNames);
		this.raceRound = raceValidationUtils.validateRacingRound(raceRound);
	}

	public RacingCarEntry getRacingCarEntry() {
		return racingCarEntry;
	}

	public int getRaceRound() {
		return raceRound;
	}
}
