
package spoty9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NuevaListaReproduccion {
    
    
    JFrame nuevo;
    JPanel nupanel;
    JComboBox tipolista ;
    JLabel a1,a2;
    JTextArea muestra;
    JScrollPane scroll,scroll2;
    DefaultTableModel modelo;
    JTextField caja;
    JButton boton,boton2;
    JTable tablamusica,tsugerencia;
    String [][] arregloaux;
    
    
    String [][] enca2 ;
    String [][] enca22 ;
    int fila  =0;
    int colum =0;
    static Array2 Listas;
    
    int contador;
    
    JComboBox ca;
    
    
    
    
    NuevaListaReproduccion(){
        contador=0;
    Listas = new Array2(30);
    
        
    enca2 = new String[30][5];
    enca22 = new String[30][5];
    
    
    componentes();
    //ventana2();
    
    tabla2();
    
    }
    
    
    
    
    private void componentes(){
        
    nuevo = new JFrame("Nueva lista");
    nuevo.setBounds(350, 150, 650, 400);
    nuevo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    nuevo.setResizable(false);
    nuevo.setVisible(false);
    
    
    
    nupanel = new JPanel();
    nupanel.setLayout(null);
    
    nuevo.add(nupanel);
    
    
    a1= new JLabel("Seleccione Estructura:");
    a1.setBounds(10, 10, 150, 20);
    
    
    
    
    tipolista = new JComboBox();
    tipolista.setBounds(150, 10, 100, 20);
    tipolista.addItem("----");
    tipolista.addItem("PILA");
    tipolista.addItem("COLA");
    tipolista.addItem("D.E.C.");
    
    muestra = new JTextArea();
    muestra.setBounds(50, 100, 300, 300);
    
    String []enca = {"Id","Artista","Album","Cancion","Check"};
    
    
    
    //consulta();
    consulta2();
    tablamusica = new JTable(enca2,enca);
    tablamusica.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            
            
      }
        });
    
    
    
    
    
    TableColumn sportColumn = tablamusica.getColumnModel().getColumn(4);
    ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Add");
    ca.addItem("Remove");
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    scroll = new JScrollPane(tablamusica);
    scroll.setBounds(20, 80,300, 200);
   //tipolista.setBounds(150, 10, 100, 20);
    a2 = new JLabel("Nombre Lista:");
    a2.setBounds(310, 10, 100, 30);
    
    caja = new JTextField();
    caja.setBounds(430, 10, 100, 20);
    
    JLabel asd = new JLabel("SUGERENCIAS");
    asd.setBounds(335, 50, 300, 20);
    
    JLabel asds = new JLabel("CANCIONES");
    asds.setBounds(20, 50, 300, 20);
    
    nupanel.add(asd);
    nupanel.add(asds);
    
    
    
    
    boton = new JButton("Crear");
    boton.setBounds(275,283,100,30);
    
    
    boton2 = new JButton("Actualizar");
    boton2.setBounds(275,320,100,30);
    boton2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           scroll2.setVisible(false);
            nupanel.remove(scroll2);
            tabla2();
            
        }
    
    
    });
    
    
    //nupanel.add(muestra);
    nupanel.add(tipolista);
    nupanel.add(a1);
    nupanel.add(a2);
    nupanel.add(scroll);
    nupanel.add(caja);
    nupanel.add(boton);
    nupanel.add(boton2);
    boton();
    //muestra.setVisible(true);
    tipolista.setVisible(true);
    a1.setVisible(true);
    scroll.setVisible(true);
    
    nupanel.repaint();
    
    
    }
    
    
    private void tabla2(){
    consulsuge();
    
    String []enca = {"Id","Artista","Album","Cancion","Check"};
    
    tsugerencia = new JTable(enca22,enca);
    tsugerencia.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            
            
      }
        });
    
    
    
    
    
    TableColumn sportColumn = tsugerencia.getColumnModel().getColumn(4);
    JComboBox ca = new JComboBox();
    ca.addItem("----");
    ca.addItem("Add");
    ca.addItem("Remove");
    ca.setSize(10,10);
    sportColumn.setCellEditor(new DefaultCellEditor(ca));
    ca.setVisible(true);
    
    
    
    
    scroll2 = new JScrollPane(tsugerencia);
    scroll2.setBounds(335, 80, 300, 200);
    scroll2.setVisible(true);
    nupanel.add(scroll2);
    
    }
    
    
    private void consulsuge(){
    
    int contador=0;
        if(frame.segundalista==0){
        
        
        }else{
            scroll2.setVisible(false);
        nupanel.remove(scroll2);
        
        for(int i =frame.contador1;i<30;i++){
        
            enca22[contador][0]=Integer.toString(contador);
            enca22[contador][1]=(String)frame.rArtista.Val(i);
            enca22[contador][2]=(String)frame.rAlbum.Val(i);
            enca22[contador][3]=(String)frame.rCancion.Val(i);
            contador++;
        
        }
        
        
        
        }
        
    
    
    }
    
    
    
    public void boton(){
    boton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String seleccion = (String)tipolista.getSelectedItem();
            String nombrelis = (String) caja.getText();
            
            caja.setText("");
            tipolista.removeAllItems();
            tipolista.addItem("----");
            tipolista.addItem("PILA");
            tipolista.addItem("COLA");
            tipolista.addItem("D.E.C.");
            
            
            
            switch (seleccion) {
                case "----":
                    
                    break;
                case "PILA":
                    
                    
                   
                    Pila pil = new Pila();
                    pil.Nombre=nombrelis;
                    
                    //consulta();
                    consulta2();
                    llenalista();
                    
                    
                    for(int i=0;i<=29;i++){
                         
                        if(arregloaux[i][0]==null){
                        
                        }else{
                            Array2 datos = new Array2(3);
                        datos.Add(arregloaux[i][0], 0);
                        datos.Add(arregloaux[i][1], 1);
                        datos.Add(arregloaux[i][2], 2);
                        
                        pil.push(datos);
                        frame.removelist.setEnabled(true);
                        }
                  }
                    
                    Listas.Add(pil,contador);
                    
                    contador++;

                    break;
                    
                    
                    
                    
                case "COLA":
                    
                     
                    
                     Cola col = new Cola();
                     col.Nombre=nombrelis;
                     
                     //consulta();
                     consulta2();
                     llenalista();
                     
                    for(int i=0;i<=29;i++){
                        System.out.println(" trae arreglo "+arregloaux[i][0]);
                    }
                    for(int i=0;i<=29;i++){
                        
                        if(arregloaux[i][0]==null){
                        
                        }else{
                            Array2 datos2 = new Array2(3);
                            datos2.Add(arregloaux[i][0], 0);
                            datos2.Add(arregloaux[i][1], 1);
                            datos2.Add(arregloaux[i][2], 2);
                            
                         col.Add(datos2);
                        }
                   }
            {
                try {
                    Cola test = (Cola)col.clone();
                    Array2 a1 = (Array2)test.Pop();
                    Array2 a2 = (Array2)test.Pop();
                    
                    System.out.println("saca primero "+a1.Val(0));
                    System.out.println("saca segundo "+a2.Val(0));
                    
                    
                    
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(NuevaListaReproduccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
            
                    
                    
                    
                    
                   Listas.Add(col, contador);
                   contador++;
                   frame.removelist.setEnabled(true);
                   
                   
                   
                    break;
                    
                    
                    
                    
                case "D.E.C.":
                    
                    
                    Circular circular = new Circular();
                    circular.Nombre=nombrelis;
                    
                    //consulta();
                    consulta2();
                    
                    llenalista();
                    
                    
                    for(int i=0;i<=29;i++){
                        if(arregloaux[i][0]==null){
                        }else{
                            Array2 datos3 = new Array2(3);
                            datos3.Add(arregloaux[i][0], 0);
                            datos3.Add(arregloaux[i][1], 1);
                            datos3.Add(arregloaux[i][2], 2);
                            //datos3.Add(nombrelis, 3);
                            circular.Agrega(datos3);
                       }
                    }
                    
                    Listas.Add(circular.ultimo, contador);
                    contador++;
                    
                    frame.removelist.setEnabled(true);
                    
                    break;
                    
                    
                default:
                    
                    break;
            }
            
            
            trae();
            consulList();
            
        }
    
    
    });
    
    
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
    
    
    
    public void consulta2(){
    
        
try{
            

    boolean bandera = false;
        
        int contador=0;
        Array2 temp1=null;
        Array2 temp2=null;
        Array2 temp3=null;    
                
        
            temp1 = (Array2)frame.rArtista.clone();
            temp2 = (Array2)frame.rAlbum.clone();
            temp3 = (Array2)frame.rCancion.clone();
    
        if(temp1!=null){
      while(!bandera){
          if(contador>=(frame.contador1-1)){
          bandera=true;
          }else{
          
          }
  

          if(temp1.Val(contador)==null){
          bandera=true;
          }else{

          enca2[contador][0]=Integer.toString(contador);
          enca2[contador][1]=(String)temp1.Val(contador);
         enca2[contador][2]=(String)temp2.Val(contador);
          enca2[contador][3]=(String)temp3.Val(contador);
        
              contador++;
          
          }
          
      }
        }else{
        
        }
        
        
    }catch(Exception asdfs){
        
        
    }
    }
    
    
    private void llenalista(){
        
    arregloaux = new String[30][3];
    
    for(int i=0;i<=29;i++){
    
    if(enca2[i][4]==null){
        System.out.println(" no hay nada en la enca");
        
    }else{
        
    if(enca2[i][4].equals("Add")){
    
        for(int j=0;j<=29;j++){
            System.out.println("hallo algo adsfasdf");
            if(arregloaux[j][0]==null){
            
        arregloaux[j][0]=enca2[i][1];
        arregloaux[j][1]=enca2[i][2];
        arregloaux[j][2]=enca2[i][3];
                System.out.println("asdfasd  ssss "+arregloaux[j][0] +" num"+i);
                break;
            }else{
            
            }
        
        }
    }else{
    }
        
    }
    
    }
    
    
    for(int i=0;i<=29;i++){
    
    if(enca22[i][4]==null){
        System.out.println(" no hay nada en la enca22");
        
    }else{
        
    if(enca22[i][4].equals("Add")){
    
        for(int j=0;j<=29;j++){
            System.out.println("hallo algo adsfasdf");
            if(arregloaux[j][0]==null){
            
        arregloaux[j][0]=enca22[i][1];
        arregloaux[j][1]=enca22[i][2];
        arregloaux[j][2]=enca22[i][3];
                System.out.println("asdfasd  ssss "+arregloaux[j][0] +" num"+i);
                break;
            }else{
            
            }
        
        }
    }else{
    }
        
    }
    
    }
    
    
    
    
    
    
    
    
    }
    
    private void trae(){
    for(int i=0;i<=29;i++){
        System.out.println("valor matriz"+Listas.Val(i));
    }
    
    }
    
    
    
    
    
    
    private void consulList(){
    Array2 temp  = NuevaListaReproduccion.Listas;
    
    
    
    frame.combox.removeAllItems();
    
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
                frame.combox.addItem((String) saca1.Nombre);
                System.out.println("valro que ingresa "+(String)saca1.Nombre);
                break;
            case 1:
                frame.combox.addItem((String) saca2.Nombre);
                System.out.println("valro que ingresa "+(String)saca2.Nombre);
                break;
            case 2:
                frame.combox.addItem((String) saca3.Nombre);
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
    
    
    frame.panel.repaint();
    
    
    
    }

}