package pareto_prinzip.scanner;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AddressFinderLevel3 extends Thread {
    private final String addmask;
    private final Stack<Host> stack;
    private final int packSize;

    AddressFinderLevel3(String addmask, Stack<Host> stack, int packSize){
        this.addmask = addmask;
        this.stack = stack;
        this.packSize = packSize;
    }

    @Override
    public void run(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        try{
            for(int i = 1; i < 255; i = i + packSize) {
                executorService.execute(new AddressFinderLevel4(addmask, stack, i, i + packSize + 5));
            }
            executorService.shutdown();
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
