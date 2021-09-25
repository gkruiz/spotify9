
package spoty9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

public class Biblioteca {
    
    
    int filab=-9;
    
    
    
    JFrame nuevo,nuevo2;
    JPanel bpanel,bpanel2;
    JComboBox tipolista ;
    JLabel a1;
    
    JScrollPane scroll,scroll2;
    
    JTable tablamusica,tablamusica2;
    String listabusca=null;
    
    JComboBox ca;
    int tiplist =-8;
    
    //Auxiliares para talbas
    String [][] arregloaux;
    String [][] enca2 ;
    
    String [][]Play;
    String [][]Canci;
    String [][]Album;
    String [][]Artis;
    String [][]tablaPlay;
    
    //fin auxiliares tablas
    
    JButton playlistB;
    JButton cancionesB;
    JButton AlbumnesB;
    JButton ArtistasB;
    JButton boton;
    
    
    static Array2 objetosL;
    int objecontador=0;
    //ventana ven ;
    
    int filamodi = -9;
    
    
    
    Biblioteca(){
        
        
     objetosL =new Array2(30);
     
    enca2 = new String[30][5];
    Play = new String[30][3];//id/Lista/check
    Canci = new String[30][4];//id/nombre/album/artista
    Album = new String[30][3];//id/album/check
    Artis = new String[30][3];//id/album/check
    tablaPlay= new String[30][4];//id/nombre/album/artista
    
    componentes();
    
    }
    
    private void componentes(){
        
    nuevo = new JFrame("Biblioteca");
    nuevo.setBounds(500, 150, 400, 400);
    nuevo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo.setResizable(false);
    nuevo.setVisible(false);
    
    
    
    bpanel = new JPanel();
    bpanel.setLayout(null);
    
    nuevo.add(bpanel);
    
    
    a1= new JLabel("Opciones");
    a1.setBounds(10, 10, 150, 20);
    
    
    
    
    
    
    
    
    boton = new JButton("Crear");
    boton.setBounds(150,305,100,30);
    
    
    
    
    
    cancionesB = new JButton("Canciones");
    cancionesB.setBounds(100, 55, 95, 20);
     canciones();
    AlbumnesB = new JButton("Albums");
    AlbumnesB.setBounds(200, 55, 80, 20);
    album();
    ArtistasB = new JButton("Artistas");
    ArtistasB.setBounds(290, 55, 80, 20);
    botonArtis();
    
    
    tablanormal();
    botonPlayL();
    
    
    bpanel.add(a1);
    
   // bpanel.add(boton);
    
    
    bpanel.add(cancionesB);
    bpanel.add(AlbumnesB);
    bpanel.add(ArtistasB);
    ArtistasB.setVisible(true);
        
    a1.setVisible(true);
    
    
    bpanel.repaint();
    
    
    }
    
    
    
     private void componentes2(){
        
    nuevo2 = new JFrame("INFO");
    nuevo2.setBounds(500, 250, 400, 250);
    nuevo2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo2.setResizable(false);
    nuevo2.setVisible(false);
    
    
    bpanel2 = new JPanel();
    bpanel2.setLayout(null);
    
    nuevo2.add(bpanel2);
    
    tablanormal2();
    
    
    bpanel.repaint();
    
    
    }
     private void tablanormal2(){
    
    
    
    String []enca = {"Id","Artista","Album","Cancion"};
    
    
    
    
    tablamusica2 = new JTable(tablaPlay,enca);
    scroll2 = new JScrollPane(tablamusica2);
    scroll2.setBounds(25, 20, 350, 200);
    bpanel2.add(scroll2);
    scroll2.setVisible(true);
    
    
    }
    
    
      
      
      
      
    
    private void tablanormal(){
    
    
    
    String []enca = {"Id","Artista","Album","Cancion","Check"};
    
    
    
    
    tablamusica = new JTable(enca2,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            filamodi=filax;
            
            
            
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
    scroll.setBounds(50, 95, 300, 200);
    bpanel.add(scroll);
    scroll.setVisible(false);
    
    
    }
    
    private void botonPlayL(){
    playlistB = new JButton("Playlist");
    playlistB.setBounds(10, 55, 80, 20);
    bpanel.add(playlistB);
    playlistB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           try{
           tablaPlaylist();
            }catch(Exception cc){
                System.out.println(" no hay datos++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
    
    });
    
    
    }
     private void tablaPlaylist(){
    
    String []enca = {"Id","Lista","Ver"};
    
    scroll.setVisible(false);
    bpanel.remove(scroll);
    
    consulList();
    
    
    tablamusica = new JTable(Play,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           try{
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            System.out.println("valor de filas "+Play[filax][2]);
            filab=filax;
            System.out.println("valor filax "+filax);
             if(columnax==2){
                 
                 System.out.println("valor de play fila col 2");
            if(Play[filax][2].equals("Ver")){
            
            //ven = new ventana(filamodi);
            //ven.nuevo.setVisible(true);
            System.out.println("valor que busca"+Play[filax][1]);
            try{    
            consulta(Play[filab][1]);
            }catch(Exception asdf){
            
            }
            
            componentes2();
            nuevo2.setVisible(true);
            nuevo2.repaint();
            }else{
            
            }
            }else{
            
            
            }
            
           }catch(Exception adfasdfe){
      
      
      }
            
            
      }
        });
    
    TableColumn sportColumn = tablamusica.getColumnModel().getColumn(2);
    ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Ver");
    
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
//    ca.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            String select = ((String)ca.getSelectedItem());
//            
//            System.out.println("valor de select "+select);
//            
//            
////            if(select!=null){
////            if(select.equals("Ver")){
////            
////            //ven = new ventana(filamodi);
////            //ven.nuevo.setVisible(true);
////            System.out.println("valor que busca"+Play[filab][1]);
////            try{    
////            consulta(Play[filab][1]);
////            }catch(Exception asdf){
////            
////            }
////            
////            componentes2();
////            nuevo2.setVisible(true);
////            nuevo2.repaint();
////            }else{
////            
////            }
////            }else{
////            
////            
////            }
//            
//            
//            
//            System.out.println(" ejecuta el evento");
//        }
//    
//    });
//    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(50, 95, 300, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    
    private void consulList(){
    Array2 temp  = NuevaListaReproduccion.Listas;
    
    
    
    
    
    boolean ban = false;
    int conta=0;
    int es =-8;
    Pila saca1 = null;
    Cola saca2 =null;
    NCircular saca3 = null;
    
    int cagrega=0;
    
    Object can=null ;
    
//        System.out.println("trae lista "+temp.Val(0));
    try{
    
    while(!ban){
        es=-8;
        can = temp.Val(conta);
        if(can!=null){
            
        try{
        saca1 = (Pila)temp.Val(conta);
        //saca1.peek();
        
        es=0;
//        objecontador.
            objetosL.Add(saca1, objecontador);
            
            objecontador++;
            
            System.out.println(" es pila--------------------------"+saca1.peek());
        }catch(Exception a1m){
            //System.out.println("no es Pila");
            //es=-8;
        }
        System.out.println("es seguido "+es);
        
        
        
        try{
        saca2 = (Cola)temp.Val(conta);
        
        es=1;
        System.out.println(" es cola--------------------------"+saca2.Nombre);
        objetosL.Add(saca2, objecontador);
            
            objecontador++;
        }catch(Exception a1mn){
           // System.out.println("no es cola");
            //es=-8;
        }
        System.out.println("es seguido "+es);
        
        try{
        saca3 = (NCircular)temp.Val(conta);
        es=2;
        System.out.println(" es circu--------------------------"+saca3.Nombre);
        objetosL.Add(saca3, objecontador);
            
            objecontador++;
        }catch(Exception a1u){
            
            //.out.println("no es Circular");
        }
        
        
        
        System.out.println("valor es "+es);
        switch (es) {
            case 0:
                
                
                String tepxx= (String) saca1.Nombre;
                Play[cagrega][0]=Integer.toString(cagrega);
                Play[cagrega][1]= tepxx;
                Play[cagrega][2]= "-----";
                
                
                cagrega++;
                
                
                System.out.println("valro que ingresa "+(String)saca1.Nombre);
                break;
            case 1:
                
                
                String tepxx2= (String) saca2.Nombre;
                Play[cagrega][0]=Integer.toString(cagrega);
                Play[cagrega][1]= tepxx2;
                Play[cagrega][2]= "-----";
                cagrega++;
                System.out.println("valro que ingresa "+(String)saca2.Nombre);
                break;
            case 2:
                
                String tepxx3= (String) saca3.Nombre;
                Play[cagrega][0]=Integer.toString(cagrega);
                Play[cagrega][1]= tepxx3;
                Play[cagrega][2]= "-----";
                cagrega++;
                System.out.println("valro que ingresa "+(String)saca3.Nombre);
                break;
            default:
                
                ban=true;
                break;
        }
        
        
        
        
        conta++;
        
        
        
        
            }else{
            ban=true;
        }
        
        
    
    }
    
    
    
    }catch(Exception xc){
        System.out.println(" no hay listas o algo");
    }
    
    
    }
    
    
    
    
    
    
    private void canciones(){
    cancionesB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            
            tablacanciones();
            
            
        }
    
    });
    
    }
    private void tablacanciones(){
    consultacan();
    String []enca = {"Id","Cancion","Album","Artista"};
    
    scroll.setVisible(false);
    bpanel.remove(scroll);
    
    tablamusica = new JTable(Canci,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            
            
      }
        });
    
    TableColumn sportColumn = tablamusica.getColumnModel().getColumn(2);
    JComboBox ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Ver");
    
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(50, 95, 300, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    private void consultacan(){
    
        for(int i=0;i<frame.contador1;i++){
        Canci[i][0]=Integer.toString(i);
        Canci[i][1]=(String)frame.rCancion.Val(i);
        Canci[i][2]=(String)frame.rAlbum.Val(i);
        Canci[i][3]=(String)frame.rArtista.Val(i);
        
        }
    
    }
    
    
    private void album(){
    AlbumnesB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          tablaalbum();
            
            
        }
    
    });
    
    }
    private void tablaalbum(){
    consultaalb();
    String []enca = {"Id","Album","Check"};
    
    scroll.setVisible(false);
    bpanel.remove(scroll);
    
    tablamusica = new JTable(Album,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            
            
      }
        });
    
    TableColumn sportColumn = tablamusica.getColumnModel().getColumn(2);
    JComboBox ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Ver");
    
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(50, 95, 300, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    private void consultaalb(){
    
        for(int i=0;i<frame.contador1;i++){
            
            try{
                if(Tops.tal.Val(i)!=null){
                    
                Album[i][0]=Integer.toString(i);
                Album[i][1]=(String)Tops.tal.Val(i);
                Album[i][2]="";
                
                }else{
                
                }
        
        
            }catch(Exception exc){
                System.out.println("no hay algo ja");
            }
        
        }
    
    }
    
    
    
    
    
    
    
    
    
    //para consulta de playist
    
    public void consulta(String nombre) throws CloneNotSupportedException{
        
        
        
        
        Array2 datos=null;
       
        
        try {
            datos = (Array2)NuevaListaReproduccion.Listas.clone();
            System.out.println(" se clono+++-+-+-+-+-");
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<=6;i++){
            System.out.println("valores trae lista "+datos.Val(i));
        }
        
        
        Pila pil= null;
        Cola col= null;
        NCircular cir= null;
        
        
        boolean sale =false;
        int contador =0;
        
        int es;
        
        while(!sale){
            System.out.println(" valor contador "+contador);
            Object temp = datos.Val(contador);
            
            
            es=-8;
        
            
            
            
        if(temp!=null){
            
            
            
        try{
           
        pil = (Pila)temp;
        
        es=0;
        Array2 asdf =(Array2)pil.peek();
            tiplist=es;
        System.out.println(" es pila--------------------+++++++++++++++++++------"+asdf.Val(0));
        }catch(Exception as1){
            
        }
        
        System.out.println("es seguidolllllllllll "+es);
        
        
        
        try{
        col = (Cola)temp;
        
        es=1;
        System.out.println(" es cola-------------------------+++++++++++++++++++++++++++-"+col.Nombre);
        tiplist=es;
        }catch(Exception a1xa){
           
        }
        System.out.println("es seguido22222222222222 "+es);
        
        
        
        try{
        cir = (NCircular)temp;
        es=2;
        System.out.println(" es circu-------------------------++++++++++++++++++++++++++++++-"+cir.valor);
        tiplist=es;
        }catch(Exception a1w){
            
            
        }
        
        
        switch (es) {
                case 0:
                    
                    System.out.println("es 0");
                    String nomb = pil.Nombre;
                    
                    if(nomb.equals(nombre)){
                        System.out.println(" nombre "+nomb);
                        rellePila((Pila)pil.clone());
                        
                        sale=true;
                        break;
                    }else{
                    
                    }
                    
                    
                    break;
                case 1:
                    System.out.println("es 1");
                    
                    String nomb2 = col.Nombre;
                    if(nomb2.equals(nombre)){
                    
                        relleCola((Cola)col.clone());
                        
                        sale=true;
                        break;
                    }else{
                    
                    }
                    break;
                case 2:
                    System.out.println("es 2");
                    
                    String nomb3 = cir.Nombre;
                    
                    if(nomb3.equals(nombre)){
                    
                        relleCircu((NCircular)cir.clone());
                        
                        sale=true;
                        break;
                    }else{
                    
                    }
                    break;
                default:
                    System.out.println("ninguno");
                    break;
            }
        contador++;
       }else{
        
        sale=true;
        }  
            
        }
        
        
        
        
        
      
    
    
    }
    
    
    
    private void rellePila(Pila pila){
        
        boolean bandera = false;
        int contador=0;
        
     Pila aux = pila;
   
        
    while(!aux.empty()){
        System.out.println(" esta llen????"+aux.empty());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println("valor de pila "+aux.Nombre);
        
        
        if(aux.peek()==null){
              System.out.println(" Llego nulo easdfas");
          break;
          }else{
           
            
           Array2 llena = (Array2)aux.pop();
           
            System.out.println("valorquepude mostrar "+llena.Val(0));
           System.out.println("valorquepude mostrar "+llena.Val(1));
           System.out.println("valorquepude mostrar "+llena.Val(2));
             String temp1 = Integer.toString(contador);
             String temp2 = (String)llena.Val(0);
             String temp3 = (String)llena.Val(1);
             String temp4 = (String)llena.Val(2);
              
          tablaPlay[contador][0]=temp1;
          tablaPlay[contador][1]=temp2;
         tablaPlay[contador][2]=temp3;
          tablaPlay[contador][3]=temp4;
          
          
             
              
              
              
              contador++;
          
              
              
          }
//           System.out.println("consulto en PILA----00000000000000000000000000000000---"+enca2[contador][0]);
      }
        System.out.println("valro status pila "+aux.empty());
    
//    scroll.setVisible(false);
//    nupanel.remove(scroll);
//    
//    tablad();
//    for(int i=0;i<=3;i++){
//        System.out.println(" consul matriz "+enca2[i][0]);
//    }
    
    }
    
    private void relleCola(Cola cols){
        
        String sal=null;
        boolean bandera = false;
        int contador=0;
        
     Cola aux = cols;
     Cola aux2=null;
        try {
            aux2 = (Cola)cols.clone();
            
            
        } catch (CloneNotSupportedException ex) {
            System.out.println(" eeror al clonar rrelle pila");
            Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    while(!aux.Empty()){
        
        
        
        System.out.println(" se debe salir?? "+aux.Empty());
           System.out.println(" iteracion asdfasdf -+-+-+");
          
          if(aux.Empty()){
              System.out.println(" 5252525");
              System.out.println(" adsfasd");
              
          break;
          }else{
              //System.out.println(" aux lengh"+aux.length());
              if(contador>29){
              break;
              }else{
              
              
              }
           Array2 llena2 = (Array2)aux.Pop();
           
           
             String temp1 = Integer.toString(contador);
             String temp2 = (String)llena2.Val(0);
             String temp3 = (String)llena2.Val(1);
             String temp4 = (String)llena2.Val(2);
             
//             if(sal==null){
//           
//           }else{
//           if(sal.equals(temp2)){
//           break;
//           }
//           
//           }
           
             
              sal= temp2;
          tablaPlay[contador][0]=temp1;
          tablaPlay[contador][1]=temp2;
         tablaPlay[contador][2]=temp3;
          tablaPlay[contador][3]=temp4;
          
              System.out.println("consulto en cola-------"+temp2);
              
              
              
              contador++;
          
          }
          
      }
   
//    for(int i=0;i<=3;i++){
//        System.out.println(" consul matriz "+enca2[i][0]);
//    }
    }
    
    private void relleCircu(NCircular circu){
        boolean bandera = false;
        int contador=0;
        //PROBLEMA VERFICAR PORQUE CADALISAPUEDE SER DISTITO CIR DOBLE COLA PILA
     NCircular aux = circu;
     
     NCircular det =circu;
     int itero=0;
     
    Array2 llena;
        
    while(!bandera){
           llena = (Array2)aux.valor;
           
           if((det.valor.equals(aux.valor))&&(itero==1)){
               bandera=true;
           }else{
           
          
             String temp1 = Integer.toString(contador);
             String temp2 = (String)llena.Val(0);
             String temp3 = (String)llena.Val(1);
             String temp4 = (String)llena.Val(2);
              
          tablaPlay[contador][0]=temp1;
          tablaPlay[contador][1]=temp2;
         tablaPlay[contador][2]=temp3;
          tablaPlay[contador][3]=temp4;
          
          
              System.out.println("consulto en PILA-------"+temp2);
              aux=aux.next;
              //ver porque infinito
              contador++;
          
          
           itero=1;
           }
          
          
      }
    
    }
    
    //tabla artista
    
    private void botonArtis(){
   
    ArtistasB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
//           try{
           tablaArtis();
//            }catch(Exception cc){
//                System.out.println(" no hay datos++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            }
        }
    
    });
    
    
    }
     private void tablaArtis(){
    
    String []enca = {"Id","Lista","Ver"};
    
    scroll.setVisible(false);
    bpanel.remove(scroll);
    
    consulartista();
    
    
    tablamusica = new JTable(Artis,enca);


    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(50, 95, 300, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    private void consulartista(){
    
        for(int i=0;i<30;i++){
        
            if(((String)frame.rArtista.Val(i))!=null){
            
             Artis[i][0]=Integer.toString(i);
            Artis[i][1]=(String)frame.rArtista.Val(i);
            Artis[i][2]="-----";    
            }else{
            
            }
           
                
        }
    
    
    }
    
}























