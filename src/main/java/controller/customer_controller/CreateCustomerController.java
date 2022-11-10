package controller.customer_controller;

import config.HibernateProvider;
import model.dto.CustomerDto;
import repository.CustomerRepository;
import service.CustomerService;
import service.converter.CustomerConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/customers")
public class CreateCustomerController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CustomerRepository customerRepository = new CustomerRepository(dbProvider);
        CustomerConverter customerConverter = new CustomerConverter();
        customerService = new CustomerService(customerRepository, customerConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        req.setAttribute("name", name);
        req.setAttribute("contact", contact);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/createCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        CustomerDto customer = new CustomerDto(name, contact);
        if(!customer.getName().isBlank() || !customer.getContact().isBlank()){
            customerService.create(customer);
            req.setAttribute("customer", customer);
            req.setAttribute("message", "Customer successfully created");
            req.getRequestDispatcher("/WEB-INF/jsp/customers/createCustomer.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Customer isn't created");
            req.getRequestDispatcher("/WEB-INF/jsp/customers/createCustomer.jsp").forward(req, resp);
        }
    }
}
