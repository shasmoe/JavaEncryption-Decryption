package DES;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/*
 * @author shasmoe
 */
public class DESApp extends javax.swing.JFrame {
    ///////Encryption Decription//////
    byte[] input;
    byte[] keyBytes ="abcd5678".getBytes();//you may input anything here but the length must equal to 8
    byte[] ivBytes ="shasmoe8".getBytes();//you may put any value but the length must equal to 8
    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
    IvParameterSpec ivspec = new IvParameterSpec(ivBytes);
    Cipher cipher;
    byte[] cipherText;
    int ctLength;
    
    public DESApp() {
        initComponents();
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
        setTitle("Data Encryption Standard (DES)");

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
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

    private void encryptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptbtnActionPerformed
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            input=plaintxt.getText().getBytes();
            SecretKeySpec key= new SecretKeySpec(keyBytes, "DES");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            cipher = Cipher.getInstance("DES/CTR/NoPadding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            cipherText = new byte[cipher.getOutputSize(input.length)];
            ctLength = cipher.update(input, 0, input.length, cipherText, 0);
            ctLength += cipher.doFinal(cipherText, ctLength);
            encryptedtxt.setText(new String(cipherText));
            //swtch-on decryption Button
            decryptbtn.setEnabled(true);
            
        } catch(NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | ShortBufferException | IllegalBlockSizeException | BadPaddingException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_encryptbtnActionPerformed

    private void decryptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptbtnActionPerformed
        try{
            cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
            byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
            int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
            ptLength += cipher.doFinal(plainText, ptLength);
            decryptedtxt.setText(new String(plainText));
        }catch(InvalidKeyException | InvalidAlgorithmParameterException | ShortBufferException | IllegalBlockSizeException | BadPaddingException ex) {
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
            java.util.logging.Logger.getLogger(DESApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DESApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptbtn;
    private javax.swing.JLabel decryptedtxt;
    private javax.swing.JButton encryptbtn;
    private javax.swing.JLabel encryptedtxt;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField plaintxt;
    private javax.swing.JButton resetbtn;
    // End of variables declaration//GEN-END:variables
}
