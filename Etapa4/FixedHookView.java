import java.awt.*;
import java.awt.geom.*;

public class FixedHookView {
   //private final double width;  // fixed point width, arista
   private Color color = Color.GREEN;
   private Rectangle2D.Double shape = null;
   private FixedHook hook;

/* to be coded */
   public FixedHookView(FixedHook h){
      hook = h;
      shape = new Rectangle2D.Double(hook.getPosition()-hook.getArista(),-hook.getArista(), 2*hook.getArista(), 2*hook.getArista());
   }
   
   public boolean contains (double x, double y){ //para saber si esta contenido dentro del marco
      return shape.contains(x,y);
      // to be coded
   }
   public void setSelected (){
      color = Color.RED;
   }
   public void setReleased() {
      color = Color.GREEN;
   }
   void updateView(Graphics2D g) {
      double arista = hook.getArista();
      shape.setFrame(hook.getPosition()-arista, -arista, 2*arista, 2*arista); //shape, para generar formar y dar contorno
      g.setColor(color);
      g.fill(shape);
      g.draw(shape);
   }
   
}