package pl.pjatk.gameplay.player.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;
    private PlayerClass playerClass;
    private PlayerRace playerRace;
    private int level;
    @OneToOne(mappedBy = "player")
    private Weapon weapon;
    @OneToMany(mappedBy = "player")
    private List<Armor> armors;
    public Player() {
    }

    public Player(Long id, String nickname, int health, int attack, int mana, PlayerClass playerClass, PlayerRace playerRace, Weapon weapon,ArrayList<Armor>armors) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.playerClass=playerClass;
        this.playerRace=playerRace;
        this.weapon = weapon;
        this.armors=armors;
        this.level=1;
    }

    public Player(String nickname, int health, int attack, int mana, PlayerClass playerClass, PlayerRace playerRace,Weapon weapon,ArrayList<Armor>armors) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.playerClass=playerClass;
        this.playerRace=playerRace;
        this.weapon = weapon;
        this.armors=armors;
        this.level=1;
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

