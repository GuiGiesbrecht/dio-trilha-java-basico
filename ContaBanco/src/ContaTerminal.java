import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o nome do titular: ");
            nomeCliente = scanner.nextLine();

            System.out.println("Digite o número da conta: ");
            numero = scanner.nextInt();

            System.out.println("Digite a agência: ");
            agencia = scanner.nextLine();

            System.out.println("Digite o saldo: ");
            saldo = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Erro ao ler dados da conta.");
            throw e;
        }

        System.out.println(
                "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia
                        + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");
    }
}
