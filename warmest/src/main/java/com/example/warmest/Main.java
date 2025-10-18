package com.example.warmest;

public class Main {
    public static void main(String[] args) {
        WarmestDataStructure ds = new WarmestDataStructure();

        System.out.println(ds.getWarmest());
        System.out.println(ds.put("a", 100));
        System.out.println(ds.getWarmest());
        System.out.println(ds.put("a", 101));
        System.out.println(ds.put("a", 101));
        System.out.println(ds.get("a"));
        System.out.println(ds.getWarmest());
        System.out.println(ds.remove("a"));
        System.out.println(ds.remove("a"));
        System.out.println(ds.getWarmest());
        System.out.println(ds.put("a", 100));
        System.out.println(ds.put("b", 200));
        System.out.println(ds.put("c", 300));
        System.out.println(ds.getWarmest());
        System.out.println(ds.remove("b"));
        System.out.println(ds.getWarmest());
        System.out.println(ds.remove("c"));
        System.out.println(ds.getWarmest());
        System.out.println(ds.remove("a"));
        System.out.println(ds.getWarmest());
        System.out.println(ds.remove("a"));
    }
}
