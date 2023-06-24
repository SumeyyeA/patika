package NEW;

// Player.java

import java.util.ArrayList;
import java.util.List;

class Player {
    private int health;
    private List<String> inventory;
    private int money;

    public Player() {
        this.health = 100;
        this.inventory = new ArrayList<>();
        this.money = 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println("You took " + damage + " damage. Your health: " + health);
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void addMoney(int amount) {
        money += amount;
    }

    private Reward getRandomReward() {
        int chance = (int) (Math.random() * 100) + 1;

        if (chance <= 15) {
            return new Weapon("Gun");
        } else if (chance <= 35) {
            return new Weapon("Sword");
        } else if (chance <= 55) {
            return new Armor("Light Armor");
        } else if (chance <= 75) {
            return new Armor("Medium Armor");
        } else if (chance <= 90) {
            return new Money(1);
        } else {
            return new Money(5);
        }
    }

    private boolean checkWinCondition() {
        // Check if player has collected all rewards and can return to Safe House
        // Implement your logic here
        return false;
    }

    private void win() {
        System.out.println("Congratulations! You have collected all rewards and won the game.");
    }

    public void exploreCave() {
        Snake snake = new Snake();
        snake.attack(this);
        if (snake.getHealth() == 0) {
            Reward reward = new Food();
            reward.apply(this);
        }
        // Continue with the rest of the game logic
    }
}
