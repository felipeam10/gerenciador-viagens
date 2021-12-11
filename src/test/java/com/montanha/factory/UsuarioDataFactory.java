package com.montanha.factory;

import com.montanha.pojo.Usuario;

public class UsuarioDataFactory {

    public static Usuario criarUsuarioAdm() {

        Usuario usuarioAdm = new Usuario();
        usuarioAdm.setEmail("admin@email.com");
        usuarioAdm.setSenha("654321");
        return usuarioAdm;
    }
}
