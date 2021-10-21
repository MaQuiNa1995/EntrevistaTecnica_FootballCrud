package com.github.christian.football.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.christian.football.dto.TeamDto;

@RestController
@RequestMapping("/team")
public class TeamController extends AbstractWebserviceController<Long, TeamDto> {

}
