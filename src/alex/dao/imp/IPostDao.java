package alex.dao.imp;

import alex.dao.common.IOperations;
import alex.model.Post;

import java.util.List;

/**
 * Created by alex on 16-3-23.
 */
public interface IPostDao extends IOperations<Post> {
    List<Post> getFollowPost(Integer userid, Integer page);
    int getPage(Integer userid);
}
