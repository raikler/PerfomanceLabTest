package com.company;

import java.util.Objects;

public class Intervals implements Comparable<Intervals>{
    private short hourIn;
    private short hourOut;
    private short minIn;
    private short minOut;
    private short people;



    public Intervals(short hourIn, short minIn, short hourOut, short minOut) {
        this.hourIn = hourIn;
        this.hourOut = hourOut;
        this.minIn = minIn;
        this.minOut = minOut;
        people = 0;
    }

    public Intervals(short hourIn, short minIn, short hourOut, short minOut, short people) {
        this.hourIn = hourIn;
        this.hourOut = hourOut;
        this.minIn = minIn;
        this.minOut = minOut;
        this.people = people;
    }
    public short getMinIn() {
        return minIn;
    }

    public short getMinOut() {
        return minOut;
    }
    public short getPeople() {
        return people;
    }

    public short getHourIn() {
        return hourIn;
    }

    public short getHourOut() {
        return hourOut;
    }

    public void setHourIn(short hourIn) {
        this.hourIn = hourIn;
    }

    public void setHourOut(short hourOut) {
        this.hourOut = hourOut;
    }

    public void setMinIn(short minIn) {
        this.minIn = minIn;
    }

    public void setMinOut(short minOut) {
        this.minOut = minOut;
    }

    public void setPeople(short people) {
        this.people = people;
    }

    @Override
    public int compareTo(Intervals o) {
        return (this.getPeople() < o.getPeople() ? -1 :
                (this.getPeople() == o.getPeople() ? 0 : 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intervals intervals = (Intervals) o;
        return hourIn == intervals.hourIn && hourOut == intervals.hourOut && minIn == intervals.minIn && minOut == intervals.minOut && people == intervals.people;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hourIn, hourOut, minIn, minOut, people);
    }
}
