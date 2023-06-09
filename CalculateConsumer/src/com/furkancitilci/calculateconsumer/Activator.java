package com.furkancitilci.calculateconsumer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.furkancitilci.utils.Convertable;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private JTextField textFieldBirinciSayi;
	private JTextField textFieldIkınciSayi;
	private JTextField textFieldSonuc;
	private JLabel lblNewLabel;
	private JLabel lblIkinciSay;
	private JLabel lblSonu;
	private JButton btnNewButton;
	private JButton btnkar;
	private JButton btnarp;
	private JButton btnBl;
	private JLabel lblNewLabel_1;


	static BundleContext getContext() {
		return context;
	}
	
	private void languageSet() {

		ResourceBundle resourceBundle =  ResourceBundle.getBundle("com/furkancitilci/config/resource_bundle");
		
		lblNewLabel.setText(resourceBundle.getString("word30"));
		lblIkinciSay.setText(resourceBundle.getString("word31"));
		lblSonu.setText(resourceBundle.getString("word32"));
		btnNewButton.setText(resourceBundle.getString("word33"));
		btnkar.setText(resourceBundle.getString("word34"));
		btnarp.setText(resourceBundle.getString("word35"));
		btnBl.setText(resourceBundle.getString("word36"));
		lblNewLabel_1.setText(resourceBundle.getString("word37"));
		
	}
	
	//User interface design
	private void initialize() {
		JFrame f = new JFrame();
        f.setBounds(100, 100, 854, 508);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		textFieldBirinciSayi = new JTextField();
		textFieldBirinciSayi.setBounds(236, 87, 399, 44);
		f.getContentPane().add(textFieldBirinciSayi);
		textFieldBirinciSayi.setColumns(10);
		
		lblNewLabel = new JLabel("Birinci Sayı");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 87, 146, 44);
		f.getContentPane().add(lblNewLabel);
        f.setVisible(true);
        
        lblIkinciSay = new JLabel("İkinci Sayı");
		lblIkinciSay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIkinciSay.setBounds(46, 175, 146, 44);
		f.getContentPane().add(lblIkinciSay);
		
		textFieldIkınciSayi = new JTextField();
		textFieldIkınciSayi.setColumns(10);
		textFieldIkınciSayi.setBounds(236, 175, 399, 44);
		f.getContentPane().add(textFieldIkınciSayi);
		
		lblSonu = new JLabel("Sonuç");
		lblSonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSonu.setBounds(46, 262, 146, 44);
		f.getContentPane().add(lblSonu);
		
		textFieldSonuc = new JTextField();
		textFieldSonuc.setColumns(10);
		textFieldSonuc.setBounds(236, 262, 399, 44);
		f.getContentPane().add(textFieldSonuc);
		
		btnNewButton = new JButton("Topla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Number conversions of expressions entered by the user are performed
				long num1 = Convertable.wordToNumber(textFieldBirinciSayi.getText());
				long num2= Convertable.wordToNumber(textFieldIkınciSayi.getText());
				//Mathematical operations of the converted numbers 
				long result = num1+num2;
				
				//data of type char number to word convert
				textFieldSonuc.setText(Convertable.numberToWord(result));
			
			}
		});
		
		btnNewButton.setBounds(127, 374, 85, 21);
		f.getContentPane().add(btnNewButton);
		
		btnkar = new JButton("Çıkar");
		btnkar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Number conversions of expressions entered by the user are performed
				long num1 = Convertable.wordToNumber(textFieldBirinciSayi.getText());
				long num2= Convertable.wordToNumber(textFieldIkınciSayi.getText());
				//Mathematical operations of the converted numbers 
				long result = num1-num2;
				
				//data of type char number to word convert
				textFieldSonuc.setText(Convertable.numberToWord(result));
			}
		});
		btnkar.setBounds(249, 374, 85, 21);
		f.getContentPane().add(btnkar);
		
		btnarp = new JButton("Çarp");
		btnarp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Number conversions of expressions entered by the user are performed
				long num1 = Convertable.wordToNumber(textFieldBirinciSayi.getText());
				long num2= Convertable.wordToNumber(textFieldIkınciSayi.getText());
				//Mathematical operations of the converted numbers 
				long result = num1*num2;
				//data of type char number to word convert
				textFieldSonuc.setText(Convertable.numberToWord(result));
			}
		});
		btnarp.setBounds(366, 374, 85, 21);
		f.getContentPane().add(btnarp);
		
		btnBl = new JButton("Böl");
		btnBl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Number conversions of expressions entered by the user are performed
				long num1 = Convertable.wordToNumber(textFieldBirinciSayi.getText());
				long num2= Convertable.wordToNumber(textFieldIkınciSayi.getText());
				//Mathematical operations of the converted numbers 
				long result = num1/num2;
				//data of type char number to word convert
				textFieldSonuc.setText(Convertable.numberToWord(result));
			}
		});
		btnBl.setBounds(501, 374, 85, 21);
		f.getContentPane().add(btnBl);
		
		lblNewLabel_1 = new JLabel("Dil");
		lblNewLabel_1.setBounds(703, 25, 85, 13);
		f.getContentPane().add(lblNewLabel_1);
		
	
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//With combox, two language options are offered to the user side
				if(comboBox.getSelectedItem().toString().equalsIgnoreCase("English")) {
					Locale.setDefault(new Locale("en","EN"));
					languageSet();
					
				}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Turkish")) {
					Locale.setDefault(new Locale("tr","TR"));
					languageSet();
				}
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Turkish", "English"}));
		comboBox.setBounds(703, 48, 62, 21);
		f.getContentPane().add(comboBox);
		
		
		
		
	}


	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Starting...");
		//When the framework is started, the GUI is created
		initialize();
		//local gui starts in english
		Locale.setDefault(new Locale("en","EN"));
		languageSet();
	     System.out.println("Started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		 System.out.println("Stopped");
	}

}
