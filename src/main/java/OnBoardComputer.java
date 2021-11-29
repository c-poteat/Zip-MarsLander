import sun.security.krb5.internal.crypto.Des;

import java.util.concurrent.TimeUnit;

public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) throws InterruptedException {

        int burn = 0;
        if (status.getAltitude() < 20000 && status.getAltitude() > 6000) {
            burn = 100;
        } else if (status.getAltitude() < 6000 && status.getAltitude() >200 & status.getVelocity() > 0) {
            burn = 200;
        } else if(status.getVelocity() == 0) {
            burn = 97;
        } else if(status.getVelocity() > 2 && status.getVelocity() < 5) {
            burn = 100;
        }
            TimeUnit.SECONDS.sleep(1);
            System.out.println(burn);
            return burn;
        }
    }
