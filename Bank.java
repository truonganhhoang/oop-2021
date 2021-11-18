import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream inputStream) {

    }

    /**
     * getCustomersInfoByNameOrder.
     * @return tex
     */
    public String getCustomersInfoByNameOrder() {
        return "a";
    }

    /**
     * getCustomersInfoByIdOrder.
     * @return tex
     */
    public String getCustomersInfoByIdOrder() {
        return "a";
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
