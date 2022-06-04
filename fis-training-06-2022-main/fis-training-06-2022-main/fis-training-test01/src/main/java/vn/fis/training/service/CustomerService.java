package vn.fis.training.service;

import vn.fis.training.domain.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * @param id : Id Customer muon tim kiem
     * @return : Customer trong he thong
     * @throws : CustomerNotFoundException trong truong hop khong tim duoc Customer tuong ung voi Id
     * @throws IllegalArgumentException trong truong hop id la null, rong
     */
    Customer findById(String id);

    /**
     * Ham tao moi doi tuong customer. Doi tuong customer phai duoc chuan hoa truoc khi insert vao he thong
     * @param customer : Doi tuong customer muon tao.
     * @throws vn.fis.training.exception.InvalidCustomerException: Khi cac truong thong tin khong dung dinh dang
     * @throws vn.fis.training.exception.DuplicateCustomerException : Khi khach hang da ton tai trong he thong - dua vao truong mobile
     * @return return lai doi tuong Customer sau khi da insert thanh cong vao database
     * */
    Customer  createCustomer(Customer customer);

    /**
     * @param customer : Doi tuong customer muon cap nhat thong tin
     * @throws vn.fis.training.exception.InvalidCustomerException: Khi cac truong thong tin khong dung dinh dang
     * @throws vn.fis.training.exception.DuplicateCustomerException : Khi khach hang da ton tai trong he thong - dua vao truong mobile
     * @throws vn.fis.training.exception.CustomerNotFoundException : Khi khong tim duoc user tuong ung voi id muon cap nhat trong he thong
     * @return return lai doi tuong Customer sau khi da update thanh cong vao database
     * */
    Customer updateCustomer(Customer customer);

    /**
     * Ham delete InActive Customer.
     * Chi cho phep delete customer voi trang thai la INACTIVE
     * @param id : Id cua khach hang can delete.
     * @throws : InvalidCustomerStatusException
     */
    void deleteCustomerById(String id);

    /**
     *
     * @return : danh sach customer trong he thong order by name giam dan (theo thu tu abc). Return emptyList neu khong co doi tuong nao
     * */
    List<Customer> findAllOrderByNameAsc();


    /**
     * @param limit : So luong toi da Customer duoc tra ve
     * @return : danh sach  limit customer trong he thong order by name giam dan (theo thu tu abc). Return emptyList neu khong co doi tuong nao
     * */
    List<Customer> findAllOrderByNameLimit(int limit);

    /**
     * @param custName : Dieu kien tim kiem . Vi du: "Nguyen Van" -> He thong tra ve tat ca cac customer co chu chuoi ky tu : Nguyen Van, Khong phan biet hoa tuong
     * @param limit : So luong toi da Customer duoc tra ve
     * @return : danh sach  limit customer trong he thong order by name giam dan (theo thu tu abc). Return emptyList neu khong co doi tuong nao
     * */
    List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit);

    /**
     * Ham thu hien tim kiem tat ca danh sach customer trong he thong. Tong hop theo do tuoi cua khach hang
     * @return : Danh sach doi tuong SummaryCustomerByAgeDTO duoc sap xep theo thu tu Age GIAM DAM. Neu khong co khach hang nao tra ve EmptyList
     */
    List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc();

}
