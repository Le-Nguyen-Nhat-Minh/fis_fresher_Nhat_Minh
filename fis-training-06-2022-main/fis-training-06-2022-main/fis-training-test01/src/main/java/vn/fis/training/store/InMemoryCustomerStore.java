package vn.fis.training.store;

import vn.fis.training.domain.Customer;

import java.util.*;

public final class InMemoryCustomerStore {
    /**
     *  Map dung de lu tru customer trong he thong
     */
    private final Map<String, Customer> mapCustomer = new HashMap<>();

    /**
     * @param customer doi tuong customer (da duoc chuan hoa truoc do)
     * @return Customer: Doi tuong customer sau khi da duoc luu thanh cong vao he thong
     * @throws vn.fis.training.exception.ApplicationException tuong ung.
     */
    public Customer insertOrUpdate(Customer customer) {
        //TODO: Implement theo dac ta
        mapCustomer.put(customer.getId(),customer);
        return  customer;
    }

    /**
     * @return : tra ve toan bo danh sach customer trong he thong
     */
    public List<Customer> findAll() {
        //TODO: Implement method  dac ta
        return new ArrayList<>(mapCustomer.values());
    }

    /**
     * @param id: Id cua customer muon delete
     */
    public void deleteById(String id) {
        //TODO: Implement method  dac ta
        mapCustomer.remove(id);

    }
}
