import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Tester {
    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static Field getField(Object obj, String fieldName) {
        List<Field> fields = getAllFields(new LinkedList<Field>(), obj.getClass());
        for(Field f : fields){
            if (f.getName().equals(fieldName)) {
                return f;
            }
        }
        return null;
    }

    private static Method getMethod(Object obj, String methodName) {
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    public static void test(Humanoid humanoid) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter code: ");
        int code = scanner.nextInt();

        if (code == 1) {
            Field name = Tester.getField(humanoid, "name");
            Field gender = Tester.getField(humanoid, "gender");
            Field age = Tester.getField(humanoid, "age");

            if (
                    (name != null && Modifier.isPrivate(name.getModifiers())) &&
                            (gender != null && Modifier.isPrivate(gender.getModifiers())) &&
                            (age != null && Modifier.isPrivate(age.getModifiers()))
            ) {
                if (humanoid instanceof SuperHuman) {
                    Field strength = Tester.getField(humanoid, "strength");

                    if (!(strength != null && Modifier.isPrivate(strength.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                } else if (humanoid instanceof Mutant) {
                    Field hasSuperpowers = Tester.getField(humanoid, "hasSuperpowers");

                    if (!(hasSuperpowers != null && Modifier.isPrivate(hasSuperpowers.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        } else if (code == 2) {
            Method getName = Tester.getMethod(humanoid, "getName");
            Method getGender = Tester.getMethod(humanoid, "getGender");
            Method getAge = Tester.getMethod(humanoid, "getAge");

            try {
                System.out.println(getName.invoke(humanoid));
                System.out.println(getGender.invoke(humanoid));
                System.out.println(getAge.invoke(humanoid));

                if (humanoid instanceof SuperHuman) {
                    Method getStrength = Tester.getMethod(humanoid, "getStrength");
                    System.out.println(getStrength.invoke(humanoid));
                } else if (humanoid instanceof Mutant) {
                    Method getHasSuperpowers = Tester.getMethod(humanoid, "getHasSuperpowers");
                    System.out.println(getHasSuperpowers.invoke(humanoid));
                }

                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 3) {
            Method grow = Tester.getMethod(humanoid, "grow");
            Method getAge = Tester.getMethod(humanoid, "getAge");
            try {
                int ageBefore = (int)getAge.invoke(humanoid);
                grow.invoke(humanoid, 5);
                int ageAfter = (int)getAge.invoke(humanoid);
                if(ageAfter == ageBefore + 5) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 4) {
            Method changeName = Tester.getMethod(humanoid, "changeName");
            Method getName = Tester.getMethod(humanoid, "getName");
            try {
                String newName = "NewName";
                changeName.invoke(humanoid, newName);
                String nameAfter = (String)getName.invoke(humanoid);
                if(nameAfter.equals(newName)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 5 && humanoid instanceof SuperHuman) {
            Method increaseStrength = Tester.getMethod(humanoid, "increaseStrength");
            Method getStrength = Tester.getMethod(humanoid, "getStrength");
            try {
                int strengthBefore = (int)getStrength.invoke(humanoid);
                increaseStrength.invoke(humanoid, 10);
                int strengthAfter = (int)getStrength.invoke(humanoid);
                if(strengthAfter == strengthBefore + 10) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 6 && humanoid instanceof Mutant) {
            Method gainPower = Tester.getMethod(humanoid, "gainPower");
            Method getHasSuperpowers = Tester.getMethod(humanoid, "getHasSuperpowers");
            try {
                gainPower.invoke(humanoid);
                boolean hasSuperpowersAfter = (boolean)getHasSuperpowers.invoke(humanoid);
                if(hasSuperpowersAfter) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 7) {
            Method setName = Tester.getMethod(humanoid, "setName");
            Method getName = Tester.getMethod(humanoid, "getName");
            try {
                String newName = "UpdatedName";
                setName.invoke(humanoid, newName);
                String nameAfter = (String)getName.invoke(humanoid);
                if(nameAfter.equals(newName)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }
        else if (code == 8) {
            Method setGender = Tester.getMethod(humanoid, "setGender");
            Method getGender = Tester.getMethod(humanoid, "getGender");
            try {
                char newGender = 'O';
                setGender.invoke(humanoid, newGender);
                char genderAfter = (char)getGender.invoke(humanoid);
                if(genderAfter == newGender) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 9) {
            Method setAge = Tester.getMethod(humanoid, "setAge");
            Method getAge = Tester.getMethod(humanoid, "getAge");
            try {
                int newAge = 50;
                setAge.invoke(humanoid, newAge);
                int ageAfter = (int)getAge.invoke(humanoid);
                if(ageAfter == newAge) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 10) {
            Method toString = Tester.getMethod(humanoid, "toString");
            try {
                String stringRepresentation = (String)toString.invoke(humanoid);
                if(stringRepresentation.contains(humanoid.getName()) &&
                        stringRepresentation.contains(String.valueOf(humanoid.getGender())) &&
                        stringRepresentation.contains(String.valueOf(humanoid.getAge()))) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 11) {
            Method grow = Tester.getMethod(humanoid, "grow");
            Method getAge = Tester.getMethod(humanoid, "getAge");
            try {
                int initialAge = (int)getAge.invoke(humanoid);
                int years = 5;
                grow.invoke(humanoid, years);
                int ageAfter = (int)getAge.invoke(humanoid);
                if(ageAfter == initialAge + years) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        } else if (code == 12) {
            Method changeName = Tester.getMethod(humanoid, "changeName");
            Method getName = Tester.getMethod(humanoid, "getName");
            try {
                String newName = "UpdatedName";
                changeName.invoke(humanoid, newName);
                String nameAfter = (String)getName.invoke(humanoid);
                if(nameAfter.equals(newName)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }
    }
}