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
    String first_name;
    String last_name;
    String address;
    String years;

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
                String first_name = keyValuePair[0];
                String last_name = keyValuePair[1];
                String address = keyValuePair[2];
                String years = keyValuePair[3];
                fileData.put("Line 1", first_name);
                fileData.put("Line 2", last_name);
                fileData.put("Line 3", address);
                fileData.put("Line 4", years);

                // System.out.println(fileData.get("Line 1"));

            } 
            count++; // count increments as you read lines

            
        }
        br.close(); // do not forget to close the resources
    }
}
