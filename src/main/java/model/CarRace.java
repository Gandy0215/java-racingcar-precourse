package model;

import utils.CarRaceValidationUtils;
import view.CarRacingConsole;

public class CarRace {

	final private RacingCarEntry racingCarEntry;
	final private CarRacingConsole carRacingConsole;
	final int raceRound;

	public CarRace(String entryCarNames, String raceRound) {
		CarRaceValidationUtils raceValidationUtils = new CarRaceValidationUtils();
		this.carRacingConsole = new CarRacingConsole();
		this.racingCarEntry = new RacingCarEntry(entryCarNames);
		this.raceRound = raceValidationUtils.validateRacingRound(raceRound);
	}

	public RacingCarEntry getRacingCarEntry() {
		return racingCarEntry;
	}

	public int getRaceRound() {
		return raceRound;
	}

	public void racing() {
		for (int i = 0; i < raceRound; i++) {
			racingCarEntry.racingOneRound();
			carRacingConsole.printRacingStatus(racingCarEntry.getRacingCars());
		}
	}
}
