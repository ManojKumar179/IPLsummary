# Java Project for processing IPL Data from 2008-2017

### Dataset 
1. matches.csv
2. deliveries.csv

#### Problem 1: Top 4 teams which elected to field first after winning toss in 2016 and 2017.

    Output Expected: YEAR TEAM COUNT
#### Problem 2: List total number of fours, sixes, total score with respect to team and year.

    Output Expected: YEAR TEAM_NAME FOURS_COUNT SIXES_COUNT TOTAL_SCORE
#### Problem 3: Top 10 best economy rate bowler with respect to year who bowled at least 10 overs

    LEGBYE_RUNS and BYE_RUNS should not be considered for Total Runs Given by a bowler
    Economy = (Total Runs Given / Overs bowled)
    Output Expected: YEAR PLAYER ECONOMY
#### Problem 4: Find the team name which has Highest Net Run Rate with respect to year.

    Net Run Rate = (Total Runs Scored / Total Overs Faced) – (Total Runs Conceded /Total Overs Bowled)