package utils;

public class RacingCarValidationUtils {

	public static final int MAX_LENGTH_CAR_NAME = 5;

	public String validateRacingCarName(String racingCarName) {
		if (isEmptyName(racingCarName)) {
			throw new IllegalArgumentException("차량 이름이 입력되지 않았습니다.");
		}

		if (racingCarName.length() > MAX_LENGTH_CAR_NAME) {
			throw new IllegalArgumentException("차량 이름의 최대 크기를 초과하였습니다.");
		}

		return racingCarName;
	}

	private boolean isEmptyName(String racingCarName) {
		return racingCarName == null || racingCarName.isEmpty();
	}
}
