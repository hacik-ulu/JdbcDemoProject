import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) throws SQLException {

		Delete();
	}
	
	public static void Delete() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null; // sql cümleciği
		ResultSet resultSet;

		try {
			connection = helper.getConnection();   // prepare statement --> cumle hazırla,durumu hazırla!
			String sql = "delete from city where id =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,4087);
			int result = statement.executeUpdate();
			System.out.println("Kayit silindi");
			
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
	}


