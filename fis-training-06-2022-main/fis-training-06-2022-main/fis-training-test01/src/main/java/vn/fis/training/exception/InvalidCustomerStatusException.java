package vn.fis.training.exception;

import vn.fis.training.domain.Customer;
import vn.fis.training.service.AppConstant;

public class InvalidCustomerStatusException extends  ApplicationException{
    private final Customer customer;
    public InvalidCustomerStatusException(Customer customer,String message) {
        super(message);
        this.customer = customer;
    }
    @Override
    public String getErrorCode() {
        return AppConstant.INVALID_STATUS_CUSTOMER;
    }
}
