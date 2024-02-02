package TP;

public interface Competidor {
    public boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws TipoDeCompetidorException;
    public Integer getValor(Caracteristica c);
    public TipoCompetidor getAfilacion();
}
