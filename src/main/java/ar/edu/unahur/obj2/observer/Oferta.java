package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Observer;

public class Oferta {
    private final Observer subastador;
    private final Integer valorOfertado;
    
    public Oferta(Observer subastador, Integer valorOfertado) {
        this.subastador = subastador;
        this.valorOfertado = valorOfertado;
    }

    public Observer getSubastador() {
        return subastador;
    }

    public Integer getValorOfertado() {
        return valorOfertado;
    }

    
}
