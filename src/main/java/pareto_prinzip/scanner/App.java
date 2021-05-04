package pareto_prinzip.scanner;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Stack data = find();
    }

    public static Stack find(){
        Stack stack = new Stack<String>();
        AddressFinderLevel3 finder = new AddressFinderLevel3("192.168.178", stack, 10);
        finder.start();

        try {
            finder.join();
            stack.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stack;
    }
}

