
package spoty9;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Spoty9 {

    public static void main(String[] args) {
//        
        try{
            
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
           UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        
        
        
        
       frame fra = new frame(); 
       frame.panel.repaint();
       frame.panel.updateUI();
       
       
    }   
}



//----------------------------------
class frame {
    
    
    
    static Array2 topcanciones;
    static Array2 topcalbums ;
    static Array2 topcartistas ;
    
    static Array2 csuma;
    static Array2 alsuma;
    static Array2 artsuma;
    
    
    
    static int segundalista=0;
    
    
    Graphiz grafica ;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    static Array ruta ;
//    static Array rArtista ;
//    static Array rAlbum ;
//    static Array rCancion ;
    
    
    
    
    
    static Array2 ruta ;
    static Array2 rArtista ;
    static Array2 rAlbum ;
    static Array2 rCancion ;
    
    static int tiporeproduce =-9;
    static Pila pilaG=null;    
     static Cola ColaG=null;    
     static NCircular CircuG=null;    
     static Circular Cradio=null;
    
     
    static  Tops top;
     
     static int selec=0;
     
     
    
JFrame frame;
static JPanel panel;
JTextField caja1;
static String rutatxt;
static JButton boton;
static JComboBox combox;
JButton boton2,boton0,boton3,detiene ;


static JButton newlist;
static JButton removelist;
static JButton radio;
static JButton biblioteca,tops;


NuevaListaReproduccion nuevalista ;



abre abr= new abre();

static Reproduce hilo=null;


Radio radios ;

static int press=0;
static int continua=0;

    static int contador1=0;
      static  int contador2=0;
        
JLabel texto;
static JButton Bgrafica;

//    static llena llen ;

    public frame(){
        
        grafica = new Graphiz();
//        Array2 ara = new Array2(30);
//        
//        for(int i=1;i<30;i++){
//        
//        ara.Add(i, i);
//     
//        }
//        System.out.println("/////////////");
//        for(int i=1;i<30;i++){
//        
//            System.out.println("sale orden indice for "+i+" con: "+ara.Val(i));
//     
//        }
        
        
        top = new Tops();
    
//        Array2 ax =  new Array2(30);
//        for(int i=1;i<30;i++){
//        
//        System.out.println(" array pruea "+ax.Val(i));
//     
//    }
        
        
        
        
        Cradio= new Circular();
        
        ruta = new Array2(30);
        rArtista = new Array2(30);
        rAlbum = new Array2(30);
        rCancion = new Array2(30);
        
        
        radios = new Radio();
    componentes();
    nuevalista = new NuevaListaReproduccion();
    addbotonList();
    removebotonList();
    
    radio();
    biblioteca();
    combobox();
     hilosigui();
    //hilov as = new hilov();
    //as.veri.start();
    }
    
    private void hilosigui(){
    Thread sigui = new Thread(){
        @Override
        public void run() {
            try{
            
        while(true){
            
            
            if(hilo!=null){
            
            
            
            
            if((continua==1)&&(hilo.isAlive()==false)){
             
                
                System.out.println(" valor de reproduce en bobon asdfasd "+tiporeproduce);
                        if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        
                        
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.next;
                        seleccion2();
                        
                        }
                continua=1;
                press=1;
                boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                //frame.continua=0;
            }else{
            
            }
            //frame.as.hilo.isAlive();
            
            }else if((hilo==null)&&(continua==1)){
            
                
                 if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        
                        
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.next;
                        seleccion2();
                        
                        }
                continua=1;
                press=1;
                boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                
                
                
            
            }else{
            
            
            
            }
        
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
               
            }
        }
        
            }catch(Exception sdfs){
            
            }
        
        
    }

        };
        
        sigui.start();
    
    }
    
    
    
    
    
    public frame(int nada){
    
    
        
    }
  
    
    private void componentes(){
    frame = new JFrame("Spoty9");
    frame.setBounds(520, 150, 360, 399);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    
    
    panel = new JPanel();
    panel.setLayout(null);
    frame.add(panel);
   
    boton = new JButton();
    boton.setBounds(75, 300, 55, 55);
    boton.setBorder(null);
    boton.setHorizontalAlignment(JButton.CENTER);
    boton.setVerticalAlignment(JButton.CENTER);
    boton.setContentAreaFilled( false );
    boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
    listenerboton();
    
    
    
    
 
    
    boton2 = new JButton();
    boton2.setBounds(125, 300, 55, 55);
    boton2.setBorder(null);
    boton2.setHorizontalAlignment(JButton.CENTER);
    boton2.setVerticalAlignment(JButton.CENTER);
    boton2.setContentAreaFilled( false );
    listenerboton2();
    
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/spoty9/next.png"));
    int ancho = 46; 
    int alto = 50; 
    boton2.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
    
    
    JLabel imagen = new JLabel();
    imagen.setBounds(25, 90, 180, 180);
    imagen.setHorizontalAlignment(JLabel.CENTER);
    imagen.setVerticalAlignment(JLabel.CENTER);
    ImageIcon iconoOriginal8 = new ImageIcon(getClass().getResource("/spoty9/cor.png"));
    int ancho5 = 180; 
    int alto5 = 180; 
    imagen.setIcon(new ImageIcon(iconoOriginal8.getImage().getScaledInstance(ancho5, alto5, java.awt.Image.SCALE_DEFAULT)));
    
    
    
    
    texto= new JLabel("Cancion");
    texto.setBounds(25, 275, 250, 20);
    
    
    
    
    
    boton0 = new JButton();
    boton0.setBounds(25, 302, 55, 55);
    boton0.setBorder(null);
    boton0.setHorizontalAlignment(JButton.CENTER);
    boton0.setVerticalAlignment(JButton.CENTER);
    boton0.setContentAreaFilled( false );
    
    ImageIcon foto = new ImageIcon(getClass().getResource("/spoty9/next2.png"));
    int ancho2 = 46; 
    int alto2 = 50; 
    boton0.setIcon(new ImageIcon(foto.getImage().getScaledInstance(ancho2, alto2, java.awt.Image.SCALE_DEFAULT)));
    listenerboton0();
    
    
    detiene = new JButton();
    detiene.setBounds(190, 302, 50, 50);
    detiene.setContentAreaFilled( false );
    detiene();
    
    
    boton3 = new JButton("Cargar Txt");
    boton3.setBounds(239, 20, 100, 30);
    boton3.setContentAreaFilled( false );
    listenerboton3();
    
    Tops();
    
    
    Bgrafica  = new JButton("Grafica");
    Bgrafica.setBounds(239, 250, 100, 30);
    Bgrafica.setContentAreaFilled( false );
    Bgrafica.setEnabled(false);
    BotonGra();
    panel.add(imagen);
    panel.add(boton0);
    panel.add(boton);
    panel.add(boton2);
    panel.add(boton3);
    panel.add(detiene);
    panel.add(Bgrafica);
    boton.setVisible(true);
    
    
    
    
        panel.add(texto);
     panel.setVisible(true);
     
     
    panel.repaint();
    
    }


    
    private void listenerboton(){
    boton.addActionListener(new ActionListener(){
    
        @Override
    public void actionPerformed(ActionEvent e) {
       
       
      
        if(selec==1){
            
            
            
            
            if(press==0){
                System.out.println(" paso con press 0");
            boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            press=1;
            
                    if(hilo==null){
                        
                        System.out.println(" valor de reproduce en bobon asdfasd "+tiporeproduce);
                        if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                        seleccion2();
                        
                        }
                        continua=1;
                    
                    
                    }else{
                    
                    
                    hilo.resume();
                    
                    
                    }
            
            }else if(press==1){
                System.out.println("paso con press 1");
            boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
                press=0;
                
                if(hilo==null){
                
                
                }else{
                
                hilo.suspend();
                }
                continua=0;
                
            }else{
            
            }
        
        }else{
        
        }
            
     
    }
    
    });
    }
    
    
    
    private void listenerboton2(){
    boton2.addActionListener(new ActionListener(){
    
        @Override
    public void actionPerformed(ActionEvent e) {
        try{
            
            if(hilo==null){
                
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                            
                            CircuG=CircuG.next;
                        seleccion2();
                        
                        }
            
            
            }else{
            
            if(hilo.isAlive()){
                
                hilo.stop();
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.next;
                        seleccion2();
                        
                        }
                
                boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                
              
                
                
        }else{
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.next;
                        seleccion2();
                        
                        }
       
           
            
        }
            
            
            }
            boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            press=1;
            continua=1;
        }catch(Exception xs){
            System.out.println(" el hilo no existe o esta detenido");
        }
        
            
            
        
        
        
    }
    });
    }
    
    
    private void listenerboton0(){
    boton0.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try{
                
                
                if(hilo==null){
                
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                            CircuG=CircuG.ant;
                        seleccion2();
                        //
                        }
                
                }else{
            
            if(hilo.isAlive()){
                
                hilo.stop();
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.ant;
                        seleccion2();
                        
                        }
                
                boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                
              
                
                
        }else{
                
                if(tiporeproduce==0){
                        
                        seleccion0();
                        
                        }else if(tiporeproduce==1){
                        
                        seleccion1();
                        }else if(tiporeproduce==2){
                        CircuG=CircuG.ant;
                        seleccion2();
                        
                        }
       
           
            
        }
         
            
            
                }
            boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            press=1;
            continua=1;
        }catch(Exception xs){
            System.out.println(" el hilo no existe o esta detenido");
        }
            
        }
    
    });
    
    }
    
    
    private void detiene(){
      
    detiene.setBorder(null);
    detiene.setHorizontalAlignment(JButton.CENTER);
    detiene.setVerticalAlignment(JButton.CENTER);
    detiene.setContentAreaFilled( false );
    
    
    ImageIcon iconoOriginal5 = new ImageIcon(getClass().getResource("/spoty9/cuadro.png"));
    int ancho = 25; 
    int alto = 25; 
    detiene.setIcon(new ImageIcon(iconoOriginal5.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        
        
        
        
        
    detiene.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           
            if(hilo==null){
        press=0;
        boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
        
        }else{
                //hilo.isInterrupted();
        hilo.stop();
        hilo=null;
        
        
        
        
        boton.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
        }
            press=0;
            continua=0;            
        }
    });
        
        
        
        
    
    }
    
    
    
    private void listenerboton3(){
    boton3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            rutatxt = JOptionPane.showInputDialog("Ingrese la ruta:");
            System.out.println(rutatxt);
            

            
            
            
            try {
            abr.lee();
           // temp=lista.primero;
            } catch (Exception ex) {
            System.out.println("error fatal abrir archivo");
            
            }
            
            
        }
    
    
    });
    
    }
    
    
    
    
    
    private void addbotonList(){
    newlist = new JButton("Nueva lista");
    newlist.setBounds(239, 60, 100, 30);
    newlist.setContentAreaFilled( false );
    panel.add(newlist);
    newlist.setVisible(true);
    newlist.setEnabled(false);
    
    
    newlist.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e) {
            nuevalista.consulta2();
            nuevalista.nuevo.setVisible(true);
            //nuevalista.ventana2.setVisible(true);
            
            
        }
    });
    
    
    
    
    }
    
    private void removebotonList(){
    removelist = new JButton("Elimina");
    removelist.setBounds(239, 100, 100, 30);
    removelist.setContentAreaFilled( false );
    removelist.setEnabled(false);
    panel.add(removelist);
    removelist.setVisible(true);
    panel.repaint();
    removelist.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
         EliminarListas elimina = new EliminarListas();
         elimina.nuevo.setVisible(true);
        }
    });
    
    
    }
    
    
    private void Tops(){
    tops= new JButton("Reportes");
    tops.setBounds(239, 140, 100, 30);
    tops.setContentAreaFilled( false );
    //tops.setEnabled(false);
    tops.setEnabled(false);
    
    tops.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
       top.nuevo.setVisible(true);   
        }
    
    });
    panel.add(tops);
    panel.repaint();
    }
    
    
    private void combobox(){
    combox = new JComboBox();
    
    combox.setBounds(239, 310, 100, 26);
    combox.addItem("--------");
    combox.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            consultaseleccion();
             if(tiporeproduce==0){
                        
                        boton0.setEnabled(false);
                        
           }else if(tiporeproduce==1){
                        boton0.setEnabled(false);
                        
           }else if(tiporeproduce==2){
                       boton2.setEnabled(true);
                       boton0.setEnabled(true);
         }
        }
    
    });
    //combox.setBorder(border);
    
    panel.add(combox);
    combox.setVisible(true);
    
    
    panel.repaint();
    }
    
    
    
    
    private void radio(){
    radio = new JButton("Radio");
    radio.setBounds(10, 10, 100, 30);
    radio.setContentAreaFilled( false );
    radio.setEnabled(false);
    panel.add(radio);
    
    radio.setVisible(true);
    
    panel.repaint();
    radio.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            continua=0;
            radios.nuevo.setVisible(true);
            
        }
    });
    
    
    
    }
    
   
    
    
    
    private void biblioteca(){
    biblioteca = new JButton("Biblioteca");
    biblioteca.setBounds(10, 50, 100, 30);
    biblioteca.setContentAreaFilled( false );
    biblioteca.setEnabled(false);
    panel.add(biblioteca);
    biblioteca.setVisible(true);
    
    panel.repaint();
    biblioteca.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            Biblioteca biblio = new Biblioteca();
            biblio.nuevo.setVisible(true);
            
        }
    });
    
    }
    
    
    
        
    
    
    
    private void consultaseleccion(){
   String seleccion = (String) combox.getSelectedItem();
       System.out.println(" entro a buscar la lista n consultaseleccion "+seleccion);
   
   if((seleccion==null)|| seleccion.trim().equals("")){
   
   
   }else{
   
    Object retorno = buscaL(seleccion);
    
    
    if(retorno==null){
        System.out.println("no se hallo la lista++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }else{
        selec=1;
        System.out.println(" tipo reproduce en asdfas "+tiporeproduce);
        System.out.println(" se hallo la cancion----++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        
        switch (tiporeproduce) {
            case 0:
                Pila pil = (Pila)retorno;
                
                Pila copia=null;
   
       try {
           copia = (Pila) pil.clone();
       } catch (CloneNotSupportedException ex) {
           Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
       }
                
       pilaG= copia;
       System.out.println("valor de pila copia 959595959595959595 "+pilaG.Nombre);
       break;
            case 1:
                Cola cola = (Cola)retorno;
                Cola copia2=null;
       try {
           copia2 = (Cola)cola.clone();
       } catch (CloneNotSupportedException ex) {
           Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
       }
       ColaG=copia2;
   
                
                break;
            case 2:
                NCircular circular = (NCircular)retorno;
                NCircular copia3=null;
                
   
       try {
           copia3= (NCircular)circular.clone();
       } catch (CloneNotSupportedException ex) {
           Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       CircuG=copia3;
                
                
                break;
            default:
                
                
                System.out.println(" nose encontro");
                break;
        }
   
   
    }
   }
        
   
   }
    
    
    
     private Object buscaL(String Nombre){
         
         tiporeproduce=-9;
        System.out.println("inicia buscaeliminar +++++++++++++++++++++++++++++++++-------------------------------------------");
        int contador =0;
        
        Pila pil=null;
        Cola col =null;
        NCircular cir =null;
        
        
        int es=-9;
        
        boolean bandera = false;
        
        int conta =0;
        
       
        Object envi=null;
        
        
        
        while(!bandera){
            
            
            
            
            Object temp =NuevaListaReproduccion.Listas.Val(contador);
            es=-9;
            
            
            
            if(conta>=30){
            bandera=true;
            }else{
            }
            
            if(temp==null){
           
            
            break;
            }else{
            }
            
            
            
            
            try{
           
            pil = (Pila)temp;
            es=0;
            tiporeproduce=0;
            Array asdf =(Array)pil.peek();
           
                System.out.println(" es pila+++++----++++");
            }catch(Exception as1){

            }
            
            
        
        try{
        col = (Cola)temp;
        es=1;
        
        
        if(col.Nombre=="hla"){
        
        }else{
        
        }
        System.out.println(" es cola-------------------------+++++++++++++++++++++++++++-"+col.Nombre);
        tiporeproduce=1;
        }catch(Exception a1xa){
        }
        System.out.println("paso con 222 /"+es);
        
        
        
        try{
        cir = (NCircular)temp;
        es=2;
        tiporeproduce=2;
        if(cir.Nombre=="hola"){
        }else{
        }
        System.out.println(" es circu-------------------------++++++++++++++++++++++++++++++-"+cir.valor);
        System.out.println(" es circu-------------------------++++++++++++++++++++++++++++++-"+cir.next);
        tiporeproduce=2;
        }catch(Exception a1w){
        }
            
            
            System.out.println(" paso 3333 /"+es);
        System.out.println(" paso 3333 /"+tiporeproduce);
       
            
            switch (es) {
                
                case 0:
                    
                    if(pil.Nombre.equals(Nombre)){
                        
                        envi = pil;
                        bandera=true;
                      }else{
                        
                    
                    }
                    
                    break;
                case 1:
                    
                   if(col.Nombre.equals(Nombre)){
                    
                    envi = col;
                    
                          bandera=true;
                        
                      }else{
                        
                    
                    }
                    
                    break;
                case 2:
                    
                   
                    if(cir.Nombre.equals(Nombre)){
                        
                        
                        envi = cir;
                         
                         bandera=true;
                        
                      }else{
                        
                    }
                    
                    
                    
                    
                    break;
                default:
                    
                    
                    break;
            }
        
        if(contador>30){
        bandera=true;
        
        }
        contador++;
        
        }
        
    return envi;
    }
    
    private String Bcancion(String Artista,String Album,String Cancion ){
        
        String rutax=null;
//        
//    static Array ruta ;
//    static Array rArtista ;
//    static Array rAlbum ;
//    static Array rCancion ;
    
    for(int i=0;i<30;i++){
        System.out.println("trae para revisar "+Artista );
        System.out.println("trae para revisar "+Album );
        System.out.println("trae para revisar "+Cancion );
        
        
        
        if((rArtista.Val(i).equals(Artista))&&(rAlbum.Val(i).equals(Album))&&(rCancion.Val(i)).equals(Cancion)){
           
            rutax = (String)ruta.Val(i);
            
            System.out.println("valor artista en guardado Array"+rArtista.Val(i));
        System.out.println("valor artista en guardado Array"+rAlbum.Val(i));
        System.out.println("valor artista en guardado Array"+rCancion.Val(i));
            
            break;
            
        }else{
         System.out.println("valor artista en guardado Array"+rArtista.Val(i));
        System.out.println("valor artista en guardado Array"+rAlbum.Val(i));
        System.out.println("valor artista en guardado Array"+rCancion.Val(i));
        
        
        }

    }
        return rutax;
    
    
    }
    
    
    public static  void agregacancion(String ncancion){
    
        int contador=0;
        int bandera =0;
        
        topcanciones = new Array2(30);
        for(int i=0;i<30;i++){
            System.out.println(" valor de topcanciones "+topcanciones);
            
            System.out.println("valor primera casill array "+topcanciones.Val(i));
            
       if(topcanciones.Val(i)==null){
           
           topcanciones.Add(ncancion, 0);
           contador++;
       }else{
       }
       }
        
        if(contador==29){
        
            topcanciones.Add(ncancion, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(topcanciones.Val(i)==null){
        
        
        }else{
            
            if(topcanciones.Val(i)==ncancion){
            
            bandera=1;
            }else{
            
            
            }
            
        
        }
            
        }
        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(topcanciones.Val(i)==null){
            
            topcanciones.Add(ncancion, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
    
    public static  void agregaalbum(String nalbum){
    
        int contador=0;
        int bandera =0;
        
        
        for(int i=0;i<30;i++){
        
       if(topcalbums.Val(i)==null){
           
           topcalbums.Add(nalbum, 0);
           contador++;
       }else{
       }
       }
        
        if(contador==29){
        
            topcalbums.Add(nalbum, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(topcalbums.Val(i)==null){
        
        
        }else{
            
            if(topcalbums.Val(i)==nalbum){
            
            bandera=1;
            }else{
            
            
            }
            
        
        }
            
        }
        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(topcalbums.Val(i)==null){
            
            topcalbums.Add(nalbum, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
   
    
    public static  void agregaartista(String nartista){
    
        int contador=0;
        int bandera =0;
        
        
        for(int i=0;i<30;i++){
        
       if(topcartistas.Val(i)==null){
           
           topcartistas.Add(nartista, 0);
           contador++;
       }else{
       }
       }
        
        if(contador==29){
        
            topcartistas.Add(nartista, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(topcartistas.Val(i)==null){
        
        
        }else{
            
            if(topcartistas.Val(i)==nartista){
            
            bandera=1;
            }else{
            
            
            }
            
        
        }
            
        }
        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(topcartistas.Val(i)==null){
            
            topcartistas.Add(nartista, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
    
    
    
    
    
    
    private  void seleccion0(){
        Array2 sacap = null;
    try{
                    //declara global para next
                    sacap = (Array2) pilaG.pop();
                               
                                
                               if(sacap==null){
                               }else{
                                hilo = new Reproduce();
                                
                                
                                
                                
                                   String asdfss = Bcancion((String)sacap.Val(0),(String)sacap.Val(1),(String)sacap.Val(2));
                                   texto.setText("/"+(String)sacap.Val(2)+"/"+(String)sacap.Val(1)+"/"+(String)sacap.Val(0) );
                                   
                                    System.out.println(" valor que tiene pila"+asdfss+"----------------------------------s////////////////////////////");
                                    hilo.repro(asdfss);
                                 
                                 top.aumento((String)sacap.Val(0), "Artista");
                                   top.aumento((String)sacap.Val(1), "Album");
                                   top.aumento((String)sacap.Val(2), "Cancion");
                                
                                
                       hilo.start();
                       tops.setEnabled(true);
                        }
                               }catch(Exception sds){
                                  
                                   hilo=null;
                                   
                                System.out.println("die error");
                                }
   
    }
    
    private void seleccion1(){
    
        try{
                    Array2 sacac = null;//declara global para next
                    sacac = (Array2) ColaG.Pop();
                               
                                
                               if(sacac==null){
                               }else{
                                hilo = new Reproduce();
                                
                                   String asdfss = Bcancion((String)sacac.Val(0),(String)sacac.Val(1),(String)sacac.Val(2));
                                    System.out.println(" valor que tiene Cola Repro"+asdfss+"----------------------------------s////////////////////////////");
                                    hilo.repro(asdfss);
                                    texto.setText("/"+(String)sacac.Val(2)+"/"+(String)sacac.Val(1)+"/"+(String)sacac.Val(0) );
                                    top.aumento((String)sacac.Val(0), "Artista");
                                   top.aumento((String)sacac.Val(1), "Album");
                                   top.aumento((String)sacac.Val(2), "Cancion");
                                    
                                   
                                 
                                
                       hilo.start();
                       tops.setEnabled(true);
                        }
                               }catch(Exception sds){
                                System.out.println("die error");
                                }
    
    }
    
    
    private void seleccion2(){
        
        
        
        try{
                    Array2 sacaCIr = null;//declara global para next
                    sacaCIr = (Array2) CircuG.valor;
                               
                                
                               if(sacaCIr==null){
                               }else{
                                hilo = new Reproduce();
                                
                                   String asdfss = Bcancion((String)sacaCIr.Val(0),(String)sacaCIr.Val(1),(String)sacaCIr.Val(2));
                                    System.out.println(" valor que tiene Cola Repro"+asdfss+"----------------------------------s////////////////////////////");
                                    hilo.repro(asdfss);
                                    texto.setText("/"+(String)sacaCIr.Val(2)+"/"+(String)sacaCIr.Val(1)+"/"+(String)sacaCIr.Val(0) );
                                    top.aumento((String)sacaCIr.Val(0), "Artista");
                                   top.aumento((String)sacaCIr.Val(1), "Album");
                                   top.aumento((String)sacaCIr.Val(2), "Cancion");
                                    
                                    
                                
                                
                       hilo.start();
                       tops.setEnabled(true);
                        }
                               }catch(Exception sds){
                                System.out.println("die error");
                                }
    
    
    }
    
    private void BotonGra(){
        Bgrafica.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                System.out.println("ejejcuta aevente");
                try {
            grafica.Inicia(rCancion, "Simple", "Simple");
            grafica.Inicia(rAlbum, "Doble", "Doble");
            grafica.Inicia(rArtista, "DCircular", "DCircular");
            
            
//            DCircular
//        Doble
//            Simple
            
            grafica.Abre("Simple");
            grafica.Abre("Doble");
            grafica.Abre("DCircular");
            
        } catch (IOException ex) {
            System.out.println("error");
            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                
                
            }
        
        });
        
    
    }
    
    
    
    
    }//fin frame++++++++++++
    
    



//
//class hilov implements Runnable{
//    
//    Thread veri;
//    
//    hilov(){
//    veri= new Thread(this);
//    
//    }
//
//    @Override
//    public void run() {
//        while(true){
//            
//            if((frame.continua==1)&&(frame.hilo.isAlive()==false)){
//             
//                
//                System.out.println(" valor de reproduce en bobon asdfasd "+frame.tiporeproduce);
//                        if(frame.tiporeproduce==0){
//                        
//                        seleccion0();
//                        
//                        }else if(tiporeproduce==1){
//                        
//                        seleccion1();
//                        
//                        
//                        }else if(frame.tiporeproduce==2){
//                        
//                        seleccion2();
//                        
//                        }
//                frame.continua=1;
//                frame.press=1;
//                frame.boton.setIcon(new ImageIcon("C:\\Users\\KRUIZ9\\Desktop\\New folder\\pause.png"));
//                //frame.continua=0;
//            }else{
//            
//            }
//            //frame.as.hilo.isAlive();
//            
//            
//        
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException ex) {
//               
//            }
//        }
//        
//    }
//
//    
//}


//----------------------------------
//
//
//class ReproductorMp3 implements Runnable{
//
//   static boolean pausa = false;
//   Player pl;
//   static Thread hilo;
//   String reproduce;
//   
//   
//   ReproductorMp3(){
//   
//   reproduce=null;
//   
//   hilo = new Thread(this);
//   //nose();
//   
//   }
//
//   
//   public void nose(){
//       System.out.println("aaaaaaaaaa");
//       System.out.println("valor que tre "+reproduce);
//       System.out.println("bbbbbbbbbbb");
//       try{
//      pl = new Player(new FileInputStream("C:\\Proyecto2\\Sugerencias\\can1.mp3"));
//      
//            //"C:\\Proyecto2\\Sugerencias\\condor.mp3"));
//           //tiempo(new File("C:\\Proyecto2\\Sugerencias\\condor.mp3"));
//      
//      
//      
//      System.out.println("pausado");
//      //Thread.sleep(500);
//      pausa = false;
//      
//      
//       }catch(Exception x){
//           System.out.println(" ERROR FATAL PARA ABRIR ");
//           //frame.boton.setIcon(new ImageIcon("C:\\Users\\KRUIZ9\\Desktop\\New folder\\play.png"));
//       }
//   }
//
//    @Override
//    public void run() {
//            try {
//               while (true) {
//                   System.out.println(" aasdfasdfasdfasdfasdfasdfasds");
//                  if (!pausa) {
//                     if (!pl.play(1)) {
//                        break;
//                     }
//                  }
//               }
//            } catch (JavaLayerException e) {
//               e.printStackTrace();
//                System.out.println(" adsfadf asdf;laksjf ;alkfj as");
//            }
//         }
//
//    
//    
//}

//----------------------------------


    class abre{
        String linea;
        String [] lineas;
        
        
        int contaruta =0;
        
        
        int contador=1;
        static String [] temp;
        
        
        //-----------Listas que guardan
        static ListaArtista Lartista;
        static LAlbum Lalbum;
        static Lcancion Lcancions;
        //----------finasdfasdf
        
        public abre(){
        Lartista = new ListaArtista();
        Lalbum = new LAlbum();
        Lcancions = new Lcancion();
        
        
        
        
            
        
        linea=null;
        }
        
        
        public void lee(){
            
       
            
            
            
         
        try{
        FileReader file = new FileReader(frame.rutatxt);
        //FileReader file = new FileReader("C:\\Users\\KRUIZ9\\Desktop\\New folder\\texto.txt");
         BufferedReader abre = new BufferedReader(file);
         
       
        
        
        while((linea=abre.readLine())!=null){
        lineas =linea.split("");
        separa();    

        }
        
        
        
        
        
        
        
        
        
        if(Lcancions.ultimo==null){
        
        }else{
            frame.contador2=frame.contador1;
        frame.newlist.setEnabled(true);
        frame.radio.setEnabled(true);
        frame.biblioteca.setEnabled(true);
        frame.Bgrafica.setEnabled(true);
        //frame.removelist.setEnabled(true);
        System.out.println("adfasdf "+Lcancions.ultimo.siguiente.cancion);
        }
        
        
        
        
        }catch(Exception b){
            System.out.println(" erro al encontrar la ruta");
            //System.out.println("adfas///df "+Lartista.ultimo.artista);
        
            
            
        }
        
        }
        
        
        public void separa(){
            
            temp= new String[6];
            
            String conca="";
            int carray=0;
            contador=0;
            
            while(contador<=lineas.length-1){
            
                if(lineas[contador].equals("_")){
                temp[carray]=conca;
                conca="";
                carray++;
                    
                }else if(contador==(lineas.length-1)){
                conca=conca+lineas[contador];    
                temp[carray]=conca;
                conca="";
                carray++;
                    
                }else{
                conca=conca+lineas[contador];
                    //System.out.println("valor que entra nosf "+lineas[contador]);
                    //System.out.println("conca ú "+conca);
                }
                
            
            
            contador++;
            }//zd;flzksdjf;zlsdkfjz;sldkf componer******************************
            // este usaba list.Nuevo(temp[0],temp[2],temp[3],temp[4],temp[5]);
            //  list.imprimir();
            
            
            if(frame.contador2==0){
            Lartista.AgregaArtista(temp[0]);
            Lalbum.insertarInicio(temp[1]);
            Lcancions.insertarInicio(temp[2]);
            
            frame.ruta.Add(temp[3], contaruta);
            frame.rArtista.Add(temp[0], contaruta);
            frame.rAlbum.Add(temp[1], contaruta);
            frame.rCancion.Add(temp[2], contaruta);
            
            
//            frame.agregacancion(temp[1]);
//            frame.agregacancion(temp[2]);
            
//            frame.llen.agregacancion(temp[0]);
//            frame.llen.agregaalbum(temp[1]);
//            frame.llen.agregaartista(temp[2]);
            
            frame.top.agregacancion(temp[2]);
            frame.top.agregaalbum(temp[1]);
            frame.top.agregaartista(temp[0]);
            
//            
            for(int i=0;i<30;i++){
                
                System.out.println(" canciones "+frame.top.tc.Val(i));
                System.out.println(" albumes "+frame.top.tal.Val(i));
                System.out.println(" topcartistas "+frame.top.tar.Val(i));
             }
//            
            

            Array2 circuradio =new Array2(3);
            
            
            
            
            circuradio.Add(temp[0], 0);
            circuradio.Add(temp[1], 1);
            circuradio.Add(temp[2], 2);
            
            frame.Cradio.Agrega(circuradio);
            
        
            
            System.out.println("saca de contaruta "+frame.ruta.Val(contaruta));
            contaruta++;
            System.out.println("adfasdf "+Lartista.ultimo.artista);
            System.out.println("adfasdf "+Lalbum.ultimo.album);
            System.out.println("adfasdf "+Lcancions.ultimo.cancion);
            
            //System.out.println("valor matri");
//            for(int i=0;i<=temp.length-1;i++){
//            System.out.println("saca "+temp[i]);
//
//            }

            System.out.println("");
            System.out.println("");
            
            
            frame.contador1++;
            }else{
                if(contaruta==0){
                contaruta=frame.contador1+1;
                }else{
                
                
                }
            frame.segundalista=1;
            
            frame.ruta.Add(temp[3], contaruta);
            frame.rArtista.Add(temp[0], contaruta);
            frame.rAlbum.Add(temp[1], contaruta);
            frame.rCancion.Add(temp[2], contaruta);
                System.out.println("ingreso nuva listas asd;lfkajsdf;lkajsdf;lkajdsf");
             System.out.println("ingreso nuva listas asd;lfkajsdf;lkajsdf;lkajdsf");
              System.out.println("ingreso nuva listas asd;lfkajsdf;lkajsdf;lkajdsf");
            contaruta++;
            }
            
            
            
        
        }
        
        

    }


//----------------------------------


 class Reproduce extends Thread {

     String ruta;
     Player pl ;
     
   public Reproduce(){
     ruta = null;   
   }
     
   
   @Override
   public void run(){
       try {
     pl = new Player(new FileInputStream(ruta));
     pl.play();
           
       } catch (Exception ex) {
           System.out.println(" no hay ruta");
       }
          
   
   }
     
   public void repro(String ruta) throws JavaLayerException, FileNotFoundException{
       
       System.out.println(" valor que trae para reporducir "+ruta);
    this.ruta=ruta;
    }
           
           
        
}


class Graphiz{

    File file;
    FileWriter filew;
    BufferedWriter buferw;
    PrintWriter pega;
    
    String texto;
    String imagen;
    
    String rutaG = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
    String tipo = "-Tjpg";
    String parametro = "-o";
    
    public Graphiz(){
        
    
    }



 public void Inicia(Array2 datos, String nombre,String Tipo) throws IOException
    {
        
        System.out.println(" ingreso aqui");
        texto = nombre+".txt";
        imagen = nombre+".jpg";
        
        file = new File(texto);
        filew = new FileWriter(file);
        buferw = new BufferedWriter(filew);
        pega = new PrintWriter(buferw);
        

        pega.println("digraph G {");
        pega.println("rankdir=LR;");
        pega.println("node [shape=record];");
        
        Crea(datos);
        Enlaces(datos,Tipo);
        
        
        
        pega.println("}");

        
        pega.close();
        buferw.close();
        
        
        String [] cmd = {rutaG, tipo, texto, parametro, imagen};
        Runtime rt = Runtime.getRuntime();
        rt.exec(cmd);
        
        
    }
 
 
 
    private void Crea(Array2 nodo)
    {
        
        
        for(int i=0;i<30;i++){
        
            
            if(nodo.Val(i)!=null){
                
                 pega.println("node"+i+"[label = " +"\"{<ptr>  Ant |<val>["+ nodo.Val(i)+ "]| <ptr>  sigui}\""+ "];");
            
            //<ptr> 
            }else{
            
            
            
            }
            
        
        }
       
        
    }
    
    
    
    private void Enlaces(Array2 info, String Tipo)
    {
        if(Tipo.equals("DCircular")){
            
            apuntadorCD(info);
            
        
        }else if(Tipo.equals("Doble")){
            
            apuntadorDoble(info);
            
        
        }else if(Tipo.equals("Simple")){
            
        apuntadorSimple(info);
        
        }
        
        
        
        
    }
    
    
    private void apuntadorCD(Array2 dato){
        
        for(int i=0;i<30;i++){
            
            //if(dato.Val(i)!=null){
                
                if(i==0){
                    
                    
                    pega.println("\"node" + i + "\":ptr->" + "\"node"+1+ "\"");
                    
                    
                }else if(dato.Val(i+1)==null){
                    
                    pega.println("\"node" + i + "\":ptr->" + "\"node" + 0+ "\"");
                    pega.println("\"node" + 0 + "\":ptr->" + "\"node"+i+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"node" + (i-1)+ "\"");
                break;
                }else{
                
                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i-1)+ "\"");
                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i+1)+ "\"");
                
                }
                
                
                
           //}else{
            
            
           // }
            
        }
        
        
        

    }
    
    
    
    private void apuntadorDoble(Array2 dato){
        
        for(int i=0;i<30;i++){
            
            //if(dato.Val(i)!=null){
                
                if(i==0){
                    
//                    pega.println("\"node" + i + "\":ptr->" + "\"node"+29+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"Nodo "+-1+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"node"+1+ "\"");
                    
                    
                }else if(dato.Val(i+1)==null){
                    
                    pega.println("\"node" + i + "\":ptr->" + "\"node" + (i-1)+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"Nodo " + null+ "\"");
                break;
                }else{
                
                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i-1)+ "\"");
                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i+1)+ "\"");
                
                }
                
                
                
            //}else{
            
            
           // }
            
        }
        
        
        

    }
    
private void apuntadorSimple(Array2 dato){
        
        for(int i=0;i<30;i++){
            
           // if(dato.Val(i)!=null){
                
                if(i==0){
                    
//                    pega.println("\"node" + i + "\":ptr->" + "\"node"+29+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"node"+1+ "\"");
                    
                    
                }else if(dato.Val(i+1)==null){
                    
//                    pega.println("\"node" + i + "\":ptr->" + "\"node" + 0+ "\"");
                    pega.println("\"node" + i + "\":ptr->" + "\"Nodo " + null+ "\"");
                break;
                }else{
                
//                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i-1)+ "\"");
                pega.println("\"node" + i + "\":ptr->" + "\"node" + (i+1)+ "\"");
                
                }
                
                
                
           // }else{
            
            
          //  }
            
        }
        
        
        

    }


 public void Abre(String nombre){
        File file=null;
        
        try 
        {
            
            file = new File(nombre + ".jpg");
            Desktop.getDesktop().open(file);
            
            
        } 
        catch (IOException ex) {
            
        }
    }

}