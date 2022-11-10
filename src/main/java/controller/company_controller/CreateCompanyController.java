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


@WebServlet(urlPatterns = "/companies")
public class CreateCompanyController extends HttpServlet {
    private CompanyService companyService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CompanyRepository companyRepository = new CompanyRepository(dbProvider);
        CompanyConverter companyConverter = new CompanyConverter();
        companyService = new CompanyService(companyRepository, companyConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String hrm = req.getParameter("hrm");
        req.setAttribute("name", name);
        req.setAttribute("hrm", hrm);
        req.getRequestDispatcher("/WEB-INF/jsp/companies/createCompany.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String hrm = req.getParameter("hrm");
        CompanyDto company = new CompanyDto(name, hrm);
        if(!company.getName().isBlank() || !company.getHrm().isBlank()){
            companyService.create(company);
            req.setAttribute("company", company);
            req.setAttribute("message", "Company successfully created");
            req.getRequestDispatcher("/WEB-INF/jsp/companies/createCompany.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Company isn't created");
            req.getRequestDispatcher("/WEB-INF/jsp/companies/createCompany.jsp").forward(req, resp);
        }
    }
}
