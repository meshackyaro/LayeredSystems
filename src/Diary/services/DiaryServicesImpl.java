package Diary.services;
import Diary.data.models.Diary;
import Diary.data.models.Entry;
import Diary.data.repository.DiaryRepository;
import Diary.data.repository.DiaryRepositoryImpl;
import Diary.data.repository.EntryRepository;
import Diary.data.repository.EntryRepositoryImpl;
import Diary.dto.requests.CreateEntryRequest;
import Diary.dto.requests.LoginRequest;
import Diary.dto.requests.RegisterRequest;

import java.util.List;

public class DiaryServicesImpl implements DiaryServices{

    private DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    private static EntryRepository entryRepository = new EntryRepositoryImpl();
    private EntryServices entryServices = new EntryServicesImpl();
    private int count;

    @Override
    public void register(RegisterRequest registerRequests) {
        Diary diary = new Diary("username", "password");
        diary.setUsername(registerRequests.getUsername());
        diary.setPassword((registerRequests.getPassword()));
        diaryRepository.save(diary);
    }

    @Override
    public int getNumberOfUsers() {
        return diaryRepository.findAll().size();
    }

    @Override
    public void login(LoginRequest loginRequest) {
        Diary diary = new Diary("username", "password");
        diary.setUsername(loginRequest.getUsername());
        diary.setPassword(loginRequest.getPassword());

    }

    @Override
    public void createEntry(CreateEntryRequest createEntryRequest) {
        entryServices.createEntry(createEntryRequest);
    }

    @Override
    public List<Entry> findAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public void delete(String title) {
        entryServices.deleteByTitle(title);
    }


}
