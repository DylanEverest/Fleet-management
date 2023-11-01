package com.fleetmanagement.fleet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleetmanagement.fleet.Entities.User;

public interface UserRepository extends JpaRepository<User ,Long> {
    
}
