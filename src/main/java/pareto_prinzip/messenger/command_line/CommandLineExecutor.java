package pareto_prinzip.messenger.command_line;

import java.io.IOException;

public class CommandLineExecutor {
    static public void execute(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }
}
