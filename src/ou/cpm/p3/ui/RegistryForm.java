package ou.cpm.p3.ui;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ou.cpm.p3.logic.FieldValidator;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;

public class RegistryForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel customerInformationPanel;
	private JTextField textFieldName;
	private JComboBox comboBoxBirth;
	private JLabel lblNameAndSurname;
	private JLabel lblBirthDate;
	private JLabel lblPassword;
	private JLabel lblPasswordRepeat;
	private JButton btnNext;
	private JButton btnCancel;
	private JPanel panelOrder;
	private JRadioButton radioBtnOnSite;
	private JRadioButton radioBtnTakeAway;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private final ButtonGroup buttonGroupOrder = new ButtonGroup();
	
	private MainWindow mw = null;
	private ConfirmationDialog cd = null;
	
	/**
	 * runs the main application
	 * use only for testing purposes
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistryForm frame = new RegistryForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public RegistryForm(MainWindow mw) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistryForm.class.getResource("/uo/cpm/p3/ui/img/logo.PNG")));//sets the icon of the window
		
		this.mw = mw;//keeps a reference of the main window
		
		setResizable(false);//makes it not resizable
		setTitle("McDonald's::Customer Information");//sets the title
		setBounds(100, 100, 600, 300);//sets the dimensions of the window
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//this way he main dialog won't be closed if this one is
		contentPane = new JPanel();//creates the panel
		contentPane.setBackground(new Color(255, 255, 255));//sets the background to white
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// creates an invisible border for the main panel
		setContentPane(contentPane);//sets the panel
		contentPane.setLayout(null);//sets the layout to absolute
		contentPane.add(getCustomerInformationPanel());//adds the customer info panel
		contentPane.add(getBtnNext());//adds the btn next
		contentPane.add(getBtnCancel());//adds the btn cancel
		contentPane.add(getPanelOrder());//adds the panel order
	}
	
	private JPanel getCustomerInformationPanel() {
		if (customerInformationPanel == null) {//if it doesnt exist
			customerInformationPanel = new JPanel();//creates the panel
			customerInformationPanel.setLayout(null);//sets the layout to absolute
			/* sets a line border with the title inside */
			customerInformationPanel.setBorder(new TitledBorder(null, "CustomerI nformation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			customerInformationPanel.setBackground(Color.WHITE);
			customerInformationPanel.setBounds(9, 6, 565, 204);//sets the dimensions of the panel
			customerInformationPanel.add(getTextFieldName());//adds the name text field
			customerInformationPanel.add(getBirthComboBox());//adds the birth combobox
			customerInformationPanel.add(getLblNameAndSurname());//adds the label for name and surname
			customerInformationPanel.add(getLblBirthDate());//adds the birth date label
			customerInformationPanel.add(getLblPassword());//adds the label password
			customerInformationPanel.add(getLblPasswordRepeat());//adds the label password repeat
			customerInformationPanel.add(getPasswordField());//adds the password field
			customerInformationPanel.add(getPasswordFieldRepeat());//adds the password field repeat
		}
		return customerInformationPanel;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {//if doesn't exist
			textFieldName = new JTextField();//creates the textfield
			textFieldName.setToolTipText("Introduce name and surname");//adds a tooltip
			textFieldName.setBounds(176, 36, 304, 27);//sets the dimensions
		}
		return textFieldName;
	}
	private JComboBox getBirthComboBox() {
		if (comboBoxBirth == null) {//if doesn't exist
			/**
			 * iterates from 1950 to the current year and adds it to the combobox
			 */
			ArrayList<String> yearsList = new ArrayList<String>();
			for(int years = 1950; years <= Calendar.getInstance().get(Calendar.YEAR); years++) {
			    yearsList.add(years+"");
			}
			comboBoxBirth = new JComboBox(yearsList.toArray());
			comboBoxBirth.setToolTipText("Select your birthdate");//adds a tooltip
			comboBoxBirth.setBounds(176, 73, 304, 27);//sets the dimensions
			//can be used to start the combobox closer to the usual age of the users
			//comboBoxBirth.setSelectedIndex(40);
			
		}
		return comboBoxBirth;
	}
	private JLabel getLblNameAndSurname() {
		if (lblNameAndSurname == null) {//if doesn't exist
			lblNameAndSurname = new JLabel("Name and Surname:");//creates the label
			lblNameAndSurname.setLabelFor(getTextFieldName());//sets the label for the textfield
			lblNameAndSurname.setToolTipText("");//adds a tooltip
			lblNameAndSurname.setFont(new Font("Tahoma", Font.PLAIN, 13));//sets the font
			lblNameAndSurname.setBounds(24, 41, 123, 14);//sets the dimensions
		}
		return lblNameAndSurname;
	}
	private JLabel getLblBirthDate() {
		if (lblBirthDate == null) {//if doesn't exist
			lblBirthDate = new JLabel("Birthdate:");//sets the label
			lblBirthDate.setLabelFor(getBirthComboBox());//makes this label be related to the combobox
			lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 13));//sets the font
			lblBirthDate.setBounds(24, 79, 102, 14);//sets the dimensions
		}
		return lblBirthDate;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {//if doesn't exist
			lblPassword = new JLabel("Password:");//creates the label
			lblPassword.setLabelFor(getPasswordField());//makes this label be related to the password field
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));//sets the font
			lblPassword.setBounds(24, 107, 102, 33);//sets the dimensions
		}
		return lblPassword;
	}
	private JLabel getLblPasswordRepeat() {
		if (lblPasswordRepeat == null) {//if doesn't exist
			lblPasswordRepeat = new JLabel("Repeat Password:");//creates the label
			lblPasswordRepeat.setToolTipText("");//adds a tooltip to the label
			lblPasswordRepeat.setLabelFor(getPasswordFieldRepeat());//makes this label be related to the password field repeat
			lblPasswordRepeat.setFont(new Font("Tahoma", Font.PLAIN, 13));//sets the font
			lblPasswordRepeat.setBounds(24, 150, 112, 22);//sets the dimensions of the label
		}
		return lblPasswordRepeat;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");//creates the button
			btnNext.setMnemonic('n');//sets the mnemonic
			/*
			 * adds an action listener to the button
			 * when the button is pressed it checks if fields are empty
			 * and if the password is the same as the password repeat
			 * if it shows the confirmation panel
			 * if not it shows an error message
			 */
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!FieldValidator.validateAllFields(getTextFieldName().getText(), getPasswordField().getText(), getPasswordFieldRepeat().getText())) {
						JOptionPane.showMessageDialog(null, "Some fields are not completed");
					} else {
						showConfirmationDialog();
					}
				}
			});
			btnNext.setBackground(Color.GREEN);//sets the background color
			btnNext.setBounds(321, 213, 120, 37);//sets the dimensions
		}
		return btnNext;
	}
	private void showConfirmationDialog() {
		this.cd = new ConfirmationDialog();//creates the confirmation dialog
		this.cd.setLocationRelativeTo(this);//sets the location of the confirmation dialog relative to this window
		this.cd.setModal(true);//sets the confirmation dialog to be modal
		this.cd.setVisible(true);//sets the confirmation dialog to be visible
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");//creates the button
			btnCancel.setMnemonic('c');//sets the mnemonic
			/*
			 * adds an action listener to the button
			 * that closes the window
			 */
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setBackground(Color.RED);//sets the background color
			btnCancel.setBounds(454, 213, 120, 37);//sets the dimensions
		}
		return btnCancel;
	}
	private JPanel getPanelOrder() {
		if (panelOrder == null) {
			panelOrder = new JPanel();//creates the panel
			panelOrder.setLayout(null);//sets the layout to null
			panelOrder.setBorder(new TitledBorder(null, "Order", TitledBorder.LEADING, TitledBorder.TOP, null, null));//sets the border
			panelOrder.setBackground(Color.WHITE);//sets the background color
			panelOrder.setBounds(10, 213, 224, 44);//sets the dimensions
			panelOrder.add(getRadioBtnOnSite());//adds the radio button
			panelOrder.add(getRadioBtnTakeAway());//adds the radio button
		}
		return panelOrder;
	}
	private JRadioButton getRadioBtnOnSite() {
		if (radioBtnOnSite == null) {
			radioBtnOnSite = new JRadioButton("On Site");//creates the radio button
			buttonGroupOrder.add(radioBtnOnSite);//adds the radio button to a button group so only one can be selected
			radioBtnOnSite.setSelected(true);//sets the radio button to be selected by default
			radioBtnOnSite.setBackground(Color.WHITE);//sets the background color
			radioBtnOnSite.setBounds(22, 14, 79, 23);//sets the dimensions
		}
		return radioBtnOnSite;
	}
	private JRadioButton getRadioBtnTakeAway() {
		if (radioBtnTakeAway == null) {
			radioBtnTakeAway = new JRadioButton("Take Away");//creates the radio button
			buttonGroupOrder.add(radioBtnTakeAway);//adds the radio button to a button group so only one can be selected
			radioBtnTakeAway.setBackground(Color.WHITE);//sets teh background color
			radioBtnTakeAway.setBounds(107, 14, 95, 23);//sets the dimensions
		}
		return radioBtnTakeAway;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();//creates the password field
			passwordField.setToolTipText("Introduce your password");//sets the tooltip
			passwordField.setBounds(176, 111, 304, 27);//sets the dimensions
		}
		return passwordField;
	}
	private JPasswordField getPasswordFieldRepeat() {
		if (passwordFieldRepeat == null) {
			passwordFieldRepeat = new JPasswordField();//creates teh password field
			passwordFieldRepeat.setToolTipText("Repeat your password");//sets the tooltip
			passwordFieldRepeat.setBounds(176, 152, 304, 27);//sets the dimensions
		}
		return passwordFieldRepeat;
	}
}

