package com.example.demo.repos;

import com.example.demo.domain.Camera;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CameraRepo extends CrudRepository<Camera, Long> {
    Camera findByName(String name);
    Camera findById(Integer id);
}