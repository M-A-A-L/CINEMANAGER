package domain.padroes.strategy;

public class PrecoMeiaEntrada implements CalcularPreco{
    @Override
    public double calcularPreco(double precoBase) {
        return precoBase * 0.5;
    }
}
