package assessment.core;

import java.io.File;
import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String csvFile;
        String txtFile;
        csvReader reader;

        if (args.length > 0) {
            csvFile = args[0];
            txtFile = args[1];

            //? Sends the txtfile over to the csvreader
            reader = new csvReader("../" + csvFile);
            reader.start(); 
        }
        
    }
}
