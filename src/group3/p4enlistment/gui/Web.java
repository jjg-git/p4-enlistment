package group3.p4enlistment.gui;

public class Web {
    private static volatile Web instance;
    private static final Object mutex = new Object();

    private Web() {
        Setup();
    }

    private void Setup() {
        /* woah web API time*/
    }

    public static Web GetInstance() {
        Web result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new Web();
                }
            }
        }

        return result;
    }
}
