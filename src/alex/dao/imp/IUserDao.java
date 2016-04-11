package alex.dao.imp;

import alex.model.User;
import alex.dao.common.IOperations;

import java.util.List;

public interface IUserDao extends IOperations<User> {
    User login(User user);
    List<User> search(String keyword);
}
