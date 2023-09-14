package com.iba.automation;

import com.iba.automation.exceptions.TriangleException;
import com.iba.automation.exceptions.SideLengthException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

    @Test(expectedExceptions = SideLengthException.class)
    void If_any_side_is_zero_catch_SideLengthException_with_the_smallest_sides(){
        Triangle triangle = new Triangle(0,1,1);
    }
    @Test(expectedExceptions = SideLengthException.class)
    void If_any_side_is_zero_catch_SideLengthException_with_the_biggest_sides(){
        Triangle triangle = new Triangle(0,Integer.MAX_VALUE,Integer.MAX_VALUE);
    }
    @Test()
    void Equilateral_triangle_with_the_smallest_sides(){
        Triangle triangle = new Triangle(1,1,1);
        assertEquals(triangle.getTriangleType(), TriangleType.EQUILATERAL);
    }
    @Test()
    void Isosceles_triangle_with_the_smallest_sides(){
        Triangle triangle = new Triangle(2,2,3);
        assertEquals(triangle.getTriangleType(), TriangleType.ISOSCELES);
    }
    @Test()
    void Scalene_triangle_with_the_smallest_sides(){
        Triangle triangle = new Triangle(2,3,4);
        assertEquals(triangle.getTriangleType(), TriangleType.SCALENE);
    }
    @Test()
    void Equilateral_triangle_with_the_biggest_sides(){
        Triangle triangle = new Triangle(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
        assertEquals(triangle.getTriangleType(), TriangleType.EQUILATERAL);
    }
    @Test()
    void Isosceles_triangle_with_the_biggest_sides(){
        Triangle triangle = new Triangle(Integer.MAX_VALUE-1,Integer.MAX_VALUE,Integer.MAX_VALUE);
        assertEquals(triangle.getTriangleType(), TriangleType.ISOSCELES);
    }
    @Test()
    void Scalene_triangle_with_the_biggest_sides(){
        Triangle triangle = new Triangle(Integer.MAX_VALUE-1,Integer.MAX_VALUE-2,Integer.MAX_VALUE);
        assertEquals(triangle.getTriangleType(), TriangleType.SCALENE);
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