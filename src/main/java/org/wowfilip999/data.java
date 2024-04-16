package org.wowfilip999;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public  class data {
    @JsonIgnoreProperties(ignoreUnknown = true)

    private String ip_version; // Add this field
    public static String country_name; // Add this field


    // Getters and setters (optional but recommended)


    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}