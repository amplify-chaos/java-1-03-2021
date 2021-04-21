package HomeWorkApp7;

public class Test {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Васька");
        cats[1] = new Cat("Мурзик");
        cats[2] = new Cat("Барсик");

        Plate plate = new Plate(50);

        for (Cat cat : cats) {
            cat.eat(plate);
        }

        plate.addFood(100);

        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}
