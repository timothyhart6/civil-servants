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

    private static final String PROPUBLICA_API = APIKeyStore.getKey("PROPUBLICA_API");

    public void FetchHouseMember(String address, String zipCode){
//        PropublicaHouseMembers propublicaHouseMembers = getPropublicaApiRepresentativesModel(address, zipCode);

    }

    public ProPublicaHouseMember getPropublicaApiRepresentativesModel(String state, String districtCode) {
        String proPublicaRepresentativesUrl = "https://api.propublica.org/congress/v1/members/house/" + state + "/" + districtCode + "/current.json";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", PROPUBLICA_API);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PropublicaHouseMembers> response = restTemplate.exchange(proPublicaRepresentativesUrl, HttpMethod.GET, entity, PropublicaHouseMembers.class);
        return response.getBody().getResults().get(0);
    }

}
