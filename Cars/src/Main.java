// Интерфейс, описывающий возможность заправки
interface Fuelable {
    void refuel(int amount); // заправить топливом
}

// Интерфейс, описывающий возможность езды
interface Driveable {
    void drive(int distance); // проехать определенное расстояние
}

// Абстрактный класс Транспортное средство
abstract class Vehicle {
    protected String make; // марка автомобиля
    protected String model; // модель автомобиля
    protected int fuelLevel; // уровень топлива

    // Параметризованный конструктор
    public Vehicle(String make, String model, int fuelLevel) {
        this.make = make;
        this.model = model;
        this.fuelLevel = fuelLevel;
    }

    // Абстрактный метод, который должен быть реализован потомками
    public abstract void startEngine();

    // Метод, возвращающий информацию об автомобиле
    public String getInfo() {
        return "Марка: " + make + ", Модель: " + model;
    }

    // Геттер для уровня топлива (инкапсуляция)
    public int getFuelLevel() {
        return fuelLevel;
    }

    // Сеттер для уровня топлива
    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel >= 0) {
            this.fuelLevel = fuelLevel;
        } else {
            System.out.println("Уровень топлива не может быть отрицательным.");
        }
    }
}

// Класс Легковой автомобиль, наследник Vehicle и реализует интерфейсы Fuelable, Driveable
class Car extends Vehicle implements Fuelable, Driveable {
    private int passengerCount; // количество пассажиров
    private static int totalCars; // статическое поле - общее количество легковых автомобилей

    // Параметризованный конструктор
    public Car(String make, String model, int fuelLevel, int passengerCount) {
        super(make, model, fuelLevel);
        this.passengerCount = passengerCount;
        totalCars++; // увеличиваем количество автомобилей при создании объекта
    }

    // Реализация метода startEngine
    @Override
    public void startEngine() {
        if (fuelLevel > 0) {
            System.out.println("Двигатель автомобиля " + make + " " + model + " заведен.");
        } else {
            System.out.println("Нет топлива для запуска двигателя.");
        }
    }

    // Реализация метода refuel из интерфейса Fuelable
    @Override
    public void refuel(int amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println("Легковой автомобиль заправлен на " + amount + " литров.");
        } else {
            System.out.println("Количество топлива должно быть положительным.");
        }
    }

    // Реализация метода drive из интерфейса Driveable
    @Override
    public void drive(int distance) {
        if (fuelLevel >= distance / 10) {
            fuelLevel -= distance / 10;
            System.out.println("Легковой автомобиль проехал " + distance + " км.");
        } else {
            System.out.println("Недостаточно топлива для поездки.");
        }
    }

    // Статический метод для получения количества автомобилей
    public static int getTotalCars() {
        return totalCars;
    }
}

// Класс Грузовой автомобиль, наследник Vehicle и реализует интерфейсы Fuelable, Driveable
class Truck extends Vehicle implements Fuelable, Driveable {
    private int cargoWeight; // вес груза
    private static int totalTrucks; // статическое поле - общее количество грузовиков

    // Параметризованный конструктор
    public Truck(String make, String model, int fuelLevel, int cargoWeight) {
        super(make, model, fuelLevel);
        this.cargoWeight = cargoWeight;
        totalTrucks++; // увеличиваем количество грузовиков при создании объекта
    }

    // Реализация метода startEngine
    @Override
    public void startEngine() {
        if (fuelLevel > 0) {
            System.out.println("Двигатель грузовика " + make + " " + model + " заведен.");
        } else {
            System.out.println("Нет топлива для запуска двигателя.");
        }
    }

    // Реализация метода refuel из интерфейса Fuelable
    @Override
    public void refuel(int amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println("Грузовик заправлен на " + amount + " литров.");
        } else {
            System.out.println("Количество топлива должно быть положительным.");
        }
    }

    // Реализация метода drive из интерфейса Driveable
    @Override
    public void drive(int distance) {
        if (fuelLevel >= distance / 5) {
            fuelLevel -= distance / 5;
            System.out.println("Грузовик проехал " + distance + " км.");
        } else {
            System.out.println("Недостаточно топлива для поездки.");
        }
    }

    // Статический метод для получения количества грузовиков
    public static int getTotalTrucks() {
        return totalTrucks;
    }
}


public class Main {
    public static void main(String[] args) {
        // Создаем объекты легкового автомобиля и грузовика
        Car car = new Car("Toyota", "Corolla", 50, 5);
        Truck truck = new Truck("Volvo", "FH", 80, 10000);


        car.startEngine();
        car.drive(100);
        car.refuel(20);
        System.out.println("Уровень топлива в легковом автомобиле: " + car.getFuelLevel());

        truck.startEngine();
        truck.drive(150);
        truck.refuel(50);
        System.out.println("Уровень топлива в грузовике: " + truck.getFuelLevel());

        // Получаем общее количество автомобилей и грузовиков
        System.out.println("Всего легковых автомобилей: " + Car.getTotalCars());
        System.out.println("Всего грузовиков: " + Truck.getTotalTrucks());
    }
}
