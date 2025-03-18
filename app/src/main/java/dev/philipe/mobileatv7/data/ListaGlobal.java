package dev.philipe.mobileatv7.data;

import java.util.ArrayList;
import java.util.List;

public final class ListaGlobal {
    private static volatile ListaGlobal instance;
    private List<String> lista;

    private ListaGlobal() {
        lista = new ArrayList<>();
    }

    public static ListaGlobal getInstance() {
        if (instance == null) {
            synchronized (ListaGlobal.class) {
                if (instance == null) {
                    instance = new ListaGlobal();
                }
            }
        }
        return instance;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
