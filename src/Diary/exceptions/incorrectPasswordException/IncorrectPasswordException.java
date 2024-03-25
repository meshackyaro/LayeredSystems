package Diary.exceptions.incorrectPasswordException;

import Diary.exceptions.diaryExceptions.DiaryException;

public class IncorrectPasswordException extends DiaryException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
