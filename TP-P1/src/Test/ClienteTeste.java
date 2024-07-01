package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import Enum.TipoCliente;
import Model.Cliente;
import Model.Endereco;

@RunWith(Parameterized.class)
public class ClienteTeste {

    private static Endereco endereco;
    private TipoCliente tipo;
    private int id;
    private Float cashback;


    
    public ClienteTeste(int id, TipoCliente tipo, Endereco endereco, Float cashback){
        this.id = id;
        this.tipo = tipo;
        ClienteTeste.endereco = endereco;
        this.cashback = cashback;
    }
    @Parameters
    public static Object[][] getParameters(){
        return new Object[][] {
            {1, TipoCliente.PADRAO, endereco, 0.0f},
            {2, TipoCliente.ESPECIAL, endereco, 0.0f},
            {3, TipoCliente.PRIME, endereco, 0.2f}
        };
    }

   
    @Test
    public void test(){
        Cliente c = new Cliente(id, tipo, endereco, cashback);
        assertEquals(id, c.getId());
        assertEquals(tipo, c.getTipo());
        assertEquals(endereco, c.getEndereco());
        assertEquals(cashback, c.getCashback());
    }

}