package kim.xiaom.blog.converter;

import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import org.springframework.stereotype.Component;

/**
 * Created by ge on 31/12/2017.
 */
@Component
public class PostConverter {
    public Post convert(PostDO postDO) {
        Post post = new Post();
        post.setId(postDO.getPostId());
        post.setTitle(postDO.getTitle());
        post.setText(postDO.getText());
        post.setStatus(postDO.getStatus());

        post.setCreator(postDO.getCreator());
        post.setModifier(postDO.getModifier());
        post.setGmtCreate(postDO.getGmtCreate());
        post.setGmtModify(postDO.getGmtModify());

        return post;
    }

    public PostDO convert(Post post) {
        PostDO postDO = new PostDO();
        postDO.setPostId(post.getId());
        postDO.setTitle(post.getTitle());
        postDO.setText(post.getText());
        postDO.setStatus(post.getStatus());

        postDO.setCreator(post.getCreator());
        postDO.setModifier(post.getModifier());
        postDO.setGmtCreate(post.getGmtCreate());
        postDO.setGmtModify(post.getGmtModify());

        return postDO;
    }
}
