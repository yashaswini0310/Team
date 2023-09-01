package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Team;
import com.example.demo.exception.TeamNotFoundException;

public interface ITeamService {
	Team addTeam(Team t);
	Team deleteTeamById(int tId) throws TeamNotFoundException;
	Team getTeamById(int tId) throws TeamNotFoundException;
	List<Team> getAllTeams();

}
