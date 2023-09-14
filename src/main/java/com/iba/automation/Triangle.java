package com.iba.automation;


import com.iba.automation.exceptions.TriangleException;

import java.util.*;

public class Triangle {
    private final Side sideOne;
    private final Side sideTwo;
    private final Side sideThree;
    private TriangleType triangleType;

    public Triangle(int numberOne,int numberTwo,int numberThree) {
        this.sideOne = new Side(numberOne);
        this.sideTwo = new Side(numberTwo);
        this.sideThree = new Side(numberThree);
        TreeSet<Side> sides = new TreeSet<>(List.of(sideOne, sideTwo,sideThree));
        Side larger= sides.last();
        if (larger==sideOne) {if (sideOne.isNotLessThan(Side.sum(sideTwo,sideThree))) throw new TriangleException();}
        else if (larger==sideTwo) {if (sideTwo.isNotLessThan(Side.sum(sideOne,sideThree))) throw new TriangleException();}
        else {if (sideThree.isNotLessThan(Side.sum(sideOne,sideTwo))) throw new TriangleException();}
        switch (sides.size()) {
            case 3 ->triangleType=TriangleType.SCALENE;
            case 2->triangleType=TriangleType.ISOSCELES;
            case 1->triangleType=TriangleType.EQUILATERAL;
        }
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

}
