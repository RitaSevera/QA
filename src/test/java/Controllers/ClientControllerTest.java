package Controllers;

import Repository.VendasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientControllerTest {
    ClientController client;

    @BeforeEach
    void setUp () throws FileNotFoundException {
        client = new ClientController("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoTest.csv");
    }
    @Test
    void produtoMaisCaro(){
        assertEquals ("Produtos para Casa", client.produtoMaisCaro().getTipoProduto());
        assertEquals("Aspirador de Po", client.produtoMaisCaro().getProduto());
        assertEquals(99.99, client.produtoMaisCaro().getPrecoUnitario());
    }
    @Test
    void produtoMaisBarato(){
        assertEquals("Alimentacao", client.produtoMaisBarato().getTipoProduto());
        assertEquals("Pate de Sardinha", client.produtoMaisBarato().getProduto());
        assertEquals(0.65, client.produtoMaisBarato().getPrecoUnitario());
    }
    @Test
    void produtosDisponiveisSemDuplicados(){
        assertEquals(107, client.produtosDisponiveisSemDuplicados().size());
    }
    @Test
    void produtosDeCategoria(){
        assertEquals(44, client.produtosDeCategoria("Alimentacao").size());
        assertEquals(30, client.produtosDeCategoria("Higiene").size());
        assertEquals(33, client.produtosDeCategoria("Produtos para Casa").size());
    }

}
