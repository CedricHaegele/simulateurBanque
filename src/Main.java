import gui.MainWindow;
import models.Banque;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();
        banque.chargerDonnees();
        
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow(banque);
            mainWindow.setVisible(true);
            
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                banque.sauvegarderDonnees();
            }));
        });
    }
} 