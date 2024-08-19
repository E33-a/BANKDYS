package Coopple.Receipt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Receipt {
    static LocalDate date = LocalDate.now();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    private static String DateFinal = date.format(dateFormatter);
    private static String datePay;
    private static double payAmount;
    private static String type;

    //setters
    public static void setDatePay(String datePay) {
        Receipt.datePay = datePay;
    }
    public static void setPayAmount(double payAmount) {
        Receipt.payAmount = payAmount;
    }
    public static void setType(String type) {
        Receipt.type = type;
    }
    //getters
    public static String getDatePay() {
        return datePay;
    }
    public static double getPayAmount() {
        return payAmount;
    }
    public static String getType() {
        return type;
    }
    public static String getDateFinal() {
        return DateFinal;
    }
}
