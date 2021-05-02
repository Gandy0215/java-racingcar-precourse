package utils;

import java.util.List;

public class RacingUtils {

	public static final int MIN_SCORE_OF_ONE_LAP = 4;

	public boolean canRacingOneMoreLap(final int racingScore) {
		return racingScore >= MIN_SCORE_OF_ONE_LAP;
	}

	public int createRandomScore() {
		return (int) (Math.random() * 10);
	}
}
