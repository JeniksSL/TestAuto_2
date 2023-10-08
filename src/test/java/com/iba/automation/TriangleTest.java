package com.iba.automation;

import com.iba.automation.exceptions.TriangleException;
import com.iba.automation.exceptions.SideLengthException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

    //Suppose, that Integer.MAX_VALUE is a maximal acceptable value for triangle side length

    @DataProvider(name = "positive-tests-data")
    public Object[][] positiveTestsData() {
        return new Object[][] {
                {1,1,1, TriangleType.EQUILATERAL},
                {2,2,3, TriangleType.ISOSCELES},
                {2,3,4, TriangleType.SCALENE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE, TriangleType.EQUILATERAL},
                {Integer.MAX_VALUE-1,Integer.MAX_VALUE,Integer.MAX_VALUE, TriangleType.ISOSCELES},
                {Integer.MAX_VALUE-1,Integer.MAX_VALUE-2,Integer.MAX_VALUE, TriangleType.SCALENE}
        };
    }

    @Test(dataProvider = "positive-tests-data")
    void All_positive_tests(Integer size1, Integer size2,Integer size3, TriangleType type){
        Triangle triangle = new Triangle(size1,size2,size3);
        assertEquals(triangle.getTriangleType(), type);

    }


    @Test(expectedExceptions = SideLengthException.class)
    void If_any_side_is_zero_catch_SideLengthException(){
        Triangle triangle = new Triangle(0,1,Integer.MAX_VALUE);
    }
    @Test(expectedExceptions = SideLengthException.class)
    void If_any_side_is_more_than_max_value_catch_SideLengthException(){
        Triangle triangle = new Triangle(1L + Integer.MAX_VALUE,Integer.MAX_VALUE,1);
    }
    @Test(expectedExceptions = TriangleException.class)
    void If_any_side_is_not_less_then_sum__of_two_other_catch_TriangleException_with_the_smallest_sides(){
        Triangle triangle = new Triangle(1,1,3);
    }
    @Test(expectedExceptions = TriangleException.class)
    void If_any_side_is_not_less_then_sum_of_two_other_catch_TriangleException_with_the_biggest_sides(){
        Triangle triangle = new Triangle(Integer.MAX_VALUE/2,Integer.MAX_VALUE/2,Integer.MAX_VALUE);
    }



}