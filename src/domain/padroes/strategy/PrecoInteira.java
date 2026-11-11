package domain.padroes.strategy;

public class PrecoInteira implements CalcularPreco {
    @Override
    public double calcularPreco(double precoBase) {
        return precoBase;
    }
}
