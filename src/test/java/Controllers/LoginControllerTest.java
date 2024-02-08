package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginControllerTest {
    LoginController login;

    @BeforeEach
    void setUp () throws FileNotFoundException {
        this.login = new LoginController("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\main\\resources\\Ficheiros\\login_grandesNegocios.csv");
    }
    @Test
    void validarLogin(){
        assertTrue(login.validarLogin("ADMIN", "patrao", "grandesnegocios"));
        assertTrue(login.validarLogin("FUNC", "ivone", "costa"));
        assertTrue(login.validarLogin("FUNC", "quim", "formacaoDramatica"));
        assertTrue(login.validarLogin("ADMIN", "data_analyst", "senha"));
        assertFalse(login.validarLogin("ALUNA", "severa", "qa"));
    }
}
