package com.jiuxian;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-01 15:23:02
 * *
 * @description: 最近最少使用 缓存数据结构
 **/
public class LRUCache {

    private final int capacity;

    private final Map<String, String> map;

    private final Stack<String> stack;

    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new ConcurrentHashMap<>();

        stack = new Stack<>();
    }

    public synchronized String get(String key) {
        stack.remove(key);
        stack.push(key);
        size++;
        return map.get(key);
    }

    private int getSize() {
        return size;
    }

    public synchronized void put(String key, String value) {
        if (stack.contains(key)) {
            stack.remove(key);
        } else if (getSize() == capacity) {
            String preKey = stack.remove(0);
            map.remove(preKey);
        }
        stack.push(key);
        map.put(key, value);
    }

    public static void main(String[] args) {


        Map<String, List<String>> map = new HashMap<>(2);
        map.computeIfAbsent("a", s -> new ArrayList<>()).add("ABC");
        List<String> a1 = map.computeIfPresent("a", (a, b) -> {
            b.add("ABC");
            return b;
        });
        System.out.println(a1);
        System.out.println(map);

        map.replaceAll((k,v)->{
            System.out.println(k);
            System.out.println(v);
            return v;
        });
    }

}
