// DIP VIOLATION:
// High-level module depends directly on low-level modules

// -------------------- Low-level Module (MySQL) --------------------
class MySQLDatabase {

    public void saveToSQL(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES ('" + data + "')");
    }
}

// -------------------- Low-level Module (MongoDB) --------------------
class MongoDBDatabase {

    public void saveToMongo(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({ name: '" + data + "' })");
    }
}

// -------------------- High-level Module (Tightly Coupled) --------------------
class UserService {

    // ❌ Direct dependency on concrete implementations
    private MySQLDatabase sqlDb = new MySQLDatabase();
    private MongoDBDatabase mongoDb = new MongoDBDatabase();

    public void storeUserToSQL(String user) {
        sqlDb.saveToSQL(user);
    }

    public void storeUserToMongo(String user) {
        mongoDb.saveToMongo(user);
    }
}

// -------------------- Main --------------------
public class DIP_Violated {

    public static void main(String[] args) {

        UserService service = new UserService();

        service.storeUserToSQL("Alice");
        service.storeUserToMongo("Bob");
    }
}
