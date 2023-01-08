package frame;

import helpers.Koneksi;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RentalInputFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField idTextField;
    private JTextField namaTextField;
    private JTextField nomorteleponTextField;
    private JTextField jenisTextField;
    private JTextField waktuTextField;
    private JTextField nomorpsTextField;
    private JPanel buttonPnael;
    private JButton batalButton;
    private JButton simpanButton;
    private JButton tambahFotoButton;
    private JLabel gambar;

    public RentalInputFrame(){
        simpanButton.addActionListener(e -> {
            String nama = namaTextField.getText();
            String nomortelepon = nomorteleponTextField.getText();
            String jenis = jenisTextField.getText();
            String waktu = waktuTextField.getText();
            String nomorps = nomorpsTextField.getText();
            Connection c = Koneksi.getConnection();
            PreparedStatement ps;
            try {
                String insertSQL = "INSERT INTO rental VALUES (NULL, ?, ?, ?, ?, ?)";
                ps = c.prepareStatement(insertSQL);
                ps.setString(1,nama);
                ps.setString(2,nomortelepon);
                ps.setString(3,jenis);
                ps.setString(4,waktu);
                ps.setString(5,nomorps);
                ps.executeUpdate();
                dispose();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        batalButton.addActionListener(e -> {
            dispose();
        });
        init();
    }
    public void init() {
        setContentPane(mainPanel);
        setTitle("Input Pelanggan");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
