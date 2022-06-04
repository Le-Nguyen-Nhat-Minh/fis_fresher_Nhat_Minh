package vn.fis.training.exception;

import vn.fis.training.domain.Customer;

public class DuplicateCustomerException extends ApplicationException{
    private Customer customer;
    public DuplicateCustomerException(Customer customer, String message) {
        super(message);
        this.customer = customer;
    }
    @Override
    public String getErrorCode() {
        //TOTO: Dinh nghia ma loi khi tao moi 1 khach hang da ton tai
        return null;
    }
    public Customer getCustomer() {
        return this.customer;
    }
}
