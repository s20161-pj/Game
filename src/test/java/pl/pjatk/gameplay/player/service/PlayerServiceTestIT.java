package pl.pjatk.gameplay.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import pl.pjatk.gameplay.player.model.Player;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest

public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @Test
    void test(){
        List<Player> all = playerService.findAll();
        assertThat(all).isEmpty();
    }
    @Test
    void shouldAddPlayerToDB() {
        Player player = new Player(1, "nickname", 100, 50);
        Player save = playerService.save(player);
        assertThat(save.getId()).isNotNull();
    }
}
