import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabel {

	public JFrame frame2;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Tabel() {
		initialize();
		events(); // Added events group
	}
//////////////////////////////Events////////////////////////////////////////		

	private void events() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
//////////////////////////////JFrame2////////////////////////////////////////		
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 650, 400);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},

			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));

		
		
//////////////////////////////JFrame Layout Alignment ////////////////////////////////////////		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane(table);
		GroupLayout groupLayout2 = new GroupLayout(frame2.getContentPane());
		groupLayout2.setHorizontalGroup(
			groupLayout2.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout2.createSequentialGroup()
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addGap(145))
		);
		groupLayout2.setVerticalGroup(
			groupLayout2.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addGap(53))
		);
		
		
		frame2.getContentPane().setLayout(groupLayout2);
//////////////////////////////Layout////////////////////////////////////////
	}

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabel window = new Tabel();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
