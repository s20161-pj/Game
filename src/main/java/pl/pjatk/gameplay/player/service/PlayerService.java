package pl.pjatk.gameplay.player.service;

import pl.pjatk.gameplay.player.model.Player;
import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    public PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Long id, Player playerToUpdate) throws Exception {
        Optional<Player> playerEntity = findById(id);
        if(!playerEntity.isPresent()){
           throw new Exception("Nie ma gracza o podanym id: " + id);
        }
        Player player = playerEntity.get();

        player.setHealth(playerToUpdate.getHealth());
        player.setAttack(playerToUpdate.getAttack());
        player.setMana(playerToUpdate.getMana());
        player.setNickname(playerToUpdate.getNickname());

        return playerRepository.save(player);
    }
}



