package src.ru.aston.apanas_ak.task3;

import org.junit.jupiter.api.Test;


import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;


public class StreamApiTest<T> {
    //Вывести все четные числа в диапазоне от 1 до 100,
    @Test
    public void task1() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(out::println);
    }

    //Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2,
    @Test
    public void task2() {
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array)
                .map(n -> n * 2)
                .forEach(out::println);
    }

    //Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
    @Test
    public void task3() {
        int[] array = {1, 2, 3, 4, 5};
        out.println(Arrays.stream(array)
                .reduce((left, right) -> left + right)
                .orElseThrow());
    }

    //Вывести числа в диапазоне от 1 до 50 с шагом 2,
    @Test
    public void task4() {
        List<Integer> list = IntStream.range(0, 50).boxed().toList();
        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(out::println);
    }

    //Найти первый четный элемент в списке [1, 2, 3, 4, 5],
    @Test
    public void task5() {
        int[] array = {1, 2, 3, 4, 5};
        out.println(Arrays.stream(array)
                .filter(n -> n % 2 == 0).findFirst());
    }

    //Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию,
    @Test
    public void task6() {
        int[] array = {2, 1, 8, 6, 0};
        Arrays.stream(array).
                sorted().
                forEach(out::println);
    }

    //Вывести первые 10 чисел в списке [0, 1, 2, … 99]
    @Test
    public void task7() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .limit(10)
                .forEach(out::println);
    }

    //Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента,
    // выводя каждый 10-й элемент
    @Test
    public void task8() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .skip(10).filter(n -> n % 10 == 0)
                .forEach(out::println);
    }

    //Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3.
    @Test
    public void task9() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n % 3 == 0)
                .forEach(out::println);
    }

    //Выведите все нечетные числа в заданном массиве.
    @Test
    public void task10() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n % 2 != 0)
                .forEach(out::println);
    }

    //Выведите на экран только те элементы списка, которые больше заданного числа.
    @Test
    public void task11() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n > 89)
                .forEach(out::println);
    }

    //Отфильтруйте все элементы списка, которые меньше 0.
    @Test
    public void task12() {
        List<Integer> list = IntStream.range(-10, 100).boxed().toList();
        list.stream()
                .filter(n -> n < 0)
                .forEach(out::println);
    }

    //Выведите на экран строки, которые начинаются с заданной подстроки.
    @Test
    public void task13() {
        List<String> list = List.of("dog", "cat", "parrot", "mouse", "rat", "chicken");
        list.stream()
                .filter(n -> n.startsWith("c"))
                .forEach(out::println);
    }

    //Выведите все числа в списке, которые не кратны 2.
    @Test
    public void task14() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n % 2 != 0)
                .forEach(out::println);
    }

    //Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1.

    @Test
    public void task15() {
        List<User> list = List.of(new User(12), new User(1), new User(13), new User(1));
        list.stream()
                .filter(n -> n.getAge() == 1)
                .forEach(out::println);
    }

    //Выведите только те элементы коллекции, которые удовлетворяют определенному условию, например, являются уникальными или имеют определенный формат.
    @Test
    public void task16() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 1, 2, 3, 4);
        list.stream()
                .distinct()
                .forEach(out::println);
    }

    //Отфильтруйте элементы массива, которые не являются числами.
    @Test
    public void task17() {
        List<T> list = (List<T>) List.of(1, "3", "4", "5");
        list.stream()
                .filter(n -> n instanceof Number)
                .forEach(out::println);
    }

    //Выведите на экран элементы списка, которые не входят в другой список.
    @Test
    public void task18() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7);
        list1.stream()
                .filter(n -> !list.contains(n))
                .forEach(out::println);
    }

    //Проверить, все ли числа в массиве [0, 1, …, 19] являются четными,
    @Test
    public void task19() {
        List<Integer> list = List.of(2, 4, 6, 8);
        out.println(list.stream()
                .allMatch(n -> n % 2 == 0));
    }

    //Проверить, есть ли четное число в списке [0, 1, 2, 3],
    @Test
    public void task20() {
        List<Integer> list = List.of(1, 2, 5, 7, 9);
        out.println(list.stream()
                .anyMatch(n -> n % 2 == 0));
    }

    //Собрать все уникальные элементы Stream в список и отсортировать их.
    @Test
    public void task21() {
        List<Integer> list = List.of(1, 10, 1, 7, 9, 1, 2);
        list.stream()
                .distinct()
                .sorted()
                .forEach(out::println);
    }

    //Собрать элементы Stream в карту, где ключом будет первая буква каждого слова, а значением — само слово. Отсортировать ключи в алфавитном порядке.
    @Test
    public void task22() {
        List<String> list = List.of("dog", "cat", "parrot", "mouse", "rat");
        Map<Character, String> characterStringHashMap = new TreeMap<>(list.stream()
                .collect(Collectors.toMap(firstElement -> firstElement.charAt(0), value -> value)));
        out.println(characterStringHashMap);
    }


    //Собрать числа в Stream в список сумм цифр каждого числа.
    @Test
    public void task23() {
        List<Integer> list = List.of(1, 12, 123, 1234, 112345, 123456);
        list.stream()
                .map(element -> String.valueOf(element).chars().map(e -> Character.getNumericValue(e)).sum()).forEach(out::println);
    }

    //Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года.
    @Test
    public void task24() {
        List<LocalDate> list = Stream.of(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 1)).toList();
        out.println(list.stream()
                .collect(Collectors.toMap(key -> key.getMonthValue(), value -> 1, (num1, num2) -> num1 + num2)));
    }

    //Собрать файлы в Stream в список, где каждый элемент — количество файлов с определенным расширением.
    @Test
    public void task25() {
        List<File> list = Stream.of(new File("file.txt"), new File("file2.txt"), new File("file3.pdf")).toList();
        out.println(list.stream().collect(Collectors.groupingBy(e -> e.getName().split("\\.")[1], Collectors.counting())));
    }

    //Собрать пользователей в Stream в список объектов, где каждый объект содержит информацию о городе проживания пользователя и количестве пользователей из этого города.
    @Test
    public void task26() {
        List<User> list = List.of(new User(12, "Минск"), new User(13, "Минск"), new User(15, "Москва"));
        out.println(list.stream().collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting())));
    }

    //Собрать продукты в Stream в таблицу, где каждая строка — это информация о продукте (название, категория, стоимость), отсортированную по категории продукта.
    @Test
    public void task27() {
        List<Product> list = List.of(new Product("Молоко", "скоропорт", new BigDecimal(12)),
                new Product("Кефир", "скоропорт", new BigDecimal(4)),
                new Product("Колбаса", "скоропорт", new BigDecimal(60)));
        list.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()));
    }

    //Создайте Stream из массива чисел, выведите на экран числа, кратные 3 и 5 одновременно.
    @Test
    public void task28() {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();
        list.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .forEach(out::println);
    }

    //Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10.
    // Объедините эти два Stream-а в один и выведите на экран.
    @Test
    public void task29() {
        Stream.concat(Stream.of(1, 2, 3, 4, 5), Stream.of(5, 6, 7, 8, 9, 10)).forEach(out::println);
    }

    //Создайте Stream-у чисел от 1 до 20. Создайте новый Stream, который будет выводить на экран только четные числа и числа, кратные 3.
    // Затем объедините эти два Stream-a в один и выведите результирующий Stream.
    @Test
    public void task30() {
        Stream.concat(IntStream.range(0, 20).boxed(), IntStream.range(0, 20).boxed().filter(n -> n % 3 == 0)).forEach(out::println);
    }

    //Создайте Stream чисел от 2 до 10. Умножьте их на 2 и выведите результат на экран, ограничьтесь первыми десятью результатами.
    @Test
    public void task31() {
        IntStream.range(2, 10).map(e -> e * 2).limit(10).forEach(out::println);
    }

    //Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно. Объедините их в один Stream и выведите числа, которые кратны 3 или 5.
    @Test
    public void task32() {
        Stream.concat(IntStream.range(1, 10).boxed(), Stream.concat(IntStream.range(5, 20).boxed(), IntStream.range(10, 30).boxed())).filter(n -> n % 3 == 0 || n % 5 == 0)
                .forEach(out::println);
    }

    //Создайте Stream, который выводит на экран четные числа от 2 до 30.
    @Test
    public void task33() {
        IntStream.range(2, 30).boxed().forEach(out::println);
    }

    //Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20.
    @Test
    public void task34() {
        IntStream.range(2, 30).boxed().filter(e -> e > 10 && e < 20).forEach(out::println);
    }

    //Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20. Объединить их в один стрим и вывести на экран числа больше 10.
    @Test
    public void task35() {
        Stream.concat(IntStream.range(0, 10).boxed(), (IntStream.range(10, 20).boxed())).filter(n -> n > 10)
                .forEach(out::println);
    }

    //Создать стрим чисел от 0 до 100. Умножить их на 2 и вывести на экран результат, ограничиться первыми 10 результатами.
    @Test
    public void task36() {
        IntStream.range(0, 100).map(e -> e * 2)
                .limit(10).forEach(out::println);
    }

    //Создать стрим, который выводит числа от 1 до 10. Найти среднее арифметическое этих чисел и вывести его на экран.
    @Test
    public void task37() {
        out.println(IntStream.range(0, 10).average().orElseThrow());
    }

    //Создать три стрима из массивов чисел от 1 до 10, от 10 до 20 и от 20 до 30 соответственно. Объединить их в один стрим и вывести числа, которые кратны 5.
    @Test
    public void task38() {
        Stream.concat(IntStream.range(0, 10).boxed(), Stream.concat(IntStream.range(10, 20).boxed(), IntStream.range(20, 30).boxed()))
                .filter(n -> n % 5 == 0)
                .forEach(out::println);
    }

    //Создать стрим четных чисел от 2 до 40 и вывести на экран количество элементов в этом стриме.
    @Test
    public void task39() {
        out.println(IntStream.range(2, 40)
                .filter(n -> n % 2 == 0)
                .count());
    }

    //    Разделить элементы Stream на две группы: четные и нечетные, вывести результаты.
    @Test
    public void task40() {
        IntStream.range(0, 40).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0)).forEach((a, b) -> {
            if (a) {
                out.println("Чётные" + b);
            } else if (!a) {
                out.println("Нечётные" + b);
            }
        });
    }

    //    Разделить слова в Stream на две группы по первой букве: гласные и согласные, посчитать количество слов в каждой группе.
    @Test
    public void task41() {
        Stream.of("aaa", "ddd", "cccc", "mmm", "uuu", "ooo", "iii").collect(Collectors.partitioningBy(n -> n.matches("[aeiouy].*"), Collectors.counting()))
                .forEach((a, b) -> {
                    if (a) {
                        out.println("Гласные " + b);
                    } else if (!a) {
                        out.println("Согласные " + b);
                    }
                });
    }

    //    Разделить числа в Stream на три группы по остатку от деления на 3 (0, 1, 2), посчитать сумму чисел в каждой группе.
    @Test
    public void task42() {
        IntStream.range(0, 10).boxed().collect(Collectors.groupingBy(n -> n % 3, Collectors.summingInt(a -> a))).forEach((a, b) -> {
            if (a == 0) {
                out.println("группа 0 = " + b);
            } else if (a == 1) {
                out.println("группа 1 = " + b);
            } else if (a == 2) {
                out.println("группа 2 = " + b);
            }
        });
    }


    //    Разделить даты в Stream на четыре группы по временам года, посчитать количество событий в каждом времени года.
    @Test
    public void task43() {
        List<LocalDate> list = Stream.of(LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 6, 1), LocalDate.of(2025, 9, 1),
                LocalDate.of(2025, 2, 1)).toList();
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n.getMonthValue() > 2 && n.getMonthValue() < 7) {
                        return "Весна";
                    } else if (n.getMonthValue() > 5 && n.getMonthValue() < 9) {
                        return "Лето";
                    } else if (n.getMonthValue() > 8 && n.getMonthValue() < 12) {
                        return "Осень";
                    } else {
                        return "Зима";
                    }
                }, Collectors.counting()));
        out.println(map);
    }

    //    Разделить файлы в Stream на два списка: с расширением .txt и с расширением .doc, посчитать количество файлов в каждом списке.
    @Test
    public void task44() {
        List<File> list = Stream.of(new File("file.txt"), new File("file2.txt"), new File("file3.doc")).toList();
        out.println(list.stream().collect(Collectors.groupingBy(e -> e.getName().split("\\.")[1], Collectors.counting())));
    }

    //    Разделить пользователей в Stream на группы по городу (ближний и дальний план), посчитать количество пользователей в каждой группе.
    @Test
    public void task45() {
        List<User> list = List.of(new User(12, "Минск"), new User(13, "Минск"), new User(15, "Москва"));
        out.println(list.stream().collect(Collectors.groupingBy(User::getCity, Collectors.counting())));
    }

    //    Разделить продукты в Stream на несколько групп по категориям (например, молочные продукты, мясные продукты, овощи, фрукты), посчитать стоимость продуктов в каждой группе.
    @Test
    public void task46() {
        List<Product> list = List.of(new Product("Молоко", "скоропорт", new BigDecimal(12)),
                new Product("Кефир", "скоропорт", new BigDecimal(4)),
                new Product("Колбаса", "мясо", new BigDecimal(60)));
        out.println(list.stream().collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add)));
    }

    //    Создание Stream из массива целых чисел и вывод на экран всех простых чисел в диапазоне от 2 до 100.
    @Test
    public void task47() {
        IntStream.range(0, 100).boxed().filter(n -> n > 1 && n % 2 != 0 && Math.sqrt(n) % 1 != 0).forEach(out::println);
    }

    //    Создание двух Stream из массивов целых чисел и объединение их в один, затем вывод на экран суммы квадратов элементов этого Stream.
    @Test
    public void task48() {
        out.println(IntStream.concat(IntStream.range(0, 10), (IntStream.range(10, 20))).map(n -> n * n).sum());
    }

    //    Создание трех Stream из массивов и объединение их в один. Затем вывод на экран среднего геометрического значения элементов этого Stream.
    @Test
    public void task49() {
        out.println(Math.sqrt(DoubleStream.concat(DoubleStream.of(2), DoubleStream.concat(DoubleStream.of(3), DoubleStream.of(4))).reduce(((left, right) -> left * right)).orElseThrow()));
    }

    //    Создание Stream символов и поиск всех строк, состоящих из строчных букв и цифр.
    @Test
    public void task50() {
        Stream.of("aaa", "d123d", "^", "123", "#", "ooo", "!").filter(s -> s.matches("[a-z0-9]+")).forEach(out::println);
    }

    //    Создание Stream объектов и поиск всех объектов, у которых определенное поле равно определенному значению.
    @Test
    public void task51() {
        List<User> list = List.of(new User(12, "Минск"), new User(13, "Минск"), new User(15, "Москва"));
        list.stream().filter(n -> n.getCity().equals("Минск")).forEach(out::println);
    }

    //    Создание Stream дат и поиск всех дат, которые попадают в определенный диапазон.
    @Test
    public void task52() {
        List<LocalDate> list = Stream.of(LocalDate.of(2025, 1, 2), LocalDate.of(2025, 2, 1), LocalDate.of(2025, 3, 1)).toList();
        list.stream().filter(n -> n.isAfter(LocalDate.of(2025, 1, 1)) && n.isBefore(LocalDate.of(2025, 2, 1))).forEach(out::println);
    }

    //    Создание Stream целых чисел и поиск всех чисел, у которых сумма цифр равна заданному числу.
    @Test
    public void task53() {
        Stream.of(12, 123, 1234, 12345)
                .map(element -> String.valueOf(element).chars().map(Character::getNumericValue).sum()).filter(n -> n == 3).forEach(out::println);
    }

    //    Создание Stream строк и поиск всех строк, у которых длина равна заданному числу и которые состоят из определенного набора символов.
    @Test
    public void task54() {
        Stream.of("aaa", "d123d", "^", "123", "#", "ooo", "!").filter(s -> s.matches("[a-z0-9]+") && s.length() > 3).forEach(out::println);

    }

    //    Создание Stream пар чисел и поиск всех пар, у которых произведение равно заданному числу или которые удовлетворяют другому условию.
    @Test
    public void task55() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(array).boxed()
                .mapToInt(i -> i.intValue())
                .mapToObj(j -> IntStream.of(array).mapToObj(n -> new int[]{j, n}))
                .flatMap(e -> e).filter(arr -> arr[0] * arr[1] == 8)
                .forEach(n -> out.println(n[0] + " * " + n[1] + "= 8"));

    }

    //    Создание Stream коллекций и поиск всех коллекций, которые содержат определенный элемент или удовлетворяют другому условию.
    @Test
    public void task56() {

        Stream.of(List.of(1), List.of(1, 2), List.of(1, 2, 3)).filter(n -> n.contains(1) && n.size() == 2).forEach(out::println);
    }

    //    Сгруппировать элементы Stream по их чётности, посчитать размер каждой группы и вывести результаты.
    @Test
    public void task57() {
        IntStream.range(0, 20).boxed().collect(Collectors.groupingBy(n -> n % 2 == 0, Collectors.counting())).forEach((a, b) -> {
            if (a) {
                out.println("Чётные " + b + " Количество: " + b);
            } else if (!a) {
                out.println("Нечётные " + b + " Количество: " + b);
            }
        });
    }

    //    Сгруппировать слова в Stream по первой букве, посчитать количество слов в каждой группе и вывести результаты в виде словаря, где ключ — первая буква слова, а значение — количество слов, начинающихся на эту букву.
    @Test
    public void task58() {
        out.println(Stream.of("aaa", "ddd", "cccc", "mmm", "uuu", "ooo", "iii", "iii222").collect(Collectors.groupingBy(n -> n.charAt(0), Collectors.counting())));
    }

    //    Сгруппировать числа в Stream по остатку от деления на 3, посчитать сумму чисел в каждой группе и вывести результаты.
    @Test
    public void task59() {
        out.println(IntStream.range(0, 10).boxed().collect(Collectors.groupingBy(n -> n % 3, Collectors.counting())));
    }

    //    Сгруппировать даты в Stream по месяцу, посчитать количество дат в каждом месяце и вывести результаты в виде календаря с количеством событий в каждом месяце.
    @Test
    public void task60() {
        List<LocalDate> list = Stream.of(LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 6, 1), LocalDate.of(2025, 9, 1),
                LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 1)).toList();
        out.println(list.stream().collect(Collectors.groupingBy(LocalDate::getMonthValue, Collectors.counting())));

    }

    //    Сгруппировать файлы в Stream по расширению, посчитать количество файлов с каждым расширением и вывести результаты в виде списка, где ключ — расширение файла, а значение — количество файлов с таким расширением.
    @Test
    public void task61() {
        List<File> list = Stream.of(new File("file.txt"), new File("file2.txt"), new File("file3.doc")).toList();
        out.println(list.stream().collect(Collectors.groupingBy(e -> e.getName().split("\\.")[1], Collectors.counting())));
    }

    //    Сгруппировать пользователей в Stream по городу проживания, посчитать количество пользователей из каждого города и вывести результаты в виде карты мира с количеством пользователей из каждого города.
    @Test
    public void task62() {
        List<User> list = List.of(new User(12, "Минск"), new User(13, "Минск"), new User(15, "Москва"));
        out.println(list.stream().collect(Collectors.groupingBy(User::getCity, Collectors.counting())));
    }

    //    Сгруппировать продукты в Stream по категории, посчитать стоимость продуктов в каждой категории и вывести результаты в виде таблицы, где столбец — категория продукта, а строка — стоимость продуктов в этой категории.
    @Test
    public void task63() {
        List<Product> list = List.of(new Product("Молоко", "скоропорт", new BigDecimal(12)),
                new Product("Кефир", "скоропорт", new BigDecimal(4)),
                new Product("Колбаса", "мясо", new BigDecimal(60)));
        out.println(list.stream().collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add)));
    }
}