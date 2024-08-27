import java.util.ArrayList;
import java.util.List;

public class SistemaVotacao {

    private List<Candidato> candidatos;
    private List<Partido> partidos;

    public SistemaVotacao() {
        this.candidatos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void adicionarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    public void adicionarCandidato(Candidato candidato) {
        this.candidatos.add(candidato);
    }

    public Partido buscarPartidoPorNome(String nome) {

        for (Partido partido : partidos) {
            if (partido.getNome().equalsIgnoreCase(nome)) {
                return partido;
            }
        }
        return null;
    }

    public void votar(int numeroCandidato) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numeroCandidato) {
                candidato.adicionarVoto();
                System.out.println("Voto registrado para " + candidato.getNome() + " do partido " + candidato.getPartido().getNome());
            }
        }
        System.out.println("Candidato não encontrado");
    }

    public void exibirResultados() {

        if(candidatos.isEmpty()){
            System.out.println("Nenhum candidato registrado");
        }

        Candidato candidatoVencedor = candidatos.get(0);
        Partido partidoVencedor = partidos.get(0);

        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > candidatoVencedor.getVotos()) {
                candidatoVencedor = candidato;
            }
        }

        for (Partido partido : partidos) {
            if (partido.getVotos() > partidoVencedor.getVotos()) {
                partidoVencedor = partido;
            }
        }

        System.out.println("Candidato vencedor: " + candidatoVencedor.getNome());
        System.out.println("Partido vencedor" + partidoVencedor.getNome());
    }
}
