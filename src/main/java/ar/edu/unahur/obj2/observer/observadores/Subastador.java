package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.Observable;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observer {
    private String nombre;
    private Oferta ultimaOferta;
    private Observable producto;

    public Subastador(String nombre) {
        this.nombre = nombre;
        ultimaOferta = new Oferta(this, 0);
    }   

    public void setProducto(Observable producto){
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public Oferta getUltimaOferta(){
        return ultimaOferta;
    }

    public void reset(){
        ultimaOferta =  new Oferta(this, 0);
    }

    public void actualizar(Oferta oferta){
        ultimaOferta = oferta;
    }

    public void realizarOferta(Integer valorOfertado, ProductoSubastado subasta){
        if (!esOfertaValida(valorOfertado)){
            throw new OfertaSubastadorException("El valor ofertado tiene que ser 10$ más que la ultima oferta");
        }
        subasta.recibirOferta(new Oferta(this, valorOfertado)); 
    }

    public Boolean esOfertaValida(Integer valorOfertado){
        return (ultimaOferta.getValorOfertado() + 10) <= valorOfertado;
    }

    public Observable getProducto() {
        return producto;
    }
}
