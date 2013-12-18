package app.services;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import app.entity.Role;
import app.entity.User;

import com.love320.zpro.code.bean.Page;
import com.love320.zpro.code.services.BaseService;

@Service
public class RoleService extends BaseService<Role> {
	
	public List findAll(){
		return super.list();
	}
	
	public Page find(Page page,Map parameterMap){
		return super.find(page,parameterMap);
	}
	
	public Role get(Long id){
		return super.get(id);
	}

	public boolean save(Role entity) {
		entity = super.add(entity);
		if(entity.getId() != null && entity.getId() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean update(Role entity){
		return super.update(entity);
	}
	
	public boolean saveOrUdate(Role entity){
		return super.saveOrUdate(entity);
	}
	
	public boolean delete(Long id){
		Role entity = new Role();
		entity.setId(id);
		return super.delete(entity);
	}
	
}
