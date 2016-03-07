package controllers;

import play.*;
import play.mvc.*;
import models.User;
import play.data.Form;
import views.html.*;
import views.html.result.*;
import java.util.List;
import models.*;

public class FormSubmit extends Controller {

    public Result userSubmit() {
        
        //get data from Userform 
        Form<User> userForm = Form.form(User.class);
        User filledForm = userForm.bindFromRequest().get();
        
        
        //Add data to User table
        UserEbean user = new UserEbean();
        user.mail = filledForm.mail;
        user.password = filledForm.password;
        user.nick = filledForm.nick;
        user.age = filledForm.age;
        user.sex = filledForm.sex;
        user.save();
 
        //save user session
        session("mail", user.mail);
    
        return ok(userres.render());
        
    }

}