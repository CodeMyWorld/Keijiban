package alex.dao.imp;

import org.springframework.stereotype.Repository;

import alex.dao.common.AbstractHibernateDao;
import alex.model.User;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
	public UserDao() {
        super();
        setClass(User.class);
    }

    @Resource(name="followDao")
    private IFollowDao followDao;

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
    public List<User> search(String keyword, Integer userId) {
        List<Integer> followList = followDao.getFollowList(userId);
        String hql = "from User where username like :keyword and id not in (:followList)";
        List<User> result = getCurrentSesstion().createQuery(hql).setString("keyword", "%"+keyword+"%")
                .setParameterList("followList", followList)
                .list();
        return result;
    }
}
