package alex.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import alex.dao.common.IOperations;
import alex.dao.imp.IUserDao;
import alex.model.User;
import alex.service.IUserService;
import alex.service.common.AbstractService;

@Service("userService")
public class UserService extends AbstractService<User> implements IUserService{
	
	@Resource(name="userDao")
	private IUserDao dao;
	
	public UserService(){
		super();
	}
	
	@Override
	protected IOperations<User> getDao(){
		return this.dao;
	}
}
