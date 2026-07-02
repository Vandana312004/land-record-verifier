package com.mysql.demo;

import javax.swing.*;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class LandGUI extends JFrame
implements ActionListener {

    JLabel titleLabel;
    JLabel idLabel;
    JLabel resultLabel;

    JTextField idField;

    JButton verifyButton;

    public LandGUI() {

        setTitle(
                "Land Record Verification System");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel =
                new JLabel(
                "LAND RECORD VERIFIER");

        titleLabel.setBounds(
                100, 30, 350, 30);

        titleLabel.setFont(
                new Font(
                "Arial",
                Font.BOLD,
                24));

        add(titleLabel);

        idLabel =
                new JLabel(
                "Enter Survey Number");

        idLabel.setBounds(
                50, 100, 180, 30);

        add(idLabel);

        idField =
                new JTextField();

        idField.setBounds(
                220, 100, 150, 30);

        add(idField);

        verifyButton =
                new JButton("Verify");

        verifyButton.setBounds(
                170, 170, 100, 35);

        add(verifyButton);

        resultLabel =
                new JLabel();

        resultLabel.setBounds(
                50, 240, 400, 100);

        add(resultLabel);

        verifyButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String surveyNumber =
                    idField.getText();

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

            resultLabel.setText(
                    "<html>"
                    + result.replace(
                    "\n",
                    "<br>")
                    + "</html>");

        } catch (Exception ex) {

            resultLabel.setText(
                    "Error : "
                    + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new LandGUI();
    }
}