package homework;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class CustomerService {
    private final ArrayList<AbstractMap.SimpleEntry<Customer, String>> customers;
    private Map.Entry<Customer, String> smallerCustomer;

    public CustomerService() {
        this.customers = new ArrayList<>();
        this.smallerCustomer = null;
    }

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return new AbstractMap.SimpleEntry<>(new Customer(smallerCustomer.getKey()), smallerCustomer.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        customers.sort(Comparator.comparing(o -> o.getKey().getScores()));
        int customerScore = Math.toIntExact(customer.getScores());
        for (Map.Entry<Customer, String> el : customers) {
            if (customerScore < el.getKey().getScores()) {
                return new AbstractMap.SimpleEntry<>(new Customer(el.getKey()), el.getValue());
            }
        }
        return null;
    }

    public void add(Customer customer, String data) {
        AbstractMap.SimpleEntry<Customer, String> element = new AbstractMap.SimpleEntry<>(customer, data);
        customers.add(element);
        if (smallerCustomer == null || smallerCustomer.getKey().getScores() > customer.getScores()) {
            smallerCustomer = element;
        }
    }
}
