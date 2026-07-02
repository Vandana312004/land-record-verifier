package com.mysql.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jws.WebService;

@WebService(endpointInterface = "com.mysql.demo.LandServiceInterface")

public class LandService implements LandServiceInterface {

    @Override
    public String verifyLand(String surveyNumber) {

        String result = "Record Not Found";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                    "SELECT * FROM records WHERE survey_number=?");

            ps.setString(1, surveyNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                result =
                        "Owner Name : "
                        + rs.getString("owner_name")

                        + "\nSurvey Number : "
                        + rs.getString("survey_number")

                        + "\nVillage : "
                        + rs.getString("village")

                        + "\nLand Area : "
                        + rs.getString("land_area");
            }

            con.close();

        } catch (Exception e) {

            result = e.toString();
        }

        return result;
    }
}