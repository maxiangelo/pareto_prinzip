package pareto_prinzip.worker;

import pareto_prinzip.messenger.text_manipulation.TextSender;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        TextSender.sendTextFile("Manifest.txt", "192.168.40.165");
    }
}
