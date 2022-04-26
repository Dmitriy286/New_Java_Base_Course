package Tips;

import java.util.*;

public class Collections {

    public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(10);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i) + " ");

        System.out.println();
    }

    var b = new ArrayList<Integer>();

        for (var element: list) {
        System.out.println(element);
    }

        for (Integer element: list) {
        System.out.println(element);
    }

    Set set = new HashSet();
//        set.

    Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(5, "asdf");
        map.put(7, "asdfgh");
        System.out.println(map.get(5));

//        Map<Employee, Integer>
        System.out.println("Ключи: ");
        for (var key: map.keySet()) {
        System.out.println(key);
    }

}
}
