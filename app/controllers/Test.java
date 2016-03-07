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

public class Test extends Controller {

    //get 2016 anime
    
    public Result Test20() throws JsonParseException, JsonMappingException, IOException {
        
            //file downlaod
        
            InputStream in = null;
            OutputStream out = null;

            try {
                URL imgUrl2 = new URL("https://i.ytimg.com/vi/YMqu-iHKaT0/maxresdefault.jpg");
                in = imgUrl2.openStream();
                out = new FileOutputStream("/Users/keima/Downloads/act/MyApp001/public/images/ani_image/9982.jpg");
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
    
          
    
        
        
        
        
        
        
        return ok(index.render("Your new application is ready."));
        
    }

}
