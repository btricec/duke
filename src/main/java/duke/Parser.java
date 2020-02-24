package duke;

import duke.commands.*;

import java.util.Scanner;

/**
 * The parser reads in the input and parses it by
 * determining what kind of command the user has inputted
 * and then creating the corresponding Command with the
 * relevant parameters. The command is then passed back to
 * main for execution.
 */
public class Parser {
    private static final String LIST = "list";
    private static final String FIND = "find";
    private static final String DONE = "done";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DELETE = "delete";
    private static final String DATE = "date";
    private static final String EXIT = "bye";

    Scanner scanner;

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public Command scanCommand() {
        Command command = null;
        String inputString = scanner.nextLine();
        String[] instruction = inputString.split(" ", 2);
        try {
            switch (instruction[0]) {
            case (DONE):
                command = new DoneCommand(instruction[1]);
                break;
            case (DELETE):
                command = new DeleteCommand(instruction[1]);
                break;
            case (DATE):
                try{
                    command = new DateCommand(instruction[1]);
                } catch (DukeException e) {
                    System.out.println("Please enter a date!");
                }
                break;
            case (LIST):
                command = new ListCommand("");
                break;
            case (FIND):
                command = new FindCommand(instruction[1]);
                break;
            case (TODO):
            case (DEADLINE):
            case (EVENT):
                command = new AddCommand(instruction[1], instruction[0]);
                break;
            case (EXIT):
                command = new ExitCommand("");
                break;
            default:
                System.out.println("Huh? I do not understand :(");
                Ui.printHelp();
                break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Task description or date field is empty.");
            command = null;
        }
        return command;
    }
}
