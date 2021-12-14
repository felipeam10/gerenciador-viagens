package com.montanha.factory;

import com.montanha.pojo.Usuario;

public class UsuarioDataFactory {

    public static Usuario criarUsuarioAdm() {

        Usuario usuarioAdm = new Usuario();
        usuarioAdm.setEmail("admin@email.com");
        usuarioAdm.setSenha("654321");
        return usuarioAdm;
    }

    public static Usuario criarUsuarioComum() {

        Usuario usuarioComum = new Usuario();
        usuarioComum.setEmail("usuario@email.com");
        usuarioComum.setSenha("123456");
        return usuarioComum;
    }
}
