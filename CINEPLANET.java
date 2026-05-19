    import java.util.Scanner;

    public class CINEPLANET {

        static Scanner sc = new Scanner(System.in);

        // VARIABLES GLOBALES
        static String correoRegistrado = "";
        static String passwordRegistrada = "";

        public static void main(String[] args) {

            int opcion;

            do {
                System.out.println("========= CINEPLANET =========");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar Sesión");
                System.out.println("3. Modo Invitado");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        registrarse();
                        break;

                    case 2:
                        iniciarSesion();
                        break;

                    case 3:
                        menuPrincipal();
                        break;

                    case 4:
                        System.out.println("Gracias por visitar CINEPLANET 🎬");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } while (opcion != 4);
        }

        // ================= REGISTRO =================

        public static void registrarse() {

            System.out.println("========= REGISTRO =========");

            System.out.print("Ingrese correo: ");
            correoRegistrado = sc.nextLine();

            System.out.print("Ingrese contraseña: ");
            passwordRegistrada = sc.nextLine();

            boolean correoValido = correoRegistrado.contains("@")
                    && correoRegistrado.endsWith(".com");

            boolean passwordValida = passwordRegistrada.length() >= 8;

            if (correoValido && passwordValida) {

                System.out.println("Registro exitoso ✅");

            } else {

                System.out.println("Error en el registro ❌");

                if (!correoValido) {
                    System.out.println("El correo debe contener @ y terminar en .com");
                }

                if (!passwordValida) {
                    System.out.println("La contraseña debe tener mínimo 8 caracteres");
                }

                correoRegistrado = "";
                passwordRegistrada = "";
            }
        }

        // ================= LOGIN =================

        public static void iniciarSesion() {

            System.out.println("========= INICIAR SESIÓN =========");

            System.out.print("Ingrese correo: ");
            String correo = sc.nextLine();

            System.out.print("Ingrese contraseña: ");
            String password = sc.nextLine();

            if (correo.equals(correoRegistrado)
                    && password.equals(passwordRegistrada)) {

                System.out.println("Inicio de sesión exitoso ✅");
                menuPrincipal();

            } else {

                System.out.println("Datos incorrectos ❌");
            }
        }

        // ================= MENÚ PRINCIPAL =================

        public static void menuPrincipal() {

            int opcion;

            do {

                System.out.println("\n========= MENÚ PRINCIPAL =========");
                System.out.println("1. Películas");
                System.out.println("2. Cines");
                System.out.println("3. Promociones");
                System.out.println("4. Socio Cineplanet");
                System.out.println("5. Dulcería");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {

                    case 1:
                        peliculas();
                        break;

                    case 2:
                        cines();
                        break;

                    case 3:
                        promociones();
                        break;

                    case 4:
                        socio();
                        break;

                    case 5:
                        dulceria();
                        break;

                    case 6:
                        System.out.println("Regresando...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } while (opcion != 6);
        }

        // ================= PELÍCULAS =================

        public static void peliculas() {

            int opcion;
            String pelicula = "";
            double precio = 0;

            System.out.println("======== PELÍCULAS =========");
            System.out.println("1. Billie Eilish - S/25");
            System.out.println("2. Top Gun Maverick - S/28");
            System.out.println("3. Volcán Fuego Bajo Tierra - S/26");
            System.out.println("4. Coyotes - S/24");
            System.out.print("Seleccione película: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    pelicula = "Billie Eilish";
                    precio = 25;
                    break;

                case 2:
                    pelicula = "Top Gun Maverick";
                    precio = 28;
                    break;

                case 3:
                    pelicula = "Volcán Fuego Bajo Tierra";
                    precio = 26;
                    break;

                case 4:
                    pelicula = "Coyotes";
                    precio = 24;
                    break;

                default:
                    System.out.println("Película inválida");
                    return;
            }

            comprarEntradas(pelicula, precio);
        }

        // ================= COMPRA =================

        public static void comprarEntradas(String pelicula, double precio) {

            int cantidad;

            System.out.println("========= COMPRA =========");
            System.out.println("Película: " + pelicula);
            System.out.println("Precio: S/" + precio);

            System.out.print("Cantidad de entradas: ");
            cantidad = sc.nextInt();

            if (cantidad <= 0) {

                System.out.println("Cantidad inválida");
                return;
            }

            double total = cantidad * precio;

            System.out.println("¿Desea aplicar promoción?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int promo = sc.nextInt();

            if (promo == 1) {

                total = total * 0.5;
                System.out.println("Promoción aplicada ✅");
            }

            resumenCompra(pelicula, cantidad, total);
        }

        // ================= RESUMEN =================

        public static void resumenCompra(String pelicula, int cantidad,double total) {

            System.out.println("========= RESUMEN =========");
            System.out.println("Película: " + pelicula);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Total: S/" + total);
            System.out.println("Gracias por su compra 🎬");
        }

        // ================= CINES =================

        public static void cines() {

            int opcion;

            System.out.println("========= CINES =========");
            System.out.println("1. Lima");
            System.out.println("2. Arequipa");
            System.out.println("3. Cusco");
            System.out.println("4. Puno");
            System.out.print("Seleccione ciudad: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Cineplanet Lima");
                    break;

                case 2:
                    System.out.println("Cineplanet Arequipa");
                    break;

                case 3:
                    System.out.println("Cineplanet Cusco");
                    break;

                case 4:
                    System.out.println("Cineplanet Puno");
                    break;

                default:
                    System.out.println("Ciudad inválida");
            }
        }

        // ================= PROMOCIONES =================

        public static void promociones() {

            System.out.println("========= PROMOCIONES =========");
            System.out.println("🎟️ 2x1 con Entel");
            System.out.println("🍿 Combo especial Socio");
            System.out.println("🎮 Experiencia Gaming");
            System.out.println("🎁 Tickets coleccionables");
        }

        // ================= SOCIO =================

        public static void socio() {

            int opcion;

            System.out.println("========= SOCIO CINEPLANET =========");
            System.out.println("1. Socio Clásico");
            System.out.println("2. Socio Plata");
            System.out.println("3. Socio Oro");
            System.out.println("4. Socio Black");
            System.out.print("Seleccione categoría: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Beneficios Socio Clásico");
                    break;

                case 2:
                    System.out.println("Beneficios Socio Plata");
                    break;

                case 3:
                    System.out.println("Beneficios Socio Oro");
                    break;

                case 4:
                    System.out.println("Beneficios Socio Black");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        // ================= DULCERÍA =================

        public static void dulceria() {

            int opcion;

            System.out.println("========= DULCERÍA =========");
            System.out.println("1. Canchita Grande - S/18");
            System.out.println("2. Hot Dog - S/12");
            System.out.println("3. Nachos - S/15");
            System.out.println("4. Gaseosa - S/10");
            System.out.print("Seleccione producto: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Canchita agregada 🍿");
                    break;

                case 2:
                    System.out.println("Hot Dog agregado 🌭");
                    break;

                case 3:
                    System.out.println("Nachos agregados 🧀");
                    break;

                case 4:
                    System.out.println("Gaseosa agregada 🥤");
                    break;

                default:
                    System.out.println("Producto inválido");
            }
        }
    }
