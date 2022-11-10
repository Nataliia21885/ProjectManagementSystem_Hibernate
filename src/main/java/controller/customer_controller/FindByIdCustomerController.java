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

@WebServlet(urlPatterns = "/customers/findId")
public class FindByIdCustomerController extends HttpServlet {
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
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            CustomerDto customer = customerService.getByID(id);
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/WEB-INF/jsp/customers/findCustomerById.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/customers/findCustomerById.jsp").forward(req, resp);
        }
    }
}
