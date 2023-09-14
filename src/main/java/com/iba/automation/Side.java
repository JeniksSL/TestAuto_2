package com.iba.automation;

import com.iba.automation.exceptions.SideLengthException;

import java.util.Comparator;

public record Side(long length) implements Comparable<Side> {
    public Side {
        if (length==0) throw new SideLengthException("Side length can not be 0");
        if (length>Integer.MAX_VALUE) throw new SideLengthException("Side length limit is exceeded");
    }
    @Override
    public int compareTo(Side o) {
        return Comparator.comparing(Side::length).compare(this,o);
    }
    public boolean isNotLessThanSumOfTwoOther(Side s1, Side s2) {return length>=s1.length+s2.length;}
}
