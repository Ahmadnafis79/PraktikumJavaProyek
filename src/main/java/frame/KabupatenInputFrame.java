package frame;

import helpers.Koneksi;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KabupatenInputFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField idTextField;
    private JPanel buttonPanel;
    private JButton batalButton;
    private JButton simpanButton;

    public KabupatenInputFrame() {
        batalButton.addActionListener(e -> {
            dispose();
        });

        simpanButton.addActionListener(e -> {
            String nama = idTextField.getText();
            Connection c = Koneksi.getConnection();
            PreparedStatement ps;
            try {
                String insertSQL = "INSERT INTO kabupaten VALUES (NULL, ?)";
                ps = c.prepareStatement(insertSQL);
                ps.setString(1, nama);
                ps.executeUpdate();
                dispose();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            };
        });

        init();

    }

    public void init(){
        setContentPane(mainPanel);
        setTitle("Input Kabupaten");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
