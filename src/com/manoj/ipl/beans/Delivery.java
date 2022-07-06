package com.manoj.ipl.beans;

public class Delivery {
    private String matchId;
    private String inning;
    private String battingTeam;
    private String bowlingTeam;
    private int over;
    private int ball;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private String isSuperOver;
    private int wideRuns;
    private int byeRuns;
    private int legByeRuns;
    private int noBallRuns;
    private int penaltyRuns;
    private int batsmanRuns;
    private int extraRuns;
    private int totalRuns;
    private String playerDismissed;
    private String dismissalKind;
    private String fielder;

    public Delivery(String matchId, String inning, String battingTeam, String bowlingTeam, int over, int ball, String batsman, String nonStriker, String bowler, String isSuperOver, int wideRuns, int byeRuns, int legByeRuns, int noBallRuns, int penaltyRuns, int batsmanRuns, int extraRuns, int totalRuns, String playerDismissed, String dismissalKind, String fielder) {
        this.matchId = matchId;
        this.inning = inning;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        this.isSuperOver = isSuperOver;
        this.wideRuns = wideRuns;
        this.byeRuns = byeRuns;
        this.legByeRuns = legByeRuns;
        this.noBallRuns = noBallRuns;
        this.penaltyRuns = penaltyRuns;
        this.batsmanRuns = batsmanRuns;
        this.extraRuns = extraRuns;
        this.totalRuns = totalRuns;
        this.playerDismissed = playerDismissed;
        this.dismissalKind = dismissalKind;
        this.fielder = fielder;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getIsSuperOver() {
        return isSuperOver;
    }

    public void setIsSuperOver(String isSuperOver) {
        this.isSuperOver = isSuperOver;
    }

    public int getWideRuns() {
        return wideRuns;
    }

    public void setWideRuns(int wideRuns) {
        this.wideRuns = wideRuns;
    }

    public int getByeRuns() {
        return byeRuns;
    }

    public void setByeRuns(int byeRuns) {
        this.byeRuns = byeRuns;
    }

    public int getLegByeRuns() {
        return legByeRuns;
    }

    public void setLegByeRuns(int legByeRuns) {
        this.legByeRuns = legByeRuns;
    }

    public int getNoBallRuns() {
        return noBallRuns;
    }

    public void setNoBallRuns(int noBallRuns) {
        this.noBallRuns = noBallRuns;
    }

    public int getPenaltyRuns() {
        return penaltyRuns;
    }

    public void setPenaltyRuns(int penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public void setBatsmanRuns(int batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public String getPlayerDismissed() {
        return playerDismissed;
    }

    public void setPlayerDismissed(String playerDismissed) {
        this.playerDismissed = playerDismissed;
    }

    public String getDismissalKind() {
        return dismissalKind;
    }

    public void setDismissalKind(String dismissalKind) {
        this.dismissalKind = dismissalKind;
    }

    public String getFielder() {
        return fielder;
    }

    public void setFielder(String fielder) {
        this.fielder = fielder;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "matchId='" + matchId + '\'' +
                ", inning='" + inning + '\'' +
                ", battingTeam='" + battingTeam + '\'' +
                ", bowlingTeam='" + bowlingTeam + '\'' +
                ", over='" + over + '\'' +
                ", ball='" + ball + '\'' +
                ", batsman='" + batsman + '\'' +
                ", nonStriker='" + nonStriker + '\'' +
                ", bowler='" + bowler + '\'' +
                ", isSuperOver='" + isSuperOver + '\'' +
                ", wideRuns='" + wideRuns + '\'' +
                ", byeRuns='" + byeRuns + '\'' +
                ", legByeRuns='" + legByeRuns + '\'' +
                ", noBallRuns='" + noBallRuns + '\'' +
                ", penaltyRuns='" + penaltyRuns + '\'' +
                ", batsmanRuns='" + batsmanRuns + '\'' +
                ", extraRuns='" + extraRuns + '\'' +
                ", totalRuns='" + totalRuns + '\'' +
                ", playerDismissed='" + playerDismissed + '\'' +
                ", dismissalKind='" + dismissalKind + '\'' +
                ", fielder='" + fielder + '\'' +
                '}';
    }
}
