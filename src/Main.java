import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {
    private int Flag=3;
    Main() {
        super("Login");
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 14);
        setBackground(new Color(245, 247, 250));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Label title = new Label("Welcome back", Label.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 6, 0);
        add(title, gbc);
        // UserName Label
        Label userLabel = new Label("Username:", Label.LEFT);
        userLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(8, 0, 8, 12);
        add(userLabel, gbc);
        // UserName TextFiled
        TextField username = new TextField(18);
        username.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(8, 0, 8, 0);
        add(username, gbc);
        // pass Label
        Label passLabel = new Label("Password:", Label.LEFT);
        passLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(8, 0, 8, 12);
        add(passLabel, gbc);
        // pass TextFiled
        TextField pass = new TextField(18);
        pass.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 3;
        pass.setEchoChar('*');
        gbc.insets = new Insets(8, 0, 8, 0);
        add(pass, gbc);
        // Checkbox
        Label roleLabel = new Label("Role:", Label.LEFT);
        roleLabel.setFont(labelFont);
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        gbc.gridwidth = 1;
        gbc.insets = new Insets(8, 0, 8, 12);
        add(roleLabel, gbc);
        Panel radioPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 0)); 
        CheckboxGroup roleGroup = new CheckboxGroup();

        Checkbox studentRadio = new Checkbox("Student", roleGroup, true);
        studentRadio.setFont(inputFont);
        Checkbox professorRadio = new Checkbox("Professor", roleGroup, false);
        professorRadio.setFont(inputFont);
        radioPanel.add(studentRadio);
        radioPanel.add(professorRadio);
        gbc.gridx = 1; 
        gbc.gridy = 4;
        gbc.insets = new Insets(8, 0, 8, 0);
        add(radioPanel, gbc);
        // Note 
        Label statusLabel = new Label("* Note: you have "+Flag+" trials", Label.LEFT);
        gbc.gridx = 1; gbc.gridy = 6; 
        add(statusLabel, gbc);
        statusLabel.setForeground(Color.RED);
        // BTN Login
        Button loginButton = new Button("Login");
        loginButton.setFont(labelFont);
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 1;
        gbc.insets = new Insets(15, 0, 0, 0);
        add(loginButton, gbc);
        loginButton.addActionListener(e -> {
            String user = username.getText();
            String password = pass.getText();
            Checkbox selectedBox = roleGroup.getSelectedCheckbox();
            User loggedIn = AuthService.login(user, password,selectedBox.getLabel());
            
            if (loggedIn != null) {
                statusLabel.setForeground(new Color(34, 139, 34));
                statusLabel.setText("Success! ");
                new HomePage(loggedIn).setVisible(getFocusTraversalKeysEnabled());
            } else {
                Flag--;
                if (Flag > 0) {
                    statusLabel.setForeground(Color.RED);
                    String word = (Flag == 1) ? " trial" : " trials";
                    statusLabel.setText("* Note: you have " + Flag + word + " left");
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Account Locked! No trials left.");
                    loginButton.setEnabled(false); 
                    username.setEnabled(false);
                    pass.setEnabled(false);
                }
            }
        });



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setSize(420, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
