import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class Calc extends JFrame {

	private JLabel label0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel huss;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JButton button1;
	private JButton button2;
	private JTextField antibase;
	private JLabel anti;
	private JButton clear;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnAbout;

	
	public static void main(String[] args) {

        Calc obj = new Calc();
     

    }
	
	public Calc() {

		super("Log And Antilog Calculator v1.1");

		setBackground(new Color(64, 224, 208));

		setLayout(null);

		label1 = new JLabel(); // label font size
		label1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label1.setText("Logrithm Value");
		label1.setBounds(83, 48, 104, 26);
		add(label1);

		label2 = new JLabel();

		label2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label2.setText("Anti-Logrithm Value");
		label2.setBounds(267, 48, 134, 26);
		add(label2);

		Icon iconobj = new ImageIcon(getClass().getResource("hu_1.png"));

		Icon iconobj2 = new ImageIcon(getClass().getResource("textio.png"));

		ImageIcon iconobj3 = new ImageIcon(getClass().getResource("icon.png"));

		Icon iconobj4 = new ImageIcon(getClass().getResource("greaterthan.png"));

		setIconImage(iconobj3.getImage());
		menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		mnFile = new JMenu("File");

		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");

		mntmExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}

		});

		mnFile.add(mntmExit);

		mnAbout = new JMenu("About");

		menuBar.add(mnAbout);

		JMenuItem mntmAboutThis = new JMenuItem("About");

		mntmAboutThis.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Credit Goes To Ahmad HussNain '(hussnianXain)'", "About Author",
						JOptionPane.ERROR_MESSAGE, iconobj);

			}
		});

		mnAbout.add(mntmAboutThis);

		huss = new JLabel();
		huss.setIcon(iconobj);
		huss.setBounds(387, 285, 41, 53);
		add(huss);

		label0 = new JLabel();
		label0.setForeground(Color.BLUE);

		label0.setFont(new Font("Tahoma", Font.BOLD, 14)); // label font size

		label0.setText("Logrithm and Anti Logrithm Calculator");
		label0.setBounds(91, 10, 310, 26);
		add(label0);

		label3 = new JLabel();

		label3.setFont(new Font("Tahoma", Font.BOLD, 14));// label font size

		label3.setText("Answer");

		label3.setBounds(200, 234, 62, 26);
		add(label3);

		label4 = new JLabel();

		label4.setToolTipText("Enter Log Base i.e 10,2|Default Set Base Is :'e' = Natural Log");

		label4.setFont(new Font("Tahoma", Font.BOLD, 11)); // label font size
		label4.setText("Log Base e,10");
		label4.setBounds(92, 142, 77, 29);
		add(label4);

		anti = new JLabel();

		anti.setToolTipText("Enter Anti-Log Base i.e 10,2|Default Set Base Is :'e' = Natural Log");

		anti.setFont(new Font("Tahoma", Font.BOLD, 11));

		anti.setText("AntiLog Base e,10");

		anti.setBounds(276, 142, 100, 29);

		add(anti);

		textfield1 = new JTextField();
		textfield1.setBounds(92, 92, 62, 26);
		add(textfield1);

		textfield2 = new JTextField();
		textfield2.setBounds(291, 92, 62, 26);
		add(textfield2);

		textfield3 = new JTextField();
		textfield3.setBounds(114, 261, 232, 26);
		add(textfield3);

		textfield4 = new JTextField();
		textfield4.setBounds(93, 171, 62, 26);
		add(textfield4);

		antibase = new JTextField();
		antibase.setBounds(291, 171, 62, 26);
		add(antibase);

		// for round off
		DecimalFormat d = new DecimalFormat("0.0000");

		DecimalFormat d2 = new DecimalFormat("");// For Eliminate Auto Decimal

		d2.setGroupingUsed(false);

		button1 = new JButton();

		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double number1;
				double baseE;
				double result;

				String text1 = textfield1.getText();

				String text3 = textfield4.getText();

				try {

					number1 = Double.parseDouble(text1);

					if (number1 < 0) {

						String nrt = (String) JOptionPane.showInputDialog(null,
								"Enter Log Value Will Be 0 or Greater Than 0", "Log Value Error",
								JOptionPane.INFORMATION_MESSAGE, iconobj4, null, "");

						number1 = Double.parseDouble(nrt);

					}

					textfield1.setText("" + d2.format(number1));

					if (text3.isEmpty()) {

						result = Math.log(number1);

						if (result == (int) result) {

							textfield3.setText("" + (int) result);

						} else {

							textfield3.setText("" + d.format(result));

						}
					} else {

						baseE = Double.parseDouble(text3);

						if (baseE < 2) {

							String numb = (String) JOptionPane.showInputDialog(null,
									"Log Base Will be 2 Or Greater Than 2", "Log Base Error",
									JOptionPane.INFORMATION_MESSAGE, iconobj4, null, "");

							baseE = Double.parseDouble(numb);

						}

						textfield4.setText("" + d2.format(baseE));

						result = Math.log(number1) / Math.log(baseE);
						if (result == (int) result) {

							textfield3.setText("" + (int) result);

						} else {

							textfield3.setText("" + d.format(result));

						}

					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Logarithm TextFields INVALID", "Log Invalid TextFields",
							JOptionPane.ERROR_MESSAGE, iconobj2);

				}

			}
		});

		button1.setFont(new Font("Bullet", Font.PLAIN, 16));
		button1.setText("Logrithm Calculate");
		button1.setBounds(48, 209, 165, 26);
		getContentPane().add(button1);

		button2 = new JButton();
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double anti1, anti2, ans;

				String texter1 = textfield2.getText();

				String texter2 = antibase.getText();

				try {

					if (texter2.isEmpty()) {
						anti1 = Double.parseDouble(texter1);

						ans = Math.exp(anti1);

						if (ans == (int) ans) {

							textfield3.setText("" + (int) ans);

						} else {

							textfield3.setText("" + ans);

						}

					} else {
						anti1 = Double.parseDouble(texter1);

						anti2 = Double.parseDouble(texter2);

						ans = Math.pow(anti1, anti2);

						textfield3.setText("" + d2.format(ans));

					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Anti Logarithm TextFields INVALID",
							"AntiLog Invalid TextFields", JOptionPane.ERROR_MESSAGE, iconobj2);
				}

			}
		});

		button2.setFont(new Font("Bullet", Font.PLAIN, 16));

		button2.setText("Anti-Logrithm");
		button2.setBounds(252, 209, 165, 26);
		getContentPane().add(button2);

		clear = new JButton();

		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				textfield1.setText("");
				textfield2.setText("");
				textfield4.setText("");
				antibase.setText("");
				textfield3.setText("");

			}
		});

		clear.setFont(new Font("Bullet", Font.PLAIN, 16));
		clear.setText("Clear Fields");
		clear.setBounds(167, 292, 134, 26);
		add(clear);

		setSize(450, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
