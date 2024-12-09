package indiv2;

class Car {
    private String index;
    private double price;
    private String make;
    private String model;
    private int year;
    private String condition;
    private double mileage;
    private String color;
    private String vin;
    private String batchNumber;

    // Конструктор
    public Car(String index, double price, String make, String model, int year,
               String condition, double mileage, String color, String vin, String batchNumber) {
        this.index = index;
        this.price = price;
        this.make = make;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.mileage = mileage;
        this.color = color;
        this.vin = vin;
        this.batchNumber = batchNumber;
    }

    // Геттеры
    public String getIndex() { return index; }
    public double getPrice() { return price; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getCondition() { return condition; }
    public double getMileage() { return mileage; }
    public String getColor() { return color; }
    public String getVin() { return vin; }
    public String getBatchNumber() { return batchNumber; }

    // Сеттеры
    public void setPrice(double price) { this.price = price; }
    public void setCondition(String condition) { this.condition = condition; }
}