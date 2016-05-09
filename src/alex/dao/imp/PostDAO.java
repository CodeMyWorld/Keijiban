package alex.dao.imp;

import alex.dao.common.AbstractHibernateDao;
import alex.model.Post;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 16-3-23.
 */
@Repository("postDAO")
public class PostDAO extends AbstractHibernateDao<Post> implements IPostDao {
    public PostDAO() {
        super();
        setClass(Post.class);
    }

    @Resource(name="followDao")
    private IFollowDao followDao;

    @Override
    public List<Post> getFollowPost(Integer userid, Integer page) {
        String hql = "from Post where userid in (:followList) order by time desc ";
        List<Integer> followList = followDao.getFollowList(userid);
        List<Post> result = getCurrentSesstion().createQuery(hql).setParameterList("followList",followList)
                .setFirstResult((page-1)*10)
                .setMaxResults(10)
                .list();
        System.out.println(followList.size()+" "+result.size());
        return result;
    }

    @Override
    public int getPage(Integer userid) {
        String hql = "from Post where userid in (:followList)";
        List<Integer> followList = followDao.getFollowList(userid);
        int result = getCurrentSesstion().createQuery(hql).setParameterList("followList",followList)
                .list().size();
        return result/10+1;
    }
}
