package Coopple;

import java.util.ArrayList;
import java.util.List;

public class CustomerPayroll extends Customer {
    private CardPayroll card;
    private List<Transaction> transactions;

    CustomerPayroll(String name, String surname1, String surname2, int age, char gender, double salary, CreditC credit, CardPayroll card) {
        super(name, surname1, surname2, age, gender, salary, credit);
        this.card = card;
        this.transactions = new ArrayList<>();
    }

    // Setters
    public void assignCardPayroll(CardPayroll card) {
        this.card = card;
    }

    // Getters
    public CardPayroll getCard() {
        return card;
    }

    public void showCPay() {
        showInfoP();
        System.out.println("Tipo de tarjeta: " + getCard().getType());
        System.out.println("Número de cuenta: " + getCard().getNumber());
        System.out.println("NIP: " + getCard().getNip());
        System.out.println("Saldo: $" + getCard().getBalance());
        showInfoC();
    }

    public void realizarCompra(double monto) {
        double totalConIVA = monto * 1.16;
        if (card.getBalance() >= totalConIVA) {
            card.setBalance(card.getBalance() - totalConIVA);
            transactions.add(new Transaction("Compra", totalConIVA, "2024-07-23"));
            System.out.println("Compra realizada. Monto con IVA: $" + totalConIVA);
        } else {
            System.out.println("Saldo insuficiente para realizar la compra.");
        }
    }

    public void realizarPago(double monto, boolean esPagoCompleto, boolean rebasaFechaLimite) {
        double saldo = card.getBalance();
        if (esPagoCompleto) {
            card.setBalance(0.00);
            transactions.add(new Transaction("Pago completo", monto, "2024-07-23"));
            System.out.println("Pago completo realizado. Saldo actual: $0.00");
        } else if (rebasaFechaLimite) {
            double pagoConInteres = monto + (monto * 0.10);
            if (saldo >= pagoConInteres) {
                card.setBalance(saldo - pagoConInteres);
                transactions.add(new Transaction("Pago con interés 10%", pagoConInteres, "2024-07-23"));
                System.out.println("Pago realizado con 10% de interés. Monto pagado: $" + pagoConInteres);
            } else {
                System.out.println("Saldo insuficiente para realizar el pago con interés.");
            }
        } else {
            double pagoConInteres = monto + (monto * 0.05);
            if (saldo >= pagoConInteres) {
                card.setBalance(saldo - pagoConInteres);
                transactions.add(new Transaction("Pago con interés 5%", pagoConInteres, "2024-07-23"));
                System.out.println("Pago realizado con 5% de interés. Monto pagado: $" + pagoConInteres);
            } else {
                System.out.println("Saldo insuficiente para realizar el pago con interés.");
            }
        }
    }

    public void showTransactions() {
        System.out.println("Últimas 3 transacciones:");
        int start = Math.max(transactions.size() - 3, 0);
        for (int i = start; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }
}
