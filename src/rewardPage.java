import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class rewardPage {
    public JPanel rewardPanel;
    private JButton coffeeButton;
    private JButton gymMembershipButton;
    private JButton a10BookDiscountAtButton;
    private JButton donateToCharityButton;
    private JPanel backPanel;
    private JButton backButton;

    final private mainFrame owner;
    private String user;

    public rewardPage(mainFrame owner, String user) {
        super();
        this.user = user;
        this.owner = owner;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new mainScreen(owner,user).panel1));
            }
        });
        donateToCharityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (pointSystem.pointSystem(user, -1)) {
                        SwingUtilities.invokeLater(() -> owner.showView(new qrRewardPage(owner,user).panel1));
                    } else {
                        JOptionPane.showMessageDialog(rewardPanel, "You dont have enough points for this item", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        a10BookDiscountAtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (pointSystem.pointSystem(user, -10)) {
                        SwingUtilities.invokeLater(() -> owner.showView(new qrRewardPage(owner,user).panel1));
                    } else {
                        JOptionPane.showMessageDialog(rewardPanel, "You dont have enough points for this item", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        gymMembershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (pointSystem.pointSystem(user, -20)) {
                        SwingUtilities.invokeLater(() -> owner.showView(new qrRewardPage(owner,user).panel1));
                    } else {
                        JOptionPane.showMessageDialog(rewardPanel, "You dont have enough points for Gym!", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        coffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (pointSystem.pointSystem(user, -5)) {
                        SwingUtilities.invokeLater(() -> owner.showView(new qrRewardPage(owner,user).panel1));
                    } else {
                        JOptionPane.showMessageDialog(rewardPanel, "You dont have enough points for Coffee!", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rewardPanel = new JPanel();
        rewardPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        rewardPanel.setBackground(new Color(-7171951));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-7171951));
        rewardPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 550), null, 0, false));
        donateToCharityButton = new JButton();
        donateToCharityButton.setBackground(new Color(-1));
        donateToCharityButton.setText("Donate to charity 1 point");
        panel1.add(donateToCharityButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        a10BookDiscountAtButton = new JButton();
        a10BookDiscountAtButton.setBackground(new Color(-1));
        a10BookDiscountAtButton.setForeground(new Color(-13487566));
        a10BookDiscountAtButton.setText("10% book discount at library 10 points");
        panel1.add(a10BookDiscountAtButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        gymMembershipButton = new JButton();
        gymMembershipButton.setBackground(new Color(-1));
        gymMembershipButton.setText("Gym membership 20 points");
        panel1.add(gymMembershipButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        coffeeButton = new JButton();
        coffeeButton.setBackground(new Color(-1));
        coffeeButton.setText("Coffee 5 points");
        panel1.add(coffeeButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        backPanel = new JPanel();
        backPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        backPanel.setBackground(new Color(-7171951));
        rewardPanel.add(backPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-9474193));
        backButton.setText("Back");
        backPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rewardPanel;
    }
}
