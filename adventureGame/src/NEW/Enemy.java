package NEW;

// Enemy.java

abstract class Enemy {
    private int health;

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public abstract void attack(Player player);
}

class Snake extends Enemy {
    private static final int ID = 4;
    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DAMAGE = 6;
    private static final int HEALTH = 12;

    public Snake() {
        super(HEALTH);
    }

    @Override
    public void attack(Player player) {
        int damage = (int) (Math.random() * (MAX_DAMAGE - MIN_DAMAGE + 1) + MIN_DAMAGE);
        player.takeDamage(damage);
        System.out.println("The snake dealt " + damage + " damage to you.");
    }
}
