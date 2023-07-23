package com.civilservants.service;

import com.civilservants.model.api.proPublica.votes.recentVotes.RecentVotes;
import com.civilservants.model.api.proPublica.votes.recentVotes.Vote;
import com.civilservants.model.api.proPublica.votes.specificRollCallVote.SpecificRollCallVote;
import com.civilservants.model.api.proPublica.votes.specificRollCallVote.Votes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.civilservants.secrets.APIKeyStore;

import java.util.ArrayList;


public class PropublicaVotesApiCalls {

    private static final String PROPUBLICA_API_KEY = APIKeyStore.getKey("PROPUBLICA_API");

    public ArrayList<Vote> getRecentVotes(String chamber) {
        ResponseEntity<RecentVotes> response = null;
        try {
            String url = "https://api.propublica.org/congress/v1/" + chamber + "/votes/recent.json";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-Key", PROPUBLICA_API_KEY);
            final HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();

            response = restTemplate.exchange(url, HttpMethod.GET, entity, RecentVotes.class);
        } catch(Exception e) {
            System.out.println("Propublica RecentVotes call failed with message: " + e.getMessage());
        }
        return response.getBody().results.votes;
    }

    public Votes getSpecificRollCallVotes(String congress, String chamber, String sessionNumber, String rollCallNumber) {
        ResponseEntity<SpecificRollCallVote> response = null;
        try {
            String url = "https://api.propublica.org/congress/v1/" + congress + "/" + chamber + "/sessions/" + sessionNumber + "/votes/" + rollCallNumber + ".json";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-Key", PROPUBLICA_API_KEY);
            final HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.exchange(url, HttpMethod.GET, entity, SpecificRollCallVote.class);
        } catch (Exception e) {
            System.out.println("Propublica RollCall call failed with message: " + e.getMessage());
        }
        return response.getBody().results.votes;
    }
}
