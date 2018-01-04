package kim.xiaom.blog.service;

import com.github.pagehelper.PageInfo;
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
    PageInfo<Post> findPage(Post post, int current, int pageSize);
}
