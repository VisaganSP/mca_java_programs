public class InvoiceTest {
    public static void main(String[] args) {
        Invoice logiTechWirelessMouse = new Invoice("MOUSE01", "LogiTech Wireless Mouse", 15, 700);
        Invoice asusTufLaptop = new Invoice("LAPTOP01", "Asus TUF Gaming Laptop", 3, 120000);

        System.out.println("\t||================================||");
        System.out.println("\t||     Hardaware Store Invoice    ||");
        System.out.println("\t||================================||");
        
        System.out.println();

        System.out.println("\t" + logiTechWirelessMouse.getPartDescription().toUpperCase());
        System.out.println("PART NUMBER        : " + logiTechWirelessMouse.getPartNumber());
        System.out.println("PART DESCRIPTION   : " + logiTechWirelessMouse.getPartDescription());
        System.out.println("NO.OF QUANTIY SOLD : " + logiTechWirelessMouse.getQuantity());
        System.out.println("PRICE              : " + logiTechWirelessMouse.getPricePerItem());
        System.out.println("INVOICE AMOUNT     : " + logiTechWirelessMouse.getInvoiceAmount());

        System.out.println();

        System.out.println("\t" + asusTufLaptop.getPartDescription().toUpperCase());
        System.out.println("PART NUMBER        : " + asusTufLaptop.getPartNumber());
        System.out.println("PART DESCRIPTION   : " + asusTufLaptop.getPartDescription());
        System.out.println("NO.OF QUANTIY SOLD : " + asusTufLaptop.getQuantity());
        System.out.println("PRICE              : " + asusTufLaptop.getPricePerItem());
        System.out.println("INVOICE AMOUNT     : " + asusTufLaptop.getInvoiceAmount());
    }
}
