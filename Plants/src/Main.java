import java.util.*;

// PAIR TALIP
public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        boolean state = (mode.equals("Night") || mode.equals("Fog"));
        String input;
        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                // add more plants here
                case "Coffee Bean":
                    for (Plant p : plants) {
                        if (p instanceof Mushroom && !((Mushroom) p).isAwake()) {
                            ((Mushroom) p).awaken(new Plant.CoffeeBean());
                            break;
                        }
                    }
                    break;
                case "Sun-shroom":
                    plants.add(new Mushroom.SunShroom(state));
                    break;
                case "Puff-shroom":
                    plants.add(new Mushroom.PuffShroom(state));
                    break;
                case "Doom-shroom":
                    plants.add(new Mushroom.DoomShroom(state));
                    break;
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Twin Sunflower":
                    for (Plant p: plants) {
                        if (p instanceof Plant.Sunflower) {
                            int index = plants.indexOf(p);
                            plants.set(index, ((Plant.Sunflower) p).upgrade());
                            break;
                        }
                    }
                    break;
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail":
                    for (Plant p : plants) {
                        if (p instanceof Plant.LilyPad) {
                            int index = plants.indexOf(p);
                            plants.set(index, ((Plant.LilyPad) p).upgrade());
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));

        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            int totalSunProducer = 0, totalSunsAcquired = 0, totalPlantAttacker = 0, totalDamageProduce = 0, totalInstantKiller = 0;
            switch (input) {
                case "DONE":
                    break;
                // add more cases here
                case "Produce Sun":
                    // add implementation here
                    for (Plant p : plants) {
                        if (p instanceof SunProducer && p.isAlive()) {
                            totalSunProducer++;
                            totalSunsAcquired += ((SunProducer) p).produce_sun();
                        }
                    }
                    if (totalSunProducer < 1) {
                        System.out.println("You have no attackers");
                    } else {
                        System.out.println(totalSunProducer + " sun producers gather " + totalSunsAcquired + " suns");
                    }
                    break;
                case "Attack":
                    // add implementation here
                    for (Plant p : plants) {
                        if (p instanceof Attacker && p.isAlive()) {
                            totalPlantAttacker++;
                            totalDamageProduce += ((Attacker) p).attack();
                        }
                    }
                    if (totalPlantAttacker < 1) {
                        System.out.println("You have no attackers");
                    } else {
                        System.out.println(totalPlantAttacker + " attackers dealing " + totalDamageProduce + " damage");
                    }
                    break;
                case "Attacker Status":
                    // add implementation here
                    for (Plant p : plants) {
                        if (p instanceof Attacker && p.isAlive()) {
                            RangeType rangeType = ((Attacker) p).rangeType();
                            totalPlantAttacker++;
                            switch (rangeType) {
                                case SINGLE_LINE:
                                    System.out.println(p.name + " can attack on a single line");
                                    break;
                                case AOE:
                                    System.out.println(p.name + " can attack any enemies from anywhere");
                                    break;
                                case LIMITED_RANGE:
                                    System.out.println(p.name + " can attack only when enemy is nearby");
                                    break;
                                case FREE_RANGE:
                                    System.out.println(p.name + " can attack using area-of-effect");
                                    break;
                                default:
                                    System.out.println("Invalid plant range type");
                            }
                        }
                    }
                    if (totalPlantAttacker < 1) {
                        System.out.println("You have no attackers");
                    }
                    break;
                case "Instant Kill Status":
                    // add implementation here
                    for (Plant p : plants) {
                        if (p instanceof InstantKiller && p.isAlive()) {
                            KillType killType = ((InstantKiller) p).killType();
                            totalInstantKiller++;
                            switch (killType) {
                                case INSTANTLY:
                                    System.out.println(p.name + " can kill instantly");
                                    break;
                                case ON_CONTACT:
                                    System.out.println(p.name + " can kill on contact");
                                    break;
                                default:
                                    System.out.println("Invalid plant kill type");
                            }
                        }
                    }
                    if (totalInstantKiller < 1) {
                        System.out.println("You have no plants which can kill instantly");
                    }
                    break;
                case "Sort by HP":
                    // add implementation here
                    plants.sort(new Plant.plantSortByHp());
                    for (Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Name":
                    // add implementation here
                    Collections.sort(plants);
                    for (Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                case "Sort by Sun Cost":
                    // add implementation here
                    plants.sort(new Plant.plantSortBySunCost());
                    for (Plant p : plants) {
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}