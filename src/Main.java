import java.awt.EventQueue;



public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					
					
//					window.frame.setVisible(true);

					window.makeVisable(true);
					
					System.out.println(window.ifConnected());
					
					
				} catch (Exception e) {
					System.out.println("MAIN");
					e.printStackTrace();
				}
			}
		});
		
		
	}				
	
}
