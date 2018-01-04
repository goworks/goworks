package kim.xiaom.blog.converter;

import com.github.pagehelper.PageInfo;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public PageInfo<Post> convert(PageInfo<PostDO> doPageInfo) {
        List<PostDO> postDOs = doPageInfo.getList();
        List<Post> posts = postDOs.stream().map(this::convert).collect(Collectors.toList());

        PageInfo<Post> postPageInfo = new PageInfo<>();
        postPageInfo.setList(posts);
        postPageInfo.setPageNum(doPageInfo.getPageNum());
        postPageInfo.setPageSize(doPageInfo.getPageSize());
        postPageInfo.setTotal(doPageInfo.getTotal());

        return postPageInfo;
    }
}
