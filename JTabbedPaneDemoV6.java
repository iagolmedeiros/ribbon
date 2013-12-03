import javax.swing.*; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

import au.com.bytecode.opencsv.CSVWriter;

public class JTabbedPaneDemo extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long startTime;
	public int order = 1;
	public int orderB = 1;
	public static int error = 0;
	public int errorB = 0;
	public JButton buttonNewFile, buttonNewPDF, buttonNewImage, buttonNewDoc, buttonOpen, buttonOpenRecent, buttonSave,	buttonSavePDF, buttonSaveImage, editCut, editCopy, editPaste, editZoomPlus, editZoomMinus, buttonNewLabel, buttonDuplicate, buttonDeleteLabel, buttonCurves, buttonDistort, buttonContrast, buttonSetSize, buttonAdjustProportion, buttonSetRGB, buttonChoosePalette, buttonInvertColours, buttonBW, buttonHelpWebsite, buttonHelpForum, buttonHotkeys, buttonTips, buttonProgram, buttonTeam;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29;
	public long totalTime;
	
	public JTabbedPaneDemo() {
        super(new GridLayout(1,1));  
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = traditional("Traditional menu test");
        tabbedPane.addTab("Traditional", null, panel1, "Alpha test");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_T);        
     
        add(tabbedPane);           
        
        JComponent panel2 = information("Show information for the user");
        tabbedPane.addTab("Information", null, panel2, "Prompt the user about the test.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_I);
        add(tabbedPane);
        
        JComponent panel3 = makeTextPanel("Display results of my analysis");
        tabbedPane.addTab("Display Results", null, panel3, "results");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_D);
        add(tabbedPane);
        
        JComponent panel4 = ribbon("Ribbon menu test");
        tabbedPane.addTab("Ribbon", null, panel4, "");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_R);
        
        add(tabbedPane);
        
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    protected JComponent traditional (String textInTop) {
    	JPanel panel = new JPanel();   
//    	JFrame fr = new JFrame();
//    	fr.setVisible(true);
//    	fr.add(panel);
//    	fr.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//    	Toolkit tk = Toolkit.getDefaultToolkit();  
//        int xSize = ((int) tk.getScreenSize().getWidth());  
//        int ySize = ((int) tk.getScreenSize().getHeight());  
//        panel.setSize(xSize,ySize);
	        //traditionalLayout(panel);
	        panel.setLayout(new BorderLayout());
	        
	        //panel.setSize(1400, 1400);
	        //getContentPane().add( panel );

			// Create the menu bar
			JMenuBar menuBar = new JMenuBar();

			// Set this instance as the application's menu bar
			panel.add(menuBar);
			
/*****************************************FILE************************************************/
			
			// Create the File Menu
			JMenu menuFile = new JMenu( "File" );
			menuBar.add( menuFile );
			
			// Sub-menus of File Menu	
			JMenu menuNew = new JMenu ("New");
			JMenu menuOpen = new JMenu ("Open");			
			JMenu menuSaveAs = new JMenu ("SaveAs");
			
			//Buttons of FILE > NEW
			buttonNewFile = new JButton("New file");
			buttonNewPDF = new JButton ("New PDF");
			buttonNewImage = new JButton ("New Image");
			buttonNewDoc = new JButton ("New Doc");
			
			//Buttons of FILE > Open
			buttonOpen = new JButton("Open Image");
			buttonOpenRecent = new JButton("Open Recent Images");
			
			//Buttons of FILE > SaveAs
			
			buttonSave = new JButton ("Save");
			buttonSavePDF = new JButton("Save as pdf");
			buttonSaveImage = new JButton("Save as JPEG");
			
			// Add to the Menu File
			menuFile.addSeparator();			
			menuFile.add( menuNew );
			menuFile.add( menuOpen );			
			menuFile.add( menuSaveAs );		
			menuFile.addSeparator();
			
			//Add to the Menu Sub-files

			menuNew.add(buttonNewFile);
			menuNew.add(buttonNewDoc);
			menuNew.add(buttonNewImage);
			menuNew.add(buttonNewPDF);
			menuOpen.add(buttonOpen);
			menuOpen.add(buttonOpenRecent);
			menuSaveAs.add( buttonSave );
			menuSaveAs.add(buttonSavePDF);
			menuSaveAs.add(buttonSaveImage);
			
/*****************************************Edit************************************************/			
			// Create the edit menu
			JMenu menuEdit = new JMenu( "Edit" );
			menuBar.add(menuEdit);

			// Sub-menus of Edit Menu	
			editCut = new JButton ("Cut");
			editCopy = new JButton ("Copy");
			editPaste = new JButton ("Paste");
			editZoomPlus = new JButton ("Zoom +");
			editZoomMinus = new JButton ("Zoom -");

			// Add to the Edit
			menuEdit.add(editCut);
			menuEdit.add(editCopy);
			menuEdit.add(editPaste);
			menuEdit.add(editZoomPlus);
			menuEdit.add(editZoomMinus);
			
/*****************************************INSERT************************************************/			
			// Create the insert menu
			JMenu menuInsert = new JMenu( "Insert" );
			menuBar.add(menuInsert);
			
			// Sub-menus of Insert	
			JMenu insertNewLabel = new JMenu ("Insert New Label");
			JMenu insertAdjusts = new JMenu ("Insert Adjusts");			
			
			//Buttons of Insert > Label
			buttonNewLabel = new JButton("New Label");
			buttonDuplicate = new JButton("Duplicate");
			buttonDeleteLabel = new JButton("Delete label");
			
			//Buttons of Insert > Adjusts
			buttonCurves = new JButton("Curves");
			buttonDistort = new JButton("Distort");
			buttonContrast = new JButton("Contrast");
			
			// Add to the Insert			
			menuInsert.add(insertNewLabel);
			menuInsert.add(insertAdjusts);
			
			// Add to the Insert Sub-menus
			insertNewLabel.add(buttonNewLabel);
			insertNewLabel.add(buttonDuplicate);
			insertNewLabel.add(buttonDeleteLabel);
			
			insertAdjusts.add(buttonCurves);
			insertAdjusts.add(buttonDistort);
			insertAdjusts.add(buttonContrast);
			
/*****************************************Settings************************************************/				
			// Create the settings menu
			JMenu menuSettings = new JMenu( "Settings" );
			menuBar.add(menuSettings);
			
			// Sub-menus of Settings	
			JMenu settingsSize = new JMenu ("Size");
			JMenu settingsColours = new JMenu ("Colours");
			
			//Buttons of Settings > Size
			buttonSetSize = new JButton("Set size");
			buttonAdjustProportion = new JButton("Adjust Proportion");

			//Buttons of Settings > Colours
			buttonSetRGB = new JButton("Set RGB");
			buttonChoosePalette = new JButton("Choose Palette");
			buttonInvertColours = new JButton("Invert Colours");
			buttonBW = new JButton("Black & White");
			
			// Add to the Settings		
			menuSettings.add(settingsSize);
			menuSettings.add(settingsColours);
			
			// Add to the Settings Sub-menus		
			settingsSize.add(buttonSetSize);
			settingsSize.add(buttonAdjustProportion);
			
			settingsColours.add(buttonSetRGB);
			settingsColours.add(buttonChoosePalette);
			settingsColours.add(buttonInvertColours);
			settingsColours.add(buttonBW);
/*****************************************Help************************************************/	
			// Create the help menu
			JMenu menuHelp = new JMenu( "Help" );
			menuBar.add(menuHelp);
												
			// Sub-menus of Help	
			buttonHelpWebsite = new JButton("Website");
			buttonHelpForum = new JButton("Forum");
			JMenu helpTutorials = new JMenu("Tutorials");
			JMenu helpAbout = new JMenu("About");
			
			//Buttons of Help > Tutorials
			buttonHotkeys = new JButton("Hotkeys");
			buttonTips = new JButton("Tips");
			
			//Buttons of Help > About
			buttonProgram = new JButton("Program");
			buttonTeam = new JButton("Team");
			
			// Add to the Help		
			menuHelp.add(buttonHelpWebsite);
			menuHelp.add(buttonHelpForum);
			menuHelp.add(helpTutorials);
			menuHelp.add(helpAbout);
			
			// Add to the Help Sub-menus		
			helpTutorials.add(buttonHotkeys);
			helpTutorials.add(buttonTips);
			
			helpAbout.add(buttonProgram);
			helpAbout.add(buttonTeam);
			
/*****************************************Action Listeners************************************************/							
			buttonNewFile.addActionListener(wha);
			buttonNewPDF.addActionListener(wha);
			buttonNewImage.addActionListener(wha);
			buttonNewDoc.addActionListener(wha);
			buttonOpen.addActionListener(wha);
			buttonOpenRecent.addActionListener(wha);
			buttonSave.addActionListener(wha);
			buttonSavePDF.addActionListener(wha);
			buttonSaveImage.addActionListener(wha);
			editCut.addActionListener(wha);
			editCopy.addActionListener(wha);
			editPaste.addActionListener(wha);
			editZoomPlus.addActionListener(wha);
			editZoomMinus.addActionListener(wha);
			buttonNewLabel.addActionListener(wha);
			buttonDuplicate.addActionListener(wha);
			buttonDeleteLabel.addActionListener(wha);
			buttonCurves.addActionListener(wha);
			buttonDistort.addActionListener(wha);
			buttonContrast.addActionListener(wha);
			buttonSetSize.addActionListener(wha);
			buttonAdjustProportion.addActionListener(wha);
			buttonSetRGB.addActionListener(wha);
			buttonChoosePalette.addActionListener(wha);
			buttonInvertColours.addActionListener(wha);
			buttonBW.addActionListener(wha);
			buttonHelpWebsite.addActionListener(wha);
			buttonHelpForum.addActionListener(wha);
			buttonHotkeys.addActionListener(wha);
			buttonTips.addActionListener(wha);
			buttonProgram.addActionListener(wha);
			buttonTeam.addActionListener(wha);		
		
			return panel;
    }
    
    protected JComponent ribbon (String textInTop) {
    	JPanel panel = new JPanel(false);    	
	        ribbonLayout(panel);
	        setLayout(new BorderLayout());	 
	        panel.setVisible(true);
	        return panel;
    }
    
    protected JComponent information (String textInTop) {
    	JPanel frame = new JPanel();
        informationLayout(frame);
        frame.setVisible(true);
		return frame;
    }
     
     ActionListener wha = new ActionListener() {
    	public void actionPerformed (ActionEvent e) {
    		Object click = e.getSource();
    		if (click == buttonTeam) {
    			if (order == 1) {
    				order = 2;
    		    	JFrame frame = new JFrame();
    		    	JOptionPane.showMessageDialog(frame, "Now click on: edit > paste");
    		} else {
    	   		  error++;
    	   	  }	    		
    	} else if (click == editPaste) {
	      if (order == 2) {
	    	  		order = 3;
	    	  		JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: insert > new labels > duplicate");
			} else {
				error++;
	   	    }	    		
    	} else if (click == buttonDuplicate) {
			if (order == 3) {
				    order = 4;
				    JFrame frame = new JFrame();
				    JOptionPane.showMessageDialog(frame, "Now click on: file > save as> save as jpeg");
		} else {
	   		  error++;
	   	  }	    		
	    } else if (click == buttonSaveImage) {
			if (order == 4) {
					order = 5;
					JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: settings > colours > choose pallete");
		} else {
	   		  error++;
	   	  }	    		
	    } else if (click == buttonChoosePalette) {
			if (order == 5) {
					System.out.println("erros: " + error);
					long endTime = System.currentTimeMillis();
		    		  totalTime = endTime - startTime;		    		  
		    		  String s = String.valueOf(totalTime);
		    		  int epa = Integer.valueOf(s);
		    		  System.out.println(totalTime/1000);
		    		  System.out.println(s);
		    		  try {
						generateCsvFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
					JFrame frame = new JFrame();
	                JOptionPane.showMessageDialog(frame, "Thank you for your time. Now prepare for ribbon menu");
		} else {
	   		  error++;
	   	  }	    		
	    } else {
	    	error++;
	    }
    }
     };
          
    ActionListener actionListener = new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		      		
    		  long endTime = System.currentTimeMillis();
    		  totalTime = endTime - startTime;
    		  String s = String.valueOf(totalTime);
    		  int epa = Integer.valueOf(s);
    		  System.out.println(totalTime/1000);
    		 // generateCsvFile(s);    		      		      		      		  
    	  }
    	};
    
    	private static void generateCsvFile () throws IOException {
    		CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
    	     // feed in your array (or convert your data to an array)
    		String s = String.valueOf(error); 
    	     String[] entries = s.split("#");
    	     writer.writeNext(entries);
    		writer.close();
//    		try {
//  			  FileWriter out = new FileWriter("output4.csv");
//  			  
//  			String s = String.valueOf(error);
//  			  out.append(s);
////  			out.append(totalTime);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
    	}
    
    FlowLayout experimentLayout = new FlowLayout();
    public void traditionalLayout(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);   
        experimentLayout.setAlignment(FlowLayout.TRAILING);
        compsToExperiment.add(new JButton("File"));
        compsToExperiment.add(new JButton("Insert"));
        compsToExperiment.add(new JButton("Edit"));
        compsToExperiment.add(new JButton("Other"));
        compsToExperiment.add(new JButton("Help"));
        pane.add(compsToExperiment, BorderLayout.NORTH);
        
    }
       
//    protected JComponent rib2 (Container pane) {
//    	JFrame sframe = new JFrame();
//    	JPanel complete = new JPanel();
//    	JPanel basic = new JPanel();
//        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
//        add(basic);
//
//        basic.add(Box.createVerticalGlue());
//
//        JPanel bottom = new JPanel();
//        bottom.setAlignmentX(1f);
//        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
//
//        JButton ok = new JButton("OK");
//        JButton close = new JButton("Close");
//
//        bottom.add(ok);
//        bottom.add(Box.createRigidArea(new Dimension(5, 0)));
//        bottom.add(close);
//        bottom.add(Box.createRigidArea(new Dimension(15, 0)));
//
//        basic.add(bottom);
//        basic.add(Box.createRigidArea(new Dimension(0, 15)));
//
//        complete.add(basic);
//        complete.add(bottom);
//        
//        sframe.add(complete);
//        
//        sframe.setTitle("Two Buttons");
//        setSize(300, 150);
//        sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        sframe.setLocationRelativeTo(null);
//        sframe.setVisible(true);
//        return complete;
//    }	
    ActionListener wha2 = new ActionListener() {
    	public void actionPerformed (ActionEvent e) {
    		Object click = e.getSource();
    		if (click == b29) {
    			if (orderB == 1) {
    				orderB = 2;
    		    	JFrame frame = new JFrame();
    		    	JOptionPane.showMessageDialog(frame, "Now click on: paste");
    		} else {
    	   		  errorB++;
    	   	  }	    		
    	} else if (click == b12) {
	      if (orderB == 2) {
	    	  		orderB = 3;
	    	  		JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: duplicate");
			} else {
				errorB++;
	   	    }	    		
    	} else if (click == b16) {
			if (orderB == 3) {
				    orderB = 4;
				    JFrame frame = new JFrame();
				    JOptionPane.showMessageDialog(frame, "Now click on: save as jpeg");
		} else {
	   		  errorB++;
	   	  }	    		
	    } else if (click == b9) {
			if (orderB == 4) {
					orderB = 5;
					JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: choose pallete");
		} else {
	   		  errorB++;
	   	  }	    		
	    } else if (click == b21) {
			if (orderB == 5) {
					System.out.println("erros: " + errorB);
					JFrame frame = new JFrame();
	                JOptionPane.showMessageDialog(frame, "Thank you for your time!");
		} else {
	   		  errorB++;
	   	  }	    		
	    } else {
	    	errorB++;
	    }
    }
     };
    
//    public void rib (Container pane) {  
//    	JFrame frame = new JFrame();
//    	JPanel panel = new JPanel(new GridLayout(3, 3));   	
//    	JPanel panel1 = new JPanel();
//    	JPanel panel1a = new JPanel();
//    	JPanel panel2 = new JPanel();
//    	JPanel panel3 = new JPanel();
//    	JPanel panel4 = new JPanel();
//    	JPanel panel5 = new JPanel();
//    	JPanel panel6 = new JPanel();
//    	JPanel panel7 = new JPanel();
//    	JButton b1 = new JButton("New File");    
//    	JButton b2 = new JButton("New doc");
//        JButton b3 = new JButton("New Image");
//        JButton b4 = new JButton("New Pdf");
//        JButton b5 = new JButton("Open Image");
//        JButton b6 = new JButton("Open recent image");
//        JButton b7 = new JButton("save");
//        JButton b8 = new JButton("save as pdf");
//        JButton b9 = new JButton("save as jpeg");
//        JButton b10 = new JButton("cut");
//        JButton b11 = new JButton("copy");
//        JButton b12 = new JButton("paste");
//        JButton b13 = new JButton("zoom+");
//        JButton b14 = new JButton("zoom-");
//        JButton b15 = new JButton("new label");
//        JButton b16 = new JButton("duplicate");
//        JButton b17 = new JButton("delete label");
//        JButton b18 = new JButton("set size");
//        JButton b19 = new JButton("adjust proportion");
//        JButton b20 = new JButton("set rgb");
//        JButton b21 = new JButton("choose palette");
//        JButton b22 = new JButton("invert colours");
//        JButton b23 = new JButton("BW");
//        JButton b24 = new JButton("help website");
//        JButton b25 = new JButton("help forum");
//        JButton b26 = new JButton("tutorial hotkeys");
//        JButton b27 = new JButton("tutorial tips");
//        JButton b28 = new JButton("about program");
//        JButton b29 = new JButton("about team");
//        panel1.setAlignmentX(RIGHT_ALIGNMENT);
//        panel1.setAlignmentY(BOTTOM_ALIGNMENT);
//    	panel2.setAlignmentX(CENTER_ALIGNMENT);
//    	panel2.setAlignmentY(CENTER_ALIGNMENT);
//    	panel3.setAlignmentX(LEFT_ALIGNMENT);
//    	panel3.setAlignmentY(BOTTOM_ALIGNMENT);
//    	panel4.setAlignmentX(LEFT_ALIGNMENT);
//    	panel5.setAlignmentX(RIGHT_ALIGNMENT);
//    	panel6.setAlignmentX(LEFT_ALIGNMENT);
//    	panel7.setAlignmentX(RIGHT_ALIGNMENT);
//    	panel1.add(panel4);
//    	panel1a.add(panel1);
//    	panel1.add(panel5);
//    	panel3.add(panel6);
//    	panel3.add(panel7);
//    	panel.add(panel3);
//    	panel.add(panel2);
//    	panel.add(panel1);
//        
//        panel4.add(b1);
//        panel4.add(b2);
//        panel4.add(b3);
//        panel4.add(b4);
//        panel4.add(b5);
//        panel4.add(b6);
//        panel4.add(b7);
//        panel4.add(b8);
//        panel4.add(b9);
//        
//        panel5.add(b10);
//        panel5.add(b11);
//        panel5.add(b12);
//        panel5.add(b13);
//        panel5.add(b14);
//        
//        panel2.add(b15);
//        panel2.add(b16);
//        panel2.add(b17);
//    	
//        panel6.add(b18);
//        panel6.add(b19);
//        panel6.add(b20);
//        panel6.add(b21);
//        panel6.add(b22);
//        panel6.add(b23);
//        
//        panel7.add(b24);
//        panel7.add(b25);
//        panel7.add(b26);
//        panel7.add(b27);
//        panel7.add(b28);
//        panel7.add(b29);
//        
//        b1.addActionListener(wha2);
//        b2.addActionListener(wha2);
//        b3.addActionListener(wha2);
//        b4.addActionListener(wha2);
//        b5.addActionListener(wha2);
//        b6.addActionListener(wha2);
//        b7.addActionListener(wha2);
//        b8.addActionListener(wha2);
//        b9.addActionListener(wha2);
//        b10.addActionListener(wha2);
//        b11.addActionListener(wha2);
//        b12.addActionListener(wha2);
//        b13.addActionListener(wha2);
//        b14.addActionListener(wha2);
//        b15.addActionListener(wha2);
//        b16.addActionListener(wha2);
//        b17.addActionListener(wha2);
//        b18.addActionListener(wha2);   
//        b19.addActionListener(wha2);
//        b20.addActionListener(wha2);
//        b21.addActionListener(wha2);
//        b22.addActionListener(wha2);
//        b23.addActionListener(wha2);
//        b24.addActionListener(wha2);
//        b25.addActionListener(wha2);
//        b26.addActionListener(wha2);
//        b27.addActionListener(wha2);
//        b28.addActionListener(wha2);
//        b29.addActionListener(wha2);
//        
//    	frame.add(panel);
//    	frame.setVisible(true);
//    }
    
    
    
    
    public void ribbonLayout(final Container pane) {
        final JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(6, 6, 2, 2));
        //panel.setSize(50, 800);
        //panel.setLayout(new GridLayout(6, 6, 2, 2));
        experimentLayout.setAlignment(FlowLayout.TRAILING);
        
        b1 = new JButton("New File");    
    	b2 = new JButton("New doc");
        b3 = new JButton("New Image");
        b4 = new JButton("New Pdf");
        b5 = new JButton("Open Image");
        b6 = new JButton("Open recent image");
        b7 = new JButton("save");
        b8 = new JButton("save as pdf");
        b9 = new JButton("save as jpeg");
        b10 = new JButton("cut");
        b11 = new JButton("copy");
        b12 = new JButton("paste");
        b13 = new JButton("zoom+");
        b14 = new JButton("zoom-");
        b15 = new JButton("new label");
        b16 = new JButton("duplicate");
        b17 = new JButton("delete label");
        b18 = new JButton("set size");
        b19 = new JButton("adjust proportion");
        b20 = new JButton("set rgb");
        b21 = new JButton("choose palette");
        b22 = new JButton("invert colours");
        b23 = new JButton("BW");
        b24 = new JButton("help website");
        b25 = new JButton("help forum");
        b26 = new JButton("tutorial hotkeys");
        b27 = new JButton("tutorial tips");
        b28 = new JButton("about program");
        b29 = new JButton("about team");  
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panela = new JPanel();
        JPanel panelb = new JPanel();
        JPanel panelc = new JPanel();
        JPanel paneld = new JPanel();
        JPanel panele = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        
        
       
        
        //panel.add(panel2);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel5.setLayout(new BorderLayout());
        panel6.setLayout(new BorderLayout());
        panel7.setLayout(new BorderLayout());     
        panelc.setLayout(new BorderLayout());
        panel8.setLayout(new BorderLayout());
        panel9.setLayout(new BorderLayout());
        panel10.setLayout(new BorderLayout());
        panel11.setLayout(new BorderLayout());
        //panela.setLayout(new BorderLayout());
//        panel4.add(b26,BorderLayout.NORTH);
//        panel4.add(b25,BorderLayout.SOUTH);
//        panel4.add(b24,BorderLayout.NORTH);
        
        panel1.add(b1, BorderLayout.NORTH);
        panel1.add(b2, BorderLayout.EAST);
        panel1.add(b3, BorderLayout.SOUTH);
        panel2.add(b24, BorderLayout.NORTH);
        panel2.add(b25, BorderLayout.EAST);
        panel2.add(b26, BorderLayout.SOUTH);
        panel5.add(b27, BorderLayout.NORTH);
        panel5.add(b28, BorderLayout.EAST);
        panel5.add(b29, BorderLayout.SOUTH);  
        panel6.add(b18, BorderLayout.NORTH);
        panel6.add(b19, BorderLayout.EAST);
        panel6.add(b20, BorderLayout.SOUTH);
        panel7.add(b21, BorderLayout.NORTH);
        panel7.add(b22, BorderLayout.EAST);
        panel7.add(b23, BorderLayout.SOUTH);
        panelc.add(b15, BorderLayout.NORTH);
        panelc.add(b16, BorderLayout.EAST);
        panelc.add(b17, BorderLayout.SOUTH);
        panel8.add(b12, BorderLayout.NORTH);
        panel8.add(b13, BorderLayout.EAST);
        panel8.add(b14, BorderLayout.SOUTH);
        panel9.add(b10, BorderLayout.NORTH);
        panel9.add(b11, BorderLayout.SOUTH);
        panel10.add(b4, BorderLayout.NORTH);
        panel10.add(b5, BorderLayout.EAST);
        panel10.add(b6, BorderLayout.SOUTH);
        panel11.add(b7, BorderLayout.NORTH);
        panel11.add(b8, BorderLayout.EAST);
        panel11.add(b9, BorderLayout.SOUTH);
        
        pane.add(panel, BorderLayout.EAST);
        panel.add(panel3, BorderLayout.EAST);
        panel.add(panel4, BorderLayout.WEST);
        panelb.add(panel6, BorderLayout.NORTH);
        panelb.add(panel7, BorderLayout.SOUTH);
        panela.add(panel2, BorderLayout.NORTH);
        panela.add(panel5, BorderLayout.SOUTH);
        paneld.add(panel8, BorderLayout.NORTH);
        paneld.add(panel9, BorderLayout.SOUTH);
        panele.add(panel10, BorderLayout.NORTH);
        panele.add(panel11, BorderLayout.SOUTH);
        
        pane.add(panel1, BorderLayout.WEST);
        pane.add(panele, BorderLayout.WEST);
        pane.add(paneld, BorderLayout.WEST);
        pane.add(panelc, BorderLayout.WEST);      
        pane.add(panelb, BorderLayout.WEST);
        pane.add(panela, BorderLayout.WEST);
        
        
        
        b1.addActionListener(wha2);
        b2.addActionListener(wha2);
        b3.addActionListener(wha2);
        b4.addActionListener(wha2);
        b5.addActionListener(wha2);
        b6.addActionListener(wha2);
        b7.addActionListener(wha2);
        b8.addActionListener(wha2);
        b9.addActionListener(wha2);
        b10.addActionListener(wha2);
        b11.addActionListener(wha2);
        b12.addActionListener(wha2);
        b13.addActionListener(wha2);
        b14.addActionListener(wha2);
        b15.addActionListener(wha2);
        b16.addActionListener(wha2);
        b17.addActionListener(wha2);
        b18.addActionListener(wha2);   
        b19.addActionListener(wha2);
        b20.addActionListener(wha2);
        b21.addActionListener(wha2);
        b22.addActionListener(wha2);
        b23.addActionListener(wha2);
        b24.addActionListener(wha2);
        b25.addActionListener(wha2);
        b26.addActionListener(wha2);
        b27.addActionListener(wha2);
        b28.addActionListener(wha2);
        b29.addActionListener(wha2);
       
    }
    
    public static JPanel informationLayout(JPanel pane) {    
              
        JPanel panelarea = new JPanel();
        panelarea = pane;
        String text = "Program set to compare between traditional menu versus ribbon menu. The program will stablish a routine of activities for the user to perform using both menus. The parameters analysed will be the time taken and error count."; 
        JTextArea area = new JTextArea(text, 15,30);
        area.setPreferredSize(new Dimension(100, 100));
        JScrollPane scroll = new JScrollPane(area);        
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        panelarea.add(scroll);
        panelarea.setVisible(true);
		return panelarea;
        
    }

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
		// Set System L&F
		try {			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
		}
		
        //Create and set up the window.
        JFrame frame = new JFrame("JTabbed Pane Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight()); 
        frame.add(new JTabbedPaneDemo(), BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(xSize, ySize));
		frame.setMinimumSize(new Dimension(400, 400));	
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            	
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				startTime = System.currentTimeMillis();
				createAndShowGUI();
            }
        });
    }
}