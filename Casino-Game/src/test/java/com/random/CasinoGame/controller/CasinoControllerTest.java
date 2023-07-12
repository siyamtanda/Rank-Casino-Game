package com.random.CasinoGame.controller;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CasinoControllerTest {

    @Mock
    private CasinoService casinoService;

    @InjectMocks
    private CasinoController casinoController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(casinoController).build();
    }

    @Test
    public void testGetPlayerBalance_ValidPlayerId_ReturnsBalance() throws Exception {
        long playerId = 1L;
        double balance = 100.0;

        when(casinoService.getPlayerBalance(playerId)).thenReturn(balance);

        mockMvc.perform(get("/casino/player/{playerId}/balance", playerId))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(balance)));

        verify(casinoService, times(1)).getPlayerBalance(playerId);
    }
    

}
