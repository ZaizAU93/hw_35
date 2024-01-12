import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1.1 Создать список: номер карты и количество денег на карте, используя HashMap.
//        1.2 Добавить к этому списку 3 записи.
//        1.3 Удалить 2 записи.
//        1.4 Вывести запись по ключу.
//        1.5 Вывести список всех ключей.
//        1.6 Вывести список всех сумм на картах.
//        1.7 Проверить, содержится ли любой элемент в коллекции.

        HashMap<String, Double> check = new HashMap<>();
        check.put("1234-5678", 1212212.0);
        check.put("2345-6789", 234.3);
        check.put("1235-2344", 342.4);

        check.remove("1234-5678");
        check.remove("1235-2344");

        check.put("1234-5678", 1212212.0);
        check.put("1235-2344", 342.4);

        System.out.println(check.get("1235-2344"));
        System.out.println(check.keySet());

        double sum = 0;
        for (Map.Entry<String, Double> entry : check.entrySet()) {
            sum += entry.getValue();
        }
        System.out.println("сумма значений мапы = " + sum);

        Collection<String> collection = new ArrayList<>();
        collection.add("dfds");
        collection.add("dsf");
        collection.add("sdfdf");

        String value = "sfsd";

        for (String elem : collection) {
            if (value.contains(elem)) {
                System.out.println("элемент содердится в коллекции");
            } else {
                System.out.println("не содержится");
            }
        }

        //Пользователь вводит строку с клавиатуры. Для каждого слова подсчитать частоту его
        //встречаемости. Слова, отличающиеся регистром букв считать разными. Использовать
        //класс HashMap. После выполнения результат вывести в консоль

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку с повторяющимися словами через пробел");

        StringBuilder str = new StringBuilder(String.valueOf(scanner));
        String valueMas = scanner.nextLine();
        String[] mas = valueMas.split(" ");
        HashMap<String, Integer> map = new HashMap<>();


        System.out.println(Arrays.toString(mas));

        int i = 1;
        for (String elem : mas) {
            if (map.putIfAbsent(elem, i) == null) {
                map.put(elem, i);
            } else if (map.putIfAbsent(elem, i) == map.get(elem)) {
                map.put(elem, map.get(elem) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }

//        Блок 2. Домашнее задание
//        Задача 1:
//        На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//        строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//        или более раз.

        HashMap<String, Boolean> mapBool = new HashMap<String, Boolean>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                mapBool.put(entry.getKey(), true);
            } else {
                mapBool.put(entry.getKey(), false);
            }
        }

        for (Map.Entry<String, Boolean> entry : mapBool.entrySet()) {
            System.out.println(entry);
        }


//        Задача 2:
//        На вход поступает массив непустых строк, создайте и верните Map<String,
//        String> следующим образом: для каждой строки добавьте ее первый символ в
//        качестве ключа с последним символом в качестве значения

        System.out.println("Введите строку с повторяющимися словами через пробел");


        String valuePairs = scanner.nextLine();
        String[] masPairs = valuePairs.split(" ");
        char[][] masPairsTwo = new char[masPairs.length][];

        for (int k = 0; k < masPairs.length; k++) {
            String word = masPairs[k];
            masPairsTwo[k] = word.toCharArray();
        }


        HashMap<String, String> mapPairs = new HashMap<>();

        for (int j = 0; j < masPairsTwo.length; j++) {
            for (int k = 0; k < masPairsTwo[j].length; k++) {
                String key = String.valueOf(masPairsTwo[j][0]);
                String valueMap = String.valueOf(masPairsTwo[j][masPairsTwo[j].length - 1]);
                mapPairs.put(key, valueMap);
            }
        }

        for (Map.Entry<String, String> entry : mapPairs.entrySet()) {
            System.out.println(entry);
        }

        HashMap<String, String> balance = new HashMap<>();
        balance.put("{", "}");
        balance.put("[", "]");
        balance.put("(", ")");

        System.out.println("Введите строку со скобками");


        String staples = scanner.nextLine();
        char[] masStaples = staples.toCharArray();


        boolean balances = true;
        if (masStaples.length % 2 != 0) {
            balances = false;
        } else {
            int j = 1;
            for (int k = 0; k < masStaples.length / 2; k++) {
                String stap = balance.get(String.valueOf(masStaples[k]));
                if (!stap.equals(String.valueOf(masStaples[masStaples.length - j]))) {
                    balances = false;
                    break;
                }
                j++;
            }
        }

        if (balances == true) {
            System.out.println("сбалансированная строка");
        } else{
            System.out.println("несбалансированная строка");
        }

    }
}
