package org.example.ejercicio4;

    enum ElevatorState { IDLE, MOVING_UP, MOVING_DOWN, OUT_OF_SERVICE }

    /**
     * - currentFloor >= 1 && currentFloor <= maxFloor
     */
    public class Elevator implements IElevator {
        private int currentFloor;
        private int maxFloor;
        private ElevatorState state;

        public Elevator(int maxFloor) {
            this.maxFloor = maxFloor;
            this.state = ElevatorState.IDLE;
            this.currentFloor = 0;
        }


        public void callToFloor(int floor) {
            assert (floor >= 1 && floor <= maxFloor) : "Invalid call to floor";
            assert (!isOutOfService()) : "The elevator is out of service";
            if (floor > currentFloor) movingUp(floor);
            if(floor < currentFloor) movingDown(floor);
            assert repOK();
        }

        private void movingUp(int expectedFloor) {
            try {
                state = ElevatorState.MOVING_UP;
                while (currentFloor <= expectedFloor) {
                    currentFloor++;
                }
                state = ElevatorState.IDLE;
            } catch (IllegalStateException e) { // never exception in code, is only a simulation of real scenario
                state = ElevatorState.OUT_OF_SERVICE;
            }
        }

        private void movingDown(int expectedFloor) {
            try {
                state = ElevatorState.MOVING_DOWN;
                while (currentFloor >= expectedFloor) {
                    currentFloor--;
                }
                state = ElevatorState.IDLE;
            } catch (IllegalStateException e) { // never exception in code, is only a simulation of real scenario
                state = ElevatorState.OUT_OF_SERVICE;
            }
        }

        private boolean isOutOfService() {
            return state == ElevatorState.OUT_OF_SERVICE;
        }

        private boolean elevatorIsMoving() {
            return state == ElevatorState.MOVING_UP || state == ElevatorState.MOVING_DOWN;
        }

        public void stop(){
            assert (!isOutOfService()) : "The elevator is out of service";
            assert (elevatorIsMoving()) : "The elevator is moving";
            state = ElevatorState.IDLE;
        }

        public boolean repOK(){
            return (currentFloor >= 0 && currentFloor <= maxFloor);
        }

    }

