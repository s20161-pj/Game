package pl.pjatk.gameplay.player.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;

    public Player() {

    }

    public Player(Long id, String nickname, int health, int attack, int mana) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public Player(String nickname, int health, int attack, int mana) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }
}

