package com.random.CasinoGame.repository;

@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testFindByUsername_ExistingUsername_ReturnsPlayer() {
        String username = "john123";

        Player player = new Player();
        player.setUsername(username);
        entityManager.persist(player);
        entityManager.flush();

        Player foundPlayer = playerRepository.findByUsername(username);

        assertEquals(username, foundPlayer.getUsername());
    }
    
    
}
