import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

class BakeShop {
    private List<Cake> cakes;
    private List<String> pastries;
    private List<String> breads;
    private Queue<Receipt> orderQueue;

    public BakeShop() {
        cakes = new ArrayList<>();
        pastries = new ArrayList<>();
        breads = new ArrayList<>();
        orderQueue = new LinkedList<>();
    }

    public void addCake(Cake cake) {
        cakes.add(cake);
    }

    public void addPastry(String pastry) {
        pastries.add(pastry);
    }

    public void addBread(String bread) {
        breads.add(bread);
    }

    public void enqueueOrder(Receipt receipt) {
        orderQueue.offer(receipt);
    }

    public void displayMenu() {
        System.out.println("Welcome to the Bake Shop!");
        System.out.println("Menu Options:");
        System.out.println("1. Customize Cake");
        System.out.println("2. Customize Pastries");
        System.out.println("3. Customize Bread");
        System.out.println("4. Print Receipt");
        System.out.println("5. Next Order");
        System.out.println("6. Exit");
    }

    public void customizeCake() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customize Cake");
        System.out.print("Enter size (small, medium, large): ");
        String size = scanner.nextLine();
        System.out.print("Enter flavor(Vanilla, Chocolate): ");
        String flavor = scanner.nextLine();
        System.out.print("Enter toppings (comma-separated ex:Spriknles): ");
        String toppingsString = scanner.nextLine();
        List<String> toppings = Arrays.asList(toppingsString.split(","));
        System.out.print("Enter fruits (comma-separated): ");
        String fruitsString = scanner.nextLine();
        List<String> fruits = Arrays.asList(fruitsString.split(","));

        Cake cake = new Cake(size, flavor, toppings, fruits);
        addCake(cake);

        System.out.println("Cake added successfully!");
        System.out.println();
    }

    public void customizePastries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customize Pastries");
        System.out.print("Enter pastry name: ");
        String pastry = scanner.nextLine();

        addPastry(pastry);

        System.out.println("Pastry added successfully!");
        System.out.println();
    }

    public void customizeBread() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customize Bread");
        System.out.print("Enter bread name: ");
        String bread = scanner.nextLine();

        addBread(bread);

        System.out.println("Bread added successfully!");
        System.out.println();
    }

    public void displayOrderSummary() {
        System.out.println("Order Summary:");
        if (orderQueue.isEmpty()) {
            System.out.println("No orders in the queue.");
            return;
        }

        int orderCount = 1;
        for (Receipt receipt : orderQueue) {
            System.out.println("Order #" + orderCount++);
            System.out.println("Order Date: " + receipt.getOrderDate());
            System.out.println("Cakes:");
            List<Cake> cakes = receipt.getCakes();
            for (Cake cake : cakes) {
                System.out.println("Size: " + cake.getSize());
                System.out.println("Flavor: " + cake.getFlavor());
                System.out.println("Toppings: " + cake.getToppings());
                System.out.println("Fruits: " + cake.getFruits());
                System.out.println("-----------------------");
            }

            System.out.println("Pastries:");
            List<String> pastries = receipt.getPastries();
            for (String pastry : pastries) {
                System.out.println(pastry);
            }

            System.out.println("Breads:");
            List<String> breads = receipt.getBreads();
            for (String bread : breads) {
                System.out.println(bread);
            }
            System.out.println("-----------------------");
        }
    }

    public void printNextOrder() {
        if (!orderQueue.isEmpty()) {
            Receipt receipt = orderQueue.poll();
            receipt.printReceipt();
        } else {
            System.out.println("No orders in the queue.");
        }
    }
}

class Cake {
    private String size;
    private String flavor;
    private List<String> toppings;
    private List<String> fruits;

    public Cake(String size, String flavor, List<String> toppings, List<String> fruits) {
        this.size = size;
        this.flavor = flavor;
        this.toppings = toppings;
        this.fruits = fruits;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getFruits() {
        return fruits;
    }
}

class Receipt {
    private String orderDate;
    private List<Cake> cakes;
    private List<String> pastries;
    private List<String> breads;

    public Receipt(List<Cake> cakes, List<String> pastries, List<String> breads) {
        this.orderDate = new Date().toString();
        this.cakes = cakes;
        this.pastries = pastries;
        this.breads = breads;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public List<String> getPastries() {
        return pastries;
    }

    public List<String> getBreads() {
        return breads;
    }

    public void printReceipt() {
        System.out.println("Order Receipt");
        System.out.println("Cakes:");
        for (Cake cake : cakes) {
            System.out.println("Size: " + cake.getSize());
            System.out.println("Flavor: " + cake.getFlavor());
            System.out.println("Toppings: " + cake.getToppings());
            System.out.println("Fruits: " + cake.getFruits());
            System.out.println("-----------------------");
        }

        System.out.println("Pastries:");
        for (String pastry : pastries) {
            System.out.println(pastry);
        }

        System.out.println("Breads:");
        for (String bread : breads) {
            System.out.println(bread);
        }
        System.out.println("Thank you for your order!");
    }
}


