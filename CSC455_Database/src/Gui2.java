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

public class Gui2 extends JFrame{
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu fileMenu2;
	private JMenu fileMenu3;
	private JMenu fileMenu4;
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
	static String resultList = "";

	
	
	public Gui2() {
		setSize(width, height);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RIP_Blockbuster");
		
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
				System.out.println("bench");
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("New Member Signup");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("List of outstanding videos");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Member Cancellation");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Video Purchase");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Video Return");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Add/Delete Employee");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Process new shipment of videos");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu2.add(menuItem);
		
		menuItem = new JMenuItem("Open new store");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu2.add(menuItem);

		menuItem = new JMenuItem("Print Catalog");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = RQ.GetMovies();
				try {
					while (rs.next()) {
						String title = rs.getString("title");
						str_List.add(title);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Print due list of videos");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Print employee commission report");
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
				for (int x = 0; x < str_List.size(); x++) {
					resultList += str_List2.get(x) + ": " + str_List.get(x) + "\n";
				}
				JOptionPane.showMessageDialog(mainPanel, resultList);
				resultList = "";
				str_List.clear();
			}
		});
		fileMenu3.add(menuItem);
		
		menuItem = new JMenuItem("Print rental summary");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bench");
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
