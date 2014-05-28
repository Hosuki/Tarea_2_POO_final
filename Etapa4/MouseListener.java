import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class MouseListener extends MouseAdapter {
   private MyWorld world;
   private PhysicsElement currentElement;
   private Timer passingTime;   // NEW

   public MouseListener (MyWorld w){
      world = w;
   } 
   public void mouseMoved(MouseEvent e) { //se invoca cuando el mouse se mueve sobre un componente, pero no hay botones de haber sido empujado (selecciona arriba y cambia de color el objeto)
      Point2D.Double p = new Point2D.Double(0,0); // Change mouse coordenates from //p es la posicion del mouse
      MyWorldView.SPACE_INVERSE_TRANSFORM.transform(e.getPoint(),p);// pixels to meters.  
      PhysicsElement newElement = world.find(p.getX());  //pregunta si en la posicion del mouse hay un objeto contenido y lo retorna
      if (newElement == currentElement) return;
      if (currentElement != null) { //si hay elementos antiguos en myworld
         currentElement.setReleased();  //los deja de color normal
         currentElement = null; //y lo vacia
      }
      if (newElement != null) {  //si hay un elemento contenido 
         currentElement = newElement; //lo asigna a currentElement
         currentElement.setSelected(); //le otorga el color rojo
      }
      world.repaintView();
   }
   
   
   public void mouseDragged(MouseEvent e) { //se invoca cuando se presiona el boton sobre un objeto y lo arrastro
	     if (currentElement == null) return;
	    	  Point2D.Double p = new Point2D.Double(0,0); // Change mouse coordenates from //p posicion del mouse
		      MyWorldView.SPACE_INVERSE_TRANSFORM.transform(e.getPoint(),p);// pixels to meters.
		      currentElement.dragTo(p.getX());
            world.repaintView();  
	      
	}
   public void mouseReleased(MouseEvent e) { //se invoca cuando se suelta el mouse del componente
      if (currentElement == null) return;
      if (currentElement instanceof Spring) {
         Point2D.Double p= new Point2D.Double(0,0);
         MyWorldView.SPACE_INVERSE_TRANSFORM.transform(e.getPoint(),p);

          // we dragged a spring, so we look for and attachable element near by  
         SpringAttachable element0 = world.findAttachableElement(p.getX()-0.5); //es bola o resorte
         SpringAttachable element1 = world.findAttachableElement(p.getX()+0.5); //es bola o resorte
         if (element0 != null || element1 != null) {
            // we dragged a spring and it is near an attachable element,
            // so we hook it to a spring end.   
            Spring spring = (Spring) currentElement;
            if (element0 != null){
             double a=spring.getAendPosition();
                if (a==(p.getX()-0.5))
                   spring.attachAend(element0);
            }
            if(element1 != null){
             double b=spring.getBendPosition();
                if (b==(p.getX()+0.5))
                   spring.attachBend(element1);
            }
          }  
      }    
      currentElement.setReleased();
      currentElement = null;
      world.repaintView();
   }
   
   public void mouseClicked(MouseEvent e) //se invoca cuando se clickea el mosue, yo modique
   {
         Point2D.Double p= new Point2D.Double(0,0);
         MyWorldView.SPACE_INVERSE_TRANSFORM.transform(e.getPoint(),p);
	      currentElement = world.find(p.getX());
   }
}