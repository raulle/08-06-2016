package it.polito.tdp.formula1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.formula1.model.Circuit;
import it.polito.tdp.formula1.model.Driver;
import it.polito.tdp.formula1.model.Race;
import it.polito.tdp.formula1.model.Season;


public class F1DAO {

	public List<Season> getAllSeasons() {
		
		String sql = "SELECT year, url FROM seasons ORDER BY -year" ;
		
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet rs = st.executeQuery() ;
			
			List<Season> list = new ArrayList<>() ;
			while(rs.next()) {
				list.add(new Season(Year.of(rs.getInt("year")), rs.getString("url"))) ;
			}
			
			conn.close();
			return list ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
		public List<Circuit> getCicuiti(int anno) {
			
			String sql = "select c.circuitId,c.circuitRef,c.name,c.location,c.country,c.lat,c.lng,c.alt,c.url from races r, circuits c where year=? and r.circuitId=c.circuitId order by r.circuitId" ;
			
			try {
				Connection conn = DBConnect.getConnection() ;

				PreparedStatement st = conn.prepareStatement(sql) ;
				
				st.setInt(1, anno);
				
				ResultSet rs = st.executeQuery() ;
				
				List<Circuit> list = new ArrayList<>() ;
				while(rs.next()) {
					Circuit c= new Circuit(rs.getInt("circuitId"),rs.getString("circuitRef"),rs.getString("name"),rs.getString("location"),rs.getString("country"),rs.getDouble("lat"),rs.getDouble("lng"),rs.getInt("alt"),rs.getString("url"));
					list.add(c);
				}
				
				conn.close();
				return list ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null ;
			}	
		}
			public Race getRace(int anno, int idCir) {
				
				String sql = "select * from races r where year=? and r.circuitId=?";
				try {
					Connection conn = DBConnect.getConnection() ;

					PreparedStatement st = conn.prepareStatement(sql) ;
					
					st.setInt(1, anno);
					st.setInt(2, idCir);
					
					ResultSet rs = st.executeQuery() ;
					
					Race r=null;
					while(rs.next()) {
						r= new Race(rs.getInt("raceId"),Year.of(rs.getInt("year")),rs.getInt("round"),rs.getInt("circuitId"),rs.getString("name"),rs.getDate("date").toLocalDate(),rs.getTime("time").toLocalTime(),rs.getString("url"));
					}
					
					conn.close();
					return r ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null ;
				}
			}
				
				public List<Driver> getPiloti(int idRace) {
					
					String sql = "select d.driverid, d.driverRef,d.number,d.code,d.forename,d.surname,d.dob,d.nationality,d.url from driverstandings ds, drivers d  where ds.raceId=? and ds.driverId=d.driverId  order by d.driverId";
					try {
						Connection conn = DBConnect.getConnection() ;

						PreparedStatement st = conn.prepareStatement(sql) ;
						
						st.setInt(1, idRace);
						
						ResultSet rs = st.executeQuery() ;
						
						List<Driver> piloti = new ArrayList<>();
						while(rs.next()) {
							Driver d= new Driver(rs.getInt("driverid"),rs.getString("driverref"),rs.getInt("number"),rs.getString("code"),rs.getString("forename"),rs.getString("surname"),rs.getDate("dob").toLocalDate(),rs.getString("nationality"),rs.getString("url"));
							piloti.add(d);
						}
						
						conn.close();
						return piloti ;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null ;
					}
		
		
}
	
	public static void main(String[] args) {
		F1DAO dao = new F1DAO() ;
		
//		List<Season> seasons = dao.getAllSeasons() ;
//		System.out.println(seasons);
//		
		List<Circuit> cir = dao.getCicuiti(2015) ;
		System.out.println(dao.getPiloti(948));
	}
	
}
