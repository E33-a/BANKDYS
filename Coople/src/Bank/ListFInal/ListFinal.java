package Bank.ListFInal;

import Structures.*;

//Aqui se hallan las listas principales que contendran a los clientes
public class ListFinal {
    public static DoubleListPay ListP = new DoubleListPay();
    public static DoubleListCr ListC = new DoubleListCr();
    public static DoubleListDe ListD = new DoubleListDe();

    private final static String pathPay = "./Coople/FilesC/CustomersPayroll.txt";
    private final static String pathDeb = "./Coople/FilesC/CustomersDebit.txt";
    private final static String pathCre = "./Coople/FilesC/CustomersCredit.txt";

    //Metodo para leer los archivos del txt y almacenarlos en las listas finales de cada tipo de cliente
    public static void inData(){
        

        ListCust.readCusCaPay(pathPay);
        ListCust.TemplistPayroll.printForward();
        ListFinal.ListP.readOtherList(ListCust.TemplistPayroll);

        ListCust.readCusCaDeb(pathDeb);
        ListCust.TemplistDebit.printForward();
        ListFinal.ListD.readOtherList(ListCust.TemplistDebit);

        ListCust.readCusCaCre(pathCre);
        ListCust.TemplistCredit.printForward();
        ListFinal.ListC.readOtherList(ListCust.TemplistCredit);
    }

    public static void saveAllData(){
        ListCust.saveCustomersPay(pathPay, ListP);
        ListCust.saveCustomersDeb(pathDeb, ListD);
        ListCust.saveCustomersCred(pathCre, ListC);
    }
}
