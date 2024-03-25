package Diary.exceptions.userExistsException;

import Diary.exceptions.diaryExceptions.DiaryException;

public class UserExistException extends DiaryException {
    public UserExistException(String message) {
        super(message);
    }
}
