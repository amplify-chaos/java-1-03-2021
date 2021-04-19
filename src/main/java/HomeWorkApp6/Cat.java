package HomeWorkApp6;

public class Cat extends Animal{

    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
        runLimit = (int) (10 + Math.random() * 100);
        swimLimit = 0;
    }

    @Override
    public void run(int distance) {
if (distance <= runLimit) {
    System.out.println("Кот " + getName() + " пробежал" + distance + "м.");
} else {
    System.out.println("Кот " + getName() + " устал!");
}
    }

    @Override
    public void swim(int distance) {
throw new RuntimeException("Коты не умеют плавать!");    }

    public static int getCatCount() {
        return catCount;
    }
}
