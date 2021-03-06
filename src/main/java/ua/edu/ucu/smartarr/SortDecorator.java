package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private  String operation = "SORT";
    private MyComparator comparator;


    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        comparator = cmp;
        sort();
    }

    private void sort() {
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, comparator);
        smartArray = new BaseArray(arr, operation);
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
