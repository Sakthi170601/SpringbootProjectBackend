package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
