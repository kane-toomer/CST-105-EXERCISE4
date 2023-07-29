import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;

import java.util.Scanner;

public class Contributions {
    public static void main(String[] args) {

        // Variables
        int kt_numberOfContributions = 0;
        double kt_maxContribution = 0;
        double kt_minContribution = 10000000;
        double kt_avgContribution = 0;
        double kt_totalContributions = 0;
        double kt_inputDataFromFile;

        try {
            // Create FileOutputStream and PrintWriter objects to write to input.in file
            FileOutputStream kt_fileOutputStream = new FileOutputStream("input.in");
            PrintWriter kt_printWriter = new PrintWriter(kt_fileOutputStream);

            // Random number to input.in
            int kt_numOfRandNums = 5;
            for (int i = 0; i < kt_numOfRandNums; i++) {
                double kt_randomContribution = Math.random() * 10000000;
                kt_printWriter.println(kt_randomContribution);
            }

            kt_printWriter.close();

            // Create FileInputStream and Scanner objects to read from input.in data file
            FileInputStream kt_fileInputStream = new FileInputStream("input.in");
            Scanner kt_scnr = new Scanner(kt_fileInputStream);

            // Create FileOutputStream and PrintWriter objects to write to results.out file
            FileOutputStream kt_fileOutputStreamResult = new FileOutputStream("result.out");
            PrintWriter kt_printWriterResult = new PrintWriter(kt_fileOutputStreamResult);

            // Input and process data
            do {
                kt_inputDataFromFile = kt_scnr.nextDouble();

                // count number of contributions
                kt_numberOfContributions++;

                // find maximum contribution
                if (kt_maxContribution < kt_inputDataFromFile) {
                    kt_maxContribution = kt_inputDataFromFile;
                }

                // find minimum contribution
                if (kt_minContribution > kt_inputDataFromFile) {
                    kt_minContribution = kt_inputDataFromFile;
                }

                // find average contribution
                kt_totalContributions += kt_inputDataFromFile;

            } while (kt_totalContributions < 10000000);

            kt_avgContribution = kt_totalContributions / kt_numberOfContributions;

            // Output data
            kt_printWriterResult.printf("It took %d contributions to reach the goal.\r\n", kt_numberOfContributions);
            kt_printWriterResult.printf("The maximum contribution was $%,.2f\r\n", kt_maxContribution);
            kt_printWriterResult.printf("The minimum contribution was $%,.2f\r\n", kt_minContribution);
            kt_printWriterResult.printf("The average contribution was $%,.2f\r\n", kt_avgContribution);
            kt_printWriterResult.printf("The total contributions were $%,.2f\r\n", kt_totalContributions);

            // Close objects
            kt_scnr.close();
            kt_printWriterResult.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}