package com.civilservants.model.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Divisions {
    @JsonProperty("ocd-division/country:us")
    public OcdDivisionCountry ocdDivisionCountry;
    @JsonProperty("ocd-division/country:us/state:oh/county:franklin")
    public OcdDivisionCountryStateCounty ocdDivisionCountryStateCounty;
    @JsonProperty("ocd-division/country:us/state:oh")
    public OcdDivisionCountryState ocdDivisionCountryState;
    @JsonProperty("ocd-division/country:us/state:oh/cd:15")
    public OcdDivisionCountryStateCd ocdDivisionCountryStateCd;
    @JsonProperty("ocd-division/country:us/state:oh/place:columbus")
    public OcdDivisionCountryStatePlace ocdDivisionCountryStatePlace;
}
