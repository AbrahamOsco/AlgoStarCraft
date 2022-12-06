package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.*;

import java.util.Observable;

public class JuegoModelo extends Observable {
    private Ubicacion baseJugador1;
    private Ubicacion baseJugador2;
    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;
    private int contadorJugadores;

    private Jugador jugadorActivo;

    public JuegoModelo() {
        Base base = new Base();
        this.mapa = base.getMapa();
        Coordenada coord1 = new Coordenada(0, 0);
        if (mapa.buscar(coord1).distancia(mapa.buscarOpuesto(coord1)) == mapa.distanciaMaxima()) {
            baseJugador1 = mapa.buscar(coord1);
            baseJugador2 = mapa.buscarOpuesto(coord1);
            baseJugador1.darTipo(new Moho()); //necesito moho para instalar un criadero
            baseJugador1.ubicar(new Criadero()); //el criadero base
            baseJugador2.ubicar(new Pilon()); //el pilon base
        } else {
            throw new CoordenadaNoEsExtremoDelMapaError();
        }
        jugador1 = null;
        jugador2 = null;
        contadorJugadores = 0;
        mapa.inicializarMapa( );
    }

    public JuegoModelo(Mapa Mapa, Coordenada coor1) {
        mapa = Mapa;
        if (mapa.buscar(coor1).distancia(mapa.buscarOpuesto(coor1)) == mapa.distanciaMaxima()) {
            baseJugador1 = mapa.buscar(coor1);
            baseJugador2 = mapa.buscarOpuesto(coor1);
            baseJugador1.darTipo(new Moho()); //necesito moho para instalar un criadero
            baseJugador1.ubicar(new Criadero()); //el criadero base
            baseJugador2.ubicar(new Pilon()); //el pilon base
        } else {
            throw new CoordenadaNoEsExtremoDelMapaError();
        }
        jugadorActivo = jugador1;

    }

    public int distanciaEntreBases() {
        return baseJugador1.distancia(baseJugador2);
    }

    public void esElfinDeJuego(Raza unaRaza, Raza otraRaza) {
        unaRaza.existenAunEdificios();
        otraRaza.existenAunEdificios();
    }

    public void agregarJugador(Jugador unJugador) {
        if (jugador1 == null) {
            jugador1 = unJugador;
            jugador1.getRaza().agregarEdificioInicial(baseJugador1.getEdificio());
            jugadorActivo = jugador1;
        } else {
            unJugador.compatibleCon(jugador1);
            jugador2 = unJugador;
            jugador2.getRaza().agregarEdificioInicial(baseJugador2.getEdificio());
        }
        contadorJugadores++;
    }

    public boolean jugadoresCompletos() {
        return (jugador2 != null && jugador1 != null);
    }

    public int cantidadJugadores() {
        return contadorJugadores + 1;
    }

    public  int dimensionTablero(){
        return mapa.getDimension();
    }

    public Ubicacion buscar(Coordenada coordenada) {
        return mapa.buscar(coordenada);
    }

    public Jugador getJugador1(){
        return jugador1;
    }
    public Jugador getJugador2(){
        return jugador2;
    }

    public Mapa getMapa(){
        return mapa;
    }

    public Jugador getJugadorActivo(){
        return jugadorActivo;
    }

    public void terminarTurno(){
        if(jugadorActivo.equals(jugador1)){
            jugadorActivo = jugador2;
        }
        else{
            jugadorActivo = jugador1;
        }
    }
}

