package com.vitacard.rewardsvc.domain.dao.rewardprogram;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardProgramRowMapper implements RowMapper<RewardProgram> {
    @Override
    public RewardProgram mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RewardProgram()
                .setId(rs.getString("id"))
                .setCustomerId(rs.getLong("customer_id"))
                .setProgress(rs.getInt("progress"))
                .setDescription(rs.getString("description"))
                .setStatusCode(rs.getInt("status_code"));
    }
}
