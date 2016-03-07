package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;


@Entity
@Table(name = "ani_user")
public class UserEbean extends Model {

	/**
	 * user id
	 */
	@Id
	@Column(name = "user_id")
	public String userId;

	/**
	 * username
	 */
	@Column(name = "mail")
	public String mail;

	/**
	 * password
	 */
	@Column(name = "password")
	public String password;

	/**
	 * nick
	 */
	@Column(name = "nick")
	public String nick;

	/**
	 * age
	 */
	@Column(name = "age")
	public int age;

	/**
	 * sex
	 */
	@Column(name = "sex")
	public int sex;


	/**
	 * find
	 */
	public static Find<Long, UserEbean> find = new Find<Long, UserEbean>() {
	};

	/**
	 * get userid
	 *
	 * @return userid
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * user id conf
	 *
	 * @param userId
	 *            userid
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * username
	 *
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * username conf
	 *
	 * @param userName
	 *            username
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * get password
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password conf
	 *
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get nick
	 *
	 * @return nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * nick
	 *
	 * @param nick
	 *            
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * get age
	 *
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * age
	 *
	 * @param age
	 *            
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
		/**
	 * get age
	 *
	 * @return age
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * age
	 *
	 * @param age
	 *            
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * get find
	 *
	 * @return find
	 */
	public static Find<Long, UserEbean> getFind() {
		return find;
	}

	/**
	 * find conf
	 *
	 * @param find
	 *            find
	 */
	public static void setFind(Find<Long, UserEbean> find) {
		UserEbean.find = find;
	}
}