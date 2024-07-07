package Test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Model.Cliente;
import Model.Endereco;
import Model.Produto;
import Model.Venda;
import Enum.Estado;
import Enum.TipoCliente;
import Model.database.DataBaseProvider.java

@RunWith(Parameterized.class)
public class VendaTeste {

	DataBaseProvider 
    @Parameters
    public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
            {
                "Venda para Cliente Padrao",
				LocalDate.parse("2024-06-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new Cliente(1, TipoCliente.PADRAO, new Endereco(Estado.DF, true), 5.0f),
                new Produto[]{new Produto(1, "Produto1", 105.0f, "unidade")},
                "429613XXXXXXXXXX",
                false,
                0.0f,
                100.0f,
                7.0f,   // frete
                0.0f,   // desconto
                0.0f    // expected cashback
            },
            {
                "Venda para Cliente Padrao",
				LocalDate.parse("2024-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new Cliente(1, TipoCliente.PADRAO, new Endereco(Estado.DF, true), 5.0f),
                new Produto[]{new Produto(2, "Produto2", 200.0f, "unidade")},
                "1234567890123456",
                false,
                0.0f,
                200.0f,
                7.0f,   // frete
                0.0f,  // desconto
                0.0f    // expected cashback
            },
            {
                "Venda para Cliente Padrão",
				LocalDate.parse("2024-04-20", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new Cliente(1, TipoCliente.PADRAO, new Endereco(Estado.DF, true), 5.0f),
                new Produto[]{new Produto(3, "Produto3", 150.0f, "unidade")},
                "6543210987654321",
                false,
                0.0f,
                150.0f,
                7.0f,   // frete
                0.0f,   // desconto
                0.0f    // expected cashback
            }
        };


		return Arrays.asList(resposta);
    }

    private DataBaseProvider vendas;
	private Cliente cliente;
    private boolean respostaEsperada;

    public VendaTeste(DataBaseProvider vendas, Cliente cliente ,boolean respostaEsperada) {
        this.vendas = vendas;
		this.cliente = cliente;
		this.respostaEsperada = respostaEsperada;
	}

    @Test
    public void testVenda() {
        vendas.getVendas().add(new Venda()); 
        // Simulate the logic to calculate discount, frete, and cashback
        DataBaseProvider.isEspecial();
        assertEquals(vendas.isEspecial());
    }
}
