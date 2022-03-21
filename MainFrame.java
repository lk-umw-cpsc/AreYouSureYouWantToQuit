import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements WindowListener {

    private static final int PADDING = 16;

    public MainFrame() {
        super("Close me");
        // Nothing happens by default when 'close' is clicked; this is important
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Box layerContainer = Box.createVerticalBox();

        Box paddedHorizontalBox = Box.createHorizontalBox();
        paddedHorizontalBox.add(Box.createHorizontalStrut(PADDING));
        paddedHorizontalBox.add(layerContainer);
        paddedHorizontalBox.add(Box.createHorizontalStrut(PADDING));

        layerContainer.add(Box.createVerticalStrut(PADDING));
        Box layer;

        layer = Box.createHorizontalBox();
            layer.add(new JLabel("I'm left-aligned"));
            layer.add(Box.createHorizontalGlue());
        layerContainer.add(layer);

        layerContainer.add(Box.createVerticalStrut(PADDING));

        layer = Box.createHorizontalBox();
            layer.add(Box.createHorizontalGlue());
            layer.add(new JLabel("I'm center-aligned"));
            layer.add(Box.createHorizontalGlue());
        layerContainer.add(layer);

        layerContainer.add(Box.createVerticalStrut(PADDING));

        layer = Box.createHorizontalBox();
            layer.add(Box.createHorizontalGlue());
            layer.add(new JLabel("I'm right-aligned"));
        layerContainer.add(layer);

        layerContainer.add(Box.createVerticalStrut(PADDING));

        layer = Box.createHorizontalBox();
            layer.add(new JLabel("We're at..."));
            layer.add(Box.createHorizontalGlue());
            layer.add(new JLabel("...opposite ends!"));
        layerContainer.add(layer);

        layerContainer.add(Box.createVerticalStrut(PADDING));

        layerContainer.add(new JLabel("Try resizing and closing this window!"));
        layerContainer.add(Box.createVerticalStrut(PADDING));

        add(paddedHorizontalBox);

        pack();

        // Don't allow the user to make the window smaller than the required size
        setMinimumSize(getSize());

        // Start listening for window events (X pressed, etc.)
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    /**
     * Method called when the user presses the window's X button.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to quit?", "Closing",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // This is where you would save application data before closing
            // The user chose yes, get rid of the GUI 'gracefully'
            dispose();
            // Terminate the process
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}
