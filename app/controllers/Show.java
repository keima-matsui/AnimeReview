package controllers;

import play.*;
import play.mvc.*;
import models.User;
import views.html.*;
import play.data.Form;
import views.html.result.*;
import views.html.signed.*;
import java.util.*;
import models.*;

public class Show extends Controller {

    public Result showhome() {

        //Get Anime List
        List<AniListEbean> aniList = AniListEbean.find.all();
        
        return ok(home.render(aniList,".jpg"));
    }
    
    
    public Result showRegist() {

        Form<User> userForm = Form.form(User.class);

        return ok(regist.render(userForm));
    }
    
    public Result showToSigned() {
        
        return ok(signed.render());
    }
    
    public Result showLogout() {

        //Get Anime List
        List<AniListEbean> aniList = AniListEbean.find.all();
        
        //remove user session
        session().remove("mail");

        return ok(home.render(aniList,".jpg"));
    }

}
