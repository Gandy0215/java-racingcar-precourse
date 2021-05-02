package view;

import java.util.List;

import model.RacingCar;
import utils.RacingCarValidationUtils;

public class CarRacingConsole {

	public void printRacingStatus(final List<RacingCar> racingCars) {
		for (RacingCar racingCar : racingCars) {
			printRacingStatus(racingCar);
		}
		System.out.println("");
	}

	private void printRacingStatus(final RacingCar racingCar) {
		final String strCarName = lpad(racingCar.getRacingCarName());
		final String separator = " : ";
		final String lapCount = displayLapCount(racingCar);
		System.out.println(strCarName.concat(separator.concat(lapCount)));
	}

	private String displayLapCount(final RacingCar racingCar) {
		String lapCount = "";
		for (int i = 0; i < racingCar.getRacingLapCount(); i++) {
			lapCount = lapCount.concat("-");
		}
		return lapCount;
	}

	private String lpad(final String racingCarName) {
		String lpadCarName = "";
		for (int i = 0; i < RacingCarValidationUtils.MAX_LENGTH_CAR_NAME - racingCarName.length(); i++) {
			lpadCarName = lpadCarName.concat(" ");
		}
		return lpadCarName.concat(racingCarName);
	}

	public void printWinner(final List<RacingCar> winnerList) {
		final String AWARD_COMMENT = "가 최종 우승했습니다.";
		String winners = getWinnerNames(winnerList);
		System.out.println(winners.concat(AWARD_COMMENT));
	}

	private String getWinnerNames(List<RacingCar> winnerList) {
		String winnerNames = "";
		for (int i = 0; i < winnerList.size(); i++) {
			winnerNames = winnerNames.concat(getWinnerName(winnerList.get(i), i));
		}
		return winnerNames;
	}

	private String getWinnerName(RacingCar car, int i) {
		final String separator = ", ";
		String winnerNames = "";
		if (i > 0) {
			winnerNames = winnerNames.concat(separator);
		}
		return winnerNames.concat(car.getRacingCarName());
	}

}
