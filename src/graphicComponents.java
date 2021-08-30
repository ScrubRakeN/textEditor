import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class graphicComponents implements LayoutManager{

	private JLabel label;
	private Container container;
	private ImageIcon image;
	private JTextArea textArea;
	private JTextField textField;
	private JFormattedTextField fotmattedTextField;
	private FileReader fileReader;
	private FileDialog fileDialog;
	private JButton button;
	private JPanel pane;
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane, textScroll;
	private JTabbedPane tabbedPane;
	private JCheckBox check;
	private JSpinner spinner;
	private JRadioButton radio;
	private ButtonGroup group;
	private JComboBox comboBox;
	private JList list;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	
	//Instanciating Components
	
	public graphicComponents newFrame(int width, int height, String title, boolean resizable, String url, Component components) {
		
		frame = new JFrame();
		frame.setTitle(title);
		frame.setIconImage(newImage(url).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(components);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(resizable);
		frame.setVisible(true);
		
		return this;
		
	}
	
	public JPanel newPanel() {
		
		pane = new JPanel();
		pane.setLayout(null);
		pane.setVisible(true);
		
		return pane;
		
	}
	
	public JLabel newLabel(int x, int y, int width, int height, String caption, String url) {
		
		label = new JLabel(caption);
		label.setIcon(newImage(url));
		label.setFont(new Font("Arial", Font.BOLD, 17));
		label.setBounds(x, y, width, height);
		label.setVisible(true);
		
		return label;
		
	}
	
	public JTextField newTextField(int x, int y, int width, int height, String caption) {
		
		textField = new JTextField(caption);
		textField.setBounds(x, y, width, height);
		textField.setVisible(true);
		
		return textField;
		
	}
	
	public JScrollPane newScrollPane(int x, int y, int width, int height, String[] items) {
		
		list = new JList(items);
		scrollPane = new JScrollPane(list);
		list.setSelectedIndex(0);
		scrollPane.setBounds(x, y, width, height);
		scrollPane.setFocusable(false);
		
		return scrollPane;
		
	}
	
	public JComboBox newComboBox(int x, int y, int width, int height, String[] items) {
		
		comboBox = new JComboBox(items);
		comboBox.setBounds(x, y, width, height);
		comboBox.setFocusable(false);
		
		return comboBox;
	}
	
	public JSpinner newSpinner(int x, int y, int width, int height) {
		
		spinner = new JSpinner();
		spinner.setValue(20);
		spinner.setBounds(x, y, width, height);
		
		return spinner;
	}
	
	public JButton newButton(int x, int y, int width, int height, String caption) {
		
		button = new JButton(caption);
		button.setBounds(x, y, width, height);
		button.setFocusable(false);
		button.setVisible(true);

		return button;
		
	}
	
	public JScrollPane newTextArea(int x, int y, int width, int height) {
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textScroll = new JScrollPane(textArea);
		textScroll.setBounds(x, y, width, height);
		textScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		return textScroll;
		
	}
	
	public JMenuBar newMenuBar() {
		
		menuBar = new JMenuBar();
		
		return menuBar;
	}
	
	public JMenu newMenu(String menuCaption) {
		
		menu = new JMenu(menuCaption);
		return menu;
	}
	
	public JMenuItem newMenuItem(String itemCaption, int keyEvent, int eventMask) {
		
		menuItem = new JMenuItem(itemCaption);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(keyEvent, eventMask));
		
		return menuItem;
	}
	
	public ImageIcon newImage(String url) {
		
		image = new ImageIcon(url);
		
		return image;
		
	}
	
	public FileDialog newFileDialog(String caption, int mode) {
		
		fileDialog = new FileDialog(frame , caption, mode);
		
		return fileDialog;
	}
	
	//LayoutManager Methods
	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		
	}
	
	//Graphic Components Getters and Setters
	
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(TextArea JtextArea) {
		this.textArea = textArea;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JFormattedTextField getFotmattedTextField() {
		return fotmattedTextField;
	}
	public void setFotmattedTextField(JFormattedTextField fotmattedTextField) {
		this.fotmattedTextField = fotmattedTextField;
	}
	public FileReader getFileReader() {
		return fileReader;
	}
	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	public JPanel getPane() {
		return pane;
	}
	public void setPane(JPanel pane) {
		this.pane = pane;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scroll) {
		this.scrollPane = scroll;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	public JCheckBox getCheckBox() {
		return check;
	}
	public void setCheckBox(JCheckBox check) {
		this.check = check;
	}
	public ButtonGroup getGroup() {
		return group;
	}
	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	public JRadioButton getRadioButton() {
		return radio;
	}
	public void setRadioButton(JRadioButton radio) {
		this.radio = radio;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox combo) {
		this.comboBox = combo;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public JMenu getMenu() {
		return menu;
	}
	public void setMenu(JMenu menu) {
		this.menu = menu;
	}
	public JMenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(JMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public FileDialog getFileDialog() {
		return fileDialog;
	}

	public void setFileDialog(FileDialog fileDialog) {
		this.fileDialog = fileDialog;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

}
