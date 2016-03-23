package alex.dao.imp;

import org.springframework.stereotype.Repository;

import alex.dao.common.AbstractHibernateDao;
import alex.model.User;

import java.util.List;

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
	public UserDao() {
        super();
        setClass(User.class);
    }

    @Override
    public boolean login(User user) {
        String username = user.getUsername();

        List<User> result = getCurrentSesstion().createQuery("from User U where U.username=" + username).list();
        if(result.size() == 0){
            return false;
        }else {
         if(!result.get(0).getPassword().equals(user.getPassword())){
             return false;
         }
        }
        return true;
    }
}
