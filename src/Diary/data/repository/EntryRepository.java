package Diary.data.repository;

import Diary.data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(int id);
    long count();
    void delete(int id);

}
