import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controller {
private final class BtnListener implements ActionListener {
		private final JButton btn;

		private BtnListener(JButton btn) {
			this.btn = btn;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if("X".contentEquals(text)) {
				btn.setText("O");
				text = "O";
			}else {
				btn.setText("X");
				text = "X";
			}
			btn.setFont(new Font("Serif", Font.BOLD, 140));
			btn.setEnabled(false);
			
			if(
					isGewinner()
					) {
				if("X".contentEquals(text)) {
					mainFrame.getLblX().setText(""+(Integer.parseInt(mainFrame.getLblX().getText())+1));
				}else {
					mainFrame.getLblO().setText(""+(Integer.parseInt(mainFrame.getLblO().getText())+1));
				}
			}
			setupNogewinner();
			
		}
	}

MainFrame mainFrame;
JPanel gamePanel;
 String text = "X";
	public Controller() {
		mainFrame=	new MainFrame("0","0");
		addActionListenerToMainFrame();
		addActionListenerToGamePanel();
	
		
	}

	private void initGui() {
		mainFrame.setVisible(false);
		mainFrame = new MainFrame(mainFrame.getLblX().getText(),mainFrame.getLblO().getText());
		addActionListenerToMainFrame();
		addActionListenerToGamePanel();
		mainFrame.setVisible(true);
	}

	private void addActionListenerToGamePanel() {
		JButton[] btnList = mainFrame.getBtnList();
		for (JButton btn : btnList) {
		
			btn.addActionListener(new BtnListener(btn));
		}
		
	}

	private void addActionListenerToMainFrame() {
		mainFrame.getReset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initGui();
				System.err.println("reset");
				
			}
		});
		
mainFrame.getExit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

mainFrame.getContact().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(mainFrame, "Iheb Harchi \n Hohenstaufenstraße 4 \n 71696 Möglingen\n ihebharchi@yahoo.fr");
		
	}
});
		
	}
	

	public static void main(String[] args) {
		new Controller();
	}
	
	private boolean isDiag() {
	JButton[] list=	mainFrame.getBtnList();
		if(!list[0].getText().equals("") && list[0].getText().equals(list[4].getText())&& list[4].getText().equals(list[8].getText())) {
			setupGewinner(0,4,8);
			return true;
		}else if(!list[2].getText().equals("") && list[2].getText().equals(list[4].getText())&& list[4].getText().equals(list[6].getText())) {
			setupGewinner(2,4,6);
			return true;
		}
		return false;
	}
	
	private boolean isHorVert() {
		JButton[] list=	mainFrame.getBtnList();
		for (int i = 0; i < 7; i++) {
			if(i%3 == 0) {
				if(!list[i].getText().equals("") && list[i].getText().equals(list[i+1].getText())&& list[i+1].getText().equals(list[i+2].getText())) {
					setupGewinner(i,i+1,i+2);
					return true;
			}
		}
		}
			for(int i = 0;i<3;i++) {
				if(!list[i].getText().equals("") && list[i].getText().equals(list[i+3].getText())&& list[i+3].getText().equals(list[i+6].getText())) {
					setupGewinner(i,i+3,i+6);
					return true;
				}
			}
			return false;
		
	}
	private boolean isGewinner() {
		return isDiag() || isHorVert();
	}
	private void setupGewinner(int a, int b, int c) {
		JButton[] btnList = mainFrame.getBtnList();
		btnList[a].setBackground(Color.green);
		btnList[b].setBackground(Color.green);
		btnList[c].setBackground(Color.green);
		
		for (JButton jButton : btnList) {
			jButton.setEnabled(false);
		}
int eingabe = JOptionPane.showConfirmDialog(mainFrame, "der Gewinner ist "+text+"\n new Game?");
if(eingabe==0) {
	initGui();
}
	}
	
	
	private void setupNogewinner(){
		if(!isGewinner()&& noGewinner()) {
			int eingabe = JOptionPane.showConfirmDialog(mainFrame, "No Winner! \n new Game?");
			if(eingabe==0) {
				initGui();
		}
	}
	}
private boolean noGewinner() {
	for (JButton btn : mainFrame.getBtnList()) {
		if(btn.isEnabled()) {
			return false;
	}
		
	}
	return true;
}
	
}
