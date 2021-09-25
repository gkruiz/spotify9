/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoty9;

/**
 *
 * @author KRUIZ9
 */
public class Grupos {
    
}


class NPila {
public String Nombre =null;
private Object dato;
private NPila next;


public NPila(Object dato){
this.dato=dato;
}
public Object getDato() {
return dato;
}
public void setDato(int dato) {
this.dato = dato;
}
public NPila getNext() {
return next;
}
public void setNext(NPila next) {
this.next = next;
}
public String toString(){
String s=" "+dato+" ";
return s;
}
}



    class Pila implements Cloneable{
     
    public String Nombre =null;
    private NPila cima;
    
    
    public Pila(){
    this.cima=null;
    }
    
    
    private NPila getCima() {
    return cima;
    }
    
    
    private void setCima(NPila cima) {
    this.cima = cima;
    }
    
    
    public void push(Object dato){
        
    NPila i=new NPila(dato);
    i.setNext(this.cima);
    this.cima=i;
    i.Nombre=Nombre;
    
    }
    
    public Object pop(){
    Object dato=cima.getDato();
    this.cima=cima.getNext();
    return dato;
    }
    
    
    public boolean empty() {
        
    if (cima==null) {
        
    System.out.println("La pila esta vacia");
    return true;
    
    } else {
        
    System.out.println("La pila no esta vacia");
    return false;
    
    }
    }
    
    public Object peek(){
     Object dato=cima.getDato();
    
    return dato;
    
    }
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    
    }
//------------------------------------------


    class Nodo {
        
        
    private Object dato;
    
    private Nodo next;
    
    public Nodo(Object dato){
    this.dato=dato;
    }
    
    public Object getDato() {
    return dato;
    }
    
    public void setDato(Object dato) {
    this.dato = dato;
    }
    
    public Nodo getNext() {
    return next;
    }
    
    public void setNext(Nodo next) {
    this.next = next;
    }
    
    
    
        }





    class Cola implements Cloneable{
        
        
    public String Nombre =null;
        
    private Nodo inicio;
    
    private Nodo termino;
    
    
    
    public Cola(){
    inicio=null;
    termino=null;
    }
    
    
    
    public void Add(Object dato){
        
        System.out.println(" paso en grupos parainsertar posible infinito");
    Nodo i=new Nodo(dato);
    i.setNext(null);
    
    
    if(inicio==null & termino==null){
    inicio=i;
    termino=i;
    }
    
    termino.setNext(i);
    termino=termino.getNext();
    }
    
    public Object Pop(){
    Object dato=inicio.getDato();
    inicio=inicio.getNext();
    return dato;
    }
    
    public boolean Empty(){
        
    boolean cola ;
    
    
    if(inicio==null || termino==null){
    cola=true;
    
    
    
    }else{
        
    
    cola=false;
    }
    
    return cola;
    
    }
    
    public int length(){
        
    int contador=0;
    Nodo c=this.inicio;
    
        
    
    while(c!=null){
        System.out.println(" metidp em ciclo");
    contador++;
    c=c.getNext();
    }
    
    return contador;
    }
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
   
    }





//    class NArray{
//        
//        public Object dato;
//        public NArray siguiente;
//        public NArray anterior;
//        public int index;
//    public void ingresa(Object a ,int b){
//    
//    dato=a;
//    index=b;
//    
//    }
//    
//    
//    
//    }

   
    class Array implements Cloneable{
        
    
            
            private NArray ultimo;
            private int tama;
            
            public Array(int tamano){
               // System.out.println("valor trae "+tamano);
            tama=0;
            this.tama=tamano;
            ultimo=null;
            
            int cons =0;
                //crea 
                while(cons<tama){
                crea(null,cons);
                cons++;
                }
            
            
            }
            
    
    public void Add(Object d,int index){
           // System.out.println(" valor compara "+tama);
            if(index>tama){
                //System.out.println("error excede tama;o");
            
            }else{
                
                
                //System.out.println(" valor de ulttimo id "+ultimo.siguiente.siguiente.index);
                while(true){
                   
                
                     if(ultimo.siguiente!=null){
                     ultimo=ultimo.siguiente;
                     }else{
                     break;
                     }
                 
                }
                //busca e ingresar
                
                while(true){
                    
                    if(ultimo.index==index){
                       ultimo.dato=d;
                       
                      // System.out.println(" guarda en  "+index);
                   // System.out.println("valor "+d);
                        break;
                    }else{
                    }
                    
                    if(ultimo.anterior!=null){
                     ultimo=ultimo.anterior;
                     }else{
                        
                     break;
                     
                     }
                    
                    
                
                }
                
                while(true){
                    
                    
                    if(ultimo.siguiente!=null){
                        
                     ultimo=ultimo.siguiente;
                        
                     }else{
                     break;
                     }
                
                }
                
                
                
            
            
            }
            
            
            
            
            }
    
    
    private void crea(Object d , int index){
    
    NArray nuevo = new NArray();
            nuevo.ingresa(d, index);
            
            if(ultimo==null){
                
            ultimo=nuevo;
            
            }else{
                
            nuevo.siguiente=ultimo;
            ultimo.anterior=nuevo;
            ultimo=nuevo;
            
            }
    }
    
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    
    
    
    
    
    
    
    
    
    public Object Val(int a){
        
        
        
        
    NArray aux;
    aux=ultimo;
    boolean paso =false;
    Object retor=null;

    int con =0;
    
    while(true){
        
        //System.out.println("varlo pero detnro martriz "+aux.dato);
        if(a>=tama){
              //  System.out.println("error excede tama;o");
            break;
            }else{
            
        if(con>tama){
        
         break;
        }else{
            
            
            
        if(paso){
        aux=aux.anterior;
        //paso=false;
        
        
        }else{
        paso=true;
        
        }
        
        }
        
        con++;
        
        //System.out.println(" valor a "+a);
        int temp = (int)aux.index;
        
        if(temp==a ){
            
            
        retor= aux.dato;
          //  System.out.println("halo unoasdfasd "+aux.dato);
            break;
        }else{
            
          //  System.out.println(" nada "+ultimo.dato);
          //  System.out.println(" indexxx " +ultimo.index);
        }
        
        
        
        
        
        
        
        
        
     
    }
        
        
        
        }
        
            return retor;     
 }
    
    
    
    
    
    class NArray implements Cloneable{
        
        private Object dato;
        public  NArray siguiente;
        public NArray anterior;
        public int index;
    public void ingresa(Object a ,int b){
    dato=null;
    index=999999;
        
        
    dato=a;
    index=b;
    
    }
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
}
//--------------circular
class NCircular implements Cloneable{
     String Nombre =null;
     Object valor;
     NCircular next;
     NCircular ant;
     
     
     NCircular(Object a)
     {
      valor=a;
      
      
      
      ant=null;
      next=null;
     }
     
     @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    }

class Circular implements Cloneable{
    public String Nombre =null;
 NCircular primero;
 NCircular ultimo;
 
    Circular(){
        
     primero=null;
     ultimo=null;
    }
  
    public boolean estavacio(){

     if(primero==null) return true;
     else return false;

    }

    public void Agrega(Object val){
        
     if(estavacio()){
      NCircular nuevo=new NCircular(val);
      nuevo.Nombre=Nombre;
      primero=nuevo;//pero esta vacio
      ultimo=nuevo; //pero esta vacio
      
      nuevo.next=nuevo; //esta lleno
      nuevo.ant=nuevo;  //esta lleno
      
     }else{
         
      NCircular nuevo=new NCircular(val);
      nuevo.Nombre=Nombre;
      ultimo.next=nuevo;//pero vacio
      nuevo.ant=ultimo; //nodo anterior
      
      primero.ant=nuevo;  //nuevo configurado con el nodo anterior
      nuevo.next=primero; //nuevo configuado para el siguiente
      ultimo=nuevo;       //configura que el ultimo es el primero
     }

     
     
     
    }

    public void eliminaArtista(int dat){
        
     NCircular actual=primero;
     NCircular anterior;
     NCircular siguiente;
     
     for(int i=0;i<=dat;i++){
         
      if(actual==ultimo){
          
       if(i<dat) {
           
       }else{
           
        if(i==dat){
         anterior=actual.ant;
         anterior.next=primero;
         primero.ant=anterior;
         ultimo=anterior;
        
        }
         
       }
       
      }else{
          
       if(dat==0){
        siguiente=actual.next;
        siguiente.ant=ultimo;
        ultimo.next=siguiente;
        primero=siguiente;
        
       }
       if(dat==i){
        anterior=actual.ant;
        siguiente=actual.next;
        anterior.next=siguiente;
        siguiente.ant=anterior;
       
       }
       
      }
      
      actual=actual.next;
     }
     
    }
     
     
    public void imprimir(){
  NCircular actual;
  actual=primero;
  NCircular det=primero;
  //actual!=ultimo
  int contador=0;
  boolean bandera=false;
  while(det==primero){
      
      
      contador++;
  // System.out.println(actual.artista);
   actual=actual.ant;
  }
      //  System.out.println(actual.artista);
                 
 }
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
     
}

//////////////////////////////////aray dos pureba


   
    class Array2 implements Cloneable{
        
    
            
            private NArray ultimo;
            private int tama;
            
            public Array2(int tamano){
               // System.out.println("valor trae "+tamano);
            tama=0;
            this.tama=tamano;
            ultimo=null;
            
            int cons =0;
                //crea 
                while(cons<tama){
                crea(null,cons);
                   // System.out.println(" ingresa cons "+cons);
                cons++;
                }
            
            
            }
            
    
    public void Add(Object d,int index){
           // System.out.println(" valor compara "+tama);
            if(index>tama){
                //System.out.println("error excede tama;o");
            
            }else{
                
                
                //System.out.println(" valor de ulttimo id "+ultimo.siguiente.siguiente.index);
                while(true){
                   
                
                     if(ultimo.siguiente!=null){
                     ultimo=ultimo.siguiente;
                     }else{
                     break;
                     }
                 
                }
                //busca e ingresar
                
                while(true){
                    
                    if(ultimo.index==index){
                       ultimo.dato=d;
                       
                      // System.out.println(" guarda en  "+index);
                   // System.out.println("valor "+d);
                        break;
                    }else{
                    }
                    
                    if(ultimo.anterior!=null){
                     ultimo=ultimo.anterior;
                     }else{
                        
                     break;
                     
                     }
                    
                    
                
                }
                
                while(true){
                    
                    
                    if(ultimo.siguiente!=null){
                        
                     ultimo=ultimo.siguiente;
                        
                     }else{
                     break;
                     }
                
                }
                
                
                
            
            
            }
            
            
            
            
            }
    
    
    private void crea(Object d , int index){
    
    NArray nuevo = new NArray();
        //System.out.println(" ingresa index en crea "+index);
            nuevo.ingresa(d, index);
            
            if(ultimo==null){
                
            ultimo=nuevo;
            
            }else{
                
            nuevo.siguiente=ultimo;
            ultimo.anterior=nuevo;
            ultimo=nuevo;
                //System.out.println("valor index ultimo "+ultimo.index);
            }
            //System.out.println("rerona el valor de index matriz "+ultimo.index);
            //retorna inicio
            
            
            
            
            
            
    }
    
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    
    
    public Object Val(int a){
        
        
        
        
    
    boolean paso =false;
    Object retor=null;
    int temp ;
    int con =0;
    
    
    while(true){
                
                if(ultimo.siguiente==null){
                break;
                }else{
                ultimo=ultimo.siguiente;
                    //System.out.println("index "+ultimo.index);
                }
            
            }
    
    NArray aux;
    aux=ultimo;
    
    
    while(true){
        
        
        
        //System.out.println("varlo pero detnro martriz "+aux.dato);
        if(a>=tama){
              //  System.out.println("error excede tama;o");
            break;
            }else{
            
        if(con>tama){
        
         break;
        }else{
            
            
        if(paso){
        aux=aux.anterior;
        //aux=aux.siguiente;
        //paso=false;
        }else{
        paso=true;
        
        }
        
        }
        
        con++;
        
        //System.out.println(" valor a "+a);
        
           // System.out.println("valor index "+aux.index);
            temp =0;
        temp = aux.index;
        
        
        
        if(temp==a ){
            
            
        retor= aux.dato;
          //  System.out.println("halo unoasdfasd "+aux.dato);
            break;
        }else{
            
          //  System.out.println(" nada "+ultimo.dato);
          //  System.out.println(" indexxx " +ultimo.index);
        }
        
        
        
        
        
        
        
        
        
     
    }
        
        
        
        }
        
            return retor;     
 }
    
    
    
    
    }




    class NArray implements Cloneable{
        
        
         Object dato;
        public  NArray siguiente;
        public NArray anterior;
         int index;
        
    public void ingresa(Object a ,int b){
    dato=null;
    index=999999;
        
    //    System.out.println("reciben en la clase "+b);
    dato=a;
    this.index=b;
       // System.out.println("valro de index en clase "+index);
    }
    
    @Override
      public Object clone() throws CloneNotSupportedException{
          Object obj =null;
      try{
          obj =super.clone();
      }catch(Exception ew){
          System.out.println(" no se clona");
      }
      return obj;
   }
    
    
    
    }
    
    