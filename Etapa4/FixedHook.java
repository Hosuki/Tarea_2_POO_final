import java.util.*;
import java.awt.*;

public class FixedHook extends PhysicsElement implements SpringAttachable,Simulateable{
// to be coded
   private static int id=0;  // FixedHook identification number
   private final double arist;
   private double pos_t;     // current position at time t
   private ArrayList<Spring> springs;  // ArrayList can grow, arrays cannot. 
   private FixedHookView view;

   private FixedHook(){   // nobody can create a block without state
     this(0,0);
   }
   public FixedHook(double arista, double position){
      super(id++);
      this.arist = arista;
      pos_t = position;
      springs = new ArrayList<Spring>();
      view = new FixedHookView(this);

   }
   
   public double getArista() {
      return arist;
   }

   public double getPosition(){
	  return pos_t;
   }
/*   public double getAceleration(Spring Myspring){
	  double aceleration;
	  aceleration = Myspring.getForce(this)/getMass();
	  return (aceleration);
   }
 */  
   public void updateView (Graphics2D g) {   // NEW
     view.updateView(g);  // update this Ball's view in Model-View-Controller design pattern     
   }
   public boolean contains(double x, double y) {
      return view.contains(x,y);
   }
   public void setSelected(){
      view.setSelected();
   }
   public void setReleased(){
      view.setReleased();
   }
   public void dragTo(double x){
      pos_t=x;
   }  
  
   public String getDescription() {
   // to be coded by you
   // FixedHook_0:x    Spring_0:a_end    b_end    Ball_0:x    Ball_1:x    
	return "Fixed_Hook_" + getId() +":x";
   }
   
   public String getState(){
	return getPosition()+"";
   }
   
   public void attachSpring (Spring Myspring){
    springs.add(Myspring);
    }
    
   public void computeNextState(double delta_t, MyWorld w){
   } 
   public void updateState(){
   }
   public void detachSpring (Spring Myspring){
   springs.remove(Myspring);
   } //esta en la interfaz 
   
}