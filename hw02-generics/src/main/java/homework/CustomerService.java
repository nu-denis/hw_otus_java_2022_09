package homework;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class CustomerService {
    private final ArrayList<AbstractMap.SimpleEntry<Customer, String>> customersData;
    private Map.Entry<Customer, String> smallestCustomerData;

    public CustomerService() {
        this.customersData = new ArrayList<>();
        this.smallestCustomerData = null;
    }

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return new AbstractMap.SimpleEntry<>(
            new Customer(smallestCustomerData.getKey()), smallestCustomerData.getValue()
        );
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> nextCustomerData = null;
        int customerScore = Math.toIntExact(customer.getScores());
        for (Map.Entry<Customer, String> customerData : customersData) {
            int currentCustomerScore = Math.toIntExact(customerData.getKey().getScores());
            if (customerScore < currentCustomerScore
                    && (nextCustomerData == null || nextCustomerData.getKey().getScores() > currentCustomerScore)) {
                nextCustomerData = new AbstractMap.SimpleEntry<>(new Customer(customerData.getKey()), customerData.getValue());
            }
        }
        return nextCustomerData;
    }

    public void add(Customer customer, String data) {
        AbstractMap.SimpleEntry<Customer, String> newCustomerData = new AbstractMap.SimpleEntry<>(customer, data);
        customersData.add(newCustomerData);
        if (smallestCustomerData == null || smallestCustomerData.getKey().getScores() > customer.getScores()) {
            smallestCustomerData = newCustomerData;
        }
    }
}
