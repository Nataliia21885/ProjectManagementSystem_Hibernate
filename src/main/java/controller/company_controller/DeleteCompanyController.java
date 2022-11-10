package controller.company_controller;

import config.HibernateProvider;
import model.dto.CompanyDto;
import repository.CompanyRepository;
import repository.ProjectRepository;
import service.CompanyService;
import service.ProjectService;
import service.converter.CompanyConverter;
import service.converter.ProjectConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/companies/drop")
public class DeleteCompanyController extends HttpServlet {
    private CompanyService companyService;
    private ProjectService projectService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CompanyRepository companyRepository = new CompanyRepository(dbProvider);
        CompanyConverter companyConverter = new CompanyConverter();
        companyService = new CompanyService(companyRepository, companyConverter);
        ProjectRepository projectRepository = new ProjectRepository(dbProvider);
        ProjectConverter projectConverter = new ProjectConverter();
        projectService = new ProjectService(projectRepository, projectConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CompanyDto company = null;
        try {
            company = companyService.getByID(id);
            req.setAttribute("company", company);
            req.setAttribute("message", "Company with such id successfully deleted");
            companyService.delete(company);
            req.getRequestDispatcher("/WEB-INF/jsp/companies/deleteCompany.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Company with such id wasn't deleted. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/companies/deleteCompany.jsp").forward(req, resp);
        }
    }
}
