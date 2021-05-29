package Lesson3lvl2;

public class WrongPositionException extends Exception {
    public WrongPositionException(String warning) {
        super(warning);
    }
}