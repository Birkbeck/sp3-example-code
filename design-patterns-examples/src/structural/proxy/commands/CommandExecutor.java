package structural.proxy.commands;

public interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}