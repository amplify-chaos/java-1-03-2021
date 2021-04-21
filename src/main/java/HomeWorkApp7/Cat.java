package HomeWorkApp7;

public class Cat {

    private final String name;
    private boolean hungry;
    private final int appetite;

    public Cat(String name) {
        appetite = (int) (1 + Math.random() * 50);
        hungry = true;
        this.name = name;
    }

    public void eat(Plate plate) {
        if (hungry) {
            if (plate.getFood() >= appetite) {
                hungry = false;
                plate.consumeFood(appetite);
                System.out.println("Кот " + name + " съел " + appetite + " единиц еды, теперь он сыт!");
            } else {
                System.out.println("Я не наемся! Еды в тарелке мало!");
                System.out.println("Хозяин, добавь еды!");
            }
        } else {
            System.out.println("Хватит меня кормить, я и так сыт!");

        }
    }
}
