package pl.pjatk.gameplay.player.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Armor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int durability;
    private ArmorType type;

    public Armor(String name, int durability, ArmorType type) {
        this.name = name;
        this.durability = durability;
        this.type = type;
    }
    public Armor(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public ArmorType getType() {
        return type;
    }

    public void setType(ArmorType type) {
        this.type = type;
    }
}
