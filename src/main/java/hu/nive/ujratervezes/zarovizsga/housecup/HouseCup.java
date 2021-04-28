package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {
    /*
    Az adatbázisban egyetlen tábla van house_points néven, az alábbi oszlopokkal:

    house_name varchar
    student_name varchar
    points_earned int

Egy hallgató többször is szerezhet pontot a tanév során a házának, ilyenkor az több rekordban lesz rögzítve. Például:
house_name 	student_name 	points_earned
Gryffindor 	Harry Potter 	50
Slytherin 	Draco Malfoy 	10
Slytherin 	Draco Malfoy 	20
Gryffindor 	Harry Potter 	-15
Hufflepuff 	Cedric Diggory 	25
Java alkalmazás

Hozd létre a HouseCup osztályt, ami konstruktor paraméterben megkapja az adatbázis eléréshez szükséges DataSource példányt.
 Az osztályban hozd létre az alábbi metódusokat:

    getPointsOfHouse(String houdse): adja vissza, hogy a paraméterként megadott ház mennyi pontot szerzett

28p
     */
    private DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String house) {
        //select points_earned from house_points where house_name= ?

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select points_earned from house_points where house_name= ?");
        ) {

            return countPoints(house, stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot select", sqle);
        }
    }

    private int countPoints(String house, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, house);

        try (ResultSet rs = stmt.executeQuery();
        ) {
            int sumPoints = 0;
            while (rs.next()) {
                int point = rs.getInt("points_earned");
                sumPoints += point;
            }

            return sumPoints;

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot find house", sqle);
        }
    }
}
