package com.github.christian.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.christian.football.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
