package ar.edu.unahur.obj2.observer.strategy;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class SubastadorArriesgado extends TipoSubastador{

    @Override
    public void realizarOferta(Integer valorOfertado, Observable subasta, Observer subastador) {
        subasta.recibirOferta(new Oferta(subastador, subastador.getUltimaOferta().getValorOfertado() + 10));
    }

}
