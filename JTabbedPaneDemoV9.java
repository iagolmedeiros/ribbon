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
	public static long startTime1;
	public static long startTime2;
	public static long startTime3;
	public static long startTime4;
	public static long startTime5;
	public static long startTime6;
	public static long startTime7;
	public static long startTime8;
	public static long startTime9;
	public static long startTime10;
	public int order = 1;
	public int orderB = 1;
	public static int error = 0;
	public static int errorB = 0;
	public JButton buttonNewFile, buttonNewPDF, buttonNewImage, buttonNewDoc, buttonOpen, buttonOpenRecent, buttonSave,	buttonSavePDF, buttonSaveImage, editCut, editCopy, editPaste, editZoomPlus, editZoomMinus, buttonNewLabel, buttonDuplicate, buttonDeleteLabel, buttonCurves, buttonDistort, buttonContrast, buttonSetSize, buttonAdjustProportion, buttonSetRGB, buttonChoosePalette, buttonInvertColours, buttonBW, buttonHelpWebsite, buttonHelpForum, buttonHotkeys, buttonTips, buttonProgram, buttonTeam;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29;
	public static long totalTimes = 0;
	public static long totalTimes1 = 0;
	public static long totalTimes2 = 0;
	public static long totalTimes3 = 0;
	public static long totalTimes4 = 0;
	public static long totalTimes5 = 0;
	public static long totalTimes6 = 0;
	public static long totalTimes7 = 0;
	public static long totalTimes8 = 0;
	public static long totalTimes9 = 0;
	
	
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

	        panel.setLayout(new BorderLayout());	      

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
    				long endTime = System.currentTimeMillis();
    				totalTimes = endTime - startTime;		    		  
    				System.out.println(totalTimes);
    				startTime1 = System.currentTimeMillis();    				
    		    	JFrame frame = new JFrame();
    		    	JOptionPane.showMessageDialog(frame, "Now click on: edit > paste");
    		} else {
    	   		  error++;
    	   	  }	    		
    	} else if (click == editPaste) {
	      if (order == 2) {
	    	  		order = 3;	    	  			    	  		
    				long endTime = System.currentTimeMillis();
    				totalTimes1 = endTime - startTime1;		    		  
    				System.out.println(totalTimes1);
	    	  		startTime2 = System.currentTimeMillis();
	    	  		JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: insert > new labels > duplicate");
			} else {
				error++;
	   	    }	    		
    	} else if (click == buttonDuplicate) {
			if (order == 3) {
				    order = 4;				    
    				long endTime = System.currentTimeMillis();
    				totalTimes2 = endTime - startTime2;		    		  
    				System.out.println(totalTimes2);
	    	  		startTime3 = System.currentTimeMillis();
				    JFrame frame = new JFrame();
				    JOptionPane.showMessageDialog(frame, "Now click on: file > save as> save as jpeg");
		} else {
	   		  error++;
	   	  }	    		
	    } else if (click == buttonSaveImage) {
			if (order == 4) {
					order = 5;					
    				long endTime = System.currentTimeMillis();
    				totalTimes3 = endTime - startTime3;		    		  
    				System.out.println(totalTimes3);
	    	  		startTime4 = System.currentTimeMillis();
					JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: settings > colours > choose pallete");
		} else {
	   		  error++;
	   	  }	    		
	    } else if (click == buttonChoosePalette) {
			if (order == 5) {				
				long endTime = System.currentTimeMillis();
				totalTimes4 = endTime - startTime4;		    		  
				System.out.println(totalTimes4);
    	  		startTime5 = System.currentTimeMillis();
					System.out.println("erros: " + error);
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
       
    ActionListener wha2 = new ActionListener() {
    	public void actionPerformed (ActionEvent e) {
    		Object click = e.getSource();
    		if (click == b29) {
    			if (orderB == 1) {
    				orderB = 2;
    				long endTime = System.currentTimeMillis();
    				totalTimes5 = endTime - startTime5;		    		  
    				System.out.println(totalTimes5);
        	  		startTime6 = System.currentTimeMillis();
    		    	JFrame frame = new JFrame();
    		    	JOptionPane.showMessageDialog(frame, "Now click on: paste");
    		} else {
    	   		  errorB++;
    	   	  }	    		
    	} else if (click == b12) {
	      if (orderB == 2) {
	    	  		orderB = 3;
	    	  		long endTime = System.currentTimeMillis();
					totalTimes6 = endTime - startTime6;		    		  
					System.out.println(totalTimes6);
	    	  		startTime7 = System.currentTimeMillis();
	    	  		JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: duplicate");
			} else {
				errorB++;
	   	    }	    		
    	} else if (click == b16) {
			if (orderB == 3) {
				    orderB = 4;
				    long endTime = System.currentTimeMillis();
					totalTimes7 = endTime - startTime7;		    		  
					System.out.println(totalTimes7);
	    	  		startTime8 = System.currentTimeMillis();
				    JFrame frame = new JFrame();
				    JOptionPane.showMessageDialog(frame, "Now click on: save as jpeg");
		} else {
	   		  errorB++;
	   	  }	    		
	    } else if (click == b9) {
			if (orderB == 4) {
					orderB = 5;
					long endTime = System.currentTimeMillis();
					totalTimes8 = endTime - startTime8;		    		  
					System.out.println(totalTimes8);
	    	  		startTime9 = System.currentTimeMillis();
					JFrame frame = new JFrame();
	        	    JOptionPane.showMessageDialog(frame, "Now click on: choose pallete");
		} else {
	   		  errorB++;
	   	  }	    		
	    } else if (click == b21) {
			if (orderB == 5) {
				long endTime = System.currentTimeMillis();
				totalTimes9 = endTime - startTime9;		    		  
				System.out.println(totalTimes9);
    	  		startTime10 = System.currentTimeMillis();
					System.out.println("erros: " + errorB);
					 try {
							generateCsvFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
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
    
    private static void generateCsvFile () throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
	     // feed in your array (or convert your data to an array)
		String s1 = String.valueOf(error);
		String s2 = String.valueOf(errorB);
		String s3 = String.valueOf(totalTimes);
		String s4 = String.valueOf(totalTimes1);
		String s5 = String.valueOf(totalTimes2);
		String s6 = String.valueOf(totalTimes3);
		String s7 = String.valueOf(totalTimes4);
		String s8 = String.valueOf(totalTimes5);
		String s9 = String.valueOf(totalTimes6);
		String s10 = String.valueOf(totalTimes7);
		String s11 = String.valueOf(totalTimes8);
		String s12 = String.valueOf(totalTimes9);

		String[] entries = s1.split("#");
		String[] entries2 = s2.split("#");
		String[] entries3 = s3.split("#");
		String[] entries4 = s4.split("#");
		String[] entries5 = s5.split("#");
		String[] entries6 = s6.split("#");
		String[] entries7 = s7.split("#");
		String[] entries8 = s8.split("#");
		String[] entries9 = s9.split("#");
		String[] entries10 = s10.split("#");
		String[] entries11 = s11.split("#");
		String[] entries12 = s12.split("#");
		
		
	     writer.writeNext(entries);
	     writer.writeNext(entries2);
	     writer.writeNext(entries3);
	     writer.writeNext(entries4);
	     writer.writeNext(entries5);
	     writer.writeNext(entries6);
	     writer.writeNext(entries7);
	     writer.writeNext(entries8);
	     writer.writeNext(entries9);
	     writer.writeNext(entries10);
	     writer.writeNext(entries11);
	     writer.writeNext(entries12);
		writer.close();
	}
    
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
		frame.setPreferredSize(new Dimension(400, 400));
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