import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null; // sql cümleciği
		ResultSet resultSet;

		try {
			connection = helper.getConnection();   // prepare statement --> cumle hazırla,durumu hazırla!
			String sql = "insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "Düzce 2");
			statement.setString(2, "TUR");
			statement.setString(3, "Turkey");
			statement.setInt(4, 70000);
			int result = statement.executeUpdate();
			System.out.println("Kayit eklendi");
			
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}

		
		
	
	}
	
	public static void selectDemo() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		java.sql.Statement statement = null; // sql cümleciği
		ResultSet resultSet;

		try {
			connection = helper.getConnection();
			statement = connection.createStatement();
			resultSet =   statement.executeQuery("select Code,Name,Continent,Region from country");
			ArrayList<Country> countries = new ArrayList<Country>();
			while(resultSet.next()) { // tek tek gezecek!
				countries.add(new Country(
						resultSet.getString("Code"),
						resultSet.getString("Name"),
						resultSet.getString("Continent"),
						resultSet.getString("Region")));
			}
			System.out.println("Size:"+countries.size());
			
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			connection.close();
		}
	}

}
