package com.manoj.ipl.beans;

public class TeamsElectingToField {
    private int year;
    private String team;
    private int count;

    public TeamsElectingToField(int year, String team, int count) {
        this.year = year;
        this.team = team;
        this.count = count;
    }

    public int getYear() {
        return year;
    }

    public String getTeam() {
        return team;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TeamsElectingToField{" +
                "year='" + year + '\'' +
                ", team='" + team + '\'' +
                ", count=" + count +
                '}';
    }
}
