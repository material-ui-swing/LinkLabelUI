package io.linklabelui.view;

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
    protected MouseListener mouseHoverEvent;
    //TODO add all listener to change the color when the method setForeground and setBackground will call on component

    @Override
    protected void installDefaults(JLabel c) {
        super.installDefaults(c);
        label = c;

        this.background = this.hasPersonalConf("background", UIManager.getColor("Label.background"));
        this.foreground = this.hasPersonalConf("foreground", UIManager.getColor("Label.foreground"));
        this.mouseHoverEnable = this.hasPersonalConf("mouseHover", true);
        this.mouseHoverColor = this.hasPersonalConf("mouseHoverColor", COSMO_BLUE);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        final Border border = c.getBorder();

        int realLeft = 0;
        int realWidth = c.getWidth();

        if (border != null) {
            final Insets insets = border.getBorderInsets(c);

            realWidth -= insets.right;
            realWidth -= insets.left;
            realLeft += insets.left;
        }
        if(mouseIsHover){
            g.setColor(mouseHoverColor);
            g.drawLine(realLeft, c.getHeight() - 2, realWidth, c.getHeight() - 2);
        }else {
            g.setColor(foreground);
        }
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
        System.out.println(completeProperty);
        Color color = UIManager.getColor(completeProperty);
        if(color != null){
            return color;
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
                //label.repaint();
            }
        }
    }
}
