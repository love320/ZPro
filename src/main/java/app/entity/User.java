package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.love320.zpro.code.entity.BaseEntity;

//用户实体
@Entity
public class User extends BaseEntity {
	
	private String name;//用户名
	private String password;//密码
	private String email;//电子邮件
	
	private List<Role> roleList = new ArrayList<Role>();

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

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "USER_ROLE",
			joinColumns = { @JoinColumn(name = "USER_ID")}, 
			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") }
			)
	@Fetch(FetchMode.SUBSELECT)
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
