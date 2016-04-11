package alex.dao.imp;

import alex.dao.common.AbstractHibernateDao;
import alex.model.Follow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 16-4-11.
 */
@Repository("followDao")
public class FollowDao extends AbstractHibernateDao<Follow> implements IFollowDao{
    public FollowDao(){
        super();
        setClass(Follow.class);
    }
    @Override
    public List<Integer> getFollowList(Integer userid) {
        String hql = "select followId from Follow where userid= :userid";
        List<Integer> result = getCurrentSesstion().createQuery(hql).setInteger("userid", userid).list();
        result.add(userid);
        return result;
    }


}
