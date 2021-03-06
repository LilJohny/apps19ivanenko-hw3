package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object object) {
                return ((Integer) object) > 0;
            }
        };
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObject, Object secondObject) {
                return ((Integer) firstObject) - ((Integer) secondObject);
            }
        };
        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object object) {
                return 2 * ((Integer) object);
            }
        };
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object object) {
                Student student = (Student) object;
                return student.getYear() == 2 && student.getGpa() >= 4;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObject, Object secondObject) {
                Student firstStudent = (Student) firstObject;
                Student secondStudent = (Student) secondObject;
                return firstStudent.getSurname()
                        .compareTo(secondStudent.getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object object) {
                Student student = (Student) object;
                return student.getSurname() + " " + student.getName();
            }
        };
        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new FilterDecorator(studentSmartArray, pr);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new MapDecorator(studentSmartArray, func);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        Object[] result = studentSmartArray.toArray();
        return Arrays.stream(result).toArray(String[]::new);
    }
}
