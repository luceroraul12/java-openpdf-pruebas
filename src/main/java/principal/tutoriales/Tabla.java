package principal.tutoriales;

import com.lowagie.text.*;
import com.lowagie.text.List;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Tabla {

    public static void generarTablaPDF() throws FileNotFoundException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("tablas.pdf"));

        document.open();

        Table table = new Table(3);
        table.setBorderWidth(1);
        table.setPadding(5);
        table.setSpacing(5);

        table.addCell("IMG");
        Cell cell = new Cell("MARCA");
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("IMG");
        cell = new Cell("PRODUCTO ICÓNICO");
        cell.setColspan(2);
        table.addCell(cell);

        cell = new Cell("Sabores");
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("TAMAÑOS");

        cell = new Cell("Sabor de Ejemplo");
        cell.setColspan(2);
        table.addCell(cell);

        //Quiero tener una lista en el lugar de la celda por lo tanto
        //creo una celda nueva para alvergar la tabla
        Cell cellTamanio = new Cell();
        //creo la tabla que quiero colocar
        List lista = new List();
        //Agrego los items a lista
        lista.add("1 Lts");
        lista.add("2.5 Lts");
        lista.add("5 Lts");

        //agrego la lista a la celda
        cellTamanio.add(lista);

        //agrego la celda a la tabla. quedando Celda > Lista > items de lista
        table.addCell(cellTamanio);



        document.add(table);

        document.close();
    }

}
