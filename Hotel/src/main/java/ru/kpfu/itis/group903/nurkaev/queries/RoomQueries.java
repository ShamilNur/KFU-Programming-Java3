package ru.kpfu.itis.group903.nurkaev.queries;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

public class RoomQueries {

    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM room_hotel;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM room_hotel WHERE id = ?;";

    // language=SQL
    public static final String SQL_SELECT_BY_NAME = "SELECT * FROM room_hotel WHERE name = ?;";

    // вместо '?' должны подставить date_from
    // language=SQL
    public static final String SQL_SELECT_BY_AVAILABLE_FORM = "SELECT * FROM room_hotel WHERE date_to < ?;";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO room_hotel (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE room_hotel SET name = ?, photo = ?, date_from = ?, date_to = ?, rooms_number = ?, adults_number = ?, child_number = ?, price = ? WHERE id = ?;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM room_hotel WHERE id = ?;";
}
