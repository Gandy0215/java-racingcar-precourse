package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarEntryTest {

	RacingCarEntry carEntry;

	@Test
	@DisplayName("차량 리스트 생성 테스트")
	void createEntryTest() {
		carEntry = new RacingCarEntry("twins,bear,tiger");
		assertThat(carEntry.getRacingCars().size()).isEqualTo(3);

		carEntry = new RacingCarEntry("test");
		assertThat(carEntry.getRacingCars().size()).isEqualTo(1);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carEntry = new RacingCarEntry("");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			carEntry = new RacingCarEntry("doctorfish");
		});

	}

}
