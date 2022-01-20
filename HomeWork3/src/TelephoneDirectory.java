import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

public class TelephoneDirectory {

    public static void main(String[] args) {
        ArrayList<String> surnames = new ArrayList();
        ArrayList<String> numbers = new ArrayList();


        TelephoneDirectory.add("Комиссаров", "7(495)176-06-29", surnames, numbers);
        TelephoneDirectory.add("Никитин", "7(495)545-07-23", surnames, numbers);
        TelephoneDirectory.add("Иванов", "7(495)346-15-88", surnames, numbers);
        TelephoneDirectory.add("Кузнецов", "7(495)560-29-07", surnames, numbers);
        TelephoneDirectory.add("Петров", "7(495)741-46-00", surnames, numbers);
        TelephoneDirectory.add("Суворов", "7(495)561-28-52", surnames, numbers);
        TelephoneDirectory.add("Баранов", "7(495)994-57-22", surnames, numbers);
        TelephoneDirectory.add("Никитин", "7(495)926-92-30", surnames, numbers);
        TelephoneDirectory.add("Петров", "7(495)715-32-55", surnames, numbers);
        TelephoneDirectory.add("Комиссаров", "7(495)170-03-22", surnames, numbers);


        TelephoneDirectory.get("Комиссаров", surnames, numbers);
        TelephoneDirectory.get("Петров", surnames, numbers);
        TelephoneDirectory.get("Кузнецов", surnames, numbers);

    }


    public static void add(String s, String n, ArrayList<String> surname, ArrayList<String> number){
        surname.add(s);
        number.add(n);
    }

    public static void get(String a, ArrayList<String> b, ArrayList<String> c) {
        ArrayList<String> listSurname = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i) == a) {
                listSurname.add(c.get(i));
            }
        }
        System.out.println(listSurname);
    }



}
