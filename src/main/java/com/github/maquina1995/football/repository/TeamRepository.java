package com.github.maquina1995.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.maquina1995.football.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
