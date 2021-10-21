package com.github.christian.football.mapper;

import org.mapstruct.Mapper;

import com.github.christian.football.dto.TeamDto;
import com.github.christian.football.entity.Team;

@Mapper
public interface TeamMapper extends AbstractMapper<Team, TeamDto> {

}
