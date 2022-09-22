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
		setTitle("McDonald's::Order Confirmation");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmationDialog.class.getResource("/uo/cpm/p3/ui/img/logo.PNG")));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblGreenTick());
		getContentPane().add(getLblProcessingOrder());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTextFieldOrderCode());
		getContentPane().add(getBtnNewButton());
		setBounds(100, 100, 365, 217);

	}
	private JLabel getLblGreenTick() {
		if (lblGreenTick == null) {
			lblGreenTick = new JLabel("");
			lblGreenTick.setIcon(new ImageIcon(ConfirmationDialog.class.getResource("/uo/cpm/p3/ui/img/ok.png")));
			lblGreenTick.setBounds(10, 11, 50, 46);
		}
		return lblGreenTick;
	}
	private JLabel getLblProcessingOrder() {
		if (lblProcessingOrder == null) {
			lblProcessingOrder = new JLabel("We are processing your order");
			lblProcessingOrder.setFont(new Font("Arial", Font.BOLD, 16));
			lblProcessingOrder.setBounds(72, 11, 278, 46);
		}
		return lblProcessingOrder;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("The order code is:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNewLabel.setBounds(72, 68, 118, 29);
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldOrderCode() {
		if (textFieldOrderCode == null) {
			textFieldOrderCode = new JTextField();
			textFieldOrderCode.setEditable(false);
			textFieldOrderCode.setBounds(200, 68, 110, 29);
			textFieldOrderCode.setColumns(10);
		}
		return textFieldOrderCode;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Finish");
			btnNewButton.setBackground(Color.GREEN);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton.setBounds(221, 144, 89, 23);
		}
		return btnNewButton;
	}
}
