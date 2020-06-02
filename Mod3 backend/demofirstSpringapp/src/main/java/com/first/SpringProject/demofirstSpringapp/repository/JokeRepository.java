package com.first.SpringProject.demofirstSpringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.first.SpringProject.demofirstSpringapp.model.Joke;

@Repository
public interface JokeRepository extends JpaRepository <Joke, Long>{

}
