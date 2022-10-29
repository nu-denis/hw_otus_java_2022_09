package homework;


import java.util.LinkedList;

public class CustomerReverseOrder {
    public final LinkedList<Customer> customers = new LinkedList<>();

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"

    public void add(Customer customer) {
        customers.addFirst(customer);
    }

    public Customer take() {
        return customers.pop(); // это "заглушка, чтобы скомилировать"
    }
}
