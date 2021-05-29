package Lesson1ver2;

public class Main {
    public static void main(String[] args) {
        RunJump[] members = {
                new Human(2, 2, "Евгений"),
                new Human(1, 1, "Ольга"),
                new Cat(2, 3, "Василий"),
                new Cat(1, 1, "Борис"),
                new Robot(0, 10, 777),
                new Robot(0,12,666)
        };

        Obstacle[] obstacles = {
                new TreadMill(2),
                new TreadMill(3),
                new Wall(1),
                new Wall(4)
        };

        for (RunJump member : members) {
            System.out.println("Полосу препятствий проходит " + member);
            boolean winner = true;
            for (Obstacle obstacle : obstacles) {
                System.out.println(member + " пытается пробежать " + obstacle);
                if (obstacle.toJump(member.getMaxHeight()) ||
                        obstacle.toRun(member.getMaxLength())) {
                    System.out.println("И у него выходит!");
                } else {
                    winner = false;
                    System.out.println("И у него ничего не вышло");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " пробежал дистанцию!");
            } else {
                System.out.println(member + " не добежал.");
            }
            System.out.println();
        }
    }
}
