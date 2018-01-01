package kim.xiaom.blog.converter;

import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import org.springframework.stereotype.Component;

/**
 * Created by ge on 31/12/2017.
 */
@Component
public class PostConverter {
    public Post converter(PostDO postDO) {
        Post post = new Post();
        post.setId(postDO.getPostId());
        post.setTitle(postDO.getTitle());
        post.setText(postDO.getText());
        post.setStatus(postDO.getStatus());

        return post;
    }

    public PostDO converter(Post post) {
        PostDO postDO = new PostDO();
        postDO.setPostId(post.getId());
        postDO.setTitle(post.getTitle());
        postDO.setText(post.getText());
        postDO.setStatus(post.getStatus());

        return postDO;
    }
}
