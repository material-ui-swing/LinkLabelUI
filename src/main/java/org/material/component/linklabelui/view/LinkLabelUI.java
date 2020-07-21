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
package org.material.component.linklabelui.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class LinkLabelUI extends BasicLabelUI {

    private static final String PREFIX_UI = "LinkLabel.";

    protected static final Color COSMO_STRONG_BLUE = new ColorUIResource(25, 103, 190);
    protected static final Color COSMO_BLUE = new ColorUIResource(39, 128, 227);

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new LinkLabelUI();
    }

    protected JLabel label;
    protected Color background;
    protected Color foreground;
    protected Color mouseHoverColor;
    protected Boolean mouseHoverEnable;
    protected boolean mouseIsHover = false;
    private int additionalSpaceToIcon = 0;
    protected MouseListener mouseHoverEvent;
    //TODO add all listener to change the color when the method setForeground and setBackground will call on component


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }

    @Override
    protected void installDefaults(JLabel c) {
        super.installDefaults(c);
        label = c;

        //font
        this.background = this.hasPersonalConf("background", UIManager.getColor("Label.background"));
        label.setBackground(background);
        this.foreground = this.hasPersonalConf("foreground", UIManager.getColor("Label.foreground"));
        label.setForeground(foreground);
        this.mouseHoverEnable = this.hasPersonalConf("mouseHover", true);
        this.mouseHoverColor = this.hasPersonalConf("mouseHoverColor", COSMO_BLUE);
        label.setBorder(this.hasPersonalConf("border", UIManager.getBorder("Label.border")));
        label.setFont(this.hasPersonalConf("font", UIManager.getFont("Label.font")));
        this.additionalSpaceToIcon = UIManager.getInt(PREFIX_UI + "additionalSpaceIcon"); //This return 0 if the value isn't present
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        final Border border = c.getBorder();

        int realLeft = 0;

        if (border != null) {
            final Insets insets = border.getBorderInsets(c);
            realLeft += insets.left;
        }
        JLabel label = (JLabel) c;
        int realWidth = label.getFontMetrics(label.getFont()).stringWidth(label.getText());
        Graphics2D graphics2D = (Graphics2D) g.create();
        if(mouseIsHover){
            graphics2D.setColor(mouseHoverColor);
            graphics2D.drawLine(realLeft, c.getHeight() - 2, realWidth, c.getHeight() - 2);
        }else {
            graphics2D.setColor(foreground);
        }
        graphics2D.dispose();
    }

    @Override
    protected void installListeners(JLabel c) {
        super.installListeners(c);
        mouseHoverEvent = new LinkLabelEvent();
        c.addMouseListener(mouseHoverEvent);
    }

    @Override
    protected void uninstallListeners(JLabel c) {
        super.uninstallListeners(c);
        if(mouseHoverEvent != null){
            c.removeMouseListener(mouseHoverEvent);
        }
    }

    protected Color hasPersonalConf(String uiPropriety, Color defaultValue){
        String completeProperty = PREFIX_UI + uiPropriety;
        Color color = UIManager.getColor(completeProperty);
        if(color != null){
            return color;
        }
        return defaultValue;
    }

    protected Font hasPersonalConf(String uiPropriety, Font defaultValue){
        String completeProperty = PREFIX_UI + uiPropriety;
        Font font = UIManager.getFont(completeProperty);
        if(font != null){
            return font;
        }
        return defaultValue;
    }

    protected Border hasPersonalConf(String uiPropriety, Border defaultValue){
        String completeProperty = PREFIX_UI + uiPropriety;
        Border border = UIManager.getBorder(completeProperty);
        if(border != null){
            return border;
        }
        return defaultValue;
    }

    protected boolean hasPersonalConf(String uiPropriety, boolean defaultValue){
        String completeProperty = PREFIX_UI + uiPropriety;
        Boolean booleanValue = UIManager.getBoolean(completeProperty);
        if(booleanValue != null){
            return booleanValue;
        }
        return defaultValue;
    }

    public class LinkLabelEvent implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //do nothing
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //do nothing
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //do nothing
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.isOver(e, true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            this.isOver(e, false);
        }

        private void isOver(MouseEvent e, boolean isOver){
            JLabel label = (JLabel) e.getSource();
            if(label != null){
                mouseIsHover = isOver;
                if(mouseIsHover){
                    label.setForeground(mouseHoverColor);
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }else {
                    label.setForeground(foreground);
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
                if(foreground.equals(mouseHoverColor)){
                    label.repaint();
                }
            }
        }
    }
}
