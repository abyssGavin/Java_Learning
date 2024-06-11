package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JDialogGameDegree extends JDialog {

    static JDialogGameDegree gameDegree;
    JPanel root;
    JButton DegreeBeginner;
    JButton DegreeIntermediate;
    JButton DegreeExpert;
    JButton DegreeCustom;
    JCheckBox CustomChoose;
    JTextField TextWide;
    JTextField TextHeight;
    JTextField TextMineNum;
    JLabel LabelWide;
    JLabel LabelHeight;
    JLabel LabelMineNum;
    JCheckBox MineOptimization;

    static void setGameDegree(Component parent){
        gameDegree = new JDialogGameDegree(parent);
    }

    private JDialogGameDegree(Component parent){
        super((Window) parent, "难度选择", ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 600));
        setLocationRelativeTo(parent);
        root = new JPanel();
        setContentPane(root);
        root.setLayout(new LayoutGameDegree());


        DegreeBeginner = setDegree("入门");
        DegreeIntermediate = setDegree("中级");
        DegreeExpert = setDegree("高级");



        CustomChoose = new JCheckBox("自定义难度");
        CustomChoose.setPreferredSize(new Dimension(200, 100));
        root.add(CustomChoose);
        CustomChoose.setFont(GameUtil.font);


        LabelHeight = setLabel("行数(9-20):");
        LabelWide = setLabel("列数(9-45):");
        LabelMineNum = setLabel(("雷数(1-255):"));

        TextHeight = setTextField();
        TextWide = setTextField();
        TextMineNum = setTextField();

        DegreeCustom = setDegree("自定义");
        DegreeCustom.setEnabled(false);

        MineOptimization = new JCheckBox("雷区布局优化");
        MineOptimization.setPreferredSize(new Dimension(300, 100));
        root.add(MineOptimization);
        MineOptimization.setFont(GameUtil.font);

        DegreeBeginner.addActionListener(e -> {
            GameFrame.Game.dispose();
            GameFrame.Game.initializeGame();
            GameFrame.widthSquareNum = 9;
            GameFrame.heightSquareNum = 9;
            GameFrame.mineNum = 10;
            GameFrame.Game.launch();
        });

        DegreeIntermediate.addActionListener(e -> {
            GameFrame.Game.dispose();
            GameFrame.Game.initializeGame();
            GameFrame.widthSquareNum = 16;
            GameFrame.heightSquareNum = 16;
            GameFrame.mineNum = 40;
            GameFrame.Game.launch();

        });

        DegreeExpert.addActionListener(e -> {
            GameFrame.Game.dispose();
            GameFrame.Game.initializeGame();
            GameFrame.widthSquareNum = 30;
            GameFrame.heightSquareNum = 16;
            GameFrame.mineNum = 99;
            GameFrame.Game.launch();

        });


        CustomChoose.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                DegreeBeginner.setEnabled(false);
                DegreeIntermediate.setEnabled(false);
                DegreeExpert.setEnabled(false);
                TextWide.setEditable(true);
                TextHeight.setEditable(true);
                TextMineNum.setEditable(true);
                DegreeCustom.setEnabled(true);
            }
            else{
                DegreeBeginner.setEnabled(true);
                DegreeIntermediate.setEnabled(true);
                DegreeExpert.setEnabled(true);
                TextWide.setEditable(false);
                TextHeight.setEditable(false);
                TextMineNum.setEditable(false);
                DegreeCustom.setEnabled(false);

            }
        });




        DegreeCustom.addActionListener(e -> {
            if(validateInputs()) {
                int width = Integer.parseInt(TextWide.getText());
                int height = Integer.parseInt(TextHeight.getText());
                int mineNum = Integer.parseInt(TextMineNum.getText());

                GameFrame.Game.dispose();


                GameFrame.Game.initializeGame();
                GameFrame.widthSquareNum = width;
                GameFrame.heightSquareNum = height;
                GameFrame.mineNum = mineNum;

                GameFrame.Game.launch();
            }
        });

        MineOptimization.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                GameUtil.MineOptimization = true;
            } else {
                GameUtil.MineOptimization = false;
            }
        });










        setVisible(true);


    }


    JButton setDegree(String degreeName){
        JButton button = new JButton(degreeName);
        button.setPreferredSize(new Dimension(200, 100));
        root.add(button);
        button.setFont(GameUtil.fontButton);
        return button;
    }

    JLabel setLabel(String string) {
        JLabel jLabel = new JLabel(string);
        jLabel.setFont(GameUtil.font);
        root.add(jLabel);
        return jLabel;
    }

    JTextField setTextField(){
        JTextField jTextField = new JTextField();
        jTextField.setColumns(3);
        jTextField.setSize(new Dimension(200, 100));
        jTextField.setFont(GameUtil.font);
        jTextField.setEditable(false);
        root.add(jTextField);
        return jTextField;
    }

    private boolean validateInputs() {

        try {
            int width = Integer.parseInt(TextWide.getText());
            int height = Integer.parseInt(TextHeight.getText());
            int mineNum = Integer.parseInt(TextMineNum.getText());

            if (width <= 45 && height >= 9 && height <= 20 && mineNum >= 1 && mineNum <= 255 && width >= height && width * 4 <= height * 9 && mineNum <= width * height * 7 / 10) {
                return true;
            } else {
                Toolkit.getDefaultToolkit().beep(); // 发出提示音
                JOptionPane.showMessageDialog(this, "输入有误，请输入合适的数值。", "输入错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "请输入数字。", "输入错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
