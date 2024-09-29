package lab3;

class TouristBus {
    private int numberOfSeats;
    private double seatPrice;
    private int occupiedSeats;

    public TouristBus() {
        this.numberOfSeats = 0;
        this.seatPrice = 0.0;
        this.occupiedSeats = 0;
    }

    public TouristBus(int numberOfSeats, double seatPrice) {
        this.numberOfSeats = numberOfSeats;
        this.seatPrice = seatPrice;
        this.occupiedSeats = 0;
    }

    public TouristBus(TouristBus other) {
        this.numberOfSeats = other.numberOfSeats;
        this.seatPrice = other.seatPrice;
        this.occupiedSeats = other.occupiedSeats;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        if (occupiedSeats <= numberOfSeats) {
            this.occupiedSeats = occupiedSeats;
        } else {
            System.out.println("Ошибка: количество занятых мест не может превышать общее количество мест.");
        }
    }

    public int getFreeSeats() {
        return numberOfSeats - occupiedSeats;
    }

    public boolean isEmpty() {
        return occupiedSeats == 0;
    }

    public boolean isFull() {
        return occupiedSeats == numberOfSeats;
    }

    public double totalOccupiedCost() {
        return occupiedSeats * seatPrice;
    }

    public void displayInfo() {
        System.out.println("Количество мест: " + numberOfSeats);
        System.out.println("Стоимость места: " + seatPrice);
        System.out.println("Занятые места: " + occupiedSeats);
        System.out.println("Свободные места: " + getFreeSeats());
        System.out.println("--------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        TouristBus bus1 = new TouristBus(54, 400);
        TouristBus bus2 = new TouristBus(45, 500);

        bus1.setOccupiedSeats(25);
        bus2.setOccupiedSeats(30);

        bus1.displayInfo();
        bus2.displayInfo();

        boolean isProfitableBus1 = bus1.totalOccupiedCost() > 11000;
        boolean isProfitableBus2 = bus2.totalOccupiedCost() > 11000;

        System.out.println("Автобус 1: Поездка " + (isProfitableBus1 ? "выгодная" : "невыгодная"));
        System.out.println("Автобус 2: Поездка " + (isProfitableBus2 ? "выгодная" : "невыгодная"));
    }
}