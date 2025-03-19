package behavioural.command;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Gets the ElectronicDevice to use

        final ElectronicDevice newDevice = new Television();

        // TurnTVOn contains the behavioural.command to turn on the tv
        // When execute() is called on this behavioural.command object
        // it will execute the method on() in Television

        final Command onCommand = new TurnTVOn(newDevice);

        // Calling the execute() causes on() to execute in Television

        onCommand.execute();
        //DeviceButton button = new DeviceButton(onCommand);

        // When button() is called theCommand.execute(); executes

        //button.press();

        //----------------------------------------------------------

        // Now when execute() is called off() of Television executes

        final Command offCommand = new TurnTVOff(newDevice);

        offCommand.execute();

        // Calling the execute() causes off() to execute in Television

        //button = new DeviceButton(offCommand);

        // When button() is called theCommand.execute(); executes

        //button.press();

        //----------------------------------------------------------

        // Now when execute() is called volumeUp() of Television executes

        final Command volUpCommand = new TurnTVUp(newDevice);

        // Calling the execute() causes volumeUp() to execute in Television

        volUpCommand.execute();
        //button = new DeviceButton(volUpCommand);

        // When button() is called theCommand.execute(); executes

        volUpCommand.execute();
        volUpCommand.execute();
        volUpCommand.execute();

//    button.press();
//    button.press();
//    button.press();

        //----------------------------------------------------------

        // Creating a TV and Radio to turn off with 1 button

        final Television theTV = new Television();

        final Radio theRadio = new Radio();

        // Add the Electronic Devices to a List

        final List<ElectronicDevice> allDevices = List.of(theTV, theRadio);

        // Send the List of Electronic Devices to TurnItAllOff
        // where a call to run execute() on this function will
        // call off() for each device in the list

        final Command turnOffDevices = new TurnItAllOff(allDevices);

        // This calls for execute() to run which calls for off() to
        // run for every ElectronicDevice

        final DeviceButton turnThemOff = new DeviceButton(turnOffDevices);

        turnThemOff.press();

        //----------------------------------------------------------

        /*
         * It is common to be able to undo a behavioural.command in a behavioural.command pattern
         * To do so, DeviceButton will have a method called undo
         * Undo() will perform the opposite action that the normal
         * Command performs. undo() needs to be added to every class
         * with an execute()
         */

        turnThemOff.pressUndo();

        // To undo more than one behavioural.command add them to a LinkedList using addFirst().
        // Then execute undo on each item until there are none left.
    }

}