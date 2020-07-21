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
package org.material.component.linklabelui.model;

import org.material.component.linklabelui.view.LinkLabelUI;

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

    public LinkLabel(String text, String url, Icon icon) {
        super(text);
        this.url = url;
        if(icon != null){
            setIcon(icon);
            setHorizontalTextPosition(SwingConstants.LEFT);
        }
    }

    public LinkLabel(String url, Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        this.url = url;
    }

    public LinkLabel(String url, Icon image) {
        super(image);
        this.url = url;
    }

    public LinkLabel(String url) {
        super(url);
        this.url = url;
    }

    public LinkLabel(String text, String url, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        this.url = url;
    }

    public LinkLabel(String text,  String url, int horizontalAlignment) {
        super(text, horizontalAlignment);
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
            LabelUI ui = (LabelUI) UIManager.getUI(this);
            setUI(ui);
        } else {
            LabelUI ui = new LinkLabelUI();
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
