package controllers;

import java.net.URL;
import play.*;
import play.mvc.*;
import views.html.*;
import views.html.result.*;
import views.html.signed.*;
import models.Anidata;
import models.AniListEbean;
import twitter4j.conf.ConfigurationBuilder;
import com.avaje.ebean.SqlUpdate;
import twitter4j.*;
import java.util.*;

public class GetStory extends Controller {
    
    //get 2016 anime
    
    public Result GetStory2016() throws TwitterException{
        //Config Twitter4j
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey("wf7Eg3XE2ChXKXtPgRHAlj9pS")
        .setOAuthConsumerSecret("EYsCRB1T4gJVHcxPYWAg5WC2NU6t8mCzbOqRHvEMMgQ7tO4YgY")
        .setOAuthAccessToken("315751194-uzMD1GI2GLJLi7OG9oPe3fZeOmFrYXSiRx4LGVn5")
        .setOAuthAccessTokenSecret("DRD4uzefZzUuCn8P03BrFAU4xqfBZUwgq9DDJ80CQ5NYN");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        //Making Query
        int story = 1;
        int flg = 0;
        String str = "";
        Query query = new Query();
        List<AniListEbean> aniList = AniListEbean.find.all();
        
        for (AniListEbean data : aniList) {
            flg = 0;
            str = "";
            
            long id = data.getAniId();
            if(data.getStory() == null){
                story = 1;
            }else{
                story = Integer.parseInt(data.getStory());
            }

            while(flg == 0){
                System.out.println(data.getTitle() + "　アニメ　感想　" + story + "話");
                query.setQuery(data.getTitle() + "アニメ　感想" + story + "話");
                query.setResultType(query.RECENT);
                query.setCount(100);
                query.since("2014-12-12");
                query.until("2016-03-07");
                QueryResult result = twitter.search(query);
                System.out.println(result.getTweets().size());
                if(result.getTweets().size() > 1){
                    story++;
                }else{
                    story++;
                    flg = 1;
                }
            
            AniListEbean que = AniListEbean.find.byId(id);
            str = "" + story;
            que.story = str;
            que.update();
            
            }
		}
        
        return ok(index.render("Your new application is ready."));
        
    }

}
