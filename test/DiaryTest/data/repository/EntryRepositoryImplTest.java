package DiaryTest.data.repository;

import Diary.data.models.Entry;
import Diary.data.repository.EntryRepository;
import Diary.data.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplTest {
    private EntryRepository entryRepository;
    @BeforeEach
    public void setUp() {
        entryRepository = new EntryRepositoryImpl();
    }
    @Test
    public void saveEntryInRepository_saveEntryTest() {
        Entry entry = new Entry(1,"title", "body");
        entryRepository.save(entry);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
    }
    @Test
    public void saveMoreThanOneEntryInRepository() {
        Entry entry = new Entry(1,"title", "body");
        Entry entry1 = new Entry(1,"title", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
    }
    @Test
    public void findEntryByIdInRepository_findByIdTest() {
        Entry entry = new Entry(1, "title1", "body");
        Entry entry1 = new Entry(2,"title2", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
        Entry foundEntry = entryRepository.findById(1);
        System.out.println(entry.getTitle());
        System.out.println(foundEntry.getTitle());
        assertEquals(entry, foundEntry);
    }
    @Test
    public void findTwoEntriesByIdInRepository_findByIdTest() {
        Entry entry = new Entry(1, "title", "body");
        Entry entry1 = new Entry(2,"title", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
        Entry foundEntry = entryRepository.findById(1);
        assertEquals(entry, foundEntry);
        Entry foundEntry1 = entryRepository.findById(2);
        assertEquals(entry1, foundEntry1);
    }
    @Test
    public void allEntriesInRepositoryCaBeFound() {
        Entry entry = new Entry(1, "title", "body");
        Entry entry1 = new Entry(2, "title", "body");
        Entry entry2 = new Entry(3, "title", "body");
        Entry entry3= new Entry(4, "title", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        entryRepository.save(entry2);
        entryRepository.save(entry3);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
        List<Entry> foundEntries = new ArrayList<>();
        foundEntries.add(entry);
        foundEntries.add(entry1);
        foundEntries.add(entry2);
        foundEntries.add(entry3);
        assertEquals(entryRepository.findAll(), foundEntries);
    }
    @Test
    public void entryInRepositoryCanBeDeletedById_deleteEntryTest() {
        Entry entry = new Entry(1, "title", "body");
        Entry entry1 = new Entry(2, "title", "body");
        Entry entry2 = new Entry(3, "title", "body");
        Entry entry3= new Entry(4, "title", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        entryRepository.save(entry2);
        entryRepository.save(entry3);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
        entryRepository.delete(1);
        int newCount = entryRepository.findAll().size();
        assertEquals(newCount, entryRepository.count());
    }
    @Test
    public void deleteMoreThanOneEntryInRepositoryById_deleteEntryTest() {
        Entry entry = new Entry(1, "title", "body");
        Entry entry1 = new Entry(2, "title", "body");
        Entry entry2 = new Entry(3, "title", "body");
        Entry entry3= new Entry(4, "title", "body");
        entryRepository.save(entry);
        entryRepository.save(entry1);
        entryRepository.save(entry2);
        entryRepository.save(entry3);
        int currentCount = entryRepository.findAll().size();
        assertEquals(currentCount, entryRepository.count());
        entryRepository.delete(1);
        entryRepository.delete(3);
        int newCount = entryRepository.findAll().size();
        assertEquals(newCount, entryRepository.count());
    }



}
