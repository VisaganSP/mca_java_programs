public class InvoiceTest {
    public static void main(String[] args) {
        Invoice one = new Invoice("99F", "Remote Car Toy", 10, 1.5);
        System.out.println("Part number: " + one.getPartNumber() + "; Part description: " + one.getPartDescription() +
                "; Sold: " + one.getQuantity() + "; Price: " + one.getPricePerItem() + "; Invoice amount: " +
                one.getInvoiceAmount());
        one.setPartNumber("0x000");
        one.setPartDescription("IBM");
        one.setQuantity(1000);
        one.setPricePerItem(1500.99);
        System.out.println("After changing:");
        System.out.println("Part number: " + one.getPartNumber() + "; Part description: " + one.getPartDescription() +
                "; Sold: " + one.getQuantity() + "; Price: " + one.getPricePerItem() + "; Invoice amount: " +
                one.getInvoiceAmount());
    }
}