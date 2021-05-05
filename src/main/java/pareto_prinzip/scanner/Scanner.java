package pareto_prinzip.scanner;

import java.util.List;
import java.util.Stack;

public class Scanner {
    public static List<host> find(String mask){
        Stack<host> stack = new Stack<>();
        AddressFinderLevel3 finder = new AddressFinderLevel3(mask, stack, 10);
        finder.start();

        try {
            finder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stack;
    }
}
