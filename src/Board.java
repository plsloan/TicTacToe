import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board {

	private JFrame board;
	private JTextField TurnIndicator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board();
					window.board.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public Board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// global so reset can occur
	JTextPane TopLeft = new JTextPane();
	JTextPane TopMid = new JTextPane();
	JTextPane TopRight = new JTextPane();
	JTextPane MidLeft = new JTextPane();
	JTextPane MidMid = new JTextPane();
	JTextPane MidRight = new JTextPane();
	JTextPane BotLeft = new JTextPane();
	JTextPane BotMid = new JTextPane();
	JTextPane BotRight = new JTextPane();
	
	int xwins = 0;
	int owins = 0;
	
	private void initialize() {
		board = new JFrame();
		board.setTitle("Tic Tac Toe");
		board.setBounds(100, 100, 550, 355);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 116, 50, 116, 50, 116, 50, 0};
		gridBagLayout.rowHeights = new int[]{26, 0, 11, 30, 35, 0, 35, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		board.getContentPane().setLayout(gridBagLayout);
		
		TurnIndicator = new JTextField();
		TurnIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		TurnIndicator.setText("Player X's Turn");
		GridBagConstraints gbc_TurnIndicator = new GridBagConstraints();
		gbc_TurnIndicator.gridwidth = 3;
		gbc_TurnIndicator.fill = GridBagConstraints.HORIZONTAL;
		gbc_TurnIndicator.anchor = GridBagConstraints.NORTH;
		gbc_TurnIndicator.insets = new Insets(0, 0, 5, 5);
		gbc_TurnIndicator.gridx = 2;
		gbc_TurnIndicator.gridy = 1;
		board.getContentPane().add(TurnIndicator, gbc_TurnIndicator);
		TurnIndicator.setColumns(10);
		
		
		
		// actions
		TopLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					TopLeft.setText("X");
					
					// top row, diagonal, left column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, TopLeft, MidLeft, BotLeft);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					TopLeft.setText("O");
					
					// top row, diagonal, left column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, TopRight, MidRight, BotRight);
					
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_TopLeft = new GridBagConstraints();
		gbc_TopLeft.fill = GridBagConstraints.BOTH;
		gbc_TopLeft.insets = new Insets(0, 0, 5, 5);
		gbc_TopLeft.gridx = 1;
		gbc_TopLeft.gridy = 3;
		board.getContentPane().add(TopLeft, gbc_TopLeft);
		
		TopMid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					TopMid.setText("X");
					
					// top row, middle column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopMid, MidMid, BotMid);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					TopMid.setText("O");
					
					// top row, middle column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopMid, MidMid, BotMid);
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_TopMid = new GridBagConstraints();
		gbc_TopMid.fill = GridBagConstraints.BOTH;
		gbc_TopMid.insets = new Insets(0, 0, 5, 5);
		gbc_TopMid.gridx = 3;
		gbc_TopMid.gridy = 3;
		board.getContentPane().add(TopMid, gbc_TopMid);
		
	
		TopRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					TopRight.setText("X");
					
					// top row, diagonal, right column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopLeft, MidMid, BotRight);	
					checkWin(board, TopRight, MidRight, BotRight);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					TopRight.setText("O");
					
					// top row, diagonal, right column
					checkWin(board, TopLeft, TopMid, TopRight);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, TopRight, MidRight, BotRight);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_TopRight = new GridBagConstraints();
		gbc_TopRight.fill = GridBagConstraints.BOTH;
		gbc_TopRight.insets = new Insets(0, 0, 5, 5);
		gbc_TopRight.gridx = 5;
		gbc_TopRight.gridy = 3;
		board.getContentPane().add(TopRight, gbc_TopRight);
		
		
		MidLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					MidLeft.setText("X");
					
					// middle row, left column
					checkWin(board, TopLeft, MidLeft, BotLeft);
					checkWin(board, MidLeft, MidMid, MidRight);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					MidLeft.setText("O");
					
					// middle row, left column
					checkWin(board, TopLeft, MidLeft, BotLeft);
					checkWin(board, MidLeft, MidMid, MidRight);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_MidLeft = new GridBagConstraints();
		gbc_MidLeft.fill = GridBagConstraints.BOTH;
		gbc_MidLeft.insets = new Insets(0, 0, 5, 5);
		gbc_MidLeft.gridx = 1;
		gbc_MidLeft.gridy = 5;
		board.getContentPane().add(MidLeft, gbc_MidLeft);
		
		
		MidMid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					MidMid.setText("X");
					
					// middle row, diagonal 2x, middle column
					checkWin(board, MidLeft, MidMid, MidRight);
					checkWin(board, TopMid, MidMid, BotMid);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, TopRight, MidMid, BotLeft);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					MidMid.setText("O");
					
					// middle row, diagonal 2x, middle column
					checkWin(board, MidLeft, MidMid, MidRight);
					checkWin(board, TopMid, MidMid, BotMid);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, TopRight, MidMid, BotLeft);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_MidMid = new GridBagConstraints();
		gbc_MidMid.fill = GridBagConstraints.BOTH;
		gbc_MidMid.insets = new Insets(0, 0, 5, 5);
		gbc_MidMid.gridx = 3;
		gbc_MidMid.gridy = 5;
		board.getContentPane().add(MidMid, gbc_MidMid);
		

		MidRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					MidRight.setText("X");
					
					// middle row, right column
					checkWin(board, TopRight, MidRight, BotRight);
					checkWin(board, MidLeft, MidMid, MidRight);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					MidRight.setText("O");
					
					// middle row, right column
					checkWin(board, TopRight, MidRight, BotRight);
					checkWin(board, MidLeft, MidMid, MidRight);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_MidRight = new GridBagConstraints();
		gbc_MidRight.fill = GridBagConstraints.BOTH;
		gbc_MidRight.insets = new Insets(0, 0, 5, 5);
		gbc_MidRight.gridx = 5;
		gbc_MidRight.gridy = 5;
		board.getContentPane().add(MidRight, gbc_MidRight);
		
		
		BotLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					BotLeft.setText("X");
					
					//bottom row, diagonal, left column
					checkWin(board, TopLeft, MidLeft, BotLeft);
					checkWin(board, BotLeft, BotMid, BotRight);
					checkWin(board, TopRight, MidMid, BotLeft);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					BotLeft.setText("O");
					
					//bottom row, diagonal, left column
					checkWin(board, MidLeft, TopLeft, BotLeft);
					checkWin(board, BotLeft, BotMid, BotRight);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_BotLeft = new GridBagConstraints();
		gbc_BotLeft.fill = GridBagConstraints.BOTH;
		gbc_BotLeft.insets = new Insets(0, 0, 0, 5);
		gbc_BotLeft.gridx = 1;
		gbc_BotLeft.gridy = 7;
		board.getContentPane().add(BotLeft, gbc_BotLeft);
		
		
		BotMid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					BotMid.setText("X");
					
					// bottom row, middle column
					checkWin(board, BotLeft, BotMid, BotRight);
					checkWin(board, TopMid, MidMid, BotMid);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					BotMid.setText("O");
					
					// bottom row, middle column
					checkWin(board, BotLeft, BotMid, BotRight);
					checkWin(board, TopMid, MidMid, BotMid);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		GridBagConstraints gbc_BotMid = new GridBagConstraints();
		gbc_BotMid.fill = GridBagConstraints.BOTH;
		gbc_BotMid.insets = new Insets(0, 0, 0, 5);
		gbc_BotMid.gridx = 3;
		gbc_BotMid.gridy = 7;
		board.getContentPane().add(BotMid, gbc_BotMid);
		
		
		BotRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TurnIndicator.getText().contains("Player X's Turn")) {
					BotRight.setText("X");
					
					// bottom row, diagonal, right column
					checkWin(board, TopRight, MidRight, BotRight);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, BotLeft, BotMid, BotRight);
					
					TurnIndicator.setText("Player O's Turn");
				}
				else if (TurnIndicator.getText().contains("Player O's Turn")) {
					BotRight.setText("O");
					
					// bottom row, diagonal, right column
					checkWin(board, TopRight, MidRight, BotRight);
					checkWin(board, TopLeft, MidMid, BotRight);
					checkWin(board, BotLeft, BotMid, BotRight);
					
					TurnIndicator.setText("Player X's Turn");
				}
			}
		});
		
		
		GridBagConstraints gbc_BotRight = new GridBagConstraints();
		gbc_BotRight.insets = new Insets(0, 0, 0, 5);
		gbc_BotRight.fill = GridBagConstraints.BOTH;
		gbc_BotRight.gridx = 5;
		gbc_BotRight.gridy = 7;
		board.getContentPane().add(BotRight, gbc_BotRight);
	}
	
	
	// my functions
	private void checkWin(JFrame b, JTextPane p1, JTextPane p2, JTextPane p3) {
		if (p1.getText().contains("X") && p2.getText().contains("X") && p3.getText().contains("X")) {
			xwins++;
			JOptionPane.showMessageDialog(b, "Winner - X!\nX: " + xwins + "    O: " + owins);
			resetBoard();
		}
		
		else if (p1.getText().contains("O") && p2.getText().contains("O") && p3.getText().contains("O")) {
			owins++;
			JOptionPane.showMessageDialog(b, "Winner - O!\nX: " + xwins + "    O: " + owins);
			resetBoard();
		}
	}
	
	private void resetBoard() {
		TopLeft.setText(null);
		TopMid.setText(null);
		TopRight.setText(null);
		MidLeft.setText(null);
		MidMid.setText(null);
		MidRight.setText(null);
		BotLeft.setText(null);
		BotMid.setText(null);
		BotRight.setText(null);
	}
}
