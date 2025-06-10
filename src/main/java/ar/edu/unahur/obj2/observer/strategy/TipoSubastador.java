package ar.edu.unahur.obj2.observer.strategy;

import ar.edu.unahur.obj2.observer.observables.Observable;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public abstract class TipoSubastador {

    public abstract void realizarOferta(Integer valorOfertado, Observable subasta, Observer subastador);
    
}
