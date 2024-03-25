package DiaryTest.services;

import Diary.dto.requests.CreateEntryRequest;
import Diary.dto.requests.LoginRequest;
import Diary.dto.requests.RegisterRequest;
import Diary.services.DiaryServices;
import Diary.services.DiaryServicesImpl;
import Diary.services.EntryServices;
import Diary.services.EntryServicesImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryServicesImplTest {
    private DiaryServices diaryService;

    @BeforeEach
    public void setup(){
        diaryService = new DiaryServicesImpl();
    }

    @AfterEach
    public void clearList(){
        diaryService.findAllEntries().clear();
    }


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
    public void twoRegisteredUsersLoginRequest_loginTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest.setUsername("username1");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest1);
        assertEquals(2, diaryService.getNumberOfUsers());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest.setUsername("username1");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest1);
        assertEquals(2, diaryService.getNumberOfUsers());
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
    public void twoUsersCanCreateEntry_createEntryTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest.setUsername("username1");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest1);
        assertEquals(2, diaryService.getNumberOfUsers());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest.setUsername("username1");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest1);
        assertEquals(2, diaryService.getNumberOfUsers());
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setAuthor("username");
        createEntryRequest.setTitle("title");
        createEntryRequest.setBody("body");
        diaryService.createEntry(createEntryRequest);
        CreateEntryRequest createEntryRequest1 = new CreateEntryRequest();
        createEntryRequest.setAuthor("username1");
        createEntryRequest.setTitle("title1");
        createEntryRequest.setBody("body1");
        diaryService.createEntry(createEntryRequest1);
        assertEquals(2, diaryService.findAllEntries().size());
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
    @Test
    public void userCanCreateTwoEntries_createEntryTest() {
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
        CreateEntryRequest createEntryRequest1 = new CreateEntryRequest();
        createEntryRequest.setAuthor("username1");
        createEntryRequest.setTitle("title1");
        createEntryRequest.setBody("body1");
        diaryService.createEntry(createEntryRequest1);
        assertEquals(2, diaryService.findAllEntries().size());
    }




}
