package com.manoj.ipl.beans;

public class NetRunRatePerSeason {
    private int year;
    private String team;
    private int runs;
    private double overs;
    private double netRunRate;

    public NetRunRatePerSeason(int year, String team, int runs, double overs, double netRunRate) {
        this.year = year;
        this.team = team;
        this.runs = runs;
        this.overs = overs;
        this.netRunRate = netRunRate;
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

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public double getNetRunRate() {
        return netRunRate;
    }

    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    @Override
    public String toString() {
        return "NetRunRatePerSeason{" +
                "year=" + year +
                ", team='" + team + '\'' +
                ", runs=" + runs +
                ", overs=" + overs +
                ", netRunRate=" + netRunRate +
                '}';
    }
}
