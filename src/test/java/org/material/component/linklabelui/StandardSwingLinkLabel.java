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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class StandardSwingLinkLabel extends JPanel {

    protected JLabel linkToVincentGithub;
    protected JLabel linkToMaterialTheme;
    protected JLabel linkToMaterialToast;
    protected JLabel linkToDonation;

    protected MouseListener followingLink;

    public StandardSwingLinkLabel() {
        intView();
    }

    protected void intView() {
        initComponent();
        initAction();

        setVisible(true);
    }

    private void initComponent() {
        String starHtml = "<html><a href=''>";
        String endHtml = "</a></html>";
        //linkToVincentGithub = new JLabel(starHtml + "Author library @vincenzopalazzo" + endHtml);
        linkToMaterialTheme = new JLabel(starHtml + "Go to material-ui-swing project" + endHtml);
        linkToMaterialToast = new JLabel(starHtml + "Go to toast project" + endHtml);
        linkToDonation = new JLabel(starHtml + "Support this project" + endHtml);

        linkToVincentGithub = new JLabel("Test");
        linkToVincentGithub.setUI(new LinkLabelUI());

        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.add(Box.createRigidArea(new Dimension(5, 15)));
        super.add(linkToVincentGithub);
        super.add(Box.createRigidArea(new Dimension(5, 15)));

        super.add(linkToMaterialTheme);
        super.add(Box.createRigidArea(new Dimension(5, 15)));

        super.add(linkToMaterialToast);
        super.add(Box.createRigidArea(new Dimension(5, 15)));

        super.add(linkToDonation);
        super.add(Box.createRigidArea(new Dimension(5, 15)));
    }

    private void initAction() {
        followingLink = new ActionFollowingLink();
        linkToVincentGithub.addMouseListener(followingLink);
        linkToMaterialTheme.addMouseListener(followingLink);
        //TOD other
    }

    private class ActionFollowingLink implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            try {
                String link;
                if(label.equals(linkToVincentGithub)){
                    link = "https://github.com/vincenzopalazzo";
                }else if(label.equals(linkToMaterialTheme)){
                    link = "https://github.com/vincenzopalazzo/material-ui-swing";
                }else if(label.equals(linkToMaterialToast)){
                    link = "https://github.com/vincenzopalazzo/toasts-for-swing";
                }else{
                    link = "https://github.com/sponsors/vincenzopalazzo";
                }

                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

}
