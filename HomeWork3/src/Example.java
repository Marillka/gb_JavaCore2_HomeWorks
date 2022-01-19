import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */
public class Example {
    public static void main(String[] args) {
        list();

    }

    private static void list() {
        List<String> list = new ArrayList<>();
        list.add("Область");
        list.add("Зеленый");
        list.add("Структурный");
        list.add("Двор");
        list.add("Проявляться");
        list.add("Спуститься");
        list.add("Бродить");
        list.add("Поворачивать");
        list.add("Пускать");
        list.add("Носить");
        list.add("Поговорить");
        list.add("Поверхность");
        list.add("Область");
        list.add("Бродить");
        list.add("Область");
        list.add("Поверхность");
        list.add("Проявляться");
        list.add("Носить");
        list.add("Поворачивать");
        list.add("Двор");

        example1(list);


    }

    private static void example1(List<String> l) {
        ArrayList<String> uniqueWords = new ArrayList<>();

        String uniqueWord;

        System.out.println(l);

        System.out.println("Всего слов в списке: " + l.size());
        System.out.println();

        for (int i = 0; i < l.size(); i++) {
            uniqueWord = l.get(i);
            if (uniqueWords.contains(uniqueWord)) {
                continue;
            } else {
                uniqueWords.add(uniqueWord);
            }
        }

        System.out.println(uniqueWords);
        System.out.println("Количество уникальных слов: " + uniqueWords.size());
        System.out.println();

        Set<String> setOfStrings = new HashSet<>();
        for (int i = 0; i < l.size(); i++) {
            int count = 0;
            String wordCounter = l.get(i);
            for (int j = 0; j < l.size(); j++) {
                if (wordCounter == l.get(j)) {
                    count += 1;
                }
            }
            setOfStrings.add("Слово " + l.get(i) + " встречается " + count + " раз");
            count = 0;
        }

        for (Object o : setOfStrings) {
            System.out.println(o);
        }
    }


    }





