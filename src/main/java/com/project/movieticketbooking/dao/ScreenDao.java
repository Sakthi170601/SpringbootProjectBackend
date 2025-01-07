package com.project.movieticketbooking.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.movieticketbooking.dto.ScreenDto;
import com.project.movieticketbooking.entity.Screen;
import com.project.movieticketbooking.repository.ScreenRepository;

@Repository
public class ScreenDao {

	@Autowired
	ScreenRepository screenRepository;

//	1.save
	public Screen saveScreen(ScreenDto screen) {
		Screen screenEntity = new Screen();
		screenEntity.setScreenName(screen.getScreenName());

		int totalSeats = 100;
		int groupSize = totalSeats / 3;
		int remainder = totalSeats % 3;

		Map<String, Boolean> seatMap = new LinkedHashMap<>();
		char group = 'A';
		int seatCounter = 1;

		// Allocate seats into groups
		for (int i = 1; i <= totalSeats; i++) {
			String seatLabel = seatCounter + String.valueOf(group);
			seatMap.put(seatLabel, false);

			// Move to the next group if group size is reached
			if (i % groupSize == 0 && group < 'C') {
				group++;
				seatCounter = 0;
			}
			seatCounter++;
		}

		// Handle the remaining seats
		if (remainder > 0) {
			for (int i = 1; i <= remainder; i++) {
				String seatLabel = (totalSeats - remainder + i) + String.valueOf((char) (group + 1));
				seatMap.put(seatLabel, false);
			}
		}

		screenEntity.setMap(seatMap);
		return screenRepository.save(screenEntity);
	}

//	2.findById
	public Screen findScreenById(int id) {
		Optional<Screen> optionalScreen = screenRepository.findById(id);
		if (optionalScreen.isPresent()) {
			return optionalScreen.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Screen> findAllScreen() {
		return screenRepository.findAll();
	}

//	4.update
	public Screen updateScreen(Screen Screen, int id) {
		Screen findScreen = findScreenById(id);
		if (findScreen != null) {
			Screen.setScreenId(id);
			return Screen;

		}
		return null; // exception will be there if the findScreen object is null
	}

//	5.delete
	public Screen deleteScreen(int id) {
		Screen findedScreen = findScreenById(id);
		if (findedScreen != null) {
			screenRepository.delete(findedScreen);
			return findedScreen;
		}
		return null; // exception will be there for object is not present
	}

}
