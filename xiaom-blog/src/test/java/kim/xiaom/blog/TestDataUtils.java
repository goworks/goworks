package kim.xiaom.blog;

import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import kim.xiaom.blog.utils.XiaomUtils;

import java.util.Date;

/**
 * Created by ge on 01/01/2018.
 */
public class TestDataUtils {
    public static PostDO generatePostDO(String postId, String title, String text) {
        PostDO postDO = new PostDO();
        postDO.setPostId(postId);
        postDO.setTitle(title);
        postDO.setText(text);
        postDO.setRemark("remark");
        postDO.setActive(1);
        postDO.setStatus(1);

        postDO.setCreator("wnow20");
        postDO.setModifier("wnow20");
        postDO.setGmtCreate(new Date());
        postDO.setGmtModify(new Date());

        return postDO;
    }

    public static Post generatePost(String postId, String title, String text) {
        Post post = new Post();
        post.setId(postId);
        post.setTitle(title);
        post.setText(text);
        post.setStatus(1);

        post.setCreator("wnow20");
        post.setModifier("wnow20");
        post.setGmtCreate(new Date());
        post.setGmtModify(new Date());

        return post;
    }
}
