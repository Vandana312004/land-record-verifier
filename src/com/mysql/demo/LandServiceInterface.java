package com.mysql.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface LandServiceInterface {

    @WebMethod
    public String verifyLand(String surveyNumber);
}