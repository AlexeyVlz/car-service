package carservice;

import carservice.model.*;
import carservice.model.branch.Branch;
import carservice.model.position.Position;

import java.util.List;

public class ObjectsForTests {

    public static List<Position> getPositions() {
        return List.of(new Position("Электрик"), new Position("Механик"), new Position("Шиномонтажник"));
    }

    public static List<Branch> getBranches() {
        return List.of(new Branch("Филиал 1", "Брайнт Бич"),
                new Branch("Филиал 2", "Бейкер Стрит"));
    }

    public static List<Client> getClients() {
        return List.of(new Client("Алексей", "Селезнёв", UtilClass.stringToLocalDate("23.08.2014")),
                new Client("Роман", "Селезнёв", UtilClass.stringToLocalDate("28.06.2017")),
                new Client("Ольга", "Селезнёва", UtilClass.stringToLocalDate("29.04.1988")));
    }

    public static Car getCar1() {
        return new Car("A111AA134", "Mercedes", "C250");
    }

    public static Car getCar2() {
        return new Car("Р111РР134", "BMW", "525");
    }

    public static Car getCar3() {
        return new Car("О111ОО134", "Ford", "EcoSport");
    }

    public static Car getCar4() {
        return new Car("О222ОО134", "Hyundai", "ix35");
    }
}
