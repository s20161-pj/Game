package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private PlayerService playerService;
    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }
    @GetMapping
    public ResponseEntity<List<model.Player>> findAll(){
        return ResponseEntity.ok(playerService.findAll());
    }
}
