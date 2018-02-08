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
        String name;
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("identificacion"));
        if(optName.isPresent() && !optName.get().isEmpty()){
            name = "" + optName.get();
        }else{
            name = "";
        }
        int id = Integer.parseInt(optName.get());
        DataSourceStub cliente = DataSourceStub.getInstance();
        try {
            final Client clientById = cliente.getClientById(id);
            responseWriter.write(clientById.getAddress());
            responseWriter.write(clientById.getEmail());
            responseWriter.write(clientById.getName());
            responseWriter.write(clientById.getSallary());
        } catch (ClientNotFoundException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        responseWriter.flush();
    }
    
    
    
}
