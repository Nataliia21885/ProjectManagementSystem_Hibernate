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

@WebServlet(urlPatterns = "/skills/findId")
public class FindByIdSkillController extends HttpServlet {
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
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            SkillDto skill = skillService.getByID(id);
            req.setAttribute("skill", skill);
            req.getRequestDispatcher("/WEB-INF/jsp/skills/findSkillById.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/skills/findSkillById.jsp").forward(req, resp);
        }
    }
}
