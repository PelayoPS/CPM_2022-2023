package ou.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblMcDonalds;
	private JLabel lblProducts;
	private JComboBox comboBox;
	private JLabel lblUnits;
	private JSpinner spinnerUnits;
	private JButton btnAdd;
	private JLabel lblOrderPrice;
	private JTextField textFieldOrderPrice;
	private JButton btnNext;
	private JButton btnCancel;
	
	private RegistryForm rf = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);// makes the window spawn in the middle of the screen
					frame.setVisible(true);//sets the window as visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);//makes the window not resizable
		/*
		 * sets the icon of the window
		 */
		setIconImage(Toolkit.getDefaultToolkit()
		.getImage(MainWindow.class.getResource("/uo/cpm/p3/ui/img/logo.PNG")));
		setTitle("Mc.Donalds");//sets the title of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the default close operation
		setBounds(100, 100, 683, 437);//sets the dimensions of the window
		contentPane = new JPanel();//creates a new JPanel
		contentPane.setBackground(Color.WHITE);//sets the background color of the JPanel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//sets the border of the JPanel
		setContentPane(contentPane);//sets the content pane of the window
		contentPane.setLayout(null);//sets the layout of the JPanel to absolute
		contentPane.add(getLblLogo());//adds the label lblLogo to the JPanel
		contentPane.add(getLblMcDonalds());//adds the label lblMcDonalds to the JPanel
		contentPane.add(getLblProducts());//adds the label lblProducts to the JPanel
		contentPane.add(getComboBox());//adds the comboBox to the JPanel
		contentPane.add(getLblUnits());//adds the label lblUnits to the JPanel
		contentPane.add(getSpinnerUnits());//adds the spinner to the JPanel
		contentPane.add(getBtnAdd());//adds the button btnAdd to the JPanel
		contentPane.add(getLblOrderPrice());//adds the label lblOrderPrice to the JPanel
		contentPane.add(getTextFieldOrderPrice());//adds the textField to the JPanel
		contentPane.add(getBtnNext());//adds the button btnNext to the JPanel
		contentPane.add(getBtnCancel());//adds the button btnCancel to the JPanel
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {//checks if the label is null
			lblLogo = new JLabel("");//creates a new label with no title
			/*
			 * sets the icon of the label
			 */
			lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/uo/cpm/p3/ui/img/logo.PNG")));
			lblLogo.setBounds(10, 11, 207, 136);//sets the dimensions of the label
		}
		return lblLogo;
	}
	private JLabel getLblMcDonalds() {
		if (lblMcDonalds == null) {//checks if the label is null
			lblMcDonalds = new JLabel("McDonald's");//creates a new label with the title McDonald's
			lblMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 52));//sets the font of the label
			lblMcDonalds.setBounds(227, 47, 340, 71);//sets the dimensions of the label
		}
		return lblMcDonalds;
	}
	private JLabel getLblProducts() {
		if (lblProducts == null) {//checks if the label is null
			lblProducts = new JLabel("Products:");//creates a new label with the title Products:
			lblProducts.setFont(new Font("Arial", Font.PLAIN, 15));//sets the font of the label
			lblProducts.setBounds(20, 158, 83, 23);//sets the dimensions of the label
		}
		return lblProducts;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {//checks if the comboBox is null
			comboBox = new JComboBox();//creates a new comboBox
			comboBox.setBounds(20, 192, 364, 22);//sets the dimensions of the comboBox
		}
		return comboBox;
	}
	private JLabel getLblUnits() {
		if (lblUnits == null) {//checks if the label is null
			lblUnits = new JLabel("Units:");//creates a new label with the title Units:
			lblUnits.setFont(new Font("Arial", Font.PLAIN, 15));//sets the font of the label
			lblUnits.setBounds(416, 162, 63, 19);//sets the dimensions of the label
		}
		return lblUnits;
	}
	private JSpinner getSpinnerUnits() {
		if (spinnerUnits == null) {//checks if the spinner is null
			spinnerUnits = new JSpinner();//creates a new spinner
			/*
			 * sets the model of the spinner
			 */
			spinnerUnits.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerUnits.setBounds(416, 193, 63, 20);//sets the dimensions of the spinner
		}
		return spinnerUnits;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setMnemonic('A');
			btnAdd.setBackground(Color.GREEN);
			btnAdd.setForeground(Color.BLACK);
			btnAdd.setBounds(510, 187, 113, 33);
		}
		return btnAdd;
	}
	private JLabel getLblOrderPrice() {
		if (lblOrderPrice == null) {
			lblOrderPrice = new JLabel("Order price:");
			lblOrderPrice.setFont(new Font("Arial", Font.PLAIN, 15));
			lblOrderPrice.setBounds(416, 224, 89, 23);
		}
		return lblOrderPrice;
	}
	private JTextField getTextFieldOrderPrice() {
		if (textFieldOrderPrice == null) {
			textFieldOrderPrice = new JTextField();
			textFieldOrderPrice.setEditable(false);
			textFieldOrderPrice.setBounds(416, 258, 120, 33);
			textFieldOrderPrice.setColumns(10);
		}
		return textFieldOrderPrice;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCustomerInformationDialog();
				}
			});
			btnNext.setMnemonic('N');
			btnNext.setForeground(Color.BLACK);
			btnNext.setBackground(Color.GREEN);
			btnNext.setBounds(416, 354, 113, 33);
		}
		return btnNext;
	}
	private void showCustomerInformationDialog() {
		this.rf = new RegistryForm(this);
		this.rf.setLocationRelativeTo(this);
		this.rf.setModal(true);
		this.rf.setVisible(true);
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('C');
			btnCancel.setForeground(Color.BLACK);
			btnCancel.setBackground(Color.RED);
			btnCancel.setBounds(544, 354, 113, 33);
		}
		return btnCancel;
	}
}
