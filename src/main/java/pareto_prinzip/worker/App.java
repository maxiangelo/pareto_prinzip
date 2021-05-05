package pareto_prinzip.worker;

import pareto_prinzip.scanner.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner.find("192.168.40").forEach(System.out::println);
    }
}
