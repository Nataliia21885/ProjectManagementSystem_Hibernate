package repository;


import config.HibernateProvider;
import model.dao.ProjectDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements CRUDRepository<ProjectDao> {

    private final HibernateProvider dbProvider;

    public ProjectRepository(HibernateProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    @Override
    public ProjectDao create(ProjectDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<ProjectDao> findAll() {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new ArrayList<>(session.createQuery("SELECT p FROM ProjectDao p", ProjectDao.class)
                    .getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public ProjectDao getByID(Integer id) {
        ProjectDao projectDao = new ProjectDao();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            projectDao = session.get(ProjectDao.class, id);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return projectDao;
    }

    public Integer salaryByProject(String projectName) {
        int sum = 0;
     try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            sum = session
                    .createQuery("SELECT d.salary FROM DeveloperDao d INNER JOIN d.projects p " +
                            "WHERE p.projectName = :projectName", Integer.class)
                    .setParameter("projectName", projectName)
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public List<Object[]> listOfProjects() {
        List<Object[]> projectsList = new ArrayList<>();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            projectsList = session
                    .createQuery("SELECT p.dateOfCreation, p.projectName, COUNT(distinct d.name)" +
                            " FROM ProjectDao p INNER JOIN p.developers d GROUP BY p.dateOfCreation, p.projectName" +
                            " ORDER BY p.projectName", Object[].class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectsList;
    }

    @Override
    public ProjectDao update(ProjectDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(ProjectDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

