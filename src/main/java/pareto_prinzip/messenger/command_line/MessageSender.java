package pareto_prinzip.messenger.command_line;

import java.io.IOException;

public class MessageSender {

    static public void sendMessage(String message, String ipAddress){
        try {
            CommandLineExecutor.execute(String.format("msg * /SERVER:%s \"%s\"", ipAddress, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
