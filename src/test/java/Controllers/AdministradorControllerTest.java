package Controllers;

import Domain.Venda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministradorControllerTest {
    AdministradorController admin;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        admin = new AdministradorController("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoTest.csv");
    }
    @Test
    void produtoMaisVendido(){ //maior quantidade total de vendas ao longo do tempo
        assertEquals (1111, admin.produtoMaisVendido().getQuantidadeVendida());
        assertEquals("Cerveja Super Bock", admin.produtoMaisVendido().getProduto());

    }
    @Test
    void produtoQueMaisVendeu(){ //quantidade vendida em uma única transação
        assertEquals("Cerveja Super Bock", admin.produtoQueMaisVendeu().getProduto());
        assertEquals(445, admin.produtoQueMaisVendeu().getQuantidadeVendida());

    }
    @Test
    void vendaMaisValor(){
        assertEquals("Vinho Verde", admin.vendaMaisValor().getProduto());
        assertEquals(90, admin.vendaMaisValor().getQuantidadeVendida());
        assertEquals(5.99, admin.vendaMaisValor().getPrecoUnitario());

    }
    @Test
    void adicionarUtilizador() throws IOException {
        String path = "C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\login_grandesNegociosTest.csv";
        admin.adicionarUtilizador("ADMIN", "severa", "softdev", path);
        File file = new File(path);
        Scanner sc = new Scanner(file);

        String tipoUtilizador = "";
        String username = "";
        String password = "";

        while (sc.hasNextLine()){
            String linha = sc.nextLine();
            String[] linhaDividida = linha.split(";");

            tipoUtilizador = linhaDividida[0];
            username = linhaDividida[1];
            password = linhaDividida[2];
        }
        assertEquals("ADMIN", tipoUtilizador);
        assertEquals("severa", username);
        assertEquals("softdev", password);

    }
    @Test
    void valorVendas(){
        assertEquals(15995.62, admin.valorVendas());

    }
    @Test
    void mediaVendas(){
        assertEquals(122.10396946564886, admin.mediaVendas());
    }
}
