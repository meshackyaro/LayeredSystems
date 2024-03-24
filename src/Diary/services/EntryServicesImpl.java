package Diary.services;
import Diary.data.models.Entry;
import Diary.data.repository.DiaryRepository;
import Diary.data.repository.DiaryRepositoryImpl;
import Diary.data.repository.EntryRepository;
import Diary.data.repository.EntryRepositoryImpl;
import Diary.dto.requests.CreateEntryRequest;
import Diary.services.EntryServices;
import java.util.ArrayList;
import java.util.List;

public class EntryServicesImpl implements EntryServices {
    private EntryRepository entryRepository = new EntryRepositoryImpl();
    private List<Entry> entries;

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public void deleteByTitle(String title) {
        Entry foundEntry = findById(title);
        entryRepository.findAll().remove(foundEntry);
    }

    @Override
    public void createEntry(CreateEntryRequest entryRequest) {
        Entry entry = new Entry();
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        entry.setAuthor(entryRequest.getAuthor());
        entryRepository.save(entry);
    }

    private Entry findById(String title) {
        for (Entry entry : entryRepository.findAll()) {
            if (entry.getTitle().equals(title)) {
                return entry;
            }
        }
        return null;
    }


}
