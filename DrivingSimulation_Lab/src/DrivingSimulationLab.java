import java.util.Scanner;

public class DrivingSimulationLab {

    // Declaring and initializing Scanner type variable labeled as keyboard
    static Scanner keyboard = new Scanner(System.in);

    // Used variables
    static String user_car_entrance = "";
    static String user_input_IN_CAR = "";
    static String user_input_ENGINE_ON = "";
    static String user_input_GEAR = "";
    static String user_input_MOVEMENT = "";
    static String gear_selection = "P";
    static String additional_gear_selection_OPTION = "";
    static String engine_status = "OFF";
    static String speed_status = "";
    static int current_speed = 0;
    static int acceleration = 10;
    static int brakes = 10;
    static boolean inside_car;
    static boolean engine_is_ON;
    static boolean gear_loop;
    static boolean gear_in_D;
    static boolean gear_in_R;


    // CAR SIMULATION
    public static void CarSimulation() {

        // USER CAR ENTRANCE
        while ( !(user_car_entrance.equals("e")) ) {
            System.out.println("Press E to enter");
            user_car_entrance = keyboard.nextLine();
            user_car_entrance = user_car_entrance.toLowerCase();
        }

        // NOW YOU ARE INSIDE THE CAR
        if (user_car_entrance.equals("e")) {
            InsideCar();
        }
    }

    // INSIDE CAR
    public static void InsideCar() {
        inside_car = true;
        while (inside_car) {
            System.out.println("""
                            
                            
                --------------------   OPTIONS   --------------------
                Press Z to turn on vehicle
                Press E to exit the vehicle
                
                -----------------   CAR DASHBOARD   -----------------
                """ +
                    "Engine: " + engine_status + "\n" +
                    "SPEED: " + current_speed + " KM/H\n" +
                    "GEAR: " + gear_selection + "\n");
            user_input_IN_CAR = keyboard.nextLine();
            user_input_IN_CAR = user_input_IN_CAR.toLowerCase();

            switch (user_input_IN_CAR) {
                // TURNING ON THE ENGINE
                case "z":
                    engine_is_ON = true;
                    gear_in_D = false;
                    gear_in_R = false;
                    engine_status = "ON";

                    while (engine_is_ON) {
                        System.out.println("""
                                                            
                                                            
                            --------------------   OPTIONS   --------------------
                            Press Z to turn off vehicle
                            Press B to select gear
                                                        
                            -----------------   CAR DASHBOARD   -----------------
                            """ +
                                "Engine: " + engine_status + "\n" +
                                "SPEED: " + current_speed + " KM/H\n" +
                                "GEAR: " + gear_selection + "\n");
                        user_input_ENGINE_ON = keyboard.nextLine();
                        user_input_ENGINE_ON = user_input_ENGINE_ON.toLowerCase();

                        switch (user_input_ENGINE_ON) {
                            // TURNING OFF ENGINE
                            case "z":
                                engine_is_ON = false;
                                engine_status = "OFF";
                                gear_selection = "P";
                                break;

                            // SELECTING GEAR
                            case "b":
                                gear_selection = GearSelection();
                                break;
                        }
                    }
                    break;

                // EXITING THE VEHICLE
                case "e":
                    inside_car = false;
                    break;
            }
        }
    }

    // GEAR SELECTION
    public static String GearSelection() {
        gear_loop = true;
        while (gear_loop) {
            System.out.println("""
                                                                                            
                                                                                            
                ---------------------   GEAR   ---------------------
                P
                D
                R
                 ----------------------------------------------------
                                                                                            
                                                                                            
                                                """);
            user_input_GEAR = keyboard.nextLine();
            user_input_GEAR = user_input_GEAR.toLowerCase();

            switch (user_input_GEAR) {
                case "p":
                    gear_loop = false;
                    gear_in_D = false;
                    gear_in_R = false;
                    break;

                case "d":
                    gear_loop = false;
                    Drive("D");
                    break;

                case "r":
                    gear_loop = false;
                    Reverse("R");
                    break;

            }
        }
        return "P";
    }


    // DRIVE (D)
    public static void Drive(String gear_selection) {
        gear_in_D = true;
        gear_in_R = false;

        additional_gear_selection_OPTION = "Press B to select gear";
        while (gear_in_D) {
            System.out.println("""
                --------------------   OPTIONS   --------------------
                Press W to accelerate
                Press S to brake""");
            System.out.println(additional_gear_selection_OPTION);
            System.out.println("""
                -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                    "Engine: " + engine_status + "\n" +
                    "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                    "GEAR: " + gear_selection + "\n");
            user_input_MOVEMENT = keyboard.nextLine();
            user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

            switch (user_input_MOVEMENT) {
                case "w":
                    additional_gear_selection_OPTION = "";
                    if (current_speed <= 170) {
                        current_speed += acceleration;
                        speed_status = "";
                    } else if (current_speed == 180) {
                        speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                    }
                    break;

                case "s":
                    if (current_speed > 0) {
                        speed_status = "";
                        current_speed -= brakes;
                    }
                    if (current_speed == 0) {
                        additional_gear_selection_OPTION = "Press B to select gear";
                    }
                    break;

                case "b":
                    gear_selection = GearSelection();
                    break;
            }
        }
    }


    // REVERSE (R)
    public static void Reverse(String gear_selection) {
        gear_in_R = true;
        gear_in_D = false;

        additional_gear_selection_OPTION = "Press B to select gear";
        while (gear_in_R) {
            System.out.println("""
                                                                        
                    --------------------   OPTIONS   --------------------
                    Press W to accelerate
                    Press S to brake""");
            System.out.println(additional_gear_selection_OPTION);
            System.out.println("""
                                                                        
                    -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                    "Engine: " + engine_status + "\n" +
                    "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                    "GEAR: " + gear_selection + "\n");
            user_input_MOVEMENT = keyboard.nextLine();
            user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

            switch (user_input_MOVEMENT) {
                case "w":
                    additional_gear_selection_OPTION = "";
                    if (current_speed <= 30) {
                        current_speed += acceleration;
                        speed_status = "";
                    } else if (current_speed == 40) {
                        speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                    }
                    break;

                case "s":
                    if (current_speed > 0) {
                        speed_status = "";
                        current_speed -= brakes;
                    }
                    if (current_speed == 0) {
                        additional_gear_selection_OPTION = "Press B to select gear";
                    }
                    break;

                case "b":
                    gear_selection = GearSelection();
                    break;
            }
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        CarSimulation();
    }
}