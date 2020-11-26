package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DamageService {
    public PlayerRepository playerRepository;

    public DamageService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public int attack(long attackerId, long defenderId) {
        Player attacker = playerRepository.findById(attackerId).get();
        Player defender = playerRepository.findById(defenderId).get();
        int attackerAttack = attacker.getAttack();
        int defenderHealth = defender.getHealth();

        defender.setHealth(defenderHealth - attackerAttack);
        return defender.getHealth();
    }

}



