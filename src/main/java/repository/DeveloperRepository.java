package repository;


import config.HibernateProvider;
import model.dao.DeveloperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository implements CRUDRepository<DeveloperDao> {

    private final HibernateProvider dbProvider;

    public DeveloperRepository(HibernateProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    @Override
    public DeveloperDao create(DeveloperDao entity) {
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
    public List<DeveloperDao> findAll() {
         try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new ArrayList<>(session.createQuery("SELECT d FROM DeveloperDao d", DeveloperDao.class)
                    .getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public DeveloperDao getByID(Integer id) {
        DeveloperDao developerDao = new DeveloperDao();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            developerDao = session.get(DeveloperDao.class, id);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return developerDao;
    }

    public List<DeveloperDao> developersByLanguage(String language) {
        List<DeveloperDao> developerDaoList = new ArrayList<>();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return developerDaoList = session
                    .createQuery("SELECT d FROM DeveloperDao d INNER JOIN d.skills s " +
                            "WHERE s.language = :language", DeveloperDao.class)
                    .setParameter("language", language)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return developerDaoList;
    }

    public List<DeveloperDao> developersByLevel(String level) {
        List<DeveloperDao> developerDaoList = new ArrayList<>();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return developerDaoList = session
                    .createQuery("SELECT d FROM DeveloperDao d INNER JOIN d.skills s " +
                            "WHERE s.level = :level", DeveloperDao.class)
                    .setParameter("level", level)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return developerDaoList;
    }

    public List<DeveloperDao> quantityOfDevelopersInProject(String projectName) {
        List<DeveloperDao> listOfDevelopers = new ArrayList<>();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return listOfDevelopers = session
                    .createQuery("SELECT d FROM DeveloperDao d INNER JOIN d.projects p " +
                            "WHERE p.projectName = :projectName", DeveloperDao.class)
                    .setParameter("projectName", projectName)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return listOfDevelopers;
    }

    @Override
    public DeveloperDao update(DeveloperDao entity) {
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
    public void delete(DeveloperDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
