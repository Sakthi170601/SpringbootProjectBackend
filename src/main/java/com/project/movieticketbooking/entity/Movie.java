package com.project.movieticketbooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieTitle;
	private String duration;
	private String language;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Movieshow> show;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Screen> screen;

}
