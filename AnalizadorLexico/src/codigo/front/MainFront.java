/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.front;

import codigo.MiLexer;
import codigo.Token;
import codigo.TokenConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class MainFront {

    public static void main(String[] args) {
        analizar("id1 45 89 id2 2ad ! ' \" 23 num1 num2");
    }

    public static void analizar(String texto) {
        File archivo = new File("archivo.txt");
        String resultado = "";
        try {
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.print(texto);
            escribir.close();
            Reader lector = new BufferedReader(new FileReader("J:\\Universidad\\Vaqueras-Guate\\Compi 1\\Laboratorio\\codigo.txt"));
            MiLexer lexer = new MiLexer(lector);

            while (true) {
                Token token = lexer.yylex();

                if (token.getTypeToken() == TokenConstant.EOF) {
                    resultado += "FIN";
                    System.out.println(resultado);
                    return;
                }

                resultado += token.toString();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFront.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFront.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
