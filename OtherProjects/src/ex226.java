import javax.swing.JOptionPane;

public class ex226 {
    public static void main(String[] args) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Chọn loại phương trình (PT Bậc Nhất, Hệ PT 2 Ẩn, PT Bậc Hai) hoặc gõ 'Thoát':");
            if (choice == null || choice.equals("Thoát"))
                break;
            if (choice.equals("PT Bậc Nhất")) {
                double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
                if (a == 0) {
                    JOptionPane.showMessageDialog(null, (b == 0) ? "Vô số nghiệm." : "Vô nghiệm.");
                } else {
                    JOptionPane.showMessageDialog(null, "x = " + (-b / a));
                }
            } else if (choice.equals("Hệ PT 2 Ẩn")) {
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
                double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));
                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - a21 * b1;
                if (D != 0) {
                    JOptionPane.showMessageDialog(null, "x1 = " + (D1 / D) + "\nx2 = " + (D2 / D));
                } else {
                    JOptionPane.showMessageDialog(null, (D1 == 0 && D2 == 0) ? "Vô số nghiệm." : "Vô nghiệm.");
                }
            } else if (choice.equals("PT Bậc Hai")) {
                double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
                double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));
                if (a == 0) {
                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, (c == 0) ? "Vô số nghiệm." : "Vô nghiệm.");
                    } else {
                        JOptionPane.showMessageDialog(null, "x = " + (-c / b));
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
                    } else if (delta == 0) {
                        JOptionPane.showMessageDialog(null, "Nghiệm kép: x = " + (-b / (2 * a)));
                    } else {
                        JOptionPane.showMessageDialog(null, "Vô nghiệm thực.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thoát");
            }
        }
    }
}