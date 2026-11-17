import java.util.ArrayList; //Importing array for storing entries/task information
import java.util.Scanner; //Importing Scanner for input
public class StudySmart // Creating main class
{
    public static void main(String[] args) // Main method declaration
    {
        ArrayList<String> tasks = new ArrayList<>(); // Creating an empty list called tasks that i can store multiple string values in
        System.out.println("Welcome to Study Smart! Ready to get started? (y/n) ");
        Scanner myScanner = new Scanner(System.in); // Creating object called myScanner to read user input from the keyboard
        String start = myScanner.nextLine(); // Storing user input y/n into variable

        if (start.equals("y")) // If the user is ready to get started...
        {
            System.out.println("Please enter today's date, DD/MM/YYYY ");
            String date = myScanner.nextLine();
            String day = date.substring(0, 2);
            System.out.println(date);
            System.out.println("To begin, please enter the number of tasks you would like to input "); 
            int num = myScanner.nextInt(); // Take the user input into the 'num' variable
            myScanner.nextLine(); // Clear value from scanner

            for (int i = 0; i < num; i++) // Loops based on how many tasks the user has, incrementing by 1 each loop
            {
                String entry = createEntry(myScanner); /* Passing scanner as a parameter to createEntry() so the method can read user input 
    and storing the string returned by the method in the variable 'entry'*/
                tasks.add(entry); //Adding the new revision task entry to the list 'tasks' for storage
            }
        }

        System.out.println(tasks); // Displays list

        /*Task priority management:
        Deadline is today, tomorrow or within 2 days - high priority
        Deadline is within 7 days or task takes 3 hours or more - high priority
        Deadline is within 7 days or task takes 2 hours or more - medium priority
        Deadline is more than 7 days away or task takes less than 2 hours - low priority*/

    }

    public static String createEntry(Scanner myScanner) 
    { 
    /*Declaring createEntry() method, declaring myScanner inside 
    createEntry() method so it can be used inside the method*/

        System.out.println("Please enter a subject for which you have a revision task (e.g 'Maths')"); /*Taking necessary inputs and
        storing them in variables to create entries*/
        String subject = myScanner.nextLine();
        System.out.println("Describe the revision task for this subject (e.g 'Complete a worksheet')");
        String task = myScanner.nextLine();
        System.out.println("What is the deadline to get this done? (e.g '28/10/2026') ");
        String deadline = myScanner.nextLine();
        System.out.println("How long will the task take to complete? (e.g 0.5 hours) ");
        double timeTaken = myScanner.nextDouble();
        myScanner.nextLine();

            String entry ="\nSubject: " + subject
        + "\nRevision Task: " + task
        + "\nDeadline: " + deadline
        + "\nLength: " + timeTaken + " hours"
        + "\n"; // Creating an entry to be stored in the list, with information on separate lines for enhanced readability 

        return entry; //return the formatted task entry to the calling method

        /* Why have I chosen to use a createEntry() method? 
        I think it is more efficient to use a createEntry() method so that it can be reused in multiple places
        throughout the code. In this way, memory space is saved as well as time because the same lines of code
        are not rewritten multiple times; only a single line is used to call a method.*/

    }
}
   //myScanner.close(); 