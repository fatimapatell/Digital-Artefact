import java.time.LocalDate; // Stores dates
import java.time.format.DateTimeFormatter; // Converts dates entered as strings into dates that java understands 
import java.time.temporal.ChronoUnit; // Calculates the number of days between dates
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
            String dateInput = myScanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //creating a date format for the user input
            LocalDate today = LocalDate.parse(dateInput, formatter); //converting the user input into a date that java understands
            System.out.println("To begin, please enter the number of tasks you would like to input "); 
            int num = myScanner.nextInt(); // Take the user input into the 'num' variable
            myScanner.nextLine(); // Clear value from scanner

            for (int i = 0; i < num; i++) // Loops based on how many tasks the user has, incrementing by 1 each loop
            {
                String entry = createEntry(myScanner, today); /* Passing scanner and today's date as parameters to createEntry() so the method can read user input 
    and storing the string returned by the method in the variable 'entry'*/
                tasks.add(entry); //Adding the new revision task entry to the list 'tasks' for storage
            }

            ArrayList<String> orderedTasks=new ArrayList<>(); // Creating a new list to store the ordered tasks
            String[] priorityLevels = {"High", "Medium", "Low"}; // Creating an array to store the priority levels

            System.out.println("The avaialable priority levels are: ");
            for (int i=0; i < priorityLevels.length; i++) // For each priority level in the list of priority levels
            {
                System.out.println(priorityLevels[i]); // Print the current priority level
            }
            
            //High priority tasks:
            for (String task: tasks) // For each task in the list of tasks
            {
                if (task.contains("Priority: High")) //If the task is high priority
                {
                    orderedTasks.add(task);
                }
            }

            for (String task: tasks) // For each task in the list of tasks
            {
                if (task.contains("Priority: Medium")) //If the task is medium priority
                {
                    orderedTasks.add(task);
                }
            }

            for (String task: tasks) // For each task in the list of tasks
            {
                if (task.contains("Priority: Low")) //If the task is low priority
                {
                    orderedTasks.add(task);
                }
            }

            System.out.println("\nHere are your tasks in order of priority: ");

            for (int i=0; i < orderedTasks.size(); i++) // For each task in the list of ordered tasks
            {
                System.out.println("\nTask " + (i + 1) + ":"); // Numbering tasks starting at 1, not 0, for user readability
                System.out.println(orderedTasks.get(i)); // Printing the task at the current index of the ordered tasks list
            }
        }
        else // If the user is not ready to get started...
        {
            System.out.println("No worries! Come back when you're ready to get started!"); // Print a message to the user
        }

        /* Task priority management:
        Deadline is today, tomorrow or within 2 days OR task takes 3 hours or more - high priority
        Deadline is within 7 days OR task takes 2 hours or more - medium priority
        Deadline is more than 7 days away AND task takes less than 2 hours - low priority
        */

    }

    public static String createEntry(Scanner myScanner, LocalDate today)
    { 
    /*Declaring createEntry() method, declaring myScanner inside 
    createEntry() method so it can be used inside the method*/

        System.out.println("Please enter a subject for which you have a revision task (e.g 'Maths')"); /*Taking necessary inputs and
        storing them in variables to create entries*/
        String subject = myScanner.nextLine();
        System.out.println("Describe the revision task for this subject (e.g 'Complete a worksheet')");
        String task = myScanner.nextLine();
        System.out.println("What is the deadline to get this done? (e.g '28/11/2026') ");
        String deadlineInput = myScanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate deadline = LocalDate.parse(deadlineInput, formatter); // Now there is two dates stored in actual date form, one is todays date and done is deadline
        System.out.println("How long will the task take to complete? (e.g 0.5 hours) ");
        double timeTaken = myScanner.nextDouble();
        long daysUntilDeadline = ChronoUnit.DAYS.between(today, deadline);// Calculating he amount of days until deadline by using the ChronoUnit.DAYS.between() method to find the difference between today and the deadline
        String priority = calculatePriority(daysUntilDeadline, timeTaken); // Calls priority calculation method
        myScanner.nextLine();

String entry = "\nSubject: " + subject
    + "\nRevision Task: " + task
    + "\nDeadline: " + deadlineInput
    + "\nLength: " + timeTaken + " hours"
    + "\nPriority: " + priority
    + "\n"; // Creating an entry to be stored in the list, with information on separate lines for enhanced readability 

        return entry; // Return the formatted task entry to the calling method

        /* Why have I chosen to use a createEntry() method? 
        I think it is more efficient to use a createEntry() method so that it can be reused in multiple places
        throughout the code. In this way, memory space is saved as well as time because the same lines of code
        are not rewritten multiple times; only a single line is used to call a method.*/

    }


public static String calculatePriority(long daysUntilDeadline, double timeTaken)
{
    if (daysUntilDeadline <= 2 || timeTaken >= 3)// If deadline is within 2 days or the task takes three hours or more
    {
        return "High";
    }
    else if (daysUntilDeadline <= 7 || timeTaken >= 2) // If first condition isn't met, checks whether the deadline is within 7 days
    {
        return "Medium";
    }
    else // If neither condition is met, the task is low priority
    {
        return "Low";
    }
}
   //myScanner.close(); 
}