package principal.tutoriales;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tabla {

    public static void generarTablaPDF() throws IOException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("tablas.pdf"));



        document.open();

        for (int i = 0; i < 50; i++){
            trabajarMarca(document);
        }

        document.close();
    }

    private static void trabajarMarca(Document document) throws IOException {
        //imagen de prueba
        Image imagen = Image.getInstance("lol-cuadrado.jpg");
        imagen.scaleAbsolute(150,150);
        //tabla para fotos
        Table table = new Table(2);
        table.setBorderWidth(1);
        table.setPadding(5);
        table.setSpacing(5);
        table.setWidth(100);

        //tabla para sabores
        Table tablaSabores = new Table(2);
        tablaSabores.setPadding(5);
        tablaSabores.setBorderWidth(1);
        tablaSabores.setWidth(100);

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
        Cell tamanioCell;
        //for de sabores
        for (int i = 0; i < Math.floor(Math.random()*10+1); i++){
            tablaSabores.addCell("SABOR "+i);

            tamanioCell = new Cell();
            //For de tamaños
            for (int j = 0; j < Math.floor(Math.random()*5+1); j++){
                tamanioCell.add(new Chunk("TAM "+j+" "));
            }
          /*  tamanioCell.add(new Chunk("TAM 1 "));
            tamanioCell.add(new Chunk("TAM 1 "));
            tamanioCell.add(new Chunk("TAM 1 "));
            tamanioCell.add(new Chunk("TAM 1 "));
            tamanioCell.add(new Chunk("TAM 1 "));
            tamanioCell.add(new Chunk("TAM 1 "));*/

            tablaSabores.addCell(tamanioCell);
        }
        contenedorSaboresCell.add(tablaSabores);

        //ingreso al documento
        Font font = new Font();
        font.setColor(Color.BLUE);
        font.setSize(10);
        Paragraph p = new Paragraph("NOMBRE DE MARCA",font);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingBefore(10);

        document.add(p);
        document.add(table);
        document.add(tablaSabores);

    }

}
