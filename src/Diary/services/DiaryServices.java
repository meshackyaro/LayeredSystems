package Diary.services;

import Diary.data.models.Entry;
import Diary.dto.requests.CreateEntryRequest;
import Diary.dto.requests.LoginRequest;
import Diary.dto.requests.RegisterRequest;

import java.util.List;

public interface DiaryServices {
    void register(RegisterRequest registerRequests);

    int getNumberOfUsers();

    void login(LoginRequest loginRequest);

    void createEntry(CreateEntryRequest createEntryRequest);

    List<Entry> findAllEntries();

    void delete(String title);

    boolean isLocked();
}
