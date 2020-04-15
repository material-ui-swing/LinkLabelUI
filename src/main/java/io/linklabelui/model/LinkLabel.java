package io.linklabelui.model;

import javax.swing.*;
import javax.swing.plaf.LabelUI;


/**
 * TODO the constructors of this class is only temporary also optimizing the class
 * @author https://github.com/vincenzopalazzo
 */
public class LinkLabel extends JLabel {

    private static final String uiClassID = "LinkLabelUI";

    protected String url;

    public LinkLabel(String text, String url) {
        super(text);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUI(LabelUI ui) {
        super.setUI(ui);
    }

    @Override
    public void updateUI() {
        if (UIManager.get(getUIClassID()) != null) {
            System.out.println("Not null");
            LabelUI ui = (LabelUI) UIManager.getUI(this);
            setUI(ui);
        } else {
            //TODO Optimizing
            LabelUI ui = (LabelUI) UIManager.getUI(new JLabel());
            setUI(ui);
        }
    }

    public LabelUI getUI() {
        return (LabelUI) ui;
    }

    @Override
    public String getUIClassID() {
        return uiClassID;
    }
}
