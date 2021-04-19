package HomeWorkApp6;

public class Dog extends Animal{

    private static int dogCount = 0;


    public Dog(String name) {
        super(name);
        dogCount++;
        runLimit = (int) (20 + Math.random() * 200);
        swimLimit = (int) (5 + Math.random() * 50);
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println("Пёс " + getName() + " пробежал" + distance + "м.");
        } else {
            System.out.println("Пёс " + getName() + " не может пробежать столько!");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println("Пёс " + getName() + " проплыл" + distance + "м.");
        } else {
            System.out.println("Пёс " + getName() + " не может плыть так долго!");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
