package model;

import java.util.ArrayList;
import java.util.List;

import utils.RacingUtils;

public class RacingCarEntry {

	private final List<RacingCar> racingCars;
	private final RacingUtils racingUtils = new RacingUtils();

	public RacingCarEntry(String carNames) {
		this.racingCars = getEntryCars(carNames);
	}

	private List<RacingCar> getEntryCars(String carNames) {
		String[] racingEntryCarNames = carNames.split(",");
		List<RacingCar> racingCars = new ArrayList<RacingCar>();
		createRacingCarEntry(racingCars, racingEntryCarNames);
		return racingCars;
	}

	private void createRacingCarEntry(List<RacingCar> racingCars, String[] carEntry) {
		for (String racingCarName : carEntry) {
			racingCars.add(new RacingCar(racingCarName));
		}
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public void racingOneRound() {
		for (int trackNum = 0; trackNum < racingCars.size(); trackNum++) {
			racingEachCars(trackNum, racingUtils.createRandomScore());
		}
	}

	private void racingEachCars(int trackNum, int randomScore) {
		if (racingUtils.canRacingOneMoreLap(randomScore)) {
			racingCars.get(trackNum).raceTrack();
		}
	}
}
