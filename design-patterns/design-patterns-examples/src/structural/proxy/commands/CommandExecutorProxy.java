package structural.proxy.commands;

public class CommandExecutorProxy implements CommandExecutor {
    private final CommandExecutor executor;
    private boolean isAdmin;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm behavioural.command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}