package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by gesse_000 on 23.01.2016.
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane jEditorPane = getEditor(e);
        if (jEditorPane != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(jEditorPane).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(mutableAttributeSet, !StyleConstants.isSubscript(simpleAttributeSet));
            setCharacterAttributes(jEditorPane, simpleAttributeSet, false);
        }
    }
}
