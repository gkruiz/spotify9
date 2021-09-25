
package spoty9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
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



public class Tops {
    
    
        
    static int datos =0;
    
     JFrame nuevo;
    JPanel bpanel;
    JLabel a1;
    
    JScrollPane scroll;
    JTable tablamusica;
    
    //Auxiliares para talbas
    
    String [][] tartista ;
    String [][] talbum ;
    String [][] tcancion ;
    
    
    JButton boton1,boton2,boton3;
    
    JButton AscArtis,AscAlbum,AscCancion;
    JButton DesArtis,DesAlbum,DesCancion;
    
    static Array2 tc=null;
    static Array2 tal=null;
    static Array2 tar=null;
    
    Array2 csuma=null;
    Array2 alsuma=null;
    Array2 artsuma=null;
    int creo=0;
    
    
    public Tops(){
        
        
        
        tartista = new String[30][3];
        talbum = new String[30][3]; 
        tcancion = new String[30][3]; 
        
        
        componentes();
        array();
        llenas();
    
    }
    
    private void array(){
//    
        tc  = new Array2(30);
        csuma = new Array2(30);
        
        tal= new Array2(30);
        alsuma= new Array2(30);
        
        tar = new Array2(30);   
        artsuma = new Array2(30);   
                
    
    }
    
    private void llenas(){
    for(int i=0;i<30;i++){
        csuma.Add(0, i);
        alsuma.Add(0, i);
        artsuma.Add(0, i);
    }
    
    }

    
    
    
    private void componentes(){
        
    nuevo = new JFrame("Reportes");
    nuevo.setBounds(500, 150, 400, 500);
    nuevo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo.setResizable(false);
    nuevo.setVisible(false);
    
    
    bpanel = new JPanel();
    bpanel.setLayout(null);
    
    nuevo.add(bpanel);
    
    
    a1= new JLabel("Opciones");
    a1.setBounds(10, 10, 150, 20);
    
    
    
    boton1 = new JButton("Top Canciones");
    boton1.setBounds(40, 30, 150, 20);
    boton1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            if(creo==0){
            
            Tcancion();
            creo=1;
            }else{
            scroll.setVisible(false);
            bpanel.remove(scroll);
            Tcancion();
            }
            
        }
    });
    
    
    boton2 = new JButton("Top Albums");
    boton2.setBounds(210, 30, 150, 20);
    boton2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           if(creo==0){
            
            TAlbum();
            creo=1;
            }else{
            scroll.setVisible(false);
            bpanel.remove(scroll);
            TAlbum();
            }
        }
    });
    
    
    
    boton3 = new JButton("Top Valoracion");
    boton3.setBounds(125, 70, 150, 20);
    boton3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            if(creo==0){
            
            Tartista();
            creo=1;
            }else{
            scroll.setVisible(false);
            bpanel.remove(scroll);
            Tartista();
            }
            
        }
    
    });
    
////    
////    JButton AscArtis,AscAlbum,AscCancion;
////    JButton DesArtis,DesAlbum,DesCancion;
    
    
    AscArtis = new JButton("AscArtis");
    AscArtis.setBounds(30, 345, 100, 20);
    AscArtis.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         ordenaAsc("artista");
           // ordenaASC("artista");
           
           if(creo==0){
         
             String []enca = {"Id","Artista","Veces"};
    
    tablamusica = new JTable(tartista,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             
             
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Artista","Veces"};
    
    tablamusica = new JTable(tartista,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
           
        }
    
    });
    
    
    AscAlbum = new JButton("AscAlbum");
    AscAlbum.setBounds(150, 345, 100, 20);
    AscAlbum.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         ordenaAsc("album");
            
         if(creo==0){
         
             String []enca = {"Id","Album","Veces"};
    
    tablamusica = new JTable(talbum,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             
             creo=1;
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Album","Veces"};
    
    tablamusica = new JTable(talbum,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
         
        }
    
    });
    
    
    AscCancion = new JButton("AscCanci");
    AscCancion.setBounds(270, 345, 100, 20);
    AscCancion.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         ordenaAsc("cancion");
           // ordenaASC("cancion");
           
                      if(creo==0){
         
             String []enca = {"Id","Cancion","Veces"};
    
    tablamusica = new JTable(tcancion,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             creo=1;
             
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Cancion","Veces"};
    
    tablamusica = new JTable(tcancion,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
           
        }
    
    });
    
    
    //////
    DesArtis = new JButton("DesArtis");
    DesArtis.setBounds(30, 385, 100, 20);
    DesArtis.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
          ordenaDes("artista");

           if(creo==0){
         
             String []enca = {"Id","Artista","Veces"};
    
    tablamusica = new JTable(tartista,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             creo=1;
             
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Artista","Veces"};
    
    tablamusica = new JTable(tartista,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
          
        }
    
    });
    
    DesAlbum = new JButton("DesAlbum");
    DesAlbum.setBounds(150, 385, 100, 20);
    DesAlbum.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            ordenaDes("album");
            
            if(creo==0){
         
             String []enca = {"Id","Album","Veces"};
    
    tablamusica = new JTable(talbum,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             
             creo=1;
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Album","Veces"};
    
    tablamusica = new JTable(talbum,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
            
        }
    
    });
    
    
    DesCancion = new JButton("DesCancion");
    DesCancion.setBounds(270, 385, 100, 20);
    DesCancion.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            
         ordenaDes("cancion");
         
         if(creo==0){
         
             String []enca = {"Id","Cancion","Veces"};
    
    tablamusica = new JTable(tcancion,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
             
             creo=1;
         }else{
         scroll.setVisible(false);
         bpanel.remove(scroll);
         
         String []enca = {"Id","Cancion","Veces"};
    
    tablamusica = new JTable(tcancion,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
         
         }
         
    
         
         
            //tener tablita aqui
        }
    
    });
    
    
    
    //tablanormal();
    bpanel.add(AscArtis);
    bpanel.add(AscAlbum);
    bpanel.add(AscCancion);
    
    bpanel.add(DesArtis);
    bpanel.add(DesAlbum);
    bpanel.add(DesCancion);
    
    bpanel.add(boton1);
    bpanel.add(boton2);
    bpanel.add(boton3);
    
    bpanel.add(a1);
    a1.setVisible(true);
    
    bpanel.repaint();
    
    
    }
    
    
    
    
    private void Tartista(){
    
  
        pruebaorden("artista");
    String []enca = {"Id","Artista","Veces"};
    
    tablamusica = new JTable(tartista,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    
    private void TAlbum(){
    
    pruebaorden("album");
    
    String []enca = {"Id","Album","Veces"};
    
    tablamusica = new JTable(talbum,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    
    private void Tcancion(){
        
        
        pruebaorden("cancion");
        
        
    
    String []enca = {"Id","Cancion","Veces"};
    
    tablamusica = new JTable(tcancion,enca);
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(25, 136, 350, 200);
    bpanel.add(scroll);
    scroll.setVisible(true);
    
    
    }
    
    
    
    
    
    
    
    public void agregacancion(String ncancion){
    
        int contador=0;
        int bandera =0;
        System.out.println(" recibe para adsf "+ncancion);
        
        for(int i=0;i<30;i++){
            System.out.println(" valor de topcanciones "+tc.Val(i)+" 6666666666666666666666666666666");
            
               
            
       if(tc.Val(i)==null){
           
           
           contador++;
       }else{
       }
       }
//        
        System.out.println("variable contador en cancin "+contador);
        
        
        if(contador==30){
        
            //tc.Add(ncancion, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(tc.Val(i)==null){
        
        
        }else{
            
            if(tc.Val(i).equals(ncancion)){
            
            bandera=1;
            break;
            }else{
            
            
            }
            
        
        }
            
        }
        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(tc.Val(i)==null){
            
            tc.Add(ncancion, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
    public void agregaalbum(String nalbum){
    
        int contador=0;
        int bandera =0;
        
        
        for(int i=0;i<30;i++){
        
       if(tal.Val(i)==null){
           
           //tal.Add(nalbum, 0);
           contador++;
       }else{
       }
       }
        
        if(contador==30){
        
            //tal.Add(nalbum, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(tal.Val(i)==null){
        
        
        }else{
            System.out.println("album nuevo antes ----- "+tal.Val(i));
            System.out.println("valor de bandera antes ----- "+bandera);
            System.out.println("valor de album compara antes ----- "+nalbum);
            if(tal.Val(i).equals(nalbum)){
            
            bandera=1;
            break;
            }else{
            bandera=0;
            
            }
            
        
        }
            
        }
        }
        
//        for(int i=0;i<30;i++){
//            System.out.println("album nuevo "+tal.Val(i));
//            System.out.println("valor de bandera "+bandera);
//            System.out.println("valor de album compara "+nalbum);
//        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(tal.Val(i)==null){
            
            tal.Add(nalbum, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
    public void agregaartista(String nartista){
    
        int contador=0;
        int bandera =0;
        
        
        for(int i=0;i<30;i++){
        
       if((tar.Val(i))==null){
           
           //tar.Add(nartista, 0);
           contador++;
       }else{
       }
       }
        
        
        System.out.println("valor de ocntador "+contador);
        
        if(contador==30){
        
         //tar.Add(nartista, 0);
        
        }else{
        
        for(int i=0;i<30;i++){
            
        if(tar.Val(i)==null){
        
        
        }else{
            
            if(tar.Val(i).equals(nartista)){
            
            bandera=1;
            break;
            }else{
            
            
            }
            
        
        }
            
        }
        }
        
        
        if(bandera==0){
            
        for(int i=0;i<30;i++){
            
        if(tar.Val(i)==null){
            
            tar.Add(nartista, i);
        break;
        }else{
        
        }
            
            
        }
        
        }else{
        
            System.out.println(" hay repetiod no ingresa");
        }
        
        
        
        
        
       
    }
    public void aumento(String compara,String tipoL){
    
    if(tipoL.equals("Cancion")){
    
        for(int i=0;i<30;i++){
           
               System.out.println("valor d tc "+tc.Val(i));
               System.out.println("valor d compara "+compara);
               
            if((tc.Val(i)==null)||(compara==null)){
        
            }else{
            
            
            
            if(tc.Val(i).equals(compara)){
                int suma = ((int)csuma.Val(i))+1;
                
                csuma.Add(suma, i);
                
                break;
            }else{
            
            
            }
            
            
            }
            
            
        }
        
        
    
    }else if(tipoL.equals("Album")){
    
        for(int i=0;i<30;i++){
            
            System.out.println("valor d tal "+tal.Val(i));
               System.out.println("valor d compara "+compara);
            
            if((tal.Val(i)==null)||(compara==null)){
        
        }else{
        
                
                
            if(tal.Val(i).equals(compara)){
                int suma = ((int)alsuma.Val(i))+1;
                
                alsuma.Add(suma, i);
                System.out.println(" trae pra comparar "+compara);
                System.out.println(" valor de la suma actual "+suma);
                break;
            }else{
            
            
            }
                
            }
            
            
        }
        
    
    }else if(tipoL.equals("Artista")){
    
        
        for(int i=0;i<30;i++){
            System.out.println("valor d tar "+tar.Val(i));
               System.out.println("valor d compara "+compara);
            
            
        if((tar.Val(i)==null)||(compara==null)){
        
        }else{
            
            
            if(tar.Val(i).equals(compara)){
                int suma = ((int)artsuma.Val(i))+1;
                
                artsuma.Add(suma, i);
                System.out.println(" trae pra comparar "+compara);
                System.out.println(" valor de la suma actual "+suma);
                break;
            }else{
            
            
            }
            
            
            
        }
        }
    }else{
    
    
    }
        for(int i=0;i<9;i++){
            System.out.println("valo can "+tc.Val(i));
            System.out.println("valo tal "+tal.Val(i));
            System.out.println("valo tar "+tar.Val(i));
            
            
            System.out.println("conta can "+csuma.Val(i));
            System.out.println("conta tal "+alsuma.Val(i));
            System.out.println("conta tar "+artsuma.Val(i));
        }
        
        
        
    }
    
   
   
    
    public int[] metodoBurbujaDesc( int [ ] num )
    {
         int i;
         boolean flag = true;
         int temp;

         while ( flag )
         {
                flag = false;  
                for( i=0;  i < num.length -1;  i++ )
                {
                       if ( num[ i ] < num[i+1] )
                       {
                               temp = num[ i ]; 
                               num[ i ] = num[ i+1 ];
                               num[ i+1 ] = temp;
                              flag = true; 
                      } 
                } 
          } 
         return num;
    }
    //si sirve
    private Array2 AscP( Array2 num,Array2 info  )
    {
         int i;
         boolean flag = true;
         int temp;
         String tempo;
         
         while ( flag )
         {
                flag = false;  
                for( i=0;  i < 30-1;  i++ )
                {
                       if ( ((int)num.Val(i)) < ((int)num.Val(i+1)) )
                       {
                               tempo = (String)info.Val(i);
                               temp = (int)num.Val(i); 
                               
                               info.Add(info.Val(i+1), i);
                               num.Add(num.Val(i+1), i);
                               
                               info.Add(tempo, i+1);
                               num.Add(temp, i+1);
                               
                              flag = true; 
                      } 
                } 
          } 
         return info;
    }
    
    
    private void pruebaorden(String tipo){
    
        
        
        if(null != tipo)switch (tipo) {
            case "cancion":
                
               
                //este contiene un return 
//                for(int i=0;i<30;i++){
//                
//                    System.out.println("valor csuma "+csuma.Val(i)+" contenido "+tc.Val(i));
//                
//                }
                
                
                //Array2 temp = AscTop(csuma,tc);
                
                Array2 temp = AscP(csuma,tc);
                int contax=0;
//                for(int i=0;i<30;i++){
////                    System.out.println("csuma "+csuma.Val(i));
//                }
                
                for(int i=0;i<30;i++){
                    
                    
                    
                    tcancion[i][0]= Integer.toString(i);
                    tcancion[i][1]= (String)temp.Val(i);  
                    
                    for(int j=0;j<30;j++){
                        if(((String)temp.Val(i)==null)){
                        }else{
                            
                            if(tc.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)temp.Val(i)).equals(tc.Val(j))){
                                  
                                tcancion[i][2]= Integer.toString((int)csuma.Val(j));
                                contax++;
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                        
                        
                        
                     
                    
                    
                    
                    
                }
                
                break;
            case "album":
                
                
                
                
                Array2 temp2 = AscP(alsuma,tal);
                
                for(int i=0;i<30;i++){
                    
                    
                
                    talbum[i][0]= Integer.toString(i);
                    talbum[i][1]= (String)temp2.Val(i);
                    
                    for(int j=0;j<30;j++){
                        
                        
                     if(((String)temp2.Val(i)==null)){
                        }else{
                            
                            if(tal.Val(j)==null ){
                            
                            }else{   
                        
                        
                    if(talbum[i][1].equals(tal.Val(j))){
                      //  talbum[i][2]= (String)tal.Val(j);
                         talbum[i][2]= Integer.toString((int)alsuma.Val(j));
                        break;
                    }else{
                    
                    }
                    
                            }
                     }
                    
                    
                    }
                    
                    
                    
                }
                
                
                
                
                
                
                break;
            case "artista":
                
                Array2 temp3 = AscP(artsuma,tar);
                
                for(int i=0;i<30;i++){
                
                    tartista[i][0]= Integer.toString(i);
                    tartista[i][1]= (String)temp3.Val(i);
                    
                    for(int j=0;j<30;j++){
                        
                        
                   if(((String)temp3.Val(i)==null)){
                        }else{
                            
                            if(tar.Val(j)==null ){
                            
                            }else{     
                        
                        
                        
                    if(tartista[i][1].equals(tar.Val(j))){
                       // tartista[i][2]= (String)tar.Val(j);
                        tartista[i][2]= Integer.toString((int)artsuma.Val(j));
                        break;
                    }else{
                    
                    }
                    
                            }}
                    
                    
                    }
                    
                }
                
                break;
            default:
                
                break;
        }
        
        
        
        
    }
    
    
   
    
     
   
    
     private void ordenaDes(String tipo){
    String [] abece= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    //sino ponerlo mas add
    Array2 posi = new Array2(30);
    Array2 info = new Array2(30);
    
    int bandera =0;
    int contador=0;
    
    String [] split;
    
        if(null != tipo)switch (tipo) {
            
            case "cancion":
                
                
                
                for(int i=0;i<30;i++){
                if(tc.Val(i)!=null){
                    bandera=1;
                String temp = (String)tc.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl =null;
                if(bandera==1){
                 AscAl = DesPAlfa(posi,info);
                 
//                 tartista = new String[30][3];
//        talbum = new String[30][3]; 
//        tcancion = new String[30][3]; 



                 tcancion = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 tcancion[i][0]=Integer.toString(i);
                 tcancion[i][1]=(String)AscAl.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl.Val(i)==null)){
                        }else{
                            
                            if(tc.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl.Val(i)).equals(tc.Val(j))){
                                  
                                tcancion[i][2]= Integer.toString((int)csuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                }else{
                
                
                }
               
//                
//                for(int i=0;i<30;i++){
//                    System.out.println("saca de ascAlfa "+AscAl.Val(i));
//                
//                }
//                
                
                //meter a una tabla para  mostrar 
                
                
                break;
            case "album":
                
                
                
                 for(int i=0;i<30;i++){
                     System.out.println("valores que prueba "+tal.Val(i));
                if(tal.Val(i)!=null){
                    System.out.println("valores que dentro "+tal.Val(i));
                    bandera=1;
                String temp = (String)tal.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                    System.out.println("compara abece " +abece[j]);
                    System.out.println("con  "+split[0]);
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    break;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl2 =null;
                if(bandera==1){
                 AscAl2 = DesPAlfa(posi,info);
                 
                 
                 
                 talbum = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 talbum[i][0]=Integer.toString(i);
                 talbum[i][1]=(String)AscAl2.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl2.Val(i)==null)){
                        }else{
                            
                            if(tal.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl2.Val(i)).equals(tal.Val(j))){
                                  
                                talbum[i][2]= Integer.toString((int)alsuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                 
                }else{
                
                
                }
                
//                
//               for(int i=0;i<30;i++){
//                    System.out.println("saca de desAlfa "+AscAl2.Val(i));
//                
//                }
//                
                
                
                
                break;
            case "artista":
                
                
                
                
                
                
                
                 for(int i=0;i<30;i++){
                     System.out.println("valores que prueba "+tar.Val(i));
                if(tar.Val(i)!=null){
                    bandera=1;
                String temp = (String)tar.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl3 =null;
                if(bandera==1){
                 AscAl3 = DesPAlfa(posi,info);
                 
                 
                 
                 
                 
                 tartista = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 tartista[i][0]=Integer.toString(i);
                 tartista[i][1]=(String)AscAl3.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl3.Val(i)==null)){
                        }else{
                            
                            if(tar.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl3.Val(i)).equals(tar.Val(j))){
                                  
                                tartista[i][2]= Integer.toString((int)artsuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                 
                 
                 
                 
                 
                 
                }else{
                  
                }
                
                
//               for(int i=0;i<30;i++){
//                    System.out.println("saca de desAlfa "+AscAl3.Val(i));
//                
//                }
                
                
                
                
                
                
                
                
                
                break;
            default:
                
                break;
        }
        
        
        
        
    }
     private Array2 DesPAlfa( Array2 num,Array2 info  )
    {
         int i;
         boolean flag = true;
         int temp;
         String tempo;
         
         while ( flag )
         {
                flag = false;  
                for( i=0;  i < 30-1;  i++ )
                {
                    
                    if(num.Val(i+1)!=null){
                    
                       if ( ((int)num.Val(i)) < ((int)num.Val(i+1)) )
                       {
                               tempo = (String)info.Val(i);
                               temp = (int)num.Val(i); 
                               
                               info.Add(info.Val(i+1), i);
                               num.Add(num.Val(i+1), i);
                               
                               info.Add(tempo, i+1);
                               num.Add(temp, i+1);
                               
                              flag = true; 
                      } 
                       
                    }else{
                    
                    }
                       
                       
                } 
          } 
         return info;
    }
     
     
     
    
     
     ///para des
     
     private void ordenaAsc(String tipo){
    String [] abece= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    //sino ponerlo mas add
    Array2 posi = new Array2(30);
    Array2 info = new Array2(30);
    
    int bandera =0;
    int contador=0;
    
    String [] split;
    
        if(null != tipo)switch (tipo) {
            
            case "cancion":
                
                
                
                for(int i=0;i<30;i++){
                if(tc.Val(i)!=null){
                    bandera=1;
                String temp = (String)tc.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl =null;
                if(bandera==1){
                 AscAl = AscPAlfa(posi,info);
                 
                 
                 
                 
                 
                 tcancion = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 tcancion[i][0]=Integer.toString(i);
                 tcancion[i][1]=(String)AscAl.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl.Val(i)==null)){
                        }else{
                            
                            if(tc.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl.Val(i)).equals(tc.Val(j))){
                                  
                                tcancion[i][2]= Integer.toString((int)csuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                 
                 
                 
                 
                }else{
                
                
                }
               
//                
//                for(int i=0;i<30;i++){
//                    System.out.println("saca de ascAlfa "+AscAl.Val(i));
//                
//                }
                
                
                //meter a una tabla para  mostrar 
                
                
                break;
            case "album":
                
                
                
                 for(int i=0;i<30;i++){
                     System.out.println("valores que prueba "+tal.Val(i));
                if(tal.Val(i)!=null){
                    System.out.println("valores que dentro "+tal.Val(i));
                    bandera=1;
                String temp = (String)tal.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                    System.out.println("compara abece " +abece[j]);
                    System.out.println("con  "+split[0]);
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    break;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl2 =null;
                if(bandera==1){
                 AscAl2 = AscPAlfa(posi,info);
                 
                 
                 talbum = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 talbum[i][0]=Integer.toString(i);
                 talbum[i][1]=(String)AscAl2.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl2.Val(i)==null)){
                        }else{
                            
                            if(tal.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl2.Val(i)).equals(tal.Val(j))){
                                  
                                talbum[i][2]= Integer.toString((int)alsuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                 
                 
                 
                 
                 
                 
                 
                }else{
                
                
                }
                
                
//               for(int i=0;i<30;i++){
//                    System.out.println("saca de desAlfa "+AscAl2.Val(i));
//                
//                }
                
                
                
                
                break;
            case "artista":
                
                
                
                
                
                
                
                 for(int i=0;i<30;i++){
                     System.out.println("valores que prueba "+tar.Val(i));
                if(tar.Val(i)!=null){
                    bandera=1;
                String temp = (String)tar.Val(i);
                split = temp.split("");
                
                for(int j=0;j<26;j++){
                
                    if(abece[j].equals(split[0].toLowerCase())){
                    
                        posi.Add(j, contador);
                        info.Add(temp, contador);
                        
                    contador++;
                    }else{
                    
                    }
                
                    
                }
                
                }else{
                }
                    
                }
//                
//                for(int j=0;j<26;j++){
//                    
//                    System.out.println("posiciones despues "+posi.Val(j));
//                }
                
                 Array2 AscAl3 =null;
                if(bandera==1){
                 AscAl3 = AscPAlfa(posi,info);
                 
                 
                 
                 
                 
                  tartista = new String[30][3]; 
                
                 for(int i=0;i<30;i++){
                 
                 tartista[i][0]=Integer.toString(i);
                 tartista[i][1]=(String)AscAl3.Val(i);
                 //tcancion[i][2]=
                         
                         
                       for(int j=0;j<30;j++){
                        if(((String)AscAl3.Val(i)==null)){
                        }else{
                            
                            if(tar.Val(j)==null ){
                            
                            }else{
                                
                                if(((String)AscAl3.Val(i)).equals(tar.Val(j))){
                                  
                                tartista[i][2]= Integer.toString((int)artsuma.Val(j));
                                
//                                    System.out.println("encontro uno igual"+csuma.Val(j));
                                break;
                                }else{

                                }

                            }

                    }
                    }
                       
                       
                         
                         
                         
                 }
                 
                 
                 
                 
                 
                }else{
                
                
                }
                
                
               
                
                
                
                
                
                
                
                
                
                break;
            default:
                
                break;
        }
        
        
        
        
    }
     private Array2 AscPAlfa( Array2 num,Array2 info  )
    {
         int i;
         boolean flag = true;
         int temp;
         String tempo;
         
         while ( flag )
         {
                flag = false;  
                for( i=0;  i < 30-1;  i++ )
                {
                    
                    if(num.Val(i+1)!=null){
                    
                       if ( ((int)num.Val(i)) > ((int)num.Val(i+1)) )
                       {
                               tempo = (String)info.Val(i);
                               temp = (int)num.Val(i); 
                               
                               info.Add(info.Val(i+1), i);
                               num.Add(num.Val(i+1), i);
                               
                               info.Add(tempo, i+1);
                               num.Add(temp, i+1);
                               
                              flag = true; 
                      } 
                       
                    }else{
                    
                    }
                       
                       
                } 
          } 
         return info;
    }
     
     
     
}



