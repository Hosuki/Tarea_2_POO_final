import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Container;

public class PhysicsLab {
   public static void main(String[] args) {
      PhysicsLab_GUI lab_gui = new PhysicsLab_GUI();
      lab_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //boton de exit para salir
      lab_gui.setVisible(true); //hereda de Jframe
   }
}

class PhysicsLab_GUI extends JFrame {  //Jframe genera la interfaz grafica con loop infinito
   public PhysicsLab_GUI() {
      setTitle("My Small and Nice Physics Laboratory");
      setSize(MyWorldView.WIDTH, MyWorldView.HEIGHT+50);  // height+50 to account for menu height, tamano frame
      MyWorld world = new MyWorld();  //genera word
      MyWorldView  worldView = new MyWorldView(world); //genera view de word
      world.setView(worldView); //metodo de world para relacionarlo con worldview
      add(worldView); //agrega worldView al interfaz
      LabMenuListener menuListener = new LabMenuListener(world);
      setJMenuBar(createLabMenuBar(menuListener));

      //createConfiguration(world);  //genera el mundo como en la tarea 1
      //world.start();
      /*......*/
   }
  /* private void createConfiguration(MyWorld world) {  // Please note how similar it is to "Etapa 4" of T1
      double mass = 1.0;      // 1 [kg] 
      double radius = 0.1;    // 10 [cm] 
      double position = 0.0;  // 1 [m] 
      double speed = 0.5;     // 0.5 [m/s]
      Ball b0 = new Ball(mass, radius, position, speed);
      Ball b1 = new Ball(mass, radius, 2.0, 0);
      world.addElement(b0);
      world.addElement(b1);
   }*/
   public JMenuBar createLabMenuBar(LabMenuListener menu_l) {
      JMenuBar mb = new JMenuBar();
      
      JMenu menu = new JMenu ("Configuration");
      mb.add(menu);
      JMenu subMenu = new JMenu("Insert");  
      menu.add(subMenu);
      
      JMenuItem menuItem = new JMenuItem("Ball");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("Fixed Hook");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("Spring");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("My scenario");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
 /*....*/      
      menu = new JMenu("MyWorld");
      mb.add(menu);
      menuItem = new JMenuItem("Start");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      menuItem = new JMenuItem("Stop");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      subMenu = new JMenu("Simulator");
      menu.add(subMenu);
      menuItem = new JMenuItem("Delta time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("View Refresh time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
/* ...*/
      return mb;          
   } 
}