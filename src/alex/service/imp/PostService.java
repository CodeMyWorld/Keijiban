package alex.service.imp;

import alex.dao.common.IOperations;
import alex.dao.imp.IFollowDao;
import alex.dao.imp.IPostDao;
import alex.model.Post;
import alex.service.IPostService;
import alex.service.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 16-3-23.
 */

@Service("postService")
public class PostService extends AbstractService<Post> implements IPostService{
    @Resource(name="postDAO")
    private IPostDao dao;



    public PostService(){
        super();
    }

    @Override
    protected IOperations<Post> getDao(){
        return this.dao;
    }

    @Override
    public List<Post> getFollowPost(Integer userid) {
        return dao.getFollowPost(userid);
    }
}
