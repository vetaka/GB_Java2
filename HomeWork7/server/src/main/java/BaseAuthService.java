import java.util.HashMap;

public class BaseAuthService implements AuthService{

    HashMap<String, String> users = new HashMap<>();
// база клиентов
    public BaseAuthService(){
        users.put("Vasya", "password");
        users.put("Toto", "pass");
        users.put("Foo", "foopass");
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {

        if(users.containsKey(login)&&users.get(login).equals(password)) {
            System.out.println("return "+login);
            return login;
        }
        return null;

    }
}
//import java.util.ArrayList;
//import java.util.List;
//// Класс Сервиса_Аутентификации_Базы_клиентов (имплементирует интерфейс AuthService)
//public class BaseAuthService implements AuthService {
//    // внутренний класс Ввод
//    private class Entry {
//        private String login;
//        private String pass;
//        private String nick;
//        // конструктор класса Ввод
//        public Entry(String login, String pass, String nick) {
//            this.login = login;
//            this.pass = pass;
//            this.nick = nick;
//        }
//    }
//
//    // объявление переменной списка объектов типа Ввод
//    private List<Entry> entries;
////    // переопределение методов Старт и Стоп интерфейса AuthService
////    @Override
////    public void start() {
////        System.out.println("Сервис аутентификации запущен");
////    }
////
////    @Override
////    public void stop() {
////        System.out.println("Сервис аутентификации остановлен");
////    }
//
//    // конструктор основного класса Сервиса_Аутентификации_в_Базе_клиентов
//    public BaseAuthService() {
//        // заполняем список объектов типа Ввод:
//        entries = new ArrayList<>();
//        entries.add(new Entry("login1", "pass1", "nick1"));
//        entries.add(new Entry("login2", "pass2", "nick2"));
//        entries.add(new Entry("login3", "pass3", "nick3"));
//    }
//
//    // переопределение метода Получить_Ник_по_Логину_и_Паролю интерфейса AuthService
//    @Override
//    public String getNicknameByLoginAndPassword(String login, String pass) {
//        // перебираем список entries и ищем совпадение логина и пароля с присланными в аргументах
//        for (Entry o : entries) {
//            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick; // если находим возвращаем ник
//        }
//        return null;
//    }
//}
