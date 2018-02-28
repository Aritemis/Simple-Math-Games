package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import adapter.Controller;

public class RecordsTable extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private Controller base;
	private GridBagLayout layout;
	private JLabel header;
	private JButton backButton;
	private JTable studentRecordsSet;
	private JScrollPane scrollPane;
	private int studentID;
	
	public RecordsTable(Controller base, int studentID)
	{
		this.base = base;
		layout = new GridBagLayout();
		header = new JLabel("Student Records");
		backButton = new JButton(" BACK ");
		this.studentID = studentID;

		setUpLayout();
		setUpListeners();
	}
	
	private void setUpLayout() 
	{
		layout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		layout.rowWeights = new double[]{0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		layout.columnWidths = new int[]{0, 0, 0, 0, 0};
		layout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0};
		setLayout(layout);
		setBorder(new LineBorder(new Color(128, 128, 128), 10));
		setForeground(new Color(105, 105, 105));
		setBackground(new Color(0, 0, 0));
		
		header.setVerticalAlignment(SwingConstants.TOP);
		header.setForeground(new Color(220, 220, 220));
		header.setFont(new Font("MV Boli", Font.PLAIN, 35));
		GridBagConstraints gbc_displayName = new GridBagConstraints();
		gbc_displayName.anchor = GridBagConstraints.NORTHWEST;
		gbc_displayName.gridwidth = 4;
		gbc_displayName.insets = new Insets(15, 10, 5, 0);
		gbc_displayName.gridx = 1;
		gbc_displayName.gridy = 0;
		
		backButton.setFont(new Font("MV Boli", Font.PLAIN, 25));
		backButton.setForeground(new Color(192, 192, 192));
		backButton.setBackground(new Color(105, 105, 105));
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		GridBagConstraints gbc_settingsButton = new GridBagConstraints();
		gbc_settingsButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_settingsButton.insets = new Insets(20, 20, 5, 5);
		gbc_settingsButton.gridx = 0;
		gbc_settingsButton.gridy = 0;		
		
//		scrollPane = new JScrollPane(studentRecordsSet);
		
		populateTable(base.lookupStudent(studentID));
		
		add(header, gbc_displayName);
		add(backButton, gbc_settingsButton);
		add(studentRecordsSet);
//		add(scrollPane);
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
	}
	
	private void populateTable(ResultSet studentRecords)
	{
		try 
		{
		    studentRecordsSet = new JTable(buildTableModel(studentRecords));	    
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	private static DefaultTableModel buildTableModel(ResultSet studentRecords) throws SQLException 
	{
		ResultSetMetaData metaData = studentRecords.getMetaData();
		
		/**
		System.out.println("");
		int columnsNumber = metaData.getColumnCount();
		while (studentRecords.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = studentRecords.getString(i);
		        System.out.print(columnValue + " " + metaData.getColumnName(i));
		    }
		    System.out.println("");
		}
		*/
		
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (studentRecords.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(studentRecords.getObject(columnIndex));
	            System.out.println(studentRecords.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    return new DefaultTableModel(data, columnNames);
	}
}
