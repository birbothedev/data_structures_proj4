package proj4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        TriageSimulator simulator = new TriageSimulator();
        String filepath = "patients.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null){
                simulator.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}