package DiaryTest.services;

import Diary.dto.requests.CreateEntryRequest;
import Diary.dto.requests.LoginRequest;
import Diary.dto.requests.RegisterRequest;
import Diary.services.DiaryServices;
import Diary.services.DiaryServicesImpl;
import Diary.services.EntryServices;
import Diary.services.EntryServicesImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryServicesImplTest {
    private DiaryServices diaryService = new DiaryServicesImpl();
    private EntryServices entryServices = new EntryServicesImpl();

    @Test
    public void newUserRegistration_registerUserTest () {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
    }
    @Test
    public void registeredUserLoginRequest_loginTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
    }
    @Test
    public void userCanCreateEntry_createEntryTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setAuthor("username");
        createEntryRequest.setTitle("title");
        createEntryRequest.setBody("body");
        diaryService.createEntry(createEntryRequest);
        assertEquals(1, diaryService.findAllEntries().size());
    }
    @Test
    public void userCanDeleteEntryByTitle_deleteEntryTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setAuthor("username");
        createEntryRequest.setTitle("title");
        createEntryRequest.setBody("body");
        diaryService.createEntry(createEntryRequest);
        assertEquals(1, diaryService.findAllEntries().size());
        diaryService.delete("title");
        assertEquals(0, diaryService.findAllEntries().size());
    }


}
