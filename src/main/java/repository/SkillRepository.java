package repository;


import config.HibernateProvider;

import model.dao.SkillDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SkillRepository implements CRUDRepository<SkillDao> {

    private final HibernateProvider dbProvider;

    public SkillRepository(HibernateProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    @Override
    public SkillDao create(SkillDao entity) {
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
    public List<SkillDao> findAll() {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new ArrayList<>(session.createQuery("SELECT s FROM SkillDao s", SkillDao.class)
                    .getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public SkillDao getByID(Integer id) {
        SkillDao skillDao = new SkillDao();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            skillDao = session.get(SkillDao.class, id);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skillDao;
    }

    @Override
    public SkillDao update(SkillDao entity) {
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
    public void delete(SkillDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

