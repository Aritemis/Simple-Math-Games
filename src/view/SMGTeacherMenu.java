/**
 *	@author Ariana Fairbanks
 */
package view;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import adapter.SMGController;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SMGTeacherMenu extends JPanel 
{
	private static final long serialVersionUID = -1163688838297846114L;
	private SMGController base;
	private GridBagLayout layout;
	private JLabel displayName;
	private JButton logOut;
	private JButton settingsButton;
	
	public SMGTeacherMenu(SMGController base)
	{
		this.base = base;
		layout = new GridBagLayout();
		displayName = new JLabel(" ");
		logOut = new JButton(" Log Out ");
		settingsButton = new JButton("    ");

		setUpLayout();
		setUpListeners();
	}

	private void setUpLayout() 
	{
		layout.rowHeights = new int[]{0, 0, 0, 0};
		layout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		layout.columnWidths = new int[]{20, 0, 0, 0};
		layout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		setLayout(layout);
		setBorder(new LineBorder(new Color(70, 130, 180), 10));
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(0, 0, 0));
		
		displayName.setVerticalAlignment(SwingConstants.BOTTOM);
		displayName.setForeground(new Color(135, 206, 250));
		displayName.setFont(new Font("MV Boli", Font.PLAIN, 35));
		displayName.setText(base.getFullName());
		GridBagConstraints gbc_displayName = new GridBagConstraints();
		gbc_displayName.anchor = GridBagConstraints.NORTHWEST;
		gbc_displayName.gridwidth = 3;
		gbc_displayName.insets = new Insets(15, 10, 5, 5);
		gbc_displayName.gridx = 1;
		gbc_displayName.gridy = 0;
		
		logOut.setFont(new Font("MV Boli", Font.PLAIN, 30));
		logOut.setForeground(new Color(135, 206, 250));
		logOut.setBackground(new Color(0, 0, 0));
		logOut.setFocusPainted(false);
		logOut.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		GridBagConstraints gbc_logOut = new GridBagConstraints();
		gbc_logOut.anchor = GridBagConstraints.EAST;
		gbc_logOut.insets = new Insets(0, 0, 20, 20);
		gbc_logOut.gridx = 3;
		gbc_logOut.gridy = 3;
		
		settingsButton.setFont(new Font("MV Boli", Font.PLAIN, 25));
		settingsButton.setForeground(new Color(135, 206, 250));
		settingsButton.setBackground(new Color(70, 130, 180));
		settingsButton.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		GridBagConstraints gbc_settingsButton = new GridBagConstraints();
		gbc_settingsButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_settingsButton.insets = new Insets(20, 25, 5, 5);
		gbc_settingsButton.gridx = 0;
		gbc_settingsButton.gridy = 0;
		
		add(displayName, gbc_displayName);
		add(logOut, gbc_logOut);
		add(settingsButton, gbc_settingsButton);
	}
	
	private void setUpListeners() 
	{
		logOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent onClick) 
			{
				base.logout();
			}
		});
		
		settingsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent onClick) 
			{
				base.changeState(4);
				//settings
			}
		});
	}
}