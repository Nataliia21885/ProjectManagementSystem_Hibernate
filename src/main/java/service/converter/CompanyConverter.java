package service.converter;

import model.dao.CompanyDao;
import model.dto.CompanyDto;

public class CompanyConverter implements Converter<CompanyDto, CompanyDao> {

    @Override
    public CompanyDto from(CompanyDao entity) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(entity.getId());
        companyDto.setName(entity.getName());
        companyDto.setHrm(entity.getHrm());
        return companyDto;
    }

    @Override
    public CompanyDao to(CompanyDto entity) {
        CompanyDao companyDao = new CompanyDao();
        companyDao.setId(entity.getId());
        companyDao.setName(entity.getName());
        companyDao.setHrm(entity.getHrm());
        return companyDao;
    }
}