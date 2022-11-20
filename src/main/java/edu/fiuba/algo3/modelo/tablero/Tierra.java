package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelMohoError;
import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.Unidad.Unidad;

public class Tierra implements Tipo {

    public void instalar(Edificio edificio) {
        edificio.instalar(this);
    }

    public void crecer(Coordenada coor,Mapa mapa,int radio){}
    public void ubicar(Unidad unaUnidad){}
}
