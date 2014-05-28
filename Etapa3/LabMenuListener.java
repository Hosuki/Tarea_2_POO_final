import java.awt.event.*; 
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class LabMenuListener implements ActionListener {
   private MyWorld  world;
   public LabMenuListener (MyWorld  w){
      world = w;
   }
   public void actionPerformed(ActionEvent e) {
      JMenuItem menuItem = (JMenuItem)(e.getSource());
      String text = menuItem.getText();
      
      // Actions associated to main manu options
      if (text.equals("My scenario")) {  // here you define Etapa2's configuration
         double mass = 1.0;      // 1 [kg] 
         double radius = 0.1;    // 10 [cm] 
         double position = 0;  // 0 [m] 
         double speed = 1;     // 0 [m/s]
         double arista = 0.1;
      
         FixedHook f0 = new FixedHook(0.1,0);
         Ball b0 = new Ball(mass, radius, 1.5, 0);
         Spring spring = new Spring(1.0, 1);
         spring.attachAend(f0);
         spring.attachBend(b0);
      
         world.addElement(spring);
         world.addElement(f0);
         world.addElement(b0);
       // to be coded
      }
      if (text.equals("Ball")) {
        // nothing by now       
      }
      if (text.equals("Fixed Hook")) ; // ; same as nothing
      if (text.equals("Spring")) ;

      // Actions associated to MyWorld submenu
      if (text.equals("Start")) world.start() /* to be coded */;
      if (text.equals("Stop"))  world.stop()  /* to be coded */;
      if (text.equals("Delta time")) {
         String data = JOptionPane.showInputDialog("Enter delta t [s]");
         world.setDelta_t(Double.parseDouble(data));
      }
      if (text.equals("View Refresh time")) {
         String data1 = JOptionPane.showInputDialog("Enter View refresh time [s]");
         world.setRefreshPeriod (Double.parseDouble(data1));
         // to be coded
      }
   }
}