package homework;


import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.Map;

public class CustomerService {
    private final TreeMap<Integer, Map.Entry<Customer, String>> customersData;
    private Map.Entry<Customer, String> smallestCustomerData;

    public CustomerService() {
        this.customersData = new TreeMap<>();
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
        Integer keyOfNextCustomerData = customersData.higherKey((int) customer.getScores());
        if (keyOfNextCustomerData == null) {
            return null;
        }

        Map.Entry<Customer, String> nextCustomerData = customersData.get(keyOfNextCustomerData);
        return new AbstractMap.SimpleEntry<>(new Customer(nextCustomerData.getKey()), nextCustomerData.getValue());
    }

    public void add(Customer customer, String data) {
        AbstractMap.SimpleEntry<Customer, String> newCustomerData = new AbstractMap.SimpleEntry<>(customer, data);
        customersData.put((int) customer.getScores(), newCustomerData);
        if (smallestCustomerData == null || smallestCustomerData.getKey().getScores() > customer.getScores()) {
            smallestCustomerData = newCustomerData;
        }
    }
}
