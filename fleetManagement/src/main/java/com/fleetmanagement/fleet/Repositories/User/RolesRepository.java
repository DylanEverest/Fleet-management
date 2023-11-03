package com.fleetmanagement.fleet.Repositories.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleetmanagement.fleet.Entities.User.Roles;

public interface RolesRepository extends JpaRepository<Roles ,Integer>{

    Optional<Roles> findByName(String name);
}
