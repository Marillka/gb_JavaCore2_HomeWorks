public class Example {
    public static void main(String[] args) {

        Running characters[] = {
                new Human("Игорь", 200, 3),
                new Cat("Вася", 50, 1),
                new Robot("Жора", 0, 0)
        };

        characters[0].run(150);
        characters[1].run(45);
        characters[2].run(15);

        System.out.println();

        characters[0].jump(2);
        characters[1].jump(5);
        characters[2].jump(1);

    }
}
