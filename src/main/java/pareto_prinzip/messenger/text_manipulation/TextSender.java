package pareto_prinzip.messenger.text_manipulation;

import pareto_prinzip.messenger.command_line.MessageSender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TextSender {
    static public void sendTextFile(String filePath, String ipAddress) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));

        AtomicReference<String> tempString = new AtomicReference<>("");

        AtomicReference<String> cutoff = new AtomicReference<>("");

        lines.forEach(l -> {
            int lineLength = l.toCharArray().length;

            if (lineLength > 0) {
                if (lineLength < 200) {
                    if (tempString.get().length() < 200) {
                        tempString.set(cutoff.get() + " " + tempString.get());
                        cutoff.set("");
                        int space = 240 - tempString.get().length();
                        int index = Math.min(space, lineLength);
                        tempString.set(tempString.get() + " " + l.substring(0, index));

                        if (index < lineLength) {
                            cutoff.set(l.substring(index));
                        }
                    } else {
                        MessageSender.sendMessage(tempString.get(), ipAddress);
                        System.out.println(java.time.LocalDateTime.now() + " Sent: " + tempString.get());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tempString.set("");
                    }
                }
            }
        });
    }
}
