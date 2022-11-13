package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15 {

    @Test
    public void RazaZergDejaDeConseguirGasDelVolcanCuandoSeQuedaSinUnidadesDeGas(){
        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor(volcan);

        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i <6; i++ ){
            extractor.ejecutarTurno();
        }

        for(int i = 0; i <3; i++ ){
            extractor.agregarZangano(new Zangano());
        }

        int maximaCantidadGasExtraible = 5000;
        int cantidadDeTurnosParaSacarTodoElGas = 167;
        int cantidadGas = 0;
        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElGas ; i++ ){
            cantidadGas += extractor.extraer();
        }
       //Assert
        assertEquals(maximaCantidadGasExtraible, cantidadGas);
    }

    @Test
    public void RazaZergDejaDeConseguirMineralCuandoDelNodoMineralCuandoSeQuedaSinUnidadesDeMineral(){
        //Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Zangano zangano = new Zangano();
        int maximaCantidadGasExtraible = 2000;
        int cantidadDeTurnosParaSacarTodoElGas = 200;
        int cantidadMineral = 0;
        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElGas ; i++ ){
            cantidadMineral += zangano.extraer(nodoMineral);
        }
        //Assert
        assertEquals( maximaCantidadGasExtraible, cantidadMineral);
    }


    @Test
    public void RazaProtoDejaDeConseguirGasDelVolcanCuandoSeQuedaSinUnidadesDeGas(){
        //Arrange
        Volcan volcan = new Volcan();
        Asimilador asimilador = new Asimilador(volcan);

        // dejo el Asimilador operrable en 6 turnos
        for(int i = 0; i <6; i++ ){
            asimilador.ejecutarTurno();
        }

        int maximaCantidadGasExtraible = 5000;
        int cantidadDeTurnosParaSacarTodoElGas = 250;
        int cantidadGas = 0;

        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElGas; i++ ){
            cantidadGas += asimilador.extraer();
        }

        //Assert
        assertEquals(maximaCantidadGasExtraible, cantidadGas);
    }

    @Test
    public void RazaProtossDejaDeConseguirMineralCuandoDelNodoMineralCuandoSeQuedaSinUnidadesDeMineral(){
        //Arrange
        NexoMineral nexoMineral = new NexoMineral( new NodoMineral() );

        // dejo el Asimilador operrable en 6 turnos
        for(int i = 0; i <4; i++ ){
            nexoMineral.ejecutarTurno();
        }

        int maximaCantidadGasExtraible = 2000;
        int cantidadDeTurnosParaSacarTodoElGas = 250;
        int cantidadGas = 0;

        //Act
        for(int i = 0; i < cantidadDeTurnosParaSacarTodoElGas; i++ ){
            cantidadGas += nexoMineral.extraer();
        }

        //Assert
        assertEquals(maximaCantidadGasExtraible, cantidadGas);
    }

}
