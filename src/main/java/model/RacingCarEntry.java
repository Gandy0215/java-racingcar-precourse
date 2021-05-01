package model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarEntry {

	private final List<RacingCar> racingCars;

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
}
