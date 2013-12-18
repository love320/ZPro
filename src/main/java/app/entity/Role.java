package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.love320.zpro.code.entity.BaseEntity;

@Entity
public class Role extends BaseEntity {

	private String name;
	
	private List<Authority> authorityList = new ArrayList<Authority>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "ROLE_AUTHORITY",
			joinColumns = { @JoinColumn(name = "ROLE_ID")}, 
			inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") }
			)
	@Fetch(FetchMode.SUBSELECT)
    @OrderBy("id desc")
	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}
	
	
	
}
