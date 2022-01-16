public class Human implements Running, Jumping {

    private String name;
    private int length;
    private int height;

    public Human(String name, int length, int height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }


    @Override
    public void run(int length) {
        if (length <= 200 & length > 0) {
            System.out.println("Человек " + name + " успешно пробежал по беговой дорожке " + length + " метров");
        } else if (length <= 0) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Человек " + name + " не смог пробежать по дорожке " + length + " метров");

        }
    }

    @Override
    public void jump(int height) {
        if (height <= 4 & height > 0) {
            System.out.println("Человек " + name + " успешно перепругнул стену высотой " + height + " метров");
        } else if (height <= 0) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Человек " + name + " не смог перепрыгнуть стену высотой " + height + " метров");
        }
    }
}
