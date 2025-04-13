package command;

// Each command you want to issue will implement
// the Command interface

public interface Command {

    void execute();

    // You may want to offer the option to undo a command

    void undo();

}