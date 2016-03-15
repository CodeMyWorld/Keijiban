package alex.dao.imp;

import org.springframework.stereotype.Repository;

import alex.dao.common.AbstractHibernateDao;
import alex.model.User;

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
	public UserDao() {
        super();
        setClass(User.class);
    }
}
