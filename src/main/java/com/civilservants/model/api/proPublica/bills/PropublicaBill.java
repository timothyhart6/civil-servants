package com.civilservants.model.api.proPublica.bills;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class PropublicaBill {
    public String bill_id;
    public String bill_slug;
    public String bill_type;
    public String number;
    public String bill_uri;
    public String title;
    public String short_title;
    public String sponsor_title;
    public String sponsor_id;
    public String sponsor_name;
    public String sponsor_state;
    public String sponsor_party;
    public String sponsor_uri;
    public Object gpo_pdf_uri;
    public String congressdotgov_url;
    public String govtrack_url;
    public String introduced_date;
    public boolean active;
    public String last_vote;
    public String house_passage;
    public String senate_passage;
    public Object enacted;
    public Object vetoed;
    public int cosponsors;
    public CosponsorsByParty cosponsors_by_party;
    public String committees;
    public ArrayList<String> committee_codes;
    public ArrayList<String> subcommittee_codes;
    public String primary_subject;
    public String summary;
    public String summary_short;
    public String latest_major_action_date;
    public String latest_major_action;

}
