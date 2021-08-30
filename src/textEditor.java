import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;

public class textEditor {
		
	private static graphicComponents gComponents = new graphicComponents(); 
	
	public static Component initializingComponents() {
		
		gComponents.newPanel();
		gComponents.newMenuBar();
		
		gComponents.getMenuBar().add(gComponents.newMenu("File"));
		
		gComponents.newFileDialog("File Manager", FileDialog.SAVE);
		gComponents.getMenu().add(gComponents.newMenuItem("Save", KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		gComponents.getMenuItem().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					gComponents.getFileDialog().setVisible(true);
					if (gComponents.getFileDialog().getFile() == null) {
						return;
					}
					
					String archiveName = gComponents.getFileDialog().getDirectory() + gComponents.getFileDialog().getFile();
					FileWriter out = new FileWriter(archiveName);
					out.write(gComponents.getTextArea().getText());
					out.close();
					JOptionPane.showMessageDialog(null, "Successfully Saved!", "Status", JOptionPane.WARNING_MESSAGE);
					
				} catch (IOException error) {
					
					JOptionPane.showMessageDialog(null, "There was an error saving the archive\n" + error.toString(), "Status", JOptionPane.WARNING_MESSAGE);
					
				}
				
				
			}
		});
		
		
		gComponents.newFileDialog("File Manager", FileDialog.LOAD);
		gComponents.getMenu().add(gComponents.newMenuItem("Open", KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		gComponents.getMenuItem().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					gComponents.getFileDialog().setVisible(true);
					if (gComponents.getFileDialog().getFile() == null) {
						return;
					}
					String archiveName = gComponents.getFileDialog().getDirectory() + gComponents.getFileDialog().getFile();
					FileReader in = new FileReader(archiveName);
					String s = "";
					int i = in.read();
					while (i != -1) {
						s += (char) i;
						i = in.read();
					}
					gComponents.getTextArea().setText(s);
					in.close();
				} catch (IOException erro) {
					JOptionPane.showMessageDialog(null, "There was an error opening the archive\n" + erro.toString(), "Status", JOptionPane.WARNING_MESSAGE);
				}

				
			}
		});
		
		
		gComponents.getMenu().add(gComponents.newMenuItem("Exit", KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		gComponents.getMenuItem().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newTextArea(10, 10, 700, 500));
		
		
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		
		
		gComponents.getPane().add(gComponents.newSpinner(745, 30, 40, 20));
		gComponents.getSpinner().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], gComponents.getTextArea().getFont().getStyle(), (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
				
			}
			
		});
		
		
		gComponents.getPane().add(gComponents.newComboBox(800, 30, 100, 20, fonts));
		gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.PLAIN, (int) gComponents.getSpinner().getValue()));
		gComponents.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], gComponents.getTextArea().getFont().getStyle(), (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(745, 60, 45, 30, "B"));
		gComponents.getButton().setFont(new Font("Arial", Font.BOLD, 14));
		gComponents.getButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			
				Font font = new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.BOLD, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes);
				
				if(gComponents.getTextArea().getFont().equals(font)) {
					
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.PLAIN, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}else {
					
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.BOLD, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}
				
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(800, 60, 45, 30, "I"));
		gComponents.getButton().setFont(new Font("Times New Roman", Font.ITALIC, 20));
		gComponents.getButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					
				Font font = new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.ITALIC, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes);
				
				if(gComponents.getTextArea().getFont().equals(font)) {
					
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.PLAIN, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}else {
					
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], Font.ITALIC, (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}
					
			}
		});
		
		Map<TextAttribute, Integer> buttonFontAttributes = new HashMap<TextAttribute, Integer>();
		
		fontAttributes.put(TextAttribute.UNDERLINE, -1);
		buttonFontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		gComponents.getPane().add(gComponents.newButton(855, 60, 45, 30, "U"));
		gComponents.getButton().setFont(new Font("Arial", Font.BOLD, 14).deriveFont(buttonFontAttributes));
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				Font font = new Font(fonts[gComponents.getComboBox().getSelectedIndex()], gComponents.getTextArea().getFont().getStyle(), (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes);
				
				if(gComponents.getTextArea().getFont().equals(font)) {
					
					fontAttributes.put(TextAttribute.UNDERLINE, -1);
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], gComponents.getTextArea().getFont().getStyle(), (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}else {
					
					fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					gComponents.getTextArea().setFont(new Font(fonts[gComponents.getComboBox().getSelectedIndex()], gComponents.getTextArea().getFont().getStyle(), (int) gComponents.getSpinner().getValue()).deriveFont(fontAttributes));
					
				}
					
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(745, 100, 45, 30, null));
		gComponents.getButton().setBackground(Color.BLACK);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.BLACK);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(800, 100, 45, 30, null));
		gComponents.getButton().setBackground(Color.WHITE);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.WHITE);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(745, 140, 45, 30, null));
		gComponents.getButton().setBackground(Color.RED);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.RED);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(800, 140, 45, 30, null));
		gComponents.getButton().setBackground(Color.GREEN);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.GREEN);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(745, 180, 45, 30, null));
		gComponents.getButton().setBackground(Color.BLUE);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.BLUE);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(800, 180, 45, 30, null));
		gComponents.getButton().setBackground(Color.YELLOW);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.YELLOW);
				
			}
		});
		
		gComponents.getPane().add(gComponents.newButton(855, 100, 45, 30, null));
		gComponents.getButton().setBackground(Color.GRAY);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.GRAY);
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(855, 140, 45, 30, null));
		gComponents.getButton().setBackground(Color.MAGENTA);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.MAGENTA);
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(855, 180, 45, 30, null));
		gComponents.getButton().setBackground(Color.ORANGE);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.ORANGE);
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(745, 220, 45, 30, null));
		gComponents.getButton().setBackground(Color.PINK);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.PINK);
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(800, 220, 45, 30, null));
		gComponents.getButton().setBackground(Color.CYAN);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.CYAN);
				
			}
		});
		
		
		gComponents.getPane().add(gComponents.newButton(855, 220, 45, 30, null));
		gComponents.getButton().setBackground(Color.LIGHT_GRAY);
		gComponents.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gComponents.getTextArea().setForeground(Color.LIGHT_GRAY);
				
			}
		});
		
		return gComponents.getPane();
	}
	
	public static void main(String []args) {
		
		gComponents.newFrame(950, 580, "BRAND NEW REVOLUTIONARY TEXT EDITOR", false, "C:\\Users\\CLIENTE\\Downloads\\wordPad.png");
		gComponents.getFrame().getContentPane().add(initializingComponents());
		
	}
}


