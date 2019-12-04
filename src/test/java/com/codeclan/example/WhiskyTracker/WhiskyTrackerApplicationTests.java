package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear() {
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskiesByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindDistilleriesByRegion() {
		List<Distillery> foundDistilleries = distilleryRepository.findAllDistilleriesByRegion("Lowland");
		assertEquals("Rosebank", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindWhiskyByDistilleryNameAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskiesByDistilleryNameAndAge("Glendronach", 12);
		assertEquals("The Glendronach Original", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindWhiskyByRegion() {
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskyByDistilleryRegion("Highland");
		assertEquals(2, foundWhiskies.size());
		assertEquals("The Glendronach Revival", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFind12yoWhiskys() {
		List<Distillery> foundDistilleries = distilleryRepository.findAllDistilleriesByWhiskiesAgeEquals(12);
		assertEquals(2, foundDistilleries.size());
		assertEquals("Rosebank", foundDistilleries.get(0).getName());
	}

}
