package pl.pjatk.gameplay.player.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weapon {
    private String name;
    private WeaponType type;
    private int damage;     //zniszczenia bronią
    private int durability;
    private int speed;
    @Id
    @GeneratedValue
    private int id;

    public Weapon(String name) {
        this.name = name;
    }

    public Weapon(String name, WeaponType type, int damage, int durability, int speed) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.durability = durability;
        this.speed = speed;
    }

    public Weapon() {

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
