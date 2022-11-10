package controller.skill_controller;

import config.HibernateProvider;
import model.dto.SkillDto;
import repository.SkillRepository;
import service.SkillService;
import service.converter.SkillConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/skills")
public class CreateSkillController extends HttpServlet {
    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        SkillRepository skillRepository = new SkillRepository(dbProvider);
        SkillConverter skillConverter = new SkillConverter();
        skillService = new SkillService(skillRepository, skillConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        String level = req.getParameter("level");
        req.setAttribute("language", language);
        req.setAttribute("level", level);
        req.getRequestDispatcher("/WEB-INF/jsp/skills/createSkill.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        String level = req.getParameter("level");
        SkillDto skill = new SkillDto(language, level);
        if(!skill.getLanguage().isBlank() || !skill.getLevel().isBlank()){
            skillService.create(skill);
            req.setAttribute("skill", skill);
            req.setAttribute("message", "Skill successfully created");
            req.getRequestDispatcher("/WEB-INF/jsp/skills/createSkill.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Skill isn't created");
            req.getRequestDispatcher("/WEB-INF/jsp/skills/createSkill.jsp").forward(req, resp);
        }
    }
}
