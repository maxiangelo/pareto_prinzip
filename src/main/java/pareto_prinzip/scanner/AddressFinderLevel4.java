package pareto_prinzip.scanner;

import java.net.InetAddress;
import java.util.Stack;

public class AddressFinderLevel4 implements Runnable{
    private final String addmask;
    private final Stack<Host> stack;
    private final int start;
    private final int end;

    AddressFinderLevel4(String addmask, Stack<Host> stack, int start, int end){
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
                if(i <= 255)
                {
                    String host=addmask + "." + i;
                    if (InetAddress.getByName(host).isReachable(timeout)){

                        final String ip = InetAddress.getByName(host).getHostAddress();

                        stack.push(new Host(
                                        ip,
                                        InetAddress.getByName(host).getHostName(),
                                        UsernameFinder.getUserFromIP(ip)
                                )
                        );
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
