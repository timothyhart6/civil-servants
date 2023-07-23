package com.civilservants.service;

import com.civilservants.model.api.proPublica.HouseMembers.ProPublicaHouseMember;
import com.civilservants.model.api.proPublica.HouseMembers.PropublicaHouseMembers;
import com.civilservants.model.api.proPublica.bills.PropublicaBill;
import com.civilservants.model.api.proPublica.bills.PropublicaBills;
import com.civilservants.secrets.APIKeyStore;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


public class ProPublicaCongressApiCalls {

    private static final String PROPUBLICA_API_KEY = APIKeyStore.getKey("PROPUBLICA_API");

    public ProPublicaHouseMember getPropublicaApiRepresentativesModel(String state, String districtCode) {
        ResponseEntity<PropublicaHouseMembers> response = null;
        try {
            String proPublicaRepresentativesUrl = "https://api.propublica.org/congress/v1/members/house/" + state + "/" + districtCode + "/current.json";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-Key", PROPUBLICA_API_KEY);
            final HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();

            response = restTemplate.exchange(proPublicaRepresentativesUrl, HttpMethod.GET, entity, PropublicaHouseMembers.class);
        } catch(Exception e) {
            System.out.println("Propublica Representatives call failed with error: " + e.getMessage());
        }
        return response.getBody().getResults().get(0);
    }

    public ArrayList<PropublicaBill> getRecentBills() {
        ResponseEntity<PropublicaBills> response = null;
        try {
            String url = "https://api.propublica.org/congress/v1/bills/search?sort=date";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-Key", PROPUBLICA_API_KEY);
            final HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.exchange(url, HttpMethod.GET, entity, PropublicaBills.class);
        } catch (Exception e) {
            System.out.println("Propublica Bills call failed with message: " + e.getMessage());
        }
        return response.getBody().results.get(0).bills;
    }
}
