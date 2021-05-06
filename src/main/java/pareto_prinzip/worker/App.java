package pareto_prinzip.worker;

import pareto_prinzip.messenger.command_line.MessageSender;
import pareto_prinzip.messenger.text_manipulation.TextSender;
import pareto_prinzip.scanner.Scanner;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
    //    Scanner.find("192.168.40").forEach(System.out::println)

        TextSender.sendTextFile("Manifest.txt", "192.168.40.165");
    }
}
