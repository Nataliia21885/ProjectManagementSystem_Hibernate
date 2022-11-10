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

@WebServlet(urlPatterns = "/developers/drop")
public class DeleteDeveloperController extends HttpServlet {
    private DeveloperService developerService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        DeveloperRepository developerRepository = new DeveloperRepository(dbProvider);
        DeveloperConverter developerConverter = new DeveloperConverter();
        developerService = new DeveloperService(developerRepository, developerConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DeveloperDto developer = null;
        try {
            developer = developerService.getByID(id);
            req.setAttribute("developer", developer);
            req.setAttribute("message", "Developer with such id successfully deleted");
            developerService.delete(developer);
            req.getRequestDispatcher("/WEB-INF/jsp/developers/deleteDeveloper.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Developer with such id wasn't deleted. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/developers/deleteDeveloper.jsp").forward(req, resp);
        }
    }
}
