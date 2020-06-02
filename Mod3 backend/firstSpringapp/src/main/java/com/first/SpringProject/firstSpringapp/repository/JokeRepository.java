package com.first.SpringProject.firstSpringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.first.SpringProject.firstSpringapp.model.Joke;

@Repository
public interface JokeRepository extends JpaRepository <Joke, Long>{

}
