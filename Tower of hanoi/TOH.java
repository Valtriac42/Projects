import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TOH extends JFrame implements ActionListener
{

	JTextField game_over;
	
	JButton button_A;
	JButton button_B;
	JButton button_C;
	JButton reset_but;
	
	JLabel label;
	
	// Towers
	JPanel tower_A;
	JPanel tower_B;
	JPanel tower_C;

	JPanel disc1;
	JPanel disc2;
	JPanel disc3;
	JPanel disc4;

	// DISC length
	int disc1_len = 90;
	int disc2_len = 120;
	int disc3_len = 150;
	int disc4_len = 180;
	
	int disc_wid = 45;

	// Disc X Offset
	int disc1_X = 145;
	int disc2_X = 130;
	int disc3_X = 115;
	int disc4_X = 100;

	// Disc Y offset
	int disc1_Y = 100;
	int disc2_Y = 150;
	int disc3_Y = 200;
	int disc4_Y = 250;

	// Stacks 
	Stack<Integer> stkA;
	Stack<Integer> stkB;
	Stack<Integer> stkC;

	// selection
	int sel = 0;

	// Top of stack

	int TopA;
	int TopB;
	int TopC;
	int stkC_size;


	TOH()
	{	
		//Discs


		disc1 =new JPanel();		
		disc1.setBackground(Color.RED);
		disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
		disc1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(disc1);
		
		disc2 =new JPanel();		
		disc2.setBackground(Color.RED);
		disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
		disc2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(disc2);

		disc3 =new JPanel();		
		disc3.setBackground(Color.RED);
		disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
		disc3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(disc3);

		disc4 =new JPanel();		
		disc4.setBackground(Color.RED);
		disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
		disc4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(disc4);


		label = new JLabel();
		//label.setIcon(icon2);
		label.setBounds(150, 250, 150, 150);
		label.setVisible(false);
		
		// Buttons

		button_A = new JButton();
		button_A.setBounds(100,470,180,50);
		button_A.addActionListener(this);
		button_A.setText("A");		
		button_A.setFocusable(false);
		//button_A.setIcon(icon);
		button_A.setHorizontalTextPosition(JButton.CENTER);
		button_A.setVerticalTextPosition(JButton.BOTTOM);
		button_A.setFont(new Font("Comic Sans",Font.BOLD,25));
		button_A.setIconTextGap(-15);
		button_A.setForeground(Color.cyan);
		button_A.setBackground(Color.GRAY);
		button_A.setBorder(BorderFactory.createEtchedBorder());
		this.add(button_A);
				
		button_B = new JButton();
		button_B.setBounds(400,470,180,50);
		button_B.addActionListener(this);
		button_B.setText("B");		
		button_B.setFocusable(false);
		//button_B.setIcon(icon);
		button_B.setHorizontalTextPosition(JButton.CENTER);
		button_B.setVerticalTextPosition(JButton.BOTTOM);
		button_B.setFont(new Font("Comic Sans",Font.BOLD,25));
		button_B.setIconTextGap(-15);
		button_B.setForeground(Color.cyan);
		button_B.setBackground(Color.GRAY);
		button_B.setBorder(BorderFactory.createEtchedBorder());
		this.add(button_B);

		button_C = new JButton();
		button_C.setBounds(700,470,180,50);
		button_C.addActionListener(this);
		button_C.setText("C");		
		button_C.setFocusable(false);
		//button_C.setIcon(icon);
		button_C.setHorizontalTextPosition(JButton.CENTER);
		button_C.setVerticalTextPosition(JButton.BOTTOM);
		button_C.setFont(new Font("Comic Sans",Font.BOLD,25));
		button_C.setIconTextGap(-15);
		button_C.setForeground(Color.cyan);
		button_C.setBackground(Color.GRAY);
		button_C.setBorder(BorderFactory.createEtchedBorder());
		this.add(button_C);

		reset_but = new JButton();
		
		// Towers 

		tower_A = new JPanel();
		tower_A.setBackground(Color.BLACK);
		tower_A.setBounds(186,70,8,245);
		this.add(tower_A);
		
		tower_B = new JPanel();
		tower_B.setBackground(Color.BLACK);
		tower_B.setBounds(486,70,8,245);
		this.add(tower_B);

		tower_C = new JPanel();
		tower_C.setBackground(Color.BLACK);
		tower_C.setBounds(786,70,8,245);
		this.add(tower_C);
		
		JPanel base = new JPanel();
		base.setBackground(Color.BLACK);
		base.setBounds(186,315,608,8);
		this.add(base);

		// Background

		JPanel Background = new JPanel();
		Background.setBackground(Color.WHITE);
		Background.setSize(9999,9999);
		this.add(Background);

		// Frame 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("HANOI");
		this.setLayout(null);
		this.setBounds(300,150,1000,600);
		this.setVisible(true);
		this.add(label);
	
		// Stack

		stkA = new Stack<>();
		stkB = new Stack<>();
		stkC = new Stack<>();
		stkA.push(3);
		stkA.push(2);
		stkA.push(1);
		stkA.push(0);

	}
	public static void main(String[] args) 
	{
		JFrame welcome = new JFrame();
		welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcome.setTitle("HANOI");
		welcome.setLayout(null);
		welcome.setBounds(300,150,1000,600);		
		

		
		
		JTextField rules = new JTextField();
		rules.setText("Tower of Hanoi Rules :-");
		rules.setBounds(145,50,700,70);
		rules.setFont(new Font("Comic Sans",Font.BOLD,50));
		rules.setEditable(false);
		rules.setBackground(Color.WHITE);
		rules.setBorder(BorderFactory.createEmptyBorder());
		rules.setEnabled(true);
		rules.setVisible(true);
		welcome.add(rules);

		JTextArea rules2 = new JTextArea();
		rules2.setText("1: The objective of the game is to move the entire stack on rod A to rod C.\r\n2: Only one disk can be moved at a time. \r\n3: Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod. \r\n4: No disk may be placed on top of a smaller disk.");
		rules2.setBounds(145,150,710,200);
		rules2.setFont(new Font("Comic Sans",Font.BOLD,20));
		rules2.setEditable(false);
		rules2.setBackground(Color.WHITE);
		rules2.setLineWrap(true);
		rules2.setBorder(BorderFactory.createEmptyBorder());
		rules2.setEnabled(true);
		rules2.setWrapStyleWord(true);
		//rules2.setVisible(true);
		welcome.add(rules2);

		JButton start_but = new JButton();
		start_but.setBounds(700,470,180,50);
		start_but.setText("Start");
		start_but.setFocusable(false);
		start_but.setHorizontalTextPosition(JButton.CENTER);
		start_but.setVerticalTextPosition(JButton.BOTTOM);
		start_but.setFont(new Font("Comic Sans",Font.BOLD,25));
		start_but.setIconTextGap(-15);
		start_but.setForeground(Color.cyan);
		start_but.setBackground(Color.GRAY);
		start_but.setBorder(BorderFactory.createEtchedBorder());
		
		start_but.setEnabled(true);
		start_but.setVisible(true);
		welcome.add(start_but);
		welcome.setVisible(true);

		JPanel bg = new JPanel();
		bg.setSize(9999,9999);
		bg.setBackground(Color.WHITE);
		welcome.add(bg);
		

		start_but.addActionListener(new ActionListener()
		{  
    		public void actionPerformed(ActionEvent e)
    		{
    			if(e.getSource()==start_but)
				{	
					welcome.dispose();
					new TOH();
				}
    		}
    	} );
    	

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource()==reset_but)
		{
			this.dispose();
			new TOH();
		}
		else if(e.getSource()==button_A) 
		{
			if(sel==0)
			{	
				if(stkA.empty())
				{
					sel=0;
					unhightlight();

				}
				else
				{
					hightlight(stkA.peek());
					sel=1;
				}
			}
			else if(sel==1)
			{
				sel=0;
				unhightlight();
			}
			else if (sel==2)
			{	
				if(stkA.size()>0)
				{
					TopA = stkA.peek();
					TopB = stkB.peek();
					if(TopB>TopA)
					{
						return;
					}
					else
					{
						stkA.push(stkB.pop());
						int stkA_size = stkA.size();
						if(stkA.peek()==0)
						{
							disc1_X = 145;
							disc1_Y = 250-(stkA_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkA.peek()==1)
						{
							disc2_X = 130;
							disc2_Y = 250-(stkA_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkA.peek()==2)
						{
							disc3_X = 115;
							disc3_Y = 250-(stkA_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkA.peek()==3)
						{
							disc4_X = 100;
							disc4_Y = 250-(stkA_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
						
					}
				}
				else
					{
						stkA.push(stkB.pop());
						int stkA_size = stkA.size();
						if(stkA.peek()==0)
						{
							disc1_X = 145;
							disc1_Y = 250-(stkA_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkA.peek()==1)
						{
							disc2_X = 130;
							disc2_Y = 250-(stkA_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkA.peek()==2)
						{
							disc3_X = 115;
							disc3_Y = 250-(stkA_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkA.peek()==3)
						{
							disc4_X = 100;
							disc4_Y = 250-(stkA_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
							
					}
					sel=0;
					unhightlight();
			}
			else if (sel==3)
			{	
				if(stkA.size()>0)
				{
					TopA = stkA.peek();
				TopC = stkC.peek();
				if(TopC>TopA)
				{
					return;
				}
				else
				{
					stkA.push(stkC.pop());	
					int stkA_size = stkA.size();
					if(stkA.peek()==0)
					{
						disc1_X = 145;
						disc1_Y = 250-(stkA_size-1)*50;
						disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
					}
					else if(stkA.peek()==1)
					{
						disc2_X = 130;
						disc2_Y = 250-(stkA_size-1)*50;
						disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
					}
					else if(stkA.peek()==2)
					{
						disc3_X = 115;
						disc3_Y = 250-(stkA_size-1)*50;
						disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
					}
					else if(stkA.peek()==3)
					{
						disc4_X = 100;
						disc4_Y = 250-(stkA_size-1)*50;
						disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
					}
					
				}
				}
			
			else
				{
					stkA.push(stkC.pop());	
					int stkA_size = stkA.size();
					if(stkA.peek()==0)
					{
						disc1_X = 145;
						disc1_Y = 250-(stkA_size-1)*50;
						disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
					}
					else if(stkA.peek()==1)
					{
						disc2_X = 130;
						disc2_Y = 250-(stkA_size-1)*50;
						disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
					}
					else if(stkA.peek()==2)
					{
						disc3_X = 115;
						disc3_Y = 250-(stkA_size-1)*50;
						disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
					}
					else if(stkA.peek()==3)
					{
						disc4_X = 100;
						disc4_Y = 250-(stkA_size-1)*50;
						disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
					}
				
				}
				sel=0;
				unhightlight();
			}
		}	
		else if(e.getSource()==button_B) 
		{
			if(sel==0)
			{	
				if(stkB.empty())
				{
					sel=0;
					unhightlight();
				}
				else
				{
					sel=2;
					hightlight(stkB.peek());
				}
			}
			else if(sel==1)
			{
				if(stkB.size()>0)
				{
					TopA = stkA.peek();
				TopB = stkB.peek();
				if(TopB<TopA)
				{
					return;
				}
				else
				{
					stkB.push(stkA.pop());
					int stkB_size = stkB.size();
					if(stkB.peek()==0)
					{
						disc1_X = 445;
						disc1_Y = 250-(stkB_size-1)*50;
						disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
					}
					else if(stkB.peek()==1)
					{
						disc2_X = 430;
						disc2_Y = 250-(stkB_size-1)*50;
						disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
					}
					else if(stkB.peek()==2)
					{
						disc3_X = 415;
						disc3_Y = 250-(stkB_size-1)*50;
						disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
					}
					else if(stkB.peek()==3)
					{
						disc4_X = 400;
						disc4_Y = 250-(stkB_size-1)*50;
						disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
					}
						
				}
				
				}
			else
				{
					stkB.push(stkA.pop());
					int stkB_size = stkB.size();
					if(stkB.peek()==0)
					{
						disc1_X = 445;
						disc1_Y = 250-(stkB_size-1)*50;
						disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
					}
					else if(stkB.peek()==1)
					{
						disc2_X = 430;
						disc2_Y = 250-(stkB_size-1)*50;
						disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
					}
					else if(stkB.peek()==2)
					{
						disc3_X = 415;
						disc3_Y = 250-(stkB_size-1)*50;
						disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
					}
					else if(stkB.peek()==3)
					{
						disc4_X = 400;
						disc4_Y = 250-(stkB_size-1)*50;
						disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
					}
					sel = 0;
					unhightlight();	
				}
				sel=0;
				unhightlight();
			}
			else if (sel==2)
			{	
				sel=0;
				unhightlight();
			}
			else if (sel==3)
			{	
				if(stkB.size()>0)
				{
					TopB = stkB.peek();
					TopC = stkC.peek();
					if(TopC>TopB)
					{
						return;
					}
					else
					{
						stkB.push(stkC.pop());	
						int stkB_size = stkB.size();
						if(stkB.peek()==0)
						{
							disc1_X = 445;
							disc1_Y = 250-(stkB_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkB.peek()==1)
						{
							disc2_X = 430;
							disc2_Y = 250-(stkB_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkB.peek()==2)
						{
							disc3_X = 415;
							disc3_Y = 250-(stkB_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkB.peek()==3)
						{
							disc4_X = 400;
							disc4_Y = 250-(stkB_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
						sel = 0;
						unhightlight();
					}
				}
				else
					{
						stkB.push(stkC.pop());	
						int stkB_size = stkB.size();
						if(stkB.peek()==0)
						{
							disc1_X = 445;
							disc1_Y = 250-(stkB_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkB.peek()==1)
						{
							disc2_X = 430;
							disc2_Y = 250-(stkB_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkB.peek()==2)
						{
							disc3_X = 415;
							disc3_Y = 250-(stkB_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkB.peek()==3)
						{
							disc4_X = 400;
							disc4_Y = 250-(stkB_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
						sel = 0;
						unhightlight();
					}
					sel=0;
					unhightlight();
					
			}
		}
		else if(e.getSource()==button_C) 
		{	
			if(sel==0)
			{	
				if(stkC.empty())
				{
					sel=0;
					unhightlight();
				}
				else
				{
					sel=3;
					hightlight(stkC.peek());
				}
			}
			else if(sel==1)
			{
				if(stkC.size()>0)
				{
					TopA = stkA.peek();
					TopC = stkC.peek();
					if(TopC<TopA)
					{	

						return;
					}
					else
					{
						stkC.push(stkA.pop());
						stkC_size = stkC.size();
						if(stkC.peek()==0)
						{
							disc1_X = 745;
							disc1_Y = 250-(stkC_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkC.peek()==1)
						{
							disc2_X = 730;
							disc2_Y = 250-(stkC_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkC.peek()==2)
						{
							disc3_X = 715;
							disc3_Y = 250-(stkC_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkC.peek()==3)
						{
							disc4_X = 700;
							disc4_Y = 250-(stkC_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
						sel = 0;
						unhightlight();
					}
				
				}
				else
					{
						stkC.push(stkA.pop());
						int stkC_size = stkC.size();
						if(stkC.peek()==0)
						{
							disc1_X = 745;
							disc1_Y = 250-(stkC_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkC.peek()==1)
						{
							disc2_X = 730;
							disc2_Y = 250-(stkC_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkC.peek()==2)
						{
							disc3_X = 715;
							disc3_Y = 250-(stkC_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkC.peek()==3)
						{
							disc4_X = 700;
							disc4_Y = 250-(stkC_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}
							sel = 0;
							unhightlight();
					}
				sel=0;
				unhightlight();
			}

			else if (sel==2)
			{	
				if(stkC.size()>0)
				{
					TopB = stkB.peek();
					TopC = stkC.peek();
					if(TopC<TopB)
					{
						return;
					}
					else
					{
						stkC.push(stkB.pop());	
						int stkC_size = stkC.size();
						if(stkC.peek()==0)
						{
							disc1_X = 745;
							disc1_Y = 250-(stkC_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkC.peek()==1)
						{
							disc2_X = 730;
							disc2_Y = 250-(stkC_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkC.peek()==2)
						{
							disc3_X = 715;
							disc3_Y = 250-(stkC_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkC.peek()==3)
						{
							disc4_X = 700;
							disc4_Y = 250-(stkC_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						}					
					}
					sel=0;
					unhightlight();		
				}
				else
					{
						stkC.push(stkB.pop());	
						stkC_size = stkC.size();
						if(stkC.peek()==0)
						{
							disc1_X = 745;
							disc1_Y = 250-(stkC_size-1)*50;
							disc1.setBounds(disc1_X,disc1_Y,disc1_len,disc_wid);
						}
						else if(stkC.peek()==1)
						{
							disc2_X = 730;
							disc2_Y = 250-(stkC_size-1)*50;
							disc2.setBounds(disc2_X,disc2_Y,disc2_len,disc_wid);
						}
						else if(stkC.peek()==2)
						{
							disc3_X = 715;
							disc3_Y = 250-(stkC_size-1)*50;
							disc3.setBounds(disc3_X,disc3_Y,disc3_len,disc_wid);
						}
						else if(stkC.peek()==3)
						{
							disc4_X = 700;
							disc4_Y = 250-(stkC_size-1)*50;
							disc4.setBounds(disc4_X,disc4_Y,disc4_len,disc_wid);
						
					}
					}
					sel=0;
					unhightlight();

			}
			else if(sel==3)
			{	
				sel=0;
				unhightlight();

			}
			if(disc1_X == 745 && disc1_Y == 100)
			{
				this.dispose();
				EndScr();
			}
		}
		
	}

	void hightlight(int top)
	{
		if(top==0)
		{
			disc1.setBackground(Color.ORANGE);
		}
		else if(top==1)
		{
			disc2.setBackground(Color.ORANGE);
		}
		else if(top==2)
		{
			disc3.setBackground(Color.ORANGE);
		}
		else if(top==3)
		{
			disc4.setBackground(Color.ORANGE);
		}
	}
	void unhightlight()
	{	
		disc1.setBackground(Color.RED);
		disc2.setBackground(Color.RED);
		disc3.setBackground(Color.RED);
		disc4.setBackground(Color.RED);
	}


	void EndScr()
	{
		JFrame end = new JFrame();
			end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			end.setTitle("HANOI");
			end.setLayout(null);
			end.setBounds(300,150,1000,600);
			end.setVisible(true);

			JButton exit = new JButton();
			exit.setBounds(300,370,180,50);
			exit.setText("Exit");
			exit.setFocusable(false);
			exit.setHorizontalTextPosition(JButton.CENTER);
			exit.setVerticalTextPosition(JButton.BOTTOM);
			exit.setFont(new Font("Comic Sans",Font.BOLD,25));
			exit.setIconTextGap(-15);
			exit.setForeground(Color.cyan);
			exit.setBackground(Color.GRAY);
			exit.setBorder(BorderFactory.createEtchedBorder());
			end.add(exit);
			exit.addActionListener(new ActionListener()
			{  
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			if(e.getSource()==exit)
					{	
						end.dispose();
					}
	    		}
	    	} );


		button_A.setEnabled(false);
		button_B.setEnabled(false);
		button_C.setEnabled(false);
		
		reset_but.setEnabled(true);
		reset_but.setBounds(650,370,180,50);
		reset_but.setVisible(true);
		reset_but.addActionListener(this);
		reset_but.setText("Reset");		
		reset_but.setFocusable(false);
		//reset_but.setIcon(icon);
		reset_but.setHorizontalTextPosition(JButton.CENTER);
		reset_but.setVerticalTextPosition(JButton.BOTTOM);
		reset_but.setFont(new Font("Comic Sans",Font.BOLD,25));
		reset_but.setIconTextGap(-15);
		reset_but.setForeground(Color.cyan);
		reset_but.setBackground(Color.GRAY);
		reset_but.setBorder(BorderFactory.createEtchedBorder());
		end.add(reset_but);	


		/*JLabel label = new JLabel();
        label.setIcon(new ImageIcon("you-win.png"));
        Dimension size = label.getPreferredSize();
        label.setBounds(286,270,500,60);
        end.add(label);
*/

		game_over = new JTextField("Y O U  W I N  ! !");
		game_over.setForeground(Color.RED);
		game_over.setBackground(Color.WHITE);
		game_over.setBounds(285,70,510,100);
		game_over.setFont(new Font("Comic Sans",Font.BOLD,70));
		game_over.setEditable(false);
		game_over.setBorder(BorderFactory.createEmptyBorder());
		end.add(game_over);

		JTextArea dev = new JTextArea();
		dev.setText("Senior Developer:- Priyanshu Sharma");
		dev.setBounds(285,220,500,100);
		dev.setFont(new Font("Comic Sans",Font.BOLD,20));
		dev.setEditable(false);
		dev.setBackground(Color.WHITE);
		dev.setLineWrap(true);
		dev.setBorder(BorderFactory.createEmptyBorder());
		dev.setEnabled(true);
		dev.setWrapStyleWord(true);
		//dev.setVisible(true);
		end.add(dev);

		JPanel bg = new JPanel();
		bg.setSize(9999,9999);
		bg.setBackground(Color.WHITE);
		end.add(bg);
	}
}