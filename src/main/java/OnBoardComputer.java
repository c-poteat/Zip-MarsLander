import sun.security.krb5.internal.crypto.Des;

public class OnBoardComputer implements BurnStream {
    DescentEvent descentEvent = new DescentEvent();

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;

        System.out.println(burn); /*hack!*/
        return burn;
    }
}
