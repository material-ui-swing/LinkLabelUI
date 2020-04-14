package io.linklabelui;

import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class DemoLinkLabelMain extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JTabbedPane tabbedPane;

    protected void initView(){
        intComponents();
        initActions();

        setLocationRelativeTo(null);
        setSize(new Dimension(400, 500));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected void intComponents(){
        StandardSwingLinkLabel panelStandardLib = new StandardSwingLinkLabel();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Native Style", panelStandardLib);
        tabbedPane.setVisible(true);
        super.setContentPane(tabbedPane);
    }

    protected void initActions(){

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                DemoLinkLabelMain demo = new DemoLinkLabelMain();
                demo.initView();
            }
        });
    }
}
