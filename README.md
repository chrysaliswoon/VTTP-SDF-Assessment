# Project Set-up
- [X] Create a private git repo
- [X] Clone repo
- [X] Add .gitignore file - Ignore target directory

# Task 01 - Mail Merge

- [X] Generate a Maven project

**Takes 2 parameters from the command line** 

Run the program using the following terminal command:
- [X] java assessment.core.Main <CSV file> <template file>


**Data Source (CSV) File Format**

- 1st Row: Variable names (no spaces) to be substituted into the template
- Subsequent Rows: Data

- [X] Load and Read the CSV file using Hashmap
- [X] Able to get specific values

**Template File Format**

- [X] Produces the text according to the variables indicated
- [X] Both sets of data file are able to load correctly

**Issues**
- The current code doesn't detect by line so if there is another type of file with different values, this program will not work
- THe program only writes out one template email instead of all of them

# Task 02 - Client Application

- [X] Generate a Maven project

**Establish connnection with Server**

- [X] Client is able to connect to the server (task02.chuklee.com) on PORT 80
- [X] Use readUTF to read initial req. from server
- [X] Calculate average for the list of integers
- [X] Write answer back to the server
- [X] Server sends back a true/false response
- [X] If response is true, close socket connection and print "SUCCESS"

### Resources:

- https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
- https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html 