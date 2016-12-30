package com.thefantasyhof;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public final class Utilities {
    private Utilities() {}

    public String getJSON() {
        String url = "https://agile-badlands-78491.herokuapp.com/getLeagueDataJSON?leagueId=44169";
        String charset = "UTF-8";

        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream response = new URL(url).openStream();

            StringWriter writer = new StringWriter();
            IOUtils.copy(response, writer);
            String responseString = writer.toString();

            DataConsumer dc = new DataConsumer(responseString);
            dc.tabulateData();

            return "";
        } catch (Exception e){ return "HTTP GET Failed!"; }
    }
}