package com.civilservants.model.api.proPublica.HouseMembers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
public class ProPublicaHouseMember {

    private String id;
    private String name;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "middle_name")
    private String middleName;

    @JsonProperty(value = "last_name")
    private String lastName;

    private String suffix;
    private String role;
    private String gender;
    private String party;

    @JsonProperty(value = "times_topics_url")
    private String timesTopicsUrl;

    @JsonProperty(value = "twitter_id")
    private String twitterId;

    @JsonProperty(value = "facebook_account")
    private String facebookAccount;

    @JsonProperty(value = "youtube_id")
    private String youtubeId;

    private String seniority;

    @JsonProperty(value = "next_election")
    private String nextElection;

    @JsonProperty(value = "api_uri")
    private String apiUri;

    private String district;

    @JsonProperty(value = "at_large")
    private Boolean atLarge;
}
