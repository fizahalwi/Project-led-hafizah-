import java.io.*;
import java.net.*;

public class JavaClient {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1");

        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port 10007.");
	  System.out.println ("Done, thank you for connecting.");

        Socket javaSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            javaSocket = new Socket(serverHostname, 10007);
            out = new PrintWriter(javaSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        javaSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " +serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " +serverHostname);
            System.exit(1);
        }

        out.close();
        in.close();
        javaSocket.close();
    }
}
