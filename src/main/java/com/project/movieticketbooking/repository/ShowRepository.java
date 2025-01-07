package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Movieshow;

public interface ShowRepository extends JpaRepository<Movieshow, Integer> {

}
