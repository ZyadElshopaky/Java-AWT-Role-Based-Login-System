import java.awt.*;
import java.awt.event.*;
public class HomePage extends Frame{
    HomePage(User user){
        super("Info");
        setLayout(new GridBagLayout());
        // Font
        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        // Layout
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        // Title
        Label l=new Label("INFO");
        l.setFont(new Font("SansSerif", Font.BOLD, 20));
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(l,gc);
        // Label User
        Label l1=new Label("Name : "+user.getUsername());
        l1.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        add(l1,gc);

        Label l2=new Label("Role : "+user.getRole());
        l2.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        add(l2,gc);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setSize(420, 200);
        setLocationRelativeTo(null);
    }
    
}
