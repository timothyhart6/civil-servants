package com.civilservants.service;

import com.civilservants.model.HouseMember;
import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import com.civilservants.model.api.proPublica.PropublicaHouseMembers;
import com.civilservants.secrets.APIKeyStore;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class ProPublicaApiCalls {

    private static final String PROPUBLICA_API = APIKeyStore.getKey("PROPUBLICA_API");

    public void FetchHouseMember(String address, String zipCode){
        PropublicaHouseMembers propublicaHouseMembers = getPropublicaApiRepresentativesModel(address, zipCode);

    }

    private PropublicaHouseMembers getPropublicaApiRepresentativesModel(String address, String zipCode) {
        String googleRepresentativesUrl = "https://api.propublica.org/congress/v1/members/house/OH/15/current.json";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", "PROPUBLICA_API");

        return restTemplate.getForObject(googleRepresentativesUrl, PropublicaHouseMembers.class);
    }

}
