package controller.developer_controller;

import config.HibernateProvider;
import model.dto.DeveloperDto;
import repository.DeveloperRepository;
import repository.SkillRepository;
import service.DeveloperService;
import service.SkillService;
import service.converter.DeveloperConverter;
import service.converter.SkillConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/proj")
public class DeveloperByProjectController extends HttpServlet {
    private DeveloperService developerService;
    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        DeveloperRepository developerRepository = new DeveloperRepository(dbProvider);
        DeveloperConverter developerConverter = new DeveloperConverter();
        developerService = new DeveloperService(developerRepository, developerConverter);
        SkillRepository skillRepository = new SkillRepository(dbProvider);
        SkillConverter skillConverter = new SkillConverter();
        skillService = new SkillService(skillRepository, skillConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectName = req.getParameter("projectName");
        List<DeveloperDto> listDevelopersByProject = developerService.getListOfProjectDevelopers(projectName);
        if(!listDevelopersByProject.isEmpty()) {
            req.setAttribute("developersByProject", listDevelopersByProject);
            req.setAttribute("message", "Such developer found");
            req.getRequestDispatcher("/WEB-INF/jsp/developers/developerByProject.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Such developer didn't find");
            req.getRequestDispatcher("/WEB-INF/jsp/developers/developerByProject.jsp").forward(req, resp);
        }
    }
}
