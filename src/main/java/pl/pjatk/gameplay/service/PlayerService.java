package pl.pjatk.gameplay.service;

import pl.pjatk.gameplay.model.Player;
import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.repository.PlayerRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
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
        //List<Player> players = new ArrayList<>();
        // players.add(new Player(1L, "Player 1", 100, 10, 5));
        // players.add(new Player(2L, "Player 2", 50, 5, 5));
        //players.add(new Player(3L, "Player 3", 30, 4, 5));

        //players.forEach(player -> player.setMana(10));
        //return players.stream().filter(player -> player.getId() == id).findFirst();

        //       for(Player player :players){
        //           if (player.getId() == id) {
        //               return player;
        //          }
        //      return new Player();
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



