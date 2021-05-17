package Lesson1ver2;

public class Robot implements RunJump {
    int maxHeight;
    int maxLength;
    int codeName;

    public Robot(int maxHeight, int maxLength, int codeName) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.codeName = codeName;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void run() {
        System.out.println("Робот бежит");
    }

    @Override
    public String toString() {
        return "Робот под номером " + codeName;
    }
}
