package models;

import java.util.Comparator;
import java.util.TreeMap;

class ValueComparator implements Comparator<String> {

    private TreeMap<String, Integer> map = new TreeMap<>();

    public ValueComparator(TreeMap<String, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}