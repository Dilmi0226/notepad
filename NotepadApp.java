import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp {
    public static void main(String[] args) {
        JFrame f = new JFrame("Notepad");
        JTextArea area = new JTextArea();
        f.add(new JScrollPane(area));
        JMenuBar mb = new JMenuBar();

        // File menu
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(open);
        file.add(save);
        file.add(exit);

        // Edit menu
        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        // Help menu
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        help.add(about);

        mb.add(file); mb.add(edit); mb.add(help);
        f.setJMenuBar(mb);

        JFileChooser chooser = new JFileChooser();


        open.addActionListener(e -> {
            try {
                if (chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION)
                    area.read(new FileReader(chooser.getSelectedFile()), null);
            } catch (Exception ex) { ex.printStackTrace(); }
        });
        save.addActionListener(e -> {
            try {
                if (chooser.showSaveDialog(f) == JFileChooser.APPROVE_OPTION)
                    area.write(new FileWriter(chooser.getSelectedFile()));
            } catch (Exception ex) { ex.printStackTrace(); }
        });
        exit.addActionListener(e -> System.exit(0));
        cut.addActionListener(e -> area.cut());
        copy.addActionListener(e -> area.copy());
        paste.addActionListener(e -> area.paste());
        about.addActionListener(e -> JOptionPane.showMessageDialog(f,"Notepad App\nBy: Dilmi (s16813)"));

        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}