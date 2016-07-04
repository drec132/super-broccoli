package com.mis.view;

/**
 * @author jonereccereno and Cyka_Blyat Group
 * Management Information System - Human Resource Management System
 * Version: 1.0
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.Point;
import javax.swing.UIManager;
import com.mis.view.MainWindow;
import java.awt.Font;

public class Launcher
{

	private final ButtonGroup buttonGroup = new ButtonGroup();
	JFrame frmLog;
	private JTextField txtID;
	private JPasswordField txtPass;
	private JRadioButton rbEmployee;
	private JRadioButton rbAdmin;
	private JButton btnLogin;
	private static Launcher window;
	private JMenuItem mntmAbout;
	private JMenuItem mntmExit;
	private MainWindow mw;
	private AdminWindow aw;
	private int tempFlag = 0;
	private String tempID;
	private String tempPw;

	/////////////////////////////////////////////////////////
	// Launch the application.
	/////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					window = new Launcher();
					window.frmLog.setVisible(true);

				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/////////////////////////////////////////////////////////
	// Create the application.
	/////////////////////////////////////////////////////////
	public Launcher()
	{
		initComponents();
		createActions();
	}

	/////////////////////////////////////////////////////////
	// This method is for initialization the contents of
	// the frame.
	/////////////////////////////////////////////////////////
	private void initComponents()
	{
		frmLog = new JFrame();
		frmLog.setLocation(new Point(1, 0));
		frmLog.setTitle("Log-in");
		frmLog.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Launcher.class.getResource("/com/mis/resources/chimp-face-of-brazil.png")));
		frmLog.setResizable(false);
		frmLog.setBounds(100, 100, 831, 509);
		frmLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLog.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		JLabel lblId = new JLabel("ID #:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JMenu mnFile = new JMenu("File");
		JMenu mnHelp = new JMenu("Help");

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mntmExit = new JMenuItem("Exit");

		mntmAbout = new JMenuItem("About");
		btnLogin = new JButton("Log-In");
		btnLogin.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		rbEmployee = new JRadioButton("Employee");
		rbEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbAdmin = new JRadioButton("Admin");
		rbAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtID.setColumns(10);
		txtPass.setColumns(10);

		rbEmployee.setSelected(true);

		buttonGroup.add(rbEmployee);
		buttonGroup.add(rbAdmin);

		frmLog.setJMenuBar(menuBar);

		menuBar.add(mnFile);
		mnFile.add(mntmExit);

		menuBar.add(mnHelp);
		mnHelp.add(mntmAbout);

		GroupLayout groupLayout = new GroupLayout(frmLog.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(451, Short.MAX_VALUE).addComponent(btnLogin)
								.addGap(295))
				.addGroup(groupLayout.createSequentialGroup().addGap(242)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addComponent(lblPassword)
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(42).addComponent(lblId)))
						.addGap(26)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addComponent(rbEmployee)
														.addPreferredGap(ComponentPlacement.RELATED, 19,
																Short.MAX_VALUE)
														.addComponent(rbAdmin))
										.addComponent(txtID)
										.addComponent(txtPass, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
						.addContainerGap(277, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(144, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblId).addComponent(
								txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword)
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rbEmployee).addComponent(rbAdmin))
						.addGap(26).addComponent(btnLogin).addGap(129)));
		frmLog.getContentPane().setLayout(groupLayout);
	}

	/////////////////////////////////////////////////////////
	// This method is for the action and events
	// of the components
	/////////////////////////////////////////////////////////
	private void createActions()
	{
		// String tempID = "admin";
		// String tempPass = "1234";
		tempID = "1111";
		tempPw = "12345";
		// Revision for the human error and possible injections
		btnLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (checkPass(tempPw) == true && checkID(tempID))
				{
					// this is the temp style of the closing for the
					// launcher/log-in frame
					// window.frmLog.dispose();
					// rbAdmin.setSelected(true);
					if (rbEmployee.isSelected())
					{
						try
						{
							// JOptionPane.showMessageDialog(null,
							// "clicked");
							// mw.dispose();
							window.frmLog.dispose();
							mw = new MainWindow();
							mw.pack();
							mw.setVisible(true);

						} catch (Exception ex)
						{
						}

					} else
					{
						// must not log in to the employee
						rbAdmin.setSelected(true);
						window.frmLog.dispose();
						aw = new AdminWindow();
						aw.pack();
						aw.setVisible(true);
					}
				} else
				{
					JOptionPane.showMessageDialog(null,
							"Wrong password" + "\n You have " + (tempFlag += 1) + " retries left.");
				}
				if (tempFlag == 3)
				{
					JOptionPane.showMessageDialog(null,
							"Please contact the administrator for the reset and so on on on");
					System.exit(0);
				}

			}

			// this method is to properly check the password
			// of the employee or the user

			private boolean checkID(String tempID2)
			{
				// check for the Employee ID
				if (tempID2.equals(tempID))
					return true;
				// check for the Admin ID and supervisor
				if (tempID2.equals("admin"))
					return true;
				return false;
			}

			// this method is to properly check the password
			// of the employee or the user
			private boolean checkPass(String corrPass)
			{
				char[] input, correct;
				input = txtPass.getPassword();
				correct = corrPass.trim().toCharArray();
				// correct = new char[] { '1', '2', '3', '4' };

				if (Arrays.equals(input, correct))
					return true;
				if (Arrays.equals(input, correct))
					return true;
				Arrays.fill(input, ' ');
				return false;
			}

		});
		// action for the About
		mntmAbout.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});
		// action for the Exit
		mntmExit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to?");
				if (ans == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

	}
}
