package com.civilservants.model;

public class HouseMember {

     private String firstName;
     private String lastName;
    private String role;
    private String nextElection;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNextElection() {
        return nextElection;
    }

    public void setNextElection(String nextElection) {
        this.nextElection = nextElection;
    }
}
