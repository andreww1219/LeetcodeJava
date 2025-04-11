package Classic150.ArrayAndString;


import java.util.*;

// O(1)时间插入、删除和获取随机元素
public class Solution380 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> arr;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                arr.add(val);
                map.put(val, arr.size() - 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                Integer oriIndex = map.get(val);
                int lastVal = arr.get(arr.size() - 1);
                arr.set(oriIndex, lastVal);
                arr.remove(arr.size() - 1);
                map.replace(lastVal, oriIndex);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return arr.get(random.nextInt(arr.size()));
        }
    }
}
