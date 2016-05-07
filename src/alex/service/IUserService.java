package alex.service;

import alex.dao.common.IOperations;
import alex.model.User;

import java.util.List;

public interface IUserService extends IOperations<User>{
     User login(User user);
     List<User> search(String keyword, Integer userId);
     void follow(User user, Integer followId);
     List<User> getFollowing(Integer userId);
     void unfollow(int userid, int followid);
     User register(String username, String password);
}
