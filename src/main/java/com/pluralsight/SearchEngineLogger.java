package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {

        // while loop
        // if user enters search term
        // then write first search term
        // keep writing search term until loop ends
        // loop ends when user types in search term
        // when loop ends write exit to file

        Scanner myscanner = new Scanner(System.in);

        // 2026-04-22 12:42:20 launch
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        LocalDateTime dateRightNow = LocalDateTime.now();

        try {
            FileWriter fileWriter = new FileWriter("logs.txt");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            String text = String.format(" launch");
            bufWriter.write(dateRightNow.format(format1));
            bufWriter.write(text);
            bufWriter.write("\n");
            System.out.println("Enter a search term (X or x to exit):");
            //String searchTerm = myscanner.nextLine();

            // loop
            boolean notX = true;
            while (notX) {
                String searchTerm = myscanner.nextLine();
                if (searchTerm.equalsIgnoreCase("x")) {
                    //bufWriter.write("\n");
                    bufWriter.write(dateRightNow.format(format1));
                    bufWriter.write(" exit");
                    notX = false;
                    break;
                }
                // write to the file
                bufWriter.write(dateRightNow.format(format1));
                bufWriter.write("search " + searchTerm);
                bufWriter.write("\n");

            }
            bufWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
