package interfacerules.bill;

import java.util.List;

public class SimpleBillWriter implements BillWriter {

    @Override
    public String writeBill(List<String> billItems) {
        StringBuilder sb = new StringBuilder();
        for (String line : billItems) {
            String[] split = line.split(";");
            int price = Integer.parseInt(split[1]);
            int quantity = Integer.parseInt(split[2]);
            sb.append(String.format("%s, %d * %d = %d Ft", split[1], quantity, price, price * quantity));
        }
        return sb.toString();
    }
}
