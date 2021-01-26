package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.dao.impl.CarDaoImpl;
import ru.sapteh.model.Car;
import ru.sapteh.model.Engine;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car();
        Set<Car> cars = new HashSet<>();
        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Car, Integer> dao = new CarDaoImpl(factory);
            car.setMark("Toyota");
            car.setModel("camry");
            car.setEngine(dao.read(3).getEngine());

            dao.create(car);

//            Car car1 = dao.read(1);
//            System.out.println(car1);



        } finally {
            if(factory != null)
                factory.close();
        }



    }
}
