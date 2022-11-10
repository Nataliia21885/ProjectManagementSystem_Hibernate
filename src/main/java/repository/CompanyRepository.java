package repository;

import config.HibernateProvider;
import model.dao.CompanyDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository implements CRUDRepository<CompanyDao> {

    private final HibernateProvider dbProvider;

    public CompanyRepository(HibernateProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    @Override
    public CompanyDao create(CompanyDao entity) {
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
    public List<CompanyDao> findAll() {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new ArrayList<>(session.createQuery("SELECT c FROM CompanyDao c", CompanyDao.class)
                    .getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public CompanyDao getByID(Integer id) {
        CompanyDao companyDao = new CompanyDao();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            companyDao = session.get(CompanyDao.class, id);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return companyDao;
    }

        @Override
    public CompanyDao update(CompanyDao entity) {
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
    public void delete(CompanyDao entity) {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

