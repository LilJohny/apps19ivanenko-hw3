package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private  String operation = "BASE";
    private Object[] array;


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
        return operation;
    }

    @Override
    public int size() {
        return array.length;
    }
}
