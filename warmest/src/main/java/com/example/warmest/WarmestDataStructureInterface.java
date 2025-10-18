package com.example.warmest;

public interface WarmestDataStructureInterface {
    public Integer put(String key, int value);

    public Integer remove(String key);

    public Integer get(String key);

    public String getWarmest();
}
