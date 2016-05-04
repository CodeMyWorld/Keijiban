package alex.service.imp;

import javax.annotation.Resource;

import alex.dao.imp.IFollowDao;
import alex.model.Follow;
import org.springframework.stereotype.Service;

import alex.dao.common.IOperations;
import alex.dao.imp.IUserDao;
import alex.model.User;
import alex.service.IUserService;
import alex.service.common.AbstractService;

import java.util.List;

@Service("userService")
public class UserService extends AbstractService<User> implements IUserService{
	
	@Resource(name="userDao")
	private IUserDao dao;

	@Resource(name="followDao")
	private IFollowDao followDao;

	
	public UserService(){
		super();
	}
	
	@Override
	protected IOperations<User> getDao(){
		return this.dao;
	}

	public User login(User user){
		return dao.login(user);
	}

	@Override
	public List<User> search(String keyword) {
		return dao.search(keyword);
	}

	@Override
	public void follow(User user, Integer followId) {
		Follow follow = new Follow();
		follow.setUser(user);
		follow.setFollowId(followId);
		followDao.create(follow);
	}
}
