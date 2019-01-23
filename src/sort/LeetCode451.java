package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * @author lcl
 */

public class LeetCode451{
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(frequencyMap.containsKey(s.charAt(i))){
                frequencyMap.put(s.charAt(i),frequencyMap.get(s.charAt(i))+1);
            }
            else {
                frequencyMap.put(s.charAt(i),1);
            }
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(Character letter : frequencyMap.keySet()){
            if(buckets[frequencyMap.get(letter)] != null){
                buckets[frequencyMap.get(letter)].add(letter);
            }
            else {
                buckets[frequencyMap.get(letter)] = new ArrayList<>();
                buckets[frequencyMap.get(letter)].add(letter);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = buckets.length-1;i>0;i--){
            if(null != buckets[i]){
                for(Character letter : buckets[i]){
                    for(int time = 0;time < i;time ++){
                    stringBuilder.append(letter);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
