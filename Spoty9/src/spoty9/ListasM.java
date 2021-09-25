
package spoty9;


public class ListasM {
    //EN ESTA CLASE VA TODAS LAS CANCIONES QUE SE USARAN
    //PERO NO SON LAS LISTAS DE REPRODUCCION/
    //SOLO CONSULTA+++++++++++++++++++++++++
}




    class NodoArtista{
     String artista;
     
     
     NodoArtista next;
     NodoArtista ant;
     NodoArtista(String a)
     {
      artista=a;
      
      ant=null;
      next=null;
     }
    }



class ListaArtista{
  public static NodoArtista primero;
  public static NodoArtista ultimo;
 
 
    ListaArtista(){
     primero=null;
     ultimo=null;
    }
  
 public boolean estavacio(){
     
  if(primero==null) return true;
  else return false;
  
 }

    public void AgregaArtista(String dat){
        
     if(estavacio()){
      NodoArtista nuevo=new NodoArtista(dat);
      
      primero=nuevo;//pero esta vacio
      ultimo=nuevo; //pero esta vacio
      
      nuevo.next=nuevo; //esta lleno
      nuevo.ant=nuevo;  //esta lleno
      
     }else{
         
      NodoArtista nuevo=new NodoArtista(dat);
      
      ultimo.next=nuevo;//pero vacio
      nuevo.ant=ultimo; //nodo anterior
      
      primero.ant=nuevo;  //nuevo configurado con el nodo anterior
      nuevo.next=primero; //nuevo configuado para el siguiente
      ultimo=nuevo;       //configura que el ultimo es el primero
     }

     
     
     
    }

    public void eliminaArtista(int dat){
        
     NodoArtista actual=primero;
     NodoArtista anterior;
     NodoArtista siguiente;
     
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
     
  
    
     
}
///////////

    class LAlbum {
                public String album;
                
                
                
                public  LAlbum siguiente;
                public LAlbum anterior;
                
                public static   LAlbum ultimo;


        public void insertarInicio(String d){
                LAlbum nuevo = new LAlbum();
                nuevo.album=d;

                if(ultimo==null){

                ultimo=nuevo;
                Radio.datos=1;
                }else{

                nuevo.siguiente=ultimo;
                ultimo.anterior=nuevo;
                
                ultimo=nuevo;
                }
                }

        public void imprimir(){
        LAlbum aux;
        aux=ultimo;


        while(aux!=null){

         System.out.println(aux.album);
         aux=aux.siguiente;

            }


     }



    }


///////

    class Lcancion {
                 String cancion;
                public  Lcancion siguiente;
                public static Lcancion ultimo;


        public void insertarInicio(String d){
                Lcancion nuevo = new Lcancion();
                nuevo.cancion=d;

                if(ultimo==null){

                ultimo=nuevo;

                }else{
                 
                nuevo.siguiente=ultimo;
                ultimo=nuevo;

                }
                }



        public void imprimir(){
        Lcancion aux;
        aux=ultimo;


        while(aux!=null){

         System.out.println(aux.cancion);
         aux=aux.siguiente;

            }


     }



    }