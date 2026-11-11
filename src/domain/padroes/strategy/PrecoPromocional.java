package domain.padroes.strategy;

public class PrecoPromocional implements CalcularPreco{
    @Override
    public double calcularPreco(double precoBase) {
        return precoBase * 0.75;
    }
    public double calcularPreco(double precoBase, double taxaPromocao) {
        return precoBase * taxaPromocao;
    }
}
