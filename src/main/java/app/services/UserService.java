package app.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.entity.Role;
import app.entity.User;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Page;
import com.love320.zpro.services.BaseService;

//用户服务类
@Service
public class UserService extends BaseService<User> {
	
	public Page find(Page page,Map parameterMap){
		return super.find(page,parameterMap);
	}
	
	public User findByName(String name){
		String hql =" from User where name = ? ";
		List list = getSession().createQuery(hql).setParameter(0, name).list();
		if(list != null && list.size() == 1){
			return (User) list.get(0);
		}else{
			return null;
		}
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
	
	public boolean saveOrUdate(User entity){
		return super.saveOrUdate(entity);
	}
	
}
