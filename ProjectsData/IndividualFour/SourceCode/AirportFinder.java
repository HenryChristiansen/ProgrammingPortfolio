import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class AirportFinder {
  public static void main (String[] args) {
    File airportFile;
    Scanner fileScanner;
    try {
      airportFile = new File("airport.txt");
      fileScanner = new Scanner (airportFile, "UTF-8");
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the name of a city to find all airports in that city.\n");
      System.out.print("Name of City: ");
      String cityName = scan.next();
      cityName = '"' + cityName + '"';
      String line;
      boolean found = false;
      while (fileScanner.hasNextLine()) {
        line = fileScanner.nextLine();
        String[] splitLine = line.split(",");
        for (int i = 0; i < 13; i++) {
          if (splitLine[i].equals(cityName)) {
            found = true;
            System.out.println("Airport: " + splitLine[i-1].substring(1,splitLine[i-1].length()-1));
          }
        }
      }
      if (!found) {
        System.out.println("No airport found.");
      }
      fileScanner.close();
      scan.close();
    } catch (FileNotFoundException exception) {
      System.out.println("File not found.");
    }
  }
}
