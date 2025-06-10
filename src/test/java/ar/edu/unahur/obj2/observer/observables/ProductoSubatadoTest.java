package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    public ProductoSubastado compu = new ProductoSubastado();
    public Subastador gonzager = new Subastador("gonzager");
    public Subastador diazdan = new Subastador("diazdan");
    public Subastador martomau = new Subastador("martomau");

    @BeforeEach
    void setUp(){
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        compu.reset();
    }

    @Test
    void seRealizanOfertasYLosSubastadoresRecibenBien_LaUltimaOferta(){
        compu.agregarSubastador(gonzager);
        compu.agregarSubastador(martomau);

        martomau.realizarOferta(10, compu);
        gonzager.realizarOferta(20, compu);
        martomau.realizarOferta(30, compu);

        assertEquals(martomau.getUltimaOferta(), gonzager.getUltimaOferta());
    }

    @Test
    void ultimaOfertaRegistradaPerteneceAlUltimoOfertante(){
        compu.agregarSubastador(gonzager);
        compu.agregarSubastador(martomau);

        martomau.realizarOferta(10, compu);
        gonzager.realizarOferta(20, compu);
        martomau.realizarOferta(30, compu);

        assertEquals(martomau.getNombre(), martomau.getUltimaOferta().getSubastador().getNombre());
    }

    @Test
    void elPrecioDeLaUltimaOfertaEsCorrecto(){
        compu.agregarSubastador(gonzager);
        compu.agregarSubastador(martomau);

        martomau.realizarOferta(10, compu);
        gonzager.realizarOferta(20, compu);
        martomau.realizarOferta(30, compu);

        assertEquals(30, gonzager.getUltimaOferta().getValorOfertado());
    }
    
    @Test
    void laCantidadDeOfertasDeLaSubastaEsLaEsperada(){
        compu.agregarSubastador(gonzager);
        compu.agregarSubastador(martomau);

        martomau.realizarOferta(10, compu);
        gonzager.realizarOferta(20, compu);
        martomau.realizarOferta(30, compu);

        assertEquals(3, compu.cantDeOfertas());
    }

    @Test
    void ofertaUnNoParticipanteDeLaSubastaYSaleUnError(){
        compu.agregarSubastador(gonzager);
        compu.agregarSubastador(martomau);

        martomau.realizarOferta(10, compu);
        gonzager.realizarOferta(20, compu);
        martomau.realizarOferta(30, compu);

        assertThrows(OfertaSubastadorException.class, () -> {diazdan.realizarOferta(40, compu);});
    }

}
