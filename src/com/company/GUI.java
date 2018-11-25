package com.company;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lib.checkStr;

public class GUI extends JFrame
{
    private JLabel chooseLb;
    private JCheckBox subCb;
    private JCheckBox prefCb;
    private JCheckBox sufCb;
    private JLabel firstLb;
    private JTextField firstTf;
    private JLabel secondLb;
    private JTextField secondTf;
    private JButton checkBt;

    private boolean subChk, prefChk, sufChk = false;

    public GUI() throws HeadlessException
    {
        super("Check string");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        GridBagLayout mainGrid = new GridBagLayout();
        GridBagConstraints mainGridConstr = new GridBagConstraints();
        mainGridConstr.weightx = 1.0;
        mainGridConstr.weighty = 0.0;
        mainGridConstr.insets = new Insets(5, 5, 5, 5);

        container.setLayout(mainGrid);

        chooseLb = new JLabel("What to check: ");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 0;
        mainGridConstr.gridwidth = 3;
        container.add(chooseLb, mainGridConstr);

        subCb = new JCheckBox("substring");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 1;
        mainGridConstr.gridwidth = 1;
        subCb.addActionListener(e -> subChk = subCb.isSelected());
        container.add(subCb, mainGridConstr);

        prefCb = new JCheckBox("prefix");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 1;
        mainGridConstr.gridy = 1;
        prefCb.addActionListener(e -> prefChk = prefCb.isSelected());
        container.add(prefCb, mainGridConstr);

        sufCb = new JCheckBox("suffix");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 2;
        mainGridConstr.gridy = 1;
        sufCb.addActionListener(e -> sufChk = sufCb.isSelected());
        container.add(sufCb, mainGridConstr);

        firstLb = new JLabel("Enter first string: ");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 2;
        mainGridConstr.gridwidth = 3;
        container.add(firstLb, mainGridConstr);

        firstTf = new JTextField();
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 3;
        container.add(firstTf, mainGridConstr);

        secondLb = new JLabel("Enter second string: ");
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 4;
        container.add(secondLb, mainGridConstr);

        secondTf = new JTextField();
        mainGridConstr.fill = GridBagConstraints.HORIZONTAL;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 5;
        container.add(secondTf, mainGridConstr);

        checkBt = new JButton("Check");
        mainGridConstr.fill = GridBagConstraints.SOUTH;
        mainGridConstr.gridx = 0;
        mainGridConstr.gridy = 6;
        mainGridConstr.anchor = GridBagConstraints.SOUTH;
        mainGridConstr.weighty = 1.0;
        checkBt.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                StringBuilder res = new StringBuilder();
                String s1 = firstTf.getText();
                String s2 = secondTf.getText();
                if (!(subChk || prefChk || sufChk))
                {
                    res.append("What do you want to see here???");
                } else
                {
                    if (subChk)
                        res.append("Substring: ").append(checkStr.is_Substring(s1, s2).toString()).append(System.lineSeparator());
                    if (prefChk)
                        res.append("Prefix: ").append(checkStr.is_Prefix(s1, s2).toString()).append(System.lineSeparator());
                    if (sufChk)
                        res.append("Suffix: ").append(checkStr.is_Suffix(s1, s2).toString()).append(System.lineSeparator());
                }
                JOptionPane.showMessageDialog(null, res);
            }
        });
        container.add(checkBt, mainGridConstr);

        this.setMinimumSize(new Dimension(300, 300));
        this.setBounds(500, 500, 1, 1);
    }
}
