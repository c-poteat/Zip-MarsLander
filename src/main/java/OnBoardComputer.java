import sun.security.krb5.internal.crypto.Des;

import java.util.concurrent.TimeUnit;

public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) throws InterruptedException {

        int burn = 0;
        if(status.getAltitude() < 20000 && status.getAltitude() > 5000) {
            burn = 100;
        } else if(status.getAltitude() < 5000 && status.getVelocity() > 0) {
            burn = 197;

        }
            TimeUnit.SECONDS.sleep(1);
            System.out.println(burn);
            return burn;
        }
    }
