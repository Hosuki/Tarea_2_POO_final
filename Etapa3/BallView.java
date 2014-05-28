import java.awt.*;
import java.awt.geom.*;

public class BallView {
   private Color color = Color.BLUE;
   private Ellipse2D.Double shape = null;
   private Ball ball;
   
   public BallView (Ball b){ //constructor de Ballview
      ball = b;
      shape = new Ellipse2D.Double(ball.getPosition()-ball.getRadius(),-ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());
      // to be coded //se entrega respecto del rectangulo que enmarca(pos x inferior, pos y inferior, anchura, alto) 
   }
   
   public boolean contains (double x, double y){ //para saber si esta contenido dentro del marco
      return shape.contains(x,y);
      // to be coded
   }
   public void setSelected (){
      color = Color.RED;
   }
   public void setReleased() {
      color = Color.BLUE;
   }
   void updateView(Graphics2D g) {
      double radius = ball.getRadius();
      shape.setFrame(ball.getPosition()-radius, -radius, 2*radius, 2*radius); //shape, para generar formar y dar contorno
      g.setColor(color);
      g.fill(shape);
      g.draw(shape);
   }
}