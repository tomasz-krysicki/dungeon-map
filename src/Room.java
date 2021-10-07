import java.util.Objects;

public class Room {

    private String roomNo;
    private String n;
    private String e;
    private String s;
    private String w;

    public Room(String roomNo, String n, String e, String s, String w) {
        this.roomNo = roomNo;
        this.n = n;
        this.e = e;
        this.s = s;
        this.w = w;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getN() {
        return n;
    }

    public String getE() {
        return e;
    }

    public String getS() {
        return s;
    }

    public String getW() {
        return w;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public void setN(String n) {
        this.n = n;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setW(String w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "\nRoom {" +
                "room number='" + roomNo + '\'' +
                ", N='" + n + '\'' +
                ", E='" + e + '\'' +
                ", S='" + s + '\'' +
                ", W='" + w + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNo.equals(room.roomNo) && n.equals(room.n) && e.equals(room.e) && s.equals(room.s) && w.equals(room.w);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo, n, e, s, w);
    }
}
