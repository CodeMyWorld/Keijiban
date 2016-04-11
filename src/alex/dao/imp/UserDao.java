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
    public User login(User user) {
        String username = user.getUsername();
        String hql = "from User where username=:username";
        List<User> result = getCurrentSesstion().createQuery(hql).setString("username",username).list();
        if(result.size() == 0){
            return null;
        }else {
         if(!result.get(0).getPassword().equals(user.getPassword())){
             return null;
         }
        }
        return result.get(0);
    }

    @Override
    public List<User> search(String keyword) {
        String hql = "from User where username like :keyword";
        List<User> result = getCurrentSesstion().createQuery(hql).setString("keyword", "%"+keyword+"%").list();
        return result;
    }
}
