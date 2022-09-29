package principal;

import principal.tutoriales.HelloWorld;
import principal.tutoriales.Imagen;
import principal.tutoriales.Tabla;

import java.io.FileNotFoundException;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("HelloWorld");

        HelloWorld.crearDocumentoConTexto("Esto es un texto de prueba, para ver lo que se puede lograr con solo texto como input");

        Imagen.crearDocumentoConImagenLocal("lol-cuadrado.jpg");

        Imagen.crearDocumentConImagenInternet("https://i.imgur.com/JVMcwMs.jpg");

        Tabla.generarTablaPDF();

    }

}
