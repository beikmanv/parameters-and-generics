package org.example;
import java.util.Collections;
import java.util.List;

public interface BoxOperations<I1> {
    public abstract I1 getLargestValue();
    public abstract void setLargestValue (I1 largestValue);
    public abstract <N extends Number> void setLargestValue(N  value, N value2);
    public void setLargestValueFromList(List<I1> list);
}


