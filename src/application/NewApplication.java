
package application;

import giachamtranchamsan.Servicer;
import giachamtranchamsan.ServicerInterface;
import giacophieu.CauThayDoiGia;
import giatrigiaodich.Cau;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import khoiluongkhop.CauKLKL;
import nhomnganh.InCauNN;
import tainguyenchung.ChungKhoan;
import tainguyenchung.ReadFileCSV;

public class NewApplication extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NewApplication() {
        initComponents();
        textResult.setEditable(false);
    }

    private void initComponents() {

        jChonTag = new javax.swing.JLabel();
        jCheckTangGiamGia = new javax.swing.JCheckBox();
        jCheckChamTranSan = new javax.swing.JCheckBox();
        jCheckKLKL = new javax.swing.JCheckBox();
        jOK = new javax.swing.JButton();
        jChonNgay = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        JQuit = new javax.swing.JButton();
        jCheckGTGD = new javax.swing.JCheckBox();
        jCheckDauTuNN = new javax.swing.JCheckBox();
        textResult = new java.awt.TextArea();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jChonTag.setText("Chọn các tag");

        jCheckTangGiamGia.setText("Tăng , Giảm giá");
        jCheckTangGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckTangGiamGiaActionPerformed(evt);
            }
        });

        jCheckChamTranSan.setText("Chạm trần,sàn");

        jCheckKLKL.setText("Khối lượng khớp lệnh");

        jOK.setText("OK");
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });

        jChonNgay.setText("Chọn ngày");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ 1-7/5", "Từ 8-14/5", "Từ 15-21/5", "Từ 22-28/5" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        JQuit.setText("QUIT");
        JQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JQuitActionPerformed(evt);
            }
        });

        jCheckGTGD.setText("Giá trị giao dịch");

        jCheckDauTuNN.setText("Đầu tư theo nhóm ngành");
        jCheckDauTuNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckDauTuNNActionPerformed(evt);
            }
        });

        textResult.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                textResultComponentShown(evt);
            }
        });
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckDauTuNN, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckTangGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckKLKL, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckGTGD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckChamTranSan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                            .addComponent(jChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChonTag, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textResult, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChonTag, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckTangGiamGia)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckKLKL)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckChamTranSan)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckGTGD)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckDauTuNN)
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JQuit)
                            .addComponent(jOK)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textResult, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    public String docFile(String fileName) throws IOException{
        BufferedReader br = null;
        StringBuffer stb = new StringBuffer();
        br = new BufferedReader(new FileReader(fileName));
        String textline;
        textline = br.readLine();
        while(textline!= null){
            stb.append(textline+"\n");
            textline= br.readLine();
        }
        return stb.toString();
    }
    private void jCheckTangGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }                                                 

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void JQuitActionPerformed(java.awt.event.ActionEvent evt) {                                      
        System.exit(0);
    }                                     

    private void jCheckDauTuNNActionPerformed(java.awt.event.ActionEvent evt) {                                              
    }                                             

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {                                    
       int index = jComboBox1.getSelectedIndex();

        if(index == 0) {
    		ReadFileCSV readfile = new ReadFileCSV("data\\input\\input2.csv");
    		CauThayDoiGia cauThayDoiGia = new CauThayDoiGia(readfile.listcp());
    		CauKLKL cauKLKL = new CauKLKL(readfile.listcp());
    		Cau cau = new Cau(readfile.listcp());
			InCauNN incaunn = new InCauNN(readfile.listcp());
			File file = new File("data/out.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
			} catch (Exception e) {
			}
			if(jCheckTangGiamGia.isSelected()) {
				System.out.println("\n=================================TĂNG GIẢM GIÁ====================================================================");
				cauThayDoiGia.inCau();
			}
			if(jCheckKLKL.isSelected()) {
				System.out.println("\n=================================KHỐI LƯỢNG KHỚP LỆNH====================================================================");
				cauKLKL.inCauKLKL();
			}
			if(jCheckGTGD.isSelected()) {
				System.out.println("\n=================================GIÁ TRỊ GIAO DỊCH====================================================================");
				cau.inCau();
			}
			if(jCheckChamTranSan.isSelected()) {
				System.out.println("\n=================================CHẠM TRẦN CHẠM SÀN====================================================================");
				ServicerInterface servicerInterface = new Servicer();
				List<ChungKhoan> list = servicerInterface.convert(readfile.listcp());
				servicerInterface.listGiaDongCuaChamTranSan(list);
				servicerInterface.listGiaCaoNhatChamTran(list);
				servicerInterface.ListGiaThapNhatChamSan(list);
				
			}
			if(jCheckDauTuNN.isSelected()) {
				System.out.println("\n=================================ĐẦU TƯ THEO NHÓM NGÀNH====================================================================");
				incaunn.inCau();
			}
    	}
     	if(index == 1) {
    		ReadFileCSV readfile = new ReadFileCSV("data\\input\\input3.csv");
    		CauThayDoiGia cauThayDoiGia = new CauThayDoiGia(readfile.listcp());
    		CauKLKL cauKLKL = new CauKLKL(readfile.listcp());
    		Cau cau = new Cau(readfile.listcp());
			InCauNN incaunn = new InCauNN(readfile.listcp());
			File file = new File("data/out.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
			} catch (Exception e) {
			}
			if(jCheckTangGiamGia.isSelected()) {
				System.out.println("\n=================================TĂNG GIẢM GIÁ====================================================================");
				cauThayDoiGia.inCau();
			}
			if(jCheckKLKL.isSelected()) {
				System.out.println("\n=================================KHỐI LƯỢNG KHỚP LỆNH====================================================================");
				cauKLKL.inCauKLKL();
			}
			if(jCheckGTGD.isSelected()) {
				System.out.println("\n=================================GIÁ TRỊ GIAO DỊCH====================================================================");
				cau.inCau();
			}
			if(jCheckChamTranSan.isSelected()) {
				System.out.println("\n=================================CHẠM TRẦN CHẠM SÀN====================================================================");
				ServicerInterface servicerInterface = new Servicer();
				List<ChungKhoan> list = servicerInterface.convert(readfile.listcp());
				servicerInterface.listGiaDongCuaChamTranSan(list);
				servicerInterface.listGiaCaoNhatChamTran(list);
				servicerInterface.ListGiaThapNhatChamSan(list);
				
			}
			if(jCheckDauTuNN.isSelected()) {
				System.out.println("\n=================================ĐẦU TƯ THEO NHÓM NGÀNH====================================================================");
				incaunn.inCau();
			}
    	}
     	if(index == 2) {
    		ReadFileCSV readfile = new ReadFileCSV("data\\input\\input4.csv");
    		CauThayDoiGia cauThayDoiGia = new CauThayDoiGia(readfile.listcp());
    		CauKLKL cauKLKL = new CauKLKL(readfile.listcp());
    		Cau cau = new Cau(readfile.listcp());
			InCauNN incaunn = new InCauNN(readfile.listcp());
			File file = new File("data/out.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
			} catch (Exception e) {
			}
			if(jCheckTangGiamGia.isSelected()) {
				System.out.println("\n=================================TĂNG GIẢM GIÁ====================================================================");
				cauThayDoiGia.inCau();
			}
			if(jCheckKLKL.isSelected()) {
				System.out.println("\n=================================KHỐI LƯỢNG KHỚP LỆNH====================================================================");
				cauKLKL.inCauKLKL();
			}
			if(jCheckGTGD.isSelected()) {
				System.out.println("\n=================================GIÁ TRỊ GIAO DỊCH====================================================================");
				cau.inCau();
			}
			if(jCheckChamTranSan.isSelected()) {
				System.out.println("\n=================================CHẠM TRẦN CHẠM SÀN====================================================================");
				ServicerInterface servicerInterface = new Servicer();
				List<ChungKhoan> list = servicerInterface.convert(readfile.listcp());
				servicerInterface.listGiaDongCuaChamTranSan(list);
				servicerInterface.listGiaCaoNhatChamTran(list);
				servicerInterface.ListGiaThapNhatChamSan(list);
				
			}
			if(jCheckDauTuNN.isSelected()) {
				System.out.println("\n=================================ĐẦU TƯ THEO NHÓM NGÀNH====================================================================");
				incaunn.inCau();
			}
    	}
     	if(index == 3) {
    		ReadFileCSV readfile = new ReadFileCSV("data\\input\\input5.csv");
    		CauThayDoiGia cauThayDoiGia = new CauThayDoiGia(readfile.listcp());
    		CauKLKL cauKLKL = new CauKLKL(readfile.listcp());
    		Cau cau = new Cau(readfile.listcp());
			InCauNN incaunn = new InCauNN(readfile.listcp());
			File file = new File("data/out.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
			} catch (Exception e) {
			}
			if(jCheckTangGiamGia.isSelected()) {
				System.out.println("\n=================================TĂNG GIẢM GIÁ====================================================================");
				cauThayDoiGia.inCau();
			}
			if(jCheckKLKL.isSelected()) {
				System.out.println("\n=================================KHỐI LƯỢNG KHỚP LỆNH====================================================================");
				cauKLKL.inCauKLKL();
			}
			if(jCheckGTGD.isSelected()) {
				System.out.println("\n=================================GIÁ TRỊ GIAO DỊCH====================================================================");
				cau.inCau();
			}
			if(jCheckChamTranSan.isSelected()) {
				System.out.println("\n=================================CHẠM TRẦN CHẠM SÀN====================================================================");
				ServicerInterface servicerInterface = new Servicer();
				List<ChungKhoan> list = servicerInterface.convert(readfile.listcp());
				servicerInterface.listGiaDongCuaChamTranSan(list);
				servicerInterface.listGiaCaoNhatChamTran(list);
				servicerInterface.ListGiaThapNhatChamSan(list);
				
			}
			if(jCheckDauTuNN.isSelected()) {
				System.out.println("\n=================================ĐẦU TƯ THEO NHÓM NGÀNH====================================================================");
				incaunn.inCau();
			}
    	}
        JOptionPane.showMessageDialog(rootPane, "Bạn đã in ra file");
        
        try {
            textResult.append(docFile("data\\out.txt"));
        } catch (IOException ex) {
            Logger.getLogger(NewApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                   

    private void textResultComponentShown(java.awt.event.ComponentEvent evt) {                                          
        
    }                                         


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewApplication().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JQuit;
    private javax.swing.JCheckBox jCheckChamTranSan;
    private javax.swing.JCheckBox jCheckDauTuNN;
    private javax.swing.JCheckBox jCheckGTGD;
    private javax.swing.JCheckBox jCheckKLKL;
    private javax.swing.JCheckBox jCheckTangGiamGia;
    private javax.swing.JLabel jChonNgay;
    private javax.swing.JLabel jChonTag;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton jOK;
    private javax.swing.JMenuBar menuBar;
    private java.awt.TextArea textResult;

}
