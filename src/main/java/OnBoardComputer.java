import java.util.concurrent.TimeUnit;

public class OnBoardComputer implements BurnStream {
    int burn = 0;

    @Override
    public int getNextBurn(DescentEvent status) throws InterruptedException {


        if (status.getAltitude() > 5500) {
            burnAmount100();

        } else if (status.getVelocity() > 100 && status.getAltitude() < 5500) {
            burnAmount200();

        } else if (status.getVelocity() > 100) {
            burnAmount100();

        } else if (status.getAltitude() == 100 & status.getAltitude() < 200) {
            burnAmount200();
//            burnAmount200();
//            burnAmount100();

        }

            TimeUnit.SECONDS.sleep(1);
            System.out.println(burn);
            return burn;

        }
        public int burnAmount100 () {
            burn = 100;
            return burn;
        }
    public int burnAmount200 () {
        burn = 200;
        return burn;
    }
    public int burnAmount98 () {
        burn = 98;
        return burn;
    }
    }

