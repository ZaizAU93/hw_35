import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1.1 ������� ������: ����� ����� � ���������� ����� �� �����, ��������� HashMap.
//        1.2 �������� � ����� ������ 3 ������.
//        1.3 ������� 2 ������.
//        1.4 ������� ������ �� �����.
//        1.5 ������� ������ ���� ������.
//        1.6 ������� ������ ���� ���� �� ������.
//        1.7 ���������, ���������� �� ����� ������� � ���������.

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
        System.out.println("����� �������� ���� = " + sum);

        Collection<String> collection = new ArrayList<>();
        collection.add("dfds");
        collection.add("dsf");
        collection.add("sdfdf");

        String value = "sfsd";

        for (String elem : collection) {
            if (value.contains(elem)) {
                System.out.println("������� ���������� � ���������");
            } else {
                System.out.println("�� ����������");
            }
        }

        //������������ ������ ������ � ����������. ��� ������� ����� ���������� ������� ���
        //�������������. �����, ������������ ��������� ���� ������� �������. ������������
        //����� HashMap. ����� ���������� ��������� ������� � �������

        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������ � �������������� ������� ����� ������");

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

//        ���� 2. �������� �������
//        ������ 1:
//        �� ���� ��������� ������ �����, ������� Map<String, Boolean>, ��� ������ ���������
//        ������ �������� ������, � �� �������� ����� true, ���� ��� ������ ����������� � �������
//        ��� ����� ���.

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


//        ������ 2:
//        �� ���� ��������� ������ �������� �����, �������� � ������� Map<String,
//        String> ��������� �������: ��� ������ ������ �������� �� ������ ������ �
//        �������� ����� � ��������� �������� � �������� ��������

        System.out.println("������� ������ � �������������� ������� ����� ������");


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

        System.out.println("������� ������ �� ��������");


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
            System.out.println("���������������� ������");
        } else{
            System.out.println("������������������ ������");
        }

    }
}
