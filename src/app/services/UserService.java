package app.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.entity.User;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Page;
import com.love320.zpro.services.BaseService;

//用户服务类
@Service
public class UserService extends BaseService<User> {
	
	public Page find(Page page,Map parameterMap){
		List<Filter> filters = Filter.parse(parameterMap);
		return super.find(page,filters);
	}
	
	public User get(Long id){
		return super.get(id);
	}

	public boolean save(User entity) {
		entity = super.add(entity);
		if(entity.getId() != null && entity.getId() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean update(User entity){
		return super.update(entity);
	}
	
	public boolean delete(Long id){
		User entity = new User();
		entity.setId(id);
		return super.delete(entity);
	}
	
}
