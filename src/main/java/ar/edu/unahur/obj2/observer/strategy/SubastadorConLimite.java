package ar.edu.unahur.obj2.observer.strategy;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class SubastadorConLimite extends TipoSubastador{
    private Integer limite;

    public SubastadorConLimite(Integer limite){
        this.limite = limite;
    }

    @Override
    public void realizarOferta(Integer valorOfertado, Observable subasta, Observer subastador) {
        if(subastador.getUltimaOferta().getValorOfertado() <= limite){
            subasta.recibirOferta(new Oferta(subastador, valorOfertado));
        }
    }

}
