
package spoty9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;


public class Radio {
    
    
    static int datos =0;
    
     JFrame nuevo;
    JPanel bpanel;
    JComboBox tipolista ;
    JLabel a1;
    
    JScrollPane scroll;
    
    JTable tablamusica;
    
    int borro=0;
    //Auxiliares para talbas
    String [][] arregloaux;
    String [][] enca2 ;
    JButton botonx,atras,play,next,stop ;
    int press =0;
    
    
    
    
    
    
    public Radio(){
        enca2 = new String[30][5];
        componentes();
        
    
    }
    
    
    private void componentes(){
        
    nuevo = new JFrame("Biblioteca");
    nuevo.setBounds(500, 150, 400, 400);
    nuevo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo.setResizable(false);
    nuevo.setVisible(false);
    nuevo.addWindowListener(new WindowListener(){
        @Override
        public void windowOpened(WindowEvent e) {
           
        }

        @Override
        public void windowClosing(WindowEvent e) {
           
        }

        @Override
        public void windowClosed(WindowEvent e) {
           
        }

        @Override
        public void windowIconified(WindowEvent e) {
          
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
           
        }

        @Override
        public void windowActivated(WindowEvent e) {
            try{
            frame.hilo.stop();
            frame.hilo=null;
            }catch(Exception asdfw){
            
            }
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            try{
            frame.hilo.stop();
            frame.hilo=null;
            }catch(Exception asdf){
            
            
            }
        }
    
    });
    
    
    bpanel = new JPanel();
    bpanel.setLayout(null);
    
    nuevo.add(bpanel);
    
    
    a1= new JLabel("Opciones");
    a1.setBounds(10, 10, 150, 20);
    
    
    
    botonx = new JButton("Actualizar");
    botonx.setBounds(250, 15, 100, 20);
    
    //tablanormal();
    botonx.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           boton();
        }
    });
    
    bpanel.add(botonx);
    bpanel.add(a1);
    a1.setVisible(true);
    ATRAS();
    PLAY();
    NEXT();
    STOP();
    bpanel.repaint();
    
    
    }
    
    
    public void boton(){
    
        System.out.println(" valor de datos "+datos);
        if(datos==1){
            
        if(borro==0){
        consulta();
        tablanormal();
        borro=1;
        }else{
        scroll.setVisible(false);
        bpanel.remove(scroll);
        consulta();
        tablanormal();
        
        }
            
            
        
        
        
        }else{
        
        
        }
    
    }
    
    
    
    private void tablanormal(){
    
    
    
    String []enca = {"Id","Artista","Album","Cancion","Repr"};
    
    
    
    
    tablamusica = new JTable(enca2,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            
            
      }
        });
    
    
    
    
    
    TableColumn sportColumn = tablamusica.getColumnModel().getColumn(4);
    JComboBox ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Add");
    ca.addItem("Remove");
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 45, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    
    
    
    private void ATRAS(){
    atras = new JButton();
    atras.setBounds(70, 260, 50, 50);
    atras.setBorder(null);
    atras.setHorizontalAlignment(JButton.CENTER);
    atras.setVerticalAlignment(JButton.CENTER);
    atras.setContentAreaFilled( false );
    
    
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/spoty9/next2.png"));
    int ancho = 50; 
    int alto = 50; 
    atras.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
    
    
    
    
        atras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try{
            
                    
                  if(frame.hilo==null){
                  frame.Cradio.ultimo=frame.Cradio.ultimo.ant;
                         inicia();
                  
                  }  else{
            if(frame.hilo.isAlive()){
                
                frame.hilo.stop();
                
             frame.Cradio.ultimo=frame.Cradio.ultimo.ant;
             
                        inicia();
                        
                        
                
              play.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                
              
                
                
        }else{
                
                
                        frame.Cradio.ultimo=frame.Cradio.ultimo.ant;
                         inicia();
                        
                        
       
           
            
        }
            
            
                  }
            press=1;
            play.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            
        }catch(Exception xs){
            System.out.println(" el hilo no existe o esta detenido");
        }
               
                
            }
        });
    
        
        bpanel.add(atras);
    }
    private void PLAY(){
    play = new JButton();
    play.setBounds(140, 260, 50, 50);
    play.setBorder(null);
    play.setHorizontalAlignment(JButton.CENTER);
    play.setVerticalAlignment(JButton.CENTER);
    play.setContentAreaFilled( false );
    
    
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/spoty9/play.png"));
    int ancho = 50; 
    int alto = 50; 
    play.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
    
        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
               if(press==0){
                System.out.println(" paso con press 0");
            play.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            press=1;
            
                    if(frame.hilo==null){
                        
                        
                        
                        inicia();
                        
                        
                        
                    
                    
                    }else{
                    
                    
                    frame.hilo.resume();
                    
                    
                    }
            
            }else if(press==1){
                
                System.out.println("paso con press 1");
            play.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
                press=0;
                
                if(frame.hilo==null){
                
                
                }else{
                
                frame.hilo.suspend();
                }
                
                
            }else{
            
            }
                
                
                
               
               
                
               
               
               
            }
        });
    
        
        bpanel.add(play);
    }
    
    private void NEXT(){
    next = new JButton();
    next.setBounds(210, 260, 50, 50);
    next.setBorder(null);
    next.setHorizontalAlignment(JButton.CENTER);
    next.setVerticalAlignment(JButton.CENTER);
    next.setContentAreaFilled( false );
    
    
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/spoty9/next.png"));
    int ancho = 50; 
    int alto = 50; 
    next.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
    
    
    
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
            if(frame.hilo==null){
            
            frame.Cradio.ultimo=frame.Cradio.ultimo.next;
                        inicia();
            }else{
            
            if(frame.hilo.isAlive()){
                
                frame.hilo.stop();
                frame.Cradio.ultimo=frame.Cradio.ultimo.next;
             
                        inicia();
                
                play.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
                
              press=1;
                
                
        }else{
               
                        frame.Cradio.ultimo=frame.Cradio.ultimo.next;
                        inicia();
                        
                        
       
           
            
        }
            
            }
            
            play.setIcon(new ImageIcon(getClass().getResource("/spoty9/pause.png")));
            
        }catch(Exception xs){
            System.out.println(" el hilo no existe o esta detenido");
        }
                
                
               
                
            }
        });
    
        
        bpanel.add(next);
    }
    
    private void STOP(){
    stop = new JButton();
    stop.setBounds(280, 260, 50, 50);
    stop.setBorder(null);
    stop.setHorizontalAlignment(JButton.CENTER);
    stop.setVerticalAlignment(JButton.CENTER);
    stop.setContentAreaFilled( false );
    
    
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/spoty9/cuadro.png"));
    int ancho = 25; 
    int alto = 25; 
    stop.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
    
    
        stop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                   if(frame.hilo==null){
        
        
                    }else{
                    frame.hilo.stop();
                    frame.hilo=null;
                    }
           
                play.setIcon(new ImageIcon(getClass().getResource("/spoty9/play.png")));
                press=0;
            }
        });
    
        
        bpanel.add(stop);
    }
    
    
    
    
    
    
    
    
    
     public void consulta(){
        boolean bandera = false;
        
        int contador=0;
        
        NodoArtista aux1= ListaArtista.ultimo;
        LAlbum aux2=LAlbum.ultimo;
        Lcancion aux3=Lcancion.ultimo;
        
      while(!bandera){
          
          if(aux3==null){
          bandera=true;
          }else{
              
             String temp1 = Integer.toString(contador);
             String temp2 = aux1.artista;
             String temp3 = aux2.album;
             String temp4 = aux3.cancion;
               System.out.println(" esta consultando ------"+temp2);
               System.out.println(" esta consultando ------"+temp3);
               
          enca2[contador][0]=Integer.toString(contador);
          enca2[contador][1]=aux1.artista;
         enca2[contador][2]=aux2.album;
          enca2[contador][3]=aux3.cancion;
        
          
              aux1=aux1.next;
              aux2=aux2.siguiente;
              aux3=aux3.siguiente;
              
              contador++;
          
          }
          
      }
    
    
    }
    
     
     
    private void inicia(){
        
        
        
        try{
            System.out.println(" valor del hilo "+frame.hilo);
            if(frame.hilo==null){
            
            
            
            
                    Array2 sacaCIr = null;//declara global para next
                    sacaCIr = (Array2) frame.Cradio.ultimo.valor;
                               
                                System.out.println("valro de sacaCir "+sacaCIr.Val(0));
                                System.out.println("valro de sacaCir "+sacaCIr.Val(1));
                                System.out.println("valro de sacaCir "+sacaCIr.Val(2));
                                
                               if(sacaCIr==null){
                                   
                                   
                               }else{
                                   
                                frame.hilo = new Reproduce();
                                try {
                                   String asdfss = Bcancion((String)sacaCIr.Val(0),(String)sacaCIr.Val(1),(String)sacaCIr.Val(2));
                                   
                                   
                                    System.out.println(" devolvio la ruta en radio 132132132132132132 "+asdfss);
                                    System.out.println(" valor que tiene Cola Repro"+asdfss+"----------------------------------s////////////////////////////");
                                    frame.hilo.repro(asdfss);
                                 }catch (Exception ex) {
                                   
                                }
                                
                       frame.hilo.start();
                        }
                               
                       }else{
            frame.hilo.stop();
            frame.hilo=null;
            
            Array2 sacaCIr = null;//declara global para next
                    sacaCIr = (Array2) frame.Cradio.ultimo.valor;
                               
                                
                               if(sacaCIr==null){
                               }else{
                                frame.hilo = new Reproduce();
                                try {
                                   String asdfss = Bcancion((String)sacaCIr.Val(0),(String)sacaCIr.Val(1),(String)sacaCIr.Val(2));
                                    System.out.println(" valor que tiene Cola Repro"+asdfss+"----------------------------------s////////////////////////////");
                                    frame.hilo.repro(asdfss);
                                 }catch (Exception ex) {
                                   
                                }
                                
                       frame.hilo.start();
                        }
            
                
                
                
            
            
                        }        
                               
                               
                               
                               }catch(Exception sds){
                                System.out.println("die error");
                                }
    
    
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
        
        
        
        if((frame.rArtista.Val(i).equals(Artista))&&(frame.rAlbum.Val(i).equals(Album))&&(frame.rCancion.Val(i)).equals(Cancion)){
           
            rutax = (String)frame.ruta.Val(i);
            
            System.out.println("valor artista en guardado Array"+frame.rArtista.Val(i));
        System.out.println("valor artista en guardado Array"+frame.rAlbum.Val(i));
        System.out.println("valor artista en guardado Array"+frame.rCancion.Val(i));
            
            break;
            
        }else{
         System.out.println("valor artista en guardado Array"+frame.rArtista.Val(i));
        System.out.println("valor artista en guardado Array"+frame.rAlbum.Val(i));
        System.out.println("valor artista en guardado Array"+frame.rCancion.Val(i));
        
        
        }

    }
        return rutax;
    
    
    }
    
    
    
    
}



