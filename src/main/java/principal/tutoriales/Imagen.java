package principal.tutoriales;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Imagen {

    public static void crearDocumentoConImagenLocal(String nombreDelArchivoConExtension){
        // step 1: creation of a document-object
        Document document = new Document();

        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream("ImagebLocal.pdf"));

            // step 3: we open the document
            document.open();

            // step 4:
            Paragraph p = new Paragraph();

            Image jpg = Image.getInstance(nombreDelArchivoConExtension);
            //metodo para modificar damaño de la imagen
            jpg.scaleAbsolute(100,100);
            jpg.setSpacingAfter(10);
            jpg.setSpacingBefore(10);
            //lo agrego al mismo paragraph
            p.add(jpg);
            Chunk texto = new Chunk("Esto es un titulo");
            p.add(texto);


            document.add(p);

        }
        catch(DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        // step 5: we close the document
        document.close();
    }

    public static void crearDocumentConImagenInternet(String enlaceImagen){

        // step 1: creation of a document-object
        Document document = new Document();

        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream("ImagenUrl.pdf"));

            // step 3: we open the document
            document.open();

            // step 4:
            Paragraph p = new Paragraph();

            Image jpg = Image.getInstance(new URL(enlaceImagen));
            //metodo para modificar damaño de la imagen
            jpg.scaleAbsolute(100,100);
            jpg.setSpacingAfter(10);
            jpg.setSpacingBefore(10);
            //lo agrego al mismo paragraph
            p.add(jpg);
            Chunk texto = new Chunk("Imagen desde Internet");
            p.add(texto);


            document.add(p);

        }
        catch(DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        // step 5: we close the document
        document.close();

    }

}
