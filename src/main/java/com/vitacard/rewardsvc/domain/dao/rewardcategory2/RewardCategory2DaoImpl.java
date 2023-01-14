package com.vitacard.rewardsvc.domain.dao.rewardcategory2;

import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:db/sql/reward_category_2.xml")
public class RewardCategory2DaoImpl implements RewardCategory2Dao {
    @Autowired
    private Environment environment;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final RewardCategory2RowMapper rewardCategory2RowMapper;
    public RewardCategory2DaoImpl() {
        rewardCategory2RowMapper = new RewardCategory2RowMapper();
    }
    @Override
    public List<RewardCategory2> getRewardCategory2sByRewardCategory1Id(String rewardCategory1Id) {
        String sql = environment.getProperty("getRewardCategory2sByRewardCategory1Id");

        assert sql != null;
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("reward_category_1_id", rewardCategory1Id);

        return jdbcTemplate.query(sql, parameterSource, rewardCategory2RowMapper);
    }

    public List<RewardCategory2> getRewardCategory2sByRewardProgramId(String rewardProgramId) {
        String sql = environment.getProperty("getRewardCategory2ByRewardProgramId");
        assert sql != null;
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("reward_program_id", rewardProgramId);

        return jdbcTemplate.query(sql, parameterSource, rewardCategory2RowMapper);
    }

    @Override
    public RewardCategory2 getRewardCategory2ById(String id) {
        String sql = environment.getProperty("getRewardCategory2ById");
        assert  sql != null;
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(sql, parameterSource, rewardCategory2RowMapper);
    }
}
