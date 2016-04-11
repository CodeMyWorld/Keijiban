package alex.service;

import alex.dao.common.IOperations;
import alex.model.Post;

import java.util.List;

/**
 * Created by alex on 16-3-23.
 */
public interface IPostService extends IOperations<Post> {
    List<Post> getFollowPost(Integer userid);
}
