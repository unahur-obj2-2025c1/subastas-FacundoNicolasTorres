package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public interface Observable {
    
    public void notificar();

    public void recibirOferta(Oferta oferta);

    public Boolean esParticipante(Oferta oferta);

    public void reset();

    public void agregarSubastador(Observer subastador);
}
