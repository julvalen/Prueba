package cl.umag.prueba.modelo;

import java.util.ArrayList;

public class Lista {
    //Patrón de diseño Singleton: solo un objeto ListaDeCompras en memoria
    private static Lista instancia=new Lista();

    private ArrayList<Producto> listaDeCompras;

    //Constructor singleton
    private Lista()
    {
        listaDeCompras=new ArrayList<>();
     //   agregarProducto(new Producto("Pan",2,"Kilos"));
    }

    //Método para devolver la instancia
    public static Lista getInstancia()
    {
        return instancia;
    }
    public void agregarProducto(Producto producto)
    {
        listaDeCompras.add(producto);
    }
    public Producto getProducto(int id)
    {
        return listaDeCompras.get(id);
    }
    public ArrayList<Producto> getListaDeCompras()
    {
        return listaDeCompras;
    }
    public void eliminarComprados()
    {
        for(int i=0; i<listaDeCompras.size();i++)
        {
            if(listaDeCompras.get(i).isEstado()==Producto.COMPRADO)
            {
                listaDeCompras.remove(i);
                i--;
            }
        }
    }
}
