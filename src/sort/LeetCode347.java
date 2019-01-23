package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * @author lcl
 */

public class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int num: nums){
            if(frequency.containsKey(num)){
                frequency.put(num,frequency.get(num)+1);
            }
            else {
                frequency.put(num,1);
            }
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        frequency.keySet().forEach(key -> {
            int frequencyNum = frequency.get(key);
            if (buckets[frequencyNum] == null) {
                buckets[frequencyNum] = new ArrayList<>();
            }
            buckets[frequencyNum].add(key);
        });
        List<Integer> result = new ArrayList<>();
        int size = 0, i = buckets.length -1;
        while (size < k){
            if(buckets[i] != null){
                for(int num: buckets[i]){
                    result.add(num);
                    size += 1;
                    if(size == k){
                        break;
                    }
                }
            }
            i--;
        }
        return result;
    }
}
