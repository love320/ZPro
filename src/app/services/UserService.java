package app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.User;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Page;
import com.love320.zpro.services.BaseService;

//用户服务类
@Service
public class UserService extends BaseService<User> {
	
	public Page findPage(Page page,List<Filter> filters){
		return find(page,filters);
	}
	
}
