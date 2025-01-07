package com.project.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.movieticketbooking.dto.ScreenDto;
import com.project.movieticketbooking.entity.Screen;
import com.project.movieticketbooking.service.ScreenService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Screen")
public class ScreenController {

	@Autowired
	ScreenService screenService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody ScreenDto Screen) {
		return screenService.saveScreen(Screen);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Screen>> findBookigById(@RequestParam int id) {
		return screenService.findScreenById(id);
	}

	@GetMapping("findAllScreen")
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen() {
		return screenService.findAllScreen();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestBody Screen Screen, @RequestParam int id) {
		return screenService.updateScreen(Screen, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int id) {
		return screenService.deleteScreen(id);
	}
}
