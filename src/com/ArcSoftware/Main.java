package com.ArcSoftware;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import java.util.Scanner;


public class Main {
    public static final GpioController gpio = GpioFactory.getInstance();
    public static GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,   // PIN NUMBER
            "My LED",           // PIN FRIENDLY NAME (optional)
            PinState.LOW);      // PIN STARTUP STATE (optional)
    // explicitly set a state on the pin object
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Led [on/off]");
        String onOff = inputScanner.nextLine();
        if (onOff.equalsIgnoreCase("on")) {
            myLed.high();
        } else if (onOff.equalsIgnoreCase("off")) {
            myLed.toggle();
        } else {
            System.err.println("Invalid entry");


        }
    }
}
