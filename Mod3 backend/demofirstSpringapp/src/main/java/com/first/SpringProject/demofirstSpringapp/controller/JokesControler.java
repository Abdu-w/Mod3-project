package com.first.SpringProject.demofirstSpringapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.SpringProject.demofirstSpringapp.exception.ResourceNotFoundException;
import com.first.SpringProject.demofirstSpringapp.model.Joke;
import com.first.SpringProject.demofirstSpringapp.repository.EmployeeRepository;

@RestController

@RequestMapping("/first_api/v1" )
public class JokeControler {
	
	@Autowired
	private JokeControler jokeControler;
	

	@GetMapping("/jokes")
	public List<Joke> getAllJokes(Model model){
		return this.employeeRepository.findAll();
		
	}
	
	@GetMapping("/joke/{id}")
	public ResponseEntity<Joke> getJokeById(@PathVariable(value="id") Long jokeId)
	throws ResourceNotFoundException{
		Joke joke = jokeRepository.findById(jokeId)
				.orElseThrow(()-> new ResourceNotFoundException("joke not found for this id ::"+
		jokeId));
		return ResponseEntity.ok().body(joke);
	}
	

	@PostMapping("/joke")
	public Joke CreateJoke(@Valid @RequestBody Joke joke) {
		return jokeRepository.save(joke);
	}
	

	@PutMapping("/joke/{id}")
	public ResponseEntity<Joke> updateJoke(@PathVariable(value = "id") Long jokeId,
			  @Valid @RequestBody Joke jokeDetails)
		      throws ResourceNotFoundException {
		      Joke joke = jokeRepository.findById(jokeId)
		    		  .orElseThrow(()-> new ResourceNotFoundException("joke not found for this id :: " + jokeId));
		      
		      
		     joke.setJoke(jokeDetails.getjoke());
		     joke.setlastName(jokeDetails.getpunch_line());
		     
		     
		     final Joke updatedJoke = jokeRepository.save(joke);
		     
		     
		     return ResponseEntity.ok(updatedJoke);
	}
	  
  @DeleteMapping("/joke/{id}")
  public Map<String, Boolean> deletedJoke(@PathVariable(value = "id") Long jokeId)
			      throws ResourceNotFoundException {
			      Joke joke = jokeRepository.findById(jokeId)
			    		  .orElseThrow(()-> new ResourceNotFoundException("joke not found for this id :: " + employeeId));
  
			      jokeRepository.delete(joke);
			      Map<String, Boolean> response = new HashMap<>();
			      
			      response.put("deleted joke", Boolean.TRUE);
			      
			      return response;
  
  }
	

}
