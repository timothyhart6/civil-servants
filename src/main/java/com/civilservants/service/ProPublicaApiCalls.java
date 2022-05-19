package com.civilservants.service;

import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
import com.civilservants.model.api.proPublica.PropublicaHouseMembers;
import com.civilservants.secrets.APIKeyStore;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProPublicaApiCalls {

    private static final String PROPUBLICA_API_KEY = APIKeyStore.getKey("PROPUBLICA_API");

    public ProPublicaHouseMember getPropublicaApiRepresentativesModel(String state, String districtCode) {
        String proPublicaRepresentativesUrl = "https://api.propublica.org/congress/v1/members/house/" + state + "/" + districtCode + "/current.json";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", PROPUBLICA_API_KEY);
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PropublicaHouseMembers> response = restTemplate.exchange(proPublicaRepresentativesUrl, HttpMethod.GET, entity, PropublicaHouseMembers.class);
        return response.getBody().getResults().get(0);
    }
}
