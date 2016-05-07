package alex.dao.imp;

import alex.dao.common.IOperations;
import alex.model.Follow;

import java.util.List;

/**
 * Created by alex on 16-4-11.
 */
public interface IFollowDao extends IOperations<Follow>{
    List<Integer> getFollowList(Integer userid);
    Follow getFollow(int userId, int followId);
}
