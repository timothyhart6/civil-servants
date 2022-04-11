package com.civilservants.model;

public class HouseMember {

    final private String firstName;
    final private String lastName;

    public HouseMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
