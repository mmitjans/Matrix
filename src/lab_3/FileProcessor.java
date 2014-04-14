package lab_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for processing an input file. Each string in a 
 * line is put into a list. Also it writes to the output file a string.
 */
public class FileProcessor {
    
    private Path fFilePath;
    // UTF-8 Encoding
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    
    // Variables that stores the input/output filenames
    private String inputFile;
    private String outputFile;
    // Use to write into a file
    private BufferedWriter writer = null;
    
    /**
     * Constructor of this class. Takes the input/output file to read/write
     * 
     * @param inputFile Input file to read the strings
     */
    public FileProcessor(String inputFile, String outputFile)
    {
        this.inputFile = inputFile;
        this.outputFile = outputFile; 
        try {
            File file = new File(outputFile);
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {

        } 
    }
    
    /**
     * Parses the file input and puts each string into a list.
     * @return List containing a string appended in the file
     * @throws IOException Thrown when an error occurs processing
     * the file.
     */
    public Queue<String> listOfStrings() throws IOException
    {
        Queue<String> listOfStrings = new LinkedList<String>();
        
        fFilePath = Paths.get(this.inputFile);

        Scanner scanner = new Scanner(fFilePath, ENCODING.name());

        while (scanner.hasNextLine()) {
            listOfStrings.add(scanner.nextLine());
        }
        
        return listOfStrings;
    }
    
    /**
     * This method prints this input into a file
     * @param output String to append into the file
     */
    public void printToFile(String output)
    {
        try {
            writer.write(output);
            writer.newLine();
        } catch (IOException ex) {
            // exception is fine
        } 
    }
    
    /**
     * Closes the writer object use to write into a file
     */
    public void closeWriter()
    {
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

}

