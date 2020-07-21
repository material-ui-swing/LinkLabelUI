/**
 * MIT License
 *
 * Copyright (c) 2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.material.component.linklabelui;

import org.material.component.linklabelui.view.LinkLabelUI;
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
