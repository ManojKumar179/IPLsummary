package com.manoj.ipl.beans;


/**
 * This is a Request class
 */
public class TeamsBoundariesCount {
    private int year;
    private String team;
    int foursCount;
    int sixesCount;
    int totalScore;

    public TeamsBoundariesCount(int year, String team, int foursCount, int sixesCount, int totalScore) {
        this.year = year;
        this.team = team;
        this.foursCount = foursCount;
        this.sixesCount = sixesCount;
        this.totalScore = totalScore;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getFoursCount() {
        return foursCount;
    }

    public void setFoursCount(int foursCount) {
        this.foursCount = foursCount;
    }

    public int getSixesCount() {
        return sixesCount;
    }

    public void setSixesCount(int sixesCount) {
        this.sixesCount = sixesCount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "TeamsBoundariesCount{" +
                "year='" + year + '\'' +
                ", team='" + team + '\'' +
                ", foursCount=" + foursCount +
                ", sixesCount=" + sixesCount +
                ", totalScore=" + totalScore +
                '}';
    }
}
