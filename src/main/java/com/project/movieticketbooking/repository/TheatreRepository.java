package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
