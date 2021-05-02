package arrays;
import java.util.*;
import java.util.Comparator;

public class FindSubstring {
    public static void main(String args[]){
        findSubstring("avinash", 5);
    }

    public static String findSubstring(String str, int k){
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < str.length(); i++){
            if(k + i <= str.length()) {
                String curr = str.substring(i, k + i);
                map.put(curr, i);
            }
        }

        PriorityQueue<String> minheap = new PriorityQueue<>((a, b) -> a.length() - b.length());
        minheap.addAll(map.keySet());

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(minheap.remove());
        System.out.println(minheap.remove());
        System.out.println(minheap.remove());
        return "";
    }
}
