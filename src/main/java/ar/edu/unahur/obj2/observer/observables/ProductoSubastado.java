package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubastado implements Observable{
    private Stack<Oferta> ofertas = new Stack<>();
    private List<Subastador> subastadores = new ArrayList<>();

    public void agregarOferta(Oferta oferta){
        ofertas.add(oferta);
        this.notificar();
    }

    public void reset(){
        ofertas = new Stack<>();
        subastadores = new ArrayList<>();
    }

    public void agregarSubastador(Subastador subastador){
        subastadores.add(subastador);
    }

    public void notificar() {
       subastadores.forEach(s -> s.actualizar(ofertas.peek()));
    }

    public void recibirOferta(Oferta oferta){
        if(!esParticipante(oferta)){
            throw new OfertaSubastadorException("El subastador no participa en la subasta");
        }
        ofertas.push(oferta);
        this.notificar();
    }

    public Boolean esParticipante(Oferta oferta){
        return subastadores.contains(oferta.getSubastador());
    }

    public Integer cantDeOfertas(){
        return ofertas.size();
    }

    public Boolean hayOfertas(){
        return this.cantDeOfertas() > 0;
    }
}
