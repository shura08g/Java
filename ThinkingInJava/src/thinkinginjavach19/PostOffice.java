// Цепочка обязаностей
package thinkinginjavach19;

import java.util.Iterator;

class Mail {
    // Множественные NO снижают вероятность случайного выбора YES
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    
    @Override
    public String toString() {
        return "Mail " + id + ":";
    }
    
    public String details() {
        return toString() +
                "\n Geberal Delivery: " + generalDelivery +
                ",\n Address Scannability: " + scannability +
                ",\n Address Readability: " + readability +
                ",\n Address Address: " + address +
                ",\n Return Address: " + returnAddress + ".";
    }
    
    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                    
                    @Override
                    public void remove() { // не реализовано
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address){
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        };
        
        abstract boolean handle(Mail m);
    }
    
    static void handle(Mail m) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(m))
                return;
        }
        System.out.println(m + " is a dead letter");
    }
    
    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}
/*
Mail 0:
 Geberal Delivery: NO2,
 Address Scannability: UNSCANNABLE,
 Address Readability: YES3,
 Address Address: OK1,
 Return Address: OK1.
Delivering Mail 0: normally
*****
Mail 1:
 Geberal Delivery: NO5,
 Address Scannability: YES3,
 Address Readability: ILLEGIBLE,
 Address Address: OK5,
 Return Address: OK1.
Delivering Mail 1: automatically
*****
Mail 2:
 Geberal Delivery: YES,
 Address Scannability: YES3,
 Address Readability: YES1,
 Address Address: OK1,
 Return Address: OK5.
Using general delivery for Mail 2:
*****
Mail 3:
 Geberal Delivery: NO4,
 Address Scannability: YES3,
 Address Readability: YES1,
 Address Address: INCORRECT,
 Return Address: OK4.
Returning Mail 3: to sender
*****
Mail 4:
 Geberal Delivery: NO4,
 Address Scannability: UNSCANNABLE,
 Address Readability: YES1,
 Address Address: INCORRECT,
 Return Address: OK2.
Returning Mail 4: to sender
*****
Mail 5:
 Geberal Delivery: NO3,
 Address Scannability: YES1,
 Address Readability: ILLEGIBLE,
 Address Address: OK4,
 Return Address: OK2.
Delivering Mail 5: automatically
*****
Mail 6:
 Geberal Delivery: YES,
 Address Scannability: YES4,
 Address Readability: ILLEGIBLE,
 Address Address: OK4,
 Return Address: OK4.
Using general delivery for Mail 6:
*****
Mail 7:
 Geberal Delivery: YES,
 Address Scannability: YES3,
 Address Readability: YES4,
 Address Address: OK2,
 Return Address: MISSING.
Using general delivery for Mail 7:
*****
Mail 8:
 Geberal Delivery: NO3,
 Address Scannability: YES1,
 Address Readability: YES3,
 Address Address: INCORRECT,
 Return Address: MISSING.
Mail 8: is a dead letter
*****
Mail 9:
 Geberal Delivery: NO1,
 Address Scannability: UNSCANNABLE,
 Address Readability: YES2,
 Address Address: OK1,
 Return Address: OK4.
Delivering Mail 9: normally
*****
*/