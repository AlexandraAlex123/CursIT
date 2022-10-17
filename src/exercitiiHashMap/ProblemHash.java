package exercitiiHashMap;

import java.util.HashMap;
import java.util.Map;

public class ProblemHash {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 4, 4, 4};

        Map<Integer, Integer> myMap = new HashMap<>();
        Map<Integer, Integer> myMap2 = new HashMap<>();

        for (int i : a) {
            if (myMap.get(i) == null) {
                myMap.put(i, 1);
            } else {
                myMap.put(i, myMap.get(i) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == value) {
                myMap2.put(key, value);
            }
        }
        Map.Entry<Integer, Integer> maxMap = null;
        for (Map.Entry<Integer, Integer> entry : myMap2.entrySet()) {
            if (maxMap == null || entry.getValue().compareTo(maxMap.getValue()) > 0) {
                maxMap = entry;
            }
        }
        System.out.println(maxMap);
        assert maxMap != null;
        System.out.println("The number X that repeat exactly X times is " + maxMap.getKey());
    }
}
