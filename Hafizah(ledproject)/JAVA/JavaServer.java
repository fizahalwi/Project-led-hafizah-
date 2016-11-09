import java.net.*;
import java.io.IOException;
import java.io.*;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class JavaServer
{
 public static void main(String[] args) throws IOException,InterruptedException 
   {
    ServerSocket serverSocket = null;

    try {
         serverSocket = new ServerSocket(10007);
        }
    catch (IOException e)
        {
         System.err.println("Could not listen on port: 10007.");
         System.exit(1);
        }

    Socket clientSocket = null;
System.out.println ("Waiting for connection...");

    try {
         clientSocket = serverSocket.accept();
        }
    catch (IOException e)
        {
         System.err.println("Please try again.");
         System.exit(1);
        }

    System.out.println ("Connection successful");

// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #04 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
	   {

        	// set shutdown state for this pin
        	pin.setShutdownOptions(true, PinState.LOW);
		System.out.println("LED --> ON");
		Thread.sleep(1400);//ms  
		// turn off gpio pin #04
       	pin.low();
		System.out.println("LED --> OFF");
	   }

    clientSocket.close();
    serverSocket.close();
   }
   }

