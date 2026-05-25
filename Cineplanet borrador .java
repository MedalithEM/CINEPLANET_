 import java.util.Scanner;
public class Cineplanet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean estado = true;
        int opcion;
        double totalp=0.0;
        String tipocliente="";
        String correo = "", pass = "";
        System.out.println("Bienvenido a CINEPLANET");
        while (estado) {
            System.out.println("SELECCIONE:");
            System.out.println("1.-Registrarse");
            System.out.println("2.-Iniciar sesion");
            System.out.println("3.-Modo invitado");
            System.out.println("4.-Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese correo");
                    correo = sc.nextLine();
                    System.out.println("Ingrese password");
                    pass = sc.nextLine();
                    Registrarse(sc, correo, pass);
                    System.out.println("Ingrese su password nuevamente");
                    String pass_in = sc.nextLine();
                    validarPassword(pass, pass_in,sc);
                    break;
                case 2:
                    if (correo.equals("") || pass.equals("")) {
                        System.out.println("Primero debe registrarse.");
                    }
                    else {
                        System.out.println("Ingrese su correo");
                        String correoin = sc.nextLine();
                        System.out.println("Ingrese su password");
                        String passin = sc.nextLine();
                        validarInicio(correoin, correo, passin, pass, sc,tipocliente);
                        tipocliente = "Socio";
                        menuPrincipal(sc,tipocliente);
                    }
                    break;
                case 3:
                    tipocliente="Invitado";
                    menuPrincipal(sc,tipocliente);
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
    }

    public static boolean Registrarse(Scanner sc, String correoin, String passin) {
        boolean registroexitoso = false;
        do {
            boolean EstructuracorreoOK = correoin.contains("@") && correoin.endsWith(".com");
            boolean estructurapassOk = passin.length() >= 8 && (passin.contains("@") || (passin.contains("#")) || (passin.contains("$")) || (passin.contains("%")) || (passin.contains("&")) || (passin.contains("*")) || (passin.contains("!")) || (passin.contains("?")));
            if (!EstructuracorreoOK || !estructurapassOk) {
                System.out.println("Error los datos no cumplen requisitos");
                if (!EstructuracorreoOK) {
                    System.out.println("El correo debe contener: @ y terminar con: .com");
                }
                if (!estructurapassOk) {
                    System.out.println("La contrasena debe tener minimo 8 caracteres y uno de estos caracteres especiales: @,#,$,%,&,*,!,?");
                }
                System.out.println("Ingrese correo");
                correoin = sc.nextLine();
                System.out.println("Ingrese password");
                passin = sc.nextLine();
            } else {
                registroexitoso = true;
                System.out.println("Se ha registrado correctaente");
            }
        }
        while (!registroexitoso);
        return registroexitoso;
    }

    public static void validarPassword(String pass, String passin,Scanner sc) {
        boolean valido=false;
        do{
            if (pass.equals(passin)) {
                valido=true;
            } else {
                System.out.println("Contraseña incorrecta...vuelVa va a ESCRIBIRLA");
                System.out.println("Ingresela nuevamente");
                passin= sc.nextLine();
            }
        } while(valido==false);
        System.out.println("Contraseña validada");
        System.out.println("Ahora puede INICIAR SESION...");
    }

    public static void validarInicio(String pass, String passin, String correo, String correoin, Scanner sc,String tipocliente) {
        if (pass.equals(passin) &&
                correo.equals(correoin)) {
            System.out.println("Datos validados");
            menuPrincipal(sc,tipocliente);
        } else {
            System.out.println("Datos incorrectos");
        }
    }

    public static void menuPrincipal(Scanner sc,String tipocliente) {
        System.out.println("----Menú principal----");
        System.out.println("1.-Peliculas");
        System.out.println("2.-Cines");
        System.out.println("3.-Promociones");
        System.out.println("4.-Socio");
        System.out.println("5.-Dulcería");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Peliculas Cineplanet 🎬📽️");
                boolean Micliente=TipoPsocio(tipocliente);
                break;
            case 2:
                System.out.println("Ubicacion de Cines 🛰️");
                Cines(sc);
                break;
            case 3:
                System.out.println("Mostramdo Promociones 😎");
                Promociones(sc);
                break;
            case 4:
                System.out.println("Socio : Beneficios");
                Socio(sc);
                break;
            case 5:
                System.out.println("Dulceria 🍿🥤");
                Micliente=TipoPsocio(tipocliente);
                Dulceria(sc,Micliente);
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void Socio (Scanner sc){
        //SOCIO
        System.out.println("ZONA SOCIO 👤");
        System.out.println("Llegó SOCIO ++");
        System.out.println("Descubre socio+");
        System.out.println("Por ser Socio Cineplanet disfruta de promociones exclusivas en restaurantes, viajes, compras y mucho más");
        System.out.println("Elige entre las siguientes opciones");
        System.out.println("1 --> Explorar socio+");
        System.out.println("2 --> Visitas");
        System.out.println("3 --> Puntos");
        System.out.println("4 --> Socio Clasica");
        System.out.println("5 --> Socio Plata");
        System.out.println("6 --> Socio Oro");
        System.out.println("7 --> Socio Black");
        System.out.println("8 --> SALIR");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //EXPLORAR SOCIO
                System.out.println("INGRESASTE A SOCIO+");
                System.out.println("Elige entre las siguientes opciones");
                System.out.println("1 --> TODOS");
                System.out.println("2 --> Moda y belleza");
                System.out.println("3 --> Alimentos");
                System.out.println("4 --> Productos Financieros ");
                System.out.println("5 --> Telecomunicaciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("TODOS");
                        System.out.println("15% de dscto. en toda la tienda");
                        System.out.println("Hasta 25% OFF en maquillaje, skincare y fragancias");
                        System.out.println("Combo Socio Cineplanet");
                        System.out.println("19% de Dscto. en Promo Socio Popeyes");
                        System.out.println("Combowok Socio Cineplanet");
                        System.out.println("Combowok Socio Cineplanet para compartir");
                        System.out.println("Papa John's Socio Cineplanet");
                        System.out.println("Productos financieros");
                        System.out.println("Renueva tu SOAT a un precio especial con Interseguro");
                        System.out.println("CUY");
                        System.out.println("25% de descuento en planes Cuy Móvil");
                        break;
                    case 2:
                        System.out.println("Moda y belleza");
                        System.out.println("Opcion 1: SIFRAH");
                        System.out.println("Opcion 2: SENTUA");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("15% de dscto. en toda la tienda");
                                break;
                            case 2:
                                System.out.println("Hasta 25% OFF en maquillaje, skincare y fragancias");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                        break;
                    case 3:
                        System.out.println("Alimentos");
                        System.out.println("Opcion 1: BEMBOS");
                        System.out.println("Opcion 2: POPEYES");
                        System.out.println("Opcion 3: CHINAWOK");
                        System.out.println("Opcion 4: PAPAJOHNS");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Combo Socio Cineplanet");
                                break;
                            case 2:
                                System.out.println("Combo Socio Cineplanet");
                                System.out.println("19% de Dscto. en Promo Socio Popeyes");
                                break;
                            case 3:
                                System.out.println("Combowok Socio Cineplanet");
                                System.out.println("Combowok Socio Cineplanet para compartir");
                                break;
                            case 4:
                                System.out.println("Papa John's Socio Cineplanet");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                        break;
                    case 4:
                        System.out.println("Productos financieros");
                        System.out.println("Renueva tu SOAT a un precio especial con Interseguro");
                        break;
                    case 5:
                        System.out.println("Telecomunicaciones");
                        System.out.println("CUY");
                        System.out.println("25% de descuento en planes Cuy Móvil");
                        break;
                    default:
                        System.out.println("Opcion no valida");

                }
                break;
            case 2:
                //VISITAS

                System.out.println("Acumula visitas para pasar a la siguiente categoria y acceder a mis beneficios");
                System.out.println("Se podra acumular maximo 1 visita al día");
                System.out.println("Observa el siguiente ejemplo");
                System.out.println("HARRY ES SOCIO CINEPLANET CLÁSICO");
                System.out.println("Opcion 1: Cuando compras entradas para una función CLASICA --> 1+visita");
                System.out.println("Opcion 2: Cuando compras entradas para una función PRIME --> 2+visita");
                break;
            case 3:
                //PUNTOS
                System.out.println("Acumula puntos para canjear entradas y combos a precios de descuento");
                System.out.println("Gana 1 punto por cada entrada comprada --> Entrada socio: +5puntos canjea una entrada 2D a un precio especial");
                System.out.println("Gana el 10% del monto gastado en Dulceria --> Combo Socio: +5puntos Canjea un combo a un precio especial");
                System.out.println("Ej. Si compro S/. 25, recibo 2.5puntos");
                break;
            case 4:
                //SOCIO CLASICA
                System.out.println("Lunes y Miercoles a precio de Martes [2D]");
                System.out.println("Cartelera al correo electronico");
                System.out.println("Combo Socio a precio especial por cada 5 puntos --canjéalo de lunes a viernes--");
                System.out.println("Entrada Socio a precio especial por cada 5 puntos --canjéalo de lunes a viernes--");
                System.out.println("Regalo de cumpleaños 1 entrada 2D -- usalo hasta 3 dias despues de tu cumple");

                break;
            case 5:
                //SOCIO PLATA
                System.out.println("Lunes y Miercoles a precio de Martes [2D]");
                System.out.println("Cartelera al correo electronico");
                System.out.println("Combo Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Entrada Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Regalo de cumpleaños 2 entrada 2D + Combo Especial -- usalo hasta 6 dias despues de tu cumple");
                System.out.println("Combo Plata a precio especial--1 cancha grande + 1 bebida mediana 21Oz");
                break;
            case 6:
                //SOCIO ORO
                System.out.println("Lunes y Miercoles a precio de Martes [2D]");
                System.out.println("Cartelera al correo electronico");
                System.out.println("Combo Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Entrada Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Regalo de cumpleaños 2 entrada 2D + Combo Especial -- usalo hasta 14 dias despues de tu cumple");
                System.out.println("Combo Oro Símple, Dúo o Trío");
                break;
            case 7:
                //SOCIO BLACK
                System.out.println("Lunes y Miercoles a precio de Martes [2D] -- valido para 2D, 3D Y Prime");
                System.out.println("Cartelera al correo electronico");
                System.out.println("Combo Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Entrada Socio a precio especial por cada 5 puntos --canjéalo de lunes a domingo--");
                System.out.println("Regalo de cumpleaños 2 entrada 2D + Combo Especial -- usalo hasta 30 dias despues de tu cumple");
                System.out.println("Combo Black -- Canjealo las veces que quieras");
                System.out.println("Entrada Black - Una entrada gratis al inicio del mes [valida por 1 mes]");
                System.out.println("Regalo de Bienvenida 2 Entradas 2D-- [Validas por 2 meses]");
                break;
            case 8:
                //SALIR
                break;
            default:
                System.out.println("Opcion no valida");

        }
    }

    public static void Promociones(Scanner sc) {
        System.out.println("----Promociones Cineplanet----");
        System.out.println("1.-PROMOS 2x1 CON ENTEL");
        System.out.println("2.-TICKETS MANDALORIAN Y GROGU");
        System.out.println("3.-TICKETS UMAMUSUME");
        System.out.println("4.-MERCH UMAMUSUME");
        System.out.println("5.-TICKETS TXT");
        System.out.println("6.-SORTEO TXT");
        System.out.println("7.-EXPERIENCIA GAMING");
        System.out.println("8.-FIXTURES");
        System.out.println("9.-CARDS TOP GUN");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Eres cine,eres Entel...");
                System.out.println("Vale hasta el 31/12/26 y/o hasta agotar stock para clientes Entel con líneas activas" +
                        "(Entel prepago, postpago, hogar y corporativas móvil, BAM, BAFI)" +
                        "• Stock mínimo a nivel nacional: 300,000 entradas." +
                        "• Válido solo ingresando con su usuario Socio Cineplanet");
                break;
            case 2:
                System.out.println("Llévate tickets conmemorativos.");
                System.out.println("La dinámica aplica para la entrega de ticket coleccionable de The Mandalorian and Grogu a los primeros asistentes desde" +
                        "la primera función del 21 de mayo o hasta agotar stock, según cada complejo.");
                break;
            case 3:
                System.out.println("Llévate tickets conmemorativos de Umamusume Prety Derby.");
                System.out.println("La dinámica aplica para la entrega de Tickets Conmemorativos a los primeros asistentes de la primera función de" +
                        "estreno, o hasta agotar stock, según cada complejo.");
                break;
            case 4:
                System.out.println("Llévate merch de Umamusume Prety Derby.");
                System.out.println("Aplica para las compras realizadas en" +
                        "preventa hasta el 13 de mayo como Socio Cineplanet para las películas" +
                        "UMAMUSUME PRETTY DERBY.");
                break;
            case 5:
                System.out.println("Llévate tickets especiales de TXT.");
                System.out.println("La dinámica aplica para la entrega de Tickets Especiales a los primeros asistentes de la primera función de estreno, o" +
                        "hasta agotar stock, según cada complejo.");
                break;
            case 6:
                System.out.println("Participa pot una lightstick o un album.");
                System.out.println("Aplica para las compras realizadas en preventa" +
                        "desde el 5 al 23 de mayo como Socio Cineplanet para la película TXT MOA CON IN" +
                        "JAPAN: LIVE VIEWING y que sigan a @cineplanetoficial y @kasooperu en" +
                        "Instagram.");
                break;
            case 7:
                System.out.println("Enterate como participar de una experiencia gaming.");
                System.out.println("La dinámica aplica para los Socios Cineplanet que hayan realizado la compra de su “Combo Fanta Gaming” del 06 al 18 de" +
                        "mayo. Promoción válida para mayores de 18 años.");
                break;
            case 8:
                System.out.println("Llévate fixtures de la pelicula.");
                System.out.println("“Entrega de Fixtures The Mandalorian and Grogu”, válido desde el jueves 21 de mayo en los complejos y" +
                        "horarios indicados en el Anexo Oficial de Programación o hasta agotar stock, según cada complejo.");
                break;
            case 9:
                System.out.println("Llévate cards coleccionables de Top Gun 40° aniversario.");
                System.out.println("“Entrega de Card Coleccionable de Top Gun 40 aniversario”, válido desde el miércoles 13 de mayo en los" +
                        "complejos y horarios indicados en el Anexo Oficial de Programación o hasta agotar stock, según cada complejo.");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public static void Cines(Scanner sc) {
        System.out.println("========= CINES =========");
        System.out.println("TODAS LAS CIUDADES ");
        System.out.println("----------------------------");
        System.out.println("(Elija por números)");
        System.out.println("1.- Lima");
        System.out.println("2.- Arequipa");
        System.out.println("3.- Cajamarca");
        System.out.println("4.- Chiclayo");
        System.out.println("5.- Cusco");
        System.out.println("6.- Huancayo");
        System.out.println("7.- Huánuco");
        System.out.println("8.- Juliaca");
        System.out.println("9.- Piura");
        System.out.println("10.- Pucallpa");
        System.out.println("11.- Puno");
        System.out.println("12.- Tacna");
        System.out.println("13.- Trujillo");
        System.out.println("14.- Salir");
        System.out.println("----------------------------");
        int cuidad = sc.nextInt();
        switch (cuidad) {
            case 1:
                System.out.println("============== LIMA ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Alcazar Av. Santa Cruz 814-816 2D, REGULAR, 3D");
                System.out.println("2.- CP Brasil Av. Brasil 714 - 792 Piso 3 2D, 3D, REGULAR");
                System.out.println("3.- CP  CP Centro Civico Av. Inca Garcilazo de la Vega 2D, REGULAR, 3D");
                int lima = sc.nextInt();
                switch (lima) {
                    case 1:
                        peliculas(sc, "CP Alcazar Av. Santa Cruz 814-816 2D, REGULAR, 3D");
                        break;

                    case 2:
                        peliculas(sc, "CP Brasil Av. Brasil 714 - 792 Piso 3 2D, 3D, REGULAR");
                        break;

                    default:
                        System.out.println("CP  CP Centro Civico Av. Inca Garcilazo de la Vega 2D, REGULAR, 3D");
                }
                break;
            case 2:
                System.out.println("============== AREQUIPA ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Arequipa Mall Plaza Av. Ejercito 793 Cayma 2D, 3D, REGULAR");
                System.out.println("2.- CP Arequipa Paseo Central Av. Arturo Ibañez S/N,2D, 3D, REGULAR");
                System.out.println("3.- CP Arequipa Real Plaza Av. Ejercito 1009 Cayma 2D, REGULAR, 3D");
                int arequipa = sc.nextInt();
                switch (arequipa) {

                    case 1:
                        peliculas(sc, "CP Arequipa Mall Plaza Av. Ejercito 793 Cayma 2D, 3D, REGULAR");
                        break;

                    case 2:
                        peliculas(sc, "CP Arequipa Paseo Central Av. Arturo Ibañez S/N,2D, 3D, REGULAR");
                        break;
                    case 3:
                        peliculas(sc, "CP Arequipa Real Plaza Av. Ejercito 1009 Cayma 2D, REGULAR, 3D");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 3:
                System.out.println("============== CAJAMARCA ===============");
                System.out.println("(Tiene la siguiente opción)");
                System.out.println("1.- CP Cajamarca Av. Vía de Evitamiento Norte 2D, REGULAR, 3D");
                int cajamarca = sc.nextInt();
                switch (cajamarca) {

                    case 1:
                        peliculas(sc, "CP Cajamarca Av. Vía de Evitamiento Norte 2D, REGULAR, 3D");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 4:
                System.out.println("============== CHICLAYO ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Chiclayo Mall Aventura AV. PANAMERICANA 639 -INT 01 2D, 3D, REGULAR");
                System.out.println("2.- CP Chiclayo Real Plaza Av. Miguel de Cervantes 300 2D, 3D, REGULAR");
                int chiclayo = sc.nextInt();
                switch (chiclayo) {
                    case 1:
                        peliculas(sc, "CP Chiclayo Mall Aventura AV. PANAMERICANA 639 -INT 01 2D, 3D, REGULAR");
                        break;

                    case 2:
                        peliculas(sc, "CP Chiclayo Real Plaza Av. Miguel de Cervantes 300 2D, 3D, REGULAR");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 5:
                System.out.println("============== CUSCO ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Cusco Av. Collasuyo 2964 Lote A 2D, REGULAR, 3D, XTREME");
                int cusco = sc.nextInt();
                switch (cusco) {
                    case 1:
                        peliculas(sc, "CP Cusco Av. Collasuyo 2964 Lote A 2D, REGULAR, 3D, XTREME");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 6:
                System.out.println("============== HUANCAYO ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Huancayo Real Plaza Av. Ferrocarril Cuadra 8 S/N 2D, REGULAR, 3D");
                int huancayo = sc.nextInt();
                switch (huancayo) {
                    case 1:
                        peliculas(sc, "CP Huancayo Real Plaza Av. Ferrocarril Cuadra 8 S/N 2D, REGULAR, 3D");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 7:
                System.out.println("============== HUÁNUCO ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Huanuco Real Plaza Jr. Independencia s/n 2D, 3D, REGULAR");
                int huanuco = sc.nextInt();
                switch (huanuco) {
                    case 1:
                        peliculas(sc, "CP Huánuco Real Plaza");
                        break;

                    default:
                        System.out.println("CP Huanuco Real Plaza Jr. Independencia s/n 2D, 3D, REGULAR");
                }
                break;
            case 8:
                System.out.println("============== JULIACA ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Juliaca Calle Tumbes 395 - San Roman 2D, REGULAR, 3D");
                int juliaca = sc.nextInt();
                switch (juliaca) {
                    case 1:
                        peliculas(sc, "CP Juliaca");
                        break;

                    default:
                        System.out.println("CP Juliaca Calle Tumbes 395 - San Roman 2D, REGULAR, 3D");
                }
                break;
            case 9:
                System.out.println("============== PIURA ===============");
                System.out.println("(Elija por números por favor)");
                System.out.println("1.- CP Piura Jr. Huancavelica 537 - Piura 2D, REGULAR");
                System.out.println("2.- CP Piura Real Plaza Av.Sanchez Cerro 234-Z.I 2D, REGULAR, 3D");
                int piura = sc.nextInt();
                switch (piura) {
                    case 1:
                        peliculas(sc, "CP Piura Jr. Huancavelica 537 - Piura 2D, REGULAR");
                        break;

                    case 2:
                        peliculas(sc, "CP Piura Real Plaza Av.Sanchez Cerro 234-Z.I 2D, REGULAR, 3D");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 10:
                System.out.println("============== PUCALLPA ===============");
                System.out.println("(Tenemos la siguiente opcion)");
                System.out.println("1.- CP Pucallpa Av.Centenario s/n M2 365 Lt 16 2D, REGULAR");
                int pucallpa = sc.nextInt();
                switch (pucallpa) {
                    case 1:
                        peliculas(sc, "CP Pucallpa Av.Centenario s/n M2 365 Lt 16 2D, REGULAR");
                        break;

                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 11:
                System.out.println("============== PUNO ===============");
                System.out.println("Tenemos la siguiente opcion");
                System.out.println("1.- CP Puno Av. Los Incas s/n 2D, REGULAR, 3D");
                int puno = sc.nextInt();
                switch (puno) {
                    case 1:
                        peliculas(sc, "CP Puno Av. Los Incas s/n 2D, REGULAR, 3D");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 12:
                System.out.println("============== TACNA ===============");
                System.out.println("Tenemos la siguiente opcion");
                System.out.println("1.- CP Tacna Calle Cuzco 36 2D, 3D, REGULAR");
                int tacna = sc.nextInt();
                switch (tacna) {
                    case 1:
                        peliculas(sc, "CP Tacna  Calle Cuzco 36 2D, 3D, REGULAR");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 13:
                System.out.println("============== TRUJILLO ===============");
                System.out.println("Tenemos la siguiente opcion");
                System.out.println("1.- CP Trujillo Centro Calle Mariscal de Orbegoso 239 2D, 3D, REGULAR");
                int trujillo = sc.nextInt();
                switch (trujillo) {
                    case 1:
                        peliculas(sc, "CP Trujillo Centro Calle Mariscal de Orbegoso 239 2D, 3D, REGULAR");
                        break;
                    default:
                        System.out.println("Cine inválido");
                }
                break;
            case 14:
                System.out.println("Gracias por visitar CINEPLANET");
                break;
            default:
                System.out.println("Cuidad no valida");
        }
    }

    public static boolean TipoPsocio (String tipocliente){
        boolean socio;
        if(tipocliente.equals("Socio")){
            socio=true;
        }
        else{
            socio=false;
        }
        return socio;
    }

    public static int Dulceria(Scanner sc, boolean socio){
        System.out.println("Categorias");
        System.out.println("1.-Promos");
        System.out.println("2.-Combos");
        System.out.println("3.-Canchitas");
        System.out.println("4.-Complementos");
        System.out.println("5.-Bebidas");
        if(socio){
            System.out.println("6.-Combos socio");
        }
        double MiPrecio=0.0;
        int opcion= sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("1.-Dulceras");
                System.out.println("2.-De pelicula");
                opcion= sc.nextInt();
                MiPrecio=PrecioPROMOS(opcion,sc);
                break;
            case 2:
                System.out.println("1.-Para uno");
                System.out.println("2.-Para compartir");
                opcion= sc.nextInt();
                MiPrecio=PrecioCOMBOS(opcion,sc);
                break;
            case 3:
                System.out.println("1.-Canchita Mediana");
                System.out.println("2.-Canchita Grande");
                System.out.println("3.-Canchita Gigante");
                opcion= sc.nextInt();
                MiPrecio=PrecioCanchitas(opcion);
                break;
            case 4:
                System.out.println("1.-SUBLIME POPS");
                System.out.println("2.-Hot Dog Jumbo");
                System.out.println("3.-NACHOS CON QUESO CHEDDAR");
                System.out.println("4.-KIT KAT WHITE");
                System.out.println("5.-KIT KAT 4 FINGERS MILK");
                System.out.println("6.-QUESO ADICIONAL 1.5 OZ");
                opcion= sc.nextInt();
                MiPrecio=PrecioComplementos(opcion);
                break;
            case 5:
                System.out.println("1.-CCBebida Mediana");
                System.out.println("2.-CCBebida Grande");
                System.out.println("3.-Agua San Luis sin gas");
                opcion= sc.nextInt();
                MiPrecio=PrecioBebidas(opcion);
                break;
            case 6:
                if(socio) {
                    System.out.println("Combo Socio Clásico OL\n" +
                            "A precio especial. 1 Bebida mediana 21oz + Canchita salada grande.");
                    MiPrecio=PrecioComsocio(opcion);
                }
                else{
                    System.out.println("Opcion no valida");
                }
                break;
            default:
                System.out.println("Opcion no valida");
        }
        if(MiPrecio!=0.0) {
            Total_pagarDulceria(MiPrecio, sc);
        }
        return opcion;
    }

    public static double PrecioPROMOS(int opcion,Scanner sc){
        double precio=0.0;
        switch (opcion) {
            case 1:
                System.out.println("1.-COMBO DOS + 2M&M");
                System.out.println("2.-COMBO UNO + M&M");
                System.out.println("3.-COMBO 2 + 2 SUBLIME POPS");
                System.out.println("4.-COMBO 1 + SUBLIME POPS");
                opcion= sc.nextInt();
                switch (opcion) {
                    case 1:
                        precio=46.00;
                        break;
                    case 2:
                        precio=24.00;
                        break;
                    case 3:
                        precio=47.00;
                        break;
                    case 4:
                        precio=26.00;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;
            case 2:
                System.out.println("1.-COMBO 2 + VASO MANDALORIAN");
                System.out.println("2.-COMBO 2 + PALOMERO GROGU");
                opcion= sc.nextInt();
                switch (opcion) {
                    case 1:
                        precio=87.00;
                        break;
                    case 2:
                        precio=163.00;
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

    public static double PrecioCOMBOS(int opcion,Scanner sc){
        double precio=0.0;
        switch (opcion) {
            case 1:
                System.out.println("1.-Combo 1\n" +
                        "1 Canchita Grande + 1 Bebida (32oz)");
                System.out.println("2.-COMBO HOT DOG\n" +
                        "1 Hot Dog con papas al hilo y cremas + 1 Bebida (32oz)");
                opcion= sc.nextInt();
                switch (opcion) {
                    case 1:
                        precio=20.50;
                        break;
                    case 2:
                        precio=19.00;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;
            case 2:
                System.out.println("1.-Combo 2\n" +
                        "1 Canchita Gigante + 2 Bebidas (32oz)");
                System.out.println("2.-Combo Familiar\n" +
                        "1 Canchita Gigante + 4 Bebidas (32oz)");
                System.out.println("3.-Com.2 Dob.Gig.\n" +
                        "2 Canchitas Gigantes + 2 Bebidas (32oz)");
                System.out.println("4.-Combo de Película\n" +
                        "1 Canchita Grande + 2 Bebidas (21oz).");
                opcion= sc.nextInt();
                switch (opcion) {
                    case 1:
                        precio=33.00;
                        break;
                    case 2:
                        precio=163.00;
                        break;
                    case 3:
                        precio=40.00;
                        break;
                    case 4:
                        precio=20.50;
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

    public static double PrecioCanchitas(int opcion){
        double precio=0.0;
        switch (opcion){
            case 1:
                precio=13.00;
                break;
            case 2:
                precio=15.00;
                break;
            case 3:
                precio=21.50;
                break;
            default:
        }
        return precio;
    }

    public static double PrecioComplementos(int opcion){
        double precio=0.0;
        switch (opcion){
            case 1:
                precio=10.00;
                break;
            case 2:
                precio=13.50;
                break;
            case 3:
                precio=13.50;
                break;
            case 4:
                precio=9.00;
                break;
            case 5:
                precio=9.00;
                break;
            case 6:
                precio=4.50;
                break;
            default:
        }
        return precio;
    }

    public static double PrecioBebidas(int opcion){
        double precio=0.0;
        switch (opcion){
            case 1:
                precio=10.50;
                break;
            case 2:
                precio=12.00;
                break;
            case 3:
                precio=4.00;
                break;
            default:
        }
        return precio;
    }

    public static double PrecioComsocio(int opcion){
        double precio=15.0;
        return precio;
    }

    public static double Total_pagarDulceria(double precio,Scanner sc){
        System.out.println("Ingrese la cantidad");
        int cantidad= sc.nextInt();
        double totalp=precio*cantidad;
        System.out.println("Total a pagar: "+totalp);
        return totalp;
    }
    //PELICULAS
    //REVISA LO DE ABAJO
    public static void peliculas(Scanner sc, String cine) {
        System.out.println("============== PELICULAS ===============");
        System.out.println("1.- Volcan Fuego Bajo Tierra");
        System.out.println("2.- Coyotes");
        System.out.println("3.- Top Gun Maverick");
        System.out.println("4.- Billie Eilish");
        int pelicula = sc.nextInt();
        switch (pelicula) {
            case 1:
                formato(sc, "Volcan Fuego Bajo Tierra", cine);
                break;

            case 2:
                formato(sc, "Coyotes", cine);
                break;

            case 3:
                formato(sc, "Top Gun Maverick", cine);
                break;

            case 4:
                formato(sc, "Billie Eilish", cine);
                break;
            default:
                System.out.println("Película inválida");
        }
    }

    public static void formato(Scanner sc, String pelicula, String cine) {
        System.out.println("============== FORMATO ===============");
        System.out.println("1.- 2D");
        System.out.println("2.- 3D");
        System.out.println("3.- REGULAR");
        int opcion = sc.nextInt();
        String formato = " ";
        switch (opcion) {
            case 1:
                formato = "2D";
                break;

            case 2:
                formato = "3D";
                break;

            case 3:
                formato = "REGULAR";
                break;

            default:
                System.out.println("Formato inválido");
                return;
        }
        horarios(sc, pelicula, formato, cine);
    }

    public static void horarios(Scanner sc, String pelicula, String formato, String cine) {
        System.out.println("=======================================");
        System.out.println(pelicula);
        System.out.println(formato + ", DOBLADA");
        System.out.println(cine);
        System.out.println("Hoy, 18 de May, 2026");
        System.out.println("21:50");
        System.out.println("SALA 5");
        System.out.println("======================================================");
        entradas(sc, pelicula, formato, cine);
    }

    public static void entradas(Scanner sc, String pelicula, String formato, String cine) {
        System.out.println("============== ENTRADAS GENERALES  ===============");
        System.out.println("1.- General " + formato + " OL");
        System.out.println("Incluye servicio online");
        System.out.println("S/20.00");
        System.out.println("====================================================");
        System.out.println("2.- Mayores 60 años " + formato + " OL");
        System.out.println("Incluye servicio online");
        System.out.println("S/19.00");
        System.out.println("====================================================");
        System.out.println("3.- Niños " + formato + " OL");
        System.out.println("Para niños de 2 a 11 años");
        System.out.println("S/19.00");
        System.out.println("====================================================");
        System.out.println("4.- Boleto Conadis " + formato + " OL");
        System.out.println("Presentar DNI y Carnet Conadis");
        System.out.println("S/12.50");
        int tipoEntrada = sc.nextInt();
        double precio = 0;
        String entrada = "";
        switch (tipoEntrada) {
            case 1:
                precio = 20.00;
                entrada = "General";
                break;
            case 2:
                precio = 19.00;
                entrada = "Adulto Mayor";
                break;
            case 3:
                precio = 19.00;
                entrada = "Niños";
                break;
            case 4:
                precio = 12.50;
                entrada = "Conadis";
                break;
            default:
                System.out.println("Entrada inválida");
                return;
        }
        System.out.println("Ingrese la cantidad de entradas");
        int cantidad = sc.nextInt();
        double total = precio * cantidad;
        beneficios(sc, pelicula, formato, cine, entrada, cantidad, total);
    }

    public static void beneficios(Scanner sc, String pelicula, String formato, String cine, String entrada, int cantidad, double total) {
        System.out.println("============= TUS BENEFICIOS =============");
        System.out.println("Exclusivo con tu tarjeta American Express");
        System.out.println("============================================");
        System.out.println("1.- 50% Promo Amex 2025");
        System.out.println("2.- Continuar sin promoción");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            total = total / 2;
            System.out.println("Promocion aplicada");
        }
        resumen(pelicula, formato, cine, entrada, cantidad, total);
    }

    public static void resumen(String pelicula, String formato, String cine, String entrada, int cantidad, double total) {
        System.out.println("================== RESUMEN ==================");
        System.out.println("Película: " + pelicula);
        System.out.println("Formato: " + formato);
        System.out.println("Cine: " + cine);
        System.out.println("Entrada: " + entrada);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total s/. " + total);
        System.out.println("Gracias por comprar en CINEPLANET");
    }
