import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Form {

	 JFrame frame2;
	
//////////////////////////////// Local/ Field Variables 	
	private JButton btnNext;
	private JButton btnPrev;
	private JButton btnSave;
	private JButton btnDelete;

	
	
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
		ereateEvent();
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNext = new JButton("Next");
		
		btnPrev = new JButton("Prev");
		
		btnSave = new JButton("Save");
		
		btnDelete = new JButton("Delete");




		GroupLayout groupLayout = new GroupLayout(frame2.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(245, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(btnPrev))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnDelete))
					.addContainerGap())
		);
		frame2.getContentPane().setLayout(groupLayout);
	}

	
////////////////////////////EVENTS/////////////////////////////////////////////////	
	
	private void ereateEvent() {
		// TODO Auto-generated method stub

		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "hi");
			}
		});
		
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
	}
	
	
	
	
////////////////////////// MAIN ///////////////////////////////////////////////////	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {		
			
			public void run(){
				
				try 
				{
					Form window = new Form();
					window.frame2.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		);
	}
	
	
}
