package kim.xiaom.blog.service.impl;

import kim.xiaom.blog.common.Page;
import kim.xiaom.blog.converter.PostConverter;
import kim.xiaom.blog.dao.PostMapper;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import kim.xiaom.blog.entity.queryObjects.PostExample;
import kim.xiaom.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ge on 30/12/2017.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostConverter postConverter;

    @Override
    public Post get(String id) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostIdEqualTo(id);

        List<PostDO> posts = postMapper.selectByExample(postExample);
        if (posts == null || posts.size() == 0) {
            return null;
        }

        return postConverter.convert(posts.get(0));
    }

    @Override
    public void insert(Post post) {
        PostDO postDO = postConverter.convert(post);
        postMapper.insert(postDO);
    }

    @Override
    public void update(Post post) {
        PostDO postDO = postConverter.convert(post);
        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andPostIdEqualTo(post.getId());

        // TODO set modifier
        // TODO set gmtModify

        postMapper.updateByExampleSelective(postDO, postExample);
    }

    @Override
    public List<Post> findPage(Post post, Page page) {
        return null;
    }
}
