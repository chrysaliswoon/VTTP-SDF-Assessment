package assessment.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Template {
    String csvFile;
    String txtFile;
    csvReader reader;

    public Template(String csvFile, String txtFile) throws IOException {
        this.csvFile = csvFile;
        this.txtFile = txtFile;
    }

    public void write() throws IOException {

        File file = new File(txtFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = br.readLine()) != null) { // read through file line by line

            // array to hold replacements
            String[][] replacements = {
                    { "__address__", "Privet Drive" },
                    { "__first_name__", "Harry" },
                    { "__years__", "2" },

            };

            // loop over the array and replace
            for (String[] replacement : replacements) {
                line = line.replace(replacement[0], replacement[1]);
            }

            System.out.println(line);

        }
        br.close(); // do not forget to close the resources

    }
}
