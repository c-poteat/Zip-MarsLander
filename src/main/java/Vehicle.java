public class Vehicle {

    public Vehicle(int InitialAltitude) {
        Altitude = InitialAltitude;
        PrevAltitude = InitialAltitude;
        // initialize the altitude AND previous altitude to initialAltitude
    }
    int Gravity = 100;
    /* The rate in which the spaceship descents in free fall (in ten seconds) */
    // Various end-of-game messages and status result codes.
    String dead = "\nCRASH!!\n\tThere were no survivors.\n\n";
    public static final int DEAD = -3;
    String crashed = "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
    public static final int CRASHED = -2;
    String emptyfuel = "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
    public static final int EMPTYFUEL = -1;
    String success = "\nThe starship has landed, everyone is safe. Good job!\n\n";
    public static final int SUCCESS = 0;
    public static final int FLYING = 1;

    // this is initial vehicle setup
    int Altitude= 8000;
    int PrevAltitude= 8000;
    int Velocity= 1000;
    int Fuel = 12000;
    int Burn = 0;
    int Flying = FLYING;

    public Vehicle() {}

    public String checkFinalStatus() {
        String s = "";
        if (this.Altitude <= 0) {
            if (this.Velocity > 10) {
                s = dead;
                Flying = DEAD;
            }
            if (this.Velocity < 10 && this.Velocity > 3) {
                s = crashed;
                Flying = CRASHED;
            }
            if (this.Velocity < 3) {
                s = success;
                Flying = SUCCESS;
            }
        } else {
            if (this.Altitude > 0) {
                s = emptyfuel;
                Flying = EMPTYFUEL;
            } }
        return s;
    }

    public int computeDeltaV() {
        // return velocity + gravity - burn amount
        return Velocity + Gravity - Burn;
    }

    public void adjustForBurn(int burnAmount) {
        this.Burn = burnAmount;
        // set burn to burnamount requested

        PrevAltitude = Altitude;
        // save previousAltitude with current Altitude

        this.Velocity = computeDeltaV();
        // set new velocity to result of computeDeltaV function.

        Altitude -= Velocity;
        // subtract speed from Altitude

        // subtract burn amount fuel used from tank
        Fuel -= burnAmount;
    }

    public boolean stillFlying() {
        // return true if altitude is positive
        if(Altitude > 0) {
            return true;
        } else {
        }
        return false;
    }
    public boolean outOfFuel() {
        // return true if fuel is less than or equal to zero
        if (Altitude <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public DescentEvent getStatus(int tick) {
        // create a return a new DescentEvent object   // filled in with the state of the vehicle.
        DescentEvent descentEvent = new DescentEvent(tick, Velocity,Fuel, Altitude, Flying);
        return descentEvent;
    }

}
