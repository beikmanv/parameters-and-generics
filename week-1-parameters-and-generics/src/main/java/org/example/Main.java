package org.example;

public class Main {
    public static void main(String[] args) {
        // Create a BoxCache instance where key is Integer and value is Box<String, Float>
        BoxCache<Integer, Box<String, Float>> boxCache = new BoxCache<>();

        // Create Box instances and add them to the cache
        Box<String, Float> box1 = new Box<>("FloatBox 1");
        Box<String, Float> box2 = new Box<>("FloatBox 2");
        Box<String, Float> box3 = new Box<>("FloatBox 3");
        Box<String, Float> box4 = new Box<>("FloatBox 1"); // Same name as box1

        // Adding boxes to the cache
        boxCache.put(1, box1);
        boxCache.put(2, box2);
        boxCache.put(3, box3);
        boxCache.put(4, box4); // box4 has the same name as box1

        // Test 1: Retrieve the Box from the cache (key = 1)
        Box<String, Float> retrievedBox1 = boxCache.get(1);
        System.out.println("Test 1 - Retrieved Box Name: " + (retrievedBox1 != null ? retrievedBox1.getGenericAttribute() : "null"));

        // Test 2: Attempt to retrieve a non-existent key (key = 5)
        Box<String, Float> retrievedBox2 = boxCache.get(5);
        System.out.println("Test 2 - Retrieved Box Name (non-existent key): " + (retrievedBox2 != null ? retrievedBox2.getGenericAttribute() : "null"));

        // Test 3: Retrieve the Box from the cache (key = 2)
        Box<String, Float> retrievedBox3 = boxCache.get(2);
        System.out.println("Test 3 - Retrieved Box Name: " + (retrievedBox3 != null ? retrievedBox3.getGenericAttribute() : "null"));

        // Test 4: Compare names using hasSameName (box1 vs. box2)
        System.out.println("Test 4 - Does box1 have the same name as box2? " + retrievedBox1.hasSameName(retrievedBox3)); // Expect false

        // Test 5: Compare names using hasSameName (box1 vs. box4)
        System.out.println("Test 5 - Does box1 have the same name as box4? " + retrievedBox1.hasSameName(box4)); // Expect true
    }
}
