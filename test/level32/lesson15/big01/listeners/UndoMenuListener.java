package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by gesse_000 on 23.01.2016.
 */
public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuIten;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuIten) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuIten = redoMenuIten;
    }

    @Override
    public void menuSelected(MenuEvent e) {

        undoMenuItem.setEnabled(view.canUndo());
        redoMenuIten.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }


}
