package mineSweeper;

import javax.swing.*;
import java.awt.*;

import java.awt.Desktop;
import java.net.URI;

public class JDialogOption extends JDialog {
    static JDialogOption jDialogOption;
    JButton jButtonNewGame;
    JButton Exit;
    JButton GameDescription;
    JButton AboutUs;

    JPanel root;

    static void setJDialogOption(Component component) {
        jDialogOption = new JDialogOption(component);

    }

    private JDialogOption(Component parent) {

        super((Window) parent, "游戏菜单", ModalityType.APPLICATION_MODAL);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        root = new JPanel();
        root.setLayout(new LayoutDialogOption());
        setContentPane(root);


        jButtonNewGame = setButton("新游戏", 200, 100);
        Exit = setButton("退出游戏", 200, 100);
        GameDescription = setButton("游戏说明", 200, 100);
        AboutUs = setButton("关于我们", 200, 100);

        setSize(400, 700);
        setLocationRelativeTo(parent);



        jButtonNewGame.addActionListener(e -> JDialogGameDegree.setGameDegree(JDialogOption.this));

        Exit.addActionListener(e -> ((Window) parent).dispose());

        GameDescription.addActionListener(e -> showGameDescription());

        AboutUs.addActionListener(e -> {
            String url = "https://github.com/abyssGavin";

            try {
                // 检查Desktop是否支持打开URI
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    // 打开URL
                    Desktop.getDesktop().browse(new URI(url));
                } else {
                    System.out.println("无法打开浏览器。");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("发生错误: " + e1.getMessage());
            }
        });






        setVisible(true);



    }

    void showGameDescription() {
        JTextArea textArea = new JTextArea(20, 80);
        textArea.setFont(GameUtil.font);
        textArea.setText(Text.text);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog descriptionDialog = new JDialog(this, "游戏说明", true);
        descriptionDialog.add(scrollPane);
        descriptionDialog.pack();
        descriptionDialog.setLocationRelativeTo(this);

        // 使用SwingUtilities.invokeLater来确保滚动条位置的调整在组件显示后执行
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPane.getViewport().setViewPosition(new Point(0, 0));
            }// 将滚动条位置设置到顶部
        });
        descriptionDialog.setVisible(true);
    }

    JButton setButton(String degreeName, int width, int height){
        JButton button = new JButton(degreeName);
        button.setPreferredSize(new Dimension(width, height));
        root.add(button);
        button.setFont(GameUtil.fontButton);
        return button;
    }

    private class Text{
        static String text = "                                   扫雷游戏指引\n" +
                "                                   按\"T\"键提示\n" +
                "欢迎游戏者！本指引旨在帮助您了解经典游戏扫雷的基本规则和一些实用策略，让您能够快速上手并享受这个富有策略和运气结合的游戏。\n" +
                "\n" +
                "游戏目标\n" +
                "扫雷的主要目标是清除雷场上所有不含地雷的方块，同时避免触雷。游戏胜利条件是标记出所有地雷的位置，而不必实际打开这些雷区方块。\n" +
                "\n" +
                "基本规则\n" +
                "雷场布局：游戏开始时，您面对的是一个格子状的雷场，每个格子可能隐藏地雷。\n" +
                "操作方式：您可以点击格子来“打开”它，如果打开的是一个空白格子（即没有地雷），会显示出相邻格子中雷的数量。如果您打开的格子里有雷，那么游戏立即结束。\n" +
                "数字的意义：各个格子显示的数字表示它周围8个格子内有多少个雷。\n" +
                "标记地雷：如果您认为某个格子下有雷，可以右击该格子来放置旗帜作为标记。\n" +
                "游戏策略\n" +
                "初步探索：游戏开始时随机点击几个格子。通常，我建议从四角或边缘开始，因为这有助于迅速打开较大的区域。\n" +
                "\n" +
                "数字解读：每个数字都是关键信息，它告诉您该格子周围8个格子中有多少地雷。\n" +
                "\n" +
                "安全点击：当你确定某个数字周围已经标记了正确数量的雷时，左右双击该数字就可以快速打开周围未标记的格子。\n" +
                "\n" +
                "慎用标记：只在确定无疑的情况下标记地雷。误标会导致之后的推断错误。\n" +
                "\n" +
                "角格利用：如果一个角上的数字是1，那它只能影响到3个格子，这意味着那3个格子中有1个是雷，这是个很好的开始。\n" +
                "\n" +
                "边界利用：边界上的2通常意味着它旁边的两个格子都是雷，这个规则在辨识地雷位置时很有用。\n" +
                "\n" +
                "隐含线索：有时，不同的数字组合可以提供导致唯一解的线索，请注意周围数字的变化，尤其是当它们形成相连的模式时。\n" +
                "\n" +
                "高级技巧：当您更熟悉游戏后，可以尝试更高级的推断技巧，比如利用相邻的已解开区域来推断剩下的地雷位置。\n" +
                "\n" +
                "实用提示\n" +
                "慢慢开始，并且确保您充分理解每个数字如何影响周围的格子。\n" +
                "不要怕犯错误。扫雷是一款试错过程中学习的游戏。\n" +
                "极少数情况下，您可能会遇到需要猜测的情况。这时候，经验和直觉会有帮助。\n" +
                "结语\n" +
                "扫雷是一种简单却又能提供无穷乐趣的游戏，它不仅可以锻炼您的逻辑思维，还能让您享受解谜的快感。每次游戏都是新的挑战，每次成功避开地雷，都将带来极大的满足感。\n" +
                "\n" +
                "所以，准备好了吗？开始您的扫雷之旅，让我们清理雷场，安全归来！祝您游戏愉快！";
    }

}

