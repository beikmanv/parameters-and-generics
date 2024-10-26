package org.example;
import java.util.Collections;
import java.util.List;

public interface BoxOperations<S> {
    public abstract S getLargestValue();
    public abstract void setLargestValue (S largestValue);
    public abstract <N extends Number> void setLargestValue(N  value, N value2);
    public void setLargestValueFromList(List<S> list);
}


