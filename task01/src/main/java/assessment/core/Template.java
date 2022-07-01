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

            csvReader csvData = new csvReader(csvFile);
            csvData.start();
            String line1 = csvData.getLine1();
            String line2 = csvData.getLine2();
            String line3 = csvData.getLine3();
            String line4 = csvData.getLine4();

            // array to hold replacements
            String[][] replacements = {
                    { "__address__", line3 },
                    { "__first_name__", line1 },
                    { "__years__", line4},
                    { "__salutations__", line1},
                    { "__last_name__", line2},
                    { "__package_name__", line3},
                    { "__price__", line4},

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
