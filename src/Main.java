//Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Разберите строку, используя String.split.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
// "city":"Moscow", "age":"null"}
public class Main {

    public static void main(String[] args) {
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", " +
                "\"city\":\"Moscow\",\"age\":\"null\"}";
        filter = filter.substring(1, filter.length() - 2);
        String[] param = filter.split(",");
        StringBuilder students = new StringBuilder("select * from students where ");
        for (int i = 0; i <= param.length - 1; i++) {
            String[] name = param[i].trim().replace("\"", "").split(":");
            if (!name[1].trim().toLowerCase().equals("null")) {
                students.append(name[0]).append(" = '").append(name[1]).append("'").append(" and ");
            }
        }
        students.setLength(students.length() - 5);
        System.out.println(students);
    }
}
