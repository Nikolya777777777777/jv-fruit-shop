package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class FruitTransaction {
    private Fruit apple;
    private Fruit banana;
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction() {
    }

    public Fruit getApple() {
        return apple;
    }

    public Fruit getBanana() {
        return banana;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<FruitTransaction> parseTransaction(String[] transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] parts = transaction.split(",");

            Operation operation = Operation.getOperation(parts[0]);
            if (parts[1].startsWith("b")) {
                fruit = banana;
            } else {
                fruit = apple;
            }
            int quantity = Integer.parseInt(parts[2]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);

            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
