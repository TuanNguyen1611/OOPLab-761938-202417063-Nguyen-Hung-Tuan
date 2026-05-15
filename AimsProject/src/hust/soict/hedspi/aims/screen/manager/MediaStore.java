package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {

    private Media media;

    public MediaStore(Media media) {
        this.media = media;

        setPreferredSize(new Dimension(300, 200));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");

            playButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                        this,
                        "Playing: " + media.getTitle(),
                        "Play",
                        JOptionPane.INFORMATION_MESSAGE
                );

                ((Playable) media).play();
            });

            container.add(playButton);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(container);
        add(Box.createVerticalGlue());

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}