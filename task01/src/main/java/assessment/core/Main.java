package assessment.core;

import java.io.File;
import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String csvFile;
        String txtFile;
        Template template;


        if (args.length > 0) {
            csvFile = "../" + args[0];
            txtFile = "../" + args[1];

            //? Sends the files
            template = new Template(csvFile, txtFile);
            template.write(); 
        }
        
    }
}
