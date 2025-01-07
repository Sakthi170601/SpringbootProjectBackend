package com.project.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movieshow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieshowid;
	private int theatreId;
	private int screenId;
	private String showTiming;

}
