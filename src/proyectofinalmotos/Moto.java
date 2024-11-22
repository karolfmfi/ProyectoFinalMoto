
package proyectofinalmotos;

import java.util.Stack;


public class Moto {
    
    
    
    //Declaramos las variables
    
    private String vin;
    private String marca;
    private String linea;
    private int cilindraje;
    private int modelo;
    private String fechaingreso;
    private Float precio;
    private String Cliente;

    
    
    
    
     ///Creamos la pila de tipo objeto que se almacenara mas de un atributo 
    ///en cada posicion de la pila
    
    Stack<Moto> Motos=new Stack<Moto>();
    
    ///creamos otra donde se almacenaran las motos vendidas
    
     Stack<Moto> MotosVendidas=new Stack<Moto>();
    
     
     Stack<String> Clientes=new Stack<String>();
    
       ///creamos el constructor
    //las inicializamos en el constructor
      public Moto() {
        vin= null;
        marca= null;
        linea = null;
        cilindraje = 0;
        modelo=0;
        fechaingreso=null;
        Cliente=null;
       
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
      
      
      public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }
    
      ///Metodo para guardar los productos
     public String RegistrarProducto(Moto p){
         
        String datos="";
        
        //insertamos en la pila el objeto que se le pasa por parametro al método
        Motos.push(p);
        
        
        datos=datos+"Se registro la moto con los siguientes datos: \n"
        +"Id Vin : "+ Motos.peek().getVin()
        +"\n Marca : "+ Motos.peek().getMarca()
        +"\n Linea : "+ Motos.peek().getLinea()
        +"\n Cilindraje : "+ Motos.peek().getCilindraje()
        +"\n Modelo : "+ Motos.peek().getModelo()
        +"\n Precio : "+ Motos.peek().getPrecio()
        +"\n Fecha Ingreso : "+ Motos.peek().getFechaingreso();
        
      
         return datos;
     } 
      
     
    
    public String VenderMoto(String Vin,String Cliente){
        
        
        String datos="";
        int cont=0;
       for(int i=0;i<Motos.size();i++){
           
         if(Motos.get(i).vin.equalsIgnoreCase(Vin)){
            
               Moto Mot=new Moto();
       
             Mot.setVin(Vin);
             Mot.setMarca(Motos.get(i).getMarca());
             Mot.setModelo(Motos.get(i).getModelo());
             Mot.setLinea(Motos.get(i).getLinea());
             Mot.setPrecio(Motos.get(i).getPrecio());
             Mot.setFechaingreso(Motos.get(i).getFechaingreso());
             Mot.setCilindraje(Motos.get(i).getCilindraje());
             Mot.setCliente(Cliente);
             
             
             //INGRESAMOS LA MOTO VENDIDA
             
             MotosVendidas.push(Mot);
             
             
             ///INGRESAMOS EL CLIENTE
             Clientes.push(Cliente);
             
             Motos.remove(i);
             cont++;
              break; 
              
              
         }  
       }
       
       
       if(cont>0){
       
        datos=datos+"Se registro la Venta de la moto con los siguientes datos: \n"
        +"Id Vin : "+ MotosVendidas.peek().getVin()
        +"\n Marca : "+ MotosVendidas.peek().getMarca()
        +"\n Linea : "+ MotosVendidas.peek().getLinea()
        +"\n Cilindraje : "+ MotosVendidas.peek().getCilindraje()
        +"\n Modelo : "+ MotosVendidas.peek().getModelo()
        +"\n Precio : "+ MotosVendidas.peek().getPrecio()
        +"\n Fecha Ingreso : "+ MotosVendidas.peek().getFechaingreso()
        +"\n Cliente : "+ MotosVendidas.peek().getCliente();
        
      
        
        
       }
       
       else {
           
           datos=datos+" No se encontro niguna motocicleta con el VIN ingresado";
       }
       
       
       
         return datos;
        
    }
    
    
    public String TotalVentas(){
        
        String datos="";
        Float Total=0.0f;
       
       
         for(int i=0;i<MotosVendidas.size();i++){
        
        Total=Total+MotosVendidas.get(i).getPrecio();
        
        
    }
    
   
    
     datos="El total de ventas es : "+Total + " COP";
     
     
     
     return datos;

}
    
    
    public String MayorPrecio(){
       
        Float Mayor=Motos.get(0).getPrecio();
        String Nombre=Motos.get(0).getLinea();
        String resultado;
        //recorremos la pila
      for(int i=0;i<Motos.size();i++){
        if(Motos.get(i).getPrecio()>Mayor){
        Mayor=Motos.get(i).getPrecio();
        Nombre=Motos.get(i).getLinea();
        }
        
      
     }
     
    
        resultado="La Moto con mayor precio es: "+Nombre+ " Con un precio de : "+ Mayor+"\n"; 
        return resultado;
     
}
     
      public String MenorPrecio(){
       
         Float Menor=Motos.get(0).getPrecio();
        String Nombre=Motos.get(0).getLinea();
        String resultado;
        //recorremos la pila
      for(int i=0;i<Motos.size();i++){
        if(Motos.get(i).getPrecio()<Menor){
        Menor=Motos.get(i).getPrecio();
        Nombre=Motos.get(i).getLinea();
        }
        
      
     }
     
    
        resultado="La Moto con menor precio es: "+Nombre+ " Con un precio de : "+ Menor+"\n"; 
        return resultado;
     
}
      
    
    
    
    
    
    
    
}
