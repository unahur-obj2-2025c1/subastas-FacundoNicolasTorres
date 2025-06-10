package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observer {
    private String nombre;
    private Oferta ultimaOferta;

    public Subastador(String nombre) {
        this.nombre = nombre;
    }   

    public String getNombre() {
        return nombre;
    }

    public Oferta getUltimaOferta(){
        return ultimaOferta;
    }

    public void reset(){
        ultimaOferta =  null;
    }

    public void actualizar(Oferta oferta){
        ultimaOferta = oferta;
    }

    public void primerOferta(Integer valorOfertado, ProductoSubastado subasta){
        if(subasta.hayOfertas()){
            throw new OfertaSubastadorException("Esta no es la primer oferta, ya hay otras ofertas");
        }
        if(valorOfertado <= 0){
            throw new OfertaSubastadorException("El valor de la oferta debe ser mayor a 0");
        }
        subasta.recibirOferta(new Oferta(this, valorOfertado));
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
}
