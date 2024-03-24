package DiaryTest.data.repository;

import Diary.data.models.Diary;
import Diary.data.repository.DiaryRepository;
import Diary.data.repository.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryRepositoryImplTest {
    private DiaryRepository diaryRepository;
    @BeforeEach
    public void setUp() {
        diaryRepository = new DiaryRepositoryImpl();
    }
    @Test
    public void saveDiaryInRepository_saveTest() {
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
    }
    @Test
    public void saveMoreThanOneDiaryInRepository_saveDiaryTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.findAll().size());
    }
    @Test
    public void allDiariesInRepositoryCanBeFound_findAllTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        Diary diary3 = new Diary("username3", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        diaryRepository.save(diary2);
        diaryRepository.save(diary3);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        List<Diary> foundDiaries = new ArrayList<>();
        foundDiaries.add(diary);
        foundDiaries.add(diary1);
        foundDiaries.add(diary2);
        foundDiaries.add(diary3);
        List<Diary> found = diaryRepository.findAll();
        assertEquals(foundDiaries, found);
    }
    @Test
    public void findDiaryByUsernameInRepository_findByIdTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        Diary foundDiary = diaryRepository.findById("username1");
        assertEquals(diary1, foundDiary);
    }
    @Test
    public void findTwoDiariesByUsernameInRepository_findByIdTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        Diary foundDiary = diaryRepository.findById("username1");
        Diary foundDiary1 = diaryRepository.findById("username");
        assertEquals(diary1, foundDiary);
        assertEquals(diary, foundDiary1);
    }
    @Test
    public void diaryInRepositoryCanBeDeletedByUsername_deleteDiaryByUsernameTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        diaryRepository.delete("username");
        int newCount = diaryRepository.findAll().size();
        assertEquals(newCount, diaryRepository.count());
    }
    @Test
    public void moreThanOneDiaryInRepositoryCanBeDeletedByUsername_deleteDiaryByUsernameTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        Diary diary3 = new Diary("username3", "password");
        Diary diary4 = new Diary("username4", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        diaryRepository.save(diary2);
        diaryRepository.save(diary3);
        diaryRepository.save(diary4);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        diaryRepository.delete("username1");
        diaryRepository.delete("username3");
        diaryRepository.delete("username");
        int newCount = diaryRepository.findAll().size();
        assertEquals(newCount, diaryRepository.count());
    }
    @Test
    public void deleteDiaryInRepository_DeleteByDiaryTest() {
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        diaryRepository.delete(diary);
        long newCount = diaryRepository.findAll().size();
        assertEquals(newCount, diaryRepository.count());
    }
    @Test
    public void deleteTwoDiariesInRepository_deleteDiaryTest() {
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username1", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary1);
        long currentCount = diaryRepository.findAll().size();
        assertEquals(currentCount, diaryRepository.count());
        diaryRepository.delete(diary);
        diaryRepository.delete(diary1);
        int newCount = diaryRepository.findAll().size();
        assertEquals(newCount, diaryRepository.count());
    }
}
