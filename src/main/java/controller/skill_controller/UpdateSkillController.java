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

@WebServlet(urlPatterns = "/skills/upd")
public class UpdateSkillController extends HttpServlet {
    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        SkillRepository skillRepository = new SkillRepository(dbProvider);
        SkillConverter skillConverter = new SkillConverter();
        skillService = new SkillService(skillRepository, skillConverter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String language = req.getParameter("language");
            String level = req.getParameter("level");
            SkillDto findById = skillService.getByID(id);
            SkillDto skill = new SkillDto(id, language, level);
            SkillDto updatedSkill = skillService.update(skill);
            req.setAttribute("updatedSkill", updatedSkill);
            req.setAttribute("message", "Skill is updated successfully");
            req.getRequestDispatcher("/WEB-INF/jsp/skills/updateSkill.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Skill is not updated. " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/skills/updateSkill.jsp").forward(req, resp);
        }
    }
}
