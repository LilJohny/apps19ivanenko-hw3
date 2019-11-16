package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;
    private final String OPERATION = "BASE";

    public BaseArray(Object[] arr) {
        array = arr;
    }

    BaseArray(Object[] arr, String operation) {
        array = arr;
        operation = operation;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return OPERATION;
    }

    @Override
    public int size() {
        return array.length;
    }
}
