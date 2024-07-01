package Model;

public class Venda {
	//  A venda consiste em uma data, cliente, itens vendidos e método de pagamento
    public Venda(String data, Cliente cliente, Produto[] itens, String metodoPagamento, Boolean cashbackIsUsed, float imposto, float valor, float frete, float desconto) {
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

    //atributos
    private String data;
    private Cliente cliente;
    private Produto[] itens;
    private String metodoPagamento;
    private Boolean cashbackIsUsed;
    private float imposto;
    private float valor;
    private float frete;
    private float desconto;


    //metodos
    public String getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto[] getItens() {
        return itens;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public Boolean getCashbackIsUsed() {
        return cashbackIsUsed;
    }

    public float getImposto() {
        return imposto;
    }

    public float getValor() {
        return valor;
    }

    public float getFrete() {
        return frete;
    }

    public float getDesconto() {
        return desconto;
    }
}