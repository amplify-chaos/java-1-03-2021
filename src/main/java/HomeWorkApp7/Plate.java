package HomeWorkApp7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }
    public void consumeFood(int count) {
        food -= count;

    }
}
