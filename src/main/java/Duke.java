import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________\n" +
                        " Hello! I'm Duke\n" +
                        " What can I do for you?\n" +
                "____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println("  " + inputString + "\n" +
                "____________________________________________________________");
        while(!inputString.equals("bye bye")) {
            inputString = scanner.nextLine();
            System.out.println("  " + inputString + "\n" +
                    "____________________________________________________________");
        }
        System.out.println(" Bye. Hope to see you again soon!\n" +
                "____________________________________________________________");
    }
}
