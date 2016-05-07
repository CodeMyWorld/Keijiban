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

import java.util.ArrayList;
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
	public List<User> search(String keyword, Integer userId) {
		return dao.search(keyword, userId);
	}

	@Override
	public void follow(User user, Integer followId) {
		Follow follow = new Follow();
		follow.setUser(user);
		follow.setFollowId(followId);
		followDao.create(follow);
	}

	@Override
	public List<User> getFollowing(Integer userId) {
		List<Integer> followList = followDao.getFollowList(userId);
		List<User> following = new ArrayList<>();
		for(Integer id : followList){
			following.add(dao.findOne(id));
		}
		return following;
	}

	@Override
	public void unfollow(int userid, int followid) {
		Follow deletedFollow = followDao.getFollow(userid, followid);
		followDao.delete(deletedFollow);
	}

	@Override
	public User register(String username, String password) {
		if(dao.queryList("username", username).size() == 0){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			dao.create(user);
			return user;
		}
		return null;
	}


}
