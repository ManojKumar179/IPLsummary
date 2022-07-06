package com.manoj.ipl.beans;

public class BowlerStats {
    private int year;
    private String player;
    private int runs;
    private double oversBowled;
    private double economy;

    public BowlerStats(int year, String player, int runs, double oversBowled, double economy) {
        this.year = year;
        this.player = player;
        this.runs = runs;
        this.oversBowled = oversBowled;
        this.economy = economy;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(double oversBowled) {
        this.oversBowled = oversBowled;
    }

    @Override
    public String toString() {
        return "BowlerStats{" +
                "year=" + year +
                ", player='" + player + '\'' +
                ", runs=" + runs +
                ", oversBowled=" + oversBowled +
                ", economy=" + economy +
                '}';
    }
}
