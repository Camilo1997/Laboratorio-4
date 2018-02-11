/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw;

import edu.eci.pdsw.stubs.datasourcestub.Client;
import edu.eci.pdsw.stubs.datasourcestub.ClientNotFoundException;
import edu.eci.pdsw.stubs.datasourcestub.DataSourceStub;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilo Lopez
 */
@WebServlet(
        urlPatterns = "/pruebaWeb"
)
public class Ejercicio extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Writer responseWriter = resp.getWriter();
        DataSourceStub cliente = DataSourceStub.getInstance();
        
        String name, address, email;
        int sallary;
        
        try {
            Client clientById = cliente.getClientById(Integer.parseInt(req.getParameter("id")));
            name = clientById.getName();
            address = clientById.getAddress();
            email = clientById.getEmail();
            sallary = clientById.getSallary();
            resp.setStatus(200);
            responseWriter.write("<HTML>"
                    + " <body>"
                    + " <table style=\"width:100%\">"
                        + "<tr>"
                            + "<th>Nombre</th> <th>Email</th> <th>Direccion</th> <th>Salario</th>"
                        + "</tr>"
                        + "<tr>"
                            + "<th>" + name + "</th> <th>" + email + "</th> <th>" + address + 
                            " </th> <th>" + sallary + "</th>"
                        + "</tr>"
                    + "</table>"
                    + "</body>"
                    + "</HTML>");
            responseWriter.flush();
        } catch (ClientNotFoundException ex) {
            resp.setStatus(400);
            responseWriter.write("No existe informacion acerca del cliente"); 
            responseWriter.flush();
        }       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Writer responseWriter = resp.getWriter();
        DataSourceStub cliente = DataSourceStub.getInstance();
        
        String name, address, email;
        int sallary;
        
        try {
            Client clientById = cliente.getClientById(Integer.parseInt(req.getParameter("id")));
            name = clientById.getName();
            address = clientById.getAddress();
            email = clientById.getEmail();
            sallary = clientById.getSallary();
            resp.setStatus(200);
            responseWriter.write("<HTML>"
                    + " <body>"
                    + " <table style=\"width:100%\">"
                        + "<tr>"
                            + "<th>Nombre</th> <th>Email</th> <th>Direccion</th> <th>Salario</th>"
                        + "</tr>"
                        + "<tr>"
                            + "<th>" + name + "</th> <th>" + email + "</th> <th>" + address + 
                            " </th> <th>" + sallary + "</th>"
                        + "</tr>"
                    + "</table>"
                    + "</body>"
                    + "</HTML>");
            responseWriter.flush();
        } catch (ClientNotFoundException ex) {
            resp.setStatus(400);
            responseWriter.write("No existe informacion acerca del cliente"); 
            responseWriter.flush();
        }   
    }
}
