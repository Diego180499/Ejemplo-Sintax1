/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {

        String rutaLexer = "J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/Lexer.flex";
        String rutaLexerCup = "J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/LexerCup.flex";
        String[] rutaSintax = {"-parser", "Sintax", "J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/Sintax.cup"};

        try {
            generarParser(rutaLexer, rutaLexerCup, rutaSintax);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);

    }

    public static void generarParser(String rutaLexer, String rutaLexerCup, String[] rutaSintax) throws IOException, Exception {
        //Generamos el lexer 1
        File archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);

        //Generamos el Lexer para cup
        File archivo2 = new File(rutaLexerCup);
        JFlex.Main.generate(archivo2);

        java_cup.Main.main(rutaSintax);

        Path rutaSym = Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/sym.java");

        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }

        Files.move(
                Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/sym.java"),
                Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/sym.java")
        );

        //ruta sintax
        Path rutaSin = Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/Sintax.java");

        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }

        Files.move(
                Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/Sintax.java"),
                Paths.get("J:/Universidad/Vaqueras-Guate/Compi 1/Laboratorio/Ejemplo-Flex/AnalizadorLexico/src/codigo/Sintax.java")
        );

    }

}
