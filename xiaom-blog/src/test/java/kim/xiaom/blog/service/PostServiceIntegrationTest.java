package kim.xiaom.blog.service;

import com.github.pagehelper.PageInfo;
import kim.xiaom.blog.TestDataUtils;
import kim.xiaom.blog.XiaomBlogApplicationTests;
import kim.xiaom.blog.domain.Post;
import kim.xiaom.blog.utils.XiaomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ge on 03/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = XiaomBlogApplicationTests.class)
@Transactional
public class PostServiceIntegrationTest {
    @Autowired
    private PostService postService;

    @Test
    public void should_insert_post_successfully() {
        String postId = XiaomUtils.uuid();
        Post post = TestDataUtils.generatePost(postId, "title", "text");

        postService.insert(post);

        Post fetchedPost = postService.get(postId);
        assertThat(fetchedPost).isNotNull();
        assertThat(fetchedPost.getId()).isEqualTo(postId);
        assertThat(fetchedPost.getTitle()).isEqualTo("title");
        assertThat(fetchedPost.getText()).isEqualTo("text");
    }

    @Test
    public void should_findPage_of_posts_successfully() throws InterruptedException {
        String postId1 = XiaomUtils.uuid();
        Post post1 = TestDataUtils.generatePost(postId1, "title1", "text1");
        String postId2 = XiaomUtils.uuid();
        Post post2 = TestDataUtils.generatePost(postId2, "title2", "text2");
        String postId3 = XiaomUtils.uuid();
        Post post3 = TestDataUtils.generatePost(postId3, "title3", "text3");
        String postId4 = XiaomUtils.uuid();
        Post post4 = TestDataUtils.generatePost(postId4, "title4", "text4");
        String postId5 = XiaomUtils.uuid();
        Post post5 = TestDataUtils.generatePost(postId5, "title5", "text5");
        String postId6 = XiaomUtils.uuid();
        Post post6 = TestDataUtils.generatePost(postId6, "title6", "text6");

        postService.insert(post1);
        postService.insert(post2);
        postService.insert(post3);
        postService.insert(post4);
        postService.insert(post5);
        postService.insert(post6);

        PageInfo<Post> page1 = postService.findPage(new Post(), 1, 3);
        PageInfo<Post> page2 = postService.findPage(new Post(), 2, 3);
        assertThat(page1.getTotal()).isGreaterThanOrEqualTo(6L);
        assertThat(page2.getTotal()).isGreaterThanOrEqualTo(6L);
        assertThat(page1.getList()).isNotNull();
        assertThat(page2.getList()).isNotNull();
        assertThat(page1.getList().size()).isEqualTo(3);
        assertThat(page2.getList().size()).isEqualTo(3);

        List<String> list = new ArrayList<>();
        page1.getList().forEach(x -> list.add(x.getId()));
        page2.getList().forEach(x -> list.add(x.getId()));

        assertThat(list.contains(postId1)).isTrue();
        assertThat(list.contains(postId2)).isTrue();
        assertThat(list.contains(postId3)).isTrue();
        assertThat(list.contains(postId4)).isTrue();
        assertThat(list.contains(postId5)).isTrue();
        assertThat(list.contains(postId6)).isTrue();

        Post postExample1 = new Post();
        postExample1.setText("text1");
        PageInfo<Post> page3 = postService.findPage(postExample1, 1, 3);
        assertThat(page3.getList().size()).isGreaterThanOrEqualTo(1);
        Optional<Post> first = page3.getList().stream().filter(x -> x.getId().equals(postId1)).findFirst();
        assertThat(first.isPresent()).isTrue();
        assertThat(first.get().getText()).isEqualTo("text1");
    }
}
