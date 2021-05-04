package pareto_prinzip.scanner;

import java.net.InetAddress;
import java.util.Stack;

public class AddressFinderLevel4 implements Runnable{
    private final String addmask;
    private final Stack<String> stack;
    private final int start;
    private final int end;

    public AddressFinderLevel4(String addmask, Stack stack, int start, int end){
        this.addmask = addmask;
        this.stack = stack;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        try{
            int timeout=1000;
            for(int i = start; i <= end; i++){
                String host=addmask + "." + i;
                if (InetAddress.getByName(host).isReachable(timeout)){
                    stack.push(InetAddress.getByName(host).getHostName());
                }
            }
        }catch(Exception ex){

        }
    }
}
