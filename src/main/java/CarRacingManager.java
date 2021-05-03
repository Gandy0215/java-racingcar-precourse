import model.CarRace;
import model.RacingCarEntry;
import view.CarRacingConsole;

public class CarRacingManager {
	CarRacingConsole console;
	CarRace carRace;

	public CarRacingManager() {
		console = new CarRacingConsole();
	}

	private RacingCarEntry getRacingCarNames() {
		RacingCarEntry entry = null;
		try {
			String racingCarNames = console.getMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
			entry = new RacingCarEntry(racingCarNames);
		} catch (IllegalArgumentException illegalArgumentException) {
			console.setMessage(illegalArgumentException.getMessage());
			getRacingCarNames();
		}
		return entry;
	}

	private void getRacingRound(RacingCarEntry entry) {
		try {
			String racingRound = console.getMessage("시도할 횟수는 몇회인가요?");
			carRace = new CarRace(entry, racingRound);
		} catch (IllegalArgumentException illegalArgumentException) {
			console.setMessage(illegalArgumentException.getMessage());
			getRacingRound(entry);
		}
	}

	public void startRacing() {
		getRacingRound(getRacingCarNames());
		carRace.racing();
	}
}
