interface Payment {

    int MAX_RETRY = 3;

    void pay();

    default void validate() {

        System.out.println("Payment validated");
    }

    static void info() {

        System.out.println("Payment interface");
    }
}

interface Refundable {

    void refund();
}

class UPI implements Payment, Refundable {

    @Override
    public void pay() {

        System.out.println("Payment through UPI");
    }

    @Override
    public void refund() {

        System.out.println("UPI refund processed");
    }

    @Override
    public void validate() {

        System.out.println("UPI payment validated");
    }
}

public class InterfaceEx {

    public static void main(String[] args) {

        Payment payment = new UPI();

        payment.pay();
        payment.validate();

        System.out.println("Max retry: " + Payment.MAX_RETRY);

        Payment.info();

        Refundable refundable = new UPI();

        refundable.refund();
    }
}