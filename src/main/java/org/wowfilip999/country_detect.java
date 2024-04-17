package org.wowfilip999;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class country_detect {
    public static String country_name="";
    public static String get ="";

    public void detect() throws IOException, URISyntaxException {
        FileUtils.copyURLToFile(new URL("https://www.mojeip.cz"),new File(System.getProperty("user.home") + File.separator + "index.html"));

        List<String> dat = FileUtils.readLines(new File(System.getProperty("user.home") + File.separator + "index.html"), String.valueOf(StandardCharsets.UTF_8));
        for(int a=0;a<137;a++) {

            if(a==136) {
                get = dat.get(a).replace("</font></b> ","");
                File read_index = new File(System.getProperty("user.home") + File.separator + "index.html");
                read_index.delete();
            }
        }



        URI jsonUrl = new URI("https://api.iplocation.net/?ip=" + String.valueOf(get).replace(" ",""));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         mapper.readValue(jsonUrl.toURL(), data.class);
         data get = new data();
        country_name=get.getCountry_name();




    }
}