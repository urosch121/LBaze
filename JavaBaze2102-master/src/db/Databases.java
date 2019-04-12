package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Databases implements IStudentAccess
{
	Connection conn;
	
	public Databases () 
	{
		String connString = "jdbc:mysql://localhost:3306/studije?user=root&password=";
		try 
		{
			conn = DriverManager.getConnection(connString);
		} 
		catch (SQLException e) 
		{
			System.out.println("Neka greska sa bazom!");
		}
	}
	
	@Override
	public boolean addStudent(Student s) {
		try 
		{
			String datum = new SimpleDateFormat("yyyy-MM-dd").format(s.getDatumRodjenja());
			Statement statment = conn.createStatement();
			String query = "INSERT INTO studenti (Indeks, Upisan, Imes, Mesto, Datr, Ssmer) values ("
					+ s.getIndeks() + ", " + s.getUpisan() + ", " + "'" + s.getIme() + "'" + ", '" + s.getMesto() + "'" 
					+ ", '" + datum + "', " + s.getSmer() + ")";
			statment.executeUpdate(query);
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) 
	{
		try 
		{
			String query = "UPDATE studenti SET Imes = ?, Mesto = ? WHERE Indeks = ? AND Upisan = ?";
			
			PreparedStatement prepS = conn.prepareStatement(query);
			prepS.setString(1, s.getIme());
			prepS.setString(2, s.getMesto());
			prepS.setInt(3, s.getIndeks());
			prepS.setInt(4, s.getUpisan());
			
			prepS.executeUpdate();
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Student s) 
	{
		try 
		{
			String query = "DELETE FROM studenti WHERE Indeks = ? AND Upisan = ?";
			
			PreparedStatement prepS = conn.prepareStatement(query);
			prepS.setInt(1, s.getIndeks());
			prepS.setInt(2, s.getUpisan());
			
			prepS.executeUpdate();
			
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Student readStudent(int indeks, int godinaUpisa) {
		try 
		{
			Statement statment = conn.createStatement();
			String query = "SELECT * FROM studenti WHERE Indeks = " + indeks + " AND Upisan = " + godinaUpisa;
			
			ResultSet res = statment.executeQuery(query);
			
			if (res.next()) 
			{
			String imes = res.getString("Imes").trim();
			String mesto = res.getString("Mesto").trim();
			Date datum = res.getDate("Datr");
			int smer = res.getInt("Ssmer");
			
			Student s = new Student(indeks, godinaUpisa, imes, mesto, datum, smer);
			return s;
			}
			return null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Student> readStudents() 
	{
		ArrayList<Student> listaStudenta = new ArrayList<>();
		try 
		{
			Statement statment = conn.createStatement();
			String query = "SELECT * FROM studenti";
			
			ResultSet res = statment.executeQuery(query);
			while (res.next())
			{
				String imes = res.getString("Imes");
				int indeks = res.getInt("Indeks");
				int upisan = res.getInt("Upisan");
				String mesto = res.getString("Mesto");
				Date datum = res.getDate("Datr");
				int smer = res.getInt("Ssmer");
				
				listaStudenta.add(new Student(indeks, upisan, imes, mesto, datum, smer));
			}
			return listaStudenta;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
}
