package com.manoj.ipl.beans;

public class Match {
    private String id;
    private int season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String dlApplied;
    private String winner;
    private String winByRuns;
    private String winByWickets;
    private String playerOfMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    public Match(String id, int season, String city, String date, String team1, String team2, String tossWinner, String tossDecision, String result, String dlApplied, String winner, String winByRuns, String winByWickets, String playerOfMatch, String venue, String umpire1, String umpire2, String umpire3) {
        this.id = id;
        this.season = season;
        this.city = city;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.result = result;
        this.dlApplied = dlApplied;
        this.winner = winner;
        this.winByRuns = winByRuns;
        this.winByWickets = winByWickets;
        this.playerOfMatch = playerOfMatch;
        this.venue = venue;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
        this.umpire3 = umpire3;
    }

    public String getId() {
        return id;
    }

    public int getSeason() { return season; }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public String getResult() {
        return result;
    }

    public String getDlApplied() {
        return dlApplied;
    }

    public String getWinner() {
        return winner;
    }

    public String getWinByRuns() {
        return winByRuns;
    }

    public String getWinByWickets() {
        return winByWickets;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public String getVenue() {
        return venue;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public String getUmpire3() {
        return umpire3;
    }
}
