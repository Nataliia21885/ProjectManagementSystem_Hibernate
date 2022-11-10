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
import java.util.List;


@WebServlet(urlPatterns = "/customers/all")
public class FindAllCustomersController extends HttpServlet {
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
        List<CustomerDto> customers = customerService.findAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/findAllCustomers.jsp").forward(req, resp);
    }
}
