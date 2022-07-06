package com.manoj.ipl.service;

import com.manoj.ipl.beans.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesDataCSVReader {
    public List<Match> readData(String filePath) {
        String line;
        int lineNum = 0; // to ignore headers in the csv file
        List<Match> matches = new ArrayList<>();
        Map<String, Object> rowMap = new HashMap<>();

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (lineNum == 0) {
                    lineNum++;
                    continue;
                }

                String[] row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                matches.add(
                    new Match(
                        row[0],
                        Integer.parseInt(row[1]),
                        row[2],
                        row[3],
                        row[4],
                        row[5],
                        row[6],
                        row[7],
                        row[8],
                        row[9],
                        row[10],
                        row[11],
                        row[12],
                        row[13],
                        row[14],
                        row[15],
                        row[16],
                        row[17]
                    )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matches;
    }
}
