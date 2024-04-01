import java.util.Scanner;
public class SafeInputCopy {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; //set this to zero length, loop runs till isn't do
        do{
            System.out.print("\n" +prompt+ ":");//show prompt add space
            retString = pipe.nextLine();
        }while(retString.length()==0);

        return retString;
    }
    public static int getNonZeroInt(Scanner scanner,String prompt){
        int retInt = 0;
        boolean isValidInput = false;
        do{
            System.out.print("\n" +prompt+ ": ");
            if (scanner.hasNextInt()){
                retInt = scanner.nextInt();
                isValidInput = retInt !=0;
            }else {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
        }while(!isValidInput);

        return retInt;
    }
    public static double getNonZeroDouble(Scanner scanner, String prompt){
        double retDouble = 0.0;

        while (true){
            System.out.print("\n"+ prompt + ": ");
            if(scanner.hasNextDouble()){
                retDouble = scanner.nextDouble();
                break;
            }else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return retDouble;
    }
    public static int getRangedInt(Scanner scanner, String prompt, int low, int high) {
        int retInt;
        while (true){
            System.out.print("\n"+ prompt + " [" + low + " - " + high + "]: ");
            while(!scanner.hasNextInt()){
                System.out.println("Please enter a valid integer");
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
                scanner.next();
            }
            retInt = scanner.nextInt();
            scanner.nextLine();

            if (retInt >= low && retInt <= high){
                break;
            }else{
                System.out.println("Please enter an integer within the specified range.");
            }
        }
        return retInt;
    }
    public static double getRangedDouble(Scanner scanner, String prompt, double low, double high) {
        double retDouble;

        while (true) {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
                scanner.next();
            }
            retDouble = scanner.nextDouble();
            scanner.nextLine(); // Clear the newline character from the buffer

            if (retDouble >= low && retDouble <= high) {
                break;
            } else {
                System.out.println("Please enter a number within the specified range.");
            }
        }
        return retDouble;
    }
    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        while (true) {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String userInput = scanner.nextLine().trim().toUpperCase();

            if (userInput.equals("Y")) {
                return true;
            } else if (userInput.equals("N")) {
                return false;
            } else {
                System.out.println("Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }
    public static String getRegExString(Scanner scanner, String prompt, String regEx) {
        while (true) {
            System.out.print("\n" + prompt + ": ");
            String userInput = scanner.nextLine().trim();

            if (userInput.matches(regEx)) {
                return userInput;
            } else {
                System.out.println("Please enter a valid input matching the specified pattern.");
                // Consume the invalid input
                scanner.nextLine();
            }
        }
    }
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();

        // Determine the number of stars on each side of the centered message
        int starsOnEachSide = (totalWidth - msgWidth - 5) / 2;

        // Print the top line of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line

        // Print the second line with centered message and stars on either side
        System.out.print("***");
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom line of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line
    }
}

