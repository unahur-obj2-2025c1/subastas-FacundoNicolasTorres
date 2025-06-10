package ar.edu.unahur.obj2.observer.strategy;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class SubastadorUnico extends TipoSubastador{
    private Boolean yaOferto = Boolean.FALSE;


    @Override
    public void realizarOferta(Integer valorOfertado, Observable subasta, Observer subastador) {
        if(!yaOferto){
            subasta.recibirOferta(new Oferta(subastador, valorOfertado));
            yaOferto = Boolean.TRUE;
        }
    }

}
