package domain.padroes.strategy;

public class CalculadorDePreco {

    private CalcularPreco tipodePreco;

    public double calcular(double precobase) {
        return this.tipodePreco.calcularPreco(precobase);
    }
    public void setTipodePreco(CalcularPreco tipodePreco) {
        this.tipodePreco = tipodePreco;
    }
}
