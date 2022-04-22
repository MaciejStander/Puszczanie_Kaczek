package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

//top panel shows the best shot and the latest shot, as well as saves them in the chosen file
public class ScorePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel panelLeft=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelRight=new JPanel();
	ScoreLabel label1=new ScoreLabel("Najlepszy rzut:");
	ScoreLabel label2=new ScoreLabel("Liczba odbi�: n");
	ScoreLabel label3=new ScoreLabel("Odleg�o��: s");
	ScoreLabel label4=new ScoreLabel("Czas lotu: t");
	ScoreLabel label5=new ScoreLabel("Ostatni rzut:");
	ScoreLabel label6=new ScoreLabel("Liczba odbi�: n");
	ScoreLabel label7=new ScoreLabel("Odleg�o��: s");
	ScoreLabel label8=new ScoreLabel("Czas lotu: t");
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/sound.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/soundoff.png"));
	JButton button1=new JButton("Zapisz");
	JButton button2=new JButton("Zapisz");
	JButton button3=new JButton(icon1);
	JButton button4=new JButton("PL/EN");
	JButton button5=new JButton("HISTORIA");
	JButton button6=new JButton("Zapisz");
	JFileChooser chooser=new JFileChooser();
	int soundButtonMode=1;
	int languageMode=0;
	JLabel label9=new JLabel("xd \t xd \t xd \t");
	
	public ScorePanel() {
		super();
		setLayout(new GridLayout(1,3));
		
		//splitting ScorePanel into 3 panels
		add(panelLeft);
		add(panelCenter);
		add(panelRight);
		//working on left panel
		panelLeft.setBackground(Color.black);
		panelLeft.setLayout(new GridBagLayout());
		//adding "Najlepszy rzut:" label
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(5,5,5,5);
		label1.setHorizontalAlignment(JLabel.CENTER);
		panelLeft.add(label1,c);
		//adding "Liczba odbi�: n" label
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		panelLeft.add(label2,c);
		//adding "Zapisz" button
		c.gridx=0;
		c.gridy=1;
		c.gridheight=2;
		c.ipady=10;
		c.insets=new Insets(5,15,5,15);
		button1.setBackground(Color.green);
		button1.setForeground(Color.white);
		button1.setFont(new Font("Calibri", Font.PLAIN,24));
		panelLeft.add(button1,c);
		//adding "Odleg�o��: s" label
		c.gridx=1;
		c.gridy=1;
		c.gridheight=1;
		c.ipady=0;
		c.insets=new Insets(5,5,5,5);
		panelLeft.add(label3,c);
		//adding "Czas lotu: t" label
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(0,5,0,5);
		panelLeft.add(label4,c);
		
		
		//working on center panel
		panelCenter.setBackground(Color.black);
		panelCenter.setLayout(new GridBagLayout());
		//adding "Ostatni rzut:" label
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(5,5,5,5);
		label5.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(label5,c);
		//adding "Liczba odbi�: n" label
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label6,c);
		//adding "Zapisz" button
		c.gridx=0;
		c.gridy=1;
		c.gridheight=2;
		c.ipady=10;
		c.insets=new Insets(5,15,5,15);
		button2.setBackground(Color.green);
		button2.setForeground(Color.white);
		button2.setFont(new Font("Calibri", Font.PLAIN,24));
		panelCenter.add(button2,c);
		//adding "Odleg�o��: s" label
		c.gridx=1;
		c.gridy=1;
		c.gridheight=1;
		c.ipady=0;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label7,c);
		//adding "Czas lotu: t" label
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label8,c);
		
		
		//working on right panel
		panelRight.setBackground(Color.black);
		panelRight.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(20,10,20,10);
		//adding music button
		button3.setBackground(Color.green);
		panelRight.add(button3,c);
		//adding language switch button
		c.gridx=1;
		c.gridy=0;
		button4.setBackground(Color.green);
		button4.setForeground(Color.white);
		button4.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button4,c);
		//adding history button
		c.gridx=2;
		c.gridy=0;
		button5.setBackground(Color.green);
		button5.setForeground(Color.white);
		button5.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button5,c);
		
		//adding listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button4.setActionCommand("4");
		button5.setActionCommand("5");
		button6.setActionCommand("6");
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("1")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write("xd");
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		
		if(e.getActionCommand().equals("2")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write("xd");
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		
		if(e.getActionCommand().equals("3")) {
			if(soundButtonMode==1) {
				button3.setIcon(icon2);
				soundButtonMode=0;
			}
			else {
				button3.setIcon(icon1);
				soundButtonMode=1;
			}
		}
		
		if(e.getActionCommand().equals("4")) {
			if(languageMode==0)
				languageMode=1;
			else
				languageMode=0;
		}
		
		if(e.getActionCommand().equals("5")) {
			JDialog dialog=new JDialog(Main.frame);
			dialog.setSize(600, 400);
			dialog.setTitle("Historia");
			dialog.setLayout(new GridLayout(2,1));
			dialog.add(label9);
			dialog.add(button6);
			
			
			
			
			
			dialog.setVisible(true);
		}
		
		if(e.getActionCommand().equals("6")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write("xd");
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
}
