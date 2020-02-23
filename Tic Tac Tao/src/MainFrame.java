import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem reset, exit, contact;
	Controller controller ;
	private JLabel lblO, lblX, lblSpO, lblSpX;
	
	
	
	public JLabel getLblO() {
		return lblO;
	}
	
	public JLabel getLblX() {
		return lblX;
	}
	
	public JMenuItem getReset() {
		return reset;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getContact() {
		return contact;
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(String a, String b) {

		setTitle("Tic Tac Tao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 504);
		setSize(750,614);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu first = new JMenu("game");
		menuBar.add(first);
		
		 reset = new JMenuItem("new Game");
		first.add(reset);
		
		 exit = new JMenuItem("exit");
		first.add(exit);
		
		JMenu second = new JMenu("information");
		menuBar.add(second);
		
		 contact = new JMenuItem("contact");
		second.add(contact);
		 getContentPane().setLayout(null);
		
		lblSpX = new JLabel("Player \"X\" : ");
		lblSpX.setBorder(new LineBorder(Color.BLUE, 3, true));
		lblSpX.setBackground(Color.GREEN);
		lblSpX.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblSpX.setBounds(116, 10, 126, 48);
		getContentPane().add(lblSpX);
		
		 lblSpO = new JLabel("Player \"O\" : ");
		lblSpO.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblSpO.setBorder(new LineBorder(Color.BLUE, 3, true));
		lblSpO.setBackground(Color.GREEN);
		lblSpO.setBounds(351, 10, 126, 48);
		getContentPane().add(lblSpO);
		
		 lblX = new JLabel(a);
		lblX.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.CYAN));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblX.setBounds(253, 17, 47, 34);
		getContentPane().add(lblX);
		
		 lblO = new JLabel(b);
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblO.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.CYAN));
		lblO.setBounds(500, 17, 53, 34);
		getContentPane().add(lblO);
		 	panel = new JPanel();
		panel.setBounds(10, 68, 726, 486);
		panel.setLayout(new GridLayout(3,3));
		for (JButton jButton : btnList) {
			panel.add(jButton);
		}
		
		this.getContentPane().add(panel);
		
	this.setVisible(true);
	};
	
	JButton btn1 = new JButton();
	JButton	btn2= new JButton();
	JButton	btn3= new JButton();
	JButton	btn4= new JButton();
	JButton	btn5= new JButton();
	JButton btn6= new JButton();
	JButton btn7= new JButton();
	JButton btn8= new JButton();
	JButton btn9= new JButton();
	JButton[] btnList = {
		btn1,
		btn2,
		btn3,
		btn4,
		btn5,
		btn6,
		btn7,
		btn8,
		btn9
		
};
	private JPanel panel;
	
	public JButton[] getBtnList() {
		return btnList;
	}

	public JPanel getGamePanel() {
		return panel;
	}
}
