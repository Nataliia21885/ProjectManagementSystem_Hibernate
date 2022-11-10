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
import java.util.Objects;

@WebServlet(urlPatterns = "/projects")
public class CreateProjectController extends HttpServlet {
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
        String projectName = req.getParameter("projectName");
        String country = req.getParameter("country");
        int cost = Integer.parseInt(req.getParameter("cost"));
        Date dateOfCreation = Date.valueOf(req.getParameter("dateOfCreation"));
        req.setAttribute("projectName", projectName);
        req.setAttribute("country", country);
        req.setAttribute("cost", cost);
        req.setAttribute("dateOfCreation", dateOfCreation);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/createProject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectName = req.getParameter("projectName");
        String country = req.getParameter("country");
        int cost = Integer.parseInt(req.getParameter("cost"));
        Date dateOfCreation = Date.valueOf(req.getParameter("dateOfCreation"));
        ProjectDto project = new ProjectDto(projectName, country, cost, dateOfCreation);
        if(!project.getProjectName().isBlank() || !project.getCountry().isBlank()
                || project.getCost() != null || Objects.isNull(project.getDateOfCreation())){
            projectService.create(project);
            req.setAttribute("project", project);
            req.setAttribute("message", "Project successfully created");
            req.getRequestDispatcher("/WEB-INF/jsp/projects/createProject.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Project isn't created");
            req.getRequestDispatcher("/WEB-INF/jsp/projects/createProject.jsp").forward(req, resp);
        }
    }
}
