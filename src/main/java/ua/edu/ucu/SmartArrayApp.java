package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

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

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object object) {
                Student student = (Student) object;
                return student.getYear() == 2 && student.getGPA() >= 4;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObject, Object secondObject) {
                return ((Student) firstObject).getSurname().compareTo(((Student) secondObject).getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object object) {
                Student student = (Student) object;
                return  student.getSurname()+ " "+student.getName() ;
            }
        };
        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new FilterDecorator(studentSmartArray, pr);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new MapDecorator(studentSmartArray, func);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        return Arrays.stream(result).toArray(String[]::new);
        //return null;
    }
}
