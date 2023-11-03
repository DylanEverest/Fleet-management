package com.fleetmanagement.fleet.Repositories.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fleetmanagement.fleet.Entities.User.User;

public interface UserRepository extends JpaRepository<User ,Long> 
{
    

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    Optional<User> findByUserName(@Param("UserName") String UserName);
    

    Boolean existsByUserName(@Param("UserName") String UserName) ;

}
