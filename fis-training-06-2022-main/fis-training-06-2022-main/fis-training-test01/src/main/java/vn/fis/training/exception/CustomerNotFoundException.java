package vn.fis.training.exception;

import vn.fis.training.service.AppConstant;

public class CustomerNotFoundException extends ApplicationException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getErrorCode() {
        return AppConstant.NOT_FOUND_CUSTOMER;
    }
}
