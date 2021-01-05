package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.gameplay.player.model.*;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before each here");
    }

    @Test
    void findAllTest() {
        //Given
        ArrayList<Armor> armors = new ArrayList<Armor>();
        Armor armor = new Armor("armor1", 100, ArmorType.Cloth);
        armors.add(armor);
        when(playerRepository.findAll()).thenReturn(List.of(new Player("nick", 1, 2, 3, PlayerClass.Warrior, PlayerRace.Gnome,new Weapon("Sword1",WeaponType.Sword,100,200,150), armors)));
        //When
        List<Player> all = playerService.findAll();
        //Then
        assertThat(all).isNotEmpty();
    }

    @Test
    void findByIdTest() {
        //Given
        ArrayList<Armor> armors = new ArrayList<Armor>();
        Armor armor = new Armor("armor1", 100, ArmorType.Cloth);
        armors.add(armor);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player("nick", 1, 2, 3, PlayerClass.Warrior, PlayerRace.Gnome,new Weapon("Sword1",WeaponType.Sword,100,200,150), armors)));
        //When
        Optional<Player> optionalPlayer = playerService.findById(1L);
        //Then
        assertThat(optionalPlayer.get().getNickname()).isEqualTo("nick");
    }
    @Test
    void saveTest() {
        //Given
        ArrayList<Armor> armors = new ArrayList<Armor>();
        Armor armor = new Armor("armor1", 100, ArmorType.Cloth);
        armors.add(armor);
        Player player = new Player("nick", 1, 2, 3, PlayerClass.Warrior, PlayerRace.Gnome,new Weapon("Sword1",WeaponType.Sword,100,200,150),armors);
        Player player2 = new Player(1L,"nick", 1, 2, 3, PlayerClass.Warrior, PlayerRace.Gnome,
                new Weapon("Test", WeaponType.Sword, 100, 100, 10),armors);
        when(playerRepository.save(player)).thenReturn(player2);
        //When
        Player savedPlayer = playerService.save(player);
        //Then
        assertThat(savedPlayer).isEqualTo(player2);
    }
    @Test
    void shoulddeleteTest() {
        playerService.delete(1L);

        verify(playerRepository, times(1)).deleteById(1L);
    }
}