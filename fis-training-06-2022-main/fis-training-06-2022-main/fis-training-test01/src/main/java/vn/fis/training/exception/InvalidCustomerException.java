package vn.fis.training.exception;

import vn.fis.training.domain.Customer;

import static vn.fis.training.service.AppConstant.INVALID_CUSTOMER;

public class InvalidCustomerException extends ApplicationException{

    private Customer customer;

    public InvalidCustomerException(Customer customer, String message) {
        super(message);
        this.customer = customer;
    }

    @Override
    public String getErrorCode() {
        return INVALID_CUSTOMER;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
