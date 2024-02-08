package Controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioControllerTest {
    FuncionarioController funcionario;

    @BeforeEach
    void setUp () throws FileNotFoundException {
        funcionario = new FuncionarioController("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoTest.csv");
    }
    @Test
    void addVenda() throws IOException {
        String path = "C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoTest.csv";
        funcionario.addVenda("Alimentacao", "Gomas", 20, 1.99, path);
        File file = new File(path);
        Scanner sc = new Scanner(file);

        String tipoProduto = "";
        String nomeProduto = "";
        String quantidadeVendida = "";
        String precoProduto = "";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaDividida = linha.split(",");

            tipoProduto = linhaDividida[0];
            nomeProduto = linhaDividida[1];
            quantidadeVendida = linhaDividida[2];
            precoProduto = linhaDividida[3];
        }

        assertEquals ("Alimentacao", tipoProduto);
        assertEquals("Gomas", nomeProduto);
        assertEquals("20", quantidadeVendida);
        assertEquals("1.99", precoProduto);
    }
    @Test
    void consultarStockProduto(){
        assertEquals(1180, funcionario.consultarStockProduto("Bacalhau"));
        assertEquals(1195, funcionario.consultarStockProduto("Aspirador de Po"));
    }

    @AfterEach
    void tearDown() throws FileNotFoundException {
        // Limpar o ficheiro
        File fileTest = new File("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoTest.csv");
        File fileOriginal = new File("C:\\Users\\ritas\\Documents\\Repos\\Projeto_QA_Ana_Rita_Silva\\src\\test\\resources\\Ficheiros\\minimercadoOriginal.csv");

        PrintWriter pw = new PrintWriter(fileTest);
        Scanner sc = new Scanner(fileOriginal);

        int count=0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if(count<132){
                pw.println(linha);
            }else{
                pw.print(linha);
            }
            count++;
        }
        pw.close();
    }
}
