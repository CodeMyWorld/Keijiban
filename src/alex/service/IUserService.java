package alex.service;

import alex.dao.common.IOperations;
import alex.model.User;

import java.util.List;

public interface IUserService extends IOperations<User>{
     User login(User user);
     List<User> search(String keyword);
     void follow(User user, Integer followId);
}
