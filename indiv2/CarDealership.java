package indiv2;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> cars = new ArrayList<>();
    private Set<String> vinSet = new HashSet<>();

    // Метод для загрузки автомобилей из файла
    public void loadCarsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String index = line.trim();
                double price = Double.parseDouble(br.readLine().trim());
                String make = br.readLine().trim();
                String model = br.readLine().trim();
                int year = Integer.parseInt(br.readLine().trim());
                String condition = br.readLine().trim();
                double mileage = Double.parseDouble(br.readLine().trim());
                String color = br.readLine().trim();
                String vin = br.readLine().trim();
                String batchNumber = br.readLine().trim();

                // Проверка уникальности VIN кода
                if (!vinSet.add(vin)) {
                    System.out.println("Ошибка: Дублирующийся VIN: " + vin);
                } else {
                    Car car = new Car(index, price, make, model, year, condition, mileage, color, vin, batchNumber);
                    cars.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Поиск автомобилей по номеру партии
    public void findCarsByBatch(String batchNumber) {
        List<Car> batchCars = cars.stream()
                .filter(car -> car.getBatchNumber().equals(batchNumber))
                .collect(Collectors.toList());

        if (batchCars.isEmpty()) {
            System.out.println("Автомобили данной партии не найдены.");
        } else {
            System.out.println("Автомобили партии " + batchNumber + ":");
            try (PrintWriter writer = new PrintWriter(new FileWriter("batch_results.txt"))) {
                for (Car car : batchCars) {
                    String result = String.format("Index: %s, Make: %s, Model: %s, Price: %.2f",
                            car.getIndex(), car.getMake(), car.getModel(), car.getPrice());
                    System.out.println(result);
                    writer.println(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Вывод средней цены автомобилей по маркам
    public void printCarsByMakePrice() {
        Map<String, List<Double>> makePrices = new HashMap<>();

        for (Car car : cars) {
            makePrices.computeIfAbsent(car.getMake(), k -> new ArrayList<>()).add(car.getPrice());
        }

        // Подсчет средней цены
        Map<String, Double> averagePrice = makePrices.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

        // Сортировка и вывод
        List<Map.Entry<String, Double>> sortedMakes = new ArrayList<>(averagePrice.entrySet());
        sortedMakes.sort(Map.Entry.comparingByValue());

        System.out.println("Список марок автомобилей, упорядоченный по средней цене:");
        try (PrintWriter writer = new PrintWriter(new FileWriter("make_price_results.txt"))) {
            for (Map.Entry<String, Double> entry : sortedMakes) {
                System.out.printf("%s: Средняя цена: %.2f%n", entry.getKey(), entry.getValue());
                writer.printf("%s: Средняя цена: %.2f%n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Построение гистограммы по цветам
    public void printColorHistogram() {
        Map<String, Map<String, Integer>> colorBrandCount = new HashMap<>();

        for (Car car : cars) {
            String color = car.getColor();
            String make = car.getMake();

            colorBrandCount.computeIfAbsent(color, k -> new HashMap<>())
                    .merge(make, 1, Integer::sum);
        }

        System.out.println("Гистограмма количества автомобилей разных марок по цветам:");
        for (Map.Entry<String, Map<String, Integer>> entry : colorBrandCount.entrySet()) {
            String color = entry.getKey();
            System.out.println("Цвет: " + color);
            for (Map.Entry<String, Integer> brandEntry : entry.getValue().entrySet()) {
                System.out.printf("  %s: %d\n", brandEntry.getKey(), brandEntry.getValue());
            }
        }
    }

    // Вычисление статистики по маркам автомобилей
    public void printStatisticsByMake() {
        Map<String, List<Double>> makePriceStats = new HashMap<>();
        Map<String, List<Double>> makeMileageStats = new HashMap<>();

        for (Car car : cars) {
            String make = car.getMake();
            makePriceStats.computeIfAbsent(make, k -> new ArrayList<>()).add(car.getPrice());
            makeMileageStats.computeIfAbsent(make, k -> new ArrayList<>()).add(car.getMileage());
        }

        System.out.println("Статистика по маркам автомобилей:");
        for (String make : makePriceStats.keySet()) {
            List<Double> prices = makePriceStats.get(make);
            List<Double> mileages = makeMileageStats.get(make);

            double averagePrice = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double minPrice = prices.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
            double maxPrice = prices.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
            double averageMileage = mileages.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.printf("%s: Средняя цена: %.2f, Минимальная цена: %.2f, Максимальная цена: %.2f, Средний пробег: %.2f\n",
                    make, averagePrice, minPrice, maxPrice, averageMileage);
        }
    }

    // Поиск автомобилей по параметрам
    public List<Car> searchCars(int ageRangeStart, int ageRangeEnd, List<String> colors, String make, String condition) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            int age = 2024 - car.getYear(); // текущий год
            boolean inRange = age >= ageRangeStart && age <= ageRangeEnd;
            boolean colorMatch = colors.isEmpty() || colors.contains(car.getColor());
            boolean makeMatch = make == null || make.equalsIgnoreCase(car.getMake());
            boolean conditionMatch = condition == null || condition.equalsIgnoreCase(car.getCondition());

            if (inRange && colorMatch && makeMatch && conditionMatch) {
                results.add(car);
            }
        }
        return results;
    }

    // Отображение результатов поиска
    public void displayResults(List<Car> cars, String sortOrder) {
        if (cars.isEmpty()) {
            System.out.println("Не найдено автомобилей, соответствующих заданным критериям.");
            return;
        }

        // Сортировка результатов
        Comparator<Car> comparator;
        switch (sortOrder.toLowerCase()) {
            case "price ascending":
                comparator = Comparator.comparingDouble(Car::getPrice);
                break;
            case "price descending":
                comparator = Comparator.comparingDouble(Car::getPrice).reversed();
                break;
            case "mileage ascending":
                comparator = Comparator.comparingDouble(Car::getMileage);
                break;
            case "mileage descending":
                comparator = Comparator.comparingDouble(Car::getMileage).reversed();
                break;
            default:
                System.out.println("Некорректный порядок сортировки. Используется сортировка по цене по возрастанию по умолчанию.");
                comparator = Comparator.comparingDouble(Car::getPrice);
                break;
        }

        cars.sort(comparator);

        System.out.println("Результаты поиска:");
        try (PrintWriter writer = new PrintWriter(new FileWriter("search_results.txt"))) {
            for (Car car : cars) {
                String result = String.format("Index: %s, Price: %.2f, Make: %s, Model: %s, Year: %d, Mileage: %.2f, Condition: %s",
                        car.getIndex(), car.getPrice(), car.getMake(), car.getModel(), car.getYear(), car.getMileage(), car.getCondition());
                System.out.println(result);
                writer.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Основной метод
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();

        // Загрузка автомобилей из файла
        dealership.loadCarsFromFile("C:/Users/micha/IdeaProjects/untitled1/java/indiv2/data_auto.txt");

        // Пример поиска по номеру партии
        String batchNumber = "159348797";  // Заменить на нужный номер
        dealership.findCarsByBatch(batchNumber);

        // Вывод средней цены по маркам
        dealership.printCarsByMakePrice();

        // Вывод гистограммы по цвету
        dealership.printColorHistogram();

        // Вывод статистики
        dealership.printStatisticsByMake();

        // Пример поиска автомобилей по параметрам
        List<String> colors = Arrays.asList("black", "silver");
        List<Car> foundCars = dealership.searchCars(0, 10, colors, "toyota", "clean vehicle");

        // Отображение результатов
        String sortOrder = "price ascending";  // Можно заменить на другие варианты сортировки
        dealership.displayResults(foundCars, sortOrder);
    }
}