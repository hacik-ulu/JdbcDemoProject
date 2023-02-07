import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class updateData {

	public static void main(String[] args) throws SQLException {

		UpdateData();
	}
	
	
	public static void UpdateData() throws SQLException{
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null; // sql cümleciği
		ResultSet resultSet;

		try {
			connection = helper.getConnection();   // prepare statement --> cumle hazırla,durumu hazırla!
			String sql = "update city set population=100000,district='Turkey' where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,4087);
			int result = statement.executeUpdate();
			System.out.println("Kayit guncellendi");
			
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}

}
