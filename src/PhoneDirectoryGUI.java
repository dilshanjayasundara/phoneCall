import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneDirectoryGUI extends JFrame {
    private PhoneDirectory phoneDirectory;
    private JTextField searchField;
    private JButton searchButton;

    public PhoneDirectoryGUI() {
        phoneDirectory = new PhoneDirectory();
        setTitle("Phone Directory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(15);
        searchButton = new JButton("Search Contact");
        searchButton.addActionListener(new SearchButtonListener());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchTerm = searchField.getText();
            Contact contact = phoneDirectory.searchContact(searchTerm);
            if (contact != null) {
                JOptionPane.showMessageDialog(PhoneDirectoryGUI.this, "Contact found: " + contact.getName() + " - " + contact.getPhoneNumber());
            } else {
                JOptionPane.showMessageDialog(PhoneDirectoryGUI.this, "Contact not found.");
            }
        }
    }
}
