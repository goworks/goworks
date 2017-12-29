package cn.asdfz.diary.dao;

import java.util.UUID;

import cn.asdfz.diary.DiaryApplicationTests;
import cn.asdfz.diary.entity.dataObjects.Diary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wnow20 on 24/12/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DiaryApplicationTests.class)
@Transactional
public class DiaryIntegrationTest {

    @Autowired
    private DiaryMapper diaryMapper;

    @Test
    public void should_create_diary_successfully() {
        Diary diary = new Diary();
        String diaryId = UUID.randomUUID().toString().replaceAll("-", "");

        System.out.println(diaryId);
        diary.setId(1);
        diary.setDiaryId(diaryId);
        diary.setText("text");
        diaryMapper.insert(diary);

        Diary fetchedDiary = diaryMapper.selectByPrimaryKey(1);

        assertThat(fetchedDiary).isNotNull();
        assertThat(fetchedDiary.getText()).isEqualTo("text");
    }
}
