package utils;

public class CarRaceValidationUtils {

	public int validateRacingRound(String racingRound) {
		try {
			return isGratterThanZero(Integer.parseInt(racingRound));
		} catch (NumberFormatException numberFormatException) {
			throw new IllegalArgumentException("라운드는 정수 형식으로 입력 가능합니다.");
		}
	}

	private int isGratterThanZero(int racingRound) {
		if (racingRound <= 0) {
			throw new IllegalArgumentException("라운드는 0보다 큰 자연수를 입력해 주세요.");
		}
		return racingRound;
	}
}
