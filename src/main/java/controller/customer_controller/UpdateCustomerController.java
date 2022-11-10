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

@WebServlet(urlPatterns = "/customers/upd")
public class UpdateCustomerController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CustomerRepository customerRepository = new CustomerRepository(dbProvider);
        CustomerConverter customerConverter = new CustomerConverter();
        customerService = new CustomerService(customerRepository, customerConverter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String contact = req.getParameter("contact");
            CustomerDto findById = customerService.getByID(id);
            CustomerDto customer = new CustomerDto(id, name, contact);
            CustomerDto updatedCustomer = customerService.update(customer);
            req.setAttribute("updatedCustomer", updatedCustomer);
            req.setAttribute("message", "Customer is updated successfully");
            req.getRequestDispatcher("/WEB-INF/jsp/customers/updateCustomer.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Customer is not updated. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/customers/updateCustomer.jsp").forward(req, resp);
        }
    }
}
