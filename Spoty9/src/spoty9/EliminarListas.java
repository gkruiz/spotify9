
package spoty9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




public class EliminarListas {
    
    
    
    JFrame nuevo;
    JPanel nupanel;
    JComboBox tipolista ;
    JLabel a1,a2;
    JTextArea muestra;
    JScrollPane scroll;
    DefaultTableModel modelo;
    JTextField caja;
    JButton boton;
    JTable tablamusica;
    
    
    int tiplist =-8;
    String [][] Aux;
    String [][] enca2 ;
    int fila  =0;
    int colum =0;
    
    
    static String selec =null;
    
    String Objetob=null;
    
    String sal=null;
    
    
    
    
    boolean paso=false;
    
        EliminarListas(){
        enca2 = new String[30][5];
        componentes();
            }
    
    
    
    
    private void componentes(){
        
    nuevo = new JFrame("Elimina lista");
    nuevo.setBounds(500, 150, 400, 400);
    nuevo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo.setResizable(false);
    nuevo.setVisible(false);
    
    
    
    nupanel = new JPanel();
    nupanel.setLayout(null);
    
    nuevo.add(nupanel);
    
    
    a1= new JLabel("Seleccione Lista:");
    a1.setBounds(10, 10, 150, 20);
    
    
    
    
    tipolista = new JComboBox();
    tipolista.setBounds(150, 10, 100, 20);
    tipolista.addItem("----");
    tipolista.addItem("lias ata");
    tipolista.addItem("lista asdf");
    tipolista.addItem("lista asdf");
    
    
    consulList();
    
    tablad();
    tipolista.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            String selecion = (String)tipolista.getSelectedItem();
            Objetob=selecion;
            System.out.println("selecciono "+selecion);
            
            enca2 = new String[30][5];
            try {
                consulta(selecion);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            scroll.setVisible(false);
            nupanel.remove(scroll);
            
            
            
            tablad();

        }
        
        
    });
    
    
    
    boton = new JButton("Elminar");
    boton.setBounds(150,305,100,30);
    
    
    
    
    nupanel.add(tipolista);
    nupanel.add(a1);
    nupanel.add(boton);
    
    
    tipolista.setVisible(true);
    a1.setVisible(true);
    
    
    nupanel.repaint();
    boton();
    
    }
    
    
    
    //metodos para consulta de listas++++++++++++++++++++++++
    private void tablad(){
    
        String []enca = {"Id","Artista","Album","Cancion","Check"};
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
    ca.addItem("Remove");
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(50, 95, 300, 200);
    nupanel.add(scroll);
    scroll.setVisible(true);
    
    }
    
    public void boton(){
    boton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("--------------------------------------------------------------------------99999999999999999999999999999999");
            int contax =0;
            Aux= new String[30][3]; 
            
            
            
            
            
            for(int i=0;i<30;i++){
                if(enca2[i][4]==null){
                 //  System.out.println(" es nulo la calislla");
                }else{
                   // System.out.println(" no es nulo , pero no es igual es "+enca2[i][4]);
                if(enca2[i][4].equals("Remove")){
                    
                //System.out.println(" lleno en arreglo aux "+enca2[i][4]);
                    Aux[contax][0]=enca2[i][1];
                    Aux[contax][1]=enca2[i][2];
                    Aux[contax][2]=enca2[i][3];
                    contax++;
                }else{
                }
                
                
                
                }
            }
            
//            
//            for(int i=0;i<30;i++){
//                System.out.println("preconsulta  ");
//                System.out.println(" asdfsdf arreglo aux "+Aux[i][0]);
//                System.out.println(" asdfsdf arreglo aux "+Aux[i][1]);
//                System.out.println(" asdfsdf arreglo aux "+Aux[i][2]);
//                
//                
//                
//            }
//            
            
            
            
            for(int i=0;i<30;i++){
              //  System.out.println("valor arreglo aux "+Aux[i][0]);
             //   System.out.println("for valor i  "+i);
                if(Aux[i][0]!=null){
                  //  System.out.println(" consulta arreglo aux para igresar info");
                BuscaElimina(Objetob,Aux[i][0],Aux[i][1],Aux[i][2]);
                  //  System.out.println(" mete valor no nulo");
                }else{
                  //  System.out.println(" arreglo aux vacio");
                }
            }
            
            
            
            //declarar una variable global nombre para poder buscar lista
            //BuscaElimina();
            //meter valore de matriz para buscar y eliminar de lo que sea
            //ver si nombre se metio poqe sino no se podra consultar otra vez
            
            
            // System.out.println("--------------------------------------------------------------------------99999999999999999999999999999999");
        }
    
    
    });
    
    
    }
    
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
    
    
    private void consulList(){
    Array2 temp  = NuevaListaReproduccion.Listas;
    
    
    
    tipolista.removeAllItems();
    
    boolean ban = false;
    int conta=0;
    int es =-8;
    Pila saca1 = null;
    Cola saca2 =null;
    NCircular saca3 = null;
    Array2 temps = new Array2(30);
    
    int incre=0;
    
    Object can=null ;
    
        System.out.println("trae lista "+temp.Val(0));
    
    
    while(!ban){
        es=-8;
        can = temp.Val(conta);
        if(can!=null){
            
        try{
        saca1 = (Pila)temp.Val(conta);
        //saca1.peek();
        
        es=0;
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
        }catch(Exception a1mn){
           // System.out.println("no es cola");
            //es=-8;
        }
        System.out.println("es seguido "+es);
        
        try{
        saca3 = (NCircular)temp.Val(conta);
        es=2;
        System.out.println(" es circu--------------------------"+saca3.Nombre);
        }catch(Exception a1u){
            
            //.out.println("no es Circular");
        }
        
        
        
        System.out.println("valor es "+es);
        switch (es) {
            case 0:
                tipolista.addItem((String) saca1.Nombre);
                System.out.println("valro que ingresa "+(String)saca1.Nombre);
                break;
            case 1:
                tipolista.addItem((String) saca2.Nombre);
                System.out.println("valro que ingresa "+(String)saca2.Nombre);
                break;
            case 2:
                tipolista.addItem((String) saca3.Nombre);
                System.out.println("valro que ingresa "+(String)saca3.Nombre);
                break;
            default:
                
                ban=true;
                break;
        }
        
        
        
        if(incre>30){
        ban=true;
        }else{
        conta++;
        }
        
        
        
            }else{
            ban=true;
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
              
          enca2[contador][0]=temp1;
          enca2[contador][1]=temp2;
         enca2[contador][2]=temp3;
          enca2[contador][3]=temp4;
          
          
             
              
              
              
              contador++;
          
              
              
          }
           System.out.println("consulto en PILA----00000000000000000000000000000000---"+enca2[contador][0]);
      }
        System.out.println("valro status pila "+aux.empty());
    
    scroll.setVisible(false);
    nupanel.remove(scroll);
    
    tablad();
    for(int i=0;i<=3;i++){
        System.out.println(" consul matriz "+enca2[i][0]);
    }
    
    }
    
    private void relleCola(Cola cols){
        
        
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
          enca2[contador][0]=temp1;
          enca2[contador][1]=temp2;
         enca2[contador][2]=temp3;
          enca2[contador][3]=temp4;
          
              System.out.println("consulto en cola-------"+temp2);
              
              
              
              contador++;
          
          }
          
      }
   
    for(int i=0;i<=3;i++){
        System.out.println(" consul matriz "+enca2[i][0]);
    }
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
              
          enca2[contador][0]=temp1;
          enca2[contador][1]=temp2;
         enca2[contador][2]=temp3;
          enca2[contador][3]=temp4;
          
          
              System.out.println("consulto en PILA-------"+temp2);
              aux=aux.next;
              //ver porque infinito
              contador++;
          
          
           itero=1;
           }
          
          
      }
    
    }
    
    
  
    private void BuscaElimina(String Nombre,String Artista,String Album,String Cancion){
        System.out.println("inicia buscaeliminar +++++++++++++++++++++++++++++++++-------------------------------------------");
        int contador =0;
        
        Pila pil=null;
        Cola col =null;
        NCircular cir =null;
        
        
        int es=-9;
        
        boolean bandera = false;
        
        int conta =0;
        
       
        
        Cola llena2;
        
        
        
        
        while(!bandera){
            
            
            
            
            Object temp =NuevaListaReproduccion.Listas.Val(contador);
            es=-9;
            
            
            
            if(conta>=30){
            bandera=true;
            }else{
            }
            
            if(temp==null){
            //    System.out.println(" si entro para detner");
            
            break;
            }else{
            }
            
            
            
            
            try{
           
            pil = (Pila)temp;
            es=0;
            Array2 asdf =(Array2)pil.peek();
           // System.out.println("pila eliminar "+asdf.Val(0));
            }catch(Exception as1){

            }
            
            
        
          //  System.out.println("paso con 111/ "+es);
        
        
        
        try{
        col = (Cola)temp;
        es=1;
        
        
        if(col.Nombre=="hla"){
        
        }else{
        
        }
        System.out.println(" es cola-------------------------+++++++++++++++++++++++++++-"+col.Nombre);
        }catch(Exception a1xa){
        }
        System.out.println("paso con 222 /"+es);
        
        
        
        try{
        cir = (NCircular)temp;
        es=2;
        if(cir.Nombre=="hola"){
        }else{
        }
        System.out.println(" es circu-------------------------++++++++++++++++++++++++++++++-"+cir.valor);
        System.out.println(" es circu-------------------------++++++++++++++++++++++++++++++-"+cir.next);
        }catch(Exception a1w){
        }
            
            
        
        
        
            //averigua que es pila cola etc en la arrayx
            
            //Locaiza la lista 
            
            
            llena2=new Cola();
            switch (es) {
                
                case 0:
                    
                    if(pil.Nombre.equals(Nombre)){
                        Pila llena=new Pila();
                        llena.Nombre=Nombre;
                        
                        Pila copia =null;
                try {
                    
                   copia  = (Pila)pil.clone();
                    
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                
                //consulta sus arryas 
                        
                        while(!copia.empty()){
                            
                       //     System.out.println(" valor de empty nose "+copia.empty());    
                        Array2 nose  = (Array2)copia.pop();
                     //       System.out.println(" prueba "+nose.Val(0));
                     //       System.out.println(" prueba "+nose.Val(1));
                     //       System.out.println(" prueba "+nose.Val(2));
                            
                      //      System.out.println("compara que entra1 "+Artista);
                      //      System.out.println("compara que entra2 "+Album);
                      //      System.out.println("compara que entra3 "+Cancion);
                            
                        if(  (((String)nose.Val(0))==Artista)  &&(((String)nose.Val(1))==Album)&&(((String)nose.Val(2))==Cancion)){
                            
                        //    System.out.println("encontro la cancion a eliminar +++++++bueno//////////");
                        
                        }else{
                            llena.push(nose);
                        //    System.out.println("no se hallo-+-+-");
                        
                        }
                        
                        
                        }
                      //  System.out.println(" salio del Ciclo 33333333333333333333333333333333333333333333333333333");
                        
                        //borra el anterior 
                       NuevaListaReproduccion.Listas.Add(llena, contador);
                       
                       
                       
                        break;
                      }else{
                        
                    
                    }
                    
                    break;
                case 1:
                    
                    
                    
                    
                    
                    
                    
                    System.out.println("nombre que busca"+Nombre);
                    if(col.Nombre.equals(Nombre)){
                        System.out.println(" si lo hallo");
                       // Cola llena2=new Cola();
                        llena2.Nombre=Nombre;
                        
                        Cola copia =null;
                        
                        
                try {
                    
                    copia = (Cola)col.clone();
                    
                } catch (CloneNotSupportedException ex) {
                    System.out.println("dio error al clonar666666666666666666");
                    Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                
                //consulta sus arryas 
                        while(!copia.Empty()){
                            
                            
                            
                            
                        Array2 nose = (Array2)copia.Pop();
                       //     System.out.println("saca de nose "+nose.Val(0));
                      //      System.out.println("saca de nose "+nose.Val(1));
                      //      System.out.println("saca de nose "+nose.Val(2));
                            
                     //       System.out.println("saca de trae consul "+Artista);
                     //       System.out.println("saca de nose "+Album);
                     //       System.out.println("saca de nose "+Cancion);
                            
                            
                        if(  (((String)nose.Val(0)).equals(Artista))  &&(((String)nose.Val(1)).equals(Album))&&(((String)nose.Val(2)).equals(Cancion))){
                            
                         //   System.out.println("encontro la cancion a eliminar +++++++bueno//////////+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        
                        }else{
                            llena2.Add(nose);
                            
                        //    System.out.println(" lleno en cola +++++++++++++++++++++++++asfdasdfwer werwasdfasd++++++++++///bueno");
                        
                        }
                        
                      //  System.out.println(" itero dentro mini whiew afdfasdf");
                        }
                     //   System.out.println("contador 66666666666666666666666  +/"+contador);
                        //borra el anterior 
                       NuevaListaReproduccion.Listas.Add(llena2, contador);
                       
//                        Cola use=null;
//                
//                
//                Array sacac = (Array) llena2.Pop();
//                        System.out.println("saco de la copia prueba "+sacac.Val(0));
//                        System.out.println("saco de la copia prueba "+sacac.Val(1));
//                        System.out.println("saco de la copia prueba "+sacac.Val(2));
//                Array sacac2 = (Array) use.Pop();   
//                
//                        System.out.println("saco de la copia prueba22 "+sacac2.Val(0));
//                        System.out.println("saco de la copia prueba22 "+sacac2.Val(1));
//                        System.out.println("saco de la copia prueba22 "+sacac2.Val(2));
                        break;
                      }else{
                        
                    
                    }
                    
                    
                    
                    
                    
                    
                    break;
                case 2:
                    
                    
                    int itero =0;
                    
                    if(cir.Nombre.equals(Nombre)){
                        Circular llena3=new Circular();
                        llena3.Nombre=Nombre;
                        
                        
                        NCircular copia =null;
                        NCircular det =null;
                        
                try {
                    
                    copia = (NCircular)cir.clone();
                    
                    det = (NCircular)cir.clone();
                    
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(EliminarListas.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                
                //consulta sus arryas 
                    int conto =0;
                        while(!(12<conto)){
                            //true
                            
                            conto++;
                            
                        Array2 nose = (Array2)copia.valor;
                        System.out.println("saca de nose **********"+nose.Val(0));
                            System.out.println("saca de nose************ "+nose.Val(1));
                            System.out.println("saca de nose******* "+nose.Val(2));
                            
                            System.out.println("saca de trae consul "+Artista);
                            System.out.println("saca de nose "+Album);
                            System.out.println("saca de nose "+Cancion);
                            
                        
                        if(  (((String)nose.Val(0)).equals(Artista))&&(((String)nose.Val(1)).equals(Album))&&(((String)nose.Val(2)).equals(Cancion))){
                            
                            System.out.println("encontro la cancion a eliminar +++++++bueno//////////");
                        //llena3.Agrega(nose);
                        }else{
                            System.out.println(" ingreso a cicular "+nose.Val(0));
                            System.out.println(" ingreso a cicular "+nose.Val(1));
                            System.out.println(" ingreso a cicular "+nose.Val(2));
                            
                            
                            llena3.Nombre=Nombre;
                            
                            llena3.Agrega(nose);
                            
                            
                        }
                        copia=copia.next;
//                        if((copia.next.valor.equals(det.valor))&&(itero==1)){
//                            break;
//                            
//                            }else{
//                            copia=copia.ant;
//                            itero=1;
//                            }
                            
                        }
                        
                        llena3.Nombre=Nombre;
                        System.out.println("consultando circular "+llena3.ultimo.Nombre);
                        Array2 tempxxx = (Array2)llena3.ultimo.valor;
                        System.out.println("asdf "+tempxxx.Val(0));
                        System.out.println("asdf "+tempxxx.Val(1));
                        System.out.println("asdf "+tempxxx.Val(2));
                        llena3.ultimo=llena3.ultimo.next;
                        Array2 tempxxxx = (Array2)llena3.ultimo.valor;
                        System.out.println("asdf "+tempxxxx.Val(0));
                        System.out.println("asdf "+tempxxxx.Val(1));
                        System.out.println("asdf "+tempxxxx.Val(2));
                        llena3.ultimo=llena3.ultimo.next;
                        Array2 tempxx = (Array2)llena3.ultimo.valor;
                        System.out.println("asdf "+tempxx.Val(0));
                        System.out.println("asdf "+tempxx.Val(1));
                        System.out.println("asdf "+tempxx.Val(2));
                       llena3.ultimo=llena3.ultimo.next;
                        Array2 tempxxc = (Array2)llena3.ultimo.valor;
                        System.out.println("asdf "+tempxxc.Val(0));
                        System.out.println("asdf "+tempxxc.Val(1));
                        System.out.println("asdf "+tempxxc.Val(2));
                        llena3.ultimo=llena3.ultimo.next;
                        Array2 tempxxcc = (Array2)llena3.ultimo.valor;
                        System.out.println("asdf "+tempxxcc.Val(0));
                        System.out.println("asdf "+tempxxcc.Val(1));
                        System.out.println("asdf "+tempxxcc.Val(2));
//                        
                        
                       NuevaListaReproduccion.Listas.Add(llena3.ultimo, contador);
                        
                        
                        
                        break;
                      }else{
                        
                    
                    }
                    
                    
                    
                    
                    break;
                default:
                    
                    
                    break;
            }
        
        
        
        contador++;
        
        
        
        conta++;
        
        
        
        System.out.println("fin iteraci0on mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        }
        
        
        
        
        
        
    System.out.println("fin buscaeliminar +++++++++++++++++++++++++++++++++-------------------------------------------");
     
    }
    
    
}
