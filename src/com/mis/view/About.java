package com.mis.view;

/**
 * @author jonereccereno and Cyka_Blyat Group
 * Management Information System - Human Resource Management System
 * Version: 1.0
 */
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class About extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		try
		{
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/com/mis/resources/info.png")));
		setTitle("About");
		setBounds(100, 100, 344, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JTextArea txtrAuthorCykablyat = new JTextArea();
		txtrAuthorCykablyat.setBackground(SystemColor.menu);
		txtrAuthorCykablyat.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		txtrAuthorCykablyat.setText("Author: Cyka_Blyat \r\n\r\nVersion: 1.0");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(94).addComponent(txtrAuthorCykablyat, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(94, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(37).addComponent(txtrAuthorCykablyat, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
	}

}
