package kim.xiaom.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kim.xiaom.blog.converter.PostConverter;
import kim.xiaom.blog.dao.PostMapper;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import kim.xiaom.blog.entity.queryObjects.PostExample;
import kim.xiaom.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
        postDO.setGmtCreate(new Date());
        postDO.setGmtModify(new Date());
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
    public PageInfo<Post> findPage(Post post, int current, int pageSize) {
        PageHelper.startPage(current, pageSize);
        PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();
        if (!StringUtils.isEmpty(post.getTitle())) {
            criteria.andTitleLike(post.getTitle());
        }
        postExample.setOrderByClause("gmt_create desc");

        Page<PostDO> postDOs = (Page<PostDO>) postMapper.selectByExample(postExample);
        PageInfo<PostDO> postDOPageInfo = postDOs.toPageInfo();

        return postConverter.convert(postDOPageInfo);
    }
}
