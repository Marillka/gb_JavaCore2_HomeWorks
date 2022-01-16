public class Robot implements Running, Jumping {

    private String name;
    private int length;
    private int height;

    public Robot(String name, int length, int height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }

    @Override
    public void run(int length) {
        if (length <= 10 & length > 0) {
            System.out.println("Робот " + name + " успешно пробежал по беговой дорожке " + length + " метров");
        } else if (length <= 0) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Робот " + name + " не смог пробежать по дорожке " + length + " метров");
        }
    }

    @Override
    public void jump(int height) {
        if (height <= 1 & height > 0) {
            System.out.println("Робот " + name + " успешно перепругнул стену высотой " + height + " метров");
        } else if (height <= 0) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену высотой " + height + " метров");
        }
    }
}
