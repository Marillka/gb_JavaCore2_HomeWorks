import java.util.Arrays;

/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:

static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];

2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:

System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:

System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() – копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:

for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}

Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

public class Example {

    static final int size = 100000000;
    static final int half = size / 2;

    public static void main(String[] args) {

        float[] Array1 = method1();
        float[] Array2 = method2();

        System.out.println(Arrays.equals(Array1, Array2));

    }

    public static float[] method1() {

        float[] arr1 = new float[size];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода: " + (endTime - startTime) + " мс");
        return arr1;
    }

    public static float[] method2() {
        float[] mainArr = new float[size];

        for (int i = 0; i < mainArr.length; i++) {
            mainArr[i] = 1;
        }

        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];

        long startTime = System.currentTimeMillis();

        System.arraycopy(mainArr, 0, leftHalf, 0, half);
        System.arraycopy(mainArr, half, rightHalf, 0, half);

       Thread first = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + (i + half) / 5) * Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4f + (i + half) / 2));
            }
        });

        first.start();
        second.start();

        try {
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftHalf,0,mainArr, 0, half);
        System.arraycopy(rightHalf,0,mainArr, half, half);

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения второго метода: " + (endTime - startTime) + " мс");

        return mainArr;
    }


}
