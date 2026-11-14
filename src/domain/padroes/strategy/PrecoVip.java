package domain.padroes.strategy;

public class PrecoVip implements CalcularPreco{
    @Override
    public double calcularPreco(double precoBase) {
        return precoBase / 0.5;
    }
    public double calcularPreco(double precoBase, double taxaVip) {
        return precoBase / taxaVip;
    }
}