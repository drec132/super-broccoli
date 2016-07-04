package com.mis.view;

/**
 * @author jonereccereno and Cyka_Blyat Group
 * Management Information System - Human Resource Management System
 * Version: 1.0
 */

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class MainWindow extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmSave;
	private JMenuItem mntmLogOut;
	private JMenu mnEdit;
	private JMenu mnFile;
	private JMenuItem mntmCop;
	private JMenuItem mntmPaste;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JTextField txtNameField;
	private JTextField txtIdField;

	/**
	 * Launch the application.
	 */
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
			public void run()
			{
				try
				{
					MainWindow dialog = new MainWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MainWindow()
	{
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////
	// This method is for initialization of the components
	////////////////////////////////////////////////////////////
	private void initComponents()
	{
		// SAMPLE TITLE PLEASE CHANGE
		setTitle("Employee View");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainWindow.class.getResource("/com/mis/resources/chimp-face-of-brazil.png")));
		setBounds(100, 100, 831, 509);
		setLocationByPlatform(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JLabel lblEmployeeId = new JLabel("Employee ID #:");
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		JPanel pnlPayroll = new JPanel();
		JPanel pnlLeave = new JPanel();
		JPanel panel_2 = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JSeparator separator_1 = new JSeparator();
		JSeparator separator = new JSeparator();

		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtIdField = new JTextField();
		txtIdField.setColumns(10);
		txtNameField = new JTextField();
		txtNameField.setEditable(false);
		txtNameField.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(92).addComponent(lblEmployeeName)
										.addGap(18)
										.addComponent(txtNameField, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addGap(71).addComponent(lblEmployeeId)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtIdField,
												GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEmployeeName)
								.addComponent(txtNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmployeeId).addComponent(txtIdField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
						.addGap(2)));

		tabbedPane.addTab("Payroll", null, pnlPayroll, null);
		GroupLayout gl_pnlPayroll = new GroupLayout(pnlPayroll);
		gl_pnlPayroll.setHorizontalGroup(
				gl_pnlPayroll.createParallelGroup(Alignment.LEADING).addGap(0, 809, Short.MAX_VALUE));
		gl_pnlPayroll
				.setVerticalGroup(gl_pnlPayroll.createParallelGroup(Alignment.LEADING).addGap(0, 419, Short.MAX_VALUE));
		pnlPayroll.setLayout(gl_pnlPayroll);

		tabbedPane.addTab("Leave", null, pnlLeave, null);
		tabbedPane.addTab("New tab", null, panel_2, null);
		getContentPane().setLayout(groupLayout);
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		mntmSave = new JMenuItem("Save");
		mntmLogOut = new JMenuItem("Log-out");

		mnEdit = new JMenu("Edit");
		mntmCop = new JMenuItem("Undo");
		mntmPaste = new JMenuItem("Paste");
		mnHelp = new JMenu("Help");
		mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(MainWindow.class.getResource("/com/mis/resources/info.png")));

		menuBar.add(mnFile);
		menuBar.add(mnEdit);
		menuBar.add(mnHelp);
		mnFile.add(mntmSave);
		mnFile.add(separator_1);
		mnFile.add(mntmLogOut);
		mnEdit.add(mntmCop);
		mnEdit.add(separator);
		mnEdit.add(mntmPaste);
		mnHelp.add(mntmAbout);

	}

	// //////////////////////////////////////////////////////////
	// This method is for creating events and actions
	////////////////////////////////////////////////////////////
	private void createEvents()
	{
		mntmLogOut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to?");
				if (ans == JOptionPane.YES_OPTION)
				{
					dispose();
					Launcher ln = new Launcher();
					ln.frmLog.setVisible(true);
				}

			}
		});
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

	}
}
