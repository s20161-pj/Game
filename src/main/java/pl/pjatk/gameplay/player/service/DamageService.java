package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

@Service
public class DamageService {
    public int attack(Player attacker, Player defender) {
        int attackerAttack = attacker.getAttack();
        int defenderHealth = defender.getHealth();

        defender.setHealth(defenderHealth - attackerAttack);
        return defender.getHealth();
    }

    public Player Heal(Player playerToHeal, int healthToAdd)
    {
        int playerHealth = playerToHeal.getHealth();
        playerToHeal.setHealth(playerHealth + healthToAdd);

        return playerToHeal;
    }

    public Player RemoveMana(Player player, int manaToRemove)
    {
        int playerMana = player.getMana();
        player.setMana(playerMana - manaToRemove);
        return player;
    }

    public int AttackByPlayers(Player attacker, Player defender) {
        int attackerAttack = attacker.getAttack();
        int defenderHealth = defender.getHealth();

        defender.setHealth(defenderHealth - attackerAttack);
        return defender.getHealth();
    }



}



