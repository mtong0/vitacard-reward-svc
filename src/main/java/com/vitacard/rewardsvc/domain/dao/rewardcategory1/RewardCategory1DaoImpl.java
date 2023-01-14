package com.vitacard.rewardsvc.domain.dao.rewardcategory1;

import com.vitacard.rewardsvc.domain.entity.RewardCategory1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:db/sql/reward_category_1.xml")
public class RewardCategory1DaoImpl implements RewardCategory1Dao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private Environment environment;
    private final RewardCategory1RowMapper rewardCategory1RowMapper;

    public RewardCategory1DaoImpl() {
        rewardCategory1RowMapper = new RewardCategory1RowMapper();
    }

    @Override
    public RewardCategory1 addRewardCategory1(RewardCategory1 rewardCategory1) {
        String sql = environment.getProperty("addRewardCategory1");
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", rewardCategory1.getId())
                .addValue("category", rewardCategory1.getCategory())
                .addValue("description", rewardCategory1.getDescription());

        assert sql != null;
        jdbcTemplate.update(sql, parameterSource);
        return getRewardCategory1ById(rewardCategory1.getId());
    }

    @Override
    public RewardCategory1 getRewardCategory1ById(String id) {
        String sql = environment.getProperty("getRewardCategory1ById");

        assert sql != null;
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        return jdbcTemplate.queryForObject(sql, parameterSource, rewardCategory1RowMapper);
    }

    @Autowired
    public List<RewardCategory1> getAllRewardCategory1s() {
        String sql = environment.getProperty("getAllRewardCategory1s");
        assert sql != null;
        return jdbcTemplate.query(sql, rewardCategory1RowMapper);
    }
}
