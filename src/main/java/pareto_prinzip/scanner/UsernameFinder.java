package pareto_prinzip.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsernameFinder {

    static public String getUserFromIP(String arg1) {
        StringBuilder user = new StringBuilder();
        String u;
        String user2 = null;
        try {
            Process p = Runtime.getRuntime().exec("query user /server:" + arg1);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                user.append(line);
                line=null;
            }

        } catch (IOException | InterruptedException ignored) {
        }
        u = user.toString().replace("null", "");
        try {
            user2 = getUserFromString(u);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        return user2;
    }

    static public String getUserFromString(String u) {
        String user = null;
        String[] strarray;
        strarray = u.split("\\s+");
        for (int i = 0; i < strarray.length; i++) {
            if(strarray[i].equals("Aktiv")){
                user = strarray[i-3];
            }
        }

        return user;
    }
}
