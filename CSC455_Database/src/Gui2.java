import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Gui2 extends JFrame{
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu fileMenu2;
	private JMenu fileMenu3;
	private int width = 1200;
	private int height = 900;
	private JPanel mainPanel;
    private CardLayout layout;
    private ImageIcon horka1;
    private ImageIcon horka2;
    private ImageIcon horka3;
    private ImageIcon horka4;
    private ImageIcon previ;
    private ImageIcon nexti;
    static ArrayList<String> str_List = new ArrayList<String>();
    static ArrayList<String> str_List2 = new ArrayList<String>();
    static ArrayList<String> str_List3 = new ArrayList<String>();
    static ArrayList<String> str_List4 = new ArrayList<String>();
	static String resultList = "";

	public Gui2() {
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Movie Hut");
		buildMenu();
		ImageIcon banner = new ImageIcon("Resources/moviebanner2.png");
        	JLabel label5 = new JLabel(banner);
        	ImageIcon newr = new ImageIcon("Resources/curtains2.jpg");
        	JLabel label7 = new JLabel(newr);
        	JLabel label6 = new JLabel(newr);
        	add(label5, BorderLayout.NORTH);
        	add(label6, BorderLayout.EAST);
        	add(label7, BorderLayout.WEST);
        	getContentPane().setBackground(new Color(50, 50, 50));
		setVisible(true);	
		add(initUI(), BorderLayout.CENTER);	
	}
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(() -> {
	            new Gui2();  
	        });
	}
	
	public void buildMenu() {	
		menuBar = new JMenuBar();
		fileMenu = new JMenu("Member Functions");
		fileMenu2 = new JMenu("Administrative Functions");
		fileMenu3 = new JMenu("Reporting Functions");
		
		JMenuItem menuItem = new JMenuItem("Video Checkout");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.mostRecentRental();
				try {
					while (rs.next()) {
						String most_recent = rs.getString("rental_num");
						resultList += most_recent;
					}
					String rental_num = JOptionPane.showInputDialog(mainPanel, "Enter a 5-digit Rental Number for the new Rental. Most recent rental number: " + resultList + ".");
					String m_id = JOptionPane.showInputDialog(mainPanel, "Enter the member's ID.");
					String stock_num = JOptionPane.showInputDialog(mainPanel, "Enter the Stock Number.");
					String v_id = JOptionPane.showInputDialog(mainPanel, "Enter the Video ID.");
					String e_id = JOptionPane.showInputDialog(mainPanel, "Enter the Employee's ID.");
					if(rental_num != null && !rental_num.equals("")) {
						RQ.addRental(rental_num, m_id, stock_num, v_id, e_id);
					}
					else {
						JOptionPane.showMessageDialog(mainPanel, "Please enter valid information and try again.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList = "";
				
			}
		});
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("New Member Signup");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.mostRecentMember();
				try {
					while (rs.next()) {
						String most_recent = rs.getString("m_id");
						resultList += most_recent;
					}
				String m_id = JOptionPane.showInputDialog(mainPanel, "Enter the new member's ID. Most Recent Member ID: " + resultList + ".");
				String lname = JOptionPane.showInputDialog(mainPanel, "Enter Last Name.");
				String fname = JOptionPane.showInputDialog(mainPanel, "Enter First Name.");
				String address = JOptionPane.showInputDialog(mainPanel, "Enter Address.");
				if (m_id != null && !m_id.equals("")) {
					RQ.addMember(m_id, lname, fname, address);
				}
				else {
					JOptionPane.showMessageDialog(mainPanel, "Please enter valid information and try again.");
					}
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList = "";
			}
			
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("List of Outstanding Videos");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getOutstanding();
				try {
					while (rs.next()) {
						String rental_num = rs.getString("rental_num");
						String m_id = rs.getString("m_id");
						String due_date = rs.getString("due_date");
						str_List.add(rental_num);
						str_List2.add(m_id);
						str_List3.add(due_date);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Rental Number | Member ID | Due Date \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List.get(x) + "   |   " + str_List2.get(x) + "   |   " + str_List3.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
				
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Member Cancellation");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String member_id = JOptionPane.showInputDialog(mainPanel, "Enter the user ID of the member you wish to remove.");
				System.out.println("Removing user with ID: " + member_id);
				RQ.removeUser(member_id);
				
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Video Purchase");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.mostRecentSale();
				try {
					while (rs.next()) {
						String most_recent = rs.getString("sale_num");
						resultList += most_recent;
					}
					String sale_num = JOptionPane.showInputDialog(mainPanel, "Enter a 5-digit Sale Number for the new Sale. Most recent sale number: " + resultList + ".");
					String m_id = JOptionPane.showInputDialog(mainPanel, "Enter the member's ID.");
					String stock_num = JOptionPane.showInputDialog(mainPanel, "Enter the Stock Number.");
					String v_id = JOptionPane.showInputDialog(mainPanel, "Enter the Video ID.");
					String e_id = JOptionPane.showInputDialog(mainPanel, "Enter the Employee's ID.");
					if(sale_num != null && !sale_num.equals("")) {
						RQ.addSale(sale_num, m_id, stock_num, v_id, e_id);
					}
					else {
						JOptionPane.showMessageDialog(mainPanel, "Please enter valid information and try again.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList = "";
				
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Video Return");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rental_num = JOptionPane.showInputDialog(mainPanel, "Enter the Rental Number.");
				RQ.returnVideo(rental_num);
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Remove Employee");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employee_id = JOptionPane.showInputDialog(mainPanel, "Enter the ID of the employee you wish to remove.");
				RQ.removeEmployee(employee_id);
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Add Employee");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employee_id = JOptionPane.showInputDialog(mainPanel, "Enter the ID for the employee you wish to add.");
				String name = JOptionPane.showInputDialog(mainPanel, "Enter the name for the employee you wish to add.");
				String store_num = JOptionPane.showInputDialog(mainPanel, "Enter the Store Number for the employee you wish to add.");
				String commission_rate = JOptionPane.showInputDialog(mainPanel, "Enter the commission rate for the employee you wish to add.");
				if (employee_id != null && !employee_id.equals("")) {
					RQ.addEmployee(employee_id, name, store_num, commission_rate);
				}
				else {
					JOptionPane.showMessageDialog(mainPanel, "Please enter valid information and try again.");
				}
				
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Process New Shipment of Videos");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userInput = Integer.parseInt(JOptionPane.showInputDialog(mainPanel, "How many movies are you adding?"));
				String vendor_name = JOptionPane.showInputDialog(mainPanel, "Enter the Vendor name.");
				RQ.startTransact();
				for (int x = 0; x < userInput; x++) {
					String v_id = JOptionPane.showInputDialog(mainPanel, "Enter ID for the movie.");
					String stock_num = JOptionPane.showInputDialog(mainPanel, "Enter stock number for the movie.");
					String title = JOptionPane.showInputDialog(mainPanel, "Enter title for the movie");
					String cost = JOptionPane.showInputDialog(mainPanel, "Enter the cost for the movie.");
					String category = JOptionPane.showInputDialog(mainPanel, "Enter the genre for the movie.");
					String rent_price = JOptionPane.showInputDialog(mainPanel, "Enter the rental price for the movie.");
					String sale_price = JOptionPane.showInputDialog(mainPanel, "Enter the sale price for the movie.");
					String qoh = JOptionPane.showInputDialog(mainPanel, "How many are in stock?");
					RQ.addMovie(v_id, stock_num, title, cost, category, rent_price, sale_price, vendor_name, qoh);
				}
				JPasswordField passwordField = new JPasswordField( );
				passwordField.setEchoChar( '*' );
				passwordField.setColumns( 20 );
				int returnVal = JOptionPane.showConfirmDialog( mainPanel, passwordField, "Enter Password to Confirm Changes", JOptionPane.OK_CANCEL_OPTION );
				if (returnVal == JOptionPane.OK_OPTION) {
					@SuppressWarnings("deprecation")
					String confirm = passwordField.getText();
					if (confirm.equals("password")) {
						RQ.commit();
						JOptionPane.showMessageDialog(mainPanel, "Videos Added.");
					}
					else {
						RQ.rollback();
						JOptionPane.showMessageDialog(mainPanel, "Changes reverted.");
					}
				}
				//String confirm = JOptionPane.showInputDialog(mainPanel, "Please Enter Password to Commit Changes.");
				
				
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Open new store");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String store_num = JOptionPane.showInputDialog(mainPanel, "Enter the store number of the new store.");
				String address = JOptionPane.showInputDialog(mainPanel, "Enter the new store's address.");
				System.out.println(store_num);
				if (store_num != null && !store_num.equals("")) {
					RQ.addStore(store_num, address);
				}
				else {
					JOptionPane.showMessageDialog(mainPanel, "Please enter valid information and try again.");
				}
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("View Member's Information");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String memberID = JOptionPane.showInputDialog(mainPanel, "Enter the member's ID.");
				try {
					ResultSet rs = RQ.getInfo(memberID);
					while (rs.next()) {
						String m_id = rs.getString("m_id");
						String lname = rs.getString("lname");
						String fname = rs.getString("fname");
						String address = rs.getString("address");
						str_List.add(m_id);
						str_List2.add(lname);
						str_List3.add(fname);
						str_List4.add(address);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Member ID | Last Name | First Name | Address \n";
				resultList += str_List.get(0) + "      |      " + str_List2.get(0) + "      |      " + str_List3.get(0) + "      |      " + str_List4.get(0) + "\n";
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
			}
		});
		fileMenu2.add(menuItem);

		menuItem = new JMenuItem("View Inventory");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getMovies();
				try {
					while (rs.next()) {
						String title = rs.getString("title");
						String stock_num = rs.getString("stock_num");
						String v_id = rs.getString("v_id");
						String qoh = rs.getString("qoh");
						str_List.add(title);
						str_List2.add(stock_num);
						str_List3.add(v_id);
						str_List4.add(qoh);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Quantity | Video ID | Stock Number | Title \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List4.get(x) + "   |   " + str_List3.get(x) + "   |   " + str_List2.get(x) + "   |   " + str_List.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("List of Videos Due");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = JOptionPane.showInputDialog(mainPanel, "Enter the date in the format YYYY-MM-DD.");
				ResultSet rs = RQ.getDue(date);
				try {
					while (rs.next()) {
						String rental_num = rs.getString("rental_num");
						String m_id = rs.getString("m_id");
						str_List.add(m_id);
						str_List2.add(rental_num);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Rental Number | Member ID \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List2.get(x) + "    |    " + str_List.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
				
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Member's Rental History");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getNotRented();
				ResultSet rs2 = RQ.getTimesRented();
				try {
					while (rs.next()) {
						String m_id = rs.getString("m_id");
						str_List.add(m_id);
					}
					while (rs2.next()) {
						String m_id2 = rs2.getString("m_id");
						String times_rented = rs2.getString("times_rented");
						str_List2.add(m_id2);
						str_List3.add(times_rented);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Member ID  | Times Rented \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List.get(x) + "             |         0 " + "\n";
				}
				for (int x = 0; x < str_List2.size(); x++) {
					resultList += str_List2.get(x) + "             |         " + str_List3.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
				
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Employee Commission Report");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getCommission();
				try {
					while (rs.next()) {
						String commission = rs.getString("commission_rate");
						String employee = rs.getString("e_id");
						str_List.add(commission);
						str_List2.add(employee);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Employee ID | Commission Rate \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List2.get(x) + "    |    " + str_List.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Member List");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getMembers();
				try {
					while (rs.next()) {						
						String fname = rs.getString("fname");
						String m_id = rs.getString("m_id");
						String lname = rs.getString("lname");
						str_List.add(m_id);
						str_List2.add(fname);
						str_List3.add(lname);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Member ID | First Name | Last Name | Times Rented \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List.get(x) + "    |    " + str_List2.get(x) + "   |   " +  str_List3.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Rental History");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.getRentals();
				try {
					while (rs.next()) {
						String rental_num = rs.getString("rental_num");
						String m_id = rs.getString("m_id");
						String date_out = rs.getString("date_out");
						String date_in = rs.getString("due_date");
						str_List.add(rental_num);
						str_List2.add(m_id);
						str_List3.add(date_out);
						str_List4.add(date_in);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultList += "Rental Number | Member ID | Date Rented | Due Date \n";
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List.get(x) + "   |   " + str_List2.get(x) + "   |   " + str_List3.get(x) + "   |   " + str_List4.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
				str_List2.clear();
				str_List3.clear();
				str_List4.clear();
				
			}
		});
		fileMenu3.add(menuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(fileMenu2);
		menuBar.add(fileMenu3);

		setJMenuBar(menuBar);
	}
	
	private JPanel initUI() {

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(50, 50, 50));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        layout = new CardLayout();
        mainPanel.setLayout(layout);

        horka1 = new ImageIcon("Resources/hp.jpg");
        horka2 = new ImageIcon("Resources/shawshank.jpg");
        horka3 = new ImageIcon("Resources/walle.jpg");
        horka4 = new ImageIcon("Resources/lotrjpg.jpg");

        previ = new ImageIcon("Resources/arrow-27.png");
        nexti = new ImageIcon("Resources/rightarrow-27.png");

        JLabel label1 = new JLabel(horka1);
        JLabel label2 = new JLabel(horka2);
        JLabel label3 = new JLabel(horka3);
        JLabel label4 = new JLabel(horka4);

        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(label3);
        mainPanel.add(label4);

        add(mainPanel);

        JButton prevButton = new JButton(previ);
        prevButton.setBackground(Color.WHITE);
        prevButton.addActionListener((ActionEvent e) -> {
            layout.previous(mainPanel);
        });

        JButton nextButton = new JButton(nexti);
        nextButton.setBackground(Color.WHITE);
        nextButton.addActionListener((ActionEvent e) -> {
            layout.next(mainPanel);
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(50, 50, 50));
        btnPanel.add(prevButton);
        btnPanel.add(nextButton);
        add(btnPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
        setVisible(true);        
		return mainPanel;
    }
}
