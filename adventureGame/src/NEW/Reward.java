package NEW;

// Reward.java

abstract class Reward {
    public abstract void apply(Player player);
}

class Food extends Reward {
    @Override
    public void apply(Player player) {
        player.addToInventory("Food");
        System.out.println("You received Food as a reward.");
    }
}

class Firewood extends Reward {
    @Override
    public void apply(Player player) {
        player.addToInventory("Firewood");
        System.out.println("You received Firewood as a reward.");
    }
}

class Water extends Reward {
    @Override
    public void apply(Player player) {
        player.addToInventory("Water");
        System.out.println("You received Water as a reward.");
    }
}

class Weapon extends Reward {
    private String type;

    public Weapon(String type) {
        this.type = type;
    }

    @Override
    public void apply(Player player) {
        player.addToInventory(type);
        System.out.println("You received a " + type + " as a reward.");
    }
}

class Armor extends Reward {
    private String type;

    public Armor(String type) {
        this.type = type;
    }

    @Override
    public void apply(Player player) {
        player.addToInventory(type);
        System.out.println("You received " + type + " as a reward.");
    }
}

class Money extends Reward {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Player player) {
        player.addMoney(amount);
        System.out.println("You received " + amount + " money as a reward.");
    }
}
