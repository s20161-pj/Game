package service;

import model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> findAll(){
        return List.of(
                new Player("Player 1",100,10,5),
                new Player("Player 2",50,5,5));
    }
}
