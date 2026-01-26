// DIP FOLLOWED:

// -------------------- Abstraction --------------------
interface Database {
    void save(String data);
}

// -------------------- Low-level Module (MySQL) --------------------
class MySQLDatabase implements Database {

    @Override
    public void save(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES ('" + data + "')");
    }
}

// -------------------- Low-level Module (MongoDB) --------------------
class MongoDBDatabase implements Database {

    @Override
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({ name: '" + data + "' })");
    }
}

// -------------------- High-level Module (Loosely Coupled) --------------------
class UserService {

    private Database database;

    // Dependency Injection
    public UserService(Database database) {
        this.database = database;
    }

    public void storeUser(String user) {
        database.save(user);
    }
}

// -------------------- Main --------------------
public class DIP_Followed {

    public static void main(String[] args) {

        Database mysqlDb = new MySQLDatabase();
        Database mongoDb = new MongoDBDatabase();

        UserService mysqlService = new UserService(mysqlDb);
        mysqlService.storeUser("Alice");

        UserService mongoService = new UserService(mongoDb);
        mongoService.storeUser("Bob");
    }
}
