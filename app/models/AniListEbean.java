package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;


@Entity
@Table(name = "ani_list")
public class AniListEbean extends Model {

	/**
	 * user id
	 */
	@Id
	@Column(name = "ani_id")
	public int ani_id;

	/**
	 * username
	 */
	@Column(name = "title")
	public String title;

	@Column(name = "story")
	public String story;
	
	@CreatedTimestamp
	public Date time;
	

	/**
	 * find
	 */
	public static Find<Long, AniListEbean> find = new Find<Long, AniListEbean>() {
	};

	/**
	 * get userid
	 *
	 * @return userid
	 */
	public int getAniId() {
		return ani_id;
	}

	/**
	 * user id conf
	 *
	 * @param userId
	 *            userid
	 */
	public void setAniId(int ani_id) {
		this.ani_id = ani_id;
	}

	/**
	 * username
	 *
	 * @return mail
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * username conf
	 *
	 * @param userName
	 *            username
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *  story
	 *
	 * @return story
	 */
	public String getStory() {
		return story;
	}
	
	
	/**
	 * Story
	 *
	 * @param Story
	 *            
	 */
	public void setStory(String story) {
		this.story = story;
	}
	
		/**
	 *  time
	 *
	 * @return time
	 */
	public Date getTime() {
		return time;
	}
	
	
	/**
	 * Time
	 *
	 * @param Time
	 *            
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * get find
	 *
	 * @return find
	 */
	public static Find<Long, AniListEbean> getFind() {
		return find;
	}

	/**
	 * find conf
	 *
	 * @param find
	 *            find
	 */
	public static void setFind(Find<Long, AniListEbean> find) {
		AniListEbean.find = find;
	}
}