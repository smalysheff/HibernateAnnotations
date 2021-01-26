package ru.sapteh.dao.impl;

import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Car;
import ru.sapteh.model.Engine;

public class CarDaoImpl implements DAO<Car, Integer> {

    final SessionFactory factory;

    public CarDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Car car) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public Car read(@NotNull final Integer id) {
        try(Session session = factory.openSession()){
            final Car result = session.get(Car.class, id);
//            if(result != null)
//                Hibernate.initialize(result.);
            return result;
        }
    }

    @Override
    public void update(@NotNull final Car car) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(car);
            session.getTransaction();
        }
    }

    @Override
    public void delete(@NotNull final Car car) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(car);
            session.getTransaction();
        }
    }
}
