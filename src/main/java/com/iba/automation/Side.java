package com.iba.automation;

import com.iba.automation.exceptions.SideLengthException;

import java.util.Comparator;

public record Side(long length) implements Comparable<Side> {
    public Side {if (length==0) throw new SideLengthException();
    }

    @Override
    public int compareTo(Side o) {
        return Comparator.comparing(Side::length).compare(this,o);
    }

    public static Side sum(Side s1, Side s2) {return new Side(s1.length+ s2.length);}

    public boolean isNotLessThan(Side s1) {return length>=s1.length;}
}
