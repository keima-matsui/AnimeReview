package controllers;

import java.net.URL;
import play.*;
import play.mvc.*;
import views.html.*;
import views.html.result.*;
import views.html.signed.*;
import models.Anidata;
import models.AniListEbean;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;

public class GetAnime extends Controller {

    //get 2016 anime
    
    public Result Get2016() throws JsonParseException, JsonMappingException, IOException {
        
        //End point
            URL url = new URL("http://api.moemoe.tokyo/anime/v1/master/2016");

        ObjectMapper mapper = new ObjectMapper();

        Anidata[] ani = mapper.readValue(url, Anidata[].class);
        
        for (int i = 0; i < ani.length; i++){
            
            //Add data to User table
            AniListEbean anilist = new AniListEbean();
            anilist.ani_id = Integer.parseInt(ani[i].id);
            anilist.title = ani[i].title;
            anilist.save();
           
            //get image url
            String encodeStr = URLEncoder.encode(ani[i].title,"utf-8");
            ObjectMapper imgMapper = new ObjectMapper();
            JsonNode node = imgMapper.readTree(new URL("https://www.googleapis.com/customsearch/v1?key=AIzaSyDL8rjjZi7SpFJLo5xBty1MXdZi-OIXTss&cx=010654100926310393815:bovdshuej1s&searchType=image&q=" + encodeStr));
            String imgUrl = node.get("items").get(0).get("link").asText();
            System.out.println(imgUrl);
            //file downlaod
        
            InputStream in = null;
            OutputStream out = null;

            try {
                URL imgUrl2 = new URL(imgUrl);
                in = imgUrl2.openStream();
                out = new FileOutputStream("/Users/keima/Downloads/act/MyApp001/public/images/ani_image/" + ani[i].id + ".jpg");
                byte[] buf = new byte[1024];
                int len = 0;

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.flush();
            } catch (Exception e) {

            } finally {

                if (out != null) {
                    try {
                        out.close();
                  } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            if (in != null) {
             try {
                 in.close();
                } catch (IOException e) {
                 e.printStackTrace();
                }
         }
        }
          }
        
        
        
        
        
        
        return ok(index.render("Your new application is ready."));
        
    }

}
