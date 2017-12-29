package kim.xiaom.blog.dao;

import kim.xiaom.blog.XiaomBlogApplicationTests;
import kim.xiaom.blog.entity.dataObjects.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = XiaomBlogApplicationTests.class)
@Transactional
public class BlogIntegrationTest {
    @Autowired
    private PostMapper postMapper;
    @Test
    public void should_insert_post_successfully() {
        Post post = new Post();
        post.setId(1);
        post.setActive(1);
        post.setText(1);

        postMapper.insert(post);

        Post fetchPost = postMapper.selectByPrimaryKey(1);

        assertThat(fetchPost).isNotNull();
        assertThat(fetchPost.getText()).isEqualTo(1);
    }
}