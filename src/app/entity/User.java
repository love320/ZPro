package app.entity;

import javax.persistence.Entity;

import com.love320.zpro.entity.BaseEntity;

//用户实体
@Entity
public class User extends BaseEntity {
	
	private String name;//用户名
	private String password;//密码
	private String email;//电子邮件

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
