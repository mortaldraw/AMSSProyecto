package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import controles.ControlExtraccion;

public class InterfazCrearSuscripcion extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlCrearSuscripcion ce;
  
  //Es importante observar que todos los metodos definen la operacion GET para
  //que el metodo doGet sea el que se ejecuta al presionar el boton "Enviar". 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
          ce = new ControlCrearSuscripcion();
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<link rel='stylesheet' type='text/css' href='myStyle.css'/>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Seng N Bytes | Crear suscripcion </TITLE>");
    out.println("<h2>Jueces</h2>");
    out.println("<h3>Crear Suscripcion</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarSuscripcion();  
    }else if(operacion.equals("crear")){
       crearSuscripcion();
    } 
  }
  
  public void iniciarSuscripcion(){  
    out.println("<p>Indique su numero de suscriptor</p>");
    out.println("<form method=\"GET\" action=\"Crear\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"renovacion\"/>");
    out.println("<p> ID Suscriptor  <input type=\"text\" name=\"idS\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  

  public void crearSuscripcion(){  
    int idSuscriptor = Integer.parseInt(thisRequest.getParameter("idS").trim());

  
    ce.crearSuscripcion(idSuscriptor);
      out.println("<p>Tu suscripcion ha sido creada con exito</p>");
      out.println("<p>Gracias por registrarte </p>");
      out.println("<p>Te esperamos pronto, sigue leyendo!.</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    
  } 
}
