import models.Empresa;

import javax.swing.*;
import Frames.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgramaSeguridad programa = new ProgramaSeguridad();
            programa.setVisible(true);
        });
    }
}