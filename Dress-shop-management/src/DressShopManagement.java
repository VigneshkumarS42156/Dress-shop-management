package src;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List; 
 
public class DressShopManagement extends JFrame {
    static Map<String, List<Dress>> categoryDressMap = new HashMap<>();
    static List<Dress> cartList = new ArrayList<>();

    public static void main(String[] args) {
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14));
        SwingUtilities.invokeLater(() -> new HomeForm());
    }
}

// 🧵 Dress Data Model
class Dress {
    String name;
    double price;
    double gst;

    public Dress(String name, double price, double gst) {
        this.name = name;
        this.price = price;
        this.gst = gst;
    }

    public String toString() {
        return name + " - ₹" + price + " + GST " + gst + "%";
    }

    public double totalPrice() {
        return price + (price * gst / 100);
    }
}

// 🏠 Home Form
class HomeForm extends JFrame {
    HomeForm() {
        setTitle("👚 Dressify GST 🎀");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));
        getContentPane().setBackground(Color.PINK);

        JLabel welcome = new JLabel("👖 Welcome to Dress Shop! 👗 ", JLabel.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD, 20));
        add(welcome);

       // Setting a font that supports emojis
Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 16); // Adjust font size as needed

// Creating buttons with emojis
JButton selectBtn = new JButton("👚 Select Dresses");
selectBtn.setFont(emojiFont);

JButton addBtn = new JButton("👕 Add New Dress");
addBtn.setFont(emojiFont);

JButton cartBtn = new JButton("👜 View Cart");
cartBtn.setFont(emojiFont);

JButton billBtn = new JButton("💰 Generate Bill");
billBtn.setFont(emojiFont);


        add(selectBtn);
        add(addBtn);
        add(cartBtn);
        add(billBtn);

        populateInitialDresses();

        selectBtn.addActionListener(e -> {
            dispose();
            new CategorySelectionForm();
        });
        addBtn.addActionListener(e -> {
            dispose();
            new AddDressForm();
        });
        cartBtn.addActionListener(e -> {
            dispose();
            new CartForm();
        });
        billBtn.addActionListener(e -> {
            dispose();
            new BillForm();
        });

        setVisible(true);
    }

    void populateInitialDresses() {
        if (DressShopManagement.categoryDressMap.isEmpty()) {
            populateMaleDresses();
            populateFemaleDresses();
            populateKidsDresses();
        }
    }

    void populateMaleDresses() {
        List<Dress> maleDresses = new ArrayList<>();
        maleDresses.add(new Dress(" Men's T-Shirt", 499, 5));
        maleDresses.add(new Dress("Men's Jeans", 799, 12));
        maleDresses.add(new Dress(" Formal Shirt", 899, 18));
        maleDresses.add(new Dress("Casual Shorts", 699, 5));
        maleDresses.add(new Dress("Men's Blazer", 2499, 18));
        maleDresses.add(new Dress("Denim Jacket", 1299, 12));
        maleDresses.add(new Dress("Sweater", 799, 5));
        maleDresses.add(new Dress("Jogging Pants", 599, 5));
        maleDresses.add(new Dress("Track Suit", 1099, 12));
        maleDresses.add(new Dress("Men's Socks", 199, 5));
        maleDresses.add(new Dress("Sports Shoes", 1499, 18));
        maleDresses.add(new Dress("Men's Hoodie", 1399, 18));
        DressShopManagement.categoryDressMap.put("Male", maleDresses);
    }

    void populateFemaleDresses() {
        List<Dress> femaleDresses = new ArrayList<>();
        femaleDresses.add(new Dress("Women Gown", 1999, 18));
        femaleDresses.add(new Dress("Casual Dress", 899, 5));
        femaleDresses.add(new Dress("Cotton Kurti", 799, 5));
        femaleDresses.add(new Dress("Designer Saree", 1499, 12));
        femaleDresses.add(new Dress("Churidar", 999, 5));
        femaleDresses.add(new Dress("Floral Skirt", 799, 5));
        femaleDresses.add(new Dress("Women’s Blouse", 799, 5));
        femaleDresses.add(new Dress("Winter Coat", 2199, 12));
        femaleDresses.add(new Dress("Party Dress", 1799, 18));
        femaleDresses.add(new Dress("Evening Gown", 2799, 18));
        femaleDresses.add(new Dress("Lehenga Choli", 2499, 18));
        femaleDresses.add(new Dress("Sweater", 899, 5));
        DressShopManagement.categoryDressMap.put("Female", femaleDresses);
    }

    void populateKidsDresses() {
        List<Dress> kidsDresses = new ArrayList<>();
        kidsDresses.add(new Dress(" Boys T-Shirt", 299, 5));
        kidsDresses.add(new Dress("Girls Frock", 499, 5));
        kidsDresses.add(new Dress("Boys Shorts", 399, 5));
        kidsDresses.add(new Dress("Girls Skirt", 599, 5));
        kidsDresses.add(new Dress("Boys Jeans", 799, 5));
        kidsDresses.add(new Dress("Girls Party Dress", 799, 12));
        kidsDresses.add(new Dress("Kids Sweatshirt", 699, 12));
        kidsDresses.add(new Dress("Boys Hoodie", 799, 18));
        kidsDresses.add(new Dress("Girls Blouse", 899, 5));
        kidsDresses.add(new Dress("Boys Socks", 99, 5));
        kidsDresses.add(new Dress("Girls Headband", 199, 5));
        kidsDresses.add(new Dress("Boys Sneakers", 999, 12));
        DressShopManagement.categoryDressMap.put("Kids", kidsDresses);
    }
}

// 👚 Category Selection Form
class CategorySelectionForm extends JFrame {
    CategorySelectionForm() {
        setTitle("Select Category");
        setSize(400, 300);
        setLocationRelativeTo(null);
        JLabel welcome = new JLabel("👖 Categories 👗 ", JLabel.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD, 20));
        add(welcome);
        setLayout(new GridLayout(5, 1, 10, 10));
        getContentPane().setBackground(Color.PINK);

              // Set font that supports emojis
              Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 16);

        JButton maleBtn = new JButton(" 👕 Male");
        maleBtn.setFont(emojiFont);

        JButton femaleBtn = new JButton(" 👘 Female");
        femaleBtn.setFont(emojiFont);

        JButton kidsBtn = new JButton(" 👶 Kids");
        kidsBtn.setFont(emojiFont);

        JButton backBtn = new JButton("🔙 Back");
        backBtn.setFont(emojiFont);

        add(maleBtn);
        add(femaleBtn);
        add(kidsBtn);
        add(backBtn);

        maleBtn.addActionListener(e -> {
            dispose();
            new DressSelectionForm("Male");
        });

        femaleBtn.addActionListener(e -> {
            dispose();
            new DressSelectionForm("Female");
        });

        kidsBtn.addActionListener(e -> {
            dispose();
            new DressSelectionForm("Kids");
        });

        backBtn.addActionListener(e -> {
            dispose();
            new HomeForm();    
            });
        
        setVisible(true);
    }
}

// 👗 Dress Selection Form (based on category)
class DressSelectionForm extends JFrame {
    DressSelectionForm(String category) {
        setTitle("Select Dresses - " + category);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.PINK);

        // Get the list of dresses based on category
        List<Dress> dresses = DressShopManagement.categoryDressMap.get(category);
        JList<Dress> dressJList
         = new JList<>(dresses.toArray(new Dress[0]));
        dressJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scroll = new JScrollPane(dressJList);
        
        // Bottom panel with buttons
        JButton addToCartBtn = new JButton("Add to Cart");
        JButton backBtn = new JButton("Back");
        JPanel bottom = new JPanel();
        bottom.add(addToCartBtn);
        bottom.add(backBtn);
        
        // ===== NEW CODE FOR IMAGE (Proper Format) =====
        ImageIcon icon = null;
        if (category.equals("Male")) {
            icon = new ImageIcon("men.jpg");  // Male image path
        } else if (category.equals("Female")) {
            icon = new ImageIcon("women1.jpg"); // Female image path
        } else if (category.equals("Kids")) {
            icon = new ImageIcon("C:\\Users\\DELL\\Downloads\\java\\src\\kid2.jpg"); // Kids image path
        }
        
        JLabel imageLabel = new JLabel();
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH); // Resize image
            imageLabel.setIcon(new ImageIcon(img));
        }
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Center the image horizontally
        imageLabel.setVerticalAlignment(JLabel.CENTER);   // Center the image vertically
        
        // Wrap the image in a panel to control size and background if needed
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.setPreferredSize(new Dimension(240, 300)); // Fixed size for the image box
        // ===============================================
        
        // Now add components
        add(new JLabel("Choose Dresses to Add to Cart:", JLabel.CENTER), BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.EAST); // ⭐ Add image neatly at the right side
        
        // Action Listener for 'Add to Cart' Button
        addToCartBtn.addActionListener(e -> {
            List<Dress> selected = dressJList.getSelectedValuesList();
            DressShopManagement.cartList.addAll(selected);
            JOptionPane.showMessageDialog(this, "Added to cart!");
        });
        
        
        backBtn.addActionListener(e -> {
            dispose();
            new CategorySelectionForm();
        });

        setVisible(true);
    }
}
// 🛒 Cart View Form
class CartForm extends JFrame {
    CartForm() {
        setTitle("Cart");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JTextArea cartArea = new JTextArea();
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        cartArea.setEditable(false);

        StringBuilder sb = new StringBuilder("===== Cart Items =====\n");
        for (Dress d : DressShopManagement.cartList) {
            sb.append(d.toString()).append("\n");
        }
        sb.append("======================\n");

        cartArea.setText(sb.toString());

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            dispose();
            new HomeForm();
        });

        add(new JScrollPane(cartArea), BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
// 🧵 Add New Dress Form
class AddDressForm extends JFrame {
    AddDressForm() {
        setTitle("Add New Dress");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));
        getContentPane().setBackground(Color.pink);

        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Male", "Female", "Kids"});

        JLabel nameLabel = new JLabel("Dress Name:");
        JTextField nameField = new JTextField();

        JLabel priceLabel = new JLabel("Price (₹):");
        JTextField priceField = new JTextField();

        JLabel gstLabel = new JLabel("GST (%):");
        JTextField gstField = new JTextField();

        JButton addBtn = new JButton("Add Dress");
        JButton backBtn = new JButton("Back");

        add(categoryLabel); add(categoryCombo);
        add(nameLabel); add(nameField);
        add(priceLabel); add(priceField);
        add(gstLabel); add(gstField);
        add(addBtn); add(backBtn);

        addBtn.addActionListener(e -> {
            String category = (String) categoryCombo.getSelectedItem();
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            String gstText = gstField.getText().trim();

            if (name.isEmpty() || priceText.isEmpty() || gstText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                double gst = Double.parseDouble(gstText);
                Dress newDress = new Dress(name, price, gst);
                DressShopManagement.categoryDressMap.get(category).add(newDress);
                JOptionPane.showMessageDialog(this, "Dress added successfully!");
                nameField.setText("");
                priceField.setText("");
                gstField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            new HomeForm();
        });

        setVisible(true);
    }
}


// 🧾 Bill Form
class BillForm extends JFrame {
    BillForm() {
        setTitle("Final Bill");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea billArea = new JTextArea();
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        billArea.setEditable(false);

        double total = 0;
        StringBuilder sb = new StringBuilder("===== Final Bill =====\n");
        for (Dress d : DressShopManagement.cartList) {
            double tp = d.totalPrice();
            sb.append(d.name).append(" - ₹").append(tp).append("\n");
            total += tp;
        }

        sb.append("-----------------------\n");
        sb.append("Total Payable: ₹").append(String.format("%.2f", total)).append("\n");
        sb.append("=======================\n");

        billArea.setText(sb.toString());

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            dispose();
            new HomeForm();
        });

        add(new JScrollPane(billArea), BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
