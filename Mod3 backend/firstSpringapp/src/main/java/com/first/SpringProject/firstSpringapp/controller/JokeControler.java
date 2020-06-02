package com.first.SpringProject.firstSpringapp.controller;

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

import com.first.SpringProject.firstSpringapp.exception.ResourceNotFoundException;
import com.first.SpringProject.firstSpringapp.model.Joke;
import com.first.SpringProject.firstSpringapp.repository.JokeRepository;

@RestController
//endpoint or url
//@RequestMapping("/api/v1" ) example
@RequestMapping("/first_api/v1" )
public class JokeControler {
	
	@Autowired
	private JokeRepository jokeRepository;
	
	
	
	//get all jokes
	@GetMapping("/jokes")
	public List<Joke> getAllJokes(Model model){
		return this.jokeRepository.findAll();
		
	}
	
	@GetMapping("/jokes/{id}")
	public ResponseEntity<Joke> getJokeById(@PathVariable(value="id") Long jokeId)
	throws ResourceNotFoundException{
		Joke joke = jokeRepository.findById(jokeId)
				.orElseThrow(()-> new ResourceNotFoundException("Joke not found for this id ::"+
		jokeId));
		return ResponseEntity.ok().body(joke);
	}
	
	//save joke
	@PostMapping("/jokes")
	public Joke CreateJoke(@Valid @RequestBody Joke joke) {
		return jokeRepository.save(joke);
	}
	
	//update  Joke
	@PutMapping("/jokes/{id}")
	public ResponseEntity<Joke> updateJoke(@PathVariable(value = "id") Long jokeId,
			  @Valid @RequestBody Joke jokeDetails)
		      throws ResourceNotFoundException {
		      Joke joke = jokeRepository.findById(jokeId)
		    		  .orElseThrow(()-> new ResourceNotFoundException("Joke not found for this id :: " + jokeId));
		      
		      
		     joke.setjkType(jokeDetails.getjkType()); 
		     joke.setjoke(jokeDetails.getjoke());
		     joke.setpunchLine(jokeDetails.getpunchLine());
		     
		     
		     final Joke updatedJoke = jokeRepository.save(joke);
		     
		     
		     return ResponseEntity.ok(updatedJoke);
	}
	//  Delete Joke
	  
  @DeleteMapping("/jokes/{id}")
  public Map<String, Boolean> deletedJoke(@PathVariable(value = "id") Long jokeId)
			      throws ResourceNotFoundException {
			      Joke joke = jokeRepository.findById(jokeId)
			    		  .orElseThrow(()-> new ResourceNotFoundException("Joke not found for this id :: " + jokeId));
  
			      jokeRepository.delete(joke);
			      Map<String, Boolean> response = new HashMap<>();
			      
			      response.put("deleted joke", Boolean.TRUE);
			      
			      return response;
  
  }
	

}
