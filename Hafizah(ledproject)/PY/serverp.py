import socket               # Import socket module

import RPi.GPIO as GPIO

import time

s = socket.socket()         # Create a socket object

host = socket.gethostname()       # Get local machine name

port = 12345                # Reserve a port for your service.

s.bind((host, port))        # Bind to the port


print"Waiting for connections!"

s.listen(5)                 # Now wait for client connection.

while True:
   
	c, addr = s.accept()     # Establish connection with client.
   
	print 'Hava connection from', addr
   
	c.send('Connection successful, thank you for connecting!!')
   
	print"LED -> ON"
   
	GPIO.setmode(GPIO.BCM)
   
	GPIO.setwarnings(False)
   
	GPIO.setup(23,GPIO.OUT)
  
	GPIO.output(23,GPIO.HIGH)
   
	time.sleep(2)

   
	print"LED -> OFF"
   
	GPIO.output(23,GPIO.LOW)
	time.sleep(2)

	
	print"LED -> ON"
   
	GPIO.setmode(GPIO.BCM)
   
	GPIO.setwarnings(False)
   
	GPIO.setup(23,GPIO.OUT)
  
	GPIO.output(23,GPIO.HIGH)
   
	time.sleep(2)

   
	print"LED -> OFF"
   
	GPIO.output(23,GPIO.LOW)
	time.sleep(2)


	print"LED -> ON"
   
	GPIO.setmode(GPIO.BCM)
   
	GPIO.setwarnings(False)
   
	GPIO.setup(23,GPIO.OUT)
  
	GPIO.output(23,GPIO.HIGH)
   
	time.sleep(2)

   
	print"LED -> OFF"
   
	GPIO.output(23,GPIO.LOW)
	time.sleep(2)

   
	c.shutdown(1)
   
	c.close()                # Close the connection


