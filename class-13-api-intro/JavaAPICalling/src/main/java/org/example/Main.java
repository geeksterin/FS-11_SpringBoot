package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String myUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";


        HttpURLConnection connection = null;
        int responseCode = 0;
        URL  url = null;
        try {
            url = new URL(myUrl);
        } catch (MalformedURLException e) {
            System.out.println("Something is wrong with the URL");
        }

        //Connection :

        try {
            connection = (HttpURLConnection)url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(responseCode==200)
        {
            try {
                BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            System.out.println("api call not successful!!");
        }

    }
}