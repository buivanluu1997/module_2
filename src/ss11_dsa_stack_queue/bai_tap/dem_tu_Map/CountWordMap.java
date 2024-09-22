package ss11_dsa_stack_queue.bai_tap.dem_tu_Map;

import java.util.TreeMap;

public class CountWordMap {
    public static void main(String[] args) {
        String str = "Hello World /.,";

        TreeMap<String, Integer> map = new TreeMap<>();
        String[] words = str.toLowerCase().split("");

        for (String word : words) {
            char charcacter = word.charAt(0);

            if (charcacter >= 'a' && charcacter <= 'z') {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        for (String word : map.keySet()) {
            System.out.println(word + " : " + map.get(word));
        }
    }
}
