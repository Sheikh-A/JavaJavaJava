
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author alisheikh, Cindy, Hengyan
 */
public class Main extends javax.swing.JFrame {

    // I've created some objects here for get access in button functions
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    String selectedFile = "";
    String log = "\n";
    WordRecommender myWordRecommender;
    SpellCheckerHelpers mySpellCheckerHelpers;
    
    getDictwords mygetDictwords;
    HashMap<Integer, String> misspell_Words;
    ArrayList<String> misspelledWords;
    HashMap<Integer, String> suggestedWords;
    String item;
    int i;
    boolean takeAction = false;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
        //Left console scrolling
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jTextField1.setForeground(Color.YELLOW);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        notin = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(49, 63, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 81, 94)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit.png"))); 
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sarai", 3, 24)); //  
        jLabel2.setForeground(new java.awt.Color(236, 68, 82));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SPELL CHECKER");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); //  
        jLabel3.setForeground(new java.awt.Color(209, 222, 227));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOT IN DICTIONARY :");

        notin.setFont(new java.awt.Font("SansSerif", 1, 12)); //  
        notin.setForeground(new java.awt.Color(219, 71, 84));

        jTextField1.setBackground(new java.awt.Color(49, 63, 70));
        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 12)); //  
        jTextField1.setForeground(new java.awt.Color(215, 225, 229));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(188, 63, 63)));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextArea1.setBackground(new java.awt.Color(49, 63, 70));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 1, 12)); //  
        jTextArea1.setForeground(new java.awt.Color(205, 219, 224));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(206, 90, 90)));
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(49, 63, 70));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); //  
        jButton1.setForeground(new java.awt.Color(227, 239, 243));
        jButton1.setText("CHOOSE FILE");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(235, 77, 93)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(49, 63, 70));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 10)); //  
        jButton2.setForeground(new java.awt.Color(227, 239, 243));
        jButton2.setText("REPLACE Select # Index");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(70, 164, 165)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(49, 63, 70));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 10)); //  
        jButton3.setForeground(new java.awt.Color(227, 239, 243));
        jButton3.setText("ACCEPT AS IS");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(70, 164, 165)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(49, 63, 70));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 10)); //  
        jButton4.setForeground(new java.awt.Color(227, 239, 243));
        jButton4.setText("TYPE IN MANUALLY");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(70, 164, 165)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(notin, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(notin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            this.selectedFile = selectedFile.getAbsolutePath();
            new Thread(() -> {
                play();
            }).start();
        } else {
            JOptionPane.showMessageDialog(rootPane, "File not found. Please input a file, like test.txt. use the txt file under HengyanTao_SpellChecker directory \n "
                    + "Or put the .txt file you want to do spell check under HengyanTao_SpellChecker directory.", "Please select a file", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String input = JOptionPane.showInputDialog(null, "Enter the number corresponding to the word \n that you want to use for replacement.");
        int userOption = Integer.parseInt(input);
        if (userOption > suggestedWords.size()) {
            JOptionPane.showMessageDialog(rootPane, "please enter an integer number from 1 to " + suggestedWords.size(), "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            item = suggestedWords.get(userOption - 1);
            misspell_Words.put(i, item);
            takeAction = true;
            displayText("Replaced with " + item);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField1.setText("Type here and hit enter");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("entered");
            item = jTextField1.getText();
            misspell_Words.put(i, item);
            takeAction = true;
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        displayText("leaving as is");
        takeAction = true;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // remove existing texts on field before enter the word
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void play() {
        // for this assignment we just hard code the engDictionary.txt
        // actually for extensibility, we can ask user for the dictionary input file
        myWordRecommender = new WordRecommender("engDictionary.txt");
        mySpellCheckerHelpers = new SpellCheckerHelpers();
        mygetDictwords = new getDictwords();
        misspell_Words = new HashMap<Integer, String>();

        // generate the ArrayList of all the words in engDictionary
        HashMap<Integer, String> dictWords = new HashMap<Integer, String>();
        dictWords = mygetDictwords.getDictwords("engDictionary.txt");

        // for the to be checked file, get all the words to array list
        // for this assignment we just hard code the test.txt
        // actually for extensibility, we can ask user which file user want to do spellcheck
        File inputFile;
        inputFile = new File(selectedFile);

        try {
            Scanner fileScanner = new Scanner(inputFile);
            int index = 0;
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                misspell_Words.put(index, word);
                index += 1;
            }

            // now lets go through the ArrayList for each word and find out if there's
            // any mispelled word
            misspelledWords = new ArrayList<String>();
            suggestedWords = new HashMap<Integer, String>();
            i = 0;
            for (i = 0; i < misspell_Words.size(); i++) {
                log = "";
                takeAction = false;
                item = misspell_Words.get(i);
                // if word not in engDictionary then it's mis-spelled
                if (!dictWords.containsValue(item) && item.length() > 1) {
                    misspelledWords.add(item);
                    //
                    // If a word from the file does not exist in the provided list, 
                    // then it is assumed to be misspelled and a set of alternatives provided to the user
                    System.out.println("\n The word " + item + " is misspelled.");
                    notin.setText(item);
                    // compute the available recommended words
                    suggestedWords = myWordRecommender.getWordSuggestions(item, 2, 0.5, 10);

                    Scanner user_input = new Scanner(System.in);
                    String userInput;
                    String userTyped_word;
                    if (suggestedWords.size() > 0) {
                        System.out.println("The following suggestions are available");
                        displayText("The following suggestions are available");
                        String prettyPrint = mySpellCheckerHelpers.prettyPrint(suggestedWords);
                        System.out.println(prettyPrint);
                        displayText(prettyPrint.replace("null", ""));
                        System.out.println("Press ‘r’ for replace, ‘a’ for accept as is, ‘t’ for type in manually. \n");

                        // waiting until take an action
                        while (!takeAction) {
                            Thread.sleep(500);
                        }

                        System.out.println("reached!");
                    } else {
                        displayText("There are 0 suggestions in our dictionary for this word.");
                        displayText("Accept as is or type in manually");
                        System.out.println("There are 0 suggestions in our dictionary for this word.");
                        System.out.println("Press ‘a’ for accept as is, ‘t’ for type in manually.");

                        // waiting until take an action
                        while (!takeAction) {
                            Thread.sleep(500);
                        }

                    }
                }
            }

            log = "";
            displayText("All misspelled words have been handled!");
            displayText("We're going to write a new file with the name of the original file plus the suffix ‘_chk’!");
            System.out.println("All misspelled words have been handled!");
            System.out.println("We're going to write a new file with the name of the original file plus the suffix ‘_chk’!");
            String filename = inputFile.getName();
            int lastDot = filename.lastIndexOf('.');
            String new_filename = filename.substring(0, lastDot) + "_chk" + filename.substring(lastDot);
            try {
                FileWriter fw = new FileWriter(new_filename);

                //System.out.println("What text should we put in the file?");
                // fileContents here is the ArrayList of the spell checked original file
                for (Integer key : misspell_Words.keySet()) {
                    fw.write(misspell_Words.get(key) + " ");
                }
                fw.close();
                System.out.println("File was successfully written!");
                System.out.println("Thanks for attending Spell Checker! All done now! Great Job!");
                displayText("File was successfully written!");
                displayText("Thanks for attending Spell Checker! All done now! \n Great Job! \n Please click exit!");
            } catch (IOException e) {
                // Do nothing
            }
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // this method is for display text on screen
    public void displayText(String text) {
        log = log + "\n" + text;
        jTextArea1.setText(log);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel notin;
    // End of variables declaration//GEN-END:variables
}
