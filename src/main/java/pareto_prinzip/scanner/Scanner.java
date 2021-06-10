package pareto_prinzip.scanner;

import java.util.List;
import java.util.Stack;

public class Scanner {
    public static List<Host> find(String mask){
        Stack<Host> stack = new Stack<>();

        System.out.println("Staring scanning...");

        AddressFinderLevel3 finder = new AddressFinderLevel3(mask, stack, 10);
        finder.start();

        try {
            finder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Found " + stack.size() + " Hosts");
        return stack;
    }
}
