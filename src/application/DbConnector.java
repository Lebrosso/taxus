package application;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnector {

    private static Connection conn;
    public static DbConnector instance = null;
    private static BasicDataSource ds = new BasicDataSource();

    private DbConnector() {
    }


    public static DbConnector getInstance() throws SQLException {
        if (instance == null) {

            ds.setUrl("jdbc:postgresql://localhost:5432/tax_gis");
            ds.setUsername("postgres");
            ds.setPassword("admin");
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
            ds.setFastFailValidation(false);

            instance = new DbConnector();
            return instance;
        } else {
            return instance;
        }
    }

    public List<ResultDto> getCount(Date dateTo, Date dateFrom, String voivodeship, String county, int userId, Table table) throws SQLException {

        List<ResultDto> results = new ArrayList<>();
        conn = ds.getConnection();

        StringBuffer query = new StringBuffer();
        query.append(" SELECT count(*) from ");
        query.append(table);
        query.append(" where ");
        query.append(" ST_Intersects (geom,(select ST_Union(geom) from dzew_pol where  woj  = ? and powiat = ?))");
        query.append(" AND ");
        query.append(" datobs <= ? ");
        query.append(" AND ");
        query.append(" datobs >= ? ");
        query.append(" AND ");
        query.append(" user_id = ? ");

        PreparedStatement st = conn.prepareStatement(query.toString());

        try {
            st.setString(1, voivodeship);
            st.setString(2, county);
            st.setDate(3, dateTo);
            st.setDate(4, dateFrom);
            st.setInt(5, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ResultDto dto = new ResultDto();
                dto.setName(table.getDisplayName());
                dto.setObservation(rs.getString("count"));
                results.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        st.close();
        conn.close();
        return results;
    }

    public List<ResultDto> getCount(Date dateTo, Date dateFrom, String voivodeship, String county, Table table) throws SQLException {

        List<ResultDto> results = new ArrayList<>();
        conn = ds.getConnection();

        StringBuffer query = new StringBuffer();
        query.append(" SELECT count(*) from ");
        query.append(table);
        query.append(" where ");
        query.append(" ST_Intersects (geom,(select ST_Union(geom) from dzew_pol where  woj = ? and powiat = ?))");
        query.append(" AND ");
        query.append(" datobs <= ? ");
        query.append(" AND ");
        query.append(" datobs >= ? ");

        PreparedStatement st = conn.prepareStatement(query.toString());
        ResultDto dto = new ResultDto();

        try {
            st.setString(1, voivodeship);
            st.setString(2, county);
            st.setDate(3, dateTo);
            st.setDate(4, dateFrom);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                dto.setName(table.getDisplayName());
                dto.setObservation(rs.getString("count"));
                results.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

     /*   StringBuffer tableMonitoring = new StringBuffer();
        tableMonitoring.append(table);
        tableMonitoring.append("__m");

        StringBuffer queryMonitoring = new StringBuffer();
        queryMonitoring.append(" SELECT count(*) from ");
        queryMonitoring.append(tableMonitoring.toString());
        queryMonitoring.append(" where ");
        queryMonitoring.append(" ST_Intersects (geom,(select ST_Union(geom) from dzew_pol where  woj  = ? and powiat = ?))");
        queryMonitoring.append(" AND ");
        query.append(" datobs <= ? ");
        query.append(" AND ");
        query.append(" datobs >= ? ");

        try {
            st.setString(1, voivodeship);
            st.setString(2, county);
            st.setDate(3, dateTo);
            st.setDate(4, dateFrom);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                dto.setMonitoring(rs.getString("count"));
                results.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }   */

        st.close();
        conn.close();
        return results;
    }

}


