package com.mis.view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class AdminWindow extends JDialog
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			AdminWindow dialog = new AdminWindow();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminWindow()
	{
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////
	// This method is for initialization of the components
	////////////////////////////////////////////////////////////
	private void initComponents()
	{
		setTitle("Admin View");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainWindow.class.getResource("/com/mis/resources/chimp-face-of-brazil.png")));
		setBounds(100, 100, 832, 514);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		JPanel pnlPayroll = new JPanel();
		JPanel pnlLeave = new JPanel();
		JPanel panel_2 = new JPanel();
		JMenuBar menuBar = new JMenuBar();

		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE).addGap(1)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE).addGap(2)));

		tabbedPane.addTab("Payroll", null, pnlPayroll, null);
		GroupLayout gl_pnlPayroll = new GroupLayout(pnlPayroll);
		gl_pnlPayroll.setHorizontalGroup(
				gl_pnlPayroll.createParallelGroup(Alignment.LEADING).addGap(0, 810, Short.MAX_VALUE));
		gl_pnlPayroll
				.setVerticalGroup(gl_pnlPayroll.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		pnlPayroll.setLayout(gl_pnlPayroll);

		tabbedPane.addTab("Leave", null, pnlLeave, null);
		tabbedPane.addTab("New tab", null, panel_2, null);
		getContentPane().setLayout(groupLayout);
		setJMenuBar(menuBar);

		JSeparator separator_1 = new JSeparator();
		JSeparator separator = new JSeparator();

		mnFile = new JMenu("File");
		mntmSave = new JMenuItem("Save");
		mntmLogOut = new JMenuItem("Log-out");
		mnEdit = new JMenu("Edit");
		mntmCop = new JMenuItem("Undo");
		mntmPaste = new JMenuItem("Paste");
		mnHelp = new JMenu("Help");
		mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(AdminWindow.class.getResource("/com/mis/resources/info.png")));

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
					System.exit(0);
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
