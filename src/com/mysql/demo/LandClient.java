package com.mysql.demo;

import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class LandClient {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println(
                    "===== LAND RECORD VERIFIER =====");

            System.out.print(
                    "Enter Survey Number : ");

            String surveyNumber = sc.nextLine();

            URL url =
                    new URL(
                    "http://localhost:9091/landservice?wsdl");

            QName qname =
                    new QName(
                    "http://demo.mysql.com/",
                    "LandServiceService");

            Service service =
                    Service.create(url, qname);

            LandServiceInterface land =
                    service.getPort(
                    LandServiceInterface.class);

            String result =
                    land.verifyLand(surveyNumber);

            System.out.println("\nResult");
            System.out.println(result);

            sc.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}