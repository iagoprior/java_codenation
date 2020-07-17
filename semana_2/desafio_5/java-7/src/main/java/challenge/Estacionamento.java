package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> carrosEstacionamento = new ArrayList<>();

    public void estacionar(Carro carro) {
        Motorista motorista = carro.getMotorista();
        if (carrosEstacionados() >= 10) {
            int motrem = 0;
            for (Carro car: carrosEstacionamento) {
                if ((motrem == 0)  && (car.getMotorista().getIdade() < 55)) {
                    carrosEstacionamento.remove(car);
                    carrosEstacionamento.add(carro);
                    motrem = 1;
                    break;
                }
            }
            if (motrem == 0) {
                throw new EstacionamentoException("O estacionamento não possui mais vagas.");
            }
        } else {
            carrosEstacionamento.add(carro);
        }
        if(carro.getMotorista()==null)
        {
            throw new EstacionamentoException("Carro sem Motorista");
        }
        if (motorista.getIdade() < 18 || motorista.getPontos() > 20)
        {
            throw new EstacionamentoException("Motorista de Menor ou com habilitação suspensa");
        }


    }

    public int carrosEstacionados() {
        return carrosEstacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {

        boolean bln=false;
        for (Carro carroEst: carrosEstacionamento){
            if (carro.equals(carroEst)){
                bln = true;
            }
        }
        return bln;
    }
}
