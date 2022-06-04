package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    @Override
    public Customer findById(String id) {
        if(isNullOrEmpty(id)){
            throw new IllegalArgumentException("ID bi bo trong. Khong tim thay");
        }
        return customerStore.findAll().stream().filter(customer ->
        { return id.equals(customer.getId());
        }).findFirst().orElseThrow(() ->{
            throw new CustomerNotFoundException(
                    String.format("Khong tim thay customer voi id %s" ,id));
        });
    }

    @Override
    public Customer createCustomer(Customer customer) {
        validate(customer);
        checkDuplicate(customer);
        return customerStore.insertOrUpdate(customer);
    }

    private void checkDuplicate(Customer customer) {
        if(customerStore.findAll().stream().filter(cust ->{
            return cust.getMobile().equals(customer.getMobile());
        }).findFirst().isPresent()){
            throw new DuplicateCustomerException(customer,String.format("Customer with phone number %s is duplicated", customer.getMobile()));
        }
    }

    private void validate(Customer customer) {
        if(isNullOrEmpty((customer.getName()))){
            throw new InvalidCustomerException(customer,"Customer name is empty");
        }
        if(isNullOrEmpty(customer.getMobile())){
            throw new InvalidCustomerException(customer,"Mobile is empty");
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        validate(customer);
        findById(customer.getId());
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        if(isNullOrEmpty(id)){
            throw new IllegalArgumentException("Can not delete customer with empty id");
        }
        findById(id);
        customerStore.deleteById(id);

    }


    private boolean isNullOrEmpty(String id) {
        if(id==null || id.trim().length()==0) return false;
        return true;
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        return customerStore.findAll().stream().
                sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        return customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getName).reversed()).limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        return null;
    }



    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        /**
         * Ham thu hien tim kiem tat ca danh sach customer trong he thong. Tong hop theo do tuoi cua khach hang
         * @return : Danh sach doi tuong SummaryCustomerByAgeDTO duoc sap xep theo thu tu Age GIAM DAM. Neu khong co khach hang nao tra ve EmptyList
         */

        return null;
    }

}
