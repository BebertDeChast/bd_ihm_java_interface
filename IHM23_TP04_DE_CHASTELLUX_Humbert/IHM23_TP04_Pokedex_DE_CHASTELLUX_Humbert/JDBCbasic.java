import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCbasic {
	public static void main(String[] args) throws Exception {
		Class.forName( "org.hsqldb.jdbcDriver"  );

		String url = "jdbc:hsqldb:file:database"+File.separator+"basic;shutdown=true";
		String login = "sa";
		String password = "";
		try ( Connection connection = DriverManager.getConnection( url, login, password ) ) {

			String requete = "DROP TABLE citation IF EXISTS;";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
			requete = "CREATE TABLE citation ("
					+"annee int,"
					+"citation varchar(256),"
					+"auteur varchar(20),"
					+"PRIMARY KEY(citation))";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

			requete = "INSERT INTO citation (annee, citation, auteur) VALUES"
					+"(1947, 'la simplicite est la reussite absolue', 'Frederic Chopin'),"
					+"(1979, 'Le bonheur, tu sauras que c''est la simplicite', 'Jacques Brillant'),"
					+"(1986, 'La simplicite est la cle de la reussite','Andre Rochette')";
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}

			requete = "SELECT * FROM citation";
			try ( Statement statement = connection.createStatement() ) {
				try (ResultSet resultSet = statement.executeQuery( requete ) ) {
					while( resultSet.next() ) {
						int annee = resultSet.getInt( "annee" );
						String auteur = resultSet.getString( "auteur" );
						String citation = resultSet.getString( "citation" );
						System.out.println(String.format("%-5d %-20s %s", annee,auteur,citation));
					}
				}
			}
		}
	}
}
