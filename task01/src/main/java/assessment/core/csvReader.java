package assessment.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Read CSV file as comma separated values
 */

public class csvReader {

    String csvFile;

    public csvReader(String csvFile) throws IOException {
        this.csvFile = csvFile;
    }

    
    public void start() throws IOException {

        File file = new File(csvFile);
        System.out.println(file.exists());

        //? List that holds the strings of a file
        ArrayList<String> fileData = new ArrayList<String>();

        //? Load data from file
        BufferedReader bf = new BufferedReader(new FileReader(file));

        //? Read entire line as string
        String line = bf.readLine();

        //? Checking for the end of the file
        while (line != null) {
            fileData.add(line);
            line = bf.readLine();
        }

        //? Closing bufferedreader
        bf.close();

        //? Store data in arraylist
        String[] dataArr = fileData.toArray(new String[0]);

        //? Printing each line of file stored in array
        for (String str: dataArr) {
            System.out.println(str);
        }
    }

}
