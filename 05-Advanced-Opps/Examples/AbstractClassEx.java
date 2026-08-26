abstract class Payment {

    String customerName;

    Payment(String customerName) {

        this.customerName = customerName;

        System.out.println("Payment constructor");
    }

    void validate() {

        System.out.println("Payment validated");
    }

    abstract void pay();
}

class UPI extends Payment {

    UPI(String customerName) {

        super(customerName);
    }

    @Override
    void pay() {

        System.out.println("Payment through UPI");
    }
}

class CardPayment extends Payment {

    CardPayment(String customerName) {

        super(customerName);
    }

    @Override
    void pay() {

        System.out.println("Payment through Card");
    }
}

public class AbstractClassEx {

    public static void main(String[] args) {

        Payment payment = new UPI("Nikhil");

        payment.validate();
        payment.pay();

        System.out.println("Customer: " + payment.customerName);

        payment = new CardPayment("Nikhil");

        payment.validate();
        payment.pay();
    }
}