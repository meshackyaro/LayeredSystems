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
import Diary.exceptions.incorrectPasswordException.IncorrectPasswordException;
import Diary.exceptions.invalidUsernameException.InvalidUsernameException;
import Diary.exceptions.nullValueException.NullValueException;

import java.util.List;

public class DiaryServicesImpl implements DiaryServices{

    private DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    private static EntryRepository entryRepository = new EntryRepositoryImpl();
    private EntryServices entryServices = new EntryServicesImpl();
    private int count;

    @Override
    public void register(RegisterRequest registerRequests) {
        Diary diary = new Diary();
        String username = registerRequests.getUsername();
        if (username == null) throw new NullValueException("Diary cannot be null");
        validate(username);
        String password = registerRequests.getPassword();
        validateThis(password);
        diary.setUsername(registerRequests.getUsername());
        diary.setPassword((registerRequests.getPassword()));
        diaryRepository.save(diary);
    }
    private void validate(String username) {
        Diary diary = new Diary();
        if (diary.getUsername() != username) throw new InvalidUsernameException("Invalid username");
    }
    private void validateThis(String password) {
        Diary diary = new Diary();
        if (diary.getPassword() != password) throw new IncorrectPasswordException("Incorrect Password");
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

    @Override
    public boolean isLocked() {
        return true;
    }


}
