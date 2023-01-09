import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private String[] history;
    static final String[] OPTIONS = {"add", "multiply", "substract", "divide", "show history", "delete history", "exit"};

    public Calculator() {
        this.history = new String[0];
    }

    public static void showOptions(String[] options) {
        System.out.println(ConsoleColors.GREEN + "Please select an option: " + ConsoleColors.RESET);
        for (String option : options) {
            System.out.print(ConsoleColors.YELLOW+ option + "   " + ConsoleColors.RESET);
        }
        System.out.println();
    }

    public void getInfo() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            switch (input) {
                case "add":
                    System.out.println("First number:");
                    String num1 = scan.nextLine();
                    System.out.println("Second number:");
                    String num2 = scan.nextLine();
                    System.out.println("add result: " + add(Double.parseDouble(num1), Double.parseDouble(num2)));
                    break;
                case "multiply":
                    System.out.println("First number:");
                    String num3 = scan.nextLine();
                    System.out.println("Second number:");
                    String num4= scan.nextLine();
                    System.out.println("multiply result: " + multiply(Double.parseDouble(num3), Double.parseDouble(num4)));
                    break;
                case "substract":
                    System.out.println("First number:");
                    String num5 = scan.nextLine();
                    System.out.println("Second number:");
                    String num6= scan.nextLine();
                    System.out.println("substract result: " + substract(Double.parseDouble(num5), Double.parseDouble(num6)));
                    break;
                case "divide":
                    System.out.println("First number:");
                    String num7 = scan.nextLine();
                    System.out.println("Second number:");
                    String num8= scan.nextLine();
                    System.out.println("divide result: " + divide(Double.parseDouble(num7), Double.parseDouble(num8)));
                    break;
                case "show history":
                    printOperations();
                    break;
                case "delete history":
                    clearOperations();
                    System.out.println("history deleted successfully!");
                    System.out.printf("blank");
                    break;
                case "exit":
                    System.out.println(ConsoleColors.BLUE + "Calculator ends work. Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            showOptions(OPTIONS);
        }
    }

    public double add(double num1, double num2) {
        double result = num1 + num2;
        String entry = String.format("added %s to %s got %s", num1, num2, result);
        addToHistory(entry);

        return result;
    }

    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        String entry = String.format("multiplied %s with %s got %s", num1, num2, result);
        addToHistory(entry);

        return result;
    }


    public double substract(double num1, double num2) {
        double result = num1 - num2;
        String entry = String.format("substracted %s with %s got %s", num1, num2, result);
        addToHistory(entry);

        return result;
    }

    public double divide(double num1, double num2) {
        if(num2 !=0) {
            double result = num1 / num2;
            String entry = String.format("divided %s with %s got %s", num1, num2, result);
            addToHistory(entry);
            return result;
        }
        System.out.println("Can't devide by zero");
        return 0;


    }
    protected void addToHistory(String entry) {
        this.history = Arrays.copyOf(this.history, this.history.length + 1);
        this.history[this.history.length-1] = entry;
    }


    public void printOperations() {
        System.out.println("history:");
        for (String entry : this.history) {
            System.out.println(entry);
        }

    }


    public void clearOperations() {
        this.history = new String[0];
    }
}
