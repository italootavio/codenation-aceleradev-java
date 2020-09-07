package challenge;

import java.util.ArrayList;

public class Estacionamento {

    private final int NUMVAGAS = 10;
    private final int SENIORIDADE = 55;
    private ArrayList<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (carrosEstacionados() >= NUMVAGAS) {
            Carro carroTroca = carros.stream().filter(carro1 -> carro1.getMotorista().getIdade() < SENIORIDADE)
                    .findFirst().orElseThrow(() -> new EstacionamentoException("todos os individuos sao seniors"));
            carros.remove(carroTroca);
        }
        carros.add(carro);
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
