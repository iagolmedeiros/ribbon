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

public class JTabbedPaneDemo extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long startTime;
	public JTabbedPaneDemo() {
        super(new GridLayout(1,1));  
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = traditional("Traditional menu test");
        tabbedPane.addTab("Traditional", null, panel1, "Alpha test");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_T);        
     
        add(tabbedPane);
        
//        JComponent panel2 = ribbon("Ribbon menu test");
//        tabbedPane.addTab("Ribbon", null, panel2, "");
//        tabbedPane.setMnemonicAt(1, KeyEvent.VK_R);
//        
//        add(tabbedPane);
        
        JComponent panel2 = information("Show information for the user");
        tabbedPane.addTab("Information", null, panel2, "Prompt the user about the test.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_I);
        add(tabbedPane);
        
        JComponent panel3 = makeTextPanel("Display results of my analysis");
        tabbedPane.addTab("Display Results", null, panel3, "results");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_D);
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
	        //traditionalLayout(panel);
	        panel.setLayout(new BorderLayout());
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
			JButton buttonNewFile = new JButton("New file");
			JButton buttonNewPDF = new JButton ("New PDF");
			JButton buttonNewImage = new JButton ("New Image");
			JButton buttonNewDoc = new JButton ("New Doc");
			
			//Buttons of FILE > Open
			JButton buttonOpen = new JButton("Open Image");
			JButton buttonOpenRecent = new JButton("Open Recent Images");
			
			//Buttons of FILE > SaveAs
			
			JButton buttonSave = new JButton ("Save");
			JButton buttonSavePDF = new JButton("Save as pdf");
			JButton buttonSaveImage = new JButton("Save as JPEG");
			
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
			JButton editCut = new JButton ("Cut");
			JButton editCopy = new JButton ("Copy");
			JButton editPaste = new JButton ("Paste");
			JButton editZoomPlus = new JButton ("Zoom +");
			JButton editZoomMinus = new JButton ("Zoom -");

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
			
			// Sub-menus of File Insert	
			JMenu insertNewLabel = new JMenu ("Insert New Label");
			JMenu insertAdjusts = new JMenu ("Insert Adjusts");			
			
			//Buttons of Insert > Label
			JButton buttonNewLabel = new JButton("New Label");
			JButton buttonDuplicate = new JButton("Duplicate");
			JButton buttonDeleteLabel = new JButton("Delete label");
			
			//Buttons of Insert > Adjusts
			JButton buttonCurves = new JButton("Curves");
			JButton buttonDistort = new JButton("Distort");
			JButton buttonContrast = new JButton("Contrast");
			
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
			JMenu menuSettings = new JMenu( "Settings" );
			menuBar.add(menuSettings);
			
			JMenu menuHelp = new JMenu( "Help" );
			menuBar.add(menuHelp);
			
			return panel;
    }
    
//    protected JComponent ribbon (String textInTop) {
//    	JPanel panel = new JPanel(false);    	
//	        ribbonLayout(panel);
//	        setLayout(new BorderLayout());	 
//	        panel.setVisible(true);
//	        return panel;
//    }
    
    protected JComponent information (String textInTop) {
    	JPanel frame = new JPanel();
        informationLayout(frame);
        frame.setVisible(true);
		return frame;
    }
    
    ActionListener actionListener = new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		      		
    		  long endTime = System.currentTimeMillis();
    		  long totalTime = endTime - startTime;
    		  String s = String.valueOf(totalTime);
    		  int epa = Integer.valueOf(s);
    		  System.out.println(totalTime);
//    		  generateCsvFile(s);
    		      		  
    		  try {
    			  OutputStream out = new FileOutputStream("src/output2.csv");
				  out.write(epa);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
    		  
    		  
    	  }
    	};
    
//    	private static void generateCsvFile (String vin) {
//    		try {
//  			  FileWriter out = new FileWriter("output4.csv");
//  			  out.append(vin);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//    	}
    
    //FlowLayout experimentLayout = new FlowLayout();
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
       
    
    public void ribbonLayout(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(3, 2, 2, 2));
        experimentLayout.setAlignment(FlowLayout.TRAILING);
//        compsToExperiment.setLayout(new BorderLayout());
//        experimentLayout.setAlignment(FlowLayout.TRAILING);
        JButton b1 = new JButton("File");
        JButton b2 = new JButton("Insert");
        JButton b3 = new JButton("Edit");
        JButton b4 = new JButton("Other");
        JButton b5 = new JButton("Help");
        compsToExperiment.add(b1, BorderLayout.EAST);
        compsToExperiment.add(b2, BorderLayout.WEST);
        compsToExperiment.add(b3, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        compsToExperiment.add(panel2);
        panel2.setLayout(new BorderLayout());
        panel2.add(b4, BorderLayout.EAST);
        panel2.add(b5, BorderLayout.SOUTH);
//        compsToExperiment.add(b4, BorderLayout.EAST);
//        compsToExperiment.add(b5, BorderLayout.EAST);       
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(panel2, BorderLayout.SOUTH);
          
        b1.addActionListener(actionListener);
        b2.addActionListener(actionListener);
        b3.addActionListener(actionListener);
        b4.addActionListener(actionListener);
        b5.addActionListener(actionListener);
       
    }
    
    	// Add the action listener to your buttons.
    
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