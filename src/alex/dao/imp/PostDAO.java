package alex.dao.imp;

import alex.dao.common.AbstractHibernateDao;
import alex.model.Post;

/**
 * Created by alex on 16-3-23.
 */
public class PostDAO extends AbstractHibernateDao<Post> implements IPostDao {
    public PostDAO() {
        super();
        setClass(Post.class);
    }
}
