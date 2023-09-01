package com.example.demo.controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Team;
import com.example.demo.exception.TeamNotFoundException;
import com.example.demo.repository.ITeamRepository;
import com.example.demo.service.ITeamService;

@RestController
@RequestMapping("/Team")
@CrossOrigin("http://localhost:4200")
public class TeamController {
	
	@Autowired
	 ITeamRepository teamRepo;
	@Autowired
	ITeamService teamService;

	@Autowired
	 RestTemplate restTemplate;
	private static Logger logger = LogManager.getLogger();

	@PostMapping("/add")// localhost:8761/TeamMember/addTeamMember
	ResponseEntity<Team> addTeam(@RequestBody Team team){
		Team newTeam = teamService.addTeam(team);
		return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
	}

	/*
	 * public Team addTeam(@RequestBody Team team) {
	 * 
	 * 
	 * return teamService.addTeam(team);
	 * 
	 * }
	 */
	
	
	@GetMapping("/getTeam") // localhost:8761/Team/allTeammembers
	public List<Team> getTeamById() throws TeamNotFoundException{
		return teamService.getAllTeams();
	}
	
	
	@DeleteMapping("/delete/{teamId}")
	ResponseEntity<Team> deleteTeamById(@PathVariable int teamId) throws TeamNotFoundException{
	logger.info("Request to delete a team");
	Team deletedTeam = teamService.deleteTeamById(teamId);
	logger.info("Successfully deleted a team");
	return new ResponseEntity<>(deletedTeam,HttpStatus.OK);

	}
	
}

