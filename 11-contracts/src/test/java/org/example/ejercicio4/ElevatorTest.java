package org.example.ejercicio4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElevatorTest {
    @Test
    void callToFloorAndStopWhileDown() throws InterruptedException {
        Elevator elevator = new Elevator(7);
        elevator.callToFloor(7);
        Thread.sleep(2000); // wait 2 seconds before executing the stop
        elevator.stop();
        assertTrue(elevator.isOutOfService());
    }

    @Test
    void callToFloorAndStopAfterDown() throws InterruptedException {
        Elevator elevator = new Elevator(7);
        elevator.callToFloor(7);
        Thread.sleep(4500); // not is out of service, since the thread stopped after finishing down
        elevator.stop();
        assertFalse(elevator.isOutOfService());
    }

    @Test
    void callToFloorAndStopAfterUp() throws InterruptedException {
        Elevator elevator = new Elevator(7);
        elevator.callToFloor(7);
        Thread.sleep(4500); // the elevator is expected to have already gone up before launching the next thread
        elevator.callToFloor(2);
        Thread.sleep(500); // the thread stops 0.5s, before executing the stop, but it is not enough for it to go down to the floor
        elevator.stop();
        assertTrue(elevator.isOutOfService());
    }



}
