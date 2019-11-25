package com.siglo.siglo21maven.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Object;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import com.siglo.siglo21maven.dao.ProductoFacade;
import com.siglo.siglo21maven.dto.Producto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy.PageStamp;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.copy;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ImprimirServlet extends HttpServlet {

    @EJB
    ProductoFacade productoFacade;
    
    private String paginaRetorno = "AdminBodega.jsp";

    public static final String DEST = "results/tables/small_table.pdf";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImprimirServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImprimirServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        GenerarReporte(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public void GenerarReporte(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        try {
            String file = "c:\\reportes\\reporte_productos.pdf";

            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            document.add(new Paragraph("Control de Existencias",
                    FontFactory.getFont("arial", // fuente
                            22, // tamaño
                            Font.ITALIC, // estilo
                            BaseColor.RED)));// color

            document.add(new Paragraph("Productos en Bodega",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.NORMAL, // estilo
                            BaseColor.LIGHT_GRAY)));// color

            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            Paragraph hora = new Paragraph(" Planilla generada a las " + dateFormat.format(date) + " ",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.ITALIC, // estilo
                            BaseColor.LIGHT_GRAY));
            hora.setAlignment(Paragraph.ALIGN_CENTER);
            hora.setSpacingAfter(50);
            document.add(hora);

            PdfPTable table = new PdfPTable(4);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            table.addCell(new Paragraph("Codigo",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.BOLD, // estilo
                            BaseColor.RED)));
            table.addCell(new Paragraph("Producto",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.BOLD, // estilo
                            BaseColor.RED)));
            table.addCell(new Paragraph("Proveedor",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.BOLD, // estilo
                            BaseColor.RED)));
            table.addCell(new Paragraph("Metrica Existencia",
                    FontFactory.getFont("arial", // fuente
                            12, // tamaño
                            Font.BOLD, // estilo
                            BaseColor.RED)));

            List<Producto> productos = productoFacade.findAll();

            for (Producto p : productos) {
                PdfPCell cellC = new PdfPCell(new Phrase(p.getCodigo()));
                PdfPCell cellN = new PdfPCell(new Phrase(p.getNombre()));
                PdfPCell cellP = new PdfPCell(new Phrase(p.getProveedorId().getNombre()));
                PdfPCell cellM = new PdfPCell(new Phrase(p.getMetricaId().getPeso() + " " + p.getMetricaId().getMedida()));

                table.addCell(cellC);
                table.addCell(cellN);
                table.addCell(cellP);
                table.addCell(cellM);

                PdfPCell cell = new PdfPCell();
                cell.setCellEvent(new CheckboxCellEvent("cb" ));
            }
            document.add(table);
            document.close();

            response.sendRedirect(paginaRetorno);
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("errrrrrorrrrrrr archivo PDF0" + ex.getMessage());
        }

    }

    class CheckboxCellEvent implements PdfPCellEvent {

        // The name of the check box field
        protected String name;

        // We create a cell event
        public CheckboxCellEvent(String name) {
            this.name = name;
        }

        // We create and add the check box field
        public void cellLayout(PdfPCell cell, Rectangle position,
                PdfContentByte[] canvases) {
            PdfWriter writer = canvases[0].getPdfWriter();
            // define the coordinates of the middle
            float x = (position.getLeft() + position.getRight()) / 2;
            float y = (position.getTop() + position.getBottom()) / 2;
            // define the position of a check box that measures 20 by 20
            Rectangle rect = new Rectangle(x - 10, y - 10, x + 10, y + 10);
            // define the check box
            RadioCheckField checkbox = new RadioCheckField(
                    writer, rect, name, "Yes");
            // add the check box as a field
            try {
                writer.addAnnotation(checkbox.getCheckField());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

}
