package controller.customer_controller;

import config.HibernateProvider;
import model.dto.CustomerDto;
import repository.CustomerRepository;
import repository.ProjectRepository;
import service.CustomerService;
import service.ProjectService;
import service.converter.CustomerConverter;
import service.converter.ProjectConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/customers/drop")
public class DeleteCustomerController extends HttpServlet {
    private CustomerService customerService;
    private ProjectService projectService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CustomerRepository customerRepository = new CustomerRepository(dbProvider);
        CustomerConverter customerConverter = new CustomerConverter();
        customerService = new CustomerService(customerRepository, customerConverter);
        ProjectRepository projectRepository = new ProjectRepository(dbProvider);
        ProjectConverter projectConverter = new ProjectConverter();
        projectService = new ProjectService(projectRepository, projectConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CustomerDto customer = null;
        try {
            customer = customerService.getByID(id);
            req.setAttribute("customer", customer);
            customerService.delete(customer);
            req.setAttribute("message", "Customer with such id successfully deleted");
            req.getRequestDispatcher("/WEB-INF/jsp/customers/deleteCustomer.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Customer with such id wasn't deleted. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/customers/deleteCustomer.jsp").forward(req, resp);
        }
    }
}
