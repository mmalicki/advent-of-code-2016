package day4.model;

public class Room {
    private final String encryptedName;
    private final int id;
    private final String checksum;

    public String getEncryptedName() {
        return encryptedName;
    }

    public int getId() {
        return id;
    }

    public String getChecksum() {
        return checksum;
    }

    public Room(String encryptedName, int id, String checksum) {
        this.encryptedName = encryptedName;
        this.id = id;
        this.checksum = checksum;
    }
}
