package Diary.controllers;
import Diary.dto.requests.RegisterRequest;
import Diary.exceptions.diaryExceptions.DiaryException;
import Diary.services.DiaryServicesImpl;

public class DiaryController {
    private DiaryServicesImpl diaryServices = new DiaryServicesImpl();
    public String register(RegisterRequest registerRequest){
        try{
            diaryServices.register(registerRequest);
            return "Registration Successful";
        }catch (DiaryException e) {
            return e.getMessage();
        }

    }

}
