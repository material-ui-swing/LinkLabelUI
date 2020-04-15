package io.linklabelui;

import io.linklabelui.view.LinkLabelUI;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class DemoLinkLabelMain extends JFrame {

    static {
        try {
            UIManager.getDefaults().put("LinkLabelUI", LinkLabelUI.class.getCanonicalName());
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("LinkLabel.mouseHoverColor", MaterialColors.DARKLY_GREEN);
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
        LinkLabelSwingLinkLabel linkLabelSwingLinkLabel = new LinkLabelSwingLinkLabel();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Native Style", panelStandardLib);
        tabbedPane.addTab("Custom Style", linkLabelSwingLinkLabel);
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
