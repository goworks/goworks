package kim.xiaom.blog.service.impl;

import kim.xiaom.blog.common.Page;
import kim.xiaom.blog.dao.PostMapper;
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

    @Override
    public PostDO get(String id) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostIdEqualTo(id);

        List<PostDO> posts = postMapper.selectByExample(postExample);
        if (posts == null || posts.size() == 0) {
            return null;
        }

        return posts.get(0);
    }

    @Override
    public void insert(PostDO post) {
        postMapper.insert(post);
    }

    @Override
    public void update(PostDO post) {
        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andPostIdEqualTo(post.getPostId());
        postMapper.updateByExampleSelective(post, postExample);
    }

    @Override
    public List<PostDO> findPage(PostDO post, Page page) {
        return null;
    }
}
