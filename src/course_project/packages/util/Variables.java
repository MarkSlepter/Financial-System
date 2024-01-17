package course_project.packages.util;

/**
 *   Variables for calculating turnover
 */

public class Variables {

    private static double sumOrder = 0;
    private static double sumInvoice = 0;
    private static double sumBill = 0;

    public static double getSumOrder() {

        return sumOrder;

    }

    public static void setSumOrder(double sumOrder) {

        Variables.sumOrder = sumOrder;

    }

    public static double getSumInvoice() {

        return sumInvoice;

    }

    public static void setSumInvoice(double sumInvoice) {

        Variables.sumInvoice = sumInvoice;

    }

    public static double getSumBill() {

        return sumBill;

    }

    public static void setSumBill(double sumBill) {

        Variables.sumBill = sumBill;

    }

}
