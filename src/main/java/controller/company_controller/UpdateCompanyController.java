package controller.company_controller;

import config.HibernateProvider;
import model.dto.CompanyDto;
import repository.CompanyRepository;
import service.CompanyService;
import service.converter.CompanyConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/companies/upd")
public class UpdateCompanyController extends HttpServlet {
    private CompanyService companyService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CompanyRepository companyRepository = new CompanyRepository(dbProvider);
        CompanyConverter companyConverter = new CompanyConverter();
        companyService = new CompanyService(companyRepository, companyConverter);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String hrm = req.getParameter("hrm");
            CompanyDto findById = companyService.getByID(id);
            CompanyDto company = new CompanyDto(id, name, hrm);
            CompanyDto updatedCompany = companyService.update(company);
            req.setAttribute("updatedCompany", updatedCompany);
            req.setAttribute("message", "Company is updated successfully");
            req.getRequestDispatcher("/WEB-INF/jsp/companies/updateCompany.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Company is not updated. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/companies/updateCompany.jsp").forward(req, resp);
        }
    }
}
