package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.RacingUtils;

public class RacingCarEntry {

	private final List<RacingCar> racingCars;
	private final RacingUtils racingUtils = new RacingUtils();

	public RacingCarEntry(final String carNames) {
		this.racingCars = getEntryCars(carNames);
	}

	private List<RacingCar> getEntryCars(final String carNames) {
		String[] racingEntryCarNames = carNames.split(",");
		List<RacingCar> racingCars = new ArrayList<>();
		createRacingCarEntry(racingCars, racingEntryCarNames);
		return racingCars;
	}

	private void createRacingCarEntry(final List<RacingCar> racingCars, final String[] carEntry) {
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

	private void racingEachCars(final int trackNum, final int randomScore) {
		if (racingUtils.canRacingOneMoreLap(randomScore)) {
			racingCars.get(trackNum).raceTrack();
		}
	}

	public List<RacingCar> getWinnerList() {
		Collections.sort(racingCars);
		return getWinningRacingCars();
	}

	private List<RacingCar> getWinningRacingCars() {
		List<RacingCar> winnerList = new ArrayList<>();
		final int bestRacingLapCount = getBestRacingLapCount();

		for (int i = 0; i < racingCars.size() && isBestLapCount(bestRacingLapCount, i); i++) {
			winnerList.add(racingCars.get(i));
		}
		return winnerList;
	}

	private boolean isBestLapCount(final int bestRacingLapCount, final int i) {
		return racingCars.get(i).racingLabCount == bestRacingLapCount;
	}

	private int getBestRacingLapCount() {
		return racingCars.get(0).getRacingLapCount();
	}

}
