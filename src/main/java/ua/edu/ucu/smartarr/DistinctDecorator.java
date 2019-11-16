package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private String operation = "DISTINCT";

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        distinct();
    }

    private void distinct() {
        Object[] array = smartArray.toArray();
        Object[] distinctArray = Arrays.stream(array).distinct().toArray();
        smartArray = new BaseArray(distinctArray, operation);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
