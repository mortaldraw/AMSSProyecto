package controles;
import entidades.Suscriptor;

public class ControlCancelarSuscripcion {
   Suscriptor s1;

   public ControlCancelarSuscripcion(){
     s1 = new Suscriptor(); //Asume que la instancia persiste durante la sesion
   }
   
  //NO SABEMOS SI OCUPAMOS UN ID DEL CLIENTE PARA SABER DE QUIEN ES LA SUSCRIPCION
  
   public void cancelarSuscripcion(int idSuscriptor){
       s1.cancelarSuscripcion(idSuscriptor);

   }
   
  
}
