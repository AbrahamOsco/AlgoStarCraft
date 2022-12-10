package testAuxiliares;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Unidad.Hidralisco;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMoverse {

    @Test
    public void EnUnMapaUnaUnidadSeMueveEnVariasDireccionesSinCausarError(){
        Mapa mapa = new Mapa(20,20);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(10,10)).asignarUnidad(zangano);

        assertDoesNotThrow(() -> {
            zangano.moverseAbajo();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseDerecha();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseArriba();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseDerecha();;
        });


    }

    @Test
    public void UnaUnidadSeMueveADireccioneUbicacioneDebenSerEquivalentes(){
        Mapa mapa = new Mapa(20,20);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(10,10)).asignarUnidad(zangano);

        zangano.moverseAbajo();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 10  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 11  );

        zangano.moverseDerecha();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 11  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 11  );

        zangano.moverseArriba();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 11  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 10  );

        zangano.moverseIzquierda();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 10  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 10  );

    }

    }
