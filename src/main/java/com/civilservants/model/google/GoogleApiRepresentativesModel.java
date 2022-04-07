package com.civilservants.model.google;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GoogleApiRepresentativesModel{
    public NormalizedInput normalizedInput;
    public String kind;
    public Divisions divisions;
    public ArrayList<Office> offices;
    public ArrayList<Official> officials;
}

