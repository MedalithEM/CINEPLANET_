 import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Cineplanet {
    static String correo = "";
    static String pass = "";
    static String tipocliente = "Invitado";
    static String cine = "";
    static String pelicula = "";
    static String categoria = "";
    static String formato = "";
    static String horario = "";
    static String sala = "";
    static String tipoEntrada = "";
    static int cantidadEntradas = 0;
    static double precioEntrada = 0.0;
    static double totalEntradas = 0.0;
    static double totalDulceria = 0.0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean estado = true;
        int opcion;

        System.out.println("Bienvenido a CINEPLANET");

        while (estado) {

            System.out.println();
            System.out.println("SELECCIONE:");
            System.out.println("1.- Registrarse");
            System.out.println("2.- Iniciar sesion");
            System.out.println("3.- Modo invitado");
            System.out.println("4.- Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Registrarse(sc);
                    break;

                case 2:
                    if (correo.equals("") || pass.equals("")) {
                        System.out.println("Primero debe registrarse.");
                    } else {
                        if (validarInicio(sc)) {
                            tipocliente = "Socio";
                            menuPrincipal(sc, tipocliente);
                        }
                    }
                    break;

                case 3:
                    tipocliente = "Invitado";
                    menuPrincipal(sc, tipocliente);
                    break;

                case 4:
                    estado = false;
                    System.out.println("Gracias por visitar Cineplanet");
                    System.out.println("Saliendo de la pagina...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

    public static void Registrarse(Scanner sc) {
        boolean registroexitoso = false;
        System.out.println();
        System.out.println("============== REGISTRO ==============");
        System.out.println("Requisitos del correo:");
        System.out.println("- Debe contener @");
        System.out.println("- Debe terminar en .com");

        System.out.println();
        System.out.println("Requisitos de contraseña:");
        System.out.println("- Minimo 8 caracteres");
        System.out.println("- Debe tener al menos un caracter especial");
        System.out.println("- Caracteres permitidos: @ # $ % & * ! ?");

        do {
            System.out.print("Ingrese correo: ");
            correo = sc.nextLine();
            System.out.print("Ingrese password: ");
            pass = sc.nextLine();
            boolean correoOK = correo.contains("@") && correo.endsWith(".com");

            boolean passOK = pass.length() >= 8 &&
                    (pass.contains("@") || pass.contains("#") || pass.contains("$") ||
                            pass.contains("%") || pass.contains("&") || pass.contains("*") ||
                            pass.contains("!") || pass.contains("?"));

            if (!correoOK || !passOK) {
                System.out.println("Error: los datos no cumplen los requisitos");

                if (!correoOK) {
                    System.out.println("Corrija el correo. Debe contener @ y terminar en .com");
                }

                if (!passOK) {
                    System.out.println("Corrija la contraseña o agregue caracteres especiales");
                }

            } else {
                registroexitoso = true;
            }

        } while (!registroexitoso);

        System.out.print("Ingrese su password nuevamente: ");
        String pass_in = sc.nextLine();

        validarPassword(pass, pass_in, sc);

        System.out.println("Se ha registrado correctamente");
        System.out.println("Ahora puede iniciar sesion");
    }

    public static void validarPassword(String pass, String passin, Scanner sc) {
        boolean valido = false;
        do {
            if (pass.equals(passin)) {
                valido = true;
            } else {
                System.out.println("Contraseña incorrecta");
                System.out.println("Ingresela nuevamente");
                passin = sc.nextLine();
            }

        } while (!valido);

        System.out.println("Contraseña validada");
    }

    public static boolean validarInicio(Scanner sc) {

        int intentos = 0;
        boolean acceso = false;

        while (intentos < 3 && !acceso) {

            System.out.println();
            System.out.println("============== INICIAR SESION ==============");

            System.out.print("Ingrese su correo: ");
            String correoin = sc.nextLine();

            System.out.print("Ingrese su password: ");
            String passin = sc.nextLine();

            if (correo.equals(correoin) && pass.equals(passin)) {
                acceso = true;
                System.out.println("Datos validados");
            } else {
                intentos++;
                System.out.println("Datos incorrectos");
                System.out.println("Intentos usados: " + intentos + " de 3");
            }
        }

        if (!acceso) {
            System.out.println("Cuenta bloqueada por exceder los 3 intentos");
        }
        return acceso;
    }

    public static void menuPrincipal(Scanner sc, String tipocliente) {

        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println();
            System.out.println("----Menú principal----");
            System.out.println("Cliente: " + tipocliente);
            System.out.println("1.- Peliculas Cineplanet 🎬📽️");
            System.out.println("2.- Ubicacion de Cines 🛰️");
            System.out.println("3.- Promociones 😎");
            System.out.println("4.- Socio 👤");
            System.out.println("5.- Dulcería 🍿🥤");
            System.out.println("6.- Emitir boleta 🧾");
            System.out.println("7.- Volver al inicio 🔙");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Peliculas Cineplanet 🎬📽️");
                    boolean Micliente = TipoPsocio(tipocliente);
                    peliculas(sc, "CP Juliaca", Micliente);
                    break;

                case 2:
                    System.out.println("Ubicacion de Cines 🛰️");
                    Cines(sc);
                    break;
                case 3:
                    System.out.println("Mostrando Promociones 😎");
                    Promociones(sc);
                    break;

                case 4:
                    System.out.println("Socio : Beneficios 👤");
                    Socio(sc);
                    break;
                case 5:
                    System.out.println("Dulceria 🍿🥤");
                    Micliente = TipoPsocio(tipocliente);
                    Dulceria(sc, Micliente);
                    break;

                case 6:
                    emitirBoleta(sc);
                    break;

                case 7:
                    menuActivo = false;
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    public static void Socio(Scanner sc) {

        System.out.println("============== ZONA SOCIO 👤 ==============");
        System.out.println("1.- Explorar socio+");
        System.out.println("2.- Visitas");
        System.out.println("3.- Puntos");
        System.out.println("4.- Socio Clasica");
        System.out.println("5.- Socio Plata");
        System.out.println("6.- Socio Oro");
        System.out.println("7.- Socio Black");
        System.out.println("8.- Salir");
        int opcion = sc.nextInt();
        switch (opcion) {

            case 1:
                System.out.println("INGRESASTE A SOCIO+");
                System.out.println("15% de dscto. en toda la tienda");
                System.out.println("Hasta 25% OFF en maquillaje, skincare y fragancias");
                System.out.println("Combo Socio Cineplanet");
                System.out.println("25% de descuento en planes moviles");
                break;

            case 2:
                System.out.println("Acumula visitas para pasar a la siguiente categoria");
                System.out.println("Funcion clasica: 1 visita");
                System.out.println("Funcion Prime: 2 visitas");
                break;

            case 3:
                System.out.println("Acumula puntos para canjear entradas y combos");
                System.out.println("1 punto por cada entrada");
                System.out.println("10% del monto gastado en dulceria");
                break;

            case 4:
                System.out.println("SOCIO CLASICO");
                System.out.println("Lunes y Miércoles a precio especial");
                System.out.println("Regalo de cumpleaños: 1 entrada 2D");
                break;

            case 5:
                System.out.println("SOCIO PLATA");
                System.out.println("2 entradas 2D + Combo Especial");
                break;

            case 6:
                System.out.println("SOCIO ORO");
                System.out.println("Beneficios premium y combos especiales");
                break;

            case 7:
                System.out.println("SOCIO BLACK");
                System.out.println("Entradas de cortesia y beneficios exclusivos");
                break;

            case 8:
                break;

            default:
                System.out.println("Opcion no valida");
        }
    }

    public static void Promociones(Scanner sc) {
        System.out.println("============== PROMOCIONES 😎 ==============");
        System.out.println("1.- PROMOS 2x1 CON ENTEL");
        System.out.println("2.- TICKETS MANDALORIAN Y GROGU");
        System.out.println("3.- TICKETS TXT");
        System.out.println("4.- EXPERIENCIA GAMING");
        System.out.println("5.- CARDS TOP GUN");
        int opcion = sc.nextInt();
        switch (opcion) {

            case 1:
                System.out.println("Promo 2x1 con Entel válida hasta agotar stock");
                break;

            case 2:
                System.out.println("Tickets conmemorativos de The Mandalorian and Grogu");
                break;

            case 3:
                System.out.println("Tickets especiales de TXT");
                break;

            case 4:
                System.out.println("Participa por una experiencia gaming");
                break;

            case 5:
                System.out.println("Cards coleccionables de Top Gun");
                break;

            default:
                System.out.println("Opción inválida");
        }
    }
    public static void Cines(Scanner sc) {

        System.out.println("========= CINES 🛰️ =========");
        System.out.println("1.- Lima");
        System.out.println("2.- Arequipa");
        System.out.println("3.- Cusco");
        System.out.println("4.- Juliaca");
        System.out.println("5.- Puno");
        System.out.println("6.- Tacna");
        System.out.println("7.- Salir");

        int ciudad = sc.nextInt();

        switch (ciudad) {

            case 1:
                peliculas(sc, "CP Alcazar Av. Santa Cruz 814", TipoPsocio(tipocliente));
                break;

            case 2:
                peliculas(sc, "CP Arequipa Mall Plaza", TipoPsocio(tipocliente));
                break;

            case 3:
                peliculas(sc, "CP Cusco Av. Collasuyo", TipoPsocio(tipocliente));
                break;

            case 4:
                peliculas(sc, "CP Juliaca Real Plaza", TipoPsocio(tipocliente));
                break;

            case 5:
                peliculas(sc, "CP Puno Av. Los Incas", TipoPsocio(tipocliente));
                break;

            case 6:
                peliculas(sc, "CP Tacna Calle Cuzco", TipoPsocio(tipocliente));
                break;

            case 7:
                break;

            default:
                System.out.println("Ciudad no valida");
        }
    }
    public static boolean TipoPsocio(String tipocliente) {

        return tipocliente.equals("Socio");
    }
    public static void peliculas(Scanner sc, String cineElegido, boolean socio) {
        cine = cineElegido;
        System.out.println("============== PELICULAS 🎬📽️ ==============");
        System.out.println("1.- En cartelera");
        System.out.println("2.- Preventa");
        System.out.println("3.- Proximos estrenos");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                categoria = "En cartelera";
                peliculasCartelera(sc, socio);
                break;
            case 2:
                categoria = "Preventa";
                peliculasPreventa(sc, socio);
                break;
            case 3:
                categoria = "Proximos estrenos";
                peliculasEstrenos(sc, socio);
                break;
            default:
                System.out.println("Categoria invalida");
        }
    }

    public static void peliculasCartelera(Scanner sc, boolean socio) {
        System.out.println("============== EN CARTELERA ==============");
        if (socio) {
            System.out.println("1.- Hokum La Maldición de la Bruja     S/ 11.00");
            System.out.println("2.- Obsesión                           S/ 12.00");
            System.out.println("3.- Panda Plan La Tribu Mágica         S/ 10.00");
            System.out.println("4.- Tú y Yo La Toscana                 S/ 13.00");
            System.out.println("5.- Volcán Fuego Bajo Tierra           S/ 14.00");
            System.out.println("6.- Top Gun 1986                       S/ 14.00");
            System.out.println("7.- La Niña                            S/ 12.50");
            System.out.println("8.- Las Ovejas Detectives              S/ 10.50");
        } else {
            System.out.println("1.- Hokum La Maldición de la Bruja     S/ 15.00");
            System.out.println("2.- Obsesión                           S/ 16.00");
            System.out.println("3.- Panda Plan La Tribu Mágica         S/ 13.50");
            System.out.println("4.- Tú y Yo La Toscana                 S/ 17.00");
            System.out.println("5.- Volcán Fuego Bajo Tierra           S/ 18.00");
            System.out.println("6.- Top Gun 1986                       S/ 18.00");
            System.out.println("7.- La Niña                            S/ 16.50");
            System.out.println("8.- Las Ovejas Detectives              S/ 14.00");
        }
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                asignarPelicula("Hokum La Maldición de la Bruja", socio ? 11.00 : 15.00);
                break;
            case 2:
                asignarPelicula("Obsesión", socio ? 12.00 : 16.00);
                break;
            case 3:
                asignarPelicula("Panda Plan La Tribu Mágica", socio ? 10.00 : 13.50);
                break;
            case 4:
                asignarPelicula("Tú y Yo La Toscana", socio ? 13.00 : 17.00);
                break;
            case 5:
                asignarPelicula("Volcán Fuego Bajo Tierra", socio ? 14.00 : 18.00);
                break;
            case 6:
                asignarPelicula("Top Gun 1986", socio ? 14.00 : 18.00);
                break;
            case 7:
                asignarPelicula("La Niña", socio ? 12.50 : 16.50);
                break;
            case 8:
                asignarPelicula("Las Ovejas Detectives", socio ? 10.50 : 14.00);
                break;
            default:
                System.out.println("Película inválida");
                return;
        }
        formato(sc);
    }

    public static void peliculasPreventa(Scanner sc, boolean socio) {

        System.out.println("============== PREVENTA ==============");

        if (socio) {
            System.out.println("1.- Top Gun Maverick                      S/ 15.00");
            System.out.println("2.- Summer Wars                           S/ 11.50");
            System.out.println("3.- The Mandalorian and Grogu             S/ 16.00");
            System.out.println("4.- Mirai Mi Pequeña Hermana              S/ 10.50");
            System.out.println("5.- Amor del Universo                     S/ 13.50");
            System.out.println("6.- 2026 TXT MOA Coin Japan Live Viewing  S/ 17.00");
        } else {
            System.out.println("1.- Top Gun Maverick                      S/ 20.00");
            System.out.println("2.- Summer Wars                           S/ 15.50");
            System.out.println("3.- The Mandalorian and Grogu             S/ 22.00");
            System.out.println("4.- Mirai Mi Pequeña Hermana              S/ 14.50");
            System.out.println("5.- Amor del Universo                     S/ 18.50");
            System.out.println("6.- 2026 TXT MOA Coin Japan Live Viewing  S/ 24.00");
        }
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                asignarPelicula("Top Gun Maverick", socio ? 15.00 : 20.00);
                break;
            case 2:
                asignarPelicula("Summer Wars", socio ? 11.50 : 15.50);
                break;
            case 3:
                asignarPelicula("The Mandalorian and Grogu", socio ? 16.00 : 22.00);
                break;
            case 4:
                asignarPelicula("Mirai Mi Pequeña Hermana", socio ? 10.50 : 14.50);
                break;
            case 5:
                asignarPelicula("Amor del Universo", socio ? 13.50 : 18.50);
                break;
            case 6:
                asignarPelicula("2026 TXT MOA Coin Japan Live Viewing", socio ? 17.00 : 24.00);
                break;
            default:
                System.out.println("Película inválida");
                return;
        }
        formato(sc);
    }
    public static void peliculasEstrenos(Scanner sc, boolean socio) {
        System.out.println("============== PROXIMOS ESTRENOS ==============");

        if (socio) {
            System.out.println("1.- Dolly                              S/ 13.00");
            System.out.println("2.- El Club de los Gritos              S/ 12.50");
            System.out.println("3.- Zona de Riesgo                     S/ 14.00");
            System.out.println("4.- Amanda Amanda                      S/ 11.00");
            System.out.println("5.- Ponyo y el Secreto de la Sirena    S/ 10.00");
            System.out.println("6.- El Pasajero del Diablo             S/ 13.50");
        } else {
            System.out.println("1.- Dolly                              S/ 17.00");
            System.out.println("2.- El Club de los Gritos              S/ 16.50");
            System.out.println("3.- Zona de Riesgo                     S/ 19.00");
            System.out.println("4.- Amanda Amanda                      S/ 15.00");
            System.out.println("5.- Ponyo y el Secreto de la Sirena    S/ 13.50");
            System.out.println("6.- El Pasajero del Diablo             S/ 18.00");
        }
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                asignarPelicula("Dolly", socio ? 13.00 : 17.00);
                break;
            case 2:
                asignarPelicula("El Club de los Gritos", socio ? 12.50 : 16.50);
                break;
            case 3:
                asignarPelicula("Zona de Riesgo", socio ? 14.00 : 19.00);
                break;
            case 4:
                asignarPelicula("Amanda Amanda", socio ? 11.00 : 15.00);
                break;
            case 5:
                asignarPelicula("Ponyo y el Secreto de la Sirena", socio ? 10.00 : 13.50);
                break;
            case 6:
                asignarPelicula("El Pasajero del Diablo", socio ? 13.50 : 18.00);
                break;
            default:
                System.out.println("Película inválida");
                return;
        }
        formato(sc);
    }
    public static void asignarPelicula(String nombre, double precio) {
        pelicula = nombre;
        precioEntrada = precio;
    }
    public static void formato(Scanner sc) {
        System.out.println("============== FORMATO ==============");
        System.out.println("1.- 2D");
        System.out.println("2.- 3D");
        System.out.println("3.- REGULAR");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                formato = "2D";
                break;
            case 2:
                formato = "3D";
                precioEntrada = precioEntrada + 4.00;
                break;
            case 3:
                formato = "REGULAR";
                break;
            default:
                System.out.println("Formato inválido");
                return;
        }
        horarios(sc);
    }

    public static void horarios(Scanner sc) {
        System.out.println("=======================================");
        System.out.println(pelicula);
        System.out.println(formato + ", DOBLADA");
        System.out.println(cine);
        System.out.println("Hoy, 18 de May, 2026");
        System.out.println("1.- 14:20");
        System.out.println("2.- 19:00");
        System.out.println("3.- 21:50");
        System.out.println("SALA 5");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                horario = "14:20";
                break;
            case 2:
                horario = "19:00";
                break;
            case 3:
                horario = "21:50";
                break;
            default:
                System.out.println("Horario invalido");
                return;
        }
        sala = "SALA 5";
        entradas(sc);
    }
    public static void entradas(Scanner sc) {
        System.out.println("============== ENTRADAS GENERALES ===============");
        System.out.println("1.- General " + formato + " OL");
        System.out.println("2.- Mayores 60 años " + formato + " OL");
        System.out.println("3.- Niños " + formato + " OL");
        System.out.println("4.- Boleto Conadis " + formato + " OL");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                tipoEntrada = "General";
                break;
            case 2:
                tipoEntrada = "Adulto Mayor";
                precioEntrada = precioEntrada - 1.00;
                break;
            case 3:
                tipoEntrada = "Niños";
                precioEntrada = precioEntrada - 1.00;
                break;
            case 4:
                tipoEntrada = "Conadis";
                precioEntrada = 12.50;
                break;
            default:
                System.out.println("Entrada inválida");
                return;
        }
        System.out.println("Ingrese la cantidad de entradas");
        cantidadEntradas = sc.nextInt();
        if (cantidadEntradas <= 0) {
            System.out.println("Cantidad invalida");
            return;
        }
        totalEntradas = precioEntrada * cantidadEntradas;
        promocionesv(sc);
    }
    public static void promocionesv(Scanner sc) {

        System.out.println("============= PROMOCIONES ACTUALES =============");
        System.out.println("1.- 50% Promo Amex 2025");
        System.out.println("2.- Promocion Entel 2x1(solo en cantidad de boletas pares)");
        System.out.println("3.- Descuento del 70% para socio plata");
        System.out.println("4.- Descuento del 90% para socio black");
        System.out.println("4.- Continuar sin promoción");
        int opcion = sc.nextInt();
        boolean esSocio = tipocliente.equalsIgnoreCase("socio");
        switch (opcion){
            case 1:
                System.out.println("Ingrese su codigo de descuento");
                double codigoD= sc.nextInt();
                double codigov=45634567;
                if (codigoD==codigov) {
                    totalEntradas = totalEntradas / 2;
                    System.out.println("Promocion aplicada");
                }
                break;
            case 2:
                System.out.println("Ingrese su codigo de descuento");
                double codigoR= sc.nextInt();
                double codigoL=45678234;
                if (codigoR==codigoL) {
                    totalEntradas = totalEntradas * 0.50;
                    System.out.println("Promocion aplicada");
                }
                break;
            case 3:
                if (esSocio) {
                    System.out.println("Ingrese su codigo de descuento");
                    double codigoM = sc.nextInt();
                    double codigoK = 7890789;
                    if (codigoM == codigoK) {
                        totalEntradas = totalEntradas * 0.70;
                        System.out.println("Promocion aplicada");
                    }
                } else {
                    System.out.println("Promocion valida solo para socios");
                }

                break;
            case 4:
                if (esSocio) {
                    System.out.println("Ingrese su codigo de descuento");
                    double codigoB = sc.nextInt();
                    double codigoC = 89901212;
                    if (codigoB == codigoC) {
                        totalEntradas = totalEntradas * 0.90;
                        System.out.println("Promocion aplicada");
                    }
                } else {
                    System.out.println("Promocion valida solo para socios");
                }

                break;
            case 5:
                System.out.println("Sin promociones ni descuentos aplicados");
                break;
            default:
        }
       resumen();
    }

    public static void resumen() {
        System.out.println("================== RESUMEN ==================");
        System.out.println("Película: " + pelicula);
        System.out.println("Formato: " + formato);
        System.out.println("Cine: " + cine);
        System.out.println("Entrada: " + tipoEntrada);
        System.out.println("Cantidad: " + cantidadEntradas);
        System.out.println("Total entradas S/ " + totalEntradas);
        System.out.println("La compra fue agregada. Puede emitir boleta desde el menú principal.");
    }
    public static int Dulceria(Scanner sc, boolean socio) {
        System.out.println("============== DULCERÍA 🍿🥤 ==============");
        System.out.println("Categorias");
        System.out.println("1.- Promos");
        System.out.println("2.- Combos");
        System.out.println("3.- Canchitas");
        System.out.println("4.- Complementos");
        System.out.println("5.- Bebidas");
        if (socio) {
            System.out.println("6.- Combos socio");
        }
        double MiPrecio = 0.0;
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("1.- Dulceras");
                System.out.println("2.- De pelicula");
                opcion = sc.nextInt();
                MiPrecio = PrecioPROMOS(opcion, sc);
                break;

            case 2:
                System.out.println("1.- Para uno");
                System.out.println("2.- Para compartir");
                opcion = sc.nextInt();
                MiPrecio = PrecioCOMBOS(opcion, sc);
                break;

            case 3:
                System.out.println("1.- Canchita Mediana");
                System.out.println("2.- Canchita Grande");
                System.out.println("3.- Canchita Gigante");
                opcion = sc.nextInt();
                MiPrecio = PrecioCanchitas(opcion);
                break;

            case 4:
                System.out.println("1.- SUBLIME POPS");
                System.out.println("2.- Hot Dog Jumbo");
                System.out.println("3.- NACHOS CON QUESO CHEDDAR");
                System.out.println("4.- KIT KAT WHITE");
                System.out.println("5.- KIT KAT 4 FINGERS MILK");
                System.out.println("6.- QUESO ADICIONAL 1.5 OZ");
                opcion = sc.nextInt();
                MiPrecio = PrecioComplementos(opcion);
                break;

            case 5:
                System.out.println("1.- CCBebida Mediana");
                System.out.println("2.- CCBebida Grande");
                System.out.println("3.- Agua San Luis sin gas");
                opcion = sc.nextInt();
                MiPrecio = PrecioBebidas(opcion);
                break;

            case 6:
                if (socio) {
                    System.out.println("Combo Socio Clásico OL");
                    System.out.println("1 Bebida mediana 21oz + Canchita salada grande");
                    MiPrecio = PrecioComsocio(opcion);
                } else {
                    System.out.println("Opcion no valida");
                }
                break;

            default:
                System.out.println("Opcion no valida");
        }

        if (MiPrecio != 0.0) {
            double total = Total_pagarDulceria(MiPrecio, sc);
            totalDulceria = totalDulceria + total;
        }

        return opcion;
    }
    public static double PrecioPROMOS(int opcion, Scanner sc) {
        double precio = 0.0;
        switch (opcion) {
            case 1:
                System.out.println("1.- COMBO DOS + 2M&M");
                System.out.println("2.- COMBO UNO + M&M");
                System.out.println("3.- COMBO 2 + 2 SUBLIME POPS");
                System.out.println("4.- COMBO 1 + SUBLIME POPS");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        precio = 46.00;
                        break;
                    case 2:
                        precio = 24.00;
                        break;
                    case 3:
                        precio = 47.00;
                        break;
                    case 4:
                        precio = 26.00;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;
            case 2:
                System.out.println("1.- COMBO 2 + VASO MANDALORIAN");
                System.out.println("2.- COMBO 2 + PALOMERO GROGU");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        precio = 87.00;
                        break;
                    case 2:
                        precio = 163.00;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            default:
                System.out.println("Opcion no valida");
        }
        return precio;
    }
    public static double PrecioCOMBOS(int opcion, Scanner sc) {
        double precio = 0.0;
        switch (opcion) {
            case 1:
                System.out.println("1.- Combo 1: 1 Canchita Grande + 1 Bebida (32oz)");
                System.out.println("2.- Combo Hot Dog: 1 Hot Dog + 1 Bebida (32oz)");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        precio = 20.50;
                        break;
                    case 2:
                        precio = 19.00;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            case 2:
                System.out.println("1.- Combo 2: 1 Canchita Gigante + 2 Bebidas");
                System.out.println("2.- Combo Familiar: 1 Canchita Gigante + 4 Bebidas");
                System.out.println("3.- Com.2 Dob.Gig.: 2 Canchitas Gigantes + 2 Bebidas");
                System.out.println("4.- Combo de Película: 1 Canchita Grande + 2 Bebidas");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        precio = 33.00;
                        break;
                    case 2:
                        precio = 163.00;
                        break;
                    case 3:
                        precio = 40.00;
                        break;
                    case 4:
                        precio = 20.50;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            default:
                System.out.println("Opcion no valida");
        }
        return precio;
    }
    public static double PrecioCanchitas(int opcion) {
        double precio = 0.0;
        switch (opcion) {
            case 1:
                precio = 13.00;
                break;
            case 2:
                precio = 15.00;
                break;
            case 3:
                precio = 21.50;
                break;
            default:
                System.out.println("Opcion no valida");
        }
        return precio;
    }
    public static double PrecioComplementos(int opcion) {
        double precio = 0.0;
        switch (opcion) {
            case 1:
                precio = 10.00;
                break;
            case 2:
                precio = 13.50;
                break;
            case 3:
                precio = 13.50;
                break;
            case 4:
                precio = 9.00;
                break;
            case 5:
                precio = 9.00;
                break;
            case 6:
                precio = 4.50;
                break;
            default:
                System.out.println("Opcion no valida");
        }
        return precio;
    }
    public static double PrecioBebidas(int opcion) {
        double precio = 0.0;
        switch (opcion) {
            case 1:
                precio = 10.50;
                break;
            case 2:
                precio = 12.00;
                break;
            case 3:
                precio = 4.00;
                break;
            default:
                System.out.println("Opcion no valida");
        }
        return precio;
    }
    public static double PrecioComsocio(int opcion) {
        double precio = 15.00;
        return precio;
    }
    public static double Total_pagarDulceria(double precio, Scanner sc) {
        System.out.println("Ingrese la cantidad");
        int cantidad = sc.nextInt();
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida");
            return 0.0;
        }
        double totalp = precio * cantidad;
        System.out.println("Total a pagar en dulceria: S/ " + totalp);
        System.out.println("Redirigase al menu anterior y emita su boleta.");
        return totalp;
    }
    public static void emitirBoleta(Scanner sc) {
        double totalFinal = totalEntradas + totalDulceria;
        if (totalFinal <= 0) {
            System.out.println("No hay compras registradas para emitir boleta");
            return;
        }
        System.out.println("============== MÉTODO DE PAGO ==============");
        System.out.println("1.- Efectivo");
        System.out.println("2.- Tarjeta");
        System.out.println("3.- Yape / Plin");
        int metodo = sc.nextInt();
        String metodoPago = "";
        double pago = 0.0;
        double vuelto = 0.0;
        switch (metodo) {
            case 1:
                metodoPago = "Efectivo";

                do {
                    System.out.println("Ingrese monto pagado");
                    pago = sc.nextDouble();

                    if (pago < totalFinal) {
                        System.out.println("Monto insuficiente");
                    }
                } while (pago < totalFinal);

                vuelto = pago - totalFinal;
                break;
            case 2:
                metodoPago = "Tarjeta";
                pago = totalFinal;
                vuelto = 0.0;
                System.out.println("Pago con tarjeta aprobado");
                validaPagoTarjeta(sc,totalFinal);
                break;

            case 3:
                metodoPago = "Yape / Plin";
                pago = totalFinal;
                vuelto = 0.0;
                System.out.println("Pago por Yape / Plin confirmado");
                break;

            default:
                System.out.println("Metodo de pago invalido");
                return;
        }
        double subtotal = totalFinal / 1.18;
        double igv = totalFinal - subtotal;
        System.out.println();
        System.out.println("==============================================");
        System.out.println("              BOLETA ELECTRÓNICA 🧾");
        System.out.println("==============================================");
        System.out.println("CINEPLANET");
        System.out.println("RUC: 20429683581");
        System.out.println("Cliente: " + tipocliente);
        System.out.println("----------------------------------------------");
        System.out.println("Cine: " + cine);
        System.out.println("Película: " + pelicula);
        System.out.println("Categoria: " + categoria);
        System.out.println("Formato: " + formato);
        System.out.println("Horario: " + horario);
        System.out.println("Sala: " + sala);
        System.out.println("Tipo entrada: " + tipoEntrada);
        System.out.println("Cantidad entradas: " + cantidadEntradas);
        System.out.println("----------------------------------------------");
        System.out.println("Total entradas: S/ " + redondear(totalEntradas));
        System.out.println("Total dulceria: S/ " + redondear(totalDulceria));
        System.out.println("Subtotal: S/ " + redondear(subtotal));
        System.out.println("IGV: S/ " + redondear(igv));
        System.out.println("Total: S/ " + redondear(totalFinal));
        System.out.println("Metodo de pago: " + metodoPago);
        System.out.println("Pago recibido: S/ " + redondear(pago));
        System.out.println("Vuelto: S/ " + redondear(vuelto));
        System.out.println("----------------------------------------------");
        System.out.println("Precios incluyen IGV");
        System.out.println("Gracias por su compra");
        System.out.println("==============================================");
        limpiarCompra();
    }
    public static void validaPagoTarjeta(Scanner sc, double total) {
        String nroTarjeta, fechaVencimiento, cvv;
        boolean pAprobado = false;
        System.out.println("Monto total a pagar con tarjeta es: " + total);
        do {
            System.out.println("Ingrese los 16 digitos de la tarjeta");
            sc.nextLine();
            nroTarjeta = sc.nextLine();
            System.out.println("Ingrese la fecha de caducidad (MM/AA)");
            fechaVencimiento = sc.nextLine();
            System.out.println("Ingrese el codigo de seguridad CVV");
            cvv = sc.nextLine();
            boolean tarjetaOk =
                    (nroTarjeta.length() == 16);
            boolean cvvOk =
                    (cvv.length() == 3);
            boolean fechaEstructuraOk =
                    (fechaVencimiento.length() == 5
                            && fechaVencimiento.contains("/"));
            boolean fechaNoVencida = false;
            if (fechaEstructuraOk) {
                try {
                    DateTimeFormatter formateador =
                            DateTimeFormatter.ofPattern("MM/yy");
                    YearMonth fechaTarjeta =
                            YearMonth.parse(fechaVencimiento, formateador);
                    YearMonth fechaActual =
                            YearMonth.now();
                    if (fechaTarjeta.isAfter(fechaActual)
                            || fechaTarjeta.equals(fechaActual)) {
                        fechaNoVencida = true;
                    }
                } catch (DateTimeParseException e) {
                    fechaEstructuraOk = false;
                }
            }
            if (tarjetaOk && fechaEstructuraOk
                    && fechaNoVencida && cvvOk) {
                System.out.println("Autorizando fondos...");
                System.out.println("Transaccion exitosa");
                pAprobado = true;
            } else {
                System.out.println("Operacion denegada");
            }
            if (!tarjetaOk) {
                System.out.println("La tarjeta debe tener 16 digitos");
            }
            if (!cvvOk) {
                System.out.println("El CVV debe tener 3 digitos");
            }
            if (!fechaEstructuraOk) {
                System.out.println("Formato de fecha incorrecto");
            }
            if (fechaEstructuraOk && !fechaNoVencida) {
                System.out.println("Tarjeta vencida");
            }
        } while (!pAprobado);
    }
    public static double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
    public static void limpiarCompra() {
        cine = "";
        pelicula = "";
        categoria = "";
        formato = "";
        horario = "";
        sala = "";
        tipoEntrada = "";

        cantidadEntradas = 0;
        precioEntrada = 0.0;
        totalEntradas = 0.0;
        totalDulceria = 0.0;
    }
}
