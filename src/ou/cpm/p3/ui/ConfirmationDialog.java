package ou.cpm.p3.ui;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmationDialog extends JDialog {
	private JLabel lblGreenTick;
	private JLabel lblProcessingOrder;
	private JLabel lblNewLabel;
	private JTextField textFieldOrderCode;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmationDialog dialog = new ConfirmationDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the dialog.
	 */
	public ConfirmationDialog() {
		setTitle("McDonald's::Order Confirmation");//sets the title of the window
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmationDialog.class.getResource("/uo/cpm/p3/ui/img/logo.PNG")));//sets the icon of the window
		getContentPane().setBackground(Color.WHITE);//sets the background color of the window
		getContentPane().setLayout(null);//sets the layout of the window to absolute
		getContentPane().add(getLblGreenTick());//adds the green tick label to the window
		getContentPane().add(getLblProcessingOrder());//adds the processing order label to the window
		getContentPane().add(getLblNewLabel());//adds the label lblNewLabel to the window
		getContentPane().add(getTextFieldOrderCode());//adds the text field textFieldOrderCode to the window
		getContentPane().add(getBtnNewButton());//adds the button btnNewButton to the window
		setBounds(100, 100, 365, 217);//sets the dimensions of the window

	}
	private JLabel getLblGreenTick() {
		if (lblGreenTick == null) {
			lblGreenTick = new JLabel("");//creates a new label
			lblGreenTick.setIcon(new ImageIcon(ConfirmationDialog.class.getResource("/uo/cpm/p3/ui/img/ok.png")));//sets the icon of the label
			lblGreenTick.setBounds(10, 11, 50, 46);//serts the dimensions of the label
		}
		return lblGreenTick;
	}
	private JLabel getLblProcessingOrder() {
		if (lblProcessingOrder == null) {
			lblProcessingOrder = new JLabel("We are processing your order");//creates a new label
			lblProcessingOrder.setFont(new Font("Arial", Font.BOLD, 16));//sets the font of the label
			lblProcessingOrder.setBounds(72, 11, 278, 46);//sets the bound of the label
		}
		return lblProcessingOrder;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("The order code is:");//creates a new label
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));//sets the fonts of the label
			lblNewLabel.setBounds(72, 68, 118, 29);//sets the dimensions of the label
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldOrderCode() {
		if (textFieldOrderCode == null) {
			textFieldOrderCode = new JTextField();//creates a new text field
			textFieldOrderCode.setEditable(false);//sets the text field to be not editable
			textFieldOrderCode.setBounds(200, 68, 110, 29);//sets the dimensions of the text field
			textFieldOrderCode.setColumns(10);//sets the number of columns of the text field
		}
		return textFieldOrderCode;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Finish");//creates a new button
			btnNewButton.setBackground(Color.GREEN);//sets the background color of the button
			/*
			 * adds an action listener to the button
			 * when the button is clicked, all the application is ended
			 */
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton.setBounds(221, 144, 89, 23);//sets the dimensions of the button
		}
		return btnNewButton;
	}
}
