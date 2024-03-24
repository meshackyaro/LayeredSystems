package Diary.services;

import Diary.data.models.Entry;
import Diary.dto.requests.CreateEntryRequest;

import java.util.List;

public interface EntryServices {
    List<Entry> findAll();

    void deleteByTitle(String title);

    void createEntry(CreateEntryRequest createEntryRequest);


}
