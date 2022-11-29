package com.quan.petcaringapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Repository.CustomerRepos;

@Service
public class CustomerService {
    @Autowired
    CustomerRepos customerRepos;

    public List<Customer> getCustomers() {
        //data lấy từ posgre database, cái này khi  access trên postman thì bị lỗi , nên ở dòng comment tiếp theo thì em in trực tiếp trên terminal, thì nó chạy bình thường
        return customerRepos.findAll();
    }
    
    public List<Customer> getCustomers1() {

        // in cái data trong terminal lấy từ database thì vẫn bình thường, nhừng send nó bằng postman thì lại bị lỗi
        customerRepos.findAll().stream().forEach(cust -> System.out.println(cust));

        //cái này là  test thử bằng cách tạo một cái list rồi add customer manually, cách này thì nó lại chạy đc trên postman.

        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer("Thoa", "0412456789", "Thoa@gmail.com", "my pet is sick, take it to the hospital");
        list.add(customer1);
        return list;
    }
}
