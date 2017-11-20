/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author calin
 */
import gui.modules.Axi4BaseGuiModule;
import gui.modules.Axi4StreamAdaptGuiModule;
import gui.modules.Axi4StreamAdaptGuiModuleIn;
import model.digitalmodules.Axi4StreamAdaptModule;
import model.digitalmodules.Axi4LiteModule;
import model.digitalmodules.UserLogicStubModule;
import model.digitalmodules.DigitalModule;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class App extends JFrame implements ActionListener {

    static ArrayList<Axi4BaseGuiModule> arr = new ArrayList();
    
    private JTextField xField;
    private JTextField yField;
    private JTextArea textArea;

    public App(String _title) {
        // calling the constructor for JFrame to set the title
        super(_title);

        // initializing the components (method is implemented below)
        addComponentsToPane(this);

        // calling pack() defined in superclass to resize the frame according to
        // contents
        pack();

        // displaying the frame
        setVisible(true);

        // select the default behaviour when closing the frame by clicking
        // the X button on the bar: the application will exit
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void addAxi4Lite(Container pane) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //draw arrow as image
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(label.getWidth(), 20);

        // add arrow
        label.setIcon(new ImageIcon(new javax.swing.ImageIcon(
                App.class.getResource("/resources/updownarrows.png")).getImage().
                getScaledInstance(-1, 30, Image.SCALE_DEFAULT)));
        panel.add(label, BorderLayout.PAGE_START);
        
        // draw text
        label = new JLabel("|   AXI4-Lite Adaptor Instance    |");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        //label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        // add vertical space
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new ImageIcon(new javax.swing.ImageIcon(
                App.class.getResource("/resources/updownarrows.png")).getImage().
                getScaledInstance(-1, 30, Image.SCALE_DEFAULT)));
        panel.add(label, BorderLayout.PAGE_END);
        
        pane.add(panel, BorderLayout.PAGE_START);     
        
        //TODO: get boxes where the user writes the data
        //arr.add(new Axi4LiteGuiModule());
    }
    
    public static void addUserLogicStub(Container container) {
        // create new panel for center piece
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label;
        
        label = new JLabel(" ");  
        panel.add(label, BorderLayout.NORTH);
        
        label = new JLabel("    User Logic Stub Instance    "); label.setHorizontalAlignment(JLabel.CENTER); 
        panel.add(label, BorderLayout.CENTER);
        
        label = new JLabel(" ");
        panel.add(label, BorderLayout.SOUTH);

        //add border
        final float dash1[] = {8.0f};
        final BasicStroke dashed = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        panel.setBorder(BorderFactory.createStrokeBorder(dashed));
        
        // add to container
        container.add(panel, BorderLayout.CENTER);
        
    }
        
    public static final int LEFT_SIDE = 0;
    public static final int RIGHT_SIDE = 1;
    
    public static void addAxisStreamSideAdaptors(Container container, int StartIndex, int NumOfAdaptors, int side) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int Index = StartIndex;
        do {
                JLabel label;
                label = (NumOfAdaptors == 0) ? label = new JLabel("NO AXI STREAM") : new JLabel("AXI_STREAM_INSTANCE_" + Index);
                label.setHorizontalAlignment(JLabel.CENTER);

                panel.add(label);
                
                JTextField textfieldDepthLog;
                textfieldDepthLog = new JTextField("DEPTH_LOG");
                textfieldDepthLog.setToolTipText("Explanation for DEPTH_LOG");
                panel.add(textfieldDepthLog);

                JTextField textfieldTdataSize = new JTextField("TDATA_SIZE");
                textfieldTdataSize.setToolTipText("Explanation for TDATA_SIZE");
                panel.add(textfieldTdataSize);

                JTextField textfieldTuserSize = new JTextField("TUSER_SIZE");
                textfieldTuserSize.setToolTipText("Explanation for TUSER_SIZE");
                panel.add(textfieldTuserSize);

                panel.add(new JLabel(" ")); // create vertical space between two consecutive Axi Streams

                //panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                //panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
                //panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
                panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                
                arr.add(new Axi4StreamAdaptGuiModuleIn(Index, textfieldDepthLog, textfieldTdataSize, textfieldTuserSize));
                Index++;
            }
        while (Index < StartIndex + NumOfAdaptors);
        
        container.add(panel, (side == LEFT_SIDE) ? BorderLayout.LINE_START : BorderLayout.LINE_END);  
    }
    
    public static void addAxiStreamAdaptors(Container container, int NumOfAdaptors) {
        
        int LeftAdaptors = NumOfAdaptors / 2;
        int RightAdaptors = NumOfAdaptors - LeftAdaptors;
        addAxisStreamSideAdaptors(container, 0, LeftAdaptors, LEFT_SIDE);
        addAxisStreamSideAdaptors(container, LeftAdaptors, RightAdaptors, RIGHT_SIDE);
    }
        
    public static void addComponentsToPane(Container mainpanel) {
        
        
            JPanel InputPanel = new JPanel();
            InputPanel.setLayout(new BoxLayout(InputPanel, BoxLayout.Y_AXIS));
            InputPanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
            
            JButton button = new JButton("UpdateGui");
            InputPanel.add(button);
        
            JCheckBox hasAxi4LiteCheckBox = new JCheckBox("Has Axi4 Lite");
            InputPanel.add(hasAxi4LiteCheckBox);

            final JTextField numOfAxiStreamInputs = new JTextField("Number of axi stream inputs");
            
            InputPanel.add(numOfAxiStreamInputs);

            JTextField numOfAxiStreamOutputs = new JTextField("Number of axi stream outputs");
            InputPanel.add(numOfAxiStreamOutputs);
            
            mainpanel.add(InputPanel, BorderLayout.WEST);
            
            // add drawing
            JPanel OutputPanel = new JPanel();
            OutputPanel.setLayout(new BorderLayout());
            OutputPanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);

            addAxi4Lite(OutputPanel);
            addUserLogicStub(OutputPanel);
            addAxiStreamAdaptors(OutputPanel, 10);

            mainpanel.add(OutputPanel, BorderLayout.EAST);
         
        // adding the listener to the button Component
        //button.addActionListener(this);
    }

// this is the handler defined in the ActionListener interface
    public void actionPerformed(ActionEvent _actionEvent) {
        xField.setText(String.valueOf(this.getWidth()));
        yField.setText(String.valueOf(this.getHeight()));
        textArea.append("x");
    }
}
