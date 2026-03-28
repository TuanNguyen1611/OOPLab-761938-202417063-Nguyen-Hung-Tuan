import javax.swing.JOptionPane;

public class ex225 {
    public static void main(String[] args){
        String inputA = JOptionPane.showInputDialog(null, "Nhập số a:");
        String inputB = JOptionPane.showInputDialog(null, "Nhập số b:");

        double a = Double.parseDouble(inputA);
        double b = Double.parseDouble(inputB);

        double sum = a + b;
        double difference = a - b;
        double product = a * b;

        String result = "Tổng: " + sum +
                "\nHiệu: " + difference +
                "\nTích: " + product;

        if (b != 0) {
            double quotient = a / b;
            result += "\nThương: " + quotient;
        } else {
            result += "\nThương: Không xác định";
        }

        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }
}