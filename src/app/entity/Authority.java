package app.entity;

import javax.persistence.Entity;

import com.love320.zpro.entity.BaseEntity;

@Entity
public class Authority extends BaseEntity {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
