package com.montanha.factory;

import com.montanha.pojo.Viagem;

public class ViagemDataFactory {

    public static Viagem criarViagemValida() {
        Viagem viagemValida = new Viagem();
        viagemValida.setAcompanhante("AcompanhanteTeste");
        viagemValida.setDataPartida("2021-14-10");
        viagemValida.setDataRetorno("2021-14-10");
        viagemValida.setLocalDeDestino("Ceara");
        viagemValida.setRegiao("Norte");
        return viagemValida;
    }

}
