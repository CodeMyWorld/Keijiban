package alex.service.imp;

import alex.dao.common.IOperations;
import alex.dao.imp.IPostDao;
import alex.model.Post;
import alex.service.IPostService;
import alex.service.common.AbstractService;

import javax.annotation.Resource;

/**
 * Created by alex on 16-3-23.
 */
public class PostService extends AbstractService<Post> implements IPostService{
    @Resource(name="userDao")
    private IPostDao dao;

    public PostService(){
        super();
    }

    @Override
    protected IOperations<Post> getDao(){
        return this.dao;
    }
}
