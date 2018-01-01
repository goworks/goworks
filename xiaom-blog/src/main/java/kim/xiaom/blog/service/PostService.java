package kim.xiaom.blog.service;

import kim.xiaom.blog.common.Page;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;

import java.util.List;

/**
 * Created by ge on 30/12/2017.
 */
public interface PostService {
    Post get(String postId);
    void insert(Post post);
    void update(Post post);
    List<Post> findPage(Post post, Page page);
}
