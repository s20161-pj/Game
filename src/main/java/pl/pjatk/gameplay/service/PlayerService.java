package pl.pjatk.gameplay.service;

import pl.pjatk.gameplay.model.Player;
import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.repository.PlayerRepository;

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

    public Optional<Player> findById(int id) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L, "Player 1", 100, 10, 5));
        players.add(new Player(2L, "Player 2", 50, 5, 5));
        players.add(new Player(3L, "Player 3", 30, 4, 5));

        players.forEach(player -> player.setMana(10));
        return players.stream().filter(player -> player.getId() == id).findFirst();

        //       for(Player player :players){
        //           if (player.getId() == id) {
        //               return player;
        //          }
        //      return new Player();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }
}



