package assessment.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.Data;

/*
 * Read CSV file as comma separated values
 */

public class csvReader {

    String csvFile;
    String line1;
    String line2;
    String line3;

    public String getLine1() {
        return line1;
    }



    public void setLine1(String line1) {
        this.line1 = line1;
    }



    public String getLine2() {
        return line2;
    }



    public void setLine2(String line2) {
        this.line2 = line2;
    }



    public String getLine3() {
        return line3;
    }



    public void setLine3(String line3) {
        this.line3 = line3;
    }



    public String getLine4() {
        return line4;
    }



    public void setLine4(String line4) {
        this.line4 = line4;
    }



    String line4;

    public csvReader(String csvFile) throws IOException {
        this.csvFile = csvFile;
    }



    public void start() throws IOException {
        File file = new File(csvFile);

        // ? List that holds the strings of a file
        HashMap<String, String> fileData = new HashMap<>();

        // ? Load data from file
        BufferedReader br = new BufferedReader(new FileReader(file));

        // ? Read first line from file
        // String line = br.readLine();
        String line = null;
        int count = 0;

        // ? Loop until all lines are read
        while ((line = br.readLine()) != null ) { // read through file line by line

            if (count != 0) { // count == 0 means the first line
                String[] keyValuePair = line.split(",");
                String line1 = keyValuePair[0];
                String line2 = keyValuePair[1];
                String line3 = keyValuePair[2];
                String line4 = keyValuePair[3];
                fileData.put("Line 1", line1);
                fileData.put("Line 2", line2);
                fileData.put("Line 3", line3);
                fileData.put("Line 4", line4);

                this.line1 = fileData.get("Line 1");
                this.line2 = fileData.get("Line 2");
                this.line3 = fileData.get("Line 3");
                this.line4 = fileData.get("Line 4");


                // System.out.println(address);

            } 
            count++; // count increments as you read lines

            
        }
        br.close(); // do not forget to close the resources
    }


}
