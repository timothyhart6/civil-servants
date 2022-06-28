package com.civilservants.service;


import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProPublicaApiCallsTest {

    @Test
    public void testProPublicaHouseMemberIsReturned(){
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        ProPublicaHouseMember actual = proPublicaApiCalls.getPropublicaApiRepresentativesModel("MA", "3");
        Assertions.assertFalse(actual.getRole().isEmpty());
    }
}
