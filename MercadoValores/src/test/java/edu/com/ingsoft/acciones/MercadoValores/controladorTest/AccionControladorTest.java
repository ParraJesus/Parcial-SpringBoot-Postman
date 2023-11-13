package edu.com.ingsoft.acciones.MercadoValores.controladorTest;


import edu.com.ingsoft.acciones.MercadoValores.controlador.AccionControlador;
import edu.com.ingsoft.acciones.MercadoValores.servicio.AccionServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AccionControladorTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AccionControlador controlador;

    @Mock
    AccionServicioImp servicioImp;

    @BeforeEach
    public  void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controlador).build();
    }

    @Test
    void accionAgregada() throws Exception{

    }
}
