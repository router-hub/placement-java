// Design Skiplist

import java.util.*;

class Skiplist {
    Map<Integer,Integer> map;
    public Skiplist() {
        map = new HashMap<>();
    }
    
    public boolean search(int target) {
        if(!map.containsKey(target)){
            return false;
        }
        return true;
    }
    
    public void add(int num) {
        map.put(num,map.getOrDefault(num,0)+1);
    }
    
    public boolean erase(int num) {
        if (!map.containsKey(num)) {
            return false;
        }
        
        int count = map.get(num);
        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
        return true;
    }
}