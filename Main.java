import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    static CardLayout cardLayout;
    static JPanel anaPanel;
    static JPanel loginPanel;
    static JFrame frame;
    static String currentScreen = "Login";  // Aktif ekranı takip etmek için değişken

    public static void main(String[] args) {

        frame = new JFrame("Müzik Dersleri Rezervasyon Sistemi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cardLayout = new CardLayout();
        anaPanel = new JPanel(cardLayout);

        // Giriş sayfasını oluştur
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(new Color(34, 34, 34));  // Koyu tema arka plan

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Giriş Yap");
        //JButton dersListesiButton = new JButton("Ders Listesini Gör");

        // Kullanıcı adı ve şifre için stil ayarları
        usernameField.setBackground(new Color(55, 55, 55));
        usernameField.setForeground(Color.WHITE);
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setBackground(new Color(55, 55, 55));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Butonları stillendirme
        loginButton.setBackground(new Color(58, 58, 58));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //dersListesiButton.setBackground(new Color(58, 58, 58));
        //dersListesiButton.setForeground(Color.WHITE);
        //dersListesiButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        //dersListesiButton.setFocusPainted(false);
        //dersListesiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Kullanıcı adı etiket
        JLabel usernameLabel = new JLabel("Kullanıcı Adı:", SwingConstants.RIGHT);
        usernameLabel.setForeground(Color.WHITE);  // Kullanıcı adı etiketini beyaz yap

        // Kullanıcı adı alanı
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        // Şifre etiket
        JLabel passwordLabel = new JLabel("Şifre:", SwingConstants.RIGHT);
        passwordLabel.setForeground(Color.WHITE);  // Şifre etiketini beyaz yap

        // Şifre alanı
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        // Giriş butonu
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(loginButton, gbc);

        // Ders Listesini Gör butonu
        //gbc.gridx = 1;
        //gbc.gridy = 3;
        //loginPanel.add(dersListesiButton, gbc);

        // Ana paneli login paneli ile ekle
        anaPanel.add(loginPanel, "Login");

        // Menü Paneli
        JPanel menuPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        menuPanel.setBackground(new Color(34, 34, 34));

        JButton ogretmenButton = new JButton("Öğretmen Yönetimi");
        JButton ogrenciButton = new JButton("Öğrenci Yönetimi");
        JButton dersButton = new JButton("Ders Yönetimi");
        JButton ogretmenEkleButton = new JButton("Öğretmen Ekle");
        JButton ogrenciEkleButton = new JButton("Öğrenci Ekle");
        JButton dersEkleButton = new JButton("Ders Ekle");

        // Buton stillendirme
        styleButton(ogretmenButton);
        styleButton(ogrenciButton);
        styleButton(dersButton);
        styleButton(ogretmenEkleButton);
        styleButton(ogrenciEkleButton);
        styleButton(dersEkleButton);

        menuPanel.add(ogretmenButton);
        menuPanel.add(ogrenciButton);
        menuPanel.add(dersButton);
        menuPanel.add(ogretmenEkleButton);
        menuPanel.add(ogrenciEkleButton);
        menuPanel.add(dersEkleButton);

        anaPanel.add(menuPanel, "Menu");
        anaPanel.add(listelemeEkrani("ogretmen.hot", "Öğretmen", new String[]{"Ad Soyad", "Branş", "Telefon"}), "Ogretmen");
        anaPanel.add(listelemeEkrani("ogrenci.hot", "Öğrenci", new String[]{"Ad Soyad", "Yaş", "Telefon"}), "Ogrenci");
        anaPanel.add(listelemeEkrani("ders.hot", "Ders", new String[]{"Öğretmen", "Öğrenci", "Tarih", "Saat"}), "Ders");

        // Giriş işlemleri
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Admin kontrolü
            if ("emir".equals(username) && "1234".equals(password)) {
                cardLayout.show(anaPanel, "Menu");
                currentScreen = "Menu";  // Ana ekran aktif
            } else {
                JOptionPane.showMessageDialog(frame, "Hatalı kullanıcı adı veya şifre!");
            }
        });

        // Ders listesi butonu
        //dersListesiButton.addActionListener(e -> {
             //Sadece dersleri gösteren bir panel açacağız
            //JPanel dersListesiPanel = listelemeEkrani("ders.hot", "Ders", new String[]{"Öğretmen", "Öğrenci", "Tarih", "Saat"});
            //cardLayout.show(anaPanel, "Ders");
            //currentScreen = "Ders";  // Ders ekranı aktif
        //});

        ogretmenButton.addActionListener(e -> {
            cardLayout.show(anaPanel, "Ogretmen");
            currentScreen = "Ogretmen";  // Öğretmen yönetimi aktif
        });
        ogrenciButton.addActionListener(e -> {
            cardLayout.show(anaPanel, "Ogrenci");
            currentScreen = "Ogrenci";  // Öğrenci yönetimi aktif
        });
        dersButton.addActionListener(e -> {
            cardLayout.show(anaPanel, "Ders");
            currentScreen = "Ders";  // Ders yönetimi aktif
        });
        ogretmenEkleButton.addActionListener(e -> ekleFormu("ogretmen.hot", new String[]{"Ad Soyad", "Branş", "Telefon"}));
        ogrenciEkleButton.addActionListener(e -> ekleFormu("ogrenci.hot", new String[]{"Ad Soyad", "Yaş", "Telefon"}));
        dersEkleButton.addActionListener(e -> dersEkleFormu());

        frame.add(anaPanel);
        frame.setVisible(true);
    }

    // Buton stillendirme
    private static void styleButton(JButton button) {
        button.setBackground(new Color(58, 58, 58));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private static void ekleFormu(String dosyaAdi, String[] kolonlar) {
        JTextField[] alanlar = new JTextField[kolonlar.length];
        JPanel panel = new JPanel(new GridLayout(kolonlar.length, 2));
        panel.setBackground(new Color(34, 34, 34)); // Koyu arka plan

        // Kullanıcıdan giriş alınacak alanları ekle
        for (int i = 0; i < kolonlar.length; i++) {
            JLabel label = new JLabel(kolonlar[i] + ":");
            label.setForeground(Color.WHITE);  // Etiket yazısını beyaz yap
            panel.add(label);

            alanlar[i] = new JTextField();
            alanlar[i].setBackground(new Color(55, 55, 55));  // Gri arka plan
            alanlar[i].setForeground(Color.WHITE);  // Beyaz metin
            alanlar[i].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  // Sınır yok
            panel.add(alanlar[i]);
        }

        // Kullanıcıdan bilgi al
        int sonuc = JOptionPane.showConfirmDialog(null, panel, "Yeni Kayıt Ekle", JOptionPane.OK_CANCEL_OPTION);
        if (sonuc == JOptionPane.OK_OPTION) {

            // Ad Soyad ve Branş için harf kontrolü
            for (int i = 0; i < kolonlar.length; i++) {
                String input = alanlar[i].getText();

                // Eğer "Ad Soyad" veya "Branş" alanları varsa, sadece harflerden oluştuğunu kontrol et
                if ((dosyaAdi.equals("ogretmen.hot") && (kolonlar[i].equals("Ad Soyad") || kolonlar[i].equals("Branş"))) ||
                        (dosyaAdi.equals("ogrenci.hot") && kolonlar[i].equals("Ad Soyad"))) {
                    if (!input.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+")) {
                        JOptionPane.showMessageDialog(null, kolonlar[i] + " sadece harflerden oluşmalıdır. Sayı veya sembol içeremez!");
                        return;
                    }
                }
            }

            // Telefon numarası kontrolü
            if (dosyaAdi.equals("ogretmen.hot") || dosyaAdi.equals("ogrenci.hot")) {  // Öğretmen veya öğrenci ekranı
                String telefon = alanlar[kolonlar.length - 1].getText();  // Telefon numarasının son kolon olduğunu varsayıyoruz
                if (!telefon.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Telefon numarası 11 haneli olmalı ve sadece rakamlardan oluşmalıdır!");
                    return;
                }
            }

            // Eğer tüm doğrulamalar başarılıysa veriyi dosyaya ekle
            StringBuilder veri = new StringBuilder();
            for (int i = 0; i < kolonlar.length; i++) {
                veri.append(alanlar[i].getText());
                if (i < kolonlar.length - 1) veri.append("|");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
                writer.write(veri.toString());
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Kayıt başarıyla eklendi!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






    // Listeleme Ekranı
    private static JPanel listelemeEkrani(String dosyaAdi, String ekranAdi, String[] kolonlar) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(34, 34, 34));
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);
        JTable tablo = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablo);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton geriButton = new JButton("Geri");
        JButton silButton = new JButton("Sil");
        JButton guncelleButton = new JButton("Güncelle");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(34, 34, 34));
        buttonPanel.add(silButton);
        buttonPanel.add(guncelleButton);
        buttonPanel.add(geriButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Verileri yükleme
        panel.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                model.setRowCount(0);
                try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
                    String satir;
                    while ((satir = reader.readLine()) != null) {
                        model.addRow(satir.split("\\|"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {}
            @Override
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {}
        });

        // Silme işlemi
        silButton.addActionListener(e -> {
            int selectedRow = tablo.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
                dosyayaYaz(dosyaAdi, model);
                JOptionPane.showMessageDialog(null, ekranAdi + " başarıyla silindi!");
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen silmek için bir satır seçin.");
            }
        });

        // Güncelleme işlemi
        guncelleButton.addActionListener(e -> {
            int selectedRow = tablo.getSelectedRow();
            if (selectedRow != -1) {
                for (int i = 0; i < kolonlar.length; i++) {
                    String yeniDeger = JOptionPane.showInputDialog("Yeni " + kolonlar[i], model.getValueAt(selectedRow, i));

                    // Doğrulamalar
                    if (yeniDeger != null && !yeniDeger.trim().isEmpty()) {
                        switch (kolonlar[i]) {
                            case "Ad Soyad":
                                // Sadece harflere ve boşluklara izin ver
                                if (!yeniDeger.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+")) {
                                    JOptionPane.showMessageDialog(null, kolonlar[i] + " sadece harflerden oluşmalıdır. Sayı veya sembol içeremez!");
                                    return;
                                }
                                break;
                            case "Tarih":
                                // Tarih doğrulaması (gün/ay/yıl formatı ve 2025 yılı)
                                if (!yeniDeger.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/2025")) {
                                    JOptionPane.showMessageDialog(null, "Tarih 1-31 gün, 1-12 ay ve 2025 yılı için geçerli olmalıdır! Format: gün/ay/yıl");
                                    return;
                                }
                                break;
                            case "Saat":
                                // Saat doğrulaması (09:00 - 21:00 arasında olmalı)
                                if (!yeniDeger.matches("(0[9]|1[0-9]|2[0-1]):[0-5][0-9]")) {
                                    JOptionPane.showMessageDialog(null, "Saat 09:00 ile 21:00 arasında olmalı ve doğru formatta olmalıdır (HH:mm).");
                                    return;
                                }
                                break;
                            default:
                                // Diğer alanlar için boş geçilmez kontrolü
                                if (yeniDeger.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, kolonlar[i] + " boş bırakılamaz!");
                                    return;
                                }
                                break;
                        }
                        // Doğrulama başarılıysa tabloyu güncelle
                        model.setValueAt(yeniDeger, selectedRow, i);
                    }
                }
                dosyayaYaz(dosyaAdi, model);
                JOptionPane.showMessageDialog(null, ekranAdi + " başarıyla güncellendi!");
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen güncellemek için bir satır seçin.");
            }
        });


        geriButton.addActionListener(e -> {
            if (currentScreen.equals("Login")) {
                cardLayout.show(anaPanel, "Login");
            } else {
                cardLayout.show(anaPanel, "Menu");
            }
        });
        return panel;
    }


    // Ders Ekle Formu
    // Ders Ekle Formu
    // Ders Ekle Formu
    private static void dersEkleFormu() {
        // Öğretmen ve öğrenci dosyalarını oku
        ArrayList<String> ogretmenListesi = dosyadanOku("ogretmen.hot");
        ArrayList<String> ogrenciListesi = dosyadanOku("ogrenci.hot");

        // Öğretmen veya öğrenci listesi boşsa uyarı ver ve ekranı açma
        if (ogretmenListesi.isEmpty() || ogrenciListesi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ders eklemek için en az bir öğretmen ve öğrenci kaydı olmalıdır!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JComboBox<String> ogretmenComboBox = new JComboBox<>(ogretmenListesi.toArray(new String[0]));
        JComboBox<String> ogrenciComboBox = new JComboBox<>(ogrenciListesi.toArray(new String[0]));
        JTextField tarihField = new JTextField();
        JTextField saatField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBackground(new Color(34, 34, 34)); // Koyu arka plan

        // Öğretmen etiket ve comboBox
        JLabel ogretmenLabel = new JLabel("Öğretmen:");
        ogretmenLabel.setForeground(Color.WHITE);  // Etiket yazısını beyaz yap
        panel.add(ogretmenLabel);
        ogretmenComboBox.setBackground(new Color(55, 55, 55));  // Gri arka plan
        ogretmenComboBox.setForeground(Color.WHITE);  // Beyaz metin
        panel.add(ogretmenComboBox);

        // Öğrenci etiket ve comboBox
        JLabel ogrenciLabel = new JLabel("Öğrenci:");
        ogrenciLabel.setForeground(Color.WHITE);  // Etiket yazısını beyaz yap
        panel.add(ogrenciLabel);
        ogrenciComboBox.setBackground(new Color(55, 55, 55));  // Gri arka plan
        ogrenciComboBox.setForeground(Color.WHITE);  // Beyaz metin
        panel.add(ogrenciComboBox);

        // Tarih etiket ve textField
        JLabel tarihLabel = new JLabel("Tarih (gün/ay/yıl):");
        tarihLabel.setForeground(Color.WHITE);  // Etiket yazısını beyaz yap
        panel.add(tarihLabel);
        tarihField.setBackground(new Color(55, 55, 55));  // Gri arka plan
        tarihField.setForeground(Color.WHITE);  // Beyaz metin
        panel.add(tarihField);

        // Saat etiket ve textField
        JLabel saatLabel = new JLabel("Saat (09:00 - 21:00):");
        saatLabel.setForeground(Color.WHITE);  // Etiket yazısını beyaz yap
        panel.add(saatLabel);
        saatField.setBackground(new Color(55, 55, 55));  // Gri arka plan
        saatField.setForeground(Color.WHITE);  // Beyaz metin
        panel.add(saatField);

        int sonuc = JOptionPane.showConfirmDialog(null, panel, "Ders Ekle", JOptionPane.OK_CANCEL_OPTION);
        if (sonuc == JOptionPane.OK_OPTION) {
            // Tarih doğrulaması (gün/ay/yıl formatında ve 2025 yılı için geçerli)
            String tarih = tarihField.getText();
            if (!tarih.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/2025")) {
                JOptionPane.showMessageDialog(null, "Tarih 1-31 gün, 1-12 ay ve 2025 yılı için geçerli olmalıdır! Format: gün/ay/yıl");
                return;
            }

            // Saat doğrulaması (09:00 - 21:00 arasında olmalı)
            String saat = saatField.getText();
            if (!saat.matches("(0[9]|1[0-9]|2[0-1]):[0-5][0-9]")) {
                JOptionPane.showMessageDialog(null, "Saat 09:00 ile 21:00 arasında olmalı ve doğru formatta olmalıdır (HH:mm).");
                return;
            }

            // Ders bilgilerini kaydet
            String veri = ogretmenComboBox.getSelectedItem() + "|" +
                    ogrenciComboBox.getSelectedItem() + "|" +
                    tarihField.getText() + "|" +
                    saatField.getText();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ders.hot", true))) {
                writer.write(veri);
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Ders başarıyla eklendi!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }










    // Dosyadan veri okuma
    private static ArrayList<String> dosyadanOku(String dosyaAdi) {
        ArrayList<String> isimListesi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] veri = satir.split("\\|");
                isimListesi.add(veri[0]); // Ad Soyad
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isimListesi;
    }

    // Dosyaya yazma
    private static void dosyayaYaz(String dosyaAdi, DefaultTableModel model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) writer.write("|");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
