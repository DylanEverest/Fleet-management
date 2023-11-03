package com.fleetmanagement.fleet.Entities.User;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(nullable = false ,updatable = true)
    private String roleName ;

    @Column(nullable = false , updatable=true)
    private double hierarchyLevel ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(double hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }
}
