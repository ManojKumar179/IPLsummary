package com.manoj.ipl.service;

import com.manoj.ipl.beans.Delivery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveriesDataCSVReader {
    public List<Delivery> readData(String filePath) {
        String line;
        int lineNum = 0; // to ignore headers in the csv file
        List<Delivery> deliveries = new ArrayList<>();
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
                deliveries.add(
                    new Delivery(
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        Integer.parseInt(row[4]),
                        Integer.parseInt(row[5]),
                        row[6],
                        row[7],
                        row[8],
                        row[9],
                        Integer.parseInt(row[10]),
                        Integer.parseInt(row[11]),
                        Integer.parseInt(row[12]),
                        Integer.parseInt(row[13]),
                        Integer.parseInt(row[14]),
                        Integer.parseInt(row[15]),
                        Integer.parseInt(row[16]),
                        Integer.parseInt(row[17]),
                        row[18],
                        row[19],
                        row[20]
                    )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deliveries;
    }
}
