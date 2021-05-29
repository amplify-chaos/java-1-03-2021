package Lesson1ver2;

public class Cat implements RunJump {
    int maxHeight;
    int maxLength;
    String nickname;

    public Cat(int maxHeight, int maxLength, String nickname) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.nickname = nickname;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает");
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void run() {
        System.out.println("Кот бежит");
    }

    @Override
    public String toString() {
        return "Кот по имени " + nickname;
    }
}
