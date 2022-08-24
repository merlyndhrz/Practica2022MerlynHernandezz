package sistema.administrativo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {

    Usuario UsuSistema[] = new Usuario[10];
    JPanel panelInicioSesion;
    JPanel panelControl;
    JPanel panelCrearUsuario;
    int control = 2;
    Cliente Clientes[] = new Cliente[100];
    int controlCliente = 0;
    JPanel panelcontrolClientes;
    int controlClientes = 2; 

    public Ventana() {
        objetos();
        crearAdmin();
        crearClientes();
    }

    public void crearAdmin() {
        UsuSistema[0] = new Usuario();
        UsuSistema[0].NombreUsuario = "Admin";
        UsuSistema[0].Nombre = "Administrador";
        UsuSistema[0].Contra = "123456";

        UsuSistema[1] = new Usuario();
        UsuSistema[1].NombreUsuario = "Juan20";
        UsuSistema[1].Nombre = "Juan Perez";
        UsuSistema[1].Contra = "Jperez20";
    }

    public void crearClientes() {
        Clientes[0] = new Cliente();
        Clientes[0].Nombre = "cliente 1";
        Clientes[0].Edad = 22;
        Clientes[0].Genero = 'M';
        Clientes[0].NIT = 150;

        Clientes[1] = new Cliente();
        Clientes[1].Nombre = "cliente 2";
        Clientes[1].Edad = 30;
        Clientes[1].Genero = 'F';
        Clientes[1].NIT = 300;
    }

    public void objetos() {
        panelInicioSesion = new JPanel(); 
        this.getContentPane().add(panelInicioSesion);
        panelInicioSesion.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(20, 7, 100, 15);
        panelInicioSesion.add(lblLogin);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(60, 40, 100, 15);
        panelInicioSesion.add(lblUsuario);

        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(60, 100, 100, 15);
        panelInicioSesion.add(lblContra);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 40, 200, 25);
        panelInicioSesion.add(txtUsuario);

        JTextField txtContra = new JTextField();
        txtContra.setBounds(150, 100, 200, 25);
        panelInicioSesion.add(txtContra);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 145, 180, 32);
        panelInicioSesion.add(btnIngresar);
        ActionListener ingresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUsuario.getText().equals("") || txtContra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

                } else {
                    RecorrerUsuarios(txtUsuario.getText(), txtContra.getText());

                }

            }

        };
        btnIngresar.addActionListener(ingresar);

        JButton btnCrearUsuario = new JButton("Registrarse");
        btnCrearUsuario.setBounds(120, 200, 180, 35);
        panelInicioSesion.add(btnCrearUsuario);
        ActionListener crearUsuario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CrearUsuario();
                panelCrearUsuario.setVisible(true);
            }
        };
        btnCrearUsuario.addActionListener(crearUsuario);
    }

    public void RecorrerUsuarios(String NombreUsuario, String Contra) {
        boolean encontrado = false;
        for (int i = 0; i < 10; i++) {
            if (UsuSistema[i] != null) {
                if (UsuSistema[i].NombreUsuario.equals(NombreUsuario) && UsuSistema[i].Contra.equals(Contra)) {
                    JOptionPane.showMessageDialog(null, "Bienvenidos al sistema usuario " + NombreUsuario);
                    panelControl();
                    encontrado = true;
                    break;
                } else {
                    encontrado = false;
                }
            }

        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }

    public void panelControl() {
        panelControl = new JPanel(); 
        this.getContentPane().add(panelControl);
        panelControl.setLayout(null);
        this.setSize(600, 500);
        this.setTitle("Control principal");
        panelInicioSesion.setVisible(false);

        JButton btnAdminClientes = new JButton("Administración de clientes");
        btnAdminClientes.setBounds(150, 10, 250, 25);
        panelControl.add(btnAdminClientes);
        ActionListener administrarClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelControlCli();
                panelcontrolClientes.setVisible(true);
            }
        };
        btnAdminClientes.addActionListener(administrarClientes);

        JButton btnAdminProductos = new JButton("Administración de productos");
        btnAdminProductos.setBounds(150, 80, 250, 25);
        panelControl.add(btnAdminProductos);

        JButton btnAdminReportes = new JButton("Reportes");
        btnAdminReportes.setBounds(150, 150, 250, 25);
        panelControl.add(btnAdminReportes);
    }

    public void CrearUsuario() {
        panelCrearUsuario = new JPanel(); 
        this.getContentPane().add(panelCrearUsuario);
        panelCrearUsuario.setLayout(null);
        this.setSize(500, 450);
        this.setTitle("Registro de nuevo usuario");
        panelInicioSesion.setVisible(false);

        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setBounds(20, 10, 150, 20);
        panelCrearUsuario.add(lblRegistro);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(50, 50, 150, 20);
        panelCrearUsuario.add(lblUsuario);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50, 100, 150, 20);
        panelCrearUsuario.add(lblNombre);

        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(50, 150, 150, 20);
        panelCrearUsuario.add(lblContra);

        JLabel lblConfirmar = new JLabel("Confirmar contraseña");
        lblConfirmar.setBounds(50, 200, 150, 20);
        panelCrearUsuario.add(lblConfirmar);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(200, 50, 150, 20);
        panelCrearUsuario.add(txtUsuario);

        JTextField txtNombreUsuario = new JTextField();
        txtNombreUsuario.setBounds(200, 100, 150, 20);
        panelCrearUsuario.add(txtNombreUsuario);

        JTextField txtContra = new JTextField();
        txtContra.setBounds(200, 150, 150, 20);
        panelCrearUsuario.add(txtContra);

        JTextField txtConfContra = new JTextField();
        txtConfContra.setBounds(200, 200, 150, 20);
        panelCrearUsuario.add(txtConfContra);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 280, 200, 35);
        panelCrearUsuario.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtUsuario.getText().equals("") || txtNombreUsuario.getText().equals("") || txtContra.getText().equals("") || txtConfContra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                } else {
                    if (txtContra.getText().equals(txtConfContra.getText())) {
                        guardarUsuario(txtUsuario.getText(), txtNombreUsuario.getText(), txtContra.getText());
                        txtUsuario.setText("");
                        txtNombreUsuario.setText("");
                        txtContra.setText("");
                        txtConfContra.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas NO coinciden");
                    }
                }
            }
        };
        btnRegistrar.addActionListener(registro);

        JButton btnVolver = new JButton("Volver al inicio");
        btnVolver.setBounds(130, 350, 200, 35);
        panelCrearUsuario.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelInicioSesion.setVisible(true);
                panelCrearUsuario.setVisible(false);
                VolverInicio();
            }

        };
        btnVolver.addActionListener(volverInicio);
    }

    public void VolverInicio() {
        this.setTitle("Sistema administrativo de clientes y recursos ");
        this.setSize(450, 350);
    }

    public void guardarUsuario(String Nombre, String NombreUsuario, String Contra) {
        int posicion = 0;
        if (control < 10) {
            for (int i = 0; i < 9; i++) {
                if (UsuSistema[i] == null) {
                    posicion = i;
                    break;
                }
            }
            //System.out.println("La posicion libre es " + posicion);
            UsuSistema[posicion] = new Usuario();
            UsuSistema[posicion].NombreUsuario = Nombre;
            UsuSistema[posicion].Nombre = NombreUsuario;
            UsuSistema[posicion].Contra = Contra;
            control++;
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total de usuarios " + control);
        } else {
            JOptionPane.showMessageDialog(null, "No puede registar mas datos...");
        }
    }

    public void panelControlCli() {
        panelcontrolClientes = new JPanel(); 
        this.getContentPane().add(panelcontrolClientes);
        panelcontrolClientes.setLayout(null);
        this.setSize(750, 500);
        this.setTitle("Administracion de clientes");
        panelControl.setVisible(false);

        DefaultTableModel datosTabla = new DefaultTableModel();
        datosTabla.addColumn("Nombre");
        datosTabla.addColumn("Edad");
        datosTabla.addColumn("Genero");
        datosTabla.addColumn("NIT");

        for (int i = 0; i < 100; i++) {
            if (Clientes[i] != null) {
                String fila[] = {Clientes[i].Nombre, String.valueOf(Clientes[i].Edad), String.valueOf(Clientes[i].Genero), String.valueOf(Clientes[i].NIT)};
                datosTabla.addRow(fila);
            }
        }

        JTable tablaClientes = new JTable(datosTabla);
        JScrollPane barraTablaClientes = new JScrollPane(tablaClientes);
        barraTablaClientes.setBounds(10, 10, 300, 100);
        panelcontrolClientes.add(barraTablaClientes);

        JButton btnCargarArchivo = new JButton("Buscar archivo CSV");
        btnCargarArchivo.setBounds(350, 10, 200, 25);
        panelcontrolClientes.add(btnCargarArchivo);
        ActionListener buscarArchivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                File archivoSeleccionado;
                JFileChooser ventanaSeleccion = new JFileChooser();
                ventanaSeleccion.showOpenDialog(null);
                archivoSeleccionado = ventanaSeleccion.getSelectedFile();
                System.out.println("La ubicacion del archivo es " + archivoSeleccionado.getPath());
                leerArchivoCSV(archivoSeleccionado.getPath());
                panelcontrolClientes.setVisible(false);
                panelControlCli();

            }
        };
        btnCargarArchivo.addActionListener(buscarArchivo);
    }

    public void leerArchivoCSV(String ruta) {
        try {
            BufferedReader archivoTemporal = new BufferedReader(new FileReader(ruta));
            String lineaLeida = "";
            while (lineaLeida != null) {
                lineaLeida = archivoTemporal.readLine();
                if (lineaLeida != null) {
                    String datoSeparados[] = lineaLeida.split(",");
 
                    int posicion = 0;
                    if (controlClientes < 100) {
                        for (int i = 0; i < 99; i++) {
                            if (Clientes[i] == null) {
                                posicion = i;
                                break;
                            }
                        }                   
                        Clientes[posicion] = new Cliente();
                        Clientes[posicion].Nombre = datoSeparados[0];
                        Clientes[posicion].Edad = Integer.parseInt(datoSeparados[1]);
                        Clientes[posicion].Genero = datoSeparados[2].charAt(0);
                        Clientes[posicion].NIT = Integer.parseInt(datoSeparados[3]);
                        controlClientes++;                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No puede registar mas clientes");
                    }

                }
            }
            JOptionPane.showMessageDialog(null, "Clientes registrados exitosamente, total de clientes " + controlClientes);
            archivoTemporal.close();
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "No puedo abrir el archivo CSV");
        }
    }
}
