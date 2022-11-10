package service;

import model.dao.CustomerDao;
import model.dto.CustomerDto;
import repository.CustomerRepository;
import service.converter.CustomerConverter;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private CustomerRepository repository;
    private CustomerConverter customerConverter;

    public CustomerService(CustomerRepository repository, CustomerConverter customerConverter) {
        this.repository = repository;
        this.customerConverter = customerConverter;
    }

    public CustomerDto create(CustomerDto customerDto) {
        CustomerDao customerDao = repository.create(customerConverter.to(customerDto));
        return customerConverter.from(customerDao);
    }

    public List<CustomerDto> findAll() {
        return repository.findAll().stream()
                .map(customerConverter::from)
                .collect(Collectors.toList());
    }

    public CustomerDto getByID(Integer id) throws Exception {
        CustomerDao customerDao = repository.getByID(id);
        if(customerDao == null) {
            throw new Exception("Customer with such id does not find");
        }
        return customerConverter.from(customerDao);
    }

    public CustomerDto update(CustomerDto customerDto) {
        CustomerDao customerDao = repository.update(customerConverter.to(customerDto));
        return customerConverter.from(customerDao);
    }

    public void delete(CustomerDto customerDto) {
        repository.delete(customerConverter.to(customerDto));
    }

}

