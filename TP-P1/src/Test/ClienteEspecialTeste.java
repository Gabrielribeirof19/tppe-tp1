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

    @Parameters
    public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
            {
                "Venda para Cliente Padrao (Cliente Padrao)",
                "2024-07-01",
                new Cliente(1, TipoCliente.PRIME, new Endereco(Estado.DF, true), 5.0f),
                new Produto[]{new Produto(1, "Produto1", 75.0f, "unidade")},
                "429613XXXXXXXXXX",
                false,
                0.0f,
                100.0f,
                10.0f,   // frete
                0.0f,   // desconto
                0.0f    // expected cashback
            },
            {
                "Venda para Cliente Padrao (Cliente Padrao)",
                "2024-07-02",
                new Cliente(2, TipoCliente.ESPECIAL, new Endereco(Estado.SP, true), 0.0f),
                new Produto[]{new Produto(2, "Produto2", 200.0f, "unidade")},
                "1234567890123456",
                true,
                0.0f,
                200.0f,
                7.0f,   // frete
                30.0f,  // desconto
                0.0f    // expected cashback
            },
            {
                "Venda para Cliente Padrão",
                "2024-07-03",
                new Cliente(3, TipoCliente.PADRAO, new Endereco(Estado.RJ, true), 0.0f),
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

    private String description;
    private String data;
    private Cliente cliente;
    private Produto[] itens;
    private String metodoPagamento;
    private Boolean cashbackIsUsed;
    private float imposto;
    private float valor;
    private float frete;
    private float desconto;
    private float expectedCashback;

    public VendaTeste(
            String description,
            String data,
            Cliente cliente,
            Produto[] itens,
            String metodoPagamento,
            Boolean cashbackIsUsed,
            float imposto,
            float valor,
            float frete,
            float desconto,
            float expectedCashback) {
        this.description = description;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.metodoPagamento = metodoPagamento;
        this.cashbackIsUsed = cashbackIsUsed;
        this.imposto = imposto;
        this.valor = valor;
        this.frete = frete;
        this.desconto = desconto;
        this.expectedCashback = expectedCashback;
    }

    @Test
    public void testVenda() {
        Venda venda = new Venda(data, cliente, itens, metodoPagamento, cashbackIsUsed, imposto, valor, frete, desconto);
        
        // Simulate the logic to calculate discount, frete, and cashback
        venda.calcularTotais();

        assertEquals(description + ": Cashback", expectedCashback, cliente.getCashback(), 0.0f);
    }
}
