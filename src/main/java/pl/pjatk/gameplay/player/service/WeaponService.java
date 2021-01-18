package pl.pjatk.gameplay.player.service;

import pl.pjatk.gameplay.player.model.Armor;
import pl.pjatk.gameplay.player.model.ArmorType;
import pl.pjatk.gameplay.player.model.Weapon;
import pl.pjatk.gameplay.player.model.WeaponType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeaponService {
    public List<Weapon> weapons = List.of(
            new Weapon("longsword", WeaponType.Sword, 100, 120, 80),
            new Weapon("shortsword", WeaponType.Sword, 80, 110, 90),
            new Weapon("longbow", WeaponType.Bows, 90, 130, 125),
            new Weapon("archery_crossbow", WeaponType.Bows, 130, 150, 170),
            new Weapon("bullet_crossbow", WeaponType.Bows, 85, 115, 145),
            new Weapon("carbine", WeaponType.Gun, 200, 230, 300),
            new Weapon("sniper_rifles", WeaponType.Gun, 250, 217, 350),
            new Weapon("lupins_wand", WeaponType.Wand, 180, 400, 140),
            new Weapon("crash_axe", WeaponType.Axe, 270, 290, 160),
            new Weapon("felling_axe", WeaponType.Axe, 390, 285, 170));

    public Weapon getRandomWeapon() {
        Random rand = new Random();
        Weapon randomWeapon = weapons.get(rand.nextInt(weapons.size()));
        return randomWeapon;
    }
}



