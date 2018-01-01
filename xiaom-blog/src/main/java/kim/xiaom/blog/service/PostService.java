package kim.xiaom.blog.service;

import kim.xiaom.blog.common.Page;
import kim.xiaom.blog.entity.dataObjects.PostDO;

import java.util.List;

/**
 * Created by ge on 30/12/2017.
 */
public interface PostService {
    PostDO get(String postId);
    void insert(PostDO post);
    void update(PostDO post);
    List<PostDO> findPage(PostDO post, Page page);
}
