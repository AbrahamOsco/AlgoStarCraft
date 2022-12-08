package edu.fiuba.algo3.Controlador;

import java.util.HashMap;

public class BuscadorRutas {


    private HashMap<RUTAS_FXML,String> rutasFXML;

    public BuscadorRutas() {
        rutasFXML = new HashMap<>();
        rutasFXML.put(RUTAS_FXML.INTERFACE_JUEGO, "/VistaFxml/interfazJuego.fxml");
        rutasFXML.put(RUTAS_FXML.MENU_CRIADERO, "/VistaFxml/MenuCriadero.fxml");
        rutasFXML.put(RUTAS_FXML.MENU_PILON, "/VistaFxml/MenuPilon.fxml");
        rutasFXML.put(RUTAS_FXML.MENU_NODO_MINERAL_PROTOSS, "/VistaFxml/Menus/NodoMineral/MenuNodoMineralProtoss.fxml");
        rutasFXML.put(RUTAS_FXML.MENU_NODO_MINERAL_ZERG, "/VistaFxml/Menus/NodoMineral/MenuNodoMineralZerg.fxml");
    }

    public String buscarRuta(RUTAS_FXML nombre) {
        return rutasFXML.get(nombre);
    }
}

