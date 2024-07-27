import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private static ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private static ArrayList<RekamMedis> daftarRekamMedis = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistem Informasi Rumah Sakit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel Pasien
        JPanel panelPasien = new JPanel(new BorderLayout());
        String[] kolomPasien = {"ID", "Nama", "Alamat", "No. Telp"};
        DefaultTableModel modelPasien = new DefaultTableModel(kolomPasien, 0);
        JTable tablePasien = new JTable(modelPasien);
        panelPasien.add(new JScrollPane(tablePasien), BorderLayout.CENTER);

        JPanel panelPasienForm = new JPanel(new GridLayout(5, 2));
        JTextField idPasienField = new JTextField();
        JTextField namaPasienField = new JTextField();
        JTextField alamatPasienField = new JTextField();
        JTextField noTelpPasienField = new JTextField();

        panelPasienForm.add(new JLabel("ID:"));
        panelPasienForm.add(idPasienField);
        panelPasienForm.add(new JLabel("Nama:"));
        panelPasienForm.add(namaPasienField);
        panelPasienForm.add(new JLabel("Alamat:"));
        panelPasienForm.add(alamatPasienField);
        panelPasienForm.add(new JLabel("No. Telp:"));
        panelPasienForm.add(noTelpPasienField);

        JButton simpanPasienBtn = new JButton("Simpan");
        simpanPasienBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pasien pasien = new Pasien(idPasienField.getText(), namaPasienField.getText(), alamatPasienField.getText(), noTelpPasienField.getText());
                daftarPasien.add(pasien);
                modelPasien.addRow(new Object[]{pasien.getId(), pasien.getNama(), pasien.getAlamat(), pasien.getNoTelp()});
                idPasienField.setText("");
                namaPasienField.setText("");
                alamatPasienField.setText("");
                noTelpPasienField.setText("");
            }
        });

        JButton hapusPasienBtn = new JButton("Hapus");
        hapusPasienBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablePasien.getSelectedRow();
                if (selectedRow >= 0) {
                    modelPasien.removeRow(selectedRow);
                    daftarPasien.remove(selectedRow);
                }
            }
        });

        panelPasienForm.add(simpanPasienBtn);
        panelPasienForm.add(hapusPasienBtn);

        panelPasien.add(panelPasienForm, BorderLayout.SOUTH);
        tabbedPane.addTab("Pasien", panelPasien);

        // Panel Dokter
        JPanel panelDokter = new JPanel(new BorderLayout());
        String[] kolomDokter = {"ID", "Nama", "Spesialis", "No. Telp"};
        DefaultTableModel modelDokter = new DefaultTableModel(kolomDokter, 0);
        JTable tableDokter = new JTable(modelDokter);
        panelDokter.add(new JScrollPane(tableDokter), BorderLayout.CENTER);

        JPanel panelDokterForm = new JPanel(new GridLayout(5, 2));
        JTextField idDokterField = new JTextField();
        JTextField namaDokterField = new JTextField();
        JTextField spesialisDokterField = new JTextField();
        JTextField noTelpDokterField = new JTextField();

        panelDokterForm.add(new JLabel("ID:"));
        panelDokterForm.add(idDokterField);
        panelDokterForm.add(new JLabel("Nama:"));
        panelDokterForm.add(namaDokterField);
        panelDokterForm.add(new JLabel("Spesialis:"));
        panelDokterForm.add(spesialisDokterField);
        panelDokterForm.add(new JLabel("No. Telp:"));
        panelDokterForm.add(noTelpDokterField);

        JButton simpanDokterBtn = new JButton("Simpan");
        simpanDokterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dokter dokter = new Dokter(idDokterField.getText(), namaDokterField.getText(), spesialisDokterField.getText(), noTelpDokterField.getText());
                daftarDokter.add(dokter);
                modelDokter.addRow(new Object[]{dokter.getId(), dokter.getNama(), dokter.getSpesialis(), dokter.getNoTelp()});
                idDokterField.setText("");
                namaDokterField.setText("");
                spesialisDokterField.setText("");
                noTelpDokterField.setText("");
            }
        });

        JButton hapusDokterBtn = new JButton("Hapus");
        hapusDokterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableDokter.getSelectedRow();
                if (selectedRow >= 0) {
                    modelDokter.removeRow(selectedRow);
                    daftarDokter.remove(selectedRow);
                }
            }
        });

        panelDokterForm.add(simpanDokterBtn);
        panelDokterForm.add(hapusDokterBtn);

        panelDokter.add(panelDokterForm, BorderLayout.SOUTH);
        tabbedPane.addTab("Dokter", panelDokter);

        // Panel Rekam Medis
        JPanel panelRekamMedis = new JPanel(new BorderLayout());
        String[] kolomRekamMedis = {"ID Pasien", "ID Dokter", "Tanggal", "Diagnosa"};
        DefaultTableModel modelRekamMedis = new DefaultTableModel(kolomRekamMedis, 0);
        JTable tableRekamMedis = new JTable(modelRekamMedis);
        panelRekamMedis.add(new JScrollPane(tableRekamMedis), BorderLayout.CENTER);

        JPanel panelRekamMedisForm = new JPanel(new GridLayout(5, 2));
        JTextField idPasienRekamMedisField = new JTextField();
        JTextField idDokterRekamMedisField = new JTextField();
        JTextField tanggalRekamMedisField = new JTextField();
        JTextField diagnosaRekamMedisField = new JTextField();

        panelRekamMedisForm.add(new JLabel("ID Pasien:"));
        panelRekamMedisForm.add(idPasienRekamMedisField);
        panelRekamMedisForm.add(new JLabel("ID Dokter:"));
        panelRekamMedisForm.add(idDokterRekamMedisField);
        panelRekamMedisForm.add(new JLabel("Tanggal:"));
        panelRekamMedisForm.add(tanggalRekamMedisField);
        panelRekamMedisForm.add(new JLabel("Diagnosa:"));
        panelRekamMedisForm.add(diagnosaRekamMedisField);

        JButton simpanRekamMedisBtn = new JButton("Simpan");
        simpanRekamMedisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RekamMedis rekamMedis = new RekamMedis(idPasienRekamMedisField.getText(), idDokterRekamMedisField.getText(), tanggalRekamMedisField.getText(), diagnosaRekamMedisField.getText());
                daftarRekamMedis.add(rekamMedis);
                modelRekamMedis.addRow(new Object[]{rekamMedis.getIdPasien(), rekamMedis.getIdDokter(), rekamMedis.getTanggal(), rekamMedis.getDiagnosa()});
                idPasienRekamMedisField.setText("");
                idDokterRekamMedisField.setText("");
                tanggalRekamMedisField.setText("");
                diagnosaRekamMedisField.setText("");
            }
        });

        JButton hapusRekamMedisBtn = new JButton("Hapus");
        hapusRekamMedisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableRekamMedis.getSelectedRow();
                if (selectedRow >= 0) {
                    modelRekamMedis.removeRow(selectedRow);
                    daftarRekamMedis.remove(selectedRow);
                }
            }
        });

        panelRekamMedisForm.add(simpanRekamMedisBtn);
        panelRekamMedisForm.add(hapusRekamMedisBtn);

        panelRekamMedis.add(panelRekamMedisForm, BorderLayout.SOUTH);
        tabbedPane.addTab("Rekam Medis", panelRekamMedis);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
