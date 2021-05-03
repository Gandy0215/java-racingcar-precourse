package model;

import utils.CarRaceValidationUtils;
import view.CarRacingConsole;

public class CarRace {

	final private RacingCarEntry racingCarEntry;
	final private CarRacingConsole carRacingConsole;
	final int raceRound;

	public CarRace(RacingCarEntry racingCarEntry, String raceRound) {
		CarRaceValidationUtils raceValidationUtils = new CarRaceValidationUtils();
		this.carRacingConsole = new CarRacingConsole();
		this.racingCarEntry = racingCarEntry;
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
		racingAward();
	}

	private void racingAward() {
		carRacingConsole.printWinner(racingCarEntry.getWinnerList());
	}
}
