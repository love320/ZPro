package app.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.entity.Authority;

import com.love320.zpro.bean.Page;
import com.love320.zpro.services.BaseService;

@Service
public class AuthorityService extends BaseService<Authority> {
	
	public List list(){
		return super.list();
	}
	
	public Page find(Page page,Map parameterMap){
		return super.find(page,parameterMap);
	}
	
	public Authority get(Long id){
		return super.get(id);
	}

	public boolean save(Authority entity) {
		entity = super.add(entity);
		if(entity.getId() != null && entity.getId() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean update(Authority entity){
		return super.update(entity);
	}
	
	public boolean saveOrUdate(Authority entity){
		return super.saveOrUdate(entity);
	}
	
	public boolean delete(Long id){
		Authority entity = new Authority();
		entity.setId(id);
		return super.delete(entity);
	}

}
