package org.wowfilip999;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class country_detect {
    public static String country_name="";
    private String get ="";
    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void detect() throws IOException, URISyntaxException {
        URL get_ip = new URL("https://www.mojeip.cz");
        ReadableByteChannel read_web = Channels.newChannel(get_ip.openStream());
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + File.separator + "index.html");
        fos.getChannel().transferFrom(read_web, 0, Long.MAX_VALUE);

        FileReader r = new FileReader(new File(System.getProperty("user.home") + File.separator + "index.html"));
        Scanner r_get = new Scanner(r);
        for(int a=0;a<137;a++) {
            r_get.nextLine();

            if(a==135) {
                get = r_get.nextLine().replace("</font></b> ","");
                File read_index = new File(System.getProperty("user.home") + File.separator + "index.html");
                read_index.delete();
            }
        }

        URI jsonUrl = new URI("https://api.iplocation.net/?ip=" + String.valueOf(get).replace(" ",""));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         mapper.readValue(jsonUrl.toURL(), country_detect.class);
        country_name=country_detect.country_name;




    }
}