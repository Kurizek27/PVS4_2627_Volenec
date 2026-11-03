package gui.avatars;

import javax.swing.*;
import java.awt.*;

public class CardMenu extends JFrame {
    JLabel fullName, salary, shoeSize;
    ImageIcon avatar;
    JPanel lowerMenu;
    JButton next, previous, first, last;

    static int current = 0;

    CardMenu(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        lowerMenu = new JPanel();
        lowerMenu.setLayout(new FlowLayout());


        fullName = new JLabel();
        salary = new JLabel();
        shoeSize = new JLabel();

        fullName.setFont(new Font("MV Boli", Font.BOLD, 18));
        salary.setFont(new Font("MV Boli", Font.BOLD, 18));
        shoeSize.setFont(new Font("MV Boli", Font.BOLD, 18));

        showAvatar(0);

        fullName.setIcon(avatar);
        fullName.setHorizontalTextPosition(JLabel.CENTER);
        fullName.setVerticalTextPosition(JLabel.TOP);
        fullName.setIconTextGap(5);
        fullName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(fullName, BorderLayout.CENTER);

        first = new JButton("First");
        previous = new JButton("Previous");
        next = new JButton("Next");
        last = new JButton("Last");

        first.addActionListener(e -> showFirst());
        previous.addActionListener(e -> showPrevious());
        next.addActionListener(e -> showNext());
        last.addActionListener(e -> showLast());

        lowerMenu.add(first);
        lowerMenu.add(previous);
        lowerMenu.add(shoeSize);
        lowerMenu.add(salary);
        lowerMenu.add(next);
        lowerMenu.add(last);

        this.add(lowerMenu, BorderLayout.SOUTH);
        this.pack();
    }

    private void showFirst(){
        current = 0;
        System.out.println(current);
        showAvatar(0);
    }

    private void showLast(){
        current = MainMenu.personData.size()-1;
        System.out.println(current);
        showAvatar(current);
    }

    private void showPrevious() {
        current--;
        if(current < 0){
            current = MainMenu.personData.size()-1;
        }
        System.out.println(current);
        showAvatar(current);
    }

    private void showNext() {
        current++;
        if(current >= MainMenu.personData.size()){
            current = 0;
        }
        System.out.println(current);
        showAvatar(current);
    }

    private void showAvatar(int index){
        avatar = new ImageIcon(MainMenu.personData.get(index).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
        fullName.setText("Full name: " + MainMenu.personData.get(index).name + " " + MainMenu.personData.get(index).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(index).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(index).salary);

        fullName.setIcon(avatar);
    }

}
