import sun.security.krb5.internal.crypto.Des;

import java.util.concurrent.TimeUnit;

public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) throws InterruptedException {
        int burn = 0;
        if (status.getVelocity() <= status.getAltitude() / 2) {

            burn = 200;

            TimeUnit.SECONDS.sleep(5);
            System.out.println(burn);
        }
        return burn;
    }
}


//////