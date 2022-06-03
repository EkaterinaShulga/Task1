import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        System.out.println("Введите логин и пароль ");
        System.out.println();
        enterInformation("lo/gin", "parol", "copyPassword");

    }

    public static boolean enterInformation(String getLogin, String getPassword, String getConfirmPassword) {

        char[] charLogin = getLogin.toCharArray();
        char[] charPassword = getPassword.toCharArray();
        char[] charConfirmPassword = getConfirmPassword.toCharArray();

        if (charLogin.length >= 20 || charPassword.length > 20) {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                return false;
            } finally {
                System.out.println("Если замечаний нет - пароль и его повтор совпадают. Если замечания есть - их нужно исправить, удачи.");
            }
        }
        checkLoginAndPassword(charLogin);

        System.out.println();

        checkLoginAndPassword(charPassword);
        System.out.println();

        System.out.println("Продублируйте введенный пароль ");
        if (!Arrays.equals(charPassword, charConfirmPassword)) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException s) {
                System.out.println("Пароль и повтор пороля не совпадают. Попробуйте еще раз.");
                return false;
            } finally {
                System.out.println("Если замечаний нет - пароль и его повтор совпадают. Если замечания есть - их нужно исправить, удачи.");
            }
        }
        return true;
    }
    public static void checkLoginAndPassword(char[] word) {
        for (int i = 0; i < word.length; i++) {
            if (Character.isDigit(word[i]) || word[i] == '_' || word[i] >= 65 & word[i] <= 90
                    || word[i] >= 97 & word[i] <= 122) {
            }
            else {
                try {
                    throw new Exception();
                } catch (Exception a) {
                    System.out.println("При указании логина или пароля вы ввели не верный символ, допустимы только цифры, латинские буквы и знак подчеркивания.");
                } finally {
                    System.out.println("Если замечаний нет -  логин и пароль введены верно. Если замечания есть - их нужно исправить, удачи.");
                }
            }
        }
    }
}

