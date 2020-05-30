package com.mateuszmedon.projectone.coffiemachine;

import java.util.Scanner;

public class CoffeeMachine {

    //    package machine;
//
//    import java.util.Scanner;
//
//    public class CoffeeMachine {
    static Coffee coffeeMachine = new Coffee(400, 540, 120, 9, 550);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            flag = coffeeMachine.choose();
        }
    }
}

class Coffee {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    static Scanner scanner = new Scanner(System.in);

    public Coffee(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void withdraw() {
        System.out.println("I gave you $" + getMoney());
        addMoney(-getMoney());
        System.out.println();
    }

    public void setMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        addWater(fill());
        System.out.println("Write how many ml of milk do you want to add:");
        addMilk(fill());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        addCoffeeBeans(fill());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        addCups(fill());
    }

    private int fill() {
        int add = scanner.nextInt();
        scanner.nextLine();
        return add;
    }

    public boolean coffeeCounter(int w, int m, int cB) {

        int waterCheck = getWater() / w;
        int milkCheck = getMilk() / m;
        int coffeeBeansCheck = getCoffeeBeans() / cB;

        boolean available = true;
        if (waterCheck == 0) {
            available = isAvailable("water");
        } else if (milkCheck == 0) {
            available = isAvailable("milk");
        } else if (coffeeBeansCheck == 0) {
            available = isAvailable("coffee beans");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
        }
        return available;
    }

    private boolean isAvailable(String message) {
        System.out.println("Sorry, not enough " + message + "!\n");
        return false;
    }

    public void displayCoffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(getWater() + " of water");
        System.out.println(getMilk() + " of milk");
        System.out.println(getCoffeeBeans() + " of coffee beans");
        System.out.println(getCups() + " of disposable cups");
        System.out.println(getMoney() + " of money\n");
    }

    public boolean choose() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                buyCoffee();
                return true;
            case "fill":
                setMachine();
                return true;
            case "take":
                withdraw();
                return true;
            case "remaining":
                displayCoffeeMachineStatus();
                return true;
            case "exit":
                return false;
        }
        System.out.println("Invalid command");
        return false;
    }

    public void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (coffeeCounter(250, 1, 16)) {
                    coffeeDeal(-250, 0, -16, -1, 4);
                }
                break;
            case "2":
                if (coffeeCounter(350, 75, 20)) {
                    coffeeDeal(-350, -75, -20, -1, 7);
                }
                break;
            case "3":
                if (coffeeCounter(200, 100, 12)) {
                    coffeeDeal(-200, -100, -12, -1, 6);
                }
                break;
            default:
                choose();
        }
    }

    private void coffeeDeal(int w, int m, int cB, int c, int m$) {
        addWater(w);
        addMilk(m);
        addCoffeeBeans(cB);
        addCups(c);
        addMoney(m$);
    }

    public int getWater() {
        return water;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public int getMilk() {
        return milk;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public void addCups(int cups) {
        this.cups += cups;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }
}

