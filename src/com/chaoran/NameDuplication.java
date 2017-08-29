package com.chaoran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chaoranli on 3/8/17.
 * 利用HashMap不能有重复的特性判断是否有重复的key
 * 从而删除重复名字
 */
public class NameDuplication {

    public List<String> deduplicate(String[] names) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i = 0; i < names.length; i++) {
            String str = names[i].toLowerCase();
            if(!mp.containsKey(str)) {
                mp.put(str, 1);
                result.add(str);
            }
        }
        return result;
    }
}
