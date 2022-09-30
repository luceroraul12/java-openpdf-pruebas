package principal.tutoriales;

import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tabla {

    public static void generarTablaPDF() throws IOException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("tablas.pdf"));
        //imagen de prueba
        Image imagen = Image.getInstance("lol-rectangulo.jpg");
        imagen.scaleAbsolute(150,150);


        document.open();
        //tabla para fotos
        Table table = new Table(2);
        table.setBorderWidth(1);
        table.setPadding(5);
        table.setSpacing(5);

        //tabla para sabores
        Table tablaSabores = new Table(2);
        tablaSabores.setPadding(5);
        tablaSabores.setBorderWidth(1);

        //por cada marca
        Cell brandCell = new Cell();
        brandCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        brandCell.add(imagen);
        brandCell.add(new Paragraph("MARCA "));
        table.addCell(brandCell,0,0);

        //por cada marca
        Cell iconicBrandCell = new Cell();
        iconicBrandCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        iconicBrandCell.add(imagen);
        iconicBrandCell.add(new Chunk("PRODUCTO ICONICO "));
        table.addCell(iconicBrandCell,0,1);

        //Por cada marca
        Cell contenedorSaboresCell = new Cell();
        contenedorSaboresCell.setColspan(2);
        contenedorSaboresCell.setRowspan(2);


        //trabajar con los sabores - tamaños
        tablaSabores.addCell("Sabores");
        tablaSabores.addCell("Tamaños");




        //guardarlo en el contenedor de sabores
        contenedorSaboresCell.add(tablaSabores);

//        table.addCell(contenedorSaboresCell,0,1);









        //ingreso en tabla


        document.add(table);
        document.add(tablaSabores);

        document.close();
    }

}
