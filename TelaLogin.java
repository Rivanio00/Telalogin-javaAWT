import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends WindowAdapter{
    Frame f;
    TelaLogin() {
        f = new Frame();
        Label luser = new Label("Usuário:", Label.RIGHT);
        Label lpasswd = new Label("Senha:", Label.RIGHT);
        Button blogin = new Button("Login");
        Button bcancelar = new Button("Cancelar");
        TextField tuser = new TextField(15);
        TextField tpasswd = new TextField(15);
        tpasswd.setEchoChar('*');

        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(luser, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        f.add(tuser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        f.add(lpasswd, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        f.add(tpasswd, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        f.add(blogin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        f.add(bcancelar, gbc);
        

        
        f.setTitle("Tela de Login");
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.addWindowListener(this);

    // Adicionando o ActionListener ao botão de login
    blogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = tuser.getText();
            String password = tpasswd.getText();

            // Verifica se os campos estão preenchidos
            if (!username.isEmpty() && !password.isEmpty()) {
                // Exibe a mensagem de sucesso
                showMessageDialog("Login feito com sucesso!", true);
            } else {
                showMessageDialog("Por favor, preencha todos os campos.", false);
            }
        }
        });

    // Adicionando o ActionListener ao botão cancelar para fechar a janela
        bcancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Fecha a janela principal
            }
        });
    }

    public void showMessageDialog(String message, boolean closeOnOk) {
        Dialog d = new Dialog(f, "Mensagem");
        d.setLayout(new FlowLayout());
        Label lbl = new Label(message);
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                d.dispose();
                if (closeOnOk) {
                    f.dispose(); // Fecha a janela principal se o login for bem-sucedido
                }
            }
        });
        d.add(lbl);
        d.add(ok);
        d.setSize(250, 100);
        d.setLocationRelativeTo(f);
        d.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }
}