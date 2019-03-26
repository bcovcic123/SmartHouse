package SmartHouse.src;

import java.awt.EventQueue;
import javax.swing.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SmartHouse {

	private JFrame frame;
	private JPasswordField passwordField;
	public Boolean window1=false, window2=false, door=false;
	public String password="admin";
	public String alarm="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartHouse window = new SmartHouse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmartHouse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		JLabel lblCurrentTime = new JLabel("Current time: ");
		lblCurrentTime.setBounds(127, 0, 200, 23);
		frame.getContentPane().add(lblCurrentTime);
		
		JButton btnNewButton_1 = new JButton("Closed");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(window1==true)
				{
					window1=false;
					btnNewButton_1.setText("Closed");
					
				}else
				{
					window1=true;
					btnNewButton_1.setText("Open");
				}
			}
		});
		btnNewButton_1.setBounds(10, 57, 102, 73);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnWindow = new JButton("Closed");
		btnWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(window2==true)
				{
					window2=false;
					btnWindow.setText("Closed");
					
				}else
				{
					window2=true;
					btnWindow.setText("Open");
				}
			}
		});
		btnWindow.setBounds(119, 57, 102, 73);
		frame.getContentPane().add(btnWindow);
		
		JButton btnDoor = new JButton("Closed");
		btnDoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(door==true)
				{
					btnDoor.setText("Closed");
					door=false;
				}else
				{
					if(passwordField.getText().equals(password))
					{
						door=true;
						btnDoor.setText("Open");
						passwordField.setText("");
					}
				}
					
			}
		});
		btnDoor.setBounds(129, 158, 89, 99);
		frame.getContentPane().add(btnDoor);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 153, 81, 23);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 182, 102, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblWindows = new JLabel("Windows");
		lblWindows.setBounds(89, 34, 132, 23);
		frame.getContentPane().add(lblWindows);
		
		JLabel lblDoor = new JLabel("Door");
		lblDoor.setBounds(140, 136, 81, 23);
		frame.getContentPane().add(lblDoor);
		
		JLabel lblLights = new JLabel("Lights: ");
		lblLights.setBounds(247, 57, 177, 23);
		frame.getContentPane().add(lblLights);
		
		JLabel lblOven = new JLabel("Oven: ");
		lblOven.setBounds(247, 81, 177, 23);
		frame.getContentPane().add(lblOven);
		
		JLabel lblTeaMachine = new JLabel("Tea machine:");
		lblTeaMachine.setBounds(247, 107, 177, 23);
		frame.getContentPane().add(lblTeaMachine);
		
		JLabel lblHomepage = new JLabel("Homepage: ");
		lblHomepage.setBounds(247, 136, 177, 23);
		frame.getContentPane().add(lblHomepage);
		
		JLabel lblSecurityAlarm = new JLabel("Security alarm:");
		lblSecurityAlarm.setBounds(247, 165, 177, 23);
		frame.getContentPane().add(lblSecurityAlarm);
		
		JLabel lblTv = new JLabel("TV: ");
		lblTv.setBounds(247, 192, 177, 23);
		frame.getContentPane().add(lblTv);
		
		JLabel lblAlarm = new JLabel("Alarm(hh:mm):");
		lblAlarm.setBounds(247, 221, 80, 23);
		frame.getContentPane().add(lblAlarm);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(342, 222, 29, 20);
		frame.getContentPane().add(spinner);		
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(381, 222, 29, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblAlarmTimeOff = new JLabel("Alarm time: OFF");
		lblAlarmTimeOff.setBounds(31, 267, 200, 23);
		frame.getContentPane().add(lblAlarmTimeOff);
		
		JButton btnSetAlarm = new JButton("Set alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(spinner.getValue().toString())<24 && Integer.parseInt(spinner_1.getValue().toString())<60)
				{
					String hh,mm;
					if(Integer.parseInt(spinner.getValue().toString())<10) hh="0"+spinner.getValue().toString();
					else hh=spinner.getValue().toString();
					if(Integer.parseInt(spinner_1.getValue().toString())<10) mm="0"+spinner_1.getValue().toString();
					else mm=spinner_1.getValue().toString();
					
					lblAlarmTimeOff.setText("Alarm: "+hh+":"+mm+":00");
					alarm=hh+":"+mm+":00";
				}
					
			}
		});
		btnSetAlarm.setBounds(287, 255, 89, 23);
		frame.getContentPane().add(btnSetAlarm);
		
		
		
		Timer t=new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				lblCurrentTime.setText("Current time: "+sdf.format(new java.util.Date()));
				String s=sdf.format(new java.util.Date()).substring(0,2);
				int a=Integer.parseInt(s);
				if(a>=7 && a<=17)
				{
					lblLights.setText("Lights: OFF");
					lblSecurityAlarm.setText("Security alarm: OFF");
				}else
				{
					lblLights.setText("Lights: ON");
					lblSecurityAlarm.setText("Security alarm: ON");
				}
				if(a>=7 && a<=8 )
				{
					lblOven.setText("Oven: ON");
					lblTeaMachine.setText("Tea machine: ON");
					lblHomepage.setText("Homepage: ON");
				}else
				{
					lblOven.setText("Oven: OFF");
					lblTeaMachine.setText("Tea machine: OFF");
					lblHomepage.setText("Homepage: OFF");
				}
				
				if(a>=20 && a<=21 )
				{
					lblTv.setText("TV: ON");
				}else
				{
					lblTv.setText("TV: OFF");
				}
				
				if(alarm.equals(sdf.format(new java.util.Date()))) JOptionPane.showMessageDialog(frame,"ALARM");
				
				
				
				
					
					
				
			}
			
		}
				);
		t.start();
		
	}
}
