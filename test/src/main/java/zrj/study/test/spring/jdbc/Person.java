package zrj.study.test.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/19
 */
//@Repository
public class Person {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init123(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert() {
        this.jdbcTemplate.execute("INSERT INTO test(name) VALUES ('jdbcTemplate')");
    }

    public List<Row> getList() {
        /**
         * 占位符除了能用? 还可以:xxxxx 然后后面再 Collections.singletonMap("xxx", arg);
         */

        return this.jdbcTemplate.query("SELECT * FROM test WHERE id > ?", new Object[]{1}, new RowMapper<Row>() {
            @Override
            public Row mapRow(ResultSet rs, int rowNum) throws SQLException {
                Row row = new Row();
                row.setId(rs.getString(1));// 从1开始
                row.setName(rs.getString(2));
                return row;
            }
        });
    }

    public static class Row{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
