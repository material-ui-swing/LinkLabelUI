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

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import org.material.component.linklabelui.model.LinkLabel;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class LinkLabelSwingLinkLabel extends JPanel {

    protected LinkLabel linkToVincentGithub;
    protected LinkLabel linkToMaterialTheme;
    protected LinkLabel linkToMaterialToast;
    protected LinkLabel linkToDonation;

    protected MouseListener followingLink;

    public LinkLabelSwingLinkLabel() {
        intView();
    }

    protected void intView() {
        initComponent();
        initAction();

        setVisible(true);
    }

    private void initComponent() {
        linkToVincentGithub = new LinkLabel("Author library @vincenzopalazzo", "https://github.com/vincenzopalazzo", MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHEVRON_RIGHT
        ));
        linkToMaterialTheme = new LinkLabel("Go to material-ui-swing project", "https://github.com/vincenzopalazzo/material-ui-swing", MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHEVRON_RIGHT
        ));
        linkToMaterialToast = new LinkLabel("Go to toast project", "https://github.com/vincenzopalazzo/toasts-for-swing", MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHEVRON_RIGHT
        ));
        linkToDonation = new LinkLabel("Support this project", "https://github.com/sponsors/vincenzopalazzo", MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHEVRON_RIGHT
        ));

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
        linkToMaterialToast.addMouseListener(followingLink);
        linkToDonation.addMouseListener(followingLink);
    }

    private class ActionFollowingLink implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JComponent component = (JComponent) e.getSource();
                if (component instanceof LinkLabel) {
                    LinkLabel link = (LinkLabel) component;
                    Desktop.getDesktop().browse(new URI(link.getUrl()));
                }
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }

}
