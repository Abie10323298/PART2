package part2;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Easykanban {
    

    // Getter for tasks (needed for unit tests)
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    private ArrayList<Task> tasks;

    public Easykanban() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to display all tasks
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        } else {
            StringBuilder allTasksDetails = new StringBuilder();
            for (Task task : tasks) {
                allTasksDetails.append(task.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, allTasksDetails.toString());
        }
    }

    // Method to calculate total duration of all tasks
    public int calculateTotalDuration() {
        int totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += task.getDuration();
        }
        return totalDuration;
    }

    // Method to display welcome message and menu
    public void displayWelcomeMessageAndMenu() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Choose an option:\n" +
                    "1. Add tasks\n" +
                    "2. Show report\n" +
                    "3. Display all tasks\n" +
                    "4. Display total duration\n" +
                    "5. Quit"));

            switch (option) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    displayAllTasks();
                    break;
                case 4:
                    displayTotalDuration();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban. Goodbye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
            }
        } while (option != 5);
    }

    // Method to add tasks
    public void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:"));

        for (int i = 0; i < numTasks; i++) {
            String taskStatus = JOptionPane.showInputDialog("Enter task status:");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter task number:"));
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            String taskID = JOptionPane.showInputDialog("Enter task ID:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:"));

            Task task = new Task(taskStatus, developerDetails, taskNumber, taskName, taskDescription, taskID, duration);
            addTask(task);

            JOptionPane.showMessageDialog(null, "Task added successfully!");
        }
    }

    // Method to show report
    public void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }

    // Method to display total duration
    public void displayTotalDuration() {
        int totalDuration = calculateTotalDuration();
        JOptionPane.showMessageDialog(null, "Total duration of all tasks: " + totalDuration + " hours");
    }

    public static void main(String[] args) {
        Easykanban easyKanban = new Easykanban();
        easyKanban.displayWelcomeMessageAndMenu();
    }
}
