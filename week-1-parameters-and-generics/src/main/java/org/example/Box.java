package org.example;
import java.util.Collections;
import java.util.List;

// We use Comparable<V> to make sure ensures that instances of V can be compared to each other using the compareTo() method, which is defined in Comparable.
public class Box<T, V extends Number & Comparable<V>> implements BoxOperations<V> {
    private T genericAttribute;
    private V largestValue;
    private String name;

    // Constructor to initialize both `name` and `genericAttribute`
    public Box(String name, T genericAttribute) {
        this.name = name;
        this.genericAttribute = genericAttribute;
    }

    public T getGenericAttribute() {
        return genericAttribute;
    }

    public String getName() {
        return name;
    }

    @Override
    public V getLargestValue() {
        return largestValue;
    }

    public void setGenericAttribute(T genericAttribute) {
        this.genericAttribute = genericAttribute;
    }

    @Override
    public void setLargestValue(V largestValue) {
        this.largestValue = largestValue;
    }

    // Method to compare two numbers and set the larger as `largestValue`
    @Override
    public <N extends Number> void setLargestValue(N value, N value2) {
        // Converting both values to double for comparison ensures consistent behavior
        this.largestValue = (V) (value.doubleValue() > value2.doubleValue() ? value : value2);
    }

    // Method to check if another Box has the same name
    public boolean hasSameName(Box<?, ?> otherBox) {
        return this.name.equals(otherBox.name);
    }

    // New castValue method to cast a value to type T
    public <U> T castValue(U value, Class<T> targetType) {
        // Attempt to cast value to the specified target type (T)
        try {
            return targetType.cast(value);
        } catch (ClassCastException e) {
            System.out.println("Casting failed: incompatible types.");
            return null; // Returning null if casting fails
        }
    }

    // Task 14 (Set largestValue from a List of V using Collections.max)
    @Override
    public void setLargestValueFromList(List<V> list){
        largestValue = Collections.max(list);
    }

}

/*
// See Slack chat (Nebil) for alternative solution

public class Box<T, V extends Number & Comparable<V>> implements BoxOperations<V> {
    private T genericAttribute;
    private V largestValue;
    private String name;

    // Constructor to initialize `name` and ensure every `Box` has a unique name
    public Box(String name) {
        this.name = name;
    }

    public T getGenericAttribute() {
        return genericAttribute;
    }

    @Override
    public V getLargestValue() {
        return largestValue;
    }

    public void setGenericAttribute(T genericAttribute) {
        this.genericAttribute = genericAttribute;
    }

    @Override
    public void setLargestValue(V largestValue) {
        this.largestValue = largestValue;
    }

    // Method to compare two numbers and set the larger as `largestValue`
    @Override
    public <N extends Number> void setLargestValue(N value, N value2) {
        // Converting both values to double for comparison ensures consistent behavior
        this.largestValue = (V) (value.doubleValue() > value2.doubleValue() ? value : value2);
    }

    // Method to check if another Box has the same name
    public boolean hasSameName(Box<?, ?> otherBox) {
        return this.name.equals(otherBox.name);
    }

    // New castValue method to cast a value to type T
    public <U> T castValue(U value, Class<T> targetType) {
        // Attempt to cast value to the specified target type (T)
        try {
            return targetType.cast(value);
        } catch (ClassCastException e) {
            System.out.println("Casting failed: incompatible types.");
            return null; // Returning null if casting fails
        }
    }

    // New castValue method from Northcoders notes (alternative method)
    /*
    private <U> T convertToT(U value) {
        // cast a U to a T
        return (T) value;


    // Task 14 (Set largestValue from a List of V using Collections.max)
    @Override
    public void setLargestValueFromList(List<V> list){
        largestValue = Collections.max(list);
    }

    // Task 14 (Alternative)
    /*
    @Override
    public void setLargestValueFromList(List<V> list) {
        if (list != null && !list.isEmpty()) {
            this.largestValue = Collections.max(list);  // Finds the max and assigns it to largestValue
        }
    }
     */
