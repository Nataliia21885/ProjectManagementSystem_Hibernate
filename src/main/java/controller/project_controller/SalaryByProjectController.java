package controller.project_controller;

import config.HibernateProvider;
import repository.ProjectRepository;
import service.ProjectService;
import service.converter.ProjectConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/projects/sal")
public class SalaryByProjectController extends HttpServlet {
    private ProjectService projectService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        ProjectRepository projectRepository = new ProjectRepository(dbProvider);
        ProjectConverter projectConverter = new ProjectConverter();
        projectService = new ProjectService(projectRepository, projectConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String projectName = req.getParameter("projectName");
            Integer salary = projectService.salaryByProject(projectName);
            if (salary != 0) {
                req.setAttribute("salary", salary);
                req.getRequestDispatcher("/WEB-INF/jsp/projects/salaryByProject.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "You enter wrong format. Please, try again");
                req.getRequestDispatcher("/WEB-INF/jsp/projects/salaryByProject.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("message", "You enter wrong format. Please, try again");
            req.getRequestDispatcher("/WEB-INF/jsp/projects/salaryByProject.jsp").forward(req, resp);
        }
    }
}
