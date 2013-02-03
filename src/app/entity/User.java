package app.entity;

import javax.persistence.Entity;

import com.love320.zpro.entity.BaseEntity;

//用户实体
@Entity
public class User extends BaseEntity {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
