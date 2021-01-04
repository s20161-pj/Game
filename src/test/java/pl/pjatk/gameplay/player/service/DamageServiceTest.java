package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.model.PlayerClass;
import pl.pjatk.gameplay.player.model.PlayerRace;

import static org.assertj.core.api.Assertions.assertThat;

class DamageServiceTest {
    private final DamageService damageService = new DamageService();

    @Test
    void attackTest() {
        //given
        Player attacker = new Player("Test player1", 100, 100, 10, PlayerClass.Warrior, PlayerRace.Gnome);
        Player defender = new Player("Test player2", 200, 20, 5, PlayerClass.Warrior, PlayerRace.Gnome);
        //when
        int defenderHealth = damageService.attack(attacker, defender);
        //then
        assertThat(defenderHealth).isEqualTo(100);
    }

    @Test
    void healTest() {
        //given
        Player playerToHeal = new Player("Test player1", 100, 100, 10, PlayerClass.Warrior, PlayerRace.Gnome);
        int healthToAdd = 50;
        //when
        Player playerHealed = damageService.Heal(playerToHeal, healthToAdd);
        int playerHealth = playerHealed.getHealth();
        //then
        int expectedHealth = healthToAdd + playerToHeal.getAttack();
        assertThat(playerHealth).isEqualTo(expectedHealth);
    }
    @Test
    void removeManaTest(){
        //given
        Player player = new Player("Test player1",100,100,50, PlayerClass.Warrior, PlayerRace.Gnome);
        int manaToRemove = 15;
        int expectedMana = player.getMana()-manaToRemove;
        //when
        Player playerRemovedMana = damageService.RemoveMana(player, manaToRemove);
        //then
        assertThat(playerRemovedMana.getMana()).isEqualTo(expectedMana);
    }
    @Test
    void AttackByPlayersTest(){
        //given
        Player attacker = new Player("Test player1", 100, 100, 50, PlayerClass.Warrior, PlayerRace.Gnome);
        Player defender = new Player("Test player2",200,200,100, PlayerClass.Warrior, PlayerRace.Gnome);
        int expectedHealth = defender.getHealth() - attacker.getAttack();

        //when
        int defenderHealth  = damageService.attack(attacker, defender);
        //then
        assertThat(defenderHealth).isEqualTo(expectedHealth);
    }
}
