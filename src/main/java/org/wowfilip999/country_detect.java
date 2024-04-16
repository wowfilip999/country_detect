package org.wowfilip999;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class country_detect {
    public static String country_name="";
    public static String get ="";
    public void detect() throws IOException, URISyntaxException {
        List<String> dat = FileUtils.readLines(new File("/home/filip/index.html"), String.valueOf(StandardCharsets.UTF_8));
        for(int a=0;a<200;a++) {

            if(a==136) {
                get = dat.get(a).replace("</font></b> ","");
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