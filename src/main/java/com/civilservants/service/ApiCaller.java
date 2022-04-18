package com.civilservants.service;

import java.util.ArrayList;

public class ApiCaller {
    public static ArrayList<Object> apiCallsForDistrict(String streetAddress, String zipCode) {
        ArrayList<Object> apiCalls = new ArrayList<>();
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        apiCalls.add(googleApiCalls.FetchHouseMember(streetAddress, zipCode));


    }
}
