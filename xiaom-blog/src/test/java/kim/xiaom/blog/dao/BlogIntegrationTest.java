package kim.xiaom.blog.dao;

import kim.xiaom.blog.TestDataUtils;
import kim.xiaom.blog.XiaomBlogApplicationTests;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import kim.xiaom.blog.entity.queryObjects.PostExample;
import kim.xiaom.blog.utils.XiaomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = XiaomBlogApplicationTests.class)
@Transactional
public class BlogIntegrationTest {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void should_insert_post_successfully() {
        String postId = XiaomUtils.uuid();
        long gmtCreate = 1514793700000L;
        long gmtModify = 1514793700000L;

        PostDO postDO = new PostDO();
        postDO.setPostId(postId);
        postDO.setActive(1);
        postDO.setTitle("title");
        postDO.setText("text");
        postDO.setStatus(1);
        postDO.setCreator("wnow20");
        postDO.setModifier("wnow20");
        postDO.setGmtCreate(new Date(gmtCreate));
        postDO.setGmtModify(new Date(gmtModify));

        postMapper.insert(postDO);

        PostDO fetchPost = getByPostId(postId);
        assertThat(fetchPost).isNotNull();
        assertThat(fetchPost.getPostId()).isEqualTo(postId);
        assertThat(fetchPost.getActive()).isEqualTo(1);
        assertThat(fetchPost.getTitle()).isEqualTo("title");
        assertThat(fetchPost.getText()).isEqualTo("text");
        assertThat(fetchPost.getStatus()).isEqualTo(1);
        assertThat(fetchPost.getCreator()).isEqualTo("wnow20");
        assertThat(fetchPost.getModifier()).isEqualTo("wnow20");
        assertThat(fetchPost.getGmtCreate().getTime()).isEqualTo(gmtCreate);
        assertThat(fetchPost.getGmtModify().getTime()).isEqualTo(gmtModify);
    }

    @Test
    public void should_update_post_successfully() {
        String postId = XiaomUtils.uuid();
        PostDO postDO = TestDataUtils.generatePostDO(postId, "title", "text");
        postMapper.insert(postDO);

        PostDO fetchedPostDO = getByPostId(postId);
        assertThat(fetchedPostDO).isNotNull();
        assertThat(fetchedPostDO.getTitle()).isEqualTo("title");
        assertThat(fetchedPostDO.getText()).isEqualTo("text");

        fetchedPostDO.setTitle("title1");
        fetchedPostDO.setText("text1");

        updateByPostId(fetchedPostDO);

        PostDO updatedPostDO = getByPostId(postId);

        assertThat(updatedPostDO.getText()).isEqualTo("text1");
        assertThat(updatedPostDO.getTitle()).isEqualTo("title1");
    }

    private void updateByPostId(PostDO postDO) {
        PostExample postExample = new PostExample();
        String postId = postDO.getPostId();
        postExample.createCriteria()
                .andPostIdEqualTo(postId);
        postMapper.updateByExampleSelective(postDO, postExample);
    }

    private PostDO getByPostId(String postId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andPostIdEqualTo(postId);
        List<PostDO> postDOs = postMapper.selectByExample(postExample);

        assertThat(postDOs).isNotNull();
        assertThat(postDOs.size()).isEqualTo(1);
        return postDOs.get(0);
    }
}