package Diary.data.repository;
import Diary.data.models.Entry;
import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private static List<Entry> entries = new ArrayList<>();
    private long numberOfEntries;
    private int id;


    @Override
    public Entry save(Entry entry) {
        entry.setId(generateId());
        entries.add(entry);
        numberOfEntries++;
        return entry;
    }

    private int generateId() {
        return ++id;
    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return entries.size() ;
    }

    @Override
    public void delete(int id) {
        entries.remove(findById(id));
    }
}
