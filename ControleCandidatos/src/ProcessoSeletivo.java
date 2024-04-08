import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // Lista de nomes dos candidatos
        String[] candidatos = { "João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula", "Luiz" };

        // Seleciona os candidatos
        String[] candidatosSelecionados = selecaoCandidatos(candidatos);

        // Imprime os candidatos selecionados
        imprimirCandidatosSelecionados(candidatosSelecionados);

        // Contato com os candidatos selecionados
        contatoCandidatos(candidatosSelecionados);
    }

    static String[] selecaoCandidatos(String[] candidatos) {
        String[] candidatosSelecionados = new String[5];
        int contadorSelecionado = 0;

        // Percorre lista de candidatos e verificar os no max 5 aprovados
        for (String candidato : candidatos) {
            if (contadorSelecionado < 5) {
                System.out.println("\nAnalisando candidato: " + candidato);

                if (analisarCandidato(valorPretendido())) {
                    candidatosSelecionados[contadorSelecionado] = candidato;
                    contadorSelecionado++;
                    System.out.println("Candidato " + candidato + " aprovado");
                } else {
                    System.out.println("Candidato " + candidato + " reprovado");
                }
            } else {
                System.out.println("-- Processo seletivo encerrado --\n");
                break;
            }
        }

        return candidatosSelecionados;
    }

    static double valorPretendido() {
        // Gera um valor aleatório entre 1500 e 3000
        return ThreadLocalRandom.current().nextDouble(1500, 3000);
    }

    static boolean analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000;

        if (salarioPretendido < salarioBase) {
            System.out.println("Ligar para o candidato");
            return true;
        } else if (salarioPretendido == salarioBase) {
            System.out.println("Ligar para o candidato com contra proposta");
            return true;
        }

        System.out.println("Aguardando o resultado dos demais candidatos");
        return false;
    }

    static void imprimirCandidatosSelecionados(String[] candidatosSelecionados) {
        System.out.println("\nCandidatos selecionados: ");
        for (int i = 0; i < candidatosSelecionados.length; i++) {
            if (candidatosSelecionados[i] != null) {
                System.out.println((i + 1) + " - " + candidatosSelecionados[i]);
            }
        }
    }

    static void contatoCandidatos(String[] candidatosSelecionados) {
        for (String candidato : candidatosSelecionados) {
            if (candidato != null) {
                System.out.println("");
                int tentativasRealizadas = 0;
                boolean atendeu = false;

                // Tenta contactar o candidato no máximo 3 vezes
                while (!atendeu && tentativasRealizadas < 3) {
                    tentativasRealizadas++;
                    atendeu = candidatoAtendeu();

                    if (atendeu) {
                        System.out.println("Contato realizado com " + candidato + " na " + tentativasRealizadas
                                + " tentativa");
                    } else if (tentativasRealizadas < 3) {
                        System.out.println("Tentativa " + tentativasRealizadas + " falhou para " + candidato
                                + ". Tentando novamente...");
                    }
                }

                // Se após 3 tentativas não conseguir contato, informa no console.
                if (!atendeu) {
                    System.out.println("Não conseguimos contato com " + candidato + ", tentamos contato "
                            + tentativasRealizadas + " vezes.");
                }

            }
        }
    }

    static boolean candidatoAtendeu() {
        // Simula a chance do candidato atender, com 1 em 3 chances de sucesso
        return new Random().nextInt(3) == 1;
    }
}
