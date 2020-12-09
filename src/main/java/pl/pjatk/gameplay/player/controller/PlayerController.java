package pl.pjatk.gameplay.player.controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.player.model.Player;
import org.springframework.http.ResponseEntity;
import pl.pjatk.gameplay.player.service.DamageService;
import pl.pjatk.gameplay.player.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService,
                            DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findById(@PathVariable Long id) {
        Optional<Player> byId = playerService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.save(player));
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@RequestBody Player player,@PathVariable long id) {
        try
        {
            return ResponseEntity.ok(playerService.update(id,player));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/attack/{attackerId}/{defenderId}")
    public ResponseEntity<Integer> attack(@RequestBody Player attacker, @RequestBody Player defender) {
        return ResponseEntity.ok(damageService.attack(attacker, defender));
    }
}
 