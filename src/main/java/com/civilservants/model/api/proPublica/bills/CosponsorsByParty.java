package com.civilservants.model.api.proPublica.bills;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CosponsorsByParty {
    @JsonProperty("R")
    public int r;
    @JsonProperty("D")
    public int d;
}
