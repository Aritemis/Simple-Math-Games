/**
 *	@author Ariana Fairbanks
 * Jadie Adams
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import adapter.Controller;

public class ManageUsers extends JPanel
{
	private static final long serialVersionUID = 7833894194480819845L;
	private JFileChooser fileChoose;
	private Controller base;
	private GridBagLayout layout;
	private JLabel header;
	private JButton backButton;
	private JButton importUsersButton;
	private JComboBox<String> userOptions;
	private JLabel addFirstName;
	private JTextField addFirstNameTextField;
	private JLabel addLastName;
	private JTextField addLastNameTextField;
	private JLabel addID;
	private JTextField addIDTextField;
	private JButton manageUserButton;
	private int value;
	
	public ManageUsers(Controller base)
	{
		this.base = base;
		fileChoose = new JFileChooser();
		layout = new GridBagLayout();
		header = new JLabel(" Manage Users ");
		backButton = new JButton(" BACK ");
		importUsersButton = new JButton(" IMPORT USERS FROM CSV ");
		userOptions = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {" Add New Student", " Add New Teacher"}));
		addFirstName = new JLabel("First Name");
		addFirstNameTextField = new JTextField();
		addLastName = new JLabel("Last Name");
		addLastNameTextField = new JTextField();
		addID = new JLabel("Student ID");
		addIDTextField = new JTextField();
		manageUserButton = new JButton(" ADD USER ");
		value = 0;

		setUpLayout();
		setUpListeners();
	}

	private void setUpLayout() 
	{
		layout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		layout.rowWeights = new double[]{0.0, 2.0, 0.0, 2.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 1.0};
		layout.columnWidths = new int[]{0, 0, 0, 0, 0};
		layout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0};
		setLayout(layout);
		setBorder(new LineBorder(new Color(128, 128, 128), 10));
		setForeground(new Color(105, 105, 105));
		setBackground(new Color(245, 245, 245));
		
		header.setVerticalAlignment(SwingConstants.TOP);
		header.setForeground(new Color(105, 105, 105));
		header.setFont(new Font("Arial", Font.PLAIN, 35));
		GridBagConstraints gbc_displayName = new GridBagConstraints();
		gbc_displayName.anchor = GridBagConstraints.NORTHWEST;
		gbc_displayName.gridwidth = 4;
		gbc_displayName.insets = new Insets(15, 10, 5, 0);
		gbc_displayName.gridx = 1;
		gbc_displayName.gridy = 0;
		
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		backButton.setForeground(new Color(105, 105, 105));
		backButton.setBackground(new Color(105, 105, 105));
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new LineBorder(new Color(105, 105, 105), 2));
		GridBagConstraints gbc_settingsButton = new GridBagConstraints();
		gbc_settingsButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_settingsButton.insets = new Insets(20, 20, 5, 5);
		gbc_settingsButton.gridx = 0;
		gbc_settingsButton.gridy = 0;		
		
		importUsersButton.setVerticalAlignment(SwingConstants.TOP);
		importUsersButton.setFont(new Font("Arial", Font.PLAIN, 20));
		importUsersButton.setForeground(new Color(105, 105, 105));
		importUsersButton.setBackground(new Color(105, 105, 105));
		importUsersButton.setFocusPainted(false);
		importUsersButton.setContentAreaFilled(false);
		importUsersButton.setBorder(new LineBorder(new Color(105, 105, 105), 2));
		GridBagConstraints gbc_importUsersButton = new GridBagConstraints();
		gbc_importUsersButton.gridwidth = 5;
		gbc_importUsersButton.insets = new Insets(0, 0, 5, 0);
		gbc_importUsersButton.gridx = 0;
		gbc_importUsersButton.gridy = 2;
		
		userOptions.setForeground(new Color(105, 105, 105));
		userOptions.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_addUser = new GridBagConstraints();
		gbc_addUser.anchor = GridBagConstraints.NORTHWEST;
		gbc_addUser.gridwidth = 2;
		gbc_addUser.insets = new Insets(10, 30, 10, 0);
		gbc_addUser.gridx = 0;
		gbc_addUser.gridy = 4;
		
		addFirstName.setVerticalAlignment(SwingConstants.TOP);
		addFirstName.setForeground(new Color(105, 105, 105));
		addFirstName.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_addFirstName = new GridBagConstraints();
		gbc_addFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_addFirstName.gridwidth = 5;
		gbc_addFirstName.insets = new Insets(10, 60, 5, 0);
		gbc_addFirstName.gridx = 0;
		gbc_addFirstName.gridy = 6;
		
		addFirstNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		addFirstNameTextField.setBackground(new Color(220, 220, 220));
		addFirstNameTextField.setForeground(new Color(0, 0, 0));
		addFirstNameTextField.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), new EmptyBorder(0, 10, 0, 0)));
		GridBagConstraints gbc_addFirstNameTextField = new GridBagConstraints();
		gbc_addFirstNameTextField.gridwidth = 4;
		gbc_addFirstNameTextField.insets = new Insets(0, 75, 5, 75);
		gbc_addFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addFirstNameTextField.gridx = 0;
		gbc_addFirstNameTextField.gridy = 7;
		
		addLastName.setVerticalAlignment(SwingConstants.TOP);
		addLastName.setForeground(new Color(105, 105, 105));
		addLastName.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_addLastName = new GridBagConstraints();
		gbc_addLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_addLastName.gridwidth = 5;
		gbc_addLastName.insets = new Insets(10, 60, 5, 0);
		gbc_addLastName.gridx = 0;
		gbc_addLastName.gridy = 8;
		
		addLastNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		addLastNameTextField.setBackground(new Color(220, 220, 220));
		addLastNameTextField.setForeground(new Color(0, 0, 0));
		addLastNameTextField.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), new EmptyBorder(0, 10, 0, 0)));
		GridBagConstraints gbc_addLastNameTextField = new GridBagConstraints();
		gbc_addLastNameTextField.gridwidth = 4;
		gbc_addLastNameTextField.insets = new Insets(0, 75, 5, 75);
		gbc_addLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addLastNameTextField.gridx = 0;
		gbc_addLastNameTextField.gridy = 9;
		
		addID.setVerticalAlignment(SwingConstants.TOP);
		addID.setForeground(new Color(105, 105, 105));
		addID.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_addID = new GridBagConstraints();
		gbc_addID.anchor = GridBagConstraints.NORTHWEST;
		gbc_addID.gridwidth = 5;
		gbc_addID.insets = new Insets(10, 60, 5, 0);
		gbc_addID.gridx = 0;
		gbc_addID.gridy = 10;
		
		addIDTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		addIDTextField.setBackground(new Color(220, 220, 220));
		addIDTextField.setForeground(new Color(0, 0, 0));
		addIDTextField.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), new EmptyBorder(0, 10, 0, 0)));
		GridBagConstraints gbc_addIDTextField = new GridBagConstraints();
		gbc_addIDTextField.gridwidth = 4;
		gbc_addIDTextField.insets = new Insets(0, 75, 5, 75);
		gbc_addIDTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addIDTextField.gridx = 0;
		gbc_addIDTextField.gridy = 11;
		
		manageUserButton.setVerticalAlignment(SwingConstants.TOP);
		manageUserButton.setForeground(new Color(105, 105, 105));
		manageUserButton.setBackground(new Color(105, 105, 105));
		manageUserButton.setFocusPainted(false);
		manageUserButton.setContentAreaFilled(false);
		manageUserButton.setBorder(new LineBorder(new Color(105, 105, 105), 2));
		manageUserButton.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_addUserButton = new GridBagConstraints();
		gbc_addUserButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_addUserButton.gridwidth = 2;
		gbc_addUserButton.insets = new Insets(0, 0, 20, 20);
		gbc_addUserButton.gridx = 3;
		gbc_addUserButton.gridy = 14;
		
		add(header, gbc_displayName);
		add(backButton, gbc_settingsButton);
		add(importUsersButton, gbc_importUsersButton);
		add(userOptions, gbc_addUser);
		add(addFirstName, gbc_addFirstName);
		add(addFirstNameTextField, gbc_addFirstNameTextField);
		add(addLastName, gbc_addLastName);
		add(addLastNameTextField, gbc_addLastNameTextField);
		add(addID, gbc_addID);
		add(addIDTextField, gbc_addIDTextField);
		add(manageUserButton, gbc_addUserButton);
		
	}
	
	private void setUpListeners() 
	{
		
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent onClick) 
			{
				base.returnToMenu();
			}
		});
		
		importUsersButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent onClick) 
			{
				JPanel temp = new JPanel();
			    fileChoose.setFileFilter(new FileFilter() 
			    {
			        @Override
			        public boolean accept(File f) 
			        {	return f.getName().endsWith(".csv");	}
			        @Override
			        public String getDescription() 
			        {	return "CSV files";	}
			    });
				int valueReturned = fileChoose.showOpenDialog(temp);
				if(valueReturned == JFileChooser.APPROVE_OPTION)
				{
					base.importUsers(fileChoose.getSelectedFile());
				}
			}
		});
		
		userOptions.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(value != userOptions.getSelectedIndex())
				{
					value = userOptions.getSelectedIndex();
				}
			}
		});
		
		manageUserButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent onClick) 
			{
				switch(value)
				{
					case 0:
						addUser(3);
						break;
					case 1:
						addUser(2);
						break;
				}
			}
		});
	
	}
	
	private void addUser(int permissionLevel)
	{
		String firstName = addFirstNameTextField.getText();
		String lastName = addLastNameTextField.getText();
		String idString = addIDTextField.getText();
		int firstLength = firstName.length();
		int lastLength = lastName.length();
		int idLength = idString.length();
		if(firstLength > 0 && lastLength > 0 && idLength > 0)
		{
			base.addUser(firstName, lastName, idString, permissionLevel);	
		}
		else
		{
			JPanel errorPanel = new JPanel();
			JOptionPane.showMessageDialog(errorPanel, "Please enter first name, last name, and password.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		addFirstNameTextField.setText("");
		addLastNameTextField.setText("");
		addIDTextField.setText("");
		addFirstNameTextField.requestFocus();
	}
	
}
