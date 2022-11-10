package controller.developer_controller;

import config.HibernateProvider;
import model.dto.DeveloperDto;
import repository.DeveloperRepository;
import service.DeveloperService;
import service.converter.DeveloperConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/developers/upd")
public class UpdateDeveloperController extends HttpServlet {
    private DeveloperService developerService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        DeveloperRepository developerRepository = new DeveloperRepository(dbProvider);
        DeveloperConverter developerConverter = new DeveloperConverter();
        developerService = new DeveloperService(developerRepository, developerConverter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String sex = req.getParameter("sex");
            int salary = Integer.parseInt(req.getParameter("salary"));
            DeveloperDto findById = developerService.getByID(id);
            DeveloperDto developer = new DeveloperDto(id, name, age, sex, salary);
            DeveloperDto updatedDeveloper = developerService.update(developer);
            req.setAttribute("updatedDeveloper", updatedDeveloper);
            req.setAttribute("message", "Developer is updated successfully");
            req.getRequestDispatcher("/WEB-INF/jsp/developers/updateDeveloper.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Developer is not updated. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/developers/updateDeveloper.jsp").forward(req, resp);
        }
    }
}
