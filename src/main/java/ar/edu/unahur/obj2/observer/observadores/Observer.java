package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public interface Observer {

    public void actualizar(Oferta oferta);

    public void reset();

    public void realizarOferta(Integer valorOfertado, ProductoSubastado subasta);

    public Oferta getUltimaOferta();

    public String getNombre();
}
