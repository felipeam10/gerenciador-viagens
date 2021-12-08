package com.montanha.isolado;

import org.junit.Assert;
import org.junit.Test;

public class ViagensTest {

    @Test
    public void testCadastroDeViagemValidoRetornaSucesso() {
        Assert.assertEquals(1,1);
    }

    @Test
    public void testCadastroDeViagemInvalidoRetornaFalha() {
        Assert.assertEquals(1, 2);
    }
}
