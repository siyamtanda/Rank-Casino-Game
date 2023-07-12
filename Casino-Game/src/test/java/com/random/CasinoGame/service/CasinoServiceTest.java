import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CasinoServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private BalanceRepository balanceRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private CasinoService casinoService;

    @Test
    public void testGetPlayerBalance_ValidPlayerId_ReturnsBalance() {
        long playerId = 1L;
        double expectedBalance = 100.0;

        Player player = new Player();
        player.setId(playerId);

        Balance balance = new Balance();
        balance.setPlayer(player);
        balance.setBalanceAmount(expectedBalance);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));
        when(balanceRepository.findByPlayer(player)).thenReturn(Optional.of(balance));

        double actualBalance = casinoService.getPlayerBalance(playerId);

        assertEquals(expectedBalance, actualBalance, 0.01);
    }
    
    // Other test methods for different scenarios
}
