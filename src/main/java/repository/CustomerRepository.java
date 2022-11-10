package repository;

import config.HibernateProvider;
import model.dao.CustomerDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CRUDRepository<CustomerDao> {

    private final HibernateProvider dbProvider;

    public CustomerRepository(HibernateProvider dbProvider) {
        this.dbProvider = dbProvider;
    }


    @Override
    public CustomerDao create(CustomerDao entity) {
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
    public List<CustomerDao> findAll() {
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new ArrayList<>(session.createQuery("SELECT c FROM CustomerDao c", CustomerDao.class)
                    .getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public CustomerDao getByID(Integer id) {
        CustomerDao customerDao = new CustomerDao();
        try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            customerDao = session.get(CustomerDao.class, id);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customerDao;
    }

    @Override
    public CustomerDao update(CustomerDao entity) {
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
    public void delete(CustomerDao entity) {
    try (Session session = dbProvider.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

