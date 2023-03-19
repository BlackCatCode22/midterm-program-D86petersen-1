/* JavaMidtermSpr23.java
* Dustin Petersen 3/19/23
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class JavaMidtermSpr23 {
//   created method to calculate birthday from season born
    static String calcBirth(int yearsOld, String birthSeason) {
        // assigned variable year to the current year subtracted by yearsOld variable
        int year = 2023 - yearsOld ;
        // declared variables monthDay, and newDate but didn't assign them
        String monthDay;
        String newDate;
        // use switch case statement taking in parameter of birthSeason
        switch (birthSeason) {
            case "spring,":
                monthDay = "03-21";
                break;
            case "summer,":
                monthDay = "06-21";
                break;
            case "fall,":
                monthDay = "09-21";
                break;
            case "winter,":
                monthDay = "12-21";
                break;
            default:
                monthDay = "01-01";
                break;
        }
        // assigned variable newDate to a string of year-monthDay
        newDate = Integer.toString(year) + "-" + monthDay;
        // returned the newDate
        return newDate;
    }
    // created method to generate unique id for each animal
    static String genUniqueID(String speciesName, int numOfSpecies) {
        // declared a string variable uniqueID but didnt assign it
        String uniqueID;
        // used switch case statement to give unique id based on type of animal
        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy0" + Integer.toString(numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li0" + Integer.toString(numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti0" + Integer.toString(numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be0" + Integer.toString(numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        // returned the uniqueID
        return uniqueID;
    }
    public static void main(String[] args) {
        System.out.println("\n\nWelcome to the zoo!\n\n");
// Global variables used for species populations
        int numOfHyenas = 0;
        int numOfLions = 0;
        int numOfTigers = 0;
        int numOfBears = 0;


// We have four animals of each species, therefore, we create four arrays of four elements.
                String[] hyenas = new String[4];
        hyenas[0] = "the first hyena";
        System.out.println("hyenas[0] is: " + hyenas[0]);
        String[] lions = new String[4];
        lions[0] = "the first lion";
        System.out.println("lions[0] is: " + lions[0]);
        String[] tigers = new String[4];;
        String[] bears = new String[4];;


// Create a String array with 16 elements.
        String[] arrivingAnimals = new String[16];
// Use Scanner class to open the arrivingAnimals.txt file. This is the file we use for input
// used try catch block to use scanner to open file
        try {
            File myAnimalsFile = new
                    File("C:\\Users\\d86pe\\OneDrive\\Desktop\\FCC\\CIT63\\midterm-program-D86petersen-1\\arrivingAnimals.txt");
            Scanner scanner = new Scanner(myAnimalsFile);
            System.out.println("\n The arrivingAnimals.txt file...\n");
// declared int variable animalNum and assigned it to 0
// animalNum used in while loop to iterate array
            int animalNum = 0;

// while loop to iterate
            while (scanner.hasNextLine()) {
// Read a line from scanner into a string object named "animal"
                String animal = scanner.nextLine();
// Assign this line of text to our arrivingAnimals[] array

                arrivingAnimals[animalNum] = animal;
// Increment to go to next array element
                        animalNum++;

            }
// closed the file
            scanner.close();
        // catch block to throw error if file isn't read
        } catch (FileNotFoundException e) {
            System.out.println("\n A file error occured...");
            e.printStackTrace();
        }

// Variables needed for string processing.
        int position = 0;
// Variables needed to process the array.
        int years = 0;
        String season;
        String sex;
        String species;
        String birthdate;
        String color;
        String origin;
        String weight;
        String name;
        String uniqueID = "";
        String arrived;

// Quickest way to do this is to create four 1-D string arrays with names.
// Bonus points if your program opened the file named "animalNames.txt" to
       // create these arrays!
                String[] hyenaNames = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou",
                "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
        String[] lionNames = {"Scar", "Mufasa", "Simba", "Kiara", "King",
                "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
        String[] bearNames = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle",
                "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
        String[] tigerNames = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles",
                "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};

// for loop to iterate the names arrays
        for (int i = 0; i < 16; i++) {
// Split the string into words.


// putting the split words into a string array
            String[] splitStr = arrivingAnimals[i].split(" ", 0);


// We use two elements from our split to calculate a birthday - years (an
           // int) and season (a String)
// Calculate birthday using years old and birth season
            birthdate = calcBirth(Integer.parseInt(splitStr[0]), splitStr[7]);
            System.out.println("birthDate is: " + birthdate);
// Find incoming animal sex.
            sex = splitStr[3];
            System.out.println("sex is: " + sex);
// Find incoming animal species.
            species = splitStr[4];
            System.out.println("species is: " + species);
// Delete the trailing comma.
            position = species.indexOf(",");
            System.out.println("position of comma is: " + position);
// substring() arguments: beginning index, ending index-1
            species = species.substring(0, position);
            System.out.println("species is now: " + species);


// if else statement logic to get species and increment it by 1 as well as assign a unique id
            if (species.equals("hyena")) {
                numOfHyenas++;
                uniqueID = genUniqueID(species, numOfHyenas);
            } else if (species.equals("lion")) {
                numOfLions++;
                uniqueID = genUniqueID(species, numOfLions);
            } else if (species.equals("tiger")) {
                numOfTigers++;
                uniqueID = genUniqueID(species, numOfTigers);
            } else if (species.equals("bear")) {
                numOfBears++;
                uniqueID = genUniqueID(species, numOfBears);
            } else {
                System.out.println("An error has occurred");
            }
// Let's take a look at the numbers and... uniqueID
            System.out.println("numOfHyenas = " + numOfHyenas);
            System.out.println("numOfLions = " + numOfLions);
            System.out.println("numOfTigers = " + numOfTigers);
            System.out.println("numOfBears = " + numOfBears);
            System.out.println("uniqueID = " + uniqueID);
// finding color
            // created string array and using split method to split it by comma
            String[] splitStrComma = arrivingAnimals[i].split(",", 0);
// Output the split
            for (String s : splitStrComma) {
                System.out.println(s);
            }

// assigning color variable to splitStrComma[2]
            color = splitStrComma[2];
            System.out.println("color = " + color);
// get weight and origin
            weight = splitStrComma[3];

            origin = splitStrComma[4] + "," + splitStrComma[5];
            System.out.println("weight = " + weight);
            System.out.println("origin = " + origin);
// Use uniqueID to get a name!
            String uniqueIDPrefix = uniqueID.substring(0, 2);
            System.out.println("uniqueIDPrefix = " + uniqueIDPrefix);
            String uniqueIDSuffix = uniqueID.substring(2);
            System.out.println("uniqueIDSuffix = " + uniqueIDSuffix);
            int suffixAsInt = Integer.parseInt(uniqueIDSuffix);
            System.out.println("suffixAsInt = " + suffixAsInt);

// Use a switch statement to check for unique id prefix and use it to assign a name
            switch (uniqueIDPrefix) {
                case "Hy":
                    name = hyenaNames[suffixAsInt];
                    break;
                case "Li":
                    name = lionNames[suffixAsInt];
                    break;
                case "Ti":
                    name = tigerNames[suffixAsInt];
                    break;
                case "Be":
                    name = bearNames[suffixAsInt];
                    break;
                default:
                    name = "error in name switch statement";
                    break;
            }
            System.out.println("name is: " + name);

// declared string variable arrivalDate but didnt assign
            String arrivalDate;
// used LocalDate to get the current date
            LocalDate currentDate = LocalDate.now();
            // declared variable arrivalDate and assigned it to current date as a string
            arrivalDate = currentDate.toString();
            System.out.println("arrivalDate: " + arrivalDate);
            LocalDate bDate = LocalDate.parse(birthdate);

// declared int variable animal age and used between() method to take in the birthdate and current date and math the maths
            int animalAge = Period.between(bDate, currentDate).getYears();
            System.out.println(" Age is: " + animalAge);

                    String outputLine;
            outputLine = uniqueID + "; " +
                    name + "; " +
                    animalAge + " years old" + "; " +
                    "birth date " + birthdate + ";" +
                    color + "; " +
                    sex + ";" +
                    weight + ";" +
                    origin + ";" +
                    " arrived " + arrivalDate;
            System.out.println("\n\n" + outputLine + "\n\n");

// Get this animal into its species array
            if (species.equals("hyena")) {
                hyenas[numOfHyenas-1] = outputLine;
            } else if (species.equals("lion")) {
                lions[numOfLions-1] = outputLine;
            } else if (species.equals("tiger")) {
                tigers[numOfTigers-1] = outputLine;
            } else if (species.equals("bear")) {
                bears[numOfBears-1] = outputLine;
            }
        }
// Output arrays to display what final output should look like
        System.out.println("\nHyena Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(hyenas[i]);
        }
        System.out.println("\nLion Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(lions[i]);
        }
        System.out.println("\nTiger Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(tigers[i]);
        }
        System.out.println("\nBear Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(bears[i]);
        }
        // try catch block to write to output file
        try {
// Create a FileWriter
            FileWriter file = new
                    FileWriter("C:\\Users\\d86pe\\OneDrive\\Desktop\\FCC\\CIT63\\midterm-program-D86petersen-1\\animalOutput.txt");
// Create a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);
// Replace the System.out.println() statements with output.write()
            output.write("Hyena Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(hyenas[i]+"\n");
            }
            output.write("\nLion Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(lions[i]+"\n");
            }
            output.write("\nTiger Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(tigers[i]+"\n");
            }
            output.write("\nBear Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(bears[i]+"\n");
            }
// closed file
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}