package view.componentsView;

import controller.ProcessIMG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    private JToolBar toolbar;
    private ActionListener actionListener;
    public ToolBar(ActionListener actionListener){
        this.toolbar = new JToolBar();
        this.actionListener = actionListener;
    }
    public JToolBar init(){
        this.toolbar.setLayout(new BoxLayout(this.toolbar,BoxLayout.Y_AXIS));
        this.toolbar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.toolbar.setFloatable(false);
        this.toolbar.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        this.toolbar.add(this.home());
        this.toolbar.add(this.create());
        this.toolbar.add(this.edit());
        this.toolbar.add(this.refresh());
        this.toolbar.addSeparator();
        this.toolbar.add(this.logout());
        return this.toolbar;
    }
    private JButton home(){
        JButton home = new JButton(new ImageIcon("src/public/image/toolbar/Home-icon.png"));
        home.setActionCommand("home");
        home.addActionListener(this.actionListener);
        return home;
    }
    private JButton create(){
        JButton create = new JButton(new ImageIcon("src/public/image/toolbar/New-file-icon.png"));
        create.setActionCommand("new");
        create.addActionListener(this.actionListener);
        return create;
    }
    private JButton edit (){
        JButton edit = new JButton(new ImageIcon("src/public/image/toolbar/Actions-document-edit-icon.png"));
        edit.setActionCommand("edit");
        edit.addActionListener(this.actionListener);
        return edit;
    }
    private JButton refresh(){
        JButton refresh = new JButton(new ImageIcon("src/public/image/toolbar/Actions-view-refresh-icon.png"));
        refresh.setActionCommand("refresh");
        refresh.addActionListener(this.actionListener);
        return refresh;
    }
    private JButton logout(){
        JButton logout = new JButton(new ImageIcon("src/public/image/toolbar/Log-Out-icon.png"));
        logout.setActionCommand("logout");
        logout.addActionListener(this.actionListener);
        return logout;
    }
}
