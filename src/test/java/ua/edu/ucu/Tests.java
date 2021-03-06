package ua.edu.ucu;

import org.junit.Assert;
import org.junit.Test;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.SmartArray;

import static junit.framework.TestCase.assertEquals;

public class Tests {
    @Test
    public void testStudent(){
        Student student = new Student("Name", "Surname", 100,3);

        assertEquals (student.toString(), "Student{name=Name, surname=Surname, GPA=100.0, year=3}");
    }
}
