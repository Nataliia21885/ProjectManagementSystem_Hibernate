package controller.project_controller;

import config.HibernateProvider;
import model.dto.ProjectDto;
import repository.ProjectRepository;
import service.ProjectService;
import service.converter.ProjectConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/projects/findId")
public class FindProjectByIdController extends HttpServlet {
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
            int id = Integer.parseInt(req.getParameter("id"));
            ProjectDto project = projectService.getByID(id);
            req.setAttribute("project", project);
            req.getRequestDispatcher("/WEB-INF/jsp/projects/findProjectById.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/projects/findProjectById.jsp").forward(req, resp);
        }
    }
}
