package pt.ufp.info.esof.projeto.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.projeto.models.Empregado;
import pt.ufp.info.esof.projeto.repositories.EmpregadoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpregadoController.class)
class EmpregadoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmpregadoRepository empregadoRepository;

    @Test
    void testGetAllEmpregados() throws Exception {
        List<Empregado> empregados = new ArrayList<>();
        empregados.add(new Empregado());
        when(empregadoRepository.findAll()).thenReturn(empregados);
        String resultJson = mockMvc.perform(get("/empregado"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(resultJson);
    }

    @Test
    void testGetEmpregadoById() throws Exception {
        Empregado empregado = new Empregado();
        empregado.setId(1L);
        String empregadoAsJsonString=new ObjectMapper().writeValueAsString(empregado);

        when(empregadoRepository.findById(1L)).thenReturn(Optional.of(empregado));

        String httpResponseAsString = mockMvc.perform(get("/empregado/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);
        assertEquals(empregadoAsJsonString,httpResponseAsString);

    }

    @Test
    void testCreateEmpregado() {
    }
}