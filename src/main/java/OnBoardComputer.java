import sun.security.krb5.internal.crypto.Des;

import java.util.concurrent.TimeUnit;

public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) throws InterruptedException {
        int burn = 0;
        if(status.getAltitude() < 20000) {
            burn = 200;
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(burn);
        return burn;
    }
}
