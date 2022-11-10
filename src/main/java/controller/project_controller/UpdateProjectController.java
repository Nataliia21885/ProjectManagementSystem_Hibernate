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
import java.sql.Date;

@WebServlet(urlPatterns = "/projects/upd")
public class UpdateProjectController extends HttpServlet {
    private ProjectService projectService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        ProjectRepository projectRepository = new ProjectRepository(dbProvider);
        ProjectConverter projectConverter = new ProjectConverter();
        projectService = new ProjectService(projectRepository, projectConverter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String projectName = req.getParameter("projectName");
            String country = req.getParameter("country");
            int cost = Integer.parseInt(req.getParameter("cost"));
            Date dateOfCreation = Date.valueOf(req.getParameter("dateOfCreation"));
            ProjectDto findById = projectService.getByID(id);
            ProjectDto project = new ProjectDto(id, projectName, country, cost, dateOfCreation);
            ProjectDto updatedProject = projectService.update(project);
            req.setAttribute("updatedProject", updatedProject);
            req.setAttribute("message", "Project is updated successfully");
            req.getRequestDispatcher("/WEB-INF/jsp/projects/updateProject.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Project is not updated. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/projects/updateProject.jsp").forward(req, resp);
        }
    }
}
