package Lesson1ver2;

public class TreadMill implements Obstacle {
    int length;

    public TreadMill(int length) {
        this.length = length;
    }

    @Override
    public boolean toRun(int maxLength) {
        return (maxLength >= length);
    }

    @Override
    public boolean toJump(int maxHeight) {
        return false;
    }

    @Override
    public String toString() {
        return "беговую дорожку длиной " + length + " м";
    }
}