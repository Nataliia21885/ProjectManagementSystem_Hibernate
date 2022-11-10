package service.converter;

import model.dao.CustomerDao;
import model.dto.CustomerDto;

public class CustomerConverter implements Converter<CustomerDto, CustomerDao> {

    @Override
    public CustomerDto from(CustomerDao entity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setName(entity.getName());
        customerDto.setContact(entity.getContact());
        return customerDto;
    }

    @Override
    public CustomerDao to(CustomerDto entity) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.setId(entity.getId());
        customerDao.setName(entity.getName());
        customerDao.setContact(entity.getContact());
        return customerDao;
    }
}
