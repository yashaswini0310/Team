package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Team;
import com.example.demo.exception.TeamNotFoundException;
import com.example.demo.repository.ITeamRepository;

@Service
public class TeamServiceImpl implements ITeamService{
	
	@Autowired
	ITeamRepository teamRepo;
	
	@Override
	public Team addTeam(Team t)  {
			return teamRepo.save(t);
		
		
	}

	@Override
	public Team deleteTeamById(int tId) throws TeamNotFoundException {
		Optional<Team> teamOpt = teamRepo.findById(tId);
		if(teamOpt.isPresent()) {
		
			Team deletedTeam = teamOpt.get();
			teamRepo.deleteById(tId);
			return deletedTeam;
		}else {
			throw new TeamNotFoundException("Team not found with id: "+tId);
		}

		
		
	}

	@Override
	public Team getTeamById(int tId) throws TeamNotFoundException {
		
		Optional<Team> teamOpt = teamRepo.findById(tId);
		if(teamOpt.isPresent()) {
			
		
		Team team = teamOpt.get();
		return team;
		}else {
			throw new TeamNotFoundException("Team not found with id: "+tId );
		}
		
		
}
	@Override
	public List<Team> getAllTeams() {
		List<Team> getallteams = teamRepo.findAll();
		return getallteams;
	}
	
}