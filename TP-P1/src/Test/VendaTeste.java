package Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Model.*;
import Enum.*;

@RunWith(Parameterized.class)
public class VendaTeste {

    // Definição dos parâmetros para os testes
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
                "2023-06-01",
                new Cliente(1, TipoCliente.ESPECIAL, new Endereco(Estado.SP, true), 10.0f),
                new Produto[]{new Produto(1, "Produto1", 10.0f, "unidade")},
                "Cartao",
                false,
                0.1f,
                100.0f,
                10.0f,
                5.0f
            },
            {
                "2023-06-02",
                new Cliente(2, TipoCliente.PRIME, new Endereco(Estado.RJ, false), 20.0f),
                new Produto[]{new Produto(2, "Produto2", 20.0f, "peça")},
                "Dinheiro",
                true,
                0.2f,
                200.0f,
                20.0f,
                10.0f
            }
            // Adicione mais casos de teste conforme necessário
        });
    }

    private String data;
    private Cliente cliente;
    private Produto[] itens;
    private String metodoPagamento;
    private Boolean cashbackIsUsed;
    private float imposto;
    private float valor;
    private float frete;
    private float desconto;

    // Construtor que recebe os parâmetros
    public VendaTeste(String data, Cliente cliente, Produto[] itens, String metodoPagamento, Boolean cashbackIsUsed, float imposto, float valor, float frete, float desconto) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.metodoPagamento = metodoPagamento;
        this.cashbackIsUsed = cashbackIsUsed;
        this.imposto = imposto;
        this.valor = valor;
        this.frete = frete;
        this.desconto = desconto;
    }

    @Test
    public void testVenda() {
        Venda venda = new Venda(data, cliente, itens, metodoPagamento, cashbackIsUsed, imposto, valor, frete, desconto);
        assertEquals(data, venda.getData());
        assertEquals(cliente, venda.getCliente());
        assertArrayEquals(itens, venda.getItens());
        assertEquals(metodoPagamento, venda.getMetodoPagamento());
        assertEquals(cashbackIsUsed, venda.getCashbackIsUsed());
        assertEquals(imposto, venda.getImposto(), 0.0f);
        assertEquals(valor, venda.getValor(), 0.0f);
        assertEquals(frete, venda.getFrete(), 0.0f);
        assertEquals(desconto, venda.getDesconto(), 0.0f);
    }
}
