package pareto_prinzip.worker;

import pareto_prinzip.messenger.text_manipulation.TextSender;
import pareto_prinzip.scanner.Host;
import pareto_prinzip.scanner.Scanner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException {

        final List<Host> hosts = Scanner.find("192.168.40").stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < hosts.size(); i++) {
            Host host = hosts.get(i);
            System.out.println(i + " " + host);
        }

        System.out.print("Input host by number: ");
        java.util.Scanner colsoleReader = new java.util.Scanner(System.in);

        Host targetHost = hosts.get(colsoleReader.nextInt());
        System.out.println("Targeting " + targetHost.getUsername() + " LETS GOOOO");

        TextSender.sendTextFile("Manifest.txt", targetHost.getAddress());
    }
}
