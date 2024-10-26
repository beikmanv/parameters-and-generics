package org.example;

import java.util.HashMap;
import java.util.Map;

public class BoxCache<K, V extends BoxOperations<?>> {
    private final Map<K, V> cache;

    // Constructor to initialize the cache
    public BoxCache() {
        this.cache = new HashMap<>();
    }

    // Method to add a key-value pair to the cache
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // Method to retrieve a value from the cache by its key
    public V get(K key) {
        return cache.get(key);
    }

    // Method to check if the cache contains a specific key
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
