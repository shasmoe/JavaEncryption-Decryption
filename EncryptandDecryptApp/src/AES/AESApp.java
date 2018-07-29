package AES;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
/*
 * @author shasmoe
 */
public class AESApp extends javax.swing.JFrame {
    byte[] skey = new byte[1000];
    byte[] ebyte;
    String skeyString;
    static byte[] raw;
    
    public AESApp() {
        initComponents();
        generateSymmetricKey();        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        plaintxt = new javax.swing.JTextField();
        encryptedtxt = new javax.swing.JLabel();
        decryptedtxt = new javax.swing.JLabel();
        encryptbtn = new javax.swing.JButton();
        decryptbtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Advanced Encryption Standard (AES)");

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        plaintxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        plaintxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        plaintxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Text", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Century", 0, 12))); // NOI18N
        plaintxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                plaintxtKeyReleased(evt);
            }
        });

        encryptedtxt.setBackground(new java.awt.Color(204, 204, 255));
        encryptedtxt.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        encryptedtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encryptedtxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encrypted Text", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Century", 0, 12))); // NOI18N
        encryptedtxt.setOpaque(true);

        decryptedtxt.setBackground(new java.awt.Color(255, 102, 51));
        decryptedtxt.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        decryptedtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decryptedtxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Decrypted Text", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Century", 0, 12))); // NOI18N
        decryptedtxt.setOpaque(true);

        encryptbtn.setBackground(new java.awt.Color(255, 153, 51));
        encryptbtn.setFont(new java.awt.Font("Meiryo", 1, 12)); // NOI18N
        encryptbtn.setText("ENCRYPT");
        encryptbtn.setEnabled(false);
        encryptbtn.setOpaque(false);
        encryptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptbtnActionPerformed(evt);
            }
        });

        decryptbtn.setBackground(new java.awt.Color(153, 255, 153));
        decryptbtn.setFont(new java.awt.Font("Meiryo", 1, 12)); // NOI18N
        decryptbtn.setText("DECRYPT");
        decryptbtn.setEnabled(false);
        decryptbtn.setOpaque(false);
        decryptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptbtnActionPerformed(evt);
            }
        });

        resetbtn.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        resetbtn.setText("RESET");
        resetbtn.setEnabled(false);
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plaintxt, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(encryptedtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(decryptedtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encryptbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(decryptbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plaintxt, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(encryptbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decryptbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(encryptedtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decryptedtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //////////////////////////
    
    void generateSymmetricKey() {
        try {
            Random r = new Random();
            int num = r.nextInt(10000);
            String knum = String.valueOf(num);
            byte[] knumb = knum.getBytes();
            skey=getRawKey(knumb);
            skeyString = new String(skey);
            //JOptionPane.showMessageDialog(null, "AES Symmetric key = "+skeyString);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        raw = skey.getEncoded();
        return raw;
    }

    //Encryption MODDE
    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    //Decryption MODDE
    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }
    
    /////////////////////////
    
    private void encryptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptbtnActionPerformed
        try{
            String inputMessage=plaintxt.getText();
            byte[] ibyte = inputMessage.getBytes();
            ebyte=encrypt(raw, ibyte);
            String encryptedData = new String(ebyte);
            encryptedtxt.setText(encryptedData);
            decryptbtn.setEnabled(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_encryptbtnActionPerformed

    private void decryptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptbtnActionPerformed
        try{
            byte[] dbyte = decrypt(raw,ebyte);
            String decryptedMessage = new String(dbyte);
            decryptedtxt.setText(decryptedMessage);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_decryptbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        //clear all field
        plaintxt.setText(null);
        encryptedtxt.setText(null);
        decryptedtxt.setText(null);
        //turnoff buttons
        encryptbtn.setEnabled(false);
        decryptbtn.setEnabled(false);
        resetbtn.setEnabled(false);
    }//GEN-LAST:event_resetbtnActionPerformed

    private void plaintxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plaintxtKeyReleased
        String ptxt=plaintxt.getText();
        Integer sizee=ptxt.length();
        if(sizee == 0){
            encryptbtn.setEnabled(false);
            decryptbtn.setEnabled(false);
            resetbtn.setEnabled(false);
            encryptedtxt.setText(null);
            decryptedtxt.setText(null);
        }else{
            encryptbtn.setEnabled(true);
            resetbtn.setEnabled(true);
        }
    }//GEN-LAST:event_plaintxtKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AESApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AESApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptbtn;
    public javax.swing.JLabel decryptedtxt;
    private javax.swing.JButton encryptbtn;
    public javax.swing.JLabel encryptedtxt;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField plaintxt;
    private javax.swing.JButton resetbtn;
    // End of variables declaration//GEN-END:variables
}
