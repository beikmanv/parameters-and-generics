import org.example.BoxCache;
import org.example.Box;
import org.example.BoxOperations;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a BoxCache instance with Integer keys and Box<String, Float> values
        BoxCache<Integer, Box<String, Float>> boxCache = new BoxCache<>();

        // Step 2: Create Box instances with name and genericAttribute of type String
        // `T` is String, `V` is Float
        Box<String, Float> box1 = new Box<>("FloatBox 1", "Attribute 1");
        Box<String, Float> box2 = new Box<>("FloatBox 2", "Attribute 2");

        // Step 3: Add the boxes to the cache
        boxCache.put(1, box1);
        boxCache.put(2, box2);

        // Step 4: Retrieve and test the boxes
        Box<String, Float> retrievedBox1 = boxCache.get(1);
        System.out.println("Retrieved Box Name (key 1): " + (retrievedBox1 != null ? retrievedBox1.hasSameName(box1) : "null"));

        Box<String, Float> retrievedBox2 = boxCache.get(2);
        System.out.println("Retrieved Box Name (key 2): " + (retrievedBox2 != null ? retrievedBox2.hasSameName(box2) : "null"));

        // Test for name comparison
        System.out.println("Does box1 have the same name as box2? " + box1.hasSameName(box2)); // Expected: false
    }
}
