package com.civilservants.model.api.proPublica;

import java.util.ArrayList;
import java.util.List;

public class PropublicaHouseMembers {
    private String status;
    private String copyright;
    private List<ProPublicaHouseMember> results = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<ProPublicaHouseMember> getResults() {
        return results;
    }

    public void setResults(List<ProPublicaHouseMember> results) {
        this.results = results;
    }
}
