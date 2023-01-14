package com.vitacard.rewardsvc.domain.dao.rewardprogram;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import com.vitacard.rewardsvc.domain.dao.rewardcategory2.RewardCategory2Dao;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@PropertySource("classpath:db/sql/reward_program.xml")
public class RewardProgramDaoImpl implements RewardProgramDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private Environment environment;
    @Autowired
    private RewardCategory2Dao rewardCategory2Dao;
    private RewardProgramRowMapper rewardProgramRowMapper;

    public RewardProgramDaoImpl() {
        rewardProgramRowMapper = new RewardProgramRowMapper();
    }

    @Override
    public RewardProgram addRewardProgram(RewardProgram rewardProgram) {
        String sql = environment.getProperty("addRewardProgram");
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", rewardProgram.getId())
                .addValue("customer_id", rewardProgram.getCustomerId())
                .addValue("description", rewardProgram.getDescription())
                .addValue("progress", rewardProgram.getProgress())
                .addValue("status_code", rewardProgram.getStatusCode())
                .addValue("reward_category_1_id", rewardProgram.getRewardCategory1Id());

        assert sql != null;
        jdbcTemplate.update(sql, parameterSource);

        List<RewardCategory2> rewardCategory2s = rewardProgram.getRewardCategory2s();
        String subSql1 = environment.getProperty("addRewardCategory2");
        for (RewardCategory2 rewardCategory2: rewardCategory2s) {
            SqlParameterSource subParameterSource1 = new MapSqlParameterSource()
                    .addValue("id", UUID.randomUUID().toString())
                    .addValue("reward_program_id", rewardProgram.getId())
                    .addValue("reward_category_2_id", rewardCategory2.getId());
            assert subSql1 != null;
            jdbcTemplate.update(subSql1, subParameterSource1);
        }
        return getRewardProgramById(rewardProgram.getId());
    }

    @Override
    public RewardProgram getRewardProgramById(String id) {
        String sql = environment.getProperty("getRewardProgramById");

        assert sql != null;
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        RewardProgram rewardProgram = jdbcTemplate.queryForObject(sql, parameterSource, rewardProgramRowMapper);

        assert rewardProgram != null;
        List<RewardCategory2> rewardCategory2s = rewardCategory2Dao.getRewardCategory2sByRewardProgramId(rewardProgram.getId());
        rewardProgram.setRewardCategory2s(rewardCategory2s);

        return rewardProgram;
    }
}