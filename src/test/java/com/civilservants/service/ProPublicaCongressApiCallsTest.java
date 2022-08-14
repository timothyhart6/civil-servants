package com.civilservants.service;


import com.civilservants.model.api.proPublica.HouseMembers.ProPublicaHouseMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProPublicaCongressApiCallsTest {

    @Test
    public void testProPublicaHouseMemberIsReturned(){
        ProPublicaCongressApiCalls proPublicaCongressApiCalls = new ProPublicaCongressApiCalls();
        ProPublicaHouseMember actual = proPublicaCongressApiCalls.getPropublicaApiRepresentativesModel("MA", "3");
        Assertions.assertFalse(actual.getRole().isEmpty());
    }
}
