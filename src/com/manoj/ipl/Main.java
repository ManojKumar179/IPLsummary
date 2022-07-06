package com.manoj.ipl;

import com.manoj.ipl.beans.*;
import com.manoj.ipl.service.DeliveriesDataCSVReader;
import com.manoj.ipl.service.MatchesDataCSVReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main{

    // Helper Function for Problem 1
    public static TeamsElectingToField getKey(List<TeamsElectingToField> list, Match match) {
        for (TeamsElectingToField item : list) {
            if (item.getYear() == match.getSeason() && item.getTeam().equalsIgnoreCase(match.getTossWinner())) {
                return item;
            }
        }

        return null;
    }

    public static void problem1 (List<Match> matches) {
        List<TeamsElectingToField> list = new ArrayList<>();

        matches.forEach(match -> {
            if (match.getSeason() == 2016 || match.getSeason() == 2017) {
                if ((match.getTeam1().equalsIgnoreCase(match.getTossWinner())|| match.getTeam2().equalsIgnoreCase(match.getTossWinner()))
                        && match.getTossDecision().equalsIgnoreCase("field")) {
                    TeamsElectingToField key = getKey(list, match);
                    if (key != null) {
                        key.setCount(key.getCount() + 1);
                    } else {
                        list.add(new TeamsElectingToField(match.getSeason(), match.getTossWinner(), 1));
                    }
                }
            }
        });

        // sorting based on count
        list.sort(((o1, o2) -> Integer.compare(o2.getCount(), o1.getCount())));

        System.out.println("============================================================================");
        System.out.println("Top 4 teams which elected to field first after winning toss in 2016 and 2017");
        System.out.println("============================================================================");
        list.subList(0, 4).forEach(System.out::println);
    }

    // Helper Function for Problem 1
    public static TeamsBoundariesCount getTeamsBoundariesCountKeys(List<TeamsBoundariesCount> list, int year, String team) {
        for (TeamsBoundariesCount item : list) {
            if (item.getYear() == year && item.getTeam().equalsIgnoreCase(team)) {
                return item;
            }
        }

        return null;
    }

    public static Match getMatchById(List<Match> list, String id) {
        for (Match match : list) {
            if (match.getId().equalsIgnoreCase(id)) return match;
        }

        return null;
    }

    public static void problem2 (List<Match> matches, List<Delivery> deliveries) {
        List<TeamsBoundariesCount> teamsBoundariesCounts = new ArrayList<>();

        deliveries.forEach(delivery -> {
            Match match = getMatchById(matches, delivery.getMatchId());
            TeamsBoundariesCount keys = getTeamsBoundariesCountKeys(
                teamsBoundariesCounts,
                match.getSeason(),
                delivery.getBattingTeam()
            );

            if (keys != null) {
                keys.setFoursCount(delivery.getBatsmanRuns() == 4 ? keys.getFoursCount() + 1 : keys.getFoursCount());
                keys.setSixesCount(delivery.getBatsmanRuns() == 6 ? keys.getSixesCount() + 1 : keys.getSixesCount());
                keys.setTotalScore(keys.getTotalScore() + delivery.getTotalRuns());
            } else {
                teamsBoundariesCounts.add(
                    new TeamsBoundariesCount(
                        match.getSeason(),
                        delivery.getBattingTeam(),
                        delivery.getBatsmanRuns() == 4 ? 1 : 0,
                        delivery.getBatsmanRuns() == 6 ? 1 : 0,
                        delivery.getTotalRuns()
                    )
                );
            }
        });

        System.out.println("=======================================================================");
        System.out.println("Total number of fours, sixes, total score with respect to team and year");
        System.out.println("=======================================================================");
        teamsBoundariesCounts.forEach(System.out::println);
    }

    public static BowlerStats getBowlerStatsBySeason (List<BowlerStats> list, int year, String name) {
        for (BowlerStats stats : list) {
            if (stats.getPlayer().equalsIgnoreCase(name) && stats.getYear() == year) return stats;
        }

        return null;
    }

    public static void problem3 (List<Match> matches, List<Delivery> deliveries) {
        List<BowlerStats> bowlerStatsList = new ArrayList<>();

        deliveries.forEach(delivery -> {
            Match match = getMatchById(matches, delivery.getMatchId());

            BowlerStats bowlerStatsBySeason = getBowlerStatsBySeason(bowlerStatsList, match.getSeason(), delivery.getBowler());
            int totalRuns =(delivery.getTotalRuns() - delivery.getLegByeRuns() - delivery.getByeRuns());

            if (bowlerStatsBySeason != null) {
                if (delivery.getNoBallRuns() != 0 || delivery.getWideRuns() != 0) {
                    bowlerStatsBySeason.setOversBowled(bowlerStatsBySeason.getOversBowled());
                } else {
                    bowlerStatsBySeason.setOversBowled(
                        (bowlerStatsBySeason.getOversBowled() * 10) % 10 == 5
                            // Incrementing the oversBowled to 0.5 when the current ball is the fifth ball of the over else 0.1.
                            // Rounding the decimals to 2 places cause adding two double numbers in java might not give
                            // exact result that we expect (eg: In Java, 0.1 + 0.2 == 0.30000000000000004)
                            ? Math.round((bowlerStatsBySeason.getOversBowled() + 0.5) * 100) / 100D
                            : Math.round((bowlerStatsBySeason.getOversBowled() + 0.1) * 100) / 100D
                    );
                }

                bowlerStatsBySeason.setRuns(bowlerStatsBySeason.getRuns() + totalRuns);
                bowlerStatsBySeason.setEconomy(
                    // Rounding the decimals to 2 places
                    Math.round((bowlerStatsBySeason.getRuns() / bowlerStatsBySeason.getOversBowled()) * 100) / 100D
                );
            } else {
                bowlerStatsList.add(
                    new BowlerStats(
                        match.getSeason(),
                        delivery.getBowler(),
                        totalRuns,
                        0.1,
                        Math.round((totalRuns / 0.1)  * 100) / 100D // Rounding the decimals to 2 places
                    )
                );
            }
        });

        List<BowlerStats> bowlerStats = bowlerStatsList
            .stream()
            .filter(stats -> stats.getOversBowled() >= 10.0D)
            .sorted(Comparator.comparingDouble(BowlerStats::getEconomy).reversed())
            .collect(Collectors.toList());

        System.out.println("=================================================================================");
        System.out.println("Top 10 best economy rate bowler with respect to year who bowled at least 10 overs");
        System.out.println("=================================================================================");
        bowlerStats.subList(0, 10).forEach(System.out::println);
    }

    public static NetRunRatePerSeason getNetRunRatePerSeason (List<NetRunRatePerSeason> list, int year, String team) {
        for (NetRunRatePerSeason netRunRatePerSeason : list) {
            if (netRunRatePerSeason.getYear() == year && netRunRatePerSeason.getTeam().equalsIgnoreCase(team)) {
                return netRunRatePerSeason;
            }
        }

        return null;
    }

    public static NetRunRatePerSeason getNetRunRatePerSeasonByYear (List<NetRunRatePerSeason> list, int year) {
        for (NetRunRatePerSeason netRunRatePerSeason : list) {
            if (netRunRatePerSeason.getYear() == year) {
                return netRunRatePerSeason;
            }
        }

        return null;
    }

    public static void problem4 (List<Match> matches, List<Delivery> deliveries) {
        List<NetRunRatePerSeason> netRunRatePerSeasons = new ArrayList<>();

        deliveries.forEach(delivery -> {
            Match match = getMatchById(matches, delivery.getMatchId());

            NetRunRatePerSeason netRunRatePerSeason = getNetRunRatePerSeason(
                netRunRatePerSeasons,
                match.getSeason(),
                delivery.getBattingTeam()
            );

            if (netRunRatePerSeason != null) {
                netRunRatePerSeason.setRuns(netRunRatePerSeason.getRuns() + delivery.getTotalRuns());

                if (delivery.getNoBallRuns() != 0 || delivery.getWideRuns() != 0) {
                    netRunRatePerSeason.setOvers(netRunRatePerSeason.getOvers());
                } else {
                    netRunRatePerSeason.setOvers(
                        (netRunRatePerSeason.getOvers() * 10) % 10 == 5
                            // Incrementing the oversBowled to 0.5 when the current ball is the fifth ball of the over else 0.1.
                            // Rounding the decimals to 2 places cause adding two double numbers in java might not give
                            // exact result that we expect (eg: In Java, 0.1 + 0.2 == 0.30000000000000004)
                            ? Math.round((netRunRatePerSeason.getOvers() + 0.5) * 100) / 100D
                            : Math.round((netRunRatePerSeason.getOvers() + 0.1) * 100) / 100D
                    );
                }

                netRunRatePerSeason.setNetRunRate(
                    // Rounding the decimals to 2 places
                    Math.round((netRunRatePerSeason.getRuns() / netRunRatePerSeason.getOvers()) * 100) / 100D
                );
            } else {
                netRunRatePerSeasons.add(
                    new NetRunRatePerSeason(
                        match.getSeason(),
                        delivery.getBattingTeam(),
                        delivery.getTotalRuns(),
                        0.1,
                        Math.round((delivery.getTotalRuns() / 0.1) * 100) / 100D  // Rounding the decimals to 2 places
                    )
                );
            }
        });

        // Filtering the team which have highest net run rate per season
        List<NetRunRatePerSeason> topNetRunRateTeamPerSeasons = new ArrayList<>();

        netRunRatePerSeasons.forEach(netRunRatePerSeason -> {
            NetRunRatePerSeason runRatePerSeason = getNetRunRatePerSeasonByYear(topNetRunRateTeamPerSeasons, netRunRatePerSeason.getYear());

            if (runRatePerSeason != null) {
                if (runRatePerSeason.getNetRunRate() < netRunRatePerSeason.getNetRunRate()) {
                    runRatePerSeason.setTeam(netRunRatePerSeason.getTeam());
                    runRatePerSeason.setNetRunRate(netRunRatePerSeason.getNetRunRate());
                }
            } else {
                // Using the exiting object reference here. So any change in the object is
                // gonna effect the objects in netRunRatePerSeasons list
                topNetRunRateTeamPerSeasons.add(netRunRatePerSeason);
            }
        });

        System.out.println("=========================================================");
        System.out.println("Teams which has Highest Net Run Rate with respect to year");
        System.out.println("=========================================================");
        topNetRunRateTeamPerSeasons.forEach(System.out::println);
    }

    public static void main(String[] args) {
        DeliveriesDataCSVReader deliveriesDataCSVReader = new DeliveriesDataCSVReader();
        List<Delivery> deliveries = deliveriesDataCSVReader.readData("src/com/manoj/ipl/dataset/deliveries.csv");

        MatchesDataCSVReader matchesDataCSVReader = new MatchesDataCSVReader();
        List<Match> matches = matchesDataCSVReader.readData("src/com/manoj/ipl/dataset/matches.csv");

        // problem 1: Top 4 teams which elected to field first after winning toss in 2016 and 2017.
        // Output Expected: YEAR TEAM COUNT
        Main.problem1(matches);

        // problem 2: List total number of fours, sixes, total score with respect to team and year.
        // Output Expected: YEAR TEAM_NAME FOURS_COUNT SIXES_COUNT TOTAL_SCORE
        Main.problem2(matches, deliveries);

        // problem 3: Top 10 best economy rate bowler with respect to year who bowled at least 10 overs
        // (LEGBYE_RUNS and BYE_RUNS should not be considered for Total Runs Given by a bowler)
        // Economy = (Total Runs Given/Overs bowled) Output Expected: YEAR PLAYER ECONOMY
        Main.problem3(matches, deliveries);

        // problem 4: Find the team name which has Highest Net Run Rate with respect to year.
        // Net Run Rate = (Total Runs Scored / Total Overs Faced) – (Total Runs Conceded /Total Overs Bowled)
        Main.problem4(matches, deliveries);
    }
}
